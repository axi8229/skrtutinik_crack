package kotlinx.coroutines.flow;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: SharedFlow.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001pB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001d2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J/\u0010-\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u0010\u0015J\u0019\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00100\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0003H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00105\u001a\u00020\u0016H\u0002¢\u0006\u0004\b6\u00107J\u001b\u00108\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b8\u00109J3\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001d2\u0014\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001dH\u0002¢\u0006\u0004\b<\u0010=J!\u0010A\u001a\u00020@2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0096@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\bC\u0010\u0011J\u001b\u0010D\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\bD\u0010$J\u000f\u0010G\u001a\u00020\u0016H\u0000¢\u0006\u0004\bE\u0010FJ%\u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001d2\u0006\u0010H\u001a\u00020\u0016H\u0000¢\u0006\u0004\bI\u0010JJ\u000f\u0010L\u001a\u00020\u0003H\u0014¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001d2\u0006\u0010N\u001a\u00020\u0007H\u0014¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0013H\u0016¢\u0006\u0004\bQ\u0010\u0015J-\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000U2\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bV\u0010WR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010XR\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010XR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010YR \u0010Z\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0016\u0010_\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010XR\u0016\u0010`\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010XR\u0014\u0010b\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010FR\u0014\u0010e\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0014\u0010g\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010dR\u0014\u0010i\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010FR\u0014\u0010k\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010FR\u001a\u0010o\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\bn\u0010\u0015\u001a\u0004\bl\u0010m\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006q"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "", "replay", "bufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "tryEmitLocked", "(Ljava/lang/Object;)Z", "tryEmitNoCollectorsLocked", "", "dropOldestLocked", "()V", "", "newHead", "correctCollectorIndexesOnDropOldest", "(J)V", "item", "enqueueLocked", "(Ljava/lang/Object;)V", "", "curBuffer", "curSize", "newSize", "growBuffer", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "emitSuspend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "emitter", "cancelEmitter", "(Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;)V", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateBufferLocked", "(JJJJ)V", "cleanupTailLocked", "slot", "tryTakeValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)Ljava/lang/Object;", "tryPeekLocked", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)J", "index", "getPeekedValueLockedAt", "(J)Ljava/lang/Object;", "awaitValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "resumesIn", "findSlotsToResumeLocked", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmit", "emit", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "()J", "updateNewCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateCollectorIndexLocked", "createSlot", "()Lkotlinx/coroutines/flow/SharedFlowSlot;", "size", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "resetReplayCache", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "I", "Lkotlinx/coroutines/channels/BufferOverflow;", "buffer", "[Ljava/lang/Object;", "replayIndex", "J", "minCollectorIndex", "bufferSize", "queueSize", "getHead", "head", "getReplaySize", "()I", "replaySize", "getTotalSize", "totalSize", "getBufferEndIndex", "bufferEndIndex", "getQueueEndIndex", "queueEndIndex", "getLastReplayedLocked", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "lastReplayedLocked", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, Flow, FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    /* compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {372, 379, 382}, m = "collect$suspendImpl")
    /* renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedFlowImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SharedFlowImpl<T> sharedFlowImpl, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = sharedFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedFlowImpl.collect$suspendImpl(this.this$0, null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        return emit$suspendImpl(this, t, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelEmitter(Emitter emitter) {
        synchronized (this) {
            if (emitter.index < getHead()) {
                return;
            }
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            if (SharedFlowKt.getBufferAt(objArr, emitter.index) != emitter) {
                return;
            }
            SharedFlowKt.setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
            cleanupTailLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long newHead) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j = sharedFlowSlot.index;
                    if (j >= 0 && j < newHead) {
                        sharedFlowSlot.index = newHead;
                    }
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    public SharedFlowImpl(int i, int i2, BufferOverflow bufferOverflow) {
        this.replay = i;
        this.bufferCapacity = i2;
        this.onBufferOverflow = bufferOverflow;
    }

    private final Object awaitValue(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (tryPeekLocked(sharedFlowSlot) >= 0) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
                } else {
                    sharedFlowSlot.cont = cancellableContinuationImpl;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    private final Object emitSuspend(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArrFindSlotsToResumeLocked;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArrFindSlotsToResumeLocked2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                if (tryEmitLocked(t)) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
                    continuationArrFindSlotsToResumeLocked = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked2);
                    emitter = null;
                } else {
                    Emitter emitter2 = new Emitter(this, getTotalSize() + getHead(), t, cancellableContinuationImpl);
                    enqueueLocked(emitter2);
                    this.queueSize++;
                    if (this.bufferCapacity == 0) {
                        continuationArrFindSlotsToResumeLocked2 = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked2);
                    }
                    continuationArrFindSlotsToResumeLocked = continuationArrFindSlotsToResumeLocked2;
                    emitter = emitter2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, emitter);
        }
        for (Continuation<Unit> continuation2 : continuationArrFindSlotsToResumeLocked) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final int getReplaySize() {
        return (int) ((getHead() + this.bufferSize) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final long getBufferEndIndex() {
        return getHead() + this.bufferSize;
    }

    private final long getQueueEndIndex() {
        return getHead() + this.bufferSize + this.queueSize;
    }

    protected final T getLastReplayedLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        return (T) SharedFlowKt.getBufferAt(objArr, (this.replayIndex + getReplaySize()) - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ <T> java.lang.Object collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, kotlinx.coroutines.flow.FlowCollector<? super T> r9, kotlin.coroutines.Continuation<?> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        int i;
        boolean z;
        Continuation<Unit>[] continuationArrFindSlotsToResumeLocked = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(value)) {
                continuationArrFindSlotsToResumeLocked = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArrFindSlotsToResumeLocked) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
            }
        }
        return z;
    }

    static /* synthetic */ <T> Object emit$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, T t, Continuation<? super Unit> continuation) {
        Object objEmitSuspend;
        return (!sharedFlowImpl.tryEmit(t) && (objEmitSuspend = sharedFlowImpl.emitSuspend(t, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objEmitSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryEmitLocked(T value) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        enqueueLocked(value);
        int i2 = this.bufferSize + 1;
        this.bufferSize = i2;
        if (i2 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T value) {
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(value);
        int i = this.bufferSize + 1;
        this.bufferSize = i;
        if (i > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + this.bufferSize;
        return true;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.setBufferAt(objArr, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueLocked(Object item) {
        int totalSize = getTotalSize();
        Object[] objArrGrowBuffer = this.buffer;
        if (objArrGrowBuffer == null) {
            objArrGrowBuffer = growBuffer(null, 0, 2);
        } else if (totalSize >= objArrGrowBuffer.length) {
            objArrGrowBuffer = growBuffer(objArrGrowBuffer, totalSize, objArrGrowBuffer.length * 2);
        }
        SharedFlowKt.setBufferAt(objArrGrowBuffer, getHead() + totalSize, item);
    }

    private final Object[] growBuffer(Object[] curBuffer, int curSize, int newSize) {
        if (newSize <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr = new Object[newSize];
        this.buffer = objArr;
        if (curBuffer == null) {
            return objArr;
        }
        long head = getHead();
        for (int i = 0; i < curSize; i++) {
            long j = i + head;
            SharedFlowKt.setBufferAt(objArr, j, SharedFlowKt.getBufferAt(curBuffer, j));
        }
        return objArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j = this.replayIndex;
        if (j < this.minCollectorIndex) {
            this.minCollectorIndex = j;
        }
        return j;
    }

    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long oldIndex) {
        int iMin;
        long j;
        long j2;
        long j3;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (oldIndex > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = getHead();
        long j4 = this.bufferSize + head;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j4++;
        }
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    long j5 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j5 >= 0 && j5 < j4) {
                        j4 = j5;
                    }
                }
            }
        }
        if (j4 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        if (getNCollectors() > 0) {
            iMin = Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j4)));
        } else {
            iMin = this.queueSize;
        }
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j6 = this.queueSize + bufferEndIndex;
        if (iMin > 0) {
            continuationArr = new Continuation[iMin];
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            long j7 = bufferEndIndex;
            int i = 0;
            while (true) {
                if (bufferEndIndex >= j6) {
                    j = j4;
                    j2 = j6;
                    break;
                }
                Object bufferAt = SharedFlowKt.getBufferAt(objArr, bufferEndIndex);
                j = j4;
                Symbol symbol = SharedFlowKt.NO_VALUE;
                if (bufferAt != symbol) {
                    Intrinsics.checkNotNull(bufferAt, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    Emitter emitter = (Emitter) bufferAt;
                    int i2 = i + 1;
                    j2 = j6;
                    continuationArr[i] = emitter.cont;
                    SharedFlowKt.setBufferAt(objArr, bufferEndIndex, symbol);
                    SharedFlowKt.setBufferAt(objArr, j7, emitter.value);
                    j3 = 1;
                    j7++;
                    if (i2 >= iMin) {
                        break;
                    }
                    i = i2;
                } else {
                    j2 = j6;
                    j3 = 1;
                }
                bufferEndIndex += j3;
                j4 = j;
                j6 = j2;
            }
            bufferEndIndex = j7;
        } else {
            j = j4;
            j2 = j6;
        }
        int i3 = (int) (bufferEndIndex - head);
        long j8 = getNCollectors() == 0 ? bufferEndIndex : j;
        long jMax = Math.max(this.replayIndex, bufferEndIndex - Math.min(this.replay, i3));
        if (this.bufferCapacity == 0 && jMax < j2) {
            Object[] objArr2 = this.buffer;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.getBufferAt(objArr2, jMax), SharedFlowKt.NO_VALUE)) {
                bufferEndIndex++;
                jMax++;
            }
        }
        updateBufferLocked(jMax, j8, bufferEndIndex, j2);
        cleanupTailLocked();
        return !(continuationArr.length == 0) ? findSlotsToResumeLocked(continuationArr) : continuationArr;
    }

    private final void updateBufferLocked(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long jMin = Math.min(newMinCollectorIndex, newReplayIndex);
        for (long head = getHead(); head < jMin; head++) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.setBufferAt(objArr, head, null);
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int) (newBufferEndIndex - jMin);
        this.queueSize = (int) (newQueueEndIndex - newBufferEndIndex);
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            while (this.queueSize > 0 && SharedFlowKt.getBufferAt(objArr, (getHead() + getTotalSize()) - 1) == SharedFlowKt.NO_VALUE) {
                this.queueSize--;
                SharedFlowKt.setBufferAt(objArr, getHead() + getTotalSize(), null);
            }
        }
    }

    private final Object tryTakeValue(SharedFlowSlot slot) {
        Object obj;
        Continuation<Unit>[] continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                long jTryPeekLocked = tryPeekLocked(slot);
                if (jTryPeekLocked < 0) {
                    obj = SharedFlowKt.NO_VALUE;
                } else {
                    long j = slot.index;
                    Object peekedValueLockedAt = getPeekedValueLockedAt(jTryPeekLocked);
                    slot.index = jTryPeekLocked + 1;
                    continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = updateCollectorIndexLocked$kotlinx_coroutines_core(j);
                    obj = peekedValueLockedAt;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation<Unit> continuation : continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m2628constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot slot) {
        long j = slot.index;
        if (j < getBufferEndIndex()) {
            return j;
        }
        if (this.bufferCapacity <= 0 && j <= getHead() && this.queueSize != 0) {
            return j;
        }
        return -1L;
    }

    private final Object getPeekedValueLockedAt(long index) {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        Object bufferAt = SharedFlowKt.getBufferAt(objArr, index);
        return bufferAt instanceof Emitter ? ((Emitter) bufferAt).value : bufferAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] resumesIn) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super Unit> continuation;
        int length = resumesIn.length;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i = 0;
            resumesIn = resumesIn;
            while (i < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    int length3 = resumesIn.length;
                    resumesIn = resumesIn;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(resumesIn, Math.max(2, resumesIn.length * 2));
                        Intrinsics.checkNotNullExpressionValue(CopyOf, "copyOf(this, newSize)");
                        resumesIn = CopyOf;
                    }
                    resumesIn[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i++;
                resumesIn = resumesIn;
            }
        }
        return resumesIn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot[] createSlotArray(int size) {
        return new SharedFlowSlot[size];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, context, capacity, onBufferOverflow);
    }

    /* compiled from: SharedFlow.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Emitter implements DisposableHandle {
        public final Continuation<Unit> cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j, Object obj, Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }
}
