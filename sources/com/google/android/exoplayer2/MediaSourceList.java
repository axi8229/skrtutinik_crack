package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
class MediaSourceList {
    private boolean isPrepared;
    private final MediaSourceListInfoRefreshListener mediaSourceListInfoListener;
    private TransferListener mediaTransferListener;
    private ShuffleOrder shuffleOrder = new ShuffleOrder.DefaultShuffleOrder(0);
    private final Map<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod = new IdentityHashMap();
    private final Map<Object, MediaSourceHolder> mediaSourceByUid = new HashMap();
    private final List<MediaSourceHolder> mediaSourceHolders = new ArrayList();
    private final MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();
    private final HashMap<MediaSourceHolder, MediaSourceAndListener> childSources = new HashMap<>();
    private final Set<MediaSourceHolder> enabledMediaSourceHolders = new HashSet();

    public interface MediaSourceListInfoRefreshListener {
        void onPlaylistUpdateRequested();
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener listener) {
        this.mediaSourceListInfoListener = listener;
    }

    public final Timeline setMediaSources(List<MediaSourceHolder> holders, ShuffleOrder shuffleOrder) {
        removeMediaSourcesInternal(0, this.mediaSourceHolders.size());
        return addMediaSources(this.mediaSourceHolders.size(), holders, shuffleOrder);
    }

