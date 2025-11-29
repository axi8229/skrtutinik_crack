package com.google.android.exoplayer2.ext.ffmpeg;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DecoderAudioRenderer;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;

/* loaded from: classes2.dex */
public final class FfmpegAudioRenderer extends DecoderAudioRenderer {
    private FfmpegAudioDecoder decoder;
    private final boolean enableFloatOutput;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public FfmpegAudioRenderer() {
        this(null, null, new AudioProcessor[0]);
    }

    public FfmpegAudioRenderer(Handler eventHandler, AudioRendererEventListener eventListener, AudioProcessor... audioProcessors) {
        this(eventHandler, eventListener, new DefaultAudioSink(null, audioProcessors), false);
    }

    public FfmpegAudioRenderer(Handler eventHandler, AudioRendererEventListener eventListener, AudioSink audioSink, boolean enableFloatOutput) {
        super(eventHandler, eventListener, audioSink);
        this.enableFloatOutput = enableFloatOutput;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "FfmpegAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.audio.DecoderAudioRenderer
    protected int supportsFormatInternal(Format format) {
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        if (!FfmpegLibrary.isAvailable() || !MimeTypes.isAudio(str)) {
            return 0;
        }
        if (FfmpegLibrary.supportsFormat(str) && isOutputSupported(format)) {
            return (format.drmInitData == null || format.exoMediaCryptoType != null) ? 4 : 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.audio.DecoderAudioRenderer
    public FfmpegAudioDecoder createDecoder(Format format, ExoMediaCrypto mediaCrypto) throws FfmpegDecoderException {
        TraceUtil.beginSection("createFfmpegAudioDecoder");
        int i = format.maxInputSize;
        if (i == -1) {
            i = 5760;
        }
        this.decoder = new FfmpegAudioDecoder(16, 16, i, format, shouldUseFloatOutput(format));
        TraceUtil.endSection();
        return this.decoder;
    }

    @Override // com.google.android.exoplayer2.audio.DecoderAudioRenderer
    public Format getOutputFormat() {
        Assertions.checkNotNull(this.decoder);
        return new Format.Builder().setSampleMimeType("audio/raw").setChannelCount(this.decoder.getChannelCount()).setSampleRate(this.decoder.getSampleRate()).setPcmEncoding(this.decoder.getEncoding()).build();
    }

    private boolean isOutputSupported(Format inputFormat) {
        return shouldUseFloatOutput(inputFormat) || supportsOutput(inputFormat.channelCount, 2);
    }

    private boolean shouldUseFloatOutput(Format inputFormat) {
        Assertions.checkNotNull(inputFormat.sampleMimeType);
        if (!this.enableFloatOutput || !supportsOutput(inputFormat.channelCount, 4)) {
            return false;
        }
        String str = inputFormat.sampleMimeType;
        str.hashCode();
        if (str.equals("audio/ac3")) {
            return false;
        }
        if (!str.equals("audio/raw")) {
            return true;
        }
        int i = inputFormat.pcmEncoding;
        return i == 536870912 || i == 805306368 || i == 4;
    }
}
