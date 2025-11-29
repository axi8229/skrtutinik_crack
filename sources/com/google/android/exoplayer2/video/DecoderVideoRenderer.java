package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* loaded from: classes2.dex */
public abstract class DecoderVideoRenderer extends BaseRenderer {
    public static float DEFAULT_FRAME_RATE = 30.0f;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private float codecOperatingRate;
    private int consecutiveDroppedFrameCount;
    private Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder;
    protected DecoderCounters decoderCounters;
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final TimedValueQueue<Format> formatQueue;
    private VideoFrameMetadataListener frameMetadataListener;
    private long initialPositionUs;
    private VideoDecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private float operatingRate;
    private VideoDecoderOutputBuffer outputBuffer;
    private VideoDecoderOutputBufferRenderer outputBufferRenderer;
    private Format outputFormat;
    private int outputMode;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private int reportedHeight;
    private int reportedWidth;
    private DrmSession sourceDrmSession;
    private Surface surface;
    private boolean waitingForFirstSampleInFormat;
    private boolean waitingForKeys;

    private static boolean isBufferLate(long earlyUs) {
        return earlyUs < -30000;
    }

    private static boolean isBufferVeryLate(long earlyUs) {
        return earlyUs < -510000;
    }

    protected abstract Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> createDecoder(Format format, ExoMediaCrypto mediaCrypto) throws DecoderException;

    protected void onQueueInputBuffer(VideoDecoderInputBuffer buffer) {
    }

    protected abstract void renderOutputBufferToSurface(VideoDecoderOutputBuffer outputBuffer, Surface surface) throws DecoderException;

    protected abstract void setDecoderOutputMode(int outputMode);