    public final Timeline addMediaSources(int index, List<MediaSourceHolder> holders, ShuffleOrder shuffleOrder) {
        if (!holders.isEmpty()) {
            this.shuffleOrder = shuffleOrder;
            for (int i = index; i < holders.size() + index; i++) {
                MediaSourceHolder mediaSourceHolder = holders.get(i - index);
                if (i > 0) {
                    MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i - 1);
                    mediaSourceHolder.reset(mediaSourceHolder2.firstWindowIndexInChild + mediaSourceHolder2.mediaSource.getTimeline().getWindowCount());
                } else {
                    mediaSourceHolder.reset(0);
                }
                correctOffsets(i, mediaSourceHolder.mediaSource.getTimeline().getWindowCount());
                this.mediaSourceHolders.add(i, mediaSourceHolder);
                this.mediaSourceByUid.put(mediaSourceHolder.uid, mediaSourceHolder);
                if (this.isPrepared) {
                    prepareChildSource(mediaSourceHolder);
                    if (this.mediaSourceByMediaPeriod.isEmpty()) {
                        this.enabledMediaSourceHolders.add(mediaSourceHolder);
                    } else {
                        disableChildSource(mediaSourceHolder);
                    }
                }
            }
        }
        return createTimeline();
    }

    public final Timeline removeMediaSourceRange(int fromIndex, int toIndex, ShuffleOrder shuffleOrder) {
        Assertions.checkArgument(fromIndex >= 0 && fromIndex <= toIndex && toIndex <= getSize());
        this.shuffleOrder = shuffleOrder;
        removeMediaSourcesInternal(fromIndex, toIndex);
        return createTimeline();
    }

    public Timeline moveMediaSourceRange(int fromIndex, int toIndex, int newFromIndex, ShuffleOrder shuffleOrder) {
        Assertions.checkArgument(fromIndex >= 0 && fromIndex <= toIndex && toIndex <= getSize() && newFromIndex >= 0);
        this.shuffleOrder = shuffleOrder;
        if (fromIndex == toIndex || fromIndex == newFromIndex) {
            return createTimeline();
        }
        int iMin = Math.min(fromIndex, newFromIndex);
        int iMax = Math.max(((toIndex - fromIndex) + newFromIndex) - 1, toIndex - 1);
        int windowCount = this.mediaSourceHolders.get(iMin).firstWindowIndexInChild;
        moveMediaSourceHolders(this.mediaSourceHolders, fromIndex, toIndex, newFromIndex);
        while (iMin <= iMax) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(iMin);
            mediaSourceHolder.firstWindowIndexInChild = windowCount;
            windowCount += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
            iMin++;
        }
        return createTimeline();
    }

    public final Timeline clear(ShuffleOrder shuffleOrder) {
        if (shuffleOrder == null) {
            shuffleOrder = this.shuffleOrder.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder;
        removeMediaSourcesInternal(0, getSize());
        return createTimeline();
    }

    public final boolean isPrepared() {
        return this.isPrepared;
    }

    public final int getSize() {
        return this.mediaSourceHolders.size();
    }

    public final void setAnalyticsCollector(Handler handler, AnalyticsCollector analyticsCollector) {
        this.eventDispatcher.addEventListener(handler, analyticsCollector, MediaSourceEventListener.class);
        this.eventDispatcher.addEventListener(handler, analyticsCollector, DrmSessionEventListener.class);
    }

    public final Timeline setShuffleOrder(ShuffleOrder shuffleOrder) {
        int size = getSize();
        if (shuffleOrder.getLength() != size) {
            shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, size);
        }
        this.shuffleOrder = shuffleOrder;
        return createTimeline();
    }

    public final void prepare(TransferListener mediaTransferListener) {
        Assertions.checkState(!this.isPrepared);
        this.mediaTransferListener = mediaTransferListener;
        for (int i = 0; i < this.mediaSourceHolders.size(); i++) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i);
            prepareChildSource(mediaSourceHolder);
            this.enabledMediaSourceHolders.add(mediaSourceHolder);
        }
        this.isPrepared = true;
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId id, Allocator allocator, long startPositionUs) {
        Object mediaSourceHolderUid = getMediaSourceHolderUid(id.periodUid);
        MediaSource.MediaPeriodId mediaPeriodIdCopyWithPeriodUid = id.copyWithPeriodUid(getChildPeriodUid(id.periodUid));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByUid.get(mediaSourceHolderUid));
        enableMediaSource(mediaSourceHolder);
        mediaSourceHolder.activeMediaPeriodIds.add(mediaPeriodIdCopyWithPeriodUid);
        MaskingMediaPeriod maskingMediaPeriodCreatePeriod = mediaSourceHolder.mediaSource.createPeriod(mediaPeriodIdCopyWithPeriodUid, allocator, startPositionUs);
        this.mediaSourceByMediaPeriod.put(maskingMediaPeriodCreatePeriod, mediaSourceHolder);
        disableUnusedMediaSources();
        return maskingMediaPeriodCreatePeriod;
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByMediaPeriod.remove(mediaPeriod));
        mediaSourceHolder.mediaSource.releasePeriod(mediaPeriod);
        mediaSourceHolder.activeMediaPeriodIds.remove(((MaskingMediaPeriod) mediaPeriod).id);
        if (!this.mediaSourceByMediaPeriod.isEmpty()) {
            disableUnusedMediaSources();
        }
        maybeReleaseChildSource(mediaSourceHolder);
    }

    public final void release() {
        for (MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
            mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
        }
        this.childSources.clear();
        this.enabledMediaSourceHolders.clear();
        this.isPrepared = false;
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
        Iterator<MediaSourceAndListener> it = this.childSources.values().iterator();
        while (it.hasNext()) {
            it.next().mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    public final Timeline createTimeline() {
        if (this.mediaSourceHolders.isEmpty()) {
            return Timeline.EMPTY;
        }
        int windowCount = 0;
        for (int i = 0; i < this.mediaSourceHolders.size(); i++) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i);
            mediaSourceHolder.firstWindowIndexInChild = windowCount;
            windowCount += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
        }
        return new PlaylistTimeline(this.mediaSourceHolders, this.shuffleOrder);
    }

    private void enableMediaSource(MediaSourceHolder mediaSourceHolder) {
        this.enabledMediaSourceHolders.add(mediaSourceHolder);
        MediaSourceAndListener mediaSourceAndListener = this.childSources.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.mediaSource.enable(mediaSourceAndListener.caller);
        }
    }

    private void disableUnusedMediaSources() {
        Iterator<MediaSourceHolder> it = this.enabledMediaSourceHolders.iterator();
        while (it.hasNext()) {
            MediaSourceHolder next = it.next();
            if (next.activeMediaPeriodIds.isEmpty()) {
                disableChildSource(next);
                it.remove();
            }
        }
    }

    private void disableChildSource(MediaSourceHolder holder) {
        MediaSourceAndListener mediaSourceAndListener = this.childSources.get(holder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
        }
    }

    private void removeMediaSourcesInternal(int fromIndex, int toIndex) {
        for (int i = toIndex - 1; i >= fromIndex; i--) {
            MediaSourceHolder mediaSourceHolderRemove = this.mediaSourceHolders.remove(i);
            this.mediaSourceByUid.remove(mediaSourceHolderRemove.uid);
            correctOffsets(i, -mediaSourceHolderRemove.mediaSource.getTimeline().getWindowCount());
            mediaSourceHolderRemove.isRemoved = true;
            if (this.isPrepared) {
                maybeReleaseChildSource(mediaSourceHolderRemove);
            }
        }
    }

    private void correctOffsets(int startIndex, int windowOffsetUpdate) {
        while (startIndex < this.mediaSourceHolders.size()) {
            this.mediaSourceHolders.get(startIndex).firstWindowIndexInChild += windowOffsetUpdate;
            startIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < mediaSourceHolder.activeMediaPeriodIds.size(); i++) {
            if (mediaSourceHolder.activeMediaPeriodIds.get(i).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(getPeriodUid(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getWindowIndexForChildWindowIndex(MediaSourceHolder mediaSourceHolder, int windowIndex) {
        return windowIndex + mediaSourceHolder.firstWindowIndexInChild;
    }

    private void prepareChildSource(MediaSourceHolder holder) {
        MaskingMediaSource maskingMediaSource = holder.mediaSource;
        MediaSource.MediaSourceCaller mediaSourceCaller = new MediaSource.MediaSourceCaller() { // from class: com.google.android.exoplayer2.MediaSourceList$$ExternalSyntheticLambda0
            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
                this.f$0.lambda$prepareChildSource$0(mediaSource, timeline);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(holder);
        this.childSources.put(holder, new MediaSourceAndListener(maskingMediaSource, mediaSourceCaller, forwardingEventListener));
        maskingMediaSource.addEventListener(Util.createHandler(), forwardingEventListener);
        maskingMediaSource.addDrmEventListener(Util.createHandler(), forwardingEventListener);
        maskingMediaSource.prepareSource(mediaSourceCaller, this.mediaTransferListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareChildSource$0(MediaSource source, Timeline timeline) {
        this.mediaSourceListInfoListener.onPlaylistUpdateRequested();
    }

    private void maybeReleaseChildSource(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.isRemoved && mediaSourceHolder.activeMediaPeriodIds.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.remove(mediaSourceHolder));
            mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
            mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
            this.enabledMediaSourceHolders.remove(mediaSourceHolder);
        }
    }

    private static Object getMediaSourceHolderUid(Object periodUid) {
        return AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(periodUid);
    }

    private static Object getChildPeriodUid(Object periodUid) {
        return AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(periodUid);
    }

    private static Object getPeriodUid(MediaSourceHolder holder, Object childPeriodUid) {
        return AbstractConcatenatedTimeline.getConcatenatedUid(holder.uid, childPeriodUid);
    }

    static void moveMediaSourceHolders(List<MediaSourceHolder> mediaSourceHolders, int fromIndex, int toIndex, int newFromIndex) {
        int i = toIndex - fromIndex;
        MediaSourceHolder[] mediaSourceHolderArr = new MediaSourceHolder[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            mediaSourceHolderArr[i2] = mediaSourceHolders.remove(fromIndex + i2);
        }
        mediaSourceHolders.addAll(Math.min(newFromIndex, mediaSourceHolders.size()), Arrays.asList(mediaSourceHolderArr));
    }

    static final class MediaSourceHolder {
        public int firstWindowIndexInChild;
        public boolean isRemoved;
        public final MaskingMediaSource mediaSource;
        public final List<MediaSource.MediaPeriodId> activeMediaPeriodIds = new ArrayList();
        public final Object uid = new Object();

        public MediaSourceHolder(MediaSource mediaSource, boolean useLazyPreparation) {
            this.mediaSource = new MaskingMediaSource(mediaSource, useLazyPreparation);
        }

        public void reset(int firstWindowIndexInChild) {
            this.firstWindowIndexInChild = firstWindowIndexInChild;
            this.isRemoved = false;
            this.activeMediaPeriodIds.clear();
        }
    }

    static final class PlaylistTimeline extends AbstractConcatenatedTimeline {
        private final HashMap<Object, Integer> childIndexByUid;
        private final int[] firstPeriodInChildIndices;
        private final int[] firstWindowInChildIndices;
        private final int periodCount;
        private final Timeline[] timelines;
        private final Object[] uids;
        private final int windowCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlaylistTimeline(Collection<MediaSourceHolder> mediaSourceHolders, ShuffleOrder shuffleOrder) {
            super(false, shuffleOrder);
            int windowCount = 0;
            int size = mediaSourceHolders.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new Timeline[size];
            this.uids = new Object[size];
            this.childIndexByUid = new HashMap<>();
            int periodCount = 0;
            int i = 0;
            for (MediaSourceHolder mediaSourceHolder : mediaSourceHolders) {
                this.timelines[i] = mediaSourceHolder.mediaSource.getTimeline();
                this.firstWindowInChildIndices[i] = windowCount;
                this.firstPeriodInChildIndices[i] = periodCount;
                windowCount += this.timelines[i].getWindowCount();
                periodCount += this.timelines[i].getPeriodCount();
                Object[] objArr = this.uids;
                Object obj = mediaSourceHolder.uid;
                objArr[i] = obj;
                this.childIndexByUid.put(obj, Integer.valueOf(i));
                i++;
            }
            this.windowCount = windowCount;
            this.periodCount = periodCount;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        protected int getChildIndexByPeriodIndex(int periodIndex) {
            return Util.binarySearchFloor(this.firstPeriodInChildIndices, periodIndex + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        protected int getChildIndexByWindowIndex(int windowIndex) {
            return Util.binarySearchFloor(this.firstWindowInChildIndices, windowIndex + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        protected int getChildIndexByChildUid(Object childUid) {
            Integer num = this.childIndexByUid.get(childUid);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        protected Timeline getTimelineByChildIndex(int childIndex) {
            return this.timelines[childIndex];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        protected int getFirstPeriodIndexByChildIndex(int childIndex) {
            return this.firstPeriodInChildIndices[childIndex];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        protected int getFirstWindowIndexByChildIndex(int childIndex) {
            return this.firstWindowInChildIndices[childIndex];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        protected Object getChildUidByChildIndex(int childIndex) {
            return this.uids[childIndex];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.windowCount;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.periodCount;
        }
    }

    private static final class MediaSourceAndListener {
        public final MediaSource.MediaSourceCaller caller;
        public final MediaSourceEventListener eventListener;
        public final MediaSource mediaSource;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller caller, MediaSourceEventListener eventListener) {
            this.mediaSource = mediaSource;
            this.caller = caller;
            this.eventListener = eventListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {
        private MediaSourceEventListener.EventDispatcher eventDispatcher;
        private final MediaSourceHolder id;

        public ForwardingEventListener(MediaSourceHolder id) {
            this.eventDispatcher = MediaSourceList.this.eventDispatcher;
            this.id = id;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onMediaPeriodCreated(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.mediaPeriodCreated();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onMediaPeriodReleased(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.mediaPeriodReleased();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventData, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.loadStarted(loadEventData, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventData, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.loadCompleted(loadEventData, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCanceled(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventData, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.loadCanceled(loadEventData, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventData, MediaLoadData mediaLoadData, IOException error, boolean wasCanceled) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.loadError(loadEventData, mediaLoadData, error, wasCanceled);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onReadingStarted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.readingStarted();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onUpstreamDiscarded(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.upstreamDiscarded(mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.downstreamFormatChanged(mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionAcquired() {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda1
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmSessionAcquired();
                }
            }, DrmSessionEventListener.class);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysLoaded() {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda4
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmKeysLoaded();
                }
            }, DrmSessionEventListener.class);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionManagerError(final Exception error) {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda0
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmSessionManagerError(error);
                }
            }, DrmSessionEventListener.class);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRestored() {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda3
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmKeysRestored();
                }
            }, DrmSessionEventListener.class);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionReleased() {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda2
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmSessionReleased();
                }
            }, DrmSessionEventListener.class);
        }

        private boolean maybeUpdateEventDispatcher(int childWindowIndex, MediaSource.MediaPeriodId childMediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodIdForChildMediaPeriodId;
            if (childMediaPeriodId != null) {
                mediaPeriodIdForChildMediaPeriodId = MediaSourceList.getMediaPeriodIdForChildMediaPeriodId(this.id, childMediaPeriodId);
                if (mediaPeriodIdForChildMediaPeriodId == null) {
                    return false;
                }
            } else {
                mediaPeriodIdForChildMediaPeriodId = null;
            }
            int windowIndexForChildWindowIndex = MediaSourceList.getWindowIndexForChildWindowIndex(this.id, childWindowIndex);
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.eventDispatcher;
            if (eventDispatcher.windowIndex == windowIndexForChildWindowIndex && Util.areEqual(eventDispatcher.mediaPeriodId, mediaPeriodIdForChildMediaPeriodId)) {
                return true;
            }
            this.eventDispatcher = MediaSourceList.this.eventDispatcher.withParameters(windowIndexForChildWindowIndex, mediaPeriodIdForChildMediaPeriodId, 0L);
            return true;
        }
    }
}
