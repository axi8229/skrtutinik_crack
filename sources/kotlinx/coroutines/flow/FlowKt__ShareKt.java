package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a=\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\r\u001aM\u0010\u0018\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a;\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\u0004\b\u001f\u0010 \u001aP\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2(\u0010&\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0012\u0004\u0018\u00010%0!ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/flow/SharingStarted;", "started", "", "replay", "Lkotlinx/coroutines/flow/SharedFlow;", "shareIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;I)Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/SharingConfig;", "configureSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/SharingConfig;", "configureSharing", "Lkotlin/coroutines/CoroutineContext;", "context", "upstream", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "shared", "initialValue", "Lkotlinx/coroutines/Job;", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "launchSharing", "Lkotlinx/coroutines/flow/StateFlow;", "stateIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "asSharedFlow", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "asStateFlow", "(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "action", "onSubscription", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
final /* synthetic */ class FlowKt__ShareKt {
    public static final <T> SharedFlow<T> shareIn(Flow<? extends T> flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i) {
        SharingConfig sharingConfigConfigureSharing$FlowKt__ShareKt = configureSharing$FlowKt__ShareKt(flow, i);
        MutableSharedFlow MutableSharedFlow = SharedFlowKt.MutableSharedFlow(i, sharingConfigConfigureSharing$FlowKt__ShareKt.extraBufferCapacity, sharingConfigConfigureSharing$FlowKt__ShareKt.onBufferOverflow);
        return new ReadonlySharedFlow(MutableSharedFlow, launchSharing$FlowKt__ShareKt(coroutineScope, sharingConfigConfigureSharing$FlowKt__ShareKt.context, sharingConfigConfigureSharing$FlowKt__ShareKt.upstream, MutableSharedFlow, sharingStarted, SharedFlowKt.NO_VALUE));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final <T> kotlinx.coroutines.flow.SharingConfig<T> configureSharing$FlowKt__ShareKt(kotlinx.coroutines.flow.Flow<? extends T> r7, int r8) {
        /*
            kotlinx.coroutines.channels.Channel$Factory r0 = kotlinx.coroutines.channels.Channel.INSTANCE
            int r0 = r0.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()
            int r0 = kotlin.ranges.RangesKt.coerceAtLeast(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L3c
            r1 = r7
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            kotlinx.coroutines.flow.Flow r2 = r1.dropChannelOperators()
            if (r2 == 0) goto L3c
            kotlinx.coroutines.flow.SharingConfig r7 = new kotlinx.coroutines.flow.SharingConfig
            int r3 = r1.capacity
            r4 = -3
            if (r3 == r4) goto L26
            r4 = -2
            if (r3 == r4) goto L26
            if (r3 == 0) goto L26
            r0 = r3
            goto L34
        L26:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.onBufferOverflow
            kotlinx.coroutines.channels.BufferOverflow r5 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            r6 = 0
            if (r4 != r5) goto L31
            if (r3 != 0) goto L34
        L2f:
            r0 = r6
            goto L34
        L31:
            if (r8 != 0) goto L2f
            r0 = 1
        L34:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.onBufferOverflow
            kotlin.coroutines.CoroutineContext r1 = r1.context
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3c:
            kotlinx.coroutines.flow.SharingConfig r8 = new kotlinx.coroutines.flow.SharingConfig
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(kotlinx.coroutines.flow.Flow, int):kotlinx.coroutines.flow.SharingConfig");
    }

    private static final <T> Job launchSharing$FlowKt__ShareKt(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow<? extends T> flow, MutableSharedFlow<T> mutableSharedFlow, SharingStarted sharingStarted, T t) {
        return BuildersKt.launch(coroutineScope, coroutineContext, Intrinsics.areEqual(sharingStarted, SharingStarted.INSTANCE.getEagerly()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new FlowKt__ShareKt$launchSharing$1(sharingStarted, flow, mutableSharedFlow, t, null));
    }

    public static final <T> StateFlow<T> stateIn(Flow<? extends T> flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, T t) {
        SharingConfig sharingConfigConfigureSharing$FlowKt__ShareKt = configureSharing$FlowKt__ShareKt(flow, 1);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(t);
        return new ReadonlyStateFlow(MutableStateFlow, launchSharing$FlowKt__ShareKt(coroutineScope, sharingConfigConfigureSharing$FlowKt__ShareKt.context, sharingConfigConfigureSharing$FlowKt__ShareKt.upstream, MutableStateFlow, sharingStarted, t));
    }

    public static final <T> SharedFlow<T> asSharedFlow(MutableSharedFlow<T> mutableSharedFlow) {
        return new ReadonlySharedFlow(mutableSharedFlow, null);
    }

    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, null);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> sharedFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SubscribedSharedFlow(sharedFlow, function2);
    }
}
