package androidx.paging;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a]\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u00012(\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0000¢\u0006\u0004\b\b\u0010\t\u001aO\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022(\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022.\u0010\u000e\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u000b\"\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/Flow;", "initial", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "operation", "simpleScan", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "simpleRunningReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "transform", "simpleTransformLatest", "NULL", "Ljava/lang/Object;", "paging-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowExtKt {
    private static final Object NULL = new Object();

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: FlowExt.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleScan$1", f = "FlowExt.kt", l = {54, 55}, m = "invokeSuspend")
    /* renamed from: androidx.paging.FlowExtKt$simpleScan$1, reason: invalid class name and case insensitive filesystem */
    static final class C04811<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ R $initial;
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;
        final /* synthetic */ Flow<T> $this_simpleScan;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04811(R r, Flow<? extends T> flow, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super C04811> continuation) {
            super(2, continuation);
            this.$initial = r;
            this.$this_simpleScan = flow;
            this.$operation = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04811 c04811 = new C04811(this.$initial, this.$this_simpleScan, this.$operation, continuation);
            c04811.L$0 = obj;
            return c04811;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
            return ((C04811) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref$ObjectRef ref$ObjectRef;
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                ref$ObjectRef = new Ref$ObjectRef();
                R r = this.$initial;
                ref$ObjectRef.element = r;
                this.L$0 = flowCollector2;
                this.L$1 = ref$ObjectRef;
                this.label = 1;
                if (flowCollector2.emit(r, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector2;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ref$ObjectRef = (Ref$ObjectRef) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Flow<T> flow = this.$this_simpleScan;
            C00531 c00531 = new C00531(ref$ObjectRef, this.$operation, flowCollector);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (flow.collect(c00531, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* compiled from: FlowExt.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.paging.FlowExtKt$simpleScan$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00531<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<R> $$this$flow;
            final /* synthetic */ Ref$ObjectRef<R> $accumulator;
            final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;

            /* JADX WARN: Multi-variable type inference failed */
            C00531(Ref$ObjectRef<R> ref$ObjectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, FlowCollector<? super R> flowCollector) {
                this.$accumulator = ref$ObjectRef;
                this.$operation = function3;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(T r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof androidx.paging.FlowExtKt$simpleScan$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r9
                    androidx.paging.FlowExtKt$simpleScan$1$1$emit$1 r0 = (androidx.paging.FlowExtKt$simpleScan$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    androidx.paging.FlowExtKt$simpleScan$1$1$emit$1 r0 = new androidx.paging.FlowExtKt$simpleScan$1$1$emit$1
                    r0.<init>(r7, r9)
                L18:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L40
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L70
                L2c:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L34:
                    java.lang.Object r8 = r0.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref$ObjectRef) r8
                    java.lang.Object r2 = r0.L$0
                    androidx.paging.FlowExtKt$simpleScan$1$1 r2 = (androidx.paging.FlowExtKt.C04811.C00531) r2
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L5a
                L40:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlin.jvm.internal.Ref$ObjectRef<R> r9 = r7.$accumulator
                    kotlin.jvm.functions.Function3<R, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r2 = r7.$operation
                    T r5 = r9.element
                    r0.L$0 = r7
                    r0.L$1 = r9
                    r0.label = r4
                    java.lang.Object r8 = r2.invoke(r5, r8, r0)
                    if (r8 != r1) goto L56
                    return r1
                L56:
                    r2 = r7
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L5a:
                    r8.element = r9
                    kotlinx.coroutines.flow.FlowCollector<R> r8 = r2.$$this$flow
                    kotlin.jvm.internal.Ref$ObjectRef<R> r9 = r2.$accumulator
                    T r9 = r9.element
                    r2 = 0
                    r0.L$0 = r2
                    r0.L$1 = r2
                    r0.label = r3
                    java.lang.Object r8 = r8.emit(r9, r0)
                    if (r8 != r1) goto L70
                    return r1
                L70:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt.C04811.C00531.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }

    public static final <T, R> Flow<R> simpleScan(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return FlowKt.flow(new C04811(r, flow, operation, null));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowExt.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleRunningReduce$1", f = "FlowExt.kt", l = {68}, m = "invokeSuspend")
    /* renamed from: androidx.paging.FlowExtKt$simpleRunningReduce$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
        final /* synthetic */ Flow<T> $this_simpleRunningReduce;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T> flow, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_simpleRunningReduce = flow;
            this.$operation = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_simpleRunningReduce, this.$operation, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = (T) FlowExtKt.NULL;
                Flow<T> flow = this.$this_simpleRunningReduce;
                C00521 c00521 = new C00521(ref$ObjectRef, this.$operation, flowCollector);
                this.label = 1;
                if (flow.collect(c00521, this) == coroutine_suspended) {
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

        /* compiled from: FlowExt.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", AppMeasurementSdk.ConditionalUserProperty.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.paging.FlowExtKt$simpleRunningReduce$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00521<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<T> $$this$flow;
            final /* synthetic */ Ref$ObjectRef<Object> $accumulator;
            final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;

            /* JADX WARN: Multi-variable type inference failed */
            C00521(Ref$ObjectRef<Object> ref$ObjectRef, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, FlowCollector<? super T> flowCollector) {
                this.$accumulator = ref$ObjectRef;
                this.$operation = function3;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(T r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r9
                    androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1 r0 = (androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1 r0 = new androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1
                    r0.<init>(r7, r9)
                L18:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L40
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L7f
                L2c:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L34:
                    java.lang.Object r8 = r0.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref$ObjectRef) r8
                    java.lang.Object r2 = r0.L$0
                    androidx.paging.FlowExtKt$simpleRunningReduce$1$1 r2 = (androidx.paging.FlowExtKt.AnonymousClass1.C00521) r2
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L66
                L40:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r7.$accumulator
                    T r2 = r9.element
                    java.lang.Object r5 = androidx.paging.FlowExtKt.access$getNULL$p()
                    if (r2 != r5) goto L4f
                    r2 = r7
                    goto L69
                L4f:
                    kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super T>, java.lang.Object> r2 = r7.$operation
                    kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r5 = r7.$accumulator
                    T r5 = r5.element
                    r0.L$0 = r7
                    r0.L$1 = r9
                    r0.label = r4
                    java.lang.Object r8 = r2.invoke(r5, r8, r0)
                    if (r8 != r1) goto L62
                    return r1
                L62:
                    r2 = r7
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L66:
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L69:
                    r9.element = r8
                    kotlinx.coroutines.flow.FlowCollector<T> r8 = r2.$$this$flow
                    kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r2.$accumulator
                    T r9 = r9.element
                    r2 = 0
                    r0.L$0 = r2
                    r0.L$1 = r2
                    r0.label = r3
                    java.lang.Object r8 = r8.emit(r9, r0)
                    if (r8 != r1) goto L7f
                    return r1
                L7f:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt.AnonymousClass1.C00521.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }

    public static final <T> Flow<T> simpleRunningReduce(Flow<? extends T> flow, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return FlowKt.flow(new AnonymousClass1(flow, operation, null));
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: FlowExt.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Landroidx/paging/SimpleProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1", f = "FlowExt.kt", l = {88}, m = "invokeSuspend")
    /* renamed from: androidx.paging.FlowExtKt$simpleTransformLatest$1, reason: invalid class name and case insensitive filesystem */
    static final class C04821<R> extends SuspendLambda implements Function2<SimpleProducerScope<R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T> $this_simpleTransformLatest;
        final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04821(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super C04821> continuation) {
            super(2, continuation);
            this.$this_simpleTransformLatest = flow;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04821 c04821 = new C04821(this.$this_simpleTransformLatest, this.$transform, continuation);
            c04821.L$0 = obj;
            return c04821;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SimpleProducerScope<R> simpleProducerScope, Continuation<? super Unit> continuation) {
            return ((C04821) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
                Flow<T> flow = this.$this_simpleTransformLatest;
                C00541 c00541 = new C00541(this.$transform, new ChannelFlowCollector(simpleProducerScope), null);
                this.label = 1;
                if (FlowKt.collectLatest(flow, c00541, this) == coroutine_suspended) {
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

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* compiled from: FlowExt.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1$1", f = "FlowExt.kt", l = {89}, m = "invokeSuspend")
        /* renamed from: androidx.paging.FlowExtKt$simpleTransformLatest$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00541<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChannelFlowCollector<R> $collector;
            final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> $transform;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00541(Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, ChannelFlowCollector<R> channelFlowCollector, Continuation<? super C00541> continuation) {
                super(2, continuation);
                this.$transform = function3;
                this.$collector = channelFlowCollector;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00541 c00541 = new C00541(this.$transform, this.$collector, continuation);
                c00541.L$0 = obj;
                return c00541;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
                return invoke2((C00541<T>) obj, continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(T t, Continuation<? super Unit> continuation) {
                return ((C00541) create(t, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = this.L$0;
                    Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> function3 = this.$transform;
                    ChannelFlowCollector<R> channelFlowCollector = this.$collector;
                    this.label = 1;
                    if (function3.invoke(channelFlowCollector, obj2, this) == coroutine_suspended) {
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
        }
    }

    public static final <T, R> Flow<R> simpleTransformLatest(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return SimpleChannelFlowKt.simpleChannelFlow(new C04821(flow, transform, null));
    }
}
