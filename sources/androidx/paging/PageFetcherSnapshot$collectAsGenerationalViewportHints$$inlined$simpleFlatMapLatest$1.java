package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageFetcherSnapshotState;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1", f = "PageFetcherSnapshot.kt", l = {232, 98}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super GenerationalViewportHint>, Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoadType $loadType$inlined;
    int I$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PageFetcherSnapshot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(Continuation continuation, PageFetcherSnapshot pageFetcherSnapshot, LoadType loadType) {
        super(3, continuation);
        this.this$0 = pageFetcherSnapshot;
        this.$loadType$inlined = loadType;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super GenerationalViewportHint> flowCollector, Integer num, Continuation<? super Unit> continuation) {
        PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(continuation, this.this$0, this.$loadType$inlined);
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$0 = flowCollector;
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$1 = num;
        return pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        final int iIntValue;
        PageFetcherSnapshotState.Holder holder;
        Mutex mutex;
        Flow<GenerationalViewportHint> flowFlowOf;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                iIntValue = ((Number) this.L$1).intValue();
                holder = this.this$0.stateHolder;
                mutex = holder.lock;
                this.L$0 = flowCollector;
                this.L$1 = holder;
                this.L$2 = mutex;
                this.I$0 = iIntValue;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                iIntValue = this.I$0;
                mutex = (Mutex) this.L$2;
                holder = (PageFetcherSnapshotState.Holder) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            PageFetcherSnapshotState pageFetcherSnapshotState = holder.state;
            LoadState loadState = pageFetcherSnapshotState.getSourceLoadStates().get(this.$loadType$inlined);
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
            if (Intrinsics.areEqual(loadState, companion.getComplete$paging_common_release())) {
                flowFlowOf = FlowKt.flowOf((Object[]) new GenerationalViewportHint[0]);
            } else {
                if (!(pageFetcherSnapshotState.getSourceLoadStates().get(this.$loadType$inlined) instanceof LoadState.Error)) {
                    pageFetcherSnapshotState.getSourceLoadStates().set(this.$loadType$inlined, companion.getIncomplete$paging_common_release());
                }
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                final Flow flowDrop = FlowKt.drop(this.this$0.hintHandler.hintFor(this.$loadType$inlined), iIntValue == 0 ? 0 : 1);
                flowFlowOf = new Flow<GenerationalViewportHint>() { // from class: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
                    /* renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ int $generationId$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1$2", f = "PageFetcherSnapshot.kt", l = {223}, m = "emit")
                        /* renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, int i) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$generationId$inlined = i;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                            /*
                                r5 = this;
                                boolean r0 = r7 instanceof androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r7
                                androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1$2$1 r0 = (androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1$2$1 r0 = new androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1$2$1
                                r0.<init>(r7)
                            L18:
                                java.lang.Object r7 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r7)
                                goto L48
                            L29:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r7)
                                throw r6
                            L31:
                                kotlin.ResultKt.throwOnFailure(r7)
                                kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                                androidx.paging.ViewportHint r6 = (androidx.paging.ViewportHint) r6
                                androidx.paging.GenerationalViewportHint r2 = new androidx.paging.GenerationalViewportHint
                                int r4 = r5.$generationId$inlined
                                r2.<init>(r4, r6)
                                r0.label = r3
                                java.lang.Object r6 = r7.emit(r2, r0)
                                if (r6 != r1) goto L48
                                return r1
                            L48:
                                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda$5$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super GenerationalViewportHint> flowCollector2, Continuation continuation) {
                        Object objCollect = flowDrop.collect(new AnonymousClass2(flowCollector2, iIntValue), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
            }
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (FlowKt.emitAll(flowCollector, flowFlowOf, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }
}
