package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.android.exoplayer2.decoder.CryptoInfo;

/* loaded from: classes2.dex */
final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private final MediaCodec codec;

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void shutdown() {
    }

    public SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.codec = mediaCodec;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void start() {
        this.codec.start();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueInputBufferIndex() {
        return this.codec.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        return this.codec.dequeueOutputBuffer(bufferInfo, 0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        return this.codec.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags) throws MediaCodec.CryptoException {
        this.codec.queueInputBuffer(index, offset, size, presentationTimeUs, flags);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueSecureInputBuffer(int index, int offset, CryptoInfo info, long presentationTimeUs, int flags) throws MediaCodec.CryptoException {
        this.codec.queueSecureInputBuffer(index, offset, info.getFrameworkCryptoInfo(), presentationTimeUs, flags);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void flush() {
        this.codec.flush();
    }
}
