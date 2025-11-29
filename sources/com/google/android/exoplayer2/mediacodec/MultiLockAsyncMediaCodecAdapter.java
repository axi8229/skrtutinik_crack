package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.IntArrayQueue;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
final class MultiLockAsyncMediaCodecAdapter extends MediaCodec.Callback implements MediaCodecAdapter {
    private final IntArrayQueue availableInputBuffers;
    private final IntArrayQueue availableOutputBuffers;
    private final MediaCodecInputBufferEnqueuer bufferEnqueuer;
    private final ArrayDeque<MediaCodec.BufferInfo> bufferInfos;
    private final MediaCodec codec;
    private IllegalStateException codecException;
    private Runnable codecStartRunnable;
    private MediaFormat currentFormat;
    private final ArrayDeque<MediaFormat> formats;
    private Handler handler;
    private final HandlerThread handlerThread;
    private final Object inputBufferLock;
    private final Object objectStateLock;
    private final Object outputBufferLock;
    private long pendingFlush;
    private int state;

    MultiLockAsyncMediaCodecAdapter(MediaCodec codec, int trackType) {
        this(codec, false, trackType, new HandlerThread(createThreadLabel(trackType)));
    }

    MultiLockAsyncMediaCodecAdapter(MediaCodec codec, boolean enableAsynchronousQueueing, int trackType) {
        this(codec, enableAsynchronousQueueing, trackType, new HandlerThread(createThreadLabel(trackType)));
    }

    MultiLockAsyncMediaCodecAdapter(MediaCodec codec, boolean enableAsynchronousQueueing, int trackType, HandlerThread handlerThread) {
        this.codec = codec;
        this.inputBufferLock = new Object();
        this.outputBufferLock = new Object();
        this.objectStateLock = new Object();
        this.availableInputBuffers = new IntArrayQueue();
        this.availableOutputBuffers = new IntArrayQueue();
        this.bufferInfos = new ArrayDeque<>();
        this.formats = new ArrayDeque<>();
        this.codecException = null;
        this.handlerThread = handlerThread;
        codec.getClass();
        this.codecStartRunnable = new AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda1(codec);
        if (enableAsynchronousQueueing) {
            this.bufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(codec, trackType);
        } else {
            this.bufferEnqueuer = new SynchronousMediaCodecBufferEnqueuer(codec);
        }
        this.state = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void start() {
        synchronized (this.objectStateLock) {
            this.handlerThread.start();
            Handler handler = new Handler(this.handlerThread.getLooper());
            this.handler = handler;
            this.codec.setCallback(this, handler);
            this.bufferEnqueuer.start();
            this.codecStartRunnable.run();
            this.state = 1;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueInputBufferIndex() {
        synchronized (this.objectStateLock) {
            try {
                if (isFlushing()) {
                    return -1;
                }
                maybeThrowException();
                return dequeueAvailableInputBufferIndex();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.objectStateLock) {
            try {
                if (isFlushing()) {
                    return -1;
                }
                maybeThrowException();
                return dequeueAvailableOutputBufferIndex(bufferInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        synchronized (this.objectStateLock) {
            try {
                mediaFormat = this.currentFormat;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
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
    public void flush() {
        synchronized (this.objectStateLock) {
            this.bufferEnqueuer.flush();
            this.codec.flush();
            this.pendingFlush++;
            ((Handler) Util.castNonNull(this.handler)).post(new Runnable() { // from class: com.google.android.exoplayer2.mediacodec.MultiLockAsyncMediaCodecAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onFlushComplete();
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void shutdown() {
        synchronized (this.objectStateLock) {
            try {
                if (this.state == 1) {
                    this.bufferEnqueuer.shutdown();
                    this.handlerThread.quit();
                }
                this.state = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int dequeueAvailableInputBufferIndex() {
        int iRemove;
        synchronized (this.inputBufferLock) {
            iRemove = this.availableInputBuffers.isEmpty() ? -1 : this.availableInputBuffers.remove();
        }
        return iRemove;
    }

    private int dequeueAvailableOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int i;
        synchronized (this.outputBufferLock) {
            try {
                if (this.availableOutputBuffers.isEmpty()) {
                    i = -1;
                } else {
                    int iRemove = this.availableOutputBuffers.remove();
                    if (iRemove == -2) {
                        this.currentFormat = this.formats.remove();
                    } else if (iRemove >= 0) {
                        MediaCodec.BufferInfo bufferInfoRemove = this.bufferInfos.remove();
                        bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
                    }
                    i = iRemove;
                }
            } finally {
            }
        }
        return i;
    }

    private boolean isFlushing() {
        return this.pendingFlush > 0;
    }

    private void maybeThrowException() {
        IllegalStateException illegalStateException = this.codecException;
        if (illegalStateException == null) {
            return;
        }
        this.codecException = null;
        throw illegalStateException;
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec codec, int index) {
        synchronized (this.inputBufferLock) {
            this.availableInputBuffers.add(index);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec codec, int index, MediaCodec.BufferInfo info) {
        synchronized (this.outputBufferLock) {
            this.availableOutputBuffers.add(index);
            this.bufferInfos.add(info);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec codec, MediaCodec.CodecException e) {
        onMediaCodecError(e);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec codec, MediaFormat format) {
        synchronized (this.outputBufferLock) {
            this.availableOutputBuffers.add(-2);
            this.formats.add(format);
        }
    }

    void onMediaCodecError(IllegalStateException e) {
        synchronized (this.objectStateLock) {
            this.codecException = e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFlushComplete() {
        synchronized (this.objectStateLock) {
            try {
                if (this.state == 2) {
                    return;
                }
                long j = this.pendingFlush - 1;
                this.pendingFlush = j;
                if (j > 0) {
                    return;
                }
                if (j < 0) {
                    this.codecException = new IllegalStateException();
                    return;
                }
                clearAvailableInput();
                clearAvailableOutput();
                this.codecException = null;
                try {
                    this.codecStartRunnable.run();
                } catch (IllegalStateException e) {
                    this.codecException = e;
                } catch (Exception e2) {
                    this.codecException = new IllegalStateException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void clearAvailableInput() {
        synchronized (this.inputBufferLock) {
            this.availableInputBuffers.clear();
        }
    }

    private void clearAvailableOutput() {
        synchronized (this.outputBufferLock) {
            this.availableOutputBuffers.clear();
            this.bufferInfos.clear();
            this.formats.clear();
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
