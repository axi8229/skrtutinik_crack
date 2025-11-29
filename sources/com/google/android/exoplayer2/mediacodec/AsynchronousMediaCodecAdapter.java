package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private final MediaCodec codec;
    private Runnable codecStartRunnable;
    private boolean flushing;
    private final Handler handler;
    private IllegalStateException internalException;
    private final MediaCodecAsyncCallback mediaCodecAsyncCallback;

    public AsynchronousMediaCodecAdapter(MediaCodec codec) {
        this(codec, (Looper) Assertions.checkNotNull(Looper.myLooper()));
    }

    AsynchronousMediaCodecAdapter(MediaCodec codec, Looper looper) {
        MediaCodecAsyncCallback mediaCodecAsyncCallback = new MediaCodecAsyncCallback();
        this.mediaCodecAsyncCallback = mediaCodecAsyncCallback;
        this.handler = new Handler(looper);
        this.codec = codec;
        codec.setCallback(mediaCodecAsyncCallback);
        codec.getClass();
        this.codecStartRunnable = new AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda1(codec);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void start() {
        this.codecStartRunnable.run();
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
    public int dequeueInputBufferIndex() throws IllegalStateException {
        if (this.flushing) {
            return -1;
        }
        maybeThrowException();
        return this.mediaCodecAsyncCallback.dequeueInputBufferIndex();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) throws IllegalStateException {
        if (this.flushing) {
            return -1;
        }
        maybeThrowException();
        return this.mediaCodecAsyncCallback.dequeueOutputBufferIndex(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        return this.mediaCodecAsyncCallback.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void flush() {
        clearPendingFlushState();
        this.flushing = true;
        this.codec.flush();
        this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onCompleteFlush();
            }
        });
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void shutdown() {
        clearPendingFlushState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteFlush() {
        this.flushing = false;
        this.mediaCodecAsyncCallback.flush();
        try {
            this.codecStartRunnable.run();
        } catch (IllegalStateException e) {
            this.internalException = e;
        } catch (Exception e2) {
            this.internalException = new IllegalStateException(e2);
        }
    }

    private void maybeThrowException() throws IllegalStateException {
        maybeThrowInternalException();
        this.mediaCodecAsyncCallback.maybeThrowMediaCodecException();
    }

    private void maybeThrowInternalException() {
        IllegalStateException illegalStateException = this.internalException;
        if (illegalStateException == null) {
            return;
        }
        this.internalException = null;
        throw illegalStateException;
    }

    private void clearPendingFlushState() {
        this.handler.removeCallbacksAndMessages(null);
        this.internalException = null;
    }
}
