package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
final class ResamplingAudioProcessor extends BaseAudioProcessor {
    ResamplingAudioProcessor() {
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat inputAudioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i = inputAudioFormat.encoding;
        if (i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4) {
            return i != 2 ? new AudioProcessor.AudioFormat(inputAudioFormat.sampleRate, inputAudioFormat.channelCount, 2) : AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(inputAudioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer inputBuffer) {
        int iPosition = inputBuffer.position();
        int iLimit = inputBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.inputAudioFormat.encoding;
        if (i2 == 3) {
            i *= 2;
        } else if (i2 == 4) {
            i /= 2;
        } else if (i2 != 268435456) {
            if (i2 == 536870912) {
                i /= 3;
                i *= 2;
            } else {
                if (i2 != 805306368) {
                    throw new IllegalStateException();
                }
                i /= 2;
            }
        }
        ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(i);
        int i3 = this.inputAudioFormat.encoding;
        if (i3 == 3) {
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put((byte) 0);
                byteBufferReplaceOutputBuffer.put((byte) ((inputBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else if (i3 == 4) {
            while (iPosition < iLimit) {
                short s = (short) (inputBuffer.getFloat(iPosition) * 32767.0f);
                byteBufferReplaceOutputBuffer.put((byte) (s & 255));
                byteBufferReplaceOutputBuffer.put((byte) ((s >> 8) & KotlinVersion.MAX_COMPONENT_VALUE));
                iPosition += 4;
            }
        } else if (i3 == 268435456) {
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put(inputBuffer.get(iPosition + 1));
                byteBufferReplaceOutputBuffer.put(inputBuffer.get(iPosition));
                iPosition += 2;
            }
        } else if (i3 == 536870912) {
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put(inputBuffer.get(iPosition + 1));
                byteBufferReplaceOutputBuffer.put(inputBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else {
            if (i3 != 805306368) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put(inputBuffer.get(iPosition + 2));
                byteBufferReplaceOutputBuffer.put(inputBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        }
        inputBuffer.position(inputBuffer.limit());
        byteBufferReplaceOutputBuffer.flip();
    }
}
