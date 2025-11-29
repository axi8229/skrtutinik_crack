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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagingDataTransforms.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aW\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aM\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\b\u001am\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00028\u0001\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\b\u0002\u0010\r\u001a\u00020\f2.\u0010\u000f\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a;\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"", "T", "R", "Landroidx/paging/PagingData;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "transform", "map", "(Landroidx/paging/PagingData;Lkotlin/jvm/functions/Function2;)Landroidx/paging/PagingData;", "", "predicate", "filter", "Landroidx/paging/TerminalSeparatorType;", "terminalSeparatorType", "Lkotlin/Function3;", "generator", "insertSeparators", "(Landroidx/paging/PagingData;Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)Landroidx/paging/PagingData;", "item", "insertFooterItem", "(Landroidx/paging/PagingData;Landroidx/paging/TerminalSeparatorType;Ljava/lang/Object;)Landroidx/paging/PagingData;", "paging-common_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/paging/PagingDataTransforms")
/* loaded from: classes.dex */
public final /* synthetic */ class PagingDataTransforms__PagingDataTransformsKt {
    public static final /* synthetic */ PagingData filter(PagingData pagingData, final Function2 predicate) {
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        final Flow flow$paging_common_release = pagingData.getFlow$paging_common_release();
        return new PagingData(new Flow() { // from class: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Function2 $predicate$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1$2", f = "PagingDataTransforms.kt", l = {225, 223}, m = "emit")
                /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
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

                public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$predicate$inlined = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1$2$1 r0 = (androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1$2$1 r0 = new androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L5f
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.L$0
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L53
                    L3c:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                        androidx.paging.PageEvent r7 = (androidx.paging.PageEvent) r7
                        kotlin.jvm.functions.Function2 r2 = r6.$predicate$inlined
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r7 = r7.filter(r2, r0)
                        if (r7 != r1) goto L50
                        return r1
                    L50:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L53:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r7 = r7.emit(r8, r0)
                        if (r7 != r1) goto L5f
                        return r1
                    L5f:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flow$paging_common_release.collect(new AnonymousClass2(flowCollector, predicate), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, pagingData.getUiReceiver(), pagingData.getHintReceiver(), null, 8, null);
    }

    public static final /* synthetic */ PagingData map(PagingData pagingData, final Function2 transform) {
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final Flow flow$paging_common_release = pagingData.getFlow$paging_common_release();
        return new PagingData(new Flow() { // from class: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Function2 $transform$inlined;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2", f = "PagingDataTransforms.kt", l = {225, 223}, m = "emit")
                /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
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

                public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform$inlined = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2$1 r0 = (androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2$1 r0 = new androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L5f
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.L$0
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L53
                    L3c:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                        androidx.paging.PageEvent r7 = (androidx.paging.PageEvent) r7
                        kotlin.jvm.functions.Function2 r2 = r6.$transform$inlined
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r7 = r7.map(r2, r0)
                        if (r7 != r1) goto L50
                        return r1
                    L50:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L53:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r7 = r7.emit(r8, r0)
                        if (r7 != r1) goto L5f
                        return r1
                    L5f:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flow$paging_common_release.collect(new AnonymousClass2(flowCollector, transform), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, pagingData.getUiReceiver(), pagingData.getHintReceiver(), null, 8, null);
    }

    public static /* synthetic */ PagingData insertSeparators$default(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
        }
        return insertSeparators(pagingData, terminalSeparatorType, function3);
    }

    public static final /* synthetic */ PagingData insertSeparators(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Function3 generator) {
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(generator, "generator");
        return new PagingData(SeparatorsKt.insertEventSeparators(pagingData.getFlow$paging_common_release(), terminalSeparatorType, generator), pagingData.getUiReceiver(), pagingData.getHintReceiver(), null, 8, null);
    }

    public static /* synthetic */ PagingData insertFooterItem$default(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
        }
        return PagingDataTransforms.insertFooterItem(pagingData, terminalSeparatorType, obj);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: PagingDataTransforms.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0001H\u008a@"}, d2 = {"<anonymous>", "T", "", "<anonymous parameter 0>", "after"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransformsKt$insertFooterItem$1", f = "PagingDataTransforms.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$insertFooterItem$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends SuspendLambda implements Function3<T, T, Continuation<? super T>, Object> {
        final /* synthetic */ T $item;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(T t, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$item = t;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(T t, T t2, Continuation<? super T> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$item, continuation);
            anonymousClass1.L$0 = t2;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.L$0 == null) {
                return this.$item;
            }
            return null;
        }
    }

    public static final <T> PagingData<T> insertFooterItem(PagingData<T> pagingData, TerminalSeparatorType terminalSeparatorType, T item) {
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(item, "item");
        return insertSeparators(pagingData, terminalSeparatorType, new AnonymousClass1(item, null));
    }
}
