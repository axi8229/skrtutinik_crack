package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: CachedPageEventFlow.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$job$1", f = "CachedPageEventFlow.kt", l = {76}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class CachedPageEventFlow$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<PageEvent<T>> $src;
    int label;
    final /* synthetic */ CachedPageEventFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CachedPageEventFlow$job$1(Flow<? extends PageEvent<T>> flow, CachedPageEventFlow<T> cachedPageEventFlow, Continuation<? super CachedPageEventFlow$job$1> continuation) {
        super(2, continuation);
        this.$src = flow;
        this.this$0 = cachedPageEventFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CachedPageEventFlow$job$1(this.$src, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CachedPageEventFlow$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowWithIndex = FlowKt.withIndex(this.$src);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (flowWithIndex.collect(anonymousClass1, this) == coroutine_suspended) {
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

    /* compiled from: CachedPageEventFlow.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0005H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "", "it", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "emit", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.paging.CachedPageEventFlow$job$1$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ CachedPageEventFlow<T> this$0;

        AnonymousClass1(CachedPageEventFlow<T> cachedPageEventFlow) {
            this.this$0 = cachedPageEventFlow;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((IndexedValue) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(kotlin.collections.IndexedValue<? extends androidx.paging.PageEvent<T>> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.CachedPageEventFlow$job$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r7
                androidx.paging.CachedPageEventFlow$job$1$1$emit$1 r0 = (androidx.paging.CachedPageEventFlow$job$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.paging.CachedPageEventFlow$job$1$1$emit$1 r0 = new androidx.paging.CachedPageEventFlow$job$1$1$emit$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.throwOnFailure(r7)
                goto L6b
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                java.lang.Object r6 = r0.L$1
                kotlin.collections.IndexedValue r6 = (kotlin.collections.IndexedValue) r6
                java.lang.Object r2 = r0.L$0
                androidx.paging.CachedPageEventFlow$job$1$1 r2 = (androidx.paging.CachedPageEventFlow$job$1.AnonymousClass1) r2
                kotlin.ResultKt.throwOnFailure(r7)
                goto L57
            L40:
                kotlin.ResultKt.throwOnFailure(r7)
                androidx.paging.CachedPageEventFlow<T> r7 = r5.this$0
                kotlinx.coroutines.flow.MutableSharedFlow r7 = androidx.paging.CachedPageEventFlow.access$getMutableSharedSrc$p(r7)
                r0.L$0 = r5
                r0.L$1 = r6
                r0.label = r4
                java.lang.Object r7 = r7.emit(r6, r0)
                if (r7 != r1) goto L56
                return r1
            L56:
                r2 = r5
            L57:
                androidx.paging.CachedPageEventFlow<T> r7 = r2.this$0
                androidx.paging.FlattenedPageController r7 = androidx.paging.CachedPageEventFlow.access$getPageController$p(r7)
                r2 = 0
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r3
                java.lang.Object r6 = r7.record(r6, r0)
                if (r6 != r1) goto L6b
                return r1
            L6b:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CachedPageEventFlow$job$1.AnonymousClass1.emit(kotlin.collections.IndexedValue, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
