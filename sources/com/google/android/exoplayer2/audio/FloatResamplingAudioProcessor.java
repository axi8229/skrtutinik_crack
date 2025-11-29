package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class FloatResamplingAudioProcessor extends BaseAudioProcessor {
    private static final int FLOAT_NAN_AS_INT = Float.floatToIntBits(Float.NaN);

    FloatResamplingAudioProcessor() {
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat inputAudioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i = inputAudioFormat.encoding;
        if (Util.isEncodingHighResolutionPcm(i)) {
            return i != 4 ? new AudioProcessor.AudioFormat(inputAudioFormat.sampleRate, inputAudioFormat.channelCount, 4) : AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(inputAudioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer inputBuffer) {
        ByteBuffer byteBufferReplaceOutputBuffer;
        int iPosition = inputBuffer.position();
        int iLimit = inputBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.inputAudioFormat.encoding;
        if (i2 == 536870912) {
            byteBufferReplaceOutputBuffer = replaceOutputBuffer((i / 3) * 4);
            while (iPosition < iLimit) {
                writePcm32BitFloat(((inputBuffer.get(iPosition) & 255) << 8) | ((inputBuffer.get(iPosition + 1) & 255) << 16) | ((inputBuffer.get(iPosition + 2) & 255) << 24), byteBufferReplaceOutputBuffer);
                iPosition += 3;
            }
        } else if (i2 == 805306368) {
            byteBufferReplaceOutputBuffer = replaceOutputBuffer(i);
            while (iPosition < iLimit) {
                writePcm32BitFloat((inputBuffer.get(iPosition) & 255) | ((inputBuffer.get(iPosition + 1) & 255) << 8) | ((inputBuffer.get(iPosition + 2) & 255) << 16) | ((inputBuffer.get(iPosition + 3) & 255) << 24), byteBufferReplaceOutputBuffer);
                iPosition += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        inputBuffer.position(inputBuffer.limit());
        byteBufferReplaceOutputBuffer.flip();
    }

    private static void writePcm32BitFloat(int pcm32BitInt, ByteBuffer buffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (pcm32BitInt * 4.656612875245797E-10d));
        if (iFloatToIntBits == FLOAT_NAN_AS_INT) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        buffer.putInt(iFloatToIntBits);
    }
}
