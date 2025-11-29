package com.google.android.exoplayer2.ext.ffmpeg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.KotlinVersion;
import org.pjsip.pjsua2.pj_ssl_sock_proto;

/* loaded from: classes2.dex */
final class FfmpegAudioDecoder extends SimpleDecoder<DecoderInputBuffer, SimpleOutputBuffer, FfmpegDecoderException> {
    private volatile int channelCount;
    private final String codecName;
    private final int encoding;
    private final byte[] extraData;
    private boolean hasOutputFormat;
    private long nativeContext;
    private final int outputBufferSize;
    private volatile int sampleRate;

    private native int ffmpegDecode(long context, ByteBuffer inputData, int inputSize, ByteBuffer outputData, int outputSize);

    private native int ffmpegGetChannelCount(long context);

    private native int ffmpegGetSampleRate(long context);

    private native long ffmpegInitialize(String codecName, byte[] extraData, boolean outputFloat, int rawSampleRate, int rawChannelCount);

    private native void ffmpegRelease(long context);

    private native long ffmpegReset(long context, byte[] extraData);

    public FfmpegAudioDecoder(int numInputBuffers, int numOutputBuffers, int initialInputBufferSize, Format format, boolean outputFloat) throws FfmpegDecoderException {
        super(new DecoderInputBuffer[numInputBuffers], new SimpleOutputBuffer[numOutputBuffers]);
        if (!FfmpegLibrary.isAvailable()) {
            throw new FfmpegDecoderException("Failed to load decoder native libraries.");
        }
        Assertions.checkNotNull(format.sampleMimeType);
        String str = (String) Assertions.checkNotNull(FfmpegLibrary.getCodecName(format.sampleMimeType));
        this.codecName = str;
        byte[] extraData = getExtraData(format.sampleMimeType, format.initializationData);
        this.extraData = extraData;
        this.encoding = outputFloat ? 4 : 2;
        this.outputBufferSize = outputFloat ? 131072 : pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
        long jFfmpegInitialize = ffmpegInitialize(str, extraData, outputFloat, format.sampleRate, format.channelCount);
        this.nativeContext = jFfmpegInitialize;
        if (jFfmpegInitialize == 0) {
            throw new FfmpegDecoderException("Initialization failed.");
        }
        setInitialInputBufferSize(initialInputBufferSize);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "ffmpeg" + FfmpegLibrary.getVersion() + "-" + this.codecName;
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    protected DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public SimpleOutputBuffer createOutputBuffer() {
        return new SimpleOutputBuffer(new OutputBuffer.Owner() { // from class: com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioDecoder$$ExternalSyntheticLambda0
            @Override // com.google.android.exoplayer2.decoder.OutputBuffer.Owner
            public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
                this.f$0.releaseOutputBuffer((SimpleOutputBuffer) outputBuffer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public FfmpegDecoderException createUnexpectedDecodeException(Throwable error) {
        return new FfmpegDecoderException("Unexpected decode error", error);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public FfmpegDecoderException decode(DecoderInputBuffer inputBuffer, SimpleOutputBuffer outputBuffer, boolean reset) {
        if (reset) {
            long jFfmpegReset = ffmpegReset(this.nativeContext, this.extraData);
            this.nativeContext = jFfmpegReset;
            if (jFfmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) Util.castNonNull(inputBuffer.data);
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferInit = outputBuffer.init(inputBuffer.timeUs, this.outputBufferSize);
        int iFfmpegDecode = ffmpegDecode(this.nativeContext, byteBuffer, iLimit, byteBufferInit, this.outputBufferSize);
        if (iFfmpegDecode == -1) {
            outputBuffer.setFlags(Integer.MIN_VALUE);
            return null;
        }
        if (iFfmpegDecode == -2) {
            return new FfmpegDecoderException("Error decoding (see logcat).");
        }
        if (!this.hasOutputFormat) {
            this.channelCount = ffmpegGetChannelCount(this.nativeContext);
            this.sampleRate = ffmpegGetSampleRate(this.nativeContext);
            if (this.sampleRate == 0 && "alac".equals(this.codecName)) {
                Assertions.checkNotNull(this.extraData);
                ParsableByteArray parsableByteArray = new ParsableByteArray(this.extraData);
                parsableByteArray.setPosition(this.extraData.length - 4);
                this.sampleRate = parsableByteArray.readUnsignedIntToInt();
            }
            this.hasOutputFormat = true;
        }
        byteBufferInit.position(0);
        byteBufferInit.limit(iFfmpegDecode);
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() throws InterruptedException {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0L;
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getEncoding() {
        return this.encoding;
    }

    private static byte[] getExtraData(String mimeType, List<byte[]> initializationData) {
        mimeType.hashCode();
        switch (mimeType) {
            case "audio/vorbis":
                return getVorbisExtraData(initializationData);
            case "audio/mp4a-latm":
            case "audio/opus":
                return initializationData.get(0);
            case "audio/alac":
                return getAlacExtraData(initializationData);
            default:
                return null;
        }
    }

    private static byte[] getAlacExtraData(List<byte[]> initializationData) {
        byte[] bArr = initializationData.get(0);
        int length = bArr.length + 12;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1634492771);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(bArr, 0, bArr.length);
        return byteBufferAllocate.array();
    }

    private static byte[] getVorbisExtraData(List<byte[]> initializationData) {
        byte[] bArr = initializationData.get(0);
        byte[] bArr2 = initializationData.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length + 6];
        bArr3[0] = (byte) (bArr.length >> 8);
        bArr3[1] = (byte) (bArr.length & KotlinVersion.MAX_COMPONENT_VALUE);
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        bArr3[bArr.length + 2] = 0;
        bArr3[bArr.length + 3] = 0;
        bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
        bArr3[bArr.length + 5] = (byte) (bArr2.length & KotlinVersion.MAX_COMPONENT_VALUE);
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
        return bArr3;
    }
}
