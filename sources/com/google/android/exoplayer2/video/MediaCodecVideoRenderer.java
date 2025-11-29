package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.gms.common.Scopes;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.pjsip.pjsua2.pjsip_status_code;

/* loaded from: classes2.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, pjsip_status_code.PJSIP_SC_TEMPORARILY_UNAVAILABLE};
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private MediaFormat currentMediaFormat;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;

    private static boolean isBufferLate(long earlyUs) {
        return earlyUs < -30000;
    }

    private static boolean isBufferVeryLate(long earlyUs) {
        return earlyUs < -500000;
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long allowedJoiningTimeMs, boolean enableDecoderFallback, Handler eventHandler, VideoRendererEventListener eventListener, int maxDroppedFramesToNotify) {
        super(2, mediaCodecSelector, enableDecoderFallback, 30.0f);
        this.allowedJoiningTimeMs = allowedJoiningTimeMs;
        this.maxDroppedFramesToNotify = maxDroppedFramesToNotify;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(applicationContext);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(eventHandler, eventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return RendererCapabilities.create(0);
        }
        boolean z = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, z, false);
        if (z && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.create(1);
        }
        if (!MediaCodecRenderer.supportsFormatDrm(format)) {
            return RendererCapabilities.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(format);
        int i2 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        if (zIsFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(mediaCodecSelector, format, z, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos2.get(0);
                if (mediaCodecInfo2.isFormatSupported(format) && mediaCodecInfo2.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return RendererCapabilities.create(zIsFormatSupported ? 4 : 3, i2, i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean requiresSecureDecoder) throws MediaCodecUtil.DecoderQueryException {
        return getDecoderInfos(mediaCodecSelector, format, requiresSecureDecoder, this.tunneling);
    }

    private static List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean requiresSecureDecoder, boolean requiresTunnelingDecoder) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> codecProfileAndLevel;
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, requiresSecureDecoder, requiresTunnelingDecoder), format);
        if ("video/dolby-vision".equals(str) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/hevc", requiresSecureDecoder, requiresTunnelingDecoder));
            } else if (iIntValue == 512) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/avc", requiresSecureDecoder, requiresTunnelingDecoder));
            }
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean joining, boolean mayRenderStartOfStream) throws ExoPlaybackException {
        super.onEnabled(joining, mayRenderStartOfStream);
        int i = this.tunnelingAudioSessionId;
        int i2 = getConfiguration().tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = i2;
        this.tunneling = i2 != 0;
        if (i2 != i) {
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
        this.mayRenderFirstFrameAfterEnableIfNotStarted = mayRenderStartOfStream;
        this.renderedFirstFrameAfterEnable = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long positionUs, boolean joining) throws ExoPlaybackException {
        super.onPositionReset(positionUs, joining);
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        if (joining) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.renderedFirstFrameAfterReset || (((surface = this.dummySurface) != null && this.surface == surface) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        }
        if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0L;
        this.videoFrameProcessingOffsetCount = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.currentMediaFormat = null;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onReset() {
        try {
            super.onReset();
            Surface surface = this.dummySurface;
            if (surface != null) {
                if (this.surface == surface) {
                    this.surface = null;
                }
                surface.release();
                this.dummySurface = null;
            }
        } catch (Throwable th) {
            if (this.dummySurface != null) {
                Surface surface2 = this.surface;
                Surface surface3 = this.dummySurface;
                if (surface2 == surface3) {
                    this.surface = null;
                }
                surface3.release();
                this.dummySurface = null;
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int messageType, Object message) throws ExoPlaybackException {
        if (messageType == 1) {
            setSurface((Surface) message);
            return;
        }
        if (messageType != 4) {
            if (messageType == 6) {
                this.frameMetadataListener = (VideoFrameMetadataListener) message;
                return;
            } else {
                super.handleMessage(messageType, message);
                return;
            }
        }
        this.scalingMode = ((Integer) message).intValue();
        MediaCodec codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    surface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    this.dummySurface = surface;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            MediaCodec codec = getCodec();
            if (codec != null) {
                if (Util.SDK_INT >= 23 && surface != null && !this.codecNeedsSetOutputSurfaceWorkaround) {
                    setOutputSurfaceV23(codec, surface);
                } else {
                    releaseCodec();
                    maybeInitCodec();
                }
            }
            if (surface != null && surface != this.dummySurface) {
                maybeRenotifyVideoSizeChanged();
                clearRenderedFirstFrame();
                if (state == 2) {
                    setJoiningDeadlineMs();
                    return;
                }
                return;
            }
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            return;
        }
        if (surface == null || surface == this.dummySurface) {
            return;
        }
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec(MediaCodecInfo codecInfo) {
        return this.surface != null || shouldUseDummySurface(codecInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodecInfo codecInfo, MediaCodec codec, Format format, MediaCrypto crypto, float codecOperatingRate) {
        String str = codecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(codecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, codecOperatingRate, this.deviceNeedsNoPostProcessWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            if (!shouldUseDummySurface(codecInfo)) {
                throw new IllegalStateException();
            }
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        codec.configure(mediaFormat, this.surface, crypto, 0);
        if (Util.SDK_INT < 23 || !this.tunneling) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int canKeepCodec(MediaCodec codec, MediaCodecInfo codecInfo, Format oldFormat, Format newFormat) {
        if (!codecInfo.isSeamlessAdaptationSupported(oldFormat, newFormat, true)) {
            return 0;
        }
        int i = newFormat.width;
        CodecMaxValues codecMaxValues = this.codecMaxValues;
        if (i > codecMaxValues.width || newFormat.height > codecMaxValues.height || getMaxInputSize(codecInfo, newFormat) > this.codecMaxValues.inputSize) {
            return 0;
        }
        return oldFormat.initializationDataEquals(newFormat) ? 3 : 2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRateV23(float operatingRate, Format format, Format[] streamFormats) {
        float fMax = -1.0f;
        for (Format format2 : streamFormats) {
            float f = format2.frameRate;
            if (f != -1.0f) {
                fMax = Math.max(fMax, f);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * operatingRate;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String name, long initializedTimestampMs, long initializationDurationMs) {
        this.eventDispatcher.decoderInitialized(name, initializedTimestampMs, initializationDurationMs);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(name);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException, MediaCryptoException {
        super.onInputFormatChanged(formatHolder);
        Format format = formatHolder.format;
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        this.pendingRotationDegrees = format.rotationDegrees;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(DecoderInputBuffer buffer) {
        boolean z = this.tunneling;
        if (!z) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT >= 23 || !z) {
            return;
        }
        onProcessedTunneledBuffer(buffer.timeUs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputMediaFormatChanged(MediaCodec codec, MediaFormat outputMediaFormat) {
        int integer;
        int integer2;
        this.currentMediaFormat = outputMediaFormat;
        boolean z = outputMediaFormat.containsKey("crop-right") && outputMediaFormat.containsKey("crop-left") && outputMediaFormat.containsKey("crop-bottom") && outputMediaFormat.containsKey("crop-top");
        if (z) {
            integer = (outputMediaFormat.getInteger("crop-right") - outputMediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = outputMediaFormat.getInteger("width");
        }
        if (z) {
            integer2 = (outputMediaFormat.getInteger("crop-bottom") - outputMediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = outputMediaFormat.getInteger("height");
        }
        processOutputFormat(codec, integer, integer2);
        maybeNotifyVideoFrameProcessingOffset();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    protected void handleInputBufferSupplementalData(DecoderInputBuffer buffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(buffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    setHdr10PlusInfoV29(getCodec(), bArr);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0092  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean processOutputBuffer(long r28, long r30, android.media.MediaCodec r32, java.nio.ByteBuffer r33, int r34, int r35, int r36, long r37, boolean r39, boolean r40, com.google.android.exoplayer2.Format r41) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.processOutputBuffer(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, com.google.android.exoplayer2.Format):boolean");
    }

    private void processOutputFormat(MediaCodec codec, int width, int height) {
        this.currentWidth = width;
        this.currentHeight = height;
        float f = this.pendingPixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f;
        if (Util.SDK_INT >= 21) {
            int i = this.pendingRotationDegrees;
            if (i == 90 || i == 270) {
                this.currentWidth = height;
                this.currentHeight = width;
                this.currentPixelWidthHeightRatio = 1.0f / f;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        codec.setVideoScalingMode(this.scalingMode);
    }

    private void notifyFrameMetadataListener(long presentationTimeUs, long releaseTimeNs, Format format, MediaFormat mediaFormat) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(presentationTimeUs, releaseTimeNs, format, mediaFormat);
        }
    }

    protected void onProcessedTunneledBuffer(long presentationTimeUs) {
        Format formatUpdateOutputFormatForTime = updateOutputFormatForTime(presentationTimeUs);
        if (formatUpdateOutputFormatForTime != null) {
            processOutputFormat(getCodec(), formatUpdateOutputFormatForTime.width, formatUpdateOutputFormatForTime.height);
        }
        maybeNotifyVideoSizeChanged();
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(presentationTimeUs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedOutputBuffer(long presentationTimeUs) {
        super.onProcessedOutputBuffer(presentationTimeUs);
        if (this.tunneling) {
            return;
        }
        this.buffersInCodecCount--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
    }

    protected boolean shouldDropOutputBuffer(long earlyUs, long elapsedRealtimeUs, boolean isLastBuffer) {
        return isBufferLate(earlyUs) && !isLastBuffer;
    }

    protected boolean shouldDropBuffersToKeyframe(long earlyUs, long elapsedRealtimeUs, boolean isLastBuffer) {
        return isBufferVeryLate(earlyUs) && !isLastBuffer;
    }

    protected boolean shouldForceRenderOutputBuffer(long earlyUs, long elapsedSinceLastRenderUs) {
        return isBufferLate(earlyUs) && elapsedSinceLastRenderUs > 100000;
    }

    protected void skipOutputBuffer(MediaCodec codec, int index, long presentationTimeUs) {
        TraceUtil.beginSection("skipVideoBuffer");
        codec.releaseOutputBuffer(index, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    protected void dropOutputBuffer(MediaCodec codec, int index, long presentationTimeUs) {
        TraceUtil.beginSection("dropVideoBuffer");
        codec.releaseOutputBuffer(index, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    protected boolean maybeDropBuffersToKeyframe(MediaCodec codec, int index, long presentationTimeUs, long positionUs, boolean treatDroppedBuffersAsSkipped) throws ExoPlaybackException {
        int iSkipSource = skipSource(positionUs);
        if (iSkipSource == 0) {
            return false;
        }
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedToKeyframeCount++;
        int i = this.buffersInCodecCount + iSkipSource;
        if (treatDroppedBuffersAsSkipped) {
            decoderCounters.skippedOutputBufferCount += i;
        } else {
            updateDroppedBufferCounters(i);
        }
        flushOrReinitializeCodec();
        return true;
    }

    protected void updateDroppedBufferCounters(int droppedBufferCount) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += droppedBufferCount;
        this.droppedFrames += droppedBufferCount;
        int i = this.consecutiveDroppedFrameCount + droppedBufferCount;
        this.consecutiveDroppedFrameCount = i;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i2 = this.maxDroppedFramesToNotify;
        if (i2 <= 0 || this.droppedFrames < i2) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    protected void renderOutputBuffer(MediaCodec codec, int index, long presentationTimeUs) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        codec.releaseOutputBuffer(index, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    protected void renderOutputBufferV21(MediaCodec codec, int index, long presentationTimeUs, long releaseTimeNs) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        codec.releaseOutputBuffer(index, releaseTimeNs);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUseDummySurface(MediaCodecInfo codecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(codecInfo.name) && (!codecInfo.secure || DummySurface.isSecureSupported(this.context));
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrameAfterReset = false;
        if (Util.SDK_INT < 23 || !this.tunneling || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
    }

    void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (this.renderedFirstFrameAfterReset) {
            return;
        }
        this.renderedFirstFrameAfterReset = true;
        this.eventDispatcher.renderedFirstFrame(this.surface);
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrameAfterReset) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private void maybeNotifyVideoSizeChanged() {
        int i = this.currentWidth;
        if (i == -1 && this.currentHeight == -1) {
            return;
        }
        if (this.reportedWidth == i && this.reportedHeight == this.currentHeight && this.reportedUnappliedRotationDegrees == this.currentUnappliedRotationDegrees && this.reportedPixelWidthHeightRatio == this.currentPixelWidthHeightRatio) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
        this.reportedWidth = this.currentWidth;
        this.reportedHeight = this.currentHeight;
        this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
        this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i = this.reportedWidth;
        if (i == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        Format currentOutputFormat = getCurrentOutputFormat();
        if (currentOutputFormat != null) {
            DecoderCounters decoderCounters = this.decoderCounters;
            long j = decoderCounters.totalVideoFrameProcessingOffsetUs - this.totalVideoFrameProcessingOffsetUs;
            int i = decoderCounters.videoFrameProcessingOffsetCount - this.videoFrameProcessingOffsetCount;
            if (i != 0) {
                this.eventDispatcher.reportVideoFrameProcessingOffset(j, i, currentOutputFormat);
                DecoderCounters decoderCounters2 = this.decoderCounters;
                this.totalVideoFrameProcessingOffsetUs = decoderCounters2.totalVideoFrameProcessingOffsetUs;
                this.videoFrameProcessingOffsetCount = decoderCounters2.videoFrameProcessingOffsetCount;
            }
        }
    }

    private static void setHdr10PlusInfoV29(MediaCodec codec, byte[] hdr10PlusInfo) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", hdr10PlusInfo);
        codec.setParameters(bundle);
    }

    private static void setOutputSurfaceV23(MediaCodec codec, Surface surface) {
        codec.setOutputSurface(surface);
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int tunnelingAudioSessionId) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", tunnelingAudioSessionId);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    protected MediaFormat getMediaFormat(Format format, String codecMimeType, CodecMaxValues codecMaxValues, float codecOperatingRate, boolean deviceNeedsNoPostProcessWorkaround, int tunnelingAudioSessionId) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", codecMimeType);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger(RemoteMessageConst.Notification.PRIORITY, 0);
            if (codecOperatingRate != -1.0f) {
                mediaFormat.setFloat("operating-rate", codecOperatingRate);
            }
        }
        if (deviceNeedsNoPostProcessWorkaround) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (tunnelingAudioSessionId != 0) {
            configureTunnelingV21(mediaFormat, tunnelingAudioSessionId);
        }
        return mediaFormat;
    }

    protected CodecMaxValues getCodecMaxValues(MediaCodecInfo codecInfo, Format format, Format[] streamFormats) {
        int codecMaxInputSize;
        int iMax = format.width;
        int iMax2 = format.height;
        int maxInputSize = getMaxInputSize(codecInfo, format);
        if (streamFormats.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(codecInfo, format.sampleMimeType, format.width, format.height)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * 1.5f), codecMaxInputSize);
            }
            return new CodecMaxValues(iMax, iMax2, maxInputSize);
        }
        boolean z = false;
        for (Format format2 : streamFormats) {
            if (codecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                int i = format2.width;
                z |= i == -1 || format2.height == -1;
                iMax = Math.max(iMax, i);
                iMax2 = Math.max(iMax2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(codecInfo, format2));
            }
        }
        if (z) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point codecMaxSize = getCodecMaxSize(codecInfo, format);
            if (codecMaxSize != null) {
                iMax = Math.max(iMax, codecMaxSize.x);
                iMax2 = Math.max(iMax2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(codecInfo, format.sampleMimeType, iMax, iMax2));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new CodecMaxValues(iMax, iMax2, maxInputSize);
    }

    private static Point getCodecMaxSize(MediaCodecInfo codecInfo, Format format) {
        int i = format.height;
        int i2 = format.width;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f = i / i3;
        for (int i4 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i5 = (int) (i4 * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                Point pointAlignVideoSizeV21 = codecInfo.alignVideoSizeV21(i6, i4);
                if (codecInfo.isVideoSizeAndRateSupportedV21(pointAlignVideoSizeV21.x, pointAlignVideoSizeV21.y, format.frameRate)) {
                    return pointAlignVideoSizeV21;
                }
            } else {
                try {
                    int iCeilDivide = Util.ceilDivide(i4, 16) * 16;
                    int iCeilDivide2 = Util.ceilDivide(i5, 16) * 16;
                    if (iCeilDivide * iCeilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i7 = z ? iCeilDivide2 : iCeilDivide;
                        if (!z) {
                            iCeilDivide = iCeilDivide2;
                        }
                        return new Point(i7, iCeilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(MediaCodecInfo codecInfo, Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int length = 0;
            for (int i = 0; i < size; i++) {
                length += format.initializationData.get(i).length;
            }
            return format.maxInputSize + length;
        }
        return getCodecMaxInputSize(codecInfo, format.sampleMimeType, format.width, format.height);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r5, java.lang.String r6, int r7, int r8) {
        /*
            r0 = 4
            r1 = 3
            r2 = 2
            r3 = -1
            if (r7 == r3) goto L9b
            if (r8 != r3) goto La
            goto L9b
        La:
            r6.hashCode()
            int r4 = r6.hashCode()
            switch(r4) {
                case -1664118616: goto L4d;
                case -1662541442: goto L42;
                case 1187890754: goto L37;
                case 1331836730: goto L2c;
                case 1599127256: goto L21;
                case 1599127257: goto L16;
                default: goto L14;
            }
        L14:
            r6 = r3
            goto L57
        L16:
            java.lang.String r4 = "video/x-vnd.on2.vp9"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L1f
            goto L14
        L1f:
            r6 = 5
            goto L57
        L21:
            java.lang.String r4 = "video/x-vnd.on2.vp8"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L2a
            goto L14
        L2a:
            r6 = r0
            goto L57
        L2c:
            java.lang.String r4 = "video/avc"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L35
            goto L14
        L35:
            r6 = r1
            goto L57
        L37:
            java.lang.String r4 = "video/mp4v-es"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L40
            goto L14
        L40:
            r6 = r2
            goto L57
        L42:
            java.lang.String r4 = "video/hevc"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L4b
            goto L14
        L4b:
            r6 = 1
            goto L57
        L4d:
            java.lang.String r4 = "video/3gpp"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L56
            goto L14
        L56:
            r6 = 0
        L57:
            switch(r6) {
                case 0: goto L5b;
                case 1: goto L96;
                case 2: goto L5b;
                case 3: goto L5e;
                case 4: goto L5b;
                case 5: goto L96;
                default: goto L5a;
            }
        L5a:
            return r3
        L5b:
            int r7 = r7 * r8
        L5c:
            r0 = r2
            goto L97
        L5e:
            java.lang.String r6 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r0 = "BRAVIA 4K 2015"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L95
            java.lang.String r0 = "Amazon"
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.MANUFACTURER
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L87
            java.lang.String r0 = "KFSOWI"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L95
            java.lang.String r0 = "AFTS"
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L87
            boolean r5 = r5.secure
            if (r5 == 0) goto L87
            goto L95
        L87:
            r5 = 16
            int r6 = com.google.android.exoplayer2.util.Util.ceilDivide(r7, r5)
            int r5 = com.google.android.exoplayer2.util.Util.ceilDivide(r8, r5)
            int r6 = r6 * r5
            int r7 = r6 * 256
            goto L5c
        L95:
            return r3
        L96:
            int r7 = r7 * r8
        L97:
            int r7 = r7 * r1
            int r0 = r0 * r2
            int r7 = r7 / r0
            return r7
        L9b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, java.lang.String, int, int):int");
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* JADX WARN: Removed duplicated region for block: B:402:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0656 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x065b A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:7:0x000d, B:9:0x0011, B:11:0x001c, B:428:0x065d, B:14:0x0023, B:16:0x0029, B:18:0x0031, B:21:0x0039, B:22:0x003f, B:403:0x061a, B:406:0x0620, B:427:0x065b, B:413:0x0636, B:416:0x0640, B:419:0x0649, B:405:0x061e, B:24:0x0044, B:27:0x0050, B:30:0x005c, B:33:0x0068, B:36:0x0072, B:39:0x007e, B:42:0x008a, B:45:0x0096, B:48:0x00a2, B:51:0x00ae, B:54:0x00ba, B:57:0x00c6, B:60:0x00d2, B:63:0x00de, B:66:0x00ea, B:69:0x00f6, B:72:0x0102, B:75:0x010e, B:78:0x011a, B:81:0x0126, B:84:0x0132, B:87:0x013e, B:90:0x014a, B:93:0x0156, B:96:0x0162, B:99:0x016e, B:102:0x017a, B:105:0x0186, B:108:0x0192, B:111:0x019e, B:114:0x01aa, B:117:0x01b6, B:120:0x01c2, B:123:0x01ce, B:126:0x01da, B:129:0x01e6, B:132:0x01f2, B:135:0x01fe, B:138:0x0209, B:141:0x0215, B:144:0x0221, B:147:0x022d, B:150:0x0239, B:153:0x0245, B:156:0x0251, B:159:0x025d, B:162:0x0269, B:165:0x0275, B:168:0x0281, B:171:0x028d, B:174:0x0299, B:177:0x02a5, B:180:0x02b1, B:183:0x02bd, B:186:0x02c9, B:189:0x02d4, B:192:0x02e0, B:195:0x02ec, B:198:0x02f8, B:201:0x0304, B:204:0x0310, B:207:0x031c, B:210:0x0328, B:213:0x0334, B:216:0x0340, B:219:0x034c, B:222:0x0357, B:225:0x0362, B:228:0x036d, B:231:0x0379, B:234:0x0385, B:237:0x0391, B:240:0x039d, B:243:0x03a9, B:246:0x03b5, B:249:0x03c1, B:252:0x03cd, B:255:0x03d9, B:258:0x03e5, B:261:0x03f1, B:264:0x03fd, B:267:0x0409, B:270:0x0415, B:273:0x0421, B:276:0x042d, B:279:0x0439, B:282:0x0445, B:285:0x0451, B:288:0x045d, B:291:0x0469, B:294:0x0475, B:297:0x0481, B:300:0x048d, B:303:0x0499, B:306:0x04a5, B:309:0x04b1, B:312:0x04bd, B:315:0x04c8, B:318:0x04d4, B:321:0x04e0, B:324:0x04ec, B:327:0x04f8, B:330:0x0503, B:333:0x050e, B:336:0x051a, B:339:0x0526, B:342:0x0532, B:345:0x053e, B:348:0x054a, B:351:0x0556, B:354:0x0562, B:357:0x056e, B:360:0x057a, B:363:0x0586, B:366:0x0592, B:369:0x059e, B:372:0x05aa, B:375:0x05b6, B:378:0x05c1, B:381:0x05cc, B:384:0x05d7, B:387:0x05e2, B:390:0x05ed, B:393:0x05f8, B:396:0x0603, B:399:0x060e, B:429:0x065f), top: B:434:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean codecNeedsSetOutputSurfaceWorkaround(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 2400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.codecNeedsSetOutputSurfaceWorkaround(java.lang.String):boolean");
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int width, int height, int inputSize) {
            this.width = width;
            this.height = height;
            this.inputSize = inputSize;
        }
    }

    private final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener, Handler.Callback {
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodec codec) {
            Handler handlerCreateHandler = Util.createHandler(this);
            this.handler = handlerCreateHandler;
            codec.setOnFrameRenderedListener(this, handlerCreateHandler);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec codec, long presentationTimeUs, long nanoTime) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (presentationTimeUs >> 32), (int) presentationTimeUs));
            } else {
                handleFrameRendered(presentationTimeUs);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long presentationTimeUs) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener) {
                return;
            }
            if (presentationTimeUs == Long.MAX_VALUE) {
                mediaCodecVideoRenderer.onProcessedTunneledEndOfStream();
            } else {
                mediaCodecVideoRenderer.onProcessedTunneledBuffer(presentationTimeUs);
            }
        }
    }
}
