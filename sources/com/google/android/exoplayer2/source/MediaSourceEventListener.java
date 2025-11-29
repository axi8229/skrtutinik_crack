package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface MediaSourceEventListener {
    default void onDownstreamFormatChanged(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    default void onLoadCanceled(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void onLoadCompleted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void onLoadError(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException error, boolean wasCanceled) {
    }

    default void onLoadStarted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void onMediaPeriodCreated(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    default void onMediaPeriodReleased(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    default void onReadingStarted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    default void onUpstreamDiscarded(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    @Deprecated
    public static final class EventDispatcher extends MediaSourceEventDispatcher {
        public EventDispatcher() {
        }

        private EventDispatcher(CopyOnWriteMultiset<MediaSourceEventDispatcher.ListenerInfo> listeners, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, long mediaTimeOffsetMs) {
            super(listeners, windowIndex, mediaPeriodId, mediaTimeOffsetMs);
        }

        public EventDispatcher withParameters(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, long mediaTimeOffsetMs) {
            return new EventDispatcher(this.listenerInfos, windowIndex, mediaPeriodId, mediaTimeOffsetMs);
        }

        public void addEventListener(Handler handler, MediaSourceEventListener eventListener) {
            addEventListener(handler, eventListener, MediaSourceEventListener.class);
        }

        public void removeEventListener(MediaSourceEventListener eventListener) {
            removeEventListener(eventListener, MediaSourceEventListener.class);
        }

        public void mediaPeriodCreated() {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    MediaSourceEventListener.EventDispatcher.lambda$mediaPeriodCreated$0((MediaSourceEventListener) obj, i, mediaPeriodId);
                }
            }, MediaSourceEventListener.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$mediaPeriodCreated$0(MediaSourceEventListener listener, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            listener.onMediaPeriodCreated(windowIndex, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId));
        }

        public void mediaPeriodReleased() {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda0
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    MediaSourceEventListener.EventDispatcher.lambda$mediaPeriodReleased$1((MediaSourceEventListener) obj, i, mediaPeriodId);
                }
            }, MediaSourceEventListener.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$mediaPeriodReleased$1(MediaSourceEventListener listener, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            listener.onMediaPeriodReleased(windowIndex, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId));
        }

        public void loadStarted(DataSpec dataSpec, int dataType, long elapsedRealtimeMs) {
            loadStarted(dataSpec, dataType, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, elapsedRealtimeMs);
        }

        public void loadStarted(DataSpec dataSpec, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeUs, long mediaEndTimeUs, long elapsedRealtimeMs) {
            loadStarted(new LoadEventInfo(dataSpec, dataSpec.uri, Collections.emptyMap(), elapsedRealtimeMs, 0L, 0L), new MediaLoadData(dataType, trackType, trackFormat, trackSelectionReason, trackSelectionData, adjustMediaTime(mediaStartTimeUs), adjustMediaTime(mediaEndTimeUs)));
        }

        public void loadStarted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda6
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onLoadStarted(i, mediaPeriodId, loadEventInfo, mediaLoadData);
                }
            }, MediaSourceEventListener.class);
        }

        public void loadCompleted(DataSpec dataSpec, Uri uri, Map<String, List<String>> responseHeaders, int dataType, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
            loadCompleted(dataSpec, uri, responseHeaders, dataType, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, elapsedRealtimeMs, loadDurationMs, bytesLoaded);
        }

        public void loadCompleted(DataSpec dataSpec, Uri uri, Map<String, List<String>> responseHeaders, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeUs, long mediaEndTimeUs, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
            loadCompleted(new LoadEventInfo(dataSpec, uri, responseHeaders, elapsedRealtimeMs, loadDurationMs, bytesLoaded), new MediaLoadData(dataType, trackType, trackFormat, trackSelectionReason, trackSelectionData, adjustMediaTime(mediaStartTimeUs), adjustMediaTime(mediaEndTimeUs)));
        }

        public void loadCompleted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onLoadCompleted(i, mediaPeriodId, loadEventInfo, mediaLoadData);
                }
            }, MediaSourceEventListener.class);
        }

        public void loadCanceled(DataSpec dataSpec, Uri uri, Map<String, List<String>> responseHeaders, int dataType, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
            loadCanceled(dataSpec, uri, responseHeaders, dataType, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, elapsedRealtimeMs, loadDurationMs, bytesLoaded);
        }

        public void loadCanceled(DataSpec dataSpec, Uri uri, Map<String, List<String>> responseHeaders, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeUs, long mediaEndTimeUs, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
            loadCanceled(new LoadEventInfo(dataSpec, uri, responseHeaders, elapsedRealtimeMs, loadDurationMs, bytesLoaded), new MediaLoadData(dataType, trackType, trackFormat, trackSelectionReason, trackSelectionData, adjustMediaTime(mediaStartTimeUs), adjustMediaTime(mediaEndTimeUs)));
        }

        public void loadCanceled(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda5
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onLoadCanceled(i, mediaPeriodId, loadEventInfo, mediaLoadData);
                }
            }, MediaSourceEventListener.class);
        }

        public void loadError(DataSpec dataSpec, Uri uri, Map<String, List<String>> responseHeaders, int dataType, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded, IOException error, boolean wasCanceled) {
            loadError(dataSpec, uri, responseHeaders, dataType, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, elapsedRealtimeMs, loadDurationMs, bytesLoaded, error, wasCanceled);
        }

        public void loadError(DataSpec dataSpec, Uri uri, Map<String, List<String>> responseHeaders, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeUs, long mediaEndTimeUs, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded, IOException error, boolean wasCanceled) {
            loadError(new LoadEventInfo(dataSpec, uri, responseHeaders, elapsedRealtimeMs, loadDurationMs, bytesLoaded), new MediaLoadData(dataType, trackType, trackFormat, trackSelectionReason, trackSelectionData, adjustMediaTime(mediaStartTimeUs), adjustMediaTime(mediaEndTimeUs)), error, wasCanceled);
        }

        public void loadError(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException error, final boolean wasCanceled) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda4
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onLoadError(i, mediaPeriodId, loadEventInfo, mediaLoadData, error, wasCanceled);
                }
            }, MediaSourceEventListener.class);
        }

        public void readingStarted() {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda1
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    MediaSourceEventListener.EventDispatcher.lambda$readingStarted$6((MediaSourceEventListener) obj, i, mediaPeriodId);
                }
            }, MediaSourceEventListener.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$readingStarted$6(MediaSourceEventListener listener, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            listener.onReadingStarted(windowIndex, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId));
        }

        public void upstreamDiscarded(int trackType, long mediaStartTimeUs, long mediaEndTimeUs) {
            upstreamDiscarded(new MediaLoadData(1, trackType, null, 3, null, adjustMediaTime(mediaStartTimeUs), adjustMediaTime(mediaEndTimeUs)));
        }

        public void upstreamDiscarded(final MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda7
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    MediaSourceEventListener.EventDispatcher.lambda$upstreamDiscarded$7(mediaLoadData, (MediaSourceEventListener) obj, i, mediaPeriodId);
                }
            }, MediaSourceEventListener.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$upstreamDiscarded$7(final MediaLoadData mediaLoadData, MediaSourceEventListener listener, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {
            listener.onUpstreamDiscarded(windowIndex, (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId), mediaLoadData);
        }

        public void downstreamFormatChanged(int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaTimeUs) {
            downstreamFormatChanged(new MediaLoadData(1, trackType, trackFormat, trackSelectionReason, trackSelectionData, adjustMediaTime(mediaTimeUs), -9223372036854775807L));
        }

        public void downstreamFormatChanged(final MediaLoadData mediaLoadData) {
            dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda8
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((MediaSourceEventListener) obj).onDownstreamFormatChanged(i, mediaPeriodId, mediaLoadData);
                }
            }, MediaSourceEventListener.class);
        }

        private long adjustMediaTime(long mediaTimeUs) {
            return MediaSourceEventDispatcher.adjustMediaTime(mediaTimeUs, this.mediaTimeOffsetMs);
        }
    }
}
