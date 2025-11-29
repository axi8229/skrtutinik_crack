package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pipe.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\b*\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007H\u0082\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\"\u0010)\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R$\u0010,\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u000eR\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u00106\u001a\u0002058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010\f\u001a\u00020\u00068G¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\b\f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00118G¢\u0006\f\n\u0004\b\u0014\u0010:\u001a\u0004\b\u0014\u0010\u0013¨\u0006;"}, d2 = {"Lokio/Pipe;", "", "", "maxBufferSize", "<init>", "(J)V", "Lokio/Sink;", "Lkotlin/Function1;", "", "block", "forward", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "sink", "fold", "(Lokio/Sink;)V", "-deprecated_sink", "()Lokio/Sink;", "Lokio/Source;", "-deprecated_source", "()Lokio/Source;", "source", "cancel", "()V", "J", "getMaxBufferSize$okio", "()J", "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "", "canceled", "Z", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "setFoldedSink$okio", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "Lokio/Source;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private final Condition condition;
    private Sink foldedSink;
    private final ReentrantLock lock;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j) {
        this.maxBufferSize = j;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "lock.newCondition()");
        this.condition = conditionNewCondition;
        if (j < 1) {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j).toString());
        }
        this.sink = new Sink() { // from class: okio.Pipe.sink.1
            private final Timeout timeout = new Timeout();

            /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
            
                r1 = kotlin.Unit.INSTANCE;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
            
                r0.unlock();
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
            
                if (r2 == null) goto L57;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
            
                r0 = r12.this$0;
                r1 = r2.getTimeout();
                r0 = r0.sink().getTimeout();
                r3 = r1.getTimeoutNanos();
                r5 = okio.Timeout.INSTANCE.minTimeout(r0.getTimeoutNanos(), r1.getTimeoutNanos());
                r7 = java.util.concurrent.TimeUnit.NANOSECONDS;
                r1.timeout(r5, r7);
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
            
                if (r1.getHasDeadline() == false) goto L45;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
            
                r5 = r1.deadlineNanoTime();
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
            
                if (r0.getHasDeadline() == false) goto L66;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
            
                r1.deadlineNanoTime(java.lang.Math.min(r1.deadlineNanoTime(), r0.deadlineNanoTime()));
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
            
                r2.write(r13, r14);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00c6, code lost:
            
                r1.timeout(r3, r7);
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00cd, code lost:
            
                if (r0.getHasDeadline() == false) goto L78;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
            
                r1.deadlineNanoTime(r5);
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x00d3, code lost:
            
                r13 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00d4, code lost:
            
                r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
            
                if (r0.getHasDeadline() != false) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00df, code lost:
            
                r1.deadlineNanoTime(r5);
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x00e2, code lost:
            
                throw r13;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
            
                if (r0.getHasDeadline() == false) goto L64;
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00e9, code lost:
            
                r1.deadlineNanoTime(r0.deadlineNanoTime());
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00f0, code lost:
            
                r2.write(r13, r14);
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x00f3, code lost:
            
                r1.timeout(r3, r7);
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x00fa, code lost:
            
                if (r0.getHasDeadline() == false) goto L80;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x00fc, code lost:
            
                r1.clearDeadline();
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x0100, code lost:
            
                r13 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x0101, code lost:
            
                r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x010a, code lost:
            
                if (r0.getHasDeadline() != false) goto L55;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x010c, code lost:
            
                r1.clearDeadline();
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x010f, code lost:
            
                throw r13;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x0110, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
            
                return;
             */
            @Override // okio.Sink
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void write(okio.Buffer r13, long r14) {
                /*
                    Method dump skipped, instructions count: 291
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: okio.Pipe.AnonymousClass1.write(okio.Buffer, long):void");
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed()) {
                        throw new IllegalStateException("closed");
                    }
                    if (pipe.getCanceled()) {
                        throw new IOException("canceled");
                    }
                    Sink foldedSink = pipe.getFoldedSink();
                    if (foldedSink == null) {
                        if (pipe.getSourceClosed() && pipe.getBuffer().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        foldedSink = null;
                    }
                    Unit unit = Unit.INSTANCE;
                    lock.unlock();
                    if (foldedSink != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink.getTimeout();
                        Timeout timeout2 = pipe2.sink().getTimeout();
                        long timeoutNanos = timeout.getTimeoutNanos();
                        long jMinTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(jMinTimeout, timeUnit);
                        if (timeout.getHasDeadline()) {
                            long jDeadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink.flush();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                }
                                throw th;
                            }
                        }
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            foldedSink.flush();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                        } catch (Throwable th2) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    lock.unlock();
                    throw th3;
                }
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed()) {
                        lock.unlock();
                        return;
                    }
                    Sink foldedSink = pipe.getFoldedSink();
                    if (foldedSink == null) {
                        if (pipe.getSourceClosed() && pipe.getBuffer().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        pipe.setSinkClosed$okio(true);
                        pipe.getCondition().signalAll();
                        foldedSink = null;
                    }
                    Unit unit = Unit.INSTANCE;
                    lock.unlock();
                    if (foldedSink != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink.getTimeout();
                        Timeout timeout2 = pipe2.sink().getTimeout();
                        long timeoutNanos = timeout.getTimeoutNanos();
                        long jMinTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(jMinTimeout, timeUnit);
                        if (timeout.getHasDeadline()) {
                            long jDeadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                }
                                throw th;
                            }
                        }
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            foldedSink.close();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                        } catch (Throwable th2) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    lock.unlock();
                    throw th3;
                }
            }

            @Override // okio.Sink
            /* renamed from: timeout, reason: from getter */
            public Timeout getTimeout() {
                return this.timeout;
            }
        };
        this.source = new Source() { // from class: okio.Pipe.source.1
            private final Timeout timeout = new Timeout();

            @Override // okio.Source
            public long read(Buffer sink, long byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSourceClosed()) {
                        throw new IllegalStateException("closed");
                    }
                    if (pipe.getCanceled()) {
                        throw new IOException("canceled");
                    }
                    while (pipe.getBuffer().size() == 0) {
                        if (pipe.getSinkClosed()) {
                            lock.unlock();
                            return -1L;
                        }
                        this.timeout.awaitSignal(pipe.getCondition());
                        if (pipe.getCanceled()) {
                            throw new IOException("canceled");
                        }
                    }
                    long j2 = pipe.getBuffer().read(sink, byteCount);
                    pipe.getCondition().signalAll();
                    lock.unlock();
                    return j2;
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    pipe.setSourceClosed$okio(true);
                    pipe.getCondition().signalAll();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    lock.unlock();
                }
            }

            @Override // okio.Source
            /* renamed from: timeout, reason: from getter */
            public Timeout getTimeout() {
                return this.timeout;
            }
        };
    }

    /* renamed from: getMaxBufferSize$okio, reason: from getter */
    public final long getMaxBufferSize() {
        return this.maxBufferSize;
    }

    /* renamed from: getBuffer$okio, reason: from getter */
    public final Buffer getBuffer() {
        return this.buffer;
    }

    /* renamed from: getCanceled$okio, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    /* renamed from: getSinkClosed$okio, reason: from getter */
    public final boolean getSinkClosed() {
        return this.sinkClosed;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    /* renamed from: getSourceClosed$okio, reason: from getter */
    public final boolean getSourceClosed() {
        return this.sourceClosed;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    /* renamed from: getFoldedSink$okio, reason: from getter */
    public final Sink getFoldedSink() {
        return this.foldedSink;
    }

    public final void setFoldedSink$okio(Sink sink) {
        this.foldedSink = sink;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }

    public final void fold(Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (true) {
            this.lock.lock();
            try {
                if (this.foldedSink != null) {
                    throw new IllegalStateException("sink already folded");
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                }
                boolean z = this.sinkClosed;
                Buffer buffer = new Buffer();
                Buffer buffer2 = this.buffer;
                buffer.write(buffer2, buffer2.size());
                this.condition.signalAll();
                Unit unit = Unit.INSTANCE;
                try {
                    sink.write(buffer, buffer.size());
                    if (z) {
                        sink.close();
                    } else {
                        sink.flush();
                    }
                } catch (Throwable th) {
                    this.lock.lock();
                    try {
                        this.sourceClosed = true;
                        this.condition.signalAll();
                        Unit unit2 = Unit.INSTANCE;
                        throw th;
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    private final void forward(Sink sink, Function1<? super Sink, Unit> function1) {
        Timeout timeout = sink.getTimeout();
        Timeout timeout2 = sink().getTimeout();
        long timeoutNanos = timeout.getTimeoutNanos();
        long jMinTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(jMinTimeout, timeUnit);
        if (timeout.getHasDeadline()) {
            long jDeadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                function1.invoke(sink);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.getHasDeadline()) {
                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
                return;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.getHasDeadline()) {
                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        if (timeout2.getHasDeadline()) {
            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
        }
        try {
            function1.invoke(sink);
            Unit unit2 = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            timeout.timeout(timeoutNanos, timeUnit);
            if (timeout2.getHasDeadline()) {
                timeout.clearDeadline();
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.getHasDeadline()) {
                timeout.clearDeadline();
            }
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    @Deprecated
    /* renamed from: -deprecated_sink, reason: not valid java name and from getter */
    public final Sink getSink() {
        return this.sink;
    }

    @Deprecated
    /* renamed from: -deprecated_source, reason: not valid java name and from getter */
    public final Source getSource() {
        return this.source;
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
