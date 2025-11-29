package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private int codecMaxInputSize;
    private boolean codecNeedsDiscardChannelsWorkaround;
    private boolean codecNeedsEosBufferTimestampWorkaround;
    private final Context context;
    private long currentPositionUs;
    private final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private Format inputFormat;
    private boolean passthroughEnabled;
    private MediaFormat passthroughMediaFormat;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        return this;
    }

    protected void onAudioSessionId(int audioSessionId) {
    }

    protected void onAudioTrackPositionDiscontinuity() {
    }

    protected void onAudioTrackSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
    }

    protected void onAudioTrackUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, boolean enableDecoderFallback, Handler eventHandler, AudioRendererEventListener eventListener, AudioSink audioSink) {
        super(1, mediaCodecSelector, enableDecoderFallback, 44100.0f);
        this.context = context.getApplicationContext();
        this.audioSink = audioSink;
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(eventHandler, eventListener);
        audioSink.setListener(new AudioSinkListener());
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (!MimeTypes.isAudio(str)) {
            return RendererCapabilities.create(0);
        }
        int i = Util.SDK_INT >= 21 ? 32 : 0;
        boolean zSupportsFormatDrm = MediaCodecRenderer.supportsFormatDrm(format);
        int i2 = 8;
        if (zSupportsFormatDrm && usePassthrough(format.channelCount, str)) {
            return RendererCapabilities.create(4, 8, i);
        }
        if (("audio/raw".equals(str) && !this.audioSink.supportsOutput(format.channelCount, format.pcmEncoding)) || !this.audioSink.supportsOutput(format.channelCount, 2)) {
            return RendererCapabilities.create(1);
        }
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, false);
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.create(1);
        }
        if (!zSupportsFormatDrm) {
            return RendererCapabilities.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (zIsFormatSupported && mediaCodecInfo.isSeamlessAdaptationSupported(format)) {
            i2 = 16;
        }
        return RendererCapabilities.create(zIsFormatSupported ? 4 : 3, i2, i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean requiresSecureDecoder) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        if (usePassthrough(format.channelCount, str)) {
            return Collections.singletonList(MediaCodecUtil.getPassthroughDecoderInfo());
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, requiresSecureDecoder, false), format);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(decoderInfosSortedByFormatSupport);
            arrayList.addAll(mediaCodecSelector.getDecoderInfos("audio/eac3", requiresSecureDecoder, false));
            decoderInfosSortedByFormatSupport = arrayList;
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    protected boolean usePassthrough(int channelCount, String mimeType) throws MediaCodecUtil.DecoderQueryException {
        return (getPassthroughEncoding(channelCount, mimeType) == 0 || MediaCodecUtil.getPassthroughDecoderInfo() == null) ? false : true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodecInfo codecInfo, MediaCodec codec, Format format, MediaCrypto crypto, float codecOperatingRate) {
        this.codecMaxInputSize = getCodecMaxInputSize(codecInfo, format, getStreamFormats());
        this.codecNeedsDiscardChannelsWorkaround = codecNeedsDiscardChannelsWorkaround(codecInfo.name);
        this.codecNeedsEosBufferTimestampWorkaround = codecNeedsEosBufferTimestampWorkaround(codecInfo.name);
        this.passthroughEnabled = "audio/raw".equals(codecInfo.mimeType) && !"audio/raw".equals(format.sampleMimeType);
        MediaFormat mediaFormat = getMediaFormat(format, codecInfo.codecMimeType, this.codecMaxInputSize, codecOperatingRate);
        codec.configure(mediaFormat, (Surface) null, crypto, 0);
        if (this.passthroughEnabled) {
            this.passthroughMediaFormat = mediaFormat;
            mediaFormat.setString("mime", format.sampleMimeType);
        } else {
            this.passthroughMediaFormat = null;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int canKeepCodec(MediaCodec codec, MediaCodecInfo codecInfo, Format oldFormat, Format newFormat) {
        if (getCodecMaxInputSize(codecInfo, newFormat) <= this.codecMaxInputSize && oldFormat.encoderDelay == 0 && oldFormat.encoderPadding == 0 && newFormat.encoderDelay == 0 && newFormat.encoderPadding == 0) {
            if (codecInfo.isSeamlessAdaptationSupported(oldFormat, newFormat, true)) {
                return 3;
            }
            if (canKeepCodecWithFlush(oldFormat, newFormat)) {
                return 1;
            }
        }
        return 0;
    }

    protected boolean canKeepCodecWithFlush(Format oldFormat, Format newFormat) {
        return Util.areEqual(oldFormat.sampleMimeType, newFormat.sampleMimeType) && oldFormat.channelCount == newFormat.channelCount && oldFormat.sampleRate == newFormat.sampleRate && oldFormat.pcmEncoding == newFormat.pcmEncoding && oldFormat.initializationDataEquals(newFormat) && !"audio/opus".equals(oldFormat.sampleMimeType);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRateV23(float operatingRate, Format format, Format[] streamFormats) {
        int iMax = -1;
        for (Format format2 : streamFormats) {
            int i = format2.sampleRate;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return operatingRate * iMax;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String name, long initializedTimestampMs, long initializationDurationMs) {
        this.eventDispatcher.decoderInitialized(name, initializedTimestampMs, initializationDurationMs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException, MediaCryptoException {
        super.onInputFormatChanged(formatHolder);
        Format format = formatHolder.format;
        this.inputFormat = format;
        this.eventDispatcher.inputFormatChanged(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputMediaFormatChanged(MediaCodec codec, MediaFormat outputMediaFormat) throws ExoPlaybackException {
        int pcmEncoding;
        int passthroughEncoding;
        int[] iArr;
        int i;
        MediaFormat mediaFormat = this.passthroughMediaFormat;
        if (mediaFormat != null) {
            passthroughEncoding = getPassthroughEncoding(mediaFormat.getInteger("channel-count"), mediaFormat.getString("mime"));
            outputMediaFormat = mediaFormat;
        } else {
            if (outputMediaFormat.containsKey("v-bits-per-sample")) {
                pcmEncoding = Util.getPcmEncoding(outputMediaFormat.getInteger("v-bits-per-sample"));
            } else {
                pcmEncoding = getPcmEncoding(this.inputFormat);
            }
            passthroughEncoding = pcmEncoding;
        }
        int integer = outputMediaFormat.getInteger("channel-count");
        int integer2 = outputMediaFormat.getInteger("sample-rate");
        if (this.codecNeedsDiscardChannelsWorkaround && integer == 6 && (i = this.inputFormat.channelCount) < 6) {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.inputFormat.channelCount; i2++) {
                iArr[i2] = i2;
            }
        } else {
            iArr = null;
        }
        int[] iArr2 = iArr;
        try {
            AudioSink audioSink = this.audioSink;
            Format format = this.inputFormat;
            audioSink.configure(passthroughEncoding, integer, integer2, 0, iArr2, format.encoderDelay, format.encoderPadding);
        } catch (AudioSink.ConfigurationException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    protected int getPassthroughEncoding(int channelCount, String mimeType) {
        if ("audio/raw".equals(mimeType)) {
            return 0;
        }
        if ("audio/eac3-joc".equals(mimeType)) {
            if (this.audioSink.supportsOutput(-1, 18)) {
                return MimeTypes.getEncoding("audio/eac3-joc");
            }
            mimeType = "audio/eac3";
        }
        int encoding = MimeTypes.getEncoding(mimeType);
        if (this.audioSink.supportsOutput(channelCount, encoding)) {
            return encoding;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean joining, boolean mayRenderStartOfStream) throws ExoPlaybackException {
        super.onEnabled(joining, mayRenderStartOfStream);
        this.eventDispatcher.enabled(this.decoderCounters);
        int i = getConfiguration().tunnelingAudioSessionId;
        if (i != 0) {
            this.audioSink.enableTunnelingV21(i);
        } else {
            this.audioSink.disableTunneling();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long positionUs, boolean joining) throws ExoPlaybackException {
        super.onPositionReset(positionUs, joining);
        this.audioSink.flush();
        this.currentPositionUs = positionUs;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.audioSink.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        try {
            this.audioSink.flush();
            try {
                super.onDisabled();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onReset() {
        try {
            super.onReset();
        } finally {
            this.audioSink.reset();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return super.isEnded() && this.audioSink.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.audioSink.hasPendingData() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackSpeed(float playbackSpeed) {
        this.audioSink.setPlaybackSpeed(playbackSpeed);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public float getPlaybackSpeed() {
        return this.audioSink.getPlaybackSpeed();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(DecoderInputBuffer buffer) {
        if (!this.allowFirstBufferPositionDiscontinuity || buffer.isDecodeOnly()) {
            return;
        }
        if (Math.abs(buffer.timeUs - this.currentPositionUs) > 500000) {
            this.currentPositionUs = buffer.timeUs;
        }
        this.allowFirstBufferPositionDiscontinuity = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.audioSink.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long positionUs, long elapsedRealtimeUs, MediaCodec codec, ByteBuffer buffer, int bufferIndex, int bufferFlags, int sampleCount, long bufferPresentationTimeUs, boolean isDecodeOnlyBuffer, boolean isLastBuffer, Format format) throws ExoPlaybackException {
        if (this.codecNeedsEosBufferTimestampWorkaround && bufferPresentationTimeUs == 0 && (bufferFlags & 4) != 0 && getLargestQueuedPresentationTimeUs() != -9223372036854775807L) {
            bufferPresentationTimeUs = getLargestQueuedPresentationTimeUs();
        }
        if (this.passthroughEnabled && (bufferFlags & 2) != 0) {
            codec.releaseOutputBuffer(bufferIndex, false);
            return true;
        }
        if (isDecodeOnlyBuffer) {
            codec.releaseOutputBuffer(bufferIndex, false);
            this.decoderCounters.skippedOutputBufferCount++;
            this.audioSink.handleDiscontinuity();
            return true;
        }
        try {
            if (!this.audioSink.handleBuffer(buffer, bufferPresentationTimeUs, sampleCount)) {
                return false;
            }
            codec.releaseOutputBuffer(bufferIndex, false);
            this.decoderCounters.renderedOutputBufferCount++;
            return true;
        } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void renderToEndOfStream() throws ExoPlaybackException {
        try {
            this.audioSink.playToEndOfStream();
        } catch (AudioSink.WriteException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int messageType, Object message) throws ExoPlaybackException {
        if (messageType == 2) {
            this.audioSink.setVolume(((Float) message).floatValue());
            return;
        }
        if (messageType == 3) {
            this.audioSink.setAudioAttributes((AudioAttributes) message);
            return;
        }
        if (messageType == 5) {
            this.audioSink.setAuxEffectInfo((AuxEffectInfo) message);
        } else if (messageType == 101) {
            this.audioSink.setSkipSilenceEnabled(((Boolean) message).booleanValue());
        } else if (messageType == 102) {
            this.audioSink.setAudioSessionId(((Integer) message).intValue());
        } else {
            super.handleMessage(messageType, message);
        }
    }

    protected int getCodecMaxInputSize(MediaCodecInfo codecInfo, Format format, Format[] streamFormats) {
        int codecMaxInputSize = getCodecMaxInputSize(codecInfo, format);
        if (streamFormats.length == 1) {
            return codecMaxInputSize;
        }
        for (Format format2 : streamFormats) {
            if (codecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                codecMaxInputSize = Math.max(codecMaxInputSize, getCodecMaxInputSize(codecInfo, format2));
            }
        }
        return codecMaxInputSize;
    }

    private int getCodecMaxInputSize(MediaCodecInfo codecInfo, Format format) {
        int i;
        if (!"OMX.google.raw.decoder".equals(codecInfo.name) || (i = Util.SDK_INT) >= 24 || (i == 23 && Util.isTv(this.context))) {
            return format.maxInputSize;
        }
        return -1;
    }

    @SuppressLint({"InlinedApi"})
    protected MediaFormat getMediaFormat(Format format, String codecMimeType, int codecMaxInputSize, float codecOperatingRate) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", codecMimeType);
        mediaFormat.setInteger("channel-count", format.channelCount);
        mediaFormat.setInteger("sample-rate", format.sampleRate);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxInputSize);
        int i = Util.SDK_INT;
        if (i >= 23) {
            mediaFormat.setInteger(RemoteMessageConst.Notification.PRIORITY, 0);
            if (codecOperatingRate != -1.0f && !deviceDoesntSupportOperatingRate()) {
                mediaFormat.setFloat("operating-rate", codecOperatingRate);
            }
        }
        if (i <= 28 && "audio/ac4".equals(format.sampleMimeType)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        return mediaFormat;
    }

    private void updateCurrentPosition() {
        long currentPositionUs = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs = Math.max(this.currentPositionUs, currentPositionUs);
            }
            this.currentPositionUs = currentPositionUs;
            this.allowPositionDiscontinuity = false;
        }
    }

    private static boolean deviceDoesntSupportOperatingRate() {
        if (Util.SDK_INT == 23) {
            String str = Util.MODEL;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean codecNeedsDiscardChannelsWorkaround(String codecName) {
        if (Util.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(codecName) && "samsung".equals(Util.MANUFACTURER)) {
            String str = Util.DEVICE;
            if (str.startsWith("zeroflte") || str.startsWith("herolte") || str.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean codecNeedsEosBufferTimestampWorkaround(String codecName) {
        if (Util.SDK_INT < 21 && "OMX.SEC.mp3.dec".equals(codecName) && "samsung".equals(Util.MANUFACTURER)) {
            String str = Util.DEVICE;
            if (str.startsWith("baffin") || str.startsWith("grand") || str.startsWith("fortuna") || str.startsWith("gprimelte") || str.startsWith("j2y18lte") || str.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private static int getPcmEncoding(Format format) {
        if ("audio/raw".equals(format.sampleMimeType)) {
            return format.pcmEncoding;
        }
        return 2;
    }

    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int audioSessionId) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioSessionId(audioSessionId);
            MediaCodecAudioRenderer.this.onAudioSessionId(audioSessionId);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            MediaCodecAudioRenderer.this.onAudioTrackPositionDiscontinuity();
            MediaCodecAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioTrackUnderrun(bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
            MediaCodecAudioRenderer.this.onAudioTrackUnderrun(bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
            MediaCodecAudioRenderer.this.eventDispatcher.skipSilenceEnabledChanged(skipSilenceEnabled);
            MediaCodecAudioRenderer.this.onAudioTrackSkipSilenceEnabledChanged(skipSilenceEnabled);
        }
    }
}
