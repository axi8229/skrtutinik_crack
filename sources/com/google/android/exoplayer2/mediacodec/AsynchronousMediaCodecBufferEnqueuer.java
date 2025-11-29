package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
class AsynchronousMediaCodecBufferEnqueuer implements MediaCodecInputBufferEnqueuer {
    private static final ArrayDeque<MessageParams> MESSAGE_PARAMS_INSTANCE_POOL = new ArrayDeque<>();
    private static final Object QUEUE_SECURE_LOCK = new Object();
    private final MediaCodec codec;
    private final ConditionVariable conditionVariable;
    private Handler handler;
    private final HandlerThread handlerThread;
    private final boolean needsSynchronizationWorkaround;
    private final AtomicReference<RuntimeException> pendingRuntimeException;
    private boolean started;

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec codec, int trackType) {
        this(codec, new HandlerThread(createThreadLabel(trackType)), new ConditionVariable());
    }

    AsynchronousMediaCodecBufferEnqueuer(MediaCodec codec, HandlerThread handlerThread, ConditionVariable conditionVariable) {
        this.codec = codec;
        this.handlerThread = handlerThread;
        this.conditionVariable = conditionVariable;
        this.pendingRuntimeException = new AtomicReference<>();
        this.needsSynchronizationWorkaround = needsSynchronizationWorkaround();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void start() {
        if (this.started) {
            return;
        }
        this.handlerThread.start();
        this.handler = new Handler(this.handlerThread.getLooper()) { // from class: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) throws MediaCodec.CryptoException {
                AsynchronousMediaCodecBufferEnqueuer.this.doHandleMessage(msg);
            }
        };
        this.started = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(index, offset, size, presentationTimeUs, flags);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(0, messageParams).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueSecureInputBuffer(int index, int offset, CryptoInfo info, long presentationTimeUs, int flags) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(index, offset, 0, presentationTimeUs, flags);
        copy(info, messageParams.cryptoInfo);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(1, messageParams).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void flush() {
        if (this.started) {
            try {
                flushHandlerThread();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void shutdown() {
        if (this.started) {
            flush();
            this.handlerThread.quit();
        }
        this.started = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doHandleMessage(Message msg) throws MediaCodec.CryptoException {
        MessageParams messageParams;
        int i = msg.what;
        if (i == 0) {
            messageParams = (MessageParams) msg.obj;
            doQueueInputBuffer(messageParams.index, messageParams.offset, messageParams.size, messageParams.presentationTimeUs, messageParams.flags);
        } else if (i != 1) {
            if (i == 2) {
                this.conditionVariable.open();
            } else {
                setPendingRuntimeException(new IllegalStateException(String.valueOf(msg.what)));
            }
            messageParams = null;
        } else {
            messageParams = (MessageParams) msg.obj;
            doQueueSecureInputBuffer(messageParams.index, messageParams.offset, messageParams.cryptoInfo, messageParams.presentationTimeUs, messageParams.flags);
        }
        if (messageParams != null) {
            recycleMessageParams(messageParams);
        }
    }

    private void maybeThrowException() {
        RuntimeException andSet = this.pendingRuntimeException.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    private void flushHandlerThread() throws InterruptedException {
        Handler handler = (Handler) Util.castNonNull(this.handler);
        handler.removeCallbacksAndMessages(null);
        this.conditionVariable.close();
        handler.obtainMessage(2).sendToTarget();
        this.conditionVariable.block();
        maybeThrowException();
    }

    void setPendingRuntimeException(RuntimeException exception) {
        this.pendingRuntimeException.set(exception);
    }

    private void doQueueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flag) throws MediaCodec.CryptoException {
        try {
            this.codec.queueInputBuffer(index, offset, size, presentationTimeUs, flag);
        } catch (RuntimeException e) {
            setPendingRuntimeException(e);
        }
    }

    private void doQueueSecureInputBuffer(int index, int offset, MediaCodec.CryptoInfo info, long presentationTimeUs, int flags) throws MediaCodec.CryptoException {
        try {
            if (this.needsSynchronizationWorkaround) {
                synchronized (QUEUE_SECURE_LOCK) {
                    this.codec.queueSecureInputBuffer(index, offset, info, presentationTimeUs, flags);
                }
                return;
            }
            this.codec.queueSecureInputBuffer(index, offset, info, presentationTimeUs, flags);
        } catch (RuntimeException e) {
            setPendingRuntimeException(e);
        }
    }

    private static MessageParams getMessageParams() {
        ArrayDeque<MessageParams> arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new MessageParams();
                }
                return arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void recycleMessageParams(MessageParams params) {
        ArrayDeque<MessageParams> arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            arrayDeque.add(params);
        }
    }

    private static class MessageParams {
        public final MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        public int flags;
        public int index;
        public int offset;
        public long presentationTimeUs;
        public int size;

        MessageParams() {
        }

        public void setQueueParams(int index, int offset, int size, long presentationTimeUs, int flags) {
            this.index = index;
            this.offset = offset;
            this.size = size;
            this.presentationTimeUs = presentationTimeUs;
            this.flags = flags;
        }
    }

    private static boolean needsSynchronizationWorkaround() {
        String lowerInvariant = Util.toLowerInvariant(Util.MANUFACTURER);
        return lowerInvariant.contains("samsung") || lowerInvariant.contains("motorola");
    }

    private static String createThreadLabel(int trackType) {
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecBufferEnqueuer:");
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

    private static void copy(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo frameworkCryptoInfo) {
        frameworkCryptoInfo.numSubSamples = cryptoInfo.numSubSamples;
        frameworkCryptoInfo.numBytesOfClearData = copy(cryptoInfo.numBytesOfClearData, frameworkCryptoInfo.numBytesOfClearData);
        frameworkCryptoInfo.numBytesOfEncryptedData = copy(cryptoInfo.numBytesOfEncryptedData, frameworkCryptoInfo.numBytesOfEncryptedData);
        frameworkCryptoInfo.key = copy(cryptoInfo.key, frameworkCryptoInfo.key);
        frameworkCryptoInfo.iv = copy(cryptoInfo.iv, frameworkCryptoInfo.iv);
        frameworkCryptoInfo.mode = cryptoInfo.mode;
        if (Util.SDK_INT >= 24) {
            frameworkCryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.encryptedBlocks, cryptoInfo.clearBlocks));
        }
    }

    private static int[] copy(int[] src, int[] dst) {
        if (src == null) {
            return dst;
        }
        if (dst == null || dst.length < src.length) {
            return Arrays.copyOf(src, src.length);
        }
        System.arraycopy(src, 0, dst, 0, src.length);
        return dst;
    }

    private static byte[] copy(byte[] src, byte[] dst) {
        if (src == null) {
            return dst;
        }
        if (dst == null || dst.length < src.length) {
            return Arrays.copyOf(src, src.length);
        }
        System.arraycopy(src, 0, dst, 0, src.length);
        return dst;
    }
}
