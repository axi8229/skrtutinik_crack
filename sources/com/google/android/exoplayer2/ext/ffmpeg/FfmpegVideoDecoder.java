package com.google.android.exoplayer2.ext.ffmpeg;

import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderInputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBuffer;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
final class FfmpegVideoDecoder extends SimpleDecoder<VideoDecoderInputBuffer, VideoDecoderOutputBuffer, FfmpegDecoderException> {
    private final String codecName;
    private final byte[] extraData;
    private Format format;
    private long nativeContext;
    private volatile int outputMode;

    private native long ffmpegInitialize(String codecName, byte[] extraData, int threads);

    private native int ffmpegReceiveFrame(long context, int outputMode, VideoDecoderOutputBuffer outputBuffer, boolean decodeOnly);

    private native void ffmpegRelease(long context);

    private native void ffmpegReleaseFrame(long context, VideoDecoderOutputBuffer outputBuffer);

    private native int ffmpegRenderFrame(long context, Surface surface, VideoDecoderOutputBuffer outputBuffer, int displayedWidth, int displayedHeight);

    private native long ffmpegReset(long context);

    private native int ffmpegSendPacket(long context, ByteBuffer encodedData, int length, long inputTime);

    public FfmpegVideoDecoder(int numInputBuffers, int numOutputBuffers, int initialInputBufferSize, int threads, Format format) throws FfmpegDecoderException {
        super(new VideoDecoderInputBuffer[numInputBuffers], new VideoDecoderOutputBuffer[numOutputBuffers]);
        if (!FfmpegLibrary.isAvailable()) {
            throw new FfmpegDecoderException("Failed to load decoder native library.");
        }
        String str = (String) Assertions.checkNotNull(FfmpegLibrary.getCodecName(format.sampleMimeType));
        this.codecName = str;
        byte[] extraData = getExtraData(format.sampleMimeType, format.initializationData);
        this.extraData = extraData;
        this.format = format;
        long jFfmpegInitialize = ffmpegInitialize(str, extraData, threads);
        this.nativeContext = jFfmpegInitialize;
        if (jFfmpegInitialize == 0) {
            throw new FfmpegDecoderException("Failed to initialize decoder.");
        }
        setInitialInputBufferSize(initialInputBufferSize);
    }

    private static byte[] getExtraData(String mimeType, List<byte[]> initializationData) {
        mimeType.hashCode();
        if (mimeType.equals("video/hevc")) {
            return initializationData.get(0);
        }
        if (!mimeType.equals("video/avc")) {
            return null;
        }
        byte[] bArr = initializationData.get(0);
        byte[] bArr2 = initializationData.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "ffmpeg" + FfmpegLibrary.getVersion() + "-" + this.codecName;
    }

    public void setOutputMode(int outputMode) {
        this.outputMode = outputMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public VideoDecoderInputBuffer createInputBuffer() {
        return new VideoDecoderInputBuffer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public VideoDecoderOutputBuffer createOutputBuffer() {
        return new VideoDecoderOutputBuffer(new OutputBuffer.Owner() { // from class: com.google.android.exoplayer2.ext.ffmpeg.FfmpegVideoDecoder$$ExternalSyntheticLambda0
            @Override // com.google.android.exoplayer2.decoder.OutputBuffer.Owner
            public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
                this.f$0.releaseOutputBuffer((VideoDecoderOutputBuffer) outputBuffer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public FfmpegDecoderException decode(VideoDecoderInputBuffer inputBuffer, VideoDecoderOutputBuffer outputBuffer, boolean reset) {
        if (reset) {
            long jFfmpegReset = ffmpegReset(this.nativeContext);
            this.nativeContext = jFfmpegReset;
            if (jFfmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) Util.castNonNull(inputBuffer.data);
        int iFfmpegSendPacket = ffmpegSendPacket(this.nativeContext, byteBuffer, byteBuffer.limit(), inputBuffer.timeUs);
        if (iFfmpegSendPacket == -1) {
            outputBuffer.setFlags(Integer.MIN_VALUE);
            return null;
        }
        if (iFfmpegSendPacket == -3) {
            Log.d("FfmpegVideoDecoder", "VIDEO_DECODER_ERROR_READ_FRAME: timeUs=" + inputBuffer.timeUs);
        } else if (iFfmpegSendPacket == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        boolean zIsDecodeOnly = inputBuffer.isDecodeOnly();
        int iFfmpegReceiveFrame = ffmpegReceiveFrame(this.nativeContext, this.outputMode, outputBuffer, zIsDecodeOnly);
        if (iFfmpegReceiveFrame == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        if (iFfmpegReceiveFrame == -1) {
            outputBuffer.addFlag(Integer.MIN_VALUE);
        }
        if (!zIsDecodeOnly) {
            outputBuffer.colorInfo = inputBuffer.colorInfo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public FfmpegDecoderException createUnexpectedDecodeException(Throwable error) {
        return new FfmpegDecoderException("Unexpected decode error", error);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() throws InterruptedException {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0L;
    }

    public void renderToSurface(VideoDecoderOutputBuffer outputBuffer, Surface surface) throws FfmpegDecoderException {
        if (outputBuffer.mode != 1) {
            throw new FfmpegDecoderException("Invalid output mode.");
        }
        if (ffmpegRenderFrame(this.nativeContext, surface, outputBuffer, outputBuffer.width, outputBuffer.height) == -2) {
            throw new FfmpegDecoderException("Buffer render error: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public void releaseOutputBuffer(VideoDecoderOutputBuffer buffer) {
        if (buffer.mode == 1 && !buffer.isDecodeOnly()) {
            ffmpegReleaseFrame(this.nativeContext, buffer);
        }
        super.releaseOutputBuffer((FfmpegVideoDecoder) buffer);
    }
}
