package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.Exception;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends Exception> implements Decoder<I, O, E> {
    private int availableInputBufferCount;
    private final I[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final O[] availableOutputBuffers;
    private final Thread decodeThread;
    private I dequeuedInputBuffer;
    private E exception;
    private boolean flushed;
    private boolean released;
    private int skippedOutputBufferCount;
    private long deadLinePositionUs = -1;
    private final Object lock = new Object();
    private final ArrayDeque<I> queuedInputBuffers = new ArrayDeque<>();
    private final ArrayDeque<O> queuedOutputBuffers = new ArrayDeque<>();

    protected abstract I createInputBuffer();

    protected abstract O createOutputBuffer();

    protected abstract E createUnexpectedDecodeException(Throwable error);

    protected abstract E decode(I inputBuffer, O outputBuffer, boolean reset);

    protected SimpleDecoder(I[] iArr, O[] oArr) {
        this.availableInputBuffers = iArr;
        this.availableInputBufferCount = iArr.length;
        for (int i = 0; i < this.availableInputBufferCount; i++) {
            ((I[]) this.availableInputBuffers)[i] = createInputBuffer();
        }
        this.availableOutputBuffers = oArr;
        this.availableOutputBufferCount = oArr.length;
        for (int i2 = 0; i2 < this.availableOutputBufferCount; i2++) {
            ((O[]) this.availableOutputBuffers)[i2] = createOutputBuffer();
        }
        Thread thread = new Thread("ExoPlayer:SimpleDecoder") { // from class: com.google.android.exoplayer2.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SimpleDecoder.this.run();
            }
        };
        this.decodeThread = thread;
        thread.start();
    }

    protected final void setInitialInputBufferSize(int size) {
        Assertions.checkState(this.availableInputBufferCount == this.availableInputBuffers.length);
        for (I i : this.availableInputBuffers) {
            i.ensureSpaceForWrite(size);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final I dequeueInputBuffer() throws Exception {
        I i;
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkState(this.dequeuedInputBuffer == null);
            int i2 = this.availableInputBufferCount;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.availableInputBuffers;
                int i3 = i2 - 1;
                this.availableInputBufferCount = i3;
                i = iArr[i3];
            }
            this.dequeuedInputBuffer = i;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void queueInputBuffer(I inputBuffer) throws Exception {
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkArgument(inputBuffer == this.dequeuedInputBuffer);
            this.queuedInputBuffers.addLast(inputBuffer);
            maybeNotifyDecodeLoop();
            this.dequeuedInputBuffer = null;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final O dequeueOutputBuffer() throws Exception {
        synchronized (this.lock) {
            try {
                maybeThrowException();
                if (this.queuedOutputBuffers.isEmpty()) {
                    return null;
                }
                return this.queuedOutputBuffers.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void releaseOutputBuffer(O outputBuffer) {
        synchronized (this.lock) {
            releaseOutputBufferInternal(outputBuffer);
            maybeNotifyDecodeLoop();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void setPlaybackParams(long currentPositionUs, float rendererOperatingRate) {
        this.deadLinePositionUs = currentPositionUs + Math.round(1000000.0f / rendererOperatingRate);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void flush() {
        synchronized (this.lock) {
            try {
                this.flushed = true;
                this.skippedOutputBufferCount = 0;
                I i = this.dequeuedInputBuffer;
                if (i != null) {
                    releaseInputBufferInternal(i);
                    this.dequeuedInputBuffer = null;
                }
                while (!this.queuedInputBuffers.isEmpty()) {
                    releaseInputBufferInternal(this.queuedInputBuffers.removeFirst());
                }
                while (!this.queuedOutputBuffers.isEmpty()) {
                    this.queuedOutputBuffers.removeFirst().release();
                }
                this.exception = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() throws InterruptedException {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Exception */
    private void maybeThrowException() throws Exception {
        E e = this.exception;
        if (e != null) {
            throw e;
        }
    }

    private void maybeNotifyDecodeLoop() {
        if (canDecodeBuffer()) {
            this.lock.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (decode());
    }

    private boolean decode() throws InterruptedException {
        E e;
        synchronized (this.lock) {
            while (!this.released && !canDecodeBuffer()) {
                try {
                    this.lock.wait();
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
            if (this.released) {
                return false;
            }
            I iRemoveFirst = this.queuedInputBuffers.removeFirst();
            boolean z = iRemoveFirst.timeUs < this.deadLinePositionUs;
            synchronized (this.lock) {
                while (!iRemoveFirst.isKeyFrame() && iRemoveFirst.timeUs > 0 && this.queuedInputBuffers.size() > 0 && z) {
                    releaseInputBufferInternal(iRemoveFirst);
                    iRemoveFirst = this.queuedInputBuffers.removeFirst();
                }
            }
            O[] oArr = this.availableOutputBuffers;
            int i = this.availableOutputBufferCount - 1;
            this.availableOutputBufferCount = i;
            O o = oArr[i];
            boolean z2 = this.flushed;
            this.flushed = false;
            if (iRemoveFirst.isEndOfStream()) {
                o.addFlag(4);
            } else {
                if (iRemoveFirst.isDecodeOnly()) {
                    o.addFlag(Integer.MIN_VALUE);
                }
                try {
                    e = (E) decode(iRemoveFirst, o, z2);
                } catch (OutOfMemoryError e2) {
                    e = (E) createUnexpectedDecodeException(e2);
                } catch (RuntimeException e3) {
                    e = (E) createUnexpectedDecodeException(e3);
                }
                if (e != null) {
                    synchronized (this.lock) {
                        this.exception = e;
                    }
                    return false;
                }
            }
            synchronized (this.lock) {
                try {
                    if (this.flushed) {
                        o.release();
                    } else if (o.isDecodeOnly()) {
                        this.skippedOutputBufferCount++;
                        o.release();
                    } else {
                        o.skippedOutputBufferCount = this.skippedOutputBufferCount;
                        this.skippedOutputBufferCount = 0;
                        this.queuedOutputBuffers.addLast(o);
                    }
                    releaseInputBufferInternal(iRemoveFirst);
                } finally {
                }
            }
            return true;
        }
    }

    private boolean canDecodeBuffer() {
        return !this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0;
    }

    private void releaseInputBufferInternal(I inputBuffer) {
        inputBuffer.clear();
        I[] iArr = this.availableInputBuffers;
        int i = this.availableInputBufferCount;
        this.availableInputBufferCount = i + 1;
        iArr[i] = inputBuffer;
    }

    private void releaseOutputBufferInternal(O outputBuffer) {
        outputBuffer.clear();
        O[] oArr = this.availableOutputBuffers;
        int i = this.availableOutputBufferCount;
        this.availableOutputBufferCount = i + 1;
        oArr[i] = outputBuffer;
    }
}
