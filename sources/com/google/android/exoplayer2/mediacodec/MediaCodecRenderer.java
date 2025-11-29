package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, ByteSourceJsonBootstrapper.UTF8_BOM_3, 28, 49, -61, 39, 93, 120};
    private final float assumedMinimumCodecOperatingRate;
    private ArrayDeque<MediaCodecInfo> availableCodecInfos;
    private final DecoderInputBuffer buffer;
    private MediaCodec codec;
    private int codecAdaptationWorkaroundMode;
    private MediaCodecAdapter codecAdapter;
    private int codecDrainAction;
    private int codecDrainState;
    private DrmSession codecDrmSession;
    private Format codecFormat;
    private boolean codecHasOutputMediaFormat;
    private long codecHotswapDeadlineMs;
    private MediaCodecInfo codecInfo;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagation;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecNeedsReconfigureWorkaround;
    private boolean codecNeedsSosFlushWorkaround;
    private float codecOperatingRate;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private final ArrayList<Long> decodeOnlyPresentationTimestamps;
    protected DecoderCounters decoderCounters;
    private final boolean enableDecoderFallback;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final TimedValueQueue<Format> formatQueue;
    private ByteBuffer[] inputBuffers;
    private Format inputFormat;
    private int inputIndex;
    private boolean inputStreamEnded;
    private boolean isDecodeOnlyOutputBuffer;
    private boolean isLastOutputBuffer;
    private long largestQueuedPresentationTimeUs;
    private long lastBufferInStreamPresentationTimeUs;
    private int mediaCodecOperationMode;
    private final MediaCodecSelector mediaCodecSelector;
    private MediaCrypto mediaCrypto;
    private boolean mediaCryptoRequiresSecureDecoder;
    private ByteBuffer outputBuffer;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private ByteBuffer[] outputBuffers;
    private Format outputFormat;
    private int outputIndex;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private boolean pendingOutputEndOfStream;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private DecoderInitializationException preferredDecoderInitializationException;
    private long renderTimeLimitMs;
    private float rendererOperatingRate;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private DrmSession sourceDrmSession;
    private boolean waitingForFirstSampleInFormat;
    private boolean waitingForFirstSyncSample;
    private boolean waitingForKeys;

    protected abstract int canKeepCodec(MediaCodec codec, MediaCodecInfo codecInfo, Format oldFormat, Format newFormat);

    protected abstract void configureCodec(MediaCodecInfo codecInfo, MediaCodec codec, Format format, MediaCrypto crypto, float codecOperatingRate);

    protected boolean getCodecNeedsEosPropagation() {
        return false;
    }

    protected abstract float getCodecOperatingRateV23(float operatingRate, Format format, Format[] streamFormats);

    protected abstract List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean requiresSecureDecoder) throws MediaCodecUtil.DecoderQueryException;

    protected void handleInputBufferSupplementalData(DecoderInputBuffer buffer) throws ExoPlaybackException {
    }

    protected abstract void onCodecInitialized(String name, long initializedTimestampMs, long initializationDurationMs);

    protected abstract void onOutputMediaFormatChanged(MediaCodec codec, MediaFormat outputMediaFormat) throws ExoPlaybackException;

    protected void onProcessedStreamChange() {
    }

    protected abstract void onQueueInputBuffer(DecoderInputBuffer buffer);

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
    }

    protected abstract boolean processOutputBuffer(long positionUs, long elapsedRealtimeUs, MediaCodec codec, ByteBuffer buffer, int bufferIndex, int bufferFlags, int sampleCount, long bufferPresentationTimeUs, boolean isDecodeOnlyBuffer, boolean isLastBuffer, Format format) throws ExoPlaybackException;

    protected void renderToEndOfStream() throws ExoPlaybackException {
    }

    protected boolean shouldInitCodec(MediaCodecInfo codecInfo) {
        return true;
    }

    protected abstract int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public static class DecoderInitializationException extends Exception {
        public final MediaCodecInfo codecInfo;
        public final String diagnosticInfo;
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable cause, boolean secureDecoderRequired, int errorCode) {
            this("Decoder init failed: [" + errorCode + "], " + format, cause, format.sampleMimeType, secureDecoderRequired, null, buildCustomDiagnosticInfo(errorCode), null);
        }

        public DecoderInitializationException(Format format, Throwable cause, boolean secureDecoderRequired, MediaCodecInfo mediaCodecInfo) {
            this("Decoder init failed: " + mediaCodecInfo.name + ", " + format, cause, format.sampleMimeType, secureDecoderRequired, mediaCodecInfo, Util.SDK_INT >= 21 ? getDiagnosticInfoV21(cause) : null, null);
        }

        private DecoderInitializationException(String message, Throwable cause, String mimeType, boolean secureDecoderRequired, MediaCodecInfo mediaCodecInfo, String diagnosticInfo, DecoderInitializationException fallbackDecoderInitializationException) {
            super(message, cause);
            this.mimeType = mimeType;
            this.secureDecoderRequired = secureDecoderRequired;
            this.codecInfo = mediaCodecInfo;
            this.diagnosticInfo = diagnosticInfo;
            this.fallbackDecoderInitializationException = fallbackDecoderInitializationException;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException fallbackException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, fallbackException);
        }

        private static String getDiagnosticInfoV21(Throwable cause) {
            if (cause instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) cause).getDiagnosticInfo();
            }
            return null;
        }

        private static String buildCustomDiagnosticInfo(int errorCode) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (errorCode < 0 ? "neg_" : "") + Math.abs(errorCode);
        }
    }

    public MediaCodecRenderer(int trackType, MediaCodecSelector mediaCodecSelector, boolean enableDecoderFallback, float assumedMinimumCodecOperatingRate) {
        super(trackType);
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector);
        this.enableDecoderFallback = enableDecoderFallback;
        this.assumedMinimumCodecOperatingRate = assumedMinimumCodecOperatingRate;
        this.buffer = new DecoderInputBuffer(0);
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.formatQueue = new TimedValueQueue<>();
        this.decodeOnlyPresentationTimestamps = new ArrayList<>();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.rendererOperatingRate = 1.0f;
        this.renderTimeLimitMs = -9223372036854775807L;
        this.mediaCodecOperationMode = 0;
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamOffsetUs = -9223372036854775807L;
        resetCodecStateForRelease();
    }

    public void experimental_setMediaCodecOperationMode(int mode) {
        this.mediaCodecOperationMode = mode;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) throws ExoPlaybackException {
        try {
            return supportsFormat(this.mediaCodecSelector, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw createRendererException(e, format);
        }
    }

    protected final void maybeInitCodec() throws ExoPlaybackException {
        if (this.codec != null || this.inputFormat == null) {
            return;
        }
        setCodecDrmSession(this.sourceDrmSession);
        String str = this.inputFormat.sampleMimeType;
        DrmSession drmSession = this.codecDrmSession;
        if (drmSession != null) {
            if (this.mediaCrypto == null) {
                FrameworkMediaCrypto frameworkMediaCrypto = getFrameworkMediaCrypto(drmSession);
                if (frameworkMediaCrypto == null) {
                    if (this.codecDrmSession.getError() == null) {
                        return;
                    }
                } else {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(frameworkMediaCrypto.uuid, frameworkMediaCrypto.sessionId);
                        this.mediaCrypto = mediaCrypto;
                        this.mediaCryptoRequiresSecureDecoder = !frameworkMediaCrypto.forceAllowInsecureDecoderComponents && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e) {
                        throw createRendererException(e, this.inputFormat);
                    }
                }
            }
            if (FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                int state = this.codecDrmSession.getState();
                if (state == 1) {
                    throw createRendererException(this.codecDrmSession.getError(), this.inputFormat);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            maybeInitCodecWithFallback(this.mediaCrypto, this.mediaCryptoRequiresSecureDecoder);
        } catch (DecoderInitializationException e2) {
            throw createRendererException(e2, this.inputFormat);
        }
    }

    protected final Format updateOutputFormatForTime(long presentationTimeUs) {
        Format formatPollFloor = this.formatQueue.pollFloor(presentationTimeUs);
        if (formatPollFloor != null) {
            this.outputFormat = formatPollFloor;
        }
        return formatPollFloor;
    }

    protected final Format getCurrentOutputFormat() {
        return this.outputFormat;
    }

    protected final MediaCodec getCodec() {
        return this.codec;
    }

    protected final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean joining, boolean mayRenderStartOfStream) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(Format[] formats, long offsetUs) throws ExoPlaybackException {
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            this.outputStreamOffsetUs = offsetUs;
            return;
        }
        int i = this.pendingOutputStreamOffsetCount;
        if (i == this.pendingOutputStreamOffsetsUs.length) {
            Log.w("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
        } else {
            this.pendingOutputStreamOffsetCount = i + 1;
        }
        long[] jArr = this.pendingOutputStreamOffsetsUs;
        int i2 = this.pendingOutputStreamOffsetCount;
        jArr[i2 - 1] = offsetUs;
        this.pendingOutputStreamSwitchTimesUs[i2 - 1] = this.largestQueuedPresentationTimeUs;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long positionUs, boolean joining) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.pendingOutputEndOfStream = false;
        flushOrReinitializeCodec();
        if (this.formatQueue.size() > 0) {
            this.waitingForFirstSampleInFormat = true;
        }
        this.formatQueue.clear();
        int i = this.pendingOutputStreamOffsetCount;
        if (i != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setOperatingRate(float operatingRate) throws ExoPlaybackException {
        this.rendererOperatingRate = operatingRate;
        if (this.codec == null || this.codecDrainAction == 3 || getState() == 0) {
            return;
        }
        updateCodecOperatingRate();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.inputFormat = null;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.pendingOutputStreamOffsetCount = 0;
        if (this.sourceDrmSession != null || this.codecDrmSession != null) {
            onReset();
        } else {
            flushOrReleaseCodec();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onReset() {
        try {
            releaseCodec();
        } finally {
            setSourceDrmSession(null);
        }
    }

    protected void releaseCodec() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.codecAdapter;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.shutdown();
            }
            MediaCodec mediaCodec = this.codec;
            if (mediaCodec != null) {
                this.decoderCounters.decoderReleaseCount++;
                mediaCodec.release();
            }
            this.codec = null;
            this.codecAdapter = null;
            try {
                MediaCrypto mediaCrypto = this.mediaCrypto;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.codec = null;
            this.codecAdapter = null;
            try {
                MediaCrypto mediaCrypto2 = this.mediaCrypto;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long positionUs, long elapsedRealtimeUs) throws ExoPlaybackException, MediaCryptoException {
        if (this.pendingOutputEndOfStream) {
            this.pendingOutputEndOfStream = false;
            processEndOfStream();
        }
        try {
            if (this.outputStreamEnded) {
                renderToEndOfStream();
                return;
            }
            if (this.inputFormat != null || readToFlagsOnlyBuffer(true)) {
                maybeInitCodec();
                if (this.codec != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    TraceUtil.beginSection("drainAndFeed");
                    while (drainOutputBuffer(positionUs, elapsedRealtimeUs) && shouldContinueRendering(jElapsedRealtime)) {
                    }
                    while (feedInputBuffer() && shouldContinueRendering(jElapsedRealtime)) {
                    }
                    TraceUtil.endSection();
                } else {
                    this.decoderCounters.skippedInputBufferCount += skipSource(positionUs);
                    readToFlagsOnlyBuffer(false);
                }
                this.decoderCounters.ensureUpdated();
            }
        } catch (IllegalStateException e) {
            if (isMediaCodecException(e)) {
                throw createRendererException(e, this.inputFormat);
            }
            throw e;
        }
    }

    protected final boolean flushOrReinitializeCodec() throws ExoPlaybackException {
        boolean zFlushOrReleaseCodec = flushOrReleaseCodec();
        if (zFlushOrReleaseCodec) {
            maybeInitCodec();
        }
        return zFlushOrReleaseCodec;
    }

    protected boolean flushOrReleaseCodec() {
        if (this.codec == null) {
            return false;
        }
        if (this.codecDrainAction == 3 || this.codecNeedsFlushWorkaround || ((this.codecNeedsSosFlushWorkaround && !this.codecHasOutputMediaFormat) || (this.codecNeedsEosFlushWorkaround && this.codecReceivedEos))) {
            releaseCodec();
            return true;
        }
        try {
            this.codecAdapter.flush();
            return false;
        } finally {
            resetCodecStateForFlush();
        }
    }

    protected void resetCodecStateForFlush() {
        resetInputBuffer();
        resetOutputBuffer();
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        this.codecReceivedEos = false;
        this.codecReceivedBuffers = false;
        this.waitingForFirstSyncSample = true;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.isDecodeOnlyOutputBuffer = false;
        this.isLastOutputBuffer = false;
        this.waitingForKeys = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        this.lastBufferInStreamPresentationTimeUs = -9223372036854775807L;
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
        this.codecReconfigurationState = this.codecReconfigured ? 1 : 0;
    }

    protected void resetCodecStateForRelease() {
        resetCodecStateForFlush();
        this.availableCodecInfos = null;
        this.codecInfo = null;
        this.codecFormat = null;
        this.codecHasOutputMediaFormat = false;
        this.codecOperatingRate = -1.0f;
        this.codecAdaptationWorkaroundMode = 0;
        this.codecNeedsReconfigureWorkaround = false;
        this.codecNeedsDiscardToSpsWorkaround = false;
        this.codecNeedsFlushWorkaround = false;
        this.codecNeedsSosFlushWorkaround = false;
        this.codecNeedsEosFlushWorkaround = false;
        this.codecNeedsEosOutputExceptionWorkaround = false;
        this.codecNeedsMonoChannelCountWorkaround = false;
        this.codecNeedsEosPropagation = false;
        this.codecReconfigured = false;
        this.codecReconfigurationState = 0;
        resetCodecBuffers();
        this.mediaCryptoRequiresSecureDecoder = false;
    }

    private boolean readToFlagsOnlyBuffer(boolean requireFormat) throws ExoPlaybackException, MediaCryptoException {
        FormatHolder formatHolder = getFormatHolder();
        this.flagsOnlyBuffer.clear();
        int source = readSource(formatHolder, this.flagsOnlyBuffer, requireFormat);
        if (source == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (source != -4 || !this.flagsOnlyBuffer.isEndOfStream()) {
            return false;
        }
        this.inputStreamEnded = true;
        processEndOfStream();
        return false;
    }

    private void maybeInitCodecWithFallback(MediaCrypto crypto, boolean mediaCryptoRequiresSecureDecoder) throws DecoderInitializationException {
        if (this.availableCodecInfos == null) {
            try {
                List<MediaCodecInfo> availableCodecInfos = getAvailableCodecInfos(mediaCryptoRequiresSecureDecoder);
                ArrayDeque<MediaCodecInfo> arrayDeque = new ArrayDeque<>();
                this.availableCodecInfos = arrayDeque;
                if (this.enableDecoderFallback) {
                    arrayDeque.addAll(availableCodecInfos);
                } else if (!availableCodecInfos.isEmpty()) {
                    this.availableCodecInfos.add(availableCodecInfos.get(0));
                }
                this.preferredDecoderInitializationException = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.inputFormat, e, mediaCryptoRequiresSecureDecoder, -49998);
            }
        }
        if (this.availableCodecInfos.isEmpty()) {
            throw new DecoderInitializationException(this.inputFormat, (Throwable) null, mediaCryptoRequiresSecureDecoder, -49999);
        }
        while (this.codec == null) {
            MediaCodecInfo mediaCodecInfoPeekFirst = this.availableCodecInfos.peekFirst();
            if (!shouldInitCodec(mediaCodecInfoPeekFirst)) {
                return;
            }
            try {
                initCodec(mediaCodecInfoPeekFirst, crypto);
            } catch (Exception e2) {
                Log.w("MediaCodecRenderer", "Failed to initialize decoder: " + mediaCodecInfoPeekFirst, e2);
                this.availableCodecInfos.removeFirst();
                DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.inputFormat, e2, mediaCryptoRequiresSecureDecoder, mediaCodecInfoPeekFirst);
                if (this.preferredDecoderInitializationException != null) {
                    this.preferredDecoderInitializationException = this.preferredDecoderInitializationException.copyWithFallbackException(decoderInitializationException);
                } else {
                    this.preferredDecoderInitializationException = decoderInitializationException;
                }
                if (this.availableCodecInfos.isEmpty()) {
                    throw this.preferredDecoderInitializationException;
                }
            }
        }
        this.availableCodecInfos = null;
    }

    private List<MediaCodecInfo> getAvailableCodecInfos(boolean mediaCryptoRequiresSecureDecoder) throws MediaCodecUtil.DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, mediaCryptoRequiresSecureDecoder);
        if (decoderInfos.isEmpty() && mediaCryptoRequiresSecureDecoder) {
            decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, false);
            if (!decoderInfos.isEmpty()) {
                Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + this.inputFormat.sampleMimeType + ", but no secure decoder available. Trying to proceed with " + decoderInfos + ".");
            }
        }
        return decoderInfos;
    }

    private void initCodec(MediaCodecInfo codecInfo, MediaCrypto crypto) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        MediaCodecAdapter synchronousMediaCodecAdapter;
        String str = codecInfo.name;
        int i = Util.SDK_INT;
        float codecOperatingRateV23 = i < 23 ? -1.0f : getCodecOperatingRateV23(this.rendererOperatingRate, this.inputFormat, getStreamFormats());
        float f = codecOperatingRateV23 <= this.assumedMinimumCodecOperatingRate ? -1.0f : codecOperatingRateV23;
        MediaCodecAdapter mediaCodecAdapter = null;
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            TraceUtil.beginSection("createCodec:" + str);
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                int i2 = this.mediaCodecOperationMode;
                if (i2 == 1 && i >= 21) {
                    synchronousMediaCodecAdapter = new AsynchronousMediaCodecAdapter(mediaCodecCreateByCodecName);
                } else if (i2 == 2 && i >= 23) {
                    synchronousMediaCodecAdapter = new DedicatedThreadAsyncMediaCodecAdapter(mediaCodecCreateByCodecName, getTrackType());
                } else if (i2 == 3 && i >= 23) {
                    synchronousMediaCodecAdapter = new MultiLockAsyncMediaCodecAdapter(mediaCodecCreateByCodecName, getTrackType());
                } else if (i2 == 4 && i >= 23) {
                    synchronousMediaCodecAdapter = new DedicatedThreadAsyncMediaCodecAdapter(mediaCodecCreateByCodecName, true, getTrackType());
                } else if (i2 == 5 && i >= 23) {
                    synchronousMediaCodecAdapter = new MultiLockAsyncMediaCodecAdapter(mediaCodecCreateByCodecName, true, getTrackType());
                } else {
                    synchronousMediaCodecAdapter = new SynchronousMediaCodecAdapter(mediaCodecCreateByCodecName);
                }
                MediaCodecAdapter mediaCodecAdapter2 = synchronousMediaCodecAdapter;
                try {
                    TraceUtil.endSection();
                    TraceUtil.beginSection("configureCodec");
                    configureCodec(codecInfo, mediaCodecCreateByCodecName, this.inputFormat, crypto, f);
                    TraceUtil.endSection();
                    TraceUtil.beginSection("startCodec");
                    mediaCodecAdapter2.start();
                    TraceUtil.endSection();
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    getCodecBuffers(mediaCodecCreateByCodecName);
                    this.codec = mediaCodecCreateByCodecName;
                    this.codecAdapter = mediaCodecAdapter2;
                    this.codecInfo = codecInfo;
                    this.codecOperatingRate = f;
                    this.codecFormat = this.inputFormat;
                    this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode(str);
                    this.codecNeedsReconfigureWorkaround = codecNeedsReconfigureWorkaround(str);
                    this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround(str, this.codecFormat);
                    this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround(str);
                    this.codecNeedsSosFlushWorkaround = codecNeedsSosFlushWorkaround(str);
                    this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(str);
                    this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround(str);
                    this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround(str, this.codecFormat);
                    this.codecNeedsEosPropagation = codecNeedsEosPropagationWorkaround(codecInfo) || getCodecNeedsEosPropagation();
                    if (getState() == 2) {
                        this.codecHotswapDeadlineMs = SystemClock.elapsedRealtime() + 1000;
                    }
                    this.decoderCounters.decoderInitCount++;
                    onCodecInitialized(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                } catch (Exception e) {
                    e = e;
                    mediaCodecAdapter = mediaCodecAdapter2;
                    if (mediaCodecAdapter != null) {
                        mediaCodecAdapter.shutdown();
                    }
                    if (mediaCodecCreateByCodecName != null) {
                        resetCodecBuffers();
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodecCreateByCodecName = null;
        }
    }

    private boolean shouldContinueRendering(long renderStartTimeMs) {
        return this.renderTimeLimitMs == -9223372036854775807L || SystemClock.elapsedRealtime() - renderStartTimeMs < this.renderTimeLimitMs;
    }

    private void getCodecBuffers(MediaCodec codec) {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = codec.getInputBuffers();
            this.outputBuffers = codec.getOutputBuffers();
        }
    }

    private void resetCodecBuffers() {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = null;
            this.outputBuffers = null;
        }
    }

    private ByteBuffer getInputBuffer(int inputIndex) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getInputBuffer(inputIndex);
        }
        return this.inputBuffers[inputIndex];
    }

    private ByteBuffer getOutputBuffer(int outputIndex) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getOutputBuffer(outputIndex);
        }
        return this.outputBuffers[outputIndex];
    }

    private boolean hasOutputBuffer() {
        return this.outputIndex >= 0;
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private void setSourceDrmSession(DrmSession session) {
        DrmSession.replaceSession(this.sourceDrmSession, session);
        this.sourceDrmSession = session;
    }

    private void setCodecDrmSession(DrmSession session) {
        DrmSession.replaceSession(this.codecDrmSession, session);
        this.codecDrmSession = session;
    }

    private boolean feedInputBuffer() throws ExoPlaybackException, MediaCryptoException {
        int iPosition;
        int source;
        if (this.codec == null || this.codecDrainState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputIndex < 0) {
            int iDequeueInputBufferIndex = this.codecAdapter.dequeueInputBufferIndex();
            this.inputIndex = iDequeueInputBufferIndex;
            if (iDequeueInputBufferIndex < 0) {
                return false;
            }
            this.buffer.data = getInputBuffer(iDequeueInputBufferIndex);
            this.buffer.clear();
        }
        if (this.codecDrainState == 1) {
            if (!this.codecNeedsEosPropagation) {
                this.codecReceivedEos = true;
                this.codecAdapter.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                resetInputBuffer();
            }
            this.codecDrainState = 2;
            return false;
        }
        if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            ByteBuffer byteBuffer = this.buffer.data;
            byte[] bArr = ADAPTATION_WORKAROUND_BUFFER;
            byteBuffer.put(bArr);
            this.codecAdapter.queueInputBuffer(this.inputIndex, 0, bArr.length, 0L, 0);
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            return true;
        }
        FormatHolder formatHolder = getFormatHolder();
        if (this.waitingForKeys) {
            source = -4;
            iPosition = 0;
        } else {
            if (this.codecReconfigurationState == 1) {
                for (int i = 0; i < this.codecFormat.initializationData.size(); i++) {
                    this.buffer.data.put(this.codecFormat.initializationData.get(i));
                }
                this.codecReconfigurationState = 2;
            }
            iPosition = this.buffer.data.position();
            source = readSource(formatHolder, this.buffer, false);
        }
        if (hasReadStreamToEnd()) {
            this.lastBufferInStreamPresentationTimeUs = this.largestQueuedPresentationTimeUs;
        }
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            if (this.codecReconfigurationState == 2) {
                this.buffer.clear();
                this.codecReconfigurationState = 1;
            }
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (this.buffer.isEndOfStream()) {
            if (this.codecReconfigurationState == 2) {
                this.buffer.clear();
                this.codecReconfigurationState = 1;
            }
            this.inputStreamEnded = true;
            if (!this.codecReceivedBuffers) {
                processEndOfStream();
                return false;
            }
            try {
                if (!this.codecNeedsEosPropagation) {
                    this.codecReceivedEos = true;
                    this.codecAdapter.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                    resetInputBuffer();
                }
                return false;
            } catch (MediaCodec.CryptoException e) {
                throw createRendererException(e, this.inputFormat);
            }
        }
        if (this.waitingForFirstSyncSample && !this.buffer.isKeyFrame()) {
            this.buffer.clear();
            if (this.codecReconfigurationState == 2) {
                this.codecReconfigurationState = 1;
            }
            return true;
        }
        this.waitingForFirstSyncSample = false;
        boolean zIsEncrypted = this.buffer.isEncrypted();
        boolean zShouldWaitForKeys = shouldWaitForKeys(zIsEncrypted);
        this.waitingForKeys = zShouldWaitForKeys;
        if (zShouldWaitForKeys) {
            return false;
        }
        if (this.codecNeedsDiscardToSpsWorkaround && !zIsEncrypted) {
            NalUnitUtil.discardToSps(this.buffer.data);
            if (this.buffer.data.position() == 0) {
                return true;
            }
            this.codecNeedsDiscardToSpsWorkaround = false;
        }
        try {
            DecoderInputBuffer decoderInputBuffer = this.buffer;
            long j = decoderInputBuffer.timeUs;
            if (decoderInputBuffer.isDecodeOnly()) {
                this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j));
            }
            if (this.waitingForFirstSampleInFormat) {
                this.formatQueue.add(j, this.inputFormat);
                this.waitingForFirstSampleInFormat = false;
            }
            this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, j);
            this.buffer.flip();
            if (this.buffer.hasSupplementalData()) {
                handleInputBufferSupplementalData(this.buffer);
            }
            onQueueInputBuffer(this.buffer);
            if (zIsEncrypted) {
                CryptoInfo cryptoInfo = this.buffer.cryptoInfo;
                cryptoInfo.increaseClearDataFirstSubSampleBy(iPosition);
                this.codecAdapter.queueSecureInputBuffer(this.inputIndex, 0, cryptoInfo, j, 0);
            } else {
                this.codecAdapter.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j, 0);
            }
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            this.codecReconfigurationState = 0;
            this.decoderCounters.inputBufferCount++;
            return true;
        } catch (MediaCodec.CryptoException e2) {
            throw createRendererException(e2, this.inputFormat);
        }
    }

    private boolean shouldWaitForKeys(boolean bufferEncrypted) throws ExoPlaybackException {
        DrmSession drmSession = this.codecDrmSession;
        if (drmSession == null || (!bufferEncrypted && drmSession.playClearSamplesWithoutKeys())) {
            return false;
        }
        int state = this.codecDrmSession.getState();
        if (state != 1) {
            return state != 4;
        }
        throw createRendererException(this.codecDrmSession.getError(), this.inputFormat);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onInputFormatChanged(com.google.android.exoplayer2.FormatHolder r5) throws com.google.android.exoplayer2.ExoPlaybackException, android.media.MediaCryptoException {
        /*
            r4 = this;
            r0 = 1
            r4.waitingForFirstSampleInFormat = r0
            com.google.android.exoplayer2.Format r1 = r5.format
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
            com.google.android.exoplayer2.Format r1 = (com.google.android.exoplayer2.Format) r1
            com.google.android.exoplayer2.drm.DrmSession r5 = r5.drmSession
            r4.setSourceDrmSession(r5)
            r4.inputFormat = r1
            android.media.MediaCodec r5 = r4.codec
            if (r5 != 0) goto L1a
            r4.maybeInitCodec()
            return
        L1a:
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            if (r5 != 0) goto L22
            com.google.android.exoplayer2.drm.DrmSession r2 = r4.codecDrmSession
            if (r2 != 0) goto L44
        L22:
            if (r5 == 0) goto L28
            com.google.android.exoplayer2.drm.DrmSession r2 = r4.codecDrmSession
            if (r2 == 0) goto L44
        L28:
            com.google.android.exoplayer2.drm.DrmSession r2 = r4.codecDrmSession
            if (r5 == r2) goto L38
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r2 = r4.codecInfo
            boolean r2 = r2.secure
            if (r2 != 0) goto L38
            boolean r5 = r4.maybeRequiresSecureDecoder(r5, r1)
            if (r5 != 0) goto L44
        L38:
            int r5 = com.google.android.exoplayer2.util.Util.SDK_INT
            r2 = 23
            if (r5 >= r2) goto L48
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            com.google.android.exoplayer2.drm.DrmSession r2 = r4.codecDrmSession
            if (r5 == r2) goto L48
        L44:
            r4.drainAndReinitializeCodec()
            return
        L48:
            android.media.MediaCodec r5 = r4.codec
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r2 = r4.codecInfo
            com.google.android.exoplayer2.Format r3 = r4.codecFormat
            int r5 = r4.canKeepCodec(r5, r2, r3, r1)
            if (r5 == 0) goto Lb7
            if (r5 == r0) goto La4
            r2 = 2
            if (r5 == r2) goto L71
            r0 = 3
            if (r5 != r0) goto L6b
            r4.codecFormat = r1
            r4.updateCodecOperatingRate()
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            com.google.android.exoplayer2.drm.DrmSession r0 = r4.codecDrmSession
            if (r5 == r0) goto Lba
            r4.drainAndUpdateCodecDrmSession()
            goto Lba
        L6b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r5.<init>()
            throw r5
        L71:
            boolean r5 = r4.codecNeedsReconfigureWorkaround
            if (r5 == 0) goto L79
            r4.drainAndReinitializeCodec()
            goto Lba
        L79:
            r4.codecReconfigured = r0
            r4.codecReconfigurationState = r0
            int r5 = r4.codecAdaptationWorkaroundMode
            if (r5 == r2) goto L93
            if (r5 != r0) goto L92
            int r5 = r1.width
            com.google.android.exoplayer2.Format r2 = r4.codecFormat
            int r3 = r2.width
            if (r5 != r3) goto L92
            int r5 = r1.height
            int r2 = r2.height
            if (r5 != r2) goto L92
            goto L93
        L92:
            r0 = 0
        L93:
            r4.codecNeedsAdaptationWorkaroundBuffer = r0
            r4.codecFormat = r1
            r4.updateCodecOperatingRate()
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            com.google.android.exoplayer2.drm.DrmSession r0 = r4.codecDrmSession
            if (r5 == r0) goto Lba
            r4.drainAndUpdateCodecDrmSession()
            goto Lba
        La4:
            r4.codecFormat = r1
            r4.updateCodecOperatingRate()
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            com.google.android.exoplayer2.drm.DrmSession r0 = r4.codecDrmSession
            if (r5 == r0) goto Lb3
            r4.drainAndUpdateCodecDrmSession()
            goto Lba
        Lb3:
            r4.drainAndFlushCodec()
            goto Lba
        Lb7:
            r4.drainAndReinitializeCodec()
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.onInputFormatChanged(com.google.android.exoplayer2.FormatHolder):void");
    }

    protected void onProcessedOutputBuffer(long presentationTimeUs) {
        while (true) {
            int i = this.pendingOutputStreamOffsetCount;
            if (i == 0 || presentationTimeUs < this.pendingOutputStreamSwitchTimesUs[0]) {
                return;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            this.outputStreamOffsetUs = jArr[0];
            int i2 = i - 1;
            this.pendingOutputStreamOffsetCount = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.pendingOutputStreamSwitchTimesUs;
            System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
            onProcessedStreamChange();
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return (this.inputFormat == null || this.waitingForKeys || (!isSourceReady() && !hasOutputBuffer() && (this.codecHotswapDeadlineMs == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.codecHotswapDeadlineMs))) ? false : true;
    }

    private void updateCodecOperatingRate() throws ExoPlaybackException {
        if (Util.SDK_INT < 23) {
            return;
        }
        float codecOperatingRateV23 = getCodecOperatingRateV23(this.rendererOperatingRate, this.codecFormat, getStreamFormats());
        float f = this.codecOperatingRate;
        if (f == codecOperatingRateV23) {
            return;
        }
        if (codecOperatingRateV23 == -1.0f) {
            drainAndReinitializeCodec();
            return;
        }
        if (f != -1.0f || codecOperatingRateV23 > this.assumedMinimumCodecOperatingRate) {
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", codecOperatingRateV23);
            this.codec.setParameters(bundle);
            this.codecOperatingRate = codecOperatingRateV23;
        }
    }

    private void drainAndFlushCodec() {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 1;
        }
    }

    private void drainAndUpdateCodecDrmSession() throws ExoPlaybackException, MediaCryptoException {
        if (Util.SDK_INT < 23) {
            drainAndReinitializeCodec();
        } else if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 2;
        } else {
            updateDrmSessionOrReinitializeCodecV23();
        }
    }

    private void drainAndReinitializeCodec() throws ExoPlaybackException {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 3;
        } else {
            reinitializeCodec();
        }
    }

    private boolean drainOutputBuffer(long positionUs, long elapsedRealtimeUs) throws ExoPlaybackException, MediaCryptoException {
        boolean z;
        boolean zProcessOutputBuffer;
        int iDequeueOutputBufferIndex;
        if (!hasOutputBuffer()) {
            if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
                try {
                    iDequeueOutputBufferIndex = this.codecAdapter.dequeueOutputBufferIndex(this.outputBufferInfo);
                } catch (IllegalStateException unused) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                        releaseCodec();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBufferIndex = this.codecAdapter.dequeueOutputBufferIndex(this.outputBufferInfo);
            }
            if (iDequeueOutputBufferIndex < 0) {
                if (iDequeueOutputBufferIndex == -2) {
                    processOutputMediaFormat();
                    return true;
                }
                if (iDequeueOutputBufferIndex == -3) {
                    processOutputBuffersChanged();
                    return true;
                }
                if (this.codecNeedsEosPropagation && (this.inputStreamEnded || this.codecDrainState == 2)) {
                    processEndOfStream();
                }
                return false;
            }
            if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                this.codec.releaseOutputBuffer(iDequeueOutputBufferIndex, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.outputBufferInfo;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                processEndOfStream();
                return false;
            }
            this.outputIndex = iDequeueOutputBufferIndex;
            ByteBuffer outputBuffer = getOutputBuffer(iDequeueOutputBufferIndex);
            this.outputBuffer = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(this.outputBufferInfo.offset);
                ByteBuffer byteBuffer = this.outputBuffer;
                MediaCodec.BufferInfo bufferInfo2 = this.outputBufferInfo;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            this.isDecodeOnlyOutputBuffer = isDecodeOnlyBuffer(this.outputBufferInfo.presentationTimeUs);
            long j = this.lastBufferInStreamPresentationTimeUs;
            long j2 = this.outputBufferInfo.presentationTimeUs;
            this.isLastOutputBuffer = j == j2;
            updateOutputFormatForTime(j2);
        }
        if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
            try {
                MediaCodec mediaCodec = this.codec;
                ByteBuffer byteBuffer2 = this.outputBuffer;
                int i = this.outputIndex;
                MediaCodec.BufferInfo bufferInfo3 = this.outputBufferInfo;
                z = false;
                try {
                    zProcessOutputBuffer = processOutputBuffer(positionUs, elapsedRealtimeUs, mediaCodec, byteBuffer2, i, bufferInfo3.flags, 1, bufferInfo3.presentationTimeUs, this.isDecodeOnlyOutputBuffer, this.isLastOutputBuffer, this.outputFormat);
                } catch (IllegalStateException unused2) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                        releaseCodec();
                    }
                    return z;
                }
            } catch (IllegalStateException unused3) {
                z = false;
            }
        } else {
            z = false;
            MediaCodec mediaCodec2 = this.codec;
            ByteBuffer byteBuffer3 = this.outputBuffer;
            int i2 = this.outputIndex;
            MediaCodec.BufferInfo bufferInfo4 = this.outputBufferInfo;
            zProcessOutputBuffer = processOutputBuffer(positionUs, elapsedRealtimeUs, mediaCodec2, byteBuffer3, i2, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.isDecodeOnlyOutputBuffer, this.isLastOutputBuffer, this.outputFormat);
        }
        if (zProcessOutputBuffer) {
            onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            boolean z2 = (this.outputBufferInfo.flags & 4) != 0 ? true : z;
            resetOutputBuffer();
            if (!z2) {
                return true;
            }
            processEndOfStream();
        }
        return z;
    }

    private void processOutputMediaFormat() throws ExoPlaybackException {
        this.codecHasOutputMediaFormat = true;
        MediaFormat outputFormat = this.codecAdapter.getOutputFormat();
        if (this.codecAdaptationWorkaroundMode != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat.setInteger("channel-count", 1);
        }
        onOutputMediaFormatChanged(this.codec, outputFormat);
    }

    private void processOutputBuffersChanged() {
        if (Util.SDK_INT < 21) {
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    @TargetApi(23)
    private void processEndOfStream() throws ExoPlaybackException, MediaCryptoException {
        int i = this.codecDrainAction;
        if (i == 1) {
            flushOrReinitializeCodec();
            return;
        }
        if (i == 2) {
            updateDrmSessionOrReinitializeCodecV23();
        } else if (i == 3) {
            reinitializeCodec();
        } else {
            this.outputStreamEnded = true;
            renderToEndOfStream();
        }
    }

    protected final void setPendingOutputEndOfStream() {
        this.pendingOutputEndOfStream = true;
    }

    protected final long getLargestQueuedPresentationTimeUs() {
        return this.largestQueuedPresentationTimeUs;
    }

    protected final long getOutputStreamOffsetUs() {
        return this.outputStreamOffsetUs;
    }

    protected static boolean supportsFormatDrm(Format format) {
        return format.drmInitData == null || FrameworkMediaCrypto.class.equals(format.exoMediaCryptoType);
    }

    private boolean maybeRequiresSecureDecoder(DrmSession drmSession, Format format) throws ExoPlaybackException {
        FrameworkMediaCrypto frameworkMediaCrypto = getFrameworkMediaCrypto(drmSession);
        if (frameworkMediaCrypto == null) {
            return true;
        }
        if (frameworkMediaCrypto.forceAllowInsecureDecoderComponents) {
            return false;
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(frameworkMediaCrypto.uuid, frameworkMediaCrypto.sessionId);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(format.sampleMimeType);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    private void reinitializeCodec() throws ExoPlaybackException {
        releaseCodec();
        maybeInitCodec();
    }

    private boolean isDecodeOnlyBuffer(long presentationTimeUs) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < size; i++) {
            if (this.decodeOnlyPresentationTimestamps.get(i).longValue() == presentationTimeUs) {
                this.decodeOnlyPresentationTimestamps.remove(i);
                return true;
            }
        }
        return false;
    }

    private void updateDrmSessionOrReinitializeCodecV23() throws ExoPlaybackException, MediaCryptoException {
        FrameworkMediaCrypto frameworkMediaCrypto = getFrameworkMediaCrypto(this.sourceDrmSession);
        if (frameworkMediaCrypto == null) {
            reinitializeCodec();
            return;
        }
        if (C.PLAYREADY_UUID.equals(frameworkMediaCrypto.uuid)) {
            reinitializeCodec();
            return;
        }
        if (flushOrReinitializeCodec()) {
            return;
        }
        try {
            this.mediaCrypto.setMediaDrmSession(frameworkMediaCrypto.sessionId);
            setCodecDrmSession(this.sourceDrmSession);
            this.codecDrainState = 0;
            this.codecDrainAction = 0;
        } catch (MediaCryptoException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    private FrameworkMediaCrypto getFrameworkMediaCrypto(DrmSession drmSession) throws ExoPlaybackException {
        ExoMediaCrypto mediaCrypto = drmSession.getMediaCrypto();
        if (mediaCrypto != null && !(mediaCrypto instanceof FrameworkMediaCrypto)) {
            throw createRendererException(new IllegalArgumentException("Expecting FrameworkMediaCrypto but found: " + mediaCrypto), this.inputFormat);
        }
        return (FrameworkMediaCrypto) mediaCrypto;
    }

    private static boolean isMediaCodecException(IllegalStateException error) {
        if (Util.SDK_INT >= 21 && isMediaCodecExceptionV21(error)) {
            return true;
        }
        StackTraceElement[] stackTrace = error.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private static boolean isMediaCodecExceptionV21(IllegalStateException error) {
        return error instanceof MediaCodec.CodecException;
    }

    private static boolean codecNeedsFlushWorkaround(String name) {
        int i = Util.SDK_INT;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(name) || "OMX.SEC.avc.dec.secure".equals(name))) || (i == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(name) || "OMX.Exynos.avc.dec.secure".equals(name)));
    }

    private int codecAdaptationWorkaroundMode(String name) {
        int i = Util.SDK_INT;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(name)) {
            String str = Util.MODEL;
            if (str.startsWith("SM-T585") || str.startsWith("SM-A510") || str.startsWith("SM-A520") || str.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(name) && !"OMX.Nvidia.h264.decode.secure".equals(name)) {
            return 0;
        }
        String str2 = Util.DEVICE;
        return ("flounder".equals(str2) || "flounder_lte".equals(str2) || "grouper".equals(str2) || "tilapia".equals(str2)) ? 1 : 0;
    }

    private static boolean codecNeedsReconfigureWorkaround(String name) {
        return Util.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(name);
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String name, Format format) {
        return Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(name);
    }

    private static boolean codecNeedsEosPropagationWorkaround(MediaCodecInfo codecInfo) {
        String str = codecInfo.name;
        int i = Util.SDK_INT;
        return (i <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ("Amazon".equals(Util.MANUFACTURER) && "AFTS".equals(Util.MODEL) && codecInfo.secure);
    }

    private static boolean codecNeedsEosFlushWorkaround(String name) {
        int i = Util.SDK_INT;
        if (i > 23 || !"OMX.google.vorbis.decoder".equals(name)) {
            if (i <= 19) {
                String str = Util.DEVICE;
                if (("hb2000".equals(str) || "stvm8".equals(str)) && ("OMX.amlogic.avc.decoder.awesome".equals(name) || "OMX.amlogic.avc.decoder.awesome.secure".equals(name))) {
                }
            }
            return false;
        }
        return true;
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String name) {
        return Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(name);
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String name, Format format) {
        return Util.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(name);
    }

    private static boolean codecNeedsSosFlushWorkaround(String name) {
        return Util.SDK_INT == 29 && "c2.android.aac.decoder".equals(name);
    }
}
