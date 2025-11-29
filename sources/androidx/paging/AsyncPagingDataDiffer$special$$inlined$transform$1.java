package androidx.paging;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Emitters.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1", f = "AsyncPagingDataDiffer.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsyncPagingDataDiffer$special$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super CombinedLoadStates>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AsyncPagingDataDiffer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$special$$inlined$transform$1(Flow flow, Continuation continuation, AsyncPagingDataDiffer asyncPagingDataDiffer) {
        super(2, continuation);
        this.$this_transform = flow;
        this.this$0 = asyncPagingDataDiffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AsyncPagingDataDiffer$special$$inlined$transform$1 asyncPagingDataDiffer$special$$inlined$transform$1 = new AsyncPagingDataDiffer$special$$inlined$transform$1(this.$this_transform, continuation, this.this$0);
        asyncPagingDataDiffer$special$$inlined$transform$1.L$0 = obj;
        return asyncPagingDataDiffer$special$$inlined$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CombinedLoadStates> flowCollector, Continuation<? super Unit> continuation) {
        return ((AsyncPagingDataDiffer$special$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, this.this$0);
            this.label = 1;
            if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: Emitters.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<CombinedLoadStates> $$this$flow;
        final /* synthetic */ AsyncPagingDataDiffer this$0;

        /* compiled from: Emitters.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1", f = "AsyncPagingDataDiffer.kt", l = {224, 225, 229}, m = "emit")
        /* renamed from: androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00501 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            /* synthetic */ Object result;

            public C00501(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, AsyncPagingDataDiffer asyncPagingDataDiffer) {
            this.this$0 = asyncPagingDataDiffer;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1.AnonymousClass1.C00501
                if (r0 == 0) goto L13
                r0 = r9
                androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1$1 r0 = (androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1.AnonymousClass1.C00501) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1$1 r0 = new androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1$1
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L55
                if (r2 == r5) goto L45
                if (r2 == r4) goto L39
                if (r2 != r3) goto L31
                kotlin.ResultKt.throwOnFailure(r9)
                goto La9
            L31:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L39:
                java.lang.Object r8 = r0.L$1
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                java.lang.Object r2 = r0.L$0
                androidx.paging.CombinedLoadStates r2 = (androidx.paging.CombinedLoadStates) r2
                kotlin.ResultKt.throwOnFailure(r9)
                goto L9a
            L45:
                java.lang.Object r8 = r0.L$2
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                java.lang.Object r2 = r0.L$1
                androidx.paging.CombinedLoadStates r2 = (androidx.paging.CombinedLoadStates) r2
                java.lang.Object r5 = r0.L$0
                androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1 r5 = (androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1.AnonymousClass1) r5
                kotlin.ResultKt.throwOnFailure(r9)
                goto L80
            L55:
                kotlin.ResultKt.throwOnFailure(r9)
                kotlinx.coroutines.flow.FlowCollector<androidx.paging.CombinedLoadStates> r9 = r7.$$this$flow
                androidx.paging.CombinedLoadStates r8 = (androidx.paging.CombinedLoadStates) r8
                androidx.paging.AsyncPagingDataDiffer r2 = r7.this$0
                kotlinx.coroutines.flow.MutableStateFlow r2 = r2.getInGetItem$paging_runtime_release()
                java.lang.Object r2 = r2.getValue()
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L9c
                r0.L$0 = r7
                r0.L$1 = r8
                r0.L$2 = r9
                r0.label = r5
                java.lang.Object r2 = kotlinx.coroutines.YieldKt.yield(r0)
                if (r2 != r1) goto L7d
                return r1
            L7d:
                r5 = r7
                r2 = r8
                r8 = r9
            L80:
                androidx.paging.AsyncPagingDataDiffer r9 = r5.this$0
                kotlinx.coroutines.flow.MutableStateFlow r9 = r9.getInGetItem$paging_runtime_release()
                androidx.paging.AsyncPagingDataDiffer$loadStateFlow$1$1 r5 = new androidx.paging.AsyncPagingDataDiffer$loadStateFlow$1$1
                r5.<init>(r6)
                r0.L$0 = r2
                r0.L$1 = r8
                r0.L$2 = r6
                r0.label = r4
                java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r9, r5, r0)
                if (r9 != r1) goto L9a
                return r1
            L9a:
                r9 = r8
                r8 = r2
            L9c:
                r0.L$0 = r6
                r0.L$1 = r6
                r0.label = r3
                java.lang.Object r8 = r9.emit(r8, r0)
                if (r8 != r1) goto La9
                return r1
            La9:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
