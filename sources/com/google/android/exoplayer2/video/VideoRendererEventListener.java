package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public interface VideoRendererEventListener {
    default void onDroppedFrames(int count, long elapsedMs) {
    }

    default void onRenderedFirstFrame(Surface surface) {
    }

    default void onVideoDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
    }

    default void onVideoDisabled(DecoderCounters counters) {
    }

    default void onVideoEnabled(DecoderCounters counters) {
    }

    default void onVideoFrameProcessingOffset(long totalProcessingOffsetUs, int frameCount, Format format) {
    }

    default void onVideoInputFormatChanged(Format format) {
    }

    default void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
    }

    public static final class EventDispatcher {
        private final Handler handler;
        private final VideoRendererEventListener listener;

        public EventDispatcher(Handler handler, VideoRendererEventListener listener) {
            this.handler = listener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = listener;
        }

        public void enabled(final DecoderCounters decoderCounters) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$enabled$0(decoderCounters);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$enabled$0(final DecoderCounters decoderCounters) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoEnabled(decoderCounters);
        }

        public void decoderInitialized(final String decoderName, final long initializedTimestampMs, final long initializationDurationMs) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$decoderInitialized$1(decoderName, initializedTimestampMs, initializationDurationMs);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$decoderInitialized$1(final String decoderName, final long initializedTimestampMs, final long initializationDurationMs) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDecoderInitialized(decoderName, initializedTimestampMs, initializationDurationMs);
        }

        public void inputFormatChanged(final Format format) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$inputFormatChanged$2(format);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$inputFormatChanged$2(final Format format) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoInputFormatChanged(format);
        }

        public void droppedFrames(final int droppedFrameCount, final long elapsedMs) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$droppedFrames$3(droppedFrameCount, elapsedMs);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$droppedFrames$3(final int droppedFrameCount, final long elapsedMs) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onDroppedFrames(droppedFrameCount, elapsedMs);
        }

        public void reportVideoFrameProcessingOffset(final long totalProcessingOffsetUs, final int frameCount, final Format format) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$reportVideoFrameProcessingOffset$4(totalProcessingOffsetUs, frameCount, format);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$reportVideoFrameProcessingOffset$4(final long totalProcessingOffsetUs, final int frameCount, final Format format) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoFrameProcessingOffset(totalProcessingOffsetUs, frameCount, format);
        }

        public void videoSizeChanged(final int width, final int height, final int unappliedRotationDegrees, final float pixelWidthHeightRatio) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$videoSizeChanged$5(width, height, unappliedRotationDegrees, pixelWidthHeightRatio);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$videoSizeChanged$5(final int width, final int height, final int unappliedRotationDegrees, final float pixelWidthHeightRatio) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoSizeChanged(width, height, unappliedRotationDegrees, pixelWidthHeightRatio);
        }

        public void renderedFirstFrame(final Surface surface) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$renderedFirstFrame$6(surface);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$renderedFirstFrame$6(final Surface surface) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onRenderedFirstFrame(surface);
        }

        public void disabled(final DecoderCounters counters) {
            counters.ensureUpdated();
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$disabled$7(counters);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$disabled$7(final DecoderCounters counters) {
            counters.ensureUpdated();
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDisabled(counters);
        }
    }
}
