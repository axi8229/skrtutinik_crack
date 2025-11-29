package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class CompositeMediaSource<T> extends BaseMediaSource {
    private final HashMap<T, MediaSourceAndListener> childSources = new HashMap<>();
    private Handler eventHandler;
    private TransferListener mediaTransferListener;

    protected MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(T id, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    protected long getMediaTimeForChildMediaTime(T id, long mediaTimeMs) {
        return mediaTimeMs;
    }

    protected int getWindowIndexForChildWindowIndex(T id, int windowIndex) {
        return windowIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: onChildSourceInfoRefreshed, reason: merged with bridge method [inline-methods] */
    public abstract void lambda$prepareChildSource$0(T id, MediaSource mediaSource, Timeline timeline);

    protected boolean shouldDispatchCreateOrReleaseEvent(MediaSource.MediaPeriodId mediaPeriodId) {
        return true;
    }

    protected CompositeMediaSource() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener mediaTransferListener) {
        this.mediaTransferListener = mediaTransferListener;
        this.eventHandler = Util.createHandler();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Iterator<MediaSourceAndListener> it = this.childSources.values().iterator();
        while (it.hasNext()) {
            it.next().mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void enableInternal() {
        for (MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            mediaSourceAndListener.mediaSource.enable(mediaSourceAndListener.caller);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void disableInternal() {
        for (MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void releaseSourceInternal() {
        for (MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
            mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
        }
        this.childSources.clear();
    }

    protected final void prepareChildSource(final T id, MediaSource mediaSource) {
        Assertions.checkArgument(!this.childSources.containsKey(id));
        MediaSource.MediaSourceCaller mediaSourceCaller = new MediaSource.MediaSourceCaller() { // from class: com.google.android.exoplayer2.source.CompositeMediaSource$$ExternalSyntheticLambda0
            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline) {
                this.f$0.lambda$prepareChildSource$0(id, mediaSource2, timeline);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(id);
        this.childSources.put(id, new MediaSourceAndListener(mediaSource, mediaSourceCaller, forwardingEventListener));
        mediaSource.addEventListener((Handler) Assertions.checkNotNull(this.eventHandler), forwardingEventListener);
        mediaSource.addDrmEventListener((Handler) Assertions.checkNotNull(this.eventHandler), forwardingEventListener);
        mediaSource.prepareSource(mediaSourceCaller, this.mediaTransferListener);
        if (isEnabled()) {
            return;
        }
        mediaSource.disable(mediaSourceCaller);
    }

    protected final void enableChildSource(T id) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.get(id));
        mediaSourceAndListener.mediaSource.enable(mediaSourceAndListener.caller);
    }

    protected final void disableChildSource(T id) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.get(id));
        mediaSourceAndListener.mediaSource.disable(mediaSourceAndListener.caller);
    }

    protected final void releaseChildSource(T id) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.checkNotNull(this.childSources.remove(id));
        mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
        mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
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
        private final T id;

        public ForwardingEventListener(T id) {
            this.eventDispatcher = CompositeMediaSource.this.createEventDispatcher(null);
            this.id = id;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onMediaPeriodCreated(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId) && CompositeMediaSource.this.shouldDispatchCreateOrReleaseEvent((MediaSource.MediaPeriodId) Assertions.checkNotNull(this.eventDispatcher.mediaPeriodId))) {
                this.eventDispatcher.mediaPeriodCreated();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onMediaPeriodReleased(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId) && CompositeMediaSource.this.shouldDispatchCreateOrReleaseEvent((MediaSource.MediaPeriodId) Assertions.checkNotNull(this.eventDispatcher.mediaPeriodId))) {
                this.eventDispatcher.mediaPeriodReleased();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventData, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.loadStarted(loadEventData, maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventData, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.loadCompleted(loadEventData, maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCanceled(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventData, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.loadCanceled(loadEventData, maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventData, MediaLoadData mediaLoadData, IOException error, boolean wasCanceled) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.loadError(loadEventData, maybeUpdateMediaLoadData(mediaLoadData), error, wasCanceled);
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
                this.eventDispatcher.upstreamDiscarded(maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(windowIndex, mediaPeriodId)) {
                this.eventDispatcher.downstreamFormatChanged(maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionAcquired() {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.CompositeMediaSource$ForwardingEventListener$$ExternalSyntheticLambda3
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmSessionAcquired();
                }
            }, DrmSessionEventListener.class);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysLoaded() {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.CompositeMediaSource$ForwardingEventListener$$ExternalSyntheticLambda4
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmKeysLoaded();
                }
            }, DrmSessionEventListener.class);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionManagerError(final Exception error) {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.CompositeMediaSource$ForwardingEventListener$$ExternalSyntheticLambda0
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmSessionManagerError(error);
                }
            }, DrmSessionEventListener.class);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRestored() {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.CompositeMediaSource$ForwardingEventListener$$ExternalSyntheticLambda2
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmKeysRestored();
                }
            }, DrmSessionEventListener.class);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionReleased() {
            this.eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.CompositeMediaSource$ForwardingEventListener$$ExternalSyntheticLambda1
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmSessionReleased();
                }
            }, DrmSessionEventListener.class);
        }

        private boolean maybeUpdateEventDispatcher(int childWindowIndex, MediaSource.MediaPeriodId childMediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodIdForChildMediaPeriodId;
            if (childMediaPeriodId != null) {
                mediaPeriodIdForChildMediaPeriodId = CompositeMediaSource.this.getMediaPeriodIdForChildMediaPeriodId(this.id, childMediaPeriodId);
                if (mediaPeriodIdForChildMediaPeriodId == null) {
                    return false;
                }
            } else {
                mediaPeriodIdForChildMediaPeriodId = null;
            }
            int windowIndexForChildWindowIndex = CompositeMediaSource.this.getWindowIndexForChildWindowIndex(this.id, childWindowIndex);
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.eventDispatcher;
            if (eventDispatcher.windowIndex == windowIndexForChildWindowIndex && Util.areEqual(eventDispatcher.mediaPeriodId, mediaPeriodIdForChildMediaPeriodId)) {
                return true;
            }
            this.eventDispatcher = CompositeMediaSource.this.createEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodIdForChildMediaPeriodId, 0L);
            return true;
        }

        private MediaLoadData maybeUpdateMediaLoadData(MediaLoadData mediaLoadData) {
            long mediaTimeForChildMediaTime = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.id, mediaLoadData.mediaStartTimeMs);
            long mediaTimeForChildMediaTime2 = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.id, mediaLoadData.mediaEndTimeMs);
            return (mediaTimeForChildMediaTime == mediaLoadData.mediaStartTimeMs && mediaTimeForChildMediaTime2 == mediaLoadData.mediaEndTimeMs) ? mediaLoadData : new MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, mediaTimeForChildMediaTime, mediaTimeForChildMediaTime2);
        }
    }
}
