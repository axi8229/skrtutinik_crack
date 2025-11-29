package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> {
    private final Set<MediaSourceHolder> enabledMediaSourceHolders;
    private final boolean isAtomic;
    private final Map<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod;
    private final Map<Object, MediaSourceHolder> mediaSourceByUid;
    private final List<MediaSourceHolder> mediaSourceHolders;
    private final List<MediaSourceHolder> mediaSourcesPublic;
    private Set<HandlerAndRunnable> nextTimelineUpdateOnCompletionActions;
    private final Set<HandlerAndRunnable> pendingOnCompletionActions;
    private Handler playbackThreadHandler;
    private ShuffleOrder shuffleOrder;
    private boolean timelineUpdateScheduled;
    private final boolean useLazyPreparation;

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void enableInternal() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return null;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public boolean isSingleWindow() {
        return false;
    }

    public ConcatenatingMediaSource(MediaSource... mediaSources) {
        this(false, mediaSources);
    }

    public ConcatenatingMediaSource(boolean isAtomic, MediaSource... mediaSources) {
        this(isAtomic, new ShuffleOrder.DefaultShuffleOrder(0), mediaSources);
    }

    public ConcatenatingMediaSource(boolean isAtomic, ShuffleOrder shuffleOrder, MediaSource... mediaSources) {
        this(isAtomic, false, shuffleOrder, mediaSources);
    }

    public ConcatenatingMediaSource(boolean isAtomic, boolean useLazyPreparation, ShuffleOrder shuffleOrder, MediaSource... mediaSources) {
        for (MediaSource mediaSource : mediaSources) {
            Assertions.checkNotNull(mediaSource);
        }
        this.shuffleOrder = shuffleOrder.getLength() > 0 ? shuffleOrder.cloneAndClear() : shuffleOrder;
        this.mediaSourceByMediaPeriod = new IdentityHashMap();
        this.mediaSourceByUid = new HashMap();
        this.mediaSourcesPublic = new ArrayList();
        this.mediaSourceHolders = new ArrayList();
        this.nextTimelineUpdateOnCompletionActions = new HashSet();
        this.pendingOnCompletionActions = new HashSet();
        this.enabledMediaSourceHolders = new HashSet();
        this.isAtomic = isAtomic;
        this.useLazyPreparation = useLazyPreparation;
        addMediaSources(Arrays.asList(mediaSources));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public synchronized Timeline getInitialTimeline() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return new ConcatenatedTimeline(this.mediaSourcesPublic, this.shuffleOrder.getLength() != this.mediaSourcesPublic.size() ? this.shuffleOrder.cloneAndClear().cloneAndInsert(0, this.mediaSourcesPublic.size()) : this.shuffleOrder, this.isAtomic);
    }

    public synchronized void addMediaSource(MediaSource mediaSource) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource);
    }

    public synchronized void addMediaSource(int index, MediaSource mediaSource) {
        addPublicMediaSources(index, Collections.singletonList(mediaSource), null, null);
    }

    public synchronized void addMediaSources(Collection<MediaSource> mediaSources) {
        addPublicMediaSources(this.mediaSourcesPublic.size(), mediaSources, null, null);
    }

    public synchronized MediaSource removeMediaSource(int index) {
        MediaSource mediaSource;
        mediaSource = getMediaSource(index);
        removePublicMediaSources(index, index + 1, null, null);
        return mediaSource;
    }

    public synchronized int getSize() {
        return this.mediaSourcesPublic.size();
    }

    public synchronized MediaSource getMediaSource(int index) {
        return this.mediaSourcesPublic.get(index).mediaSource;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected synchronized void prepareSourceInternal(TransferListener mediaTransferListener) {
        try {
            super.prepareSourceInternal(mediaTransferListener);
            this.playbackThreadHandler = new Handler(new Handler.Callback() { // from class: com.google.android.exoplayer2.source.ConcatenatingMediaSource$$ExternalSyntheticLambda0
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return this.f$0.handleMessage(message);
                }
            });
            if (this.mediaSourcesPublic.isEmpty()) {
                updateTimelineAndScheduleOnCompletionActions();
            } else {
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
                addMediaSourcesInternal(0, this.mediaSourcesPublic);
                scheduleTimelineUpdate();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId id, Allocator allocator, long startPositionUs) {
        Object mediaSourceHolderUid = getMediaSourceHolderUid(id.periodUid);
        MediaSource.MediaPeriodId mediaPeriodIdCopyWithPeriodUid = id.copyWithPeriodUid(getChildPeriodUid(id.periodUid));
        MediaSourceHolder mediaSourceHolder = this.mediaSourceByUid.get(mediaSourceHolderUid);
        if (mediaSourceHolder == null) {
            mediaSourceHolder = new MediaSourceHolder(new DummyMediaSource(), this.useLazyPreparation);
            mediaSourceHolder.isRemoved = true;
            prepareChildSource(mediaSourceHolder, mediaSourceHolder.mediaSource);
        }
        enableMediaSource(mediaSourceHolder);
        mediaSourceHolder.activeMediaPeriodIds.add(mediaPeriodIdCopyWithPeriodUid);
        MaskingMediaPeriod maskingMediaPeriodCreatePeriod = mediaSourceHolder.mediaSource.createPeriod(mediaPeriodIdCopyWithPeriodUid, allocator, startPositionUs);
        this.mediaSourceByMediaPeriod.put(maskingMediaPeriodCreatePeriod, mediaSourceHolder);
        disableUnusedMediaSources();
        return maskingMediaPeriodCreatePeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByMediaPeriod.remove(mediaPeriod));
        mediaSourceHolder.mediaSource.releasePeriod(mediaPeriod);
        mediaSourceHolder.activeMediaPeriodIds.remove(((MaskingMediaPeriod) mediaPeriod).id);
        if (!this.mediaSourceByMediaPeriod.isEmpty()) {
            disableUnusedMediaSources();
        }
        maybeReleaseChildSource(mediaSourceHolder);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void disableInternal() {
        super.disableInternal();
        this.enabledMediaSourceHolders.clear();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected synchronized void releaseSourceInternal() {
        try {
            super.releaseSourceInternal();
            this.mediaSourceHolders.clear();
            this.enabledMediaSourceHolders.clear();
            this.mediaSourceByUid.clear();
            this.shuffleOrder = this.shuffleOrder.cloneAndClear();
            Handler handler = this.playbackThreadHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.playbackThreadHandler = null;
            }
            this.timelineUpdateScheduled = false;
            this.nextTimelineUpdateOnCompletionActions.clear();
            dispatchOnCompletionActions(this.pendingOnCompletionActions);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void lambda$prepareChildSource$0(MediaSourceHolder mediaSourceHolder, MediaSource mediaSource, Timeline timeline) {
        updateMediaSourceInternal(mediaSourceHolder, timeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < mediaSourceHolder.activeMediaPeriodIds.size(); i++) {
            if (mediaSourceHolder.activeMediaPeriodIds.get(i).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(getPeriodUid(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public int getWindowIndexForChildWindowIndex(MediaSourceHolder mediaSourceHolder, int windowIndex) {
        return windowIndex + mediaSourceHolder.firstWindowIndexInChild;
    }

    private void addPublicMediaSources(int index, Collection<MediaSource> mediaSources, Handler handler, Runnable onCompletionAction) {
        Assertions.checkArgument((handler == null) == (onCompletionAction == null));
        Handler handler2 = this.playbackThreadHandler;
        Iterator<MediaSource> it = mediaSources.iterator();
        while (it.hasNext()) {
            Assertions.checkNotNull(it.next());
        }
        ArrayList arrayList = new ArrayList(mediaSources.size());
        Iterator<MediaSource> it2 = mediaSources.iterator();
        while (it2.hasNext()) {
            arrayList.add(new MediaSourceHolder(it2.next(), this.useLazyPreparation));
        }
        this.mediaSourcesPublic.addAll(index, arrayList);
        if (handler2 != null && !mediaSources.isEmpty()) {
            handler2.obtainMessage(0, new MessageData(index, arrayList, createOnCompletionAction(handler, onCompletionAction))).sendToTarget();
        } else {
            if (onCompletionAction == null || handler == null) {
                return;
            }
            handler.post(onCompletionAction);
        }
    }

    private void removePublicMediaSources(int fromIndex, int toIndex, Handler handler, Runnable onCompletionAction) {
        Assertions.checkArgument((handler == null) == (onCompletionAction == null));
        Handler handler2 = this.playbackThreadHandler;
        Util.removeRange(this.mediaSourcesPublic, fromIndex, toIndex);
        if (handler2 != null) {
            handler2.obtainMessage(1, new MessageData(fromIndex, Integer.valueOf(toIndex), createOnCompletionAction(handler, onCompletionAction))).sendToTarget();
        } else {
            if (onCompletionAction == null || handler == null) {
                return;
            }
            handler.post(onCompletionAction);
        }
    }

    private HandlerAndRunnable createOnCompletionAction(Handler handler, Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        HandlerAndRunnable handlerAndRunnable = new HandlerAndRunnable(handler, runnable);
        this.pendingOnCompletionActions.add(handlerAndRunnable);
        return handlerAndRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean handleMessage(Message msg) {
        int i = msg.what;
        if (i == 0) {
            MessageData messageData = (MessageData) Util.castNonNull(msg.obj);
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData.index, ((Collection) messageData.customData).size());
            addMediaSourcesInternal(messageData.index, (Collection) messageData.customData);
            scheduleTimelineUpdate(messageData.onCompletionAction);
        } else if (i == 1) {
            MessageData messageData2 = (MessageData) Util.castNonNull(msg.obj);
            int i2 = messageData2.index;
            int iIntValue = ((Integer) messageData2.customData).intValue();
            if (i2 == 0 && iIntValue == this.shuffleOrder.getLength()) {
                this.shuffleOrder = this.shuffleOrder.cloneAndClear();
            } else {
                this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i2, iIntValue);
            }
            for (int i3 = iIntValue - 1; i3 >= i2; i3--) {
                removeMediaSourceInternal(i3);
            }
            scheduleTimelineUpdate(messageData2.onCompletionAction);
        } else if (i == 2) {
            MessageData messageData3 = (MessageData) Util.castNonNull(msg.obj);
            ShuffleOrder shuffleOrder = this.shuffleOrder;
            int i4 = messageData3.index;
            ShuffleOrder shuffleOrderCloneAndRemove = shuffleOrder.cloneAndRemove(i4, i4 + 1);
            this.shuffleOrder = shuffleOrderCloneAndRemove;
            this.shuffleOrder = shuffleOrderCloneAndRemove.cloneAndInsert(((Integer) messageData3.customData).intValue(), 1);
            moveMediaSourceInternal(messageData3.index, ((Integer) messageData3.customData).intValue());
            scheduleTimelineUpdate(messageData3.onCompletionAction);
        } else if (i == 3) {
            MessageData messageData4 = (MessageData) Util.castNonNull(msg.obj);
            this.shuffleOrder = (ShuffleOrder) messageData4.customData;
            scheduleTimelineUpdate(messageData4.onCompletionAction);
        } else if (i == 4) {
            updateTimelineAndScheduleOnCompletionActions();
        } else if (i == 5) {
            dispatchOnCompletionActions((Set) Util.castNonNull(msg.obj));
        } else {
            throw new IllegalStateException();
        }
        return true;
    }

    private void scheduleTimelineUpdate() {
        scheduleTimelineUpdate(null);
    }

    private void scheduleTimelineUpdate(HandlerAndRunnable onCompletionAction) {
        if (!this.timelineUpdateScheduled) {
            getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(4).sendToTarget();
            this.timelineUpdateScheduled = true;
        }
        if (onCompletionAction != null) {
            this.nextTimelineUpdateOnCompletionActions.add(onCompletionAction);
        }
    }

    private void updateTimelineAndScheduleOnCompletionActions() {
        this.timelineUpdateScheduled = false;
        Set<HandlerAndRunnable> set = this.nextTimelineUpdateOnCompletionActions;
        this.nextTimelineUpdateOnCompletionActions = new HashSet();
        refreshSourceInfo(new ConcatenatedTimeline(this.mediaSourceHolders, this.shuffleOrder, this.isAtomic));
        getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(5, set).sendToTarget();
    }

    private Handler getPlaybackThreadHandlerOnPlaybackThread() {
        return (Handler) Assertions.checkNotNull(this.playbackThreadHandler);
    }

    private synchronized void dispatchOnCompletionActions(Set<HandlerAndRunnable> onCompletionActions) {
        try {
            Iterator<HandlerAndRunnable> it = onCompletionActions.iterator();
            while (it.hasNext()) {
                it.next().dispatch();
            }
            this.pendingOnCompletionActions.removeAll(onCompletionActions);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void addMediaSourcesInternal(int index, Collection<MediaSourceHolder> mediaSourceHolders) {
        Iterator<MediaSourceHolder> it = mediaSourceHolders.iterator();
        while (it.hasNext()) {
            addMediaSourceInternal(index, it.next());
            index++;
        }
    }

    private void addMediaSourceInternal(int newIndex, MediaSourceHolder newMediaSourceHolder) {
        if (newIndex > 0) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(newIndex - 1);
            newMediaSourceHolder.reset(newIndex, mediaSourceHolder.firstWindowIndexInChild + mediaSourceHolder.mediaSource.getTimeline().getWindowCount());
        } else {
            newMediaSourceHolder.reset(newIndex, 0);
        }
        correctOffsets(newIndex, 1, newMediaSourceHolder.mediaSource.getTimeline().getWindowCount());
        this.mediaSourceHolders.add(newIndex, newMediaSourceHolder);
        this.mediaSourceByUid.put(newMediaSourceHolder.uid, newMediaSourceHolder);
        prepareChildSource(newMediaSourceHolder, newMediaSourceHolder.mediaSource);
        if (isEnabled() && this.mediaSourceByMediaPeriod.isEmpty()) {
            this.enabledMediaSourceHolders.add(newMediaSourceHolder);
        } else {
            disableChildSource(newMediaSourceHolder);
        }
    }

    private void updateMediaSourceInternal(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        if (mediaSourceHolder.childIndex + 1 < this.mediaSourceHolders.size()) {
            int windowCount = timeline.getWindowCount() - (this.mediaSourceHolders.get(mediaSourceHolder.childIndex + 1).firstWindowIndexInChild - mediaSourceHolder.firstWindowIndexInChild);
            if (windowCount != 0) {
                correctOffsets(mediaSourceHolder.childIndex + 1, 0, windowCount);
            }
        }
        scheduleTimelineUpdate();
    }

    private void removeMediaSourceInternal(int index) {
        MediaSourceHolder mediaSourceHolderRemove = this.mediaSourceHolders.remove(index);
        this.mediaSourceByUid.remove(mediaSourceHolderRemove.uid);
        correctOffsets(index, -1, -mediaSourceHolderRemove.mediaSource.getTimeline().getWindowCount());
        mediaSourceHolderRemove.isRemoved = true;
        maybeReleaseChildSource(mediaSourceHolderRemove);
    }

    private void moveMediaSourceInternal(int currentIndex, int newIndex) {
        int iMin = Math.min(currentIndex, newIndex);
        int iMax = Math.max(currentIndex, newIndex);
        int windowCount = this.mediaSourceHolders.get(iMin).firstWindowIndexInChild;
        List<MediaSourceHolder> list = this.mediaSourceHolders;
        list.add(newIndex, list.remove(currentIndex));
        while (iMin <= iMax) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(iMin);
            mediaSourceHolder.childIndex = iMin;
            mediaSourceHolder.firstWindowIndexInChild = windowCount;
            windowCount += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
            iMin++;
        }
    }

    private void correctOffsets(int startIndex, int childIndexUpdate, int windowOffsetUpdate) {
        while (startIndex < this.mediaSourceHolders.size()) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(startIndex);
            mediaSourceHolder.childIndex += childIndexUpdate;
            mediaSourceHolder.firstWindowIndexInChild += windowOffsetUpdate;
            startIndex++;
        }
    }

    private void maybeReleaseChildSource(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.isRemoved && mediaSourceHolder.activeMediaPeriodIds.isEmpty()) {
            this.enabledMediaSourceHolders.remove(mediaSourceHolder);
            releaseChildSource(mediaSourceHolder);
        }
    }

    private void enableMediaSource(MediaSourceHolder mediaSourceHolder) {
        this.enabledMediaSourceHolders.add(mediaSourceHolder);
        enableChildSource(mediaSourceHolder);
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

    private static Object getMediaSourceHolderUid(Object periodUid) {
        return AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(periodUid);
    }

    private static Object getChildPeriodUid(Object periodUid) {
        return AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(periodUid);
    }

    private static Object getPeriodUid(MediaSourceHolder holder, Object childPeriodUid) {
        return AbstractConcatenatedTimeline.getConcatenatedUid(holder.uid, childPeriodUid);
    }

    static final class MediaSourceHolder {
        public int childIndex;
        public int firstWindowIndexInChild;
        public boolean isRemoved;
        public final MaskingMediaSource mediaSource;
        public final List<MediaSource.MediaPeriodId> activeMediaPeriodIds = new ArrayList();
        public final Object uid = new Object();

        public MediaSourceHolder(MediaSource mediaSource, boolean useLazyPreparation) {
            this.mediaSource = new MaskingMediaSource(mediaSource, useLazyPreparation);
        }

        public void reset(int childIndex, int firstWindowIndexInChild) {
            this.childIndex = childIndex;
            this.firstWindowIndexInChild = firstWindowIndexInChild;
            this.isRemoved = false;
            this.activeMediaPeriodIds.clear();
        }
    }

    private static final class MessageData<T> {
        public final T customData;
        public final int index;
        public final HandlerAndRunnable onCompletionAction;

        public MessageData(int index, T customData, HandlerAndRunnable onCompletionAction) {
            this.index = index;
            this.customData = customData;
            this.onCompletionAction = onCompletionAction;
        }
    }

    private static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        private final HashMap<Object, Integer> childIndexByUid;
        private final int[] firstPeriodInChildIndices;
        private final int[] firstWindowInChildIndices;
        private final int periodCount;
        private final Timeline[] timelines;
        private final Object[] uids;
        private final int windowCount;

        public ConcatenatedTimeline(Collection<MediaSourceHolder> mediaSourceHolders, ShuffleOrder shuffleOrder, boolean isAtomic) {
            super(isAtomic, shuffleOrder);
            int size = mediaSourceHolders.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new Timeline[size];
            this.uids = new Object[size];
            this.childIndexByUid = new HashMap<>();
            int windowCount = 0;
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

    private static final class DummyMediaSource extends BaseMediaSource {
        @Override // com.google.android.exoplayer2.source.MediaSource
        public Object getTag() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void maybeThrowSourceInfoRefreshError() {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        protected void prepareSourceInternal(TransferListener mediaTransferListener) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void releasePeriod(MediaPeriod mediaPeriod) {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        protected void releaseSourceInternal() {
        }

        private DummyMediaSource() {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public MediaPeriod createPeriod(MediaSource.MediaPeriodId id, Allocator allocator, long startPositionUs) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class HandlerAndRunnable {
        private final Handler handler;
        private final Runnable runnable;

        public HandlerAndRunnable(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.runnable = runnable;
        }

        public void dispatch() {
            this.handler.post(this.runnable);
        }
    }
}
