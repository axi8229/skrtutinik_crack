package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
final class DedicatedThreadAsyncMediaCodecAdapter extends MediaCodec.Callback implements MediaCodecAdapter {
    private final MediaCodecInputBufferEnqueuer bufferEnqueuer;
    private final MediaCodec codec;
    private Runnable codecStartRunnable;
    private Handler handler;
    private final HandlerThread handlerThread;
    private IllegalStateException internalException;
    private final MediaCodecAsyncCallback mediaCodecAsyncCallback;
    private long pendingFlushCount;
    private int state;

    DedicatedThreadAsyncMediaCodecAdapter(MediaCodec codec, int trackType) {
        this(codec, false, trackType, new HandlerThread(createThreadLabel(trackType)));
    }

    DedicatedThreadAsyncMediaCodecAdapter(MediaCodec codec, boolean enableAsynchronousQueueing, int trackType) {
        this(codec, enableAsynchronousQueueing, trackType, new HandlerThread(createThreadLabel(trackType)));
    }

    DedicatedThreadAsyncMediaCodecAdapter(MediaCodec codec, boolean enableAsynchronousQueueing, int trackType, HandlerThread handlerThread) {
        this.mediaCodecAsyncCallback = new MediaCodecAsyncCallback();
        this.codec = codec;
        this.handlerThread = handlerThread;
        this.state = 0;
        codec.getClass();
        this.codecStartRunnable = new AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda1(codec);
        if (enableAsynchronousQueueing) {
            this.bufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(codec, trackType);
        } else {
            this.bufferEnqueuer = new SynchronousMediaCodecBufferEnqueuer(codec);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public synchronized void start() {
        this.handlerThread.start();
        Handler handler = new Handler(this.handlerThread.getLooper());
        this.handler = handler;
        this.codec.setCallback(this, handler);
        this.bufferEnqueuer.start();
        this.codecStartRunnable.run();
        this.state = 1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags) {
        this.bufferEnqueuer.queueInputBuffer(index, offset, size, presentationTimeUs, flags);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueSecureInputBuffer(int index, int offset, CryptoInfo info, long presentationTimeUs, int flags) {
        this.bufferEnqueuer.queueSecureInputBuffer(index, offset, info, presentationTimeUs, flags);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public synchronized int dequeueInputBufferIndex() {
        if (isFlushing()) {
            return -1;
        }
        maybeThrowException();
        return this.mediaCodecAsyncCallback.dequeueInputBufferIndex();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public synchronized int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        if (isFlushing()) {
            return -1;
        }
        maybeThrowException();
        return this.mediaCodecAsyncCallback.dequeueOutputBufferIndex(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public synchronized MediaFormat getOutputFormat() {
        return this.mediaCodecAsyncCallback.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public synchronized void flush() {
        this.bufferEnqueuer.flush();
        this.codec.flush();
        this.pendingFlushCount++;
        ((Handler) Util.castNonNull(this.handler)).post(new Runnable() { // from class: com.google.android.exoplayer2.mediacodec.DedicatedThreadAsyncMediaCodecAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onFlushCompleted();
            }
        });
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public synchronized void shutdown() {
        try {
            if (this.state == 1) {
                this.bufferEnqueuer.shutdown();
                this.handlerThread.quit();
                this.mediaCodecAsyncCallback.flush();
            }
            this.state = 2;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public synchronized void onInputBufferAvailable(MediaCodec codec, int index) {
        this.mediaCodecAsyncCallback.onInputBufferAvailable(codec, index);
    }

    @Override // android.media.MediaCodec.Callback
    public synchronized void onOutputBufferAvailable(MediaCodec codec, int index, MediaCodec.BufferInfo info) {
        this.mediaCodecAsyncCallback.onOutputBufferAvailable(codec, index, info);
    }

    @Override // android.media.MediaCodec.Callback
    public synchronized void onError(MediaCodec codec, MediaCodec.CodecException e) {
        this.mediaCodecAsyncCallback.onError(codec, e);
    }

    @Override // android.media.MediaCodec.Callback
    public synchronized void onOutputFormatChanged(MediaCodec codec, MediaFormat format) {
        this.mediaCodecAsyncCallback.onOutputFormatChanged(codec, format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onFlushCompleted() {
        if (this.state != 1) {
            return;
        }
        long j = this.pendingFlushCount - 1;
        this.pendingFlushCount = j;
        if (j > 0) {
            return;
        }
        if (j < 0) {
            this.internalException = new IllegalStateException();
            return;
        }
        this.mediaCodecAsyncCallback.flush();
        try {
            try {
                this.codecStartRunnable.run();
            } catch (Exception e) {
                this.internalException = new IllegalStateException(e);
            }
        } catch (IllegalStateException e2) {
            this.internalException = e2;
        }
    }

    private synchronized boolean isFlushing() {
        return this.pendingFlushCount > 0;
    }

    private synchronized void maybeThrowException() {
        maybeThrowInternalException();
        this.mediaCodecAsyncCallback.maybeThrowMediaCodecException();
    }

    private synchronized void maybeThrowInternalException() {
        IllegalStateException illegalStateException = this.internalException;
        if (illegalStateException != null) {
            this.internalException = null;
            throw illegalStateException;
        }
    }

    private static String createThreadLabel(int trackType) {
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecAsyncAdapter:");
        if (trackType == 1) {
            sb.append("Audio");
        } else if (trackType == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(trackType);
            sb.append(")");
        }
        return sb.toString();
    }
}
