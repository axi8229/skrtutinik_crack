package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {
    private int bytesPerFrame;
    private boolean enabled;
    private boolean hasOutputNoise;
    private byte[] maybeSilenceBuffer;
    private int maybeSilenceBufferSize;
    private byte[] paddingBuffer;
    private int paddingSize;
    private long skippedFrames;
    private int state;

    public SilenceSkippingAudioProcessor() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        this.maybeSilenceBuffer = bArr;
        this.paddingBuffer = bArr;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public long getSkippedFrames() {
        return this.skippedFrames;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat inputAudioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (inputAudioFormat.encoding == 2) {
            return this.enabled ? inputAudioFormat : AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(inputAudioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.enabled;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer inputBuffer) {
        while (inputBuffer.hasRemaining() && !hasPendingOutput()) {
            int i = this.state;
            if (i == 0) {
                processNoisy(inputBuffer);
            } else if (i == 1) {
                processMaybeSilence(inputBuffer);
            } else if (i == 2) {
                processSilence(inputBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    protected void onQueueEndOfStream() {
        int i = this.maybeSilenceBufferSize;
        if (i > 0) {
            output(this.maybeSilenceBuffer, i);
        }
        if (this.hasOutputNoise) {
            return;
        }
        this.skippedFrames += this.paddingSize / this.bytesPerFrame;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    protected void onFlush() {
        if (this.enabled) {
            this.bytesPerFrame = this.inputAudioFormat.bytesPerFrame;
            int iDurationUsToFrames = durationUsToFrames(150000L) * this.bytesPerFrame;
            if (this.maybeSilenceBuffer.length != iDurationUsToFrames) {
                this.maybeSilenceBuffer = new byte[iDurationUsToFrames];
            }
            int iDurationUsToFrames2 = durationUsToFrames(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) * this.bytesPerFrame;
            this.paddingSize = iDurationUsToFrames2;
            if (this.paddingBuffer.length != iDurationUsToFrames2) {
                this.paddingBuffer = new byte[iDurationUsToFrames2];
            }
        }
        this.state = 0;
        this.skippedFrames = 0L;
        this.maybeSilenceBufferSize = 0;
        this.hasOutputNoise = false;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    protected void onReset() {
        this.enabled = false;
        this.paddingSize = 0;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        this.maybeSilenceBuffer = bArr;
        this.paddingBuffer = bArr;
    }

    private void processNoisy(ByteBuffer inputBuffer) {
        int iLimit = inputBuffer.limit();
        inputBuffer.limit(Math.min(iLimit, inputBuffer.position() + this.maybeSilenceBuffer.length));
        int iFindNoiseLimit = findNoiseLimit(inputBuffer);
        if (iFindNoiseLimit == inputBuffer.position()) {
            this.state = 1;
        } else {
            inputBuffer.limit(iFindNoiseLimit);
            output(inputBuffer);
        }
        inputBuffer.limit(iLimit);
    }

    private void processMaybeSilence(ByteBuffer inputBuffer) {
        int iLimit = inputBuffer.limit();
        int iFindNoisePosition = findNoisePosition(inputBuffer);
        int iPosition = iFindNoisePosition - inputBuffer.position();
        byte[] bArr = this.maybeSilenceBuffer;
        int length = bArr.length;
        int i = this.maybeSilenceBufferSize;
        int i2 = length - i;
        if (iFindNoisePosition < iLimit && iPosition < i2) {
            output(bArr, i);
            this.maybeSilenceBufferSize = 0;
            this.state = 0;
            return;
        }
        int iMin = Math.min(iPosition, i2);
        inputBuffer.limit(inputBuffer.position() + iMin);
        inputBuffer.get(this.maybeSilenceBuffer, this.maybeSilenceBufferSize, iMin);
        int i3 = this.maybeSilenceBufferSize + iMin;
        this.maybeSilenceBufferSize = i3;
        byte[] bArr2 = this.maybeSilenceBuffer;
        if (i3 == bArr2.length) {
            if (this.hasOutputNoise) {
                output(bArr2, this.paddingSize);
                this.skippedFrames += (this.maybeSilenceBufferSize - (this.paddingSize * 2)) / this.bytesPerFrame;
            } else {
                this.skippedFrames += (i3 - this.paddingSize) / this.bytesPerFrame;
            }
            updatePaddingBuffer(inputBuffer, this.maybeSilenceBuffer, this.maybeSilenceBufferSize);
            this.maybeSilenceBufferSize = 0;
            this.state = 2;
        }
        inputBuffer.limit(iLimit);
    }

    private void processSilence(ByteBuffer inputBuffer) {
        int iLimit = inputBuffer.limit();
        int iFindNoisePosition = findNoisePosition(inputBuffer);
        inputBuffer.limit(iFindNoisePosition);
        this.skippedFrames += inputBuffer.remaining() / this.bytesPerFrame;
        updatePaddingBuffer(inputBuffer, this.paddingBuffer, this.paddingSize);
        if (iFindNoisePosition < iLimit) {
            output(this.paddingBuffer, this.paddingSize);
            this.state = 0;
            inputBuffer.limit(iLimit);
        }
    }

    private void output(byte[] data, int length) {
        replaceOutputBuffer(length).put(data, 0, length).flip();
        if (length > 0) {
            this.hasOutputNoise = true;
        }
    }

    private void output(ByteBuffer data) {
        int iRemaining = data.remaining();
        replaceOutputBuffer(iRemaining).put(data).flip();
        if (iRemaining > 0) {
            this.hasOutputNoise = true;
        }
    }

    private void updatePaddingBuffer(ByteBuffer input, byte[] buffer, int size) {
        int iMin = Math.min(input.remaining(), this.paddingSize);
        int i = this.paddingSize - iMin;
        System.arraycopy(buffer, size - i, this.paddingBuffer, 0, i);
        input.position(input.limit() - iMin);
        input.get(this.paddingBuffer, i, iMin);
    }

    private int durationUsToFrames(long durationUs) {
        return (int) ((durationUs * this.inputAudioFormat.sampleRate) / 1000000);
    }

    private int findNoisePosition(ByteBuffer buffer) {
        for (int iPosition = buffer.position() + 1; iPosition < buffer.limit(); iPosition += 2) {
            if (Math.abs((int) buffer.get(iPosition)) > 4) {
                int i = this.bytesPerFrame;
                return i * (iPosition / i);
            }
        }
        return buffer.limit();
    }

    private int findNoiseLimit(ByteBuffer buffer) {
        for (int iLimit = buffer.limit() - 1; iLimit >= buffer.position(); iLimit -= 2) {
            if (Math.abs((int) buffer.get(iLimit)) > 4) {
                int i = this.bytesPerFrame;
                return ((iLimit / i) * i) + i;
            }
        }
        return buffer.position();
    }
}
