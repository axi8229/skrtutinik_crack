package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: Semaphore.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\u00020\u0010*\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u0013\u0010\u0019\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\tJ\u001d\u0010\u0019\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH\u0005¢\u0006\u0004\b\u0019\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00070\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000bR\u000b\u0010%\u001a\u00020$8\u0002X\u0082\u0004R\u000b\u0010'\u001a\u00020&8\u0002X\u0082\u0004R\u000b\u0010(\u001a\u00020&8\u0002X\u0082\u0004R\u0011\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004R\u0011\u0010,\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquireSlowPath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decPermits", "()I", "coerceAvailablePermitsAtMaximum", "()V", "Lkotlinx/coroutines/Waiter;", "waiter", "", "addAcquireToQueue", "(Lkotlinx/coroutines/Waiter;)Z", "tryResumeNextFromQueue", "()Z", "", "tryResumeAcquire", "(Ljava/lang/Object;)Z", "tryAcquire", "acquire", "Lkotlinx/coroutines/CancellableContinuation;", "(Lkotlinx/coroutines/CancellableContinuation;)V", "release", "I", "Lkotlin/Function1;", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "getAvailablePermits", "availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "_availablePermits", "Lkotlinx/atomicfu/AtomicLong;", "deqIdx", "enqIdx", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "head", "tail", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public class SemaphoreImpl implements Semaphore {
    private volatile int _availablePermits;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;
    private volatile Object tail;
    private static final AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    private static final AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    private static final AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    private static final AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    private static final AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation<? super Unit> continuation) {
        return acquire$suspendImpl(this, continuation);
    }

    public SemaphoreImpl(int i, int i2) {
        this.permits = i;
        if (i <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
        }
        if (i2 < 0 || i2 > i) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head = semaphoreSegment;
        this.tail = semaphoreSegment;
        this._availablePermits = i - i2;
        this.onCancellationRelease = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                this.this$0.release();
            }
        };
    }

    public int getAvailablePermits() {
        return Math.max(_availablePermits$FU.get(this), 0);
    }

    public boolean tryAcquire() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _availablePermits$FU;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i > this.permits) {
                coerceAvailablePermitsAtMaximum();
            } else {
                if (i <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i, i - 1)) {
                    return true;
                }
            }
        }
    }

    static /* synthetic */ Object acquire$suspendImpl(SemaphoreImpl semaphoreImpl, Continuation<? super Unit> continuation) {
        if (semaphoreImpl.decPermits() > 0) {
            return Unit.INSTANCE;
        }
        Object objAcquireSlowPath = semaphoreImpl.acquireSlowPath(continuation);
        return objAcquireSlowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAcquireSlowPath : Unit.INSTANCE;
    }

    protected final void acquire(CancellableContinuation<? super Unit> waiter) {
        while (decPermits() <= 0) {
            Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (addAcquireToQueue((Waiter) waiter)) {
                return;
            }
        }
        waiter.resume(Unit.INSTANCE, this.onCancellationRelease);
    }

    private final int decPermits() {
        int andDecrement;
        do {
            andDecrement = _availablePermits$FU.getAndDecrement(this);
        } while (andDecrement > this.permits);
        return andDecrement;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        do {
            int andIncrement = _availablePermits$FU.getAndIncrement(this);
            if (andIncrement >= this.permits) {
                coerceAvailablePermitsAtMaximum();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!tryResumeNextFromQueue());
    }

    private final void coerceAvailablePermitsAtMaximum() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        int i2;
        do {
            atomicIntegerFieldUpdater = _availablePermits$FU;
            i = atomicIntegerFieldUpdater.get(this);
            i2 = this.permits;
            if (i <= i2) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean addAcquireToQueue(Waiter waiter) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = tail$FU;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 semaphoreImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        long j = andIncrement / SemaphoreKt.SEGMENT_SIZE;
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j, semaphoreImpl$addAcquireToQueue$createNewSegment$1);
            if (!SegmentOrClosed.m2812isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM2811getSegmentimpl = SegmentOrClosed.m2811getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= segmentM2811getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM2811getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, segmentM2811getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (segmentM2811getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM2811getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m2811getSegmentimpl(objFindSegmentInternal);
        int i = (int) (andIncrement % SemaphoreKt.SEGMENT_SIZE);
        if (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment2.getAcquirers(), i, null, waiter)) {
            if (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment2.getAcquirers(), i, SemaphoreKt.PERMIT, SemaphoreKt.TAKEN)) {
                return false;
            }
            if (waiter instanceof CancellableContinuation) {
                Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                ((CancellableContinuation) waiter).resume(Unit.INSTANCE, this.onCancellationRelease);
            } else if (waiter instanceof SelectInstance) {
                ((SelectInstance) waiter).selectInRegistrationPhase(Unit.INSTANCE);
            } else {
                throw new IllegalStateException(("unexpected: " + waiter).toString());
            }
            return true;
        }
        waiter.invokeOnCancellation(semaphoreSegment2, i);
        return true;
    }

    private final boolean tryResumeNextFromQueue() {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = head$FU;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = deqIdx$FU.getAndIncrement(this);
        long j = andIncrement / SemaphoreKt.SEGMENT_SIZE;
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (SegmentOrClosed.m2812isClosedimpl(objFindSegmentInternal)) {
                break;
            }
            Segment segmentM2811getSegmentimpl = SegmentOrClosed.m2811getSegmentimpl(objFindSegmentInternal);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.id >= segmentM2811getSegmentimpl.id) {
                    break loop0;
                }
                if (!segmentM2811getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, segmentM2811getSegmentimpl)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (segmentM2811getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    segmentM2811getSegmentimpl.remove();
                }
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m2811getSegmentimpl(objFindSegmentInternal);
        semaphoreSegment2.cleanPrev();
        if (semaphoreSegment2.id > j) {
            return false;
        }
        int i = (int) (andIncrement % SemaphoreKt.SEGMENT_SIZE);
        Object andSet = semaphoreSegment2.getAcquirers().getAndSet(i, SemaphoreKt.PERMIT);
        if (andSet == null) {
            int i2 = SemaphoreKt.MAX_SPIN_CYCLES;
            for (int i3 = 0; i3 < i2; i3++) {
                if (semaphoreSegment2.getAcquirers().get(i) == SemaphoreKt.TAKEN) {
                    return true;
                }
            }
            return !ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment2.getAcquirers(), i, SemaphoreKt.PERMIT, SemaphoreKt.BROKEN);
        }
        if (andSet == SemaphoreKt.CANCELLED) {
            return false;
        }
        return tryResumeAcquire(andSet);
    }

    private final Object acquireSlowPath(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            if (!addAcquireToQueue(orCreateCancellableContinuation)) {
                acquire((CancellableContinuation<? super Unit>) orCreateCancellableContinuation);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final boolean tryResumeAcquire(Object obj) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Object objTryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
            if (objTryResume == null) {
                return false;
            }
            cancellableContinuation.completeResume(objTryResume);
            return true;
        }
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, Unit.INSTANCE);
        }
        throw new IllegalStateException(("unexpected: " + obj).toString());
    }
}