    protected DecoderVideoRenderer(long allowedJoiningTimeMs, Handler eventHandler, VideoRendererEventListener eventListener, int maxDroppedFramesToNotify) {
        super(2);
        this.allowedJoiningTimeMs = allowedJoiningTimeMs;
        this.maxDroppedFramesToNotify = maxDroppedFramesToNotify;
        this.joiningDeadlineMs = -9223372036854775807L;
        clearReportedVideoSize();
        this.formatQueue = new TimedValueQueue<>();
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(eventHandler, eventListener);
        this.decoderReinitializationState = 0;
        this.outputMode = -1;
        this.operatingRate = 1.0f;
        this.codecOperatingRate = DEFAULT_FRAME_RATE * 1.0f;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long positionUs, long elapsedRealtimeUs) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            return;
        }
        if (this.inputFormat == null) {
            FormatHolder formatHolder = getFormatHolder();
            this.flagsOnlyBuffer.clear();
            int source = readSource(formatHolder, this.flagsOnlyBuffer, true);
            if (source != -5) {
                if (source == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                }
                return;
            }
            onInputFormatChanged(formatHolder);
        }
        maybeInitDecoder();
        if (this.decoder != null) {
            try {
                TraceUtil.beginSection("drainAndFeed");
                while (drainOutputBuffer(positionUs, elapsedRealtimeUs)) {
                }
                while (feedInputBuffer()) {
                }
                TraceUtil.endSection();
                this.decoderCounters.ensureUpdated();
            } catch (DecoderException e) {
                throw createRendererException(e, this.inputFormat);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setOperatingRate(float operatingRate) {
        this.operatingRate = operatingRate;
        this.codecOperatingRate = getCodecOperatingRate(operatingRate, this.inputFormat);
        Log.d(getClass().getName(), String.format(" operatingRate: %f  codecOperatingRate: %f \n", Float.valueOf(operatingRate), Float.valueOf(this.codecOperatingRate)));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    float getCodecOperatingRate(float r3, com.google.android.exoplayer2.Format r4) {
        /*
            r2 = this;
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r4 == 0) goto Lf
            float r4 = r4.frameRate
            int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r1 == 0) goto Lf
            float r4 = java.lang.Math.max(r0, r4)
            goto L10
        Lf:
            r4 = r0
        L10:
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto L16
            float r4 = com.google.android.exoplayer2.video.DecoderVideoRenderer.DEFAULT_FRAME_RATE
        L16:
            float r4 = r4 * r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.DecoderVideoRenderer.getCodecOperatingRate(float, com.google.android.exoplayer2.Format):float");
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.waitingForKeys) {
            return false;
        }
        if (this.inputFormat != null && ((isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrameAfterReset || !hasOutput()))) {
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

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int messageType, Object message) throws ExoPlaybackException {
        if (messageType == 1) {
            setOutputSurface((Surface) message);
            return;
        }
        if (messageType == 8) {
            setOutputBufferRenderer((VideoDecoderOutputBufferRenderer) message);
        } else if (messageType == 6) {
            this.frameMetadataListener = (VideoFrameMetadataListener) message;
        } else {
            super.handleMessage(messageType, message);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean joining, boolean mayRenderStartOfStream) throws ExoPlaybackException {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.decoderCounters = decoderCounters;
        this.eventDispatcher.enabled(decoderCounters);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = mayRenderStartOfStream;
        this.renderedFirstFrameAfterEnable = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long positionUs, boolean joining) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        if (this.decoder != null) {
            flushDecoder();
        }
        if (joining) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
        this.formatQueue.clear();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = C.msToUs(SystemClock.elapsedRealtime());
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.inputFormat = null;
        this.waitingForKeys = false;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        try {
            setSourceDrmSession(null);
            releaseDecoder();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(Format[] formats, long offsetUs) throws ExoPlaybackException {
        this.outputStreamOffsetUs = offsetUs;
        super.onStreamChanged(formats, offsetUs);
    }

    protected void onDecoderInitialized(String name, long initializedTimestampMs, long initializationDurationMs) {
        this.eventDispatcher.decoderInitialized(name, initializedTimestampMs, initializationDurationMs);
    }

    protected void flushDecoder() throws ExoPlaybackException {
        this.waitingForKeys = false;
        this.buffersInCodecCount = 0;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.outputBuffer;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    protected void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.buffersInCodecCount = 0;
        Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.decoder;
        if (decoder != null) {
            decoder.release();
            this.decoder = null;
            this.decoderCounters.decoderReleaseCount++;
        }
        setDecoderDrmSession(null);
    }

    protected void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        this.waitingForFirstSampleInFormat = true;
        setSourceDrmSession(formatHolder.drmSession);
        boolean zEquals = format.equals(this.inputFormat);
        this.inputFormat = format;
        if (this.sourceDrmSession != this.decoderDrmSession) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat);
        if (zEquals) {
            return;
        }
        setOperatingRate(this.operatingRate);
    }

    protected void onProcessedOutputBuffer(long presentationTimeUs) {
        this.buffersInCodecCount--;
    }

    protected boolean shouldDropOutputBuffer(long earlyUs, long elapsedRealtimeUs) {
        return isBufferLate(earlyUs);
    }

    protected boolean shouldDropBuffersToKeyframe(long earlyUs, long elapsedRealtimeUs) {
        return isBufferVeryLate(earlyUs);
    }

    protected boolean shouldForceRenderOutputBuffer(long earlyUs, long elapsedSinceLastRenderUs) {
        return isBufferLate(earlyUs) && elapsedSinceLastRenderUs > 300000;
    }

    protected void skipOutputBuffer(VideoDecoderOutputBuffer outputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        outputBuffer.release();
    }

    protected void dropOutputBuffer(VideoDecoderOutputBuffer outputBuffer) {
        updateDroppedBufferCounters(1);
        outputBuffer.release();
    }

    protected boolean maybeDropBuffersToKeyframe(long positionUs) throws ExoPlaybackException {
        int iSkipSource = skipSource(positionUs);
        if (iSkipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + iSkipSource);
        flushDecoder();
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

    protected void renderOutputBuffer(VideoDecoderOutputBuffer outputBuffer, long presentationTimeUs, Format outputFormat) throws DecoderException {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(presentationTimeUs, System.nanoTime(), outputFormat, null);
        }
        this.lastRenderTimeUs = C.msToUs(SystemClock.elapsedRealtime());
        int i = outputBuffer.mode;
        boolean z = i == 1 && this.surface != null;
        boolean z2 = i == 0 && this.outputBufferRenderer != null;
        if (!z2 && !z) {
            dropOutputBuffer(outputBuffer);
            return;
        }
        maybeNotifyVideoSizeChanged(outputBuffer.width, outputBuffer.height);
        if (z2) {
            this.outputBufferRenderer.setOutputBuffer(outputBuffer);
        } else {
            renderOutputBufferToSurface(outputBuffer, this.surface);
        }
        this.consecutiveDroppedFrameCount = 0;
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
    }

    protected final void setOutputSurface(Surface surface) {
        if (this.surface == surface) {
            if (surface != null) {
                onOutputReset();
                return;
            }
            return;
        }
        this.surface = surface;
        if (surface != null) {
            this.outputBufferRenderer = null;
            this.outputMode = 1;
            if (this.decoder != null) {
                setDecoderOutputMode(1);
            }
            onOutputChanged();
            return;
        }
        this.outputMode = -1;
        onOutputRemoved();
    }

    protected final void setOutputBufferRenderer(VideoDecoderOutputBufferRenderer outputBufferRenderer) {
        if (this.outputBufferRenderer == outputBufferRenderer) {
            if (outputBufferRenderer != null) {
                onOutputReset();
                return;
            }
            return;
        }
        this.outputBufferRenderer = outputBufferRenderer;
        if (outputBufferRenderer != null) {
            this.surface = null;
            this.outputMode = 0;
            if (this.decoder != null) {
                setDecoderOutputMode(0);
            }
            onOutputChanged();
            return;
        }
        this.outputMode = -1;
        onOutputRemoved();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onReset() {
        try {
            try {
                releaseDecoder();
                onOutputReset();
            } catch (Exception e) {
                Log.e(getClass().getName(), "onReset error", e);
            }
        } finally {
            setSourceDrmSession(null);
        }
    }

    private void setSourceDrmSession(DrmSession session) {
        DrmSession.replaceSession(this.sourceDrmSession, session);
        this.sourceDrmSession = session;
    }

    private void setDecoderDrmSession(DrmSession session) {
        DrmSession.replaceSession(this.decoderDrmSession, session);
        this.decoderDrmSession = session;
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        ExoMediaCrypto mediaCrypto;
        if (this.decoder != null) {
            return;
        }
        setDecoderDrmSession(this.sourceDrmSession);
        DrmSession drmSession = this.decoderDrmSession;
        if (drmSession != null) {
            mediaCrypto = drmSession.getMediaCrypto();
            if (mediaCrypto == null && this.decoderDrmSession.getError() == null) {
                return;
            }
        } else {
            mediaCrypto = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.decoder = createDecoder(this.inputFormat, mediaCrypto);
            setDecoderOutputMode(this.outputMode);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            onDecoderInitialized(this.decoder.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (DecoderException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    private boolean feedInputBuffer() throws Exception {
        Decoder<VideoDecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.decoder;
        if (decoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            VideoDecoderInputBuffer videoDecoderInputBufferDequeueInputBuffer = decoder.dequeueInputBuffer();
            this.inputBuffer = videoDecoderInputBufferDequeueInputBuffer;
            if (videoDecoderInputBufferDequeueInputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        int source = this.waitingForKeys ? -4 : readSource(formatHolder, this.inputBuffer, false);
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            return false;
        }
        boolean zShouldWaitForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
        this.waitingForKeys = zShouldWaitForKeys;
        if (zShouldWaitForKeys) {
            return false;
        }
        if (this.waitingForFirstSampleInFormat) {
            this.formatQueue.add(this.inputBuffer.timeUs, this.inputFormat);
            this.waitingForFirstSampleInFormat = false;
        }
        this.inputBuffer.flip();
        VideoDecoderInputBuffer videoDecoderInputBuffer = this.inputBuffer;
        videoDecoderInputBuffer.colorInfo = this.inputFormat.colorInfo;
        onQueueInputBuffer(videoDecoderInputBuffer);
        this.decoder.queueInputBuffer(this.inputBuffer);
        this.buffersInCodecCount++;
        this.decoderReceivedBuffers = true;
        this.decoderCounters.inputBufferCount++;
        this.inputBuffer = null;
        return true;
    }

    private boolean drainOutputBuffer(long positionUs, long elapsedRealtimeUs) throws Exception {
        if (this.outputBuffer == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBufferDequeueOutputBuffer = this.decoder.dequeueOutputBuffer();
            this.outputBuffer = videoDecoderOutputBufferDequeueOutputBuffer;
            if (videoDecoderOutputBufferDequeueOutputBuffer == null) {
                return false;
            }
            DecoderCounters decoderCounters = this.decoderCounters;
            int i = decoderCounters.skippedOutputBufferCount;
            int i2 = videoDecoderOutputBufferDequeueOutputBuffer.skippedOutputBufferCount;
            decoderCounters.skippedOutputBufferCount = i + i2;
            this.buffersInCodecCount -= i2;
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                this.outputStreamEnded = true;
            }
            return false;
        }
        this.decoder.setPlaybackParams(positionUs, this.codecOperatingRate);
        boolean zProcessOutputBuffer = processOutputBuffer(positionUs, elapsedRealtimeUs);
        if (zProcessOutputBuffer) {
            onProcessedOutputBuffer(this.outputBuffer.timeUs);
            this.outputBuffer = null;
        }
        return zProcessOutputBuffer;
    }

    private boolean processOutputBuffer(long positionUs, long elapsedRealtimeUs) throws ExoPlaybackException, DecoderException {
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = positionUs;
        }
        long j = this.outputBuffer.timeUs - positionUs;
        if (!hasOutput()) {
            if (!isBufferLate(j)) {
                return false;
            }
            skipOutputBuffer(this.outputBuffer);
            return true;
        }
        long j2 = this.outputBuffer.timeUs - this.outputStreamOffsetUs;
        Format formatPollFloor = this.formatQueue.pollFloor(j2);
        if (formatPollFloor != null) {
            this.outputFormat = formatPollFloor;
        }
        long jMsToUs = C.msToUs(SystemClock.elapsedRealtime()) - this.lastRenderTimeUs;
        boolean z = getState() == 2;
        if (this.renderedFirstFrameAfterEnable ? this.renderedFirstFrameAfterReset : !z && !this.mayRenderFirstFrameAfterEnableIfNotStarted) {
            if (!z || !shouldForceRenderOutputBuffer(j, jMsToUs)) {
                if (!z || positionUs == this.initialPositionUs || (shouldDropBuffersToKeyframe(j, elapsedRealtimeUs) && maybeDropBuffersToKeyframe(positionUs))) {
                    return false;
                }
                if (shouldDropOutputBuffer(j, elapsedRealtimeUs)) {
                    dropOutputBuffer(this.outputBuffer);
                    return true;
                }
                if (j < UtilsKt.UPDATE_INTERVAL) {
                    renderOutputBuffer(this.outputBuffer, j2, this.outputFormat);
                    return true;
                }
                return false;
            }
        }
        renderOutputBuffer(this.outputBuffer, j2, this.outputFormat);
        return true;
    }

    private boolean hasOutput() {
        return this.outputMode != -1;
    }

    private void onOutputChanged() {
        maybeRenotifyVideoSizeChanged();
        clearRenderedFirstFrame();
        if (getState() == 2) {
            setJoiningDeadlineMs();
        }
    }

    private void onOutputRemoved() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
    }

    private void onOutputReset() {
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    private boolean shouldWaitForKeys(boolean bufferEncrypted) throws ExoPlaybackException {
        DrmSession drmSession = this.decoderDrmSession;
        if (drmSession == null || (!bufferEncrypted && drmSession.playClearSamplesWithoutKeys())) {
            return false;
        }
        int state = drmSession.getState();
        if (state != 1) {
            return state != 4;
        }
        throw createRendererException(drmSession.getError(), this.inputFormat);
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrameAfterReset = false;
    }

    private void maybeNotifyRenderedFirstFrame() {
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
    }

    private void maybeNotifyVideoSizeChanged(int width, int height) {
        if (this.reportedWidth == width && this.reportedHeight == height) {
            return;
        }
        this.reportedWidth = width;
        this.reportedHeight = height;
        this.eventDispatcher.videoSizeChanged(width, height, 0, 1.0f);
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i = this.reportedWidth;
        if (i == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.reportedHeight, 0, 1.0f);
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }
}
