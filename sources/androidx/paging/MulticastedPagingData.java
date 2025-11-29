package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: CachedPagingData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/paging/MulticastedPagingData;", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroidx/paging/PagingData;", "parent", "Landroidx/paging/ActiveFlowTracker;", "tracker", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/PagingData;Landroidx/paging/ActiveFlowTracker;)V", "asPagingData", "()Landroidx/paging/PagingData;", "", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "Landroidx/paging/PagingData;", "getParent", "Landroidx/paging/CachedPageEventFlow;", "accumulated", "Landroidx/paging/CachedPageEventFlow;", "Landroidx/paging/ActiveFlowTracker;", "getTracker", "()Landroidx/paging/ActiveFlowTracker;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class MulticastedPagingData<T> {
    private final CachedPageEventFlow<T> accumulated;
    private final PagingData<T> parent;
    private final CoroutineScope scope;

    public final ActiveFlowTracker getTracker() {
        return null;
    }

    public MulticastedPagingData(CoroutineScope scope, PagingData<T> parent, ActiveFlowTracker activeFlowTracker) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.scope = scope;
        this.parent = parent;
        this.accumulated = new CachedPageEventFlow<>(parent.getFlow$paging_common_release(), scope);
    }

    /* compiled from: CachedPagingData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PageEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.MulticastedPagingData$asPagingData$1", f = "CachedPagingData.kt", l = {51}, m = "invokeSuspend")
    /* renamed from: androidx.paging.MulticastedPagingData$asPagingData$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super PageEvent<T>>, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MulticastedPagingData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MulticastedPagingData<T> multicastedPagingData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = multicastedPagingData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super PageEvent<T>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.getTracker();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final PagingData<T> asPagingData() {
        return new PagingData<>(FlowKt.onCompletion(FlowKt.onStart(this.accumulated.getDownstreamFlow(), new AnonymousClass1(this, null)), new AnonymousClass2(this, null)), this.parent.getUiReceiver(), this.parent.getHintReceiver(), new Function0<PageEvent.Insert<T>>(this) { // from class: androidx.paging.MulticastedPagingData.asPagingData.3
            final /* synthetic */ MulticastedPagingData<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final PageEvent.Insert<T> invoke() {
                return ((MulticastedPagingData) this.this$0).accumulated.getCachedEvent$paging_common_release();
            }
        });
    }

    /* compiled from: CachedPagingData.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PageEvent;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.MulticastedPagingData$asPagingData$2", f = "CachedPagingData.kt", l = {53}, m = "invokeSuspend")
    /* renamed from: androidx.paging.MulticastedPagingData$asPagingData$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super PageEvent<T>>, Throwable, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MulticastedPagingData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MulticastedPagingData<T> multicastedPagingData, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = multicastedPagingData;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super PageEvent<T>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.getTracker();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object close(Continuation<? super Unit> continuation) {
        this.accumulated.close();
        return Unit.INSTANCE;
    }
}
