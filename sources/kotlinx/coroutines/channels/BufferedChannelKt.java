package kotlinx.coroutines.channels;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

/* compiled from: BufferedChannel.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a3\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0001\"\u0004\b\u0000\u0010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\u001a?\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001e\"\u001c\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!\"\u0014\u0010\"\u001a\u00020\u00148\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#\"\u0014\u0010&\u001a\u00020%8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b&\u0010'\"\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'\"\u0014\u0010)\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'\"\u0014\u0010*\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010'\"\u0014\u0010+\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010'\"\u0014\u0010,\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010'\"\u0014\u0010-\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010'\"\u0014\u0010.\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010'\"\u001a\u0010/\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b0\u00101\"\u0014\u00102\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010'\"\u0014\u00103\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010'\"\u0014\u00104\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010'\"\u0014\u00105\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010'\"\u0014\u00106\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010'\"\u0014\u00107\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010'\"\u0014\u00108\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010'¨\u00069"}, d2 = {"E", "Lkotlin/reflect/KFunction2;", "", "Lkotlinx/coroutines/channels/ChannelSegment;", "createSegmentFunction", "()Lkotlin/reflect/KFunction;", "id", "prev", "createSegment", "(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", "T", "Lkotlinx/coroutines/CancellableContinuation;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/Function1;", "", "", "onCancellation", "", "tryResume0", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "", "capacity", "initialBufferEnd", "(I)J", "counter", "closeStatus", "constructSendersAndCloseStatus", "(JI)J", "pauseEB", "constructEBCompletedAndPauseFlag", "(JZ)J", "", "NULL_SEGMENT", "Lkotlinx/coroutines/channels/ChannelSegment;", "SEGMENT_SIZE", "I", "EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS", "Lkotlinx/coroutines/internal/Symbol;", "BUFFERED", "Lkotlinx/coroutines/internal/Symbol;", "IN_BUFFER", "RESUMING_BY_RCV", "RESUMING_BY_EB", "POISONED", "DONE_RCV", "INTERRUPTED_SEND", "INTERRUPTED_RCV", "CHANNEL_CLOSED", "getCHANNEL_CLOSED", "()Lkotlinx/coroutines/internal/Symbol;", "SUSPEND", "SUSPEND_NO_WAITER", "FAILED", "NO_RECEIVE_RESULT", "CLOSE_HANDLER_CLOSED", "CLOSE_HANDLER_INVOKED", "NO_CLOSE_CAUSE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BufferedChannelKt {
    private static final ChannelSegment<Object> NULL_SEGMENT = new ChannelSegment<>(-1, null, null, 0);
    public static final int SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);
    private static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object) null);
    public static final Symbol BUFFERED = new Symbol("BUFFERED");
    private static final Symbol IN_BUFFER = new Symbol("SHOULD_BUFFER");
    private static final Symbol RESUMING_BY_RCV = new Symbol("S_RESUMING_BY_RCV");
    private static final Symbol RESUMING_BY_EB = new Symbol("RESUMING_BY_EB");
    private static final Symbol POISONED = new Symbol("POISONED");
    private static final Symbol DONE_RCV = new Symbol("DONE_RCV");
    private static final Symbol INTERRUPTED_SEND = new Symbol("INTERRUPTED_SEND");
    private static final Symbol INTERRUPTED_RCV = new Symbol("INTERRUPTED_RCV");
    private static final Symbol CHANNEL_CLOSED = new Symbol("CHANNEL_CLOSED");
    private static final Symbol SUSPEND = new Symbol("SUSPEND");
    private static final Symbol SUSPEND_NO_WAITER = new Symbol("SUSPEND_NO_WAITER");
    private static final Symbol FAILED = new Symbol("FAILED");
    private static final Symbol NO_RECEIVE_RESULT = new Symbol("NO_RECEIVE_RESULT");
    private static final Symbol CLOSE_HANDLER_CLOSED = new Symbol("CLOSE_HANDLER_CLOSED");
    private static final Symbol CLOSE_HANDLER_INVOKED = new Symbol("CLOSE_HANDLER_INVOKED");
    private static final Symbol NO_CLOSE_CAUSE = new Symbol("NO_CLOSE_CAUSE");

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constructEBCompletedAndPauseFlag(long j, boolean z) {
        return (z ? 4611686018427387904L : 0L) + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constructSendersAndCloseStatus(long j, int i) {
        return (i << 60) + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long initialBufferEnd(int i) {
        if (i == 0) {
            return 0L;
        }
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: BufferedChannel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1<E> extends FunctionReferenceImpl implements Function2<Long, ChannelSegment<E>, ChannelSegment<E>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Long l, Object obj) {
            return invoke(l.longValue(), (ChannelSegment) obj);
        }

        public final ChannelSegment<E> invoke(long j, ChannelSegment<E> channelSegment) {
            return BufferedChannelKt.createSegment(j, channelSegment);
        }
    }

    public static final <E> KFunction<ChannelSegment<E>> createSegmentFunction() {
        return AnonymousClass1.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> ChannelSegment<E> createSegment(long j, ChannelSegment<E> channelSegment) {
        return new ChannelSegment<>(j, channelSegment, channelSegment.getChannel(), 0);
    }

    static /* synthetic */ boolean tryResume0$default(CancellableContinuation cancellableContinuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return tryResume0(cancellableContinuation, obj, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean tryResume0(CancellableContinuation<? super T> cancellableContinuation, T t, Function1<? super Throwable, Unit> function1) {
        Object objTryResume = cancellableContinuation.tryResume(t, null, function1);
        if (objTryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(objTryResume);
        return true;
    }

    public static final Symbol getCHANNEL_CLOSED() {
        return CHANNEL_CLOSED;
    }
}
