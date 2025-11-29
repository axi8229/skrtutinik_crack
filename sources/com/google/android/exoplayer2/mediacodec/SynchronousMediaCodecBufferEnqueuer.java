package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.CryptoInfo;

/* loaded from: classes2.dex */
class SynchronousMediaCodecBufferEnqueuer implements MediaCodecInputBufferEnqueuer {
    private final MediaCodec codec;

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void flush() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void shutdown() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void start() {
    }

    SynchronousMediaCodecBufferEnqueuer(MediaCodec codec) {
        this.codec = codec;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags) throws MediaCodec.CryptoException {
        this.codec.queueInputBuffer(index, offset, size, presentationTimeUs, flags);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueSecureInputBuffer(int index, int offset, CryptoInfo info, long presentationTimeUs, int flags) throws MediaCodec.CryptoException {
        this.codec.queueSecureInputBuffer(index, offset, info.getFrameworkCryptoInfo(), presentationTimeUs, flags);
    }
}
