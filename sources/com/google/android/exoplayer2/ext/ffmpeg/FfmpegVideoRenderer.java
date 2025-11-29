package com.google.android.exoplayer2.ext.ffmpeg;

import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.DecoderVideoRenderer;
import com.google.android.exoplayer2.video.VideoDecoderInputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes2.dex */
public final class FfmpegVideoRenderer extends DecoderVideoRenderer {
    public static final /* synthetic */ int $r8$clinit = 0;
    private FfmpegVideoDecoder decoder;
    private long lastRenderTimeUs;
    private final int numInputBuffers;
    private final int numOutputBuffers;
    private final int threads;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    private static int getInputBufferSize(final int width, final int height) {
        int i = Resources.getSystem().getDisplayMetrics().widthPixels;
        int i2 = Resources.getSystem().getDisplayMetrics().heightPixels;
        int iMax = Math.max(Math.min(i, i2), 1080);
        int iMax2 = Math.max(Math.max(i, i2), 1920);
        if (width * height <= 0) {
            return ((Util.ceilDivide(iMax2, 64) * Util.ceilDivide(iMax, 64)) * 6144) / 2;
        }
        return ((Util.ceilDivide(Math.min(width, iMax2), 64) * Util.ceilDivide(Math.min(height, iMax), 64)) * 6144) / 2;
    }

    @Override // com.google.android.exoplayer2.video.DecoderVideoRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        this.lastRenderTimeUs = jElapsedRealtime;
        Log.d("FfmpegVideoRenderer", String.format("started lastRenderTimeUs %d", Long.valueOf(jElapsedRealtime)));
    }

    @Override // com.google.android.exoplayer2.video.DecoderVideoRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        super.onStopped();
        Log.d("FfmpegVideoRenderer", String.format("stopped lastRenderTimeUs %d", Long.valueOf(this.lastRenderTimeUs)));
    }

    public FfmpegVideoRenderer(long allowedJoiningTimeMs, Handler eventHandler, VideoRendererEventListener eventListener, int maxDroppedFramesToNotify) {
        this(allowedJoiningTimeMs, eventHandler, eventListener, maxDroppedFramesToNotify, Runtime.getRuntime().availableProcessors(), 8, 4);
    }

    public FfmpegVideoRenderer(long allowedJoiningTimeMs, Handler eventHandler, VideoRendererEventListener eventListener, int maxDroppedFramesToNotify, int threads, int numInputBuffers, int numOutputBuffers) {
        super(allowedJoiningTimeMs, eventHandler, eventListener, maxDroppedFramesToNotify);
        this.threads = threads;
        this.numInputBuffers = numInputBuffers;
        this.numOutputBuffers = numOutputBuffers;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "FfmpegVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) {
        boolean zIsVideo = MimeTypes.isVideo((String) Assertions.checkNotNull(format.sampleMimeType));
        if (!FfmpegLibrary.isAvailable() || !zIsVideo) {
            if (zIsVideo) {
                Log.e("FfmpegVideoRenderer", "FfmpegLibrary unavailable");
            }
            return 0;
        }
        if (!FfmpegLibrary.supportsFormat(format.sampleMimeType)) {
            return RendererCapabilities.create(1);
        }
        if (format.drmInitData != null && format.exoMediaCryptoType == null) {
            return RendererCapabilities.create(2);
        }
        return RendererCapabilities.create(format.width * format.height > 3939840 ? 3 : 4, 16, 0);
    }

    @Override // com.google.android.exoplayer2.video.DecoderVideoRenderer
    protected Decoder<VideoDecoderInputBuffer, VideoDecoderOutputBuffer, FfmpegDecoderException> createDecoder(Format format, ExoMediaCrypto mediaCrypto) throws FfmpegDecoderException {
        TraceUtil.beginSection("createFfmpegVideoDecoder");
        int inputBufferSize = format.maxInputSize;
        if (inputBufferSize == -1) {
            inputBufferSize = getInputBufferSize(format.width, format.height);
        }
        FfmpegVideoDecoder ffmpegVideoDecoder = new FfmpegVideoDecoder(this.numInputBuffers, this.numOutputBuffers, inputBufferSize, this.threads, format);
        this.decoder = ffmpegVideoDecoder;
        TraceUtil.endSection();
        return ffmpegVideoDecoder;
    }

    @Override // com.google.android.exoplayer2.video.DecoderVideoRenderer
    protected void renderOutputBufferToSurface(VideoDecoderOutputBuffer outputBuffer, Surface surface) throws FfmpegDecoderException {
        FfmpegVideoDecoder ffmpegVideoDecoder = this.decoder;
        if (ffmpegVideoDecoder == null) {
            throw new FfmpegDecoderException("Failed to render output buffer to surface: decoder is not initialized.");
        }
        ffmpegVideoDecoder.renderToSurface(outputBuffer, surface);
        outputBuffer.release();
    }

    @Override // com.google.android.exoplayer2.video.DecoderVideoRenderer
    protected void setDecoderOutputMode(int outputMode) {
        FfmpegVideoDecoder ffmpegVideoDecoder = this.decoder;
        if (ffmpegVideoDecoder != null) {
            ffmpegVideoDecoder.setOutputMode(outputMode);
        }
    }

    @Override // com.google.android.exoplayer2.video.DecoderVideoRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean joining, boolean mayRenderStartOfStream) throws ExoPlaybackException {
        super.onEnabled(joining, mayRenderStartOfStream);
        Log.d("FfmpegVideoRenderer", "enabled");
    }

    @Override // com.google.android.exoplayer2.video.DecoderVideoRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        super.onDisabled();
        Log.d("FfmpegVideoRenderer", "disabled");
    }
}
