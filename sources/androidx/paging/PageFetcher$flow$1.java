package androidx.paging;

import androidx.paging.PageFetcher;
import kotlin.Function;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* compiled from: PageFetcher.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PagingData;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1", f = "PageFetcher.kt", l = {136}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class PageFetcher$flow$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PagingData<Value>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PageFetcher<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcher$flow$1(RemoteMediator<Key, Value> remoteMediator, PageFetcher<Key, Value> pageFetcher, Continuation<? super PageFetcher$flow$1> continuation) {
        super(2, continuation);
        this.this$0 = pageFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PageFetcher$flow$1 pageFetcher$flow$1 = new PageFetcher$flow$1(null, this.this$0, continuation);
        pageFetcher$flow$1.L$0 = obj;
        return pageFetcher$flow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SimpleProducerScope<PagingData<Value>> simpleProducerScope, Continuation<? super Unit> continuation) {
        return ((PageFetcher$flow$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            Flow flowSimpleTransformLatest = FlowExtKt.simpleTransformLatest(FlowKt.filterNotNull(FlowExtKt.simpleScan(FlowKt.onStart(((PageFetcher) this.this$0).refreshEvents.getFlow(), new AnonymousClass1(null, null)), null, new AnonymousClass2(null, this.this$0, null))), new PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(null, this.this$0, null));
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(simpleProducerScope);
            this.label = 1;
            if (flowSimpleTransformLatest.collect(anonymousClass4, this) == coroutine_suspended) {
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

    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$1", f = "PageFetcher.kt", l = {63, 63}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcher$flow$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $remoteMediatorAccessor;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$remoteMediatorAccessor, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.throwOnFailure(r7)
                goto L53
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3a
            L23:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                r1 = r7
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                androidx.paging.RemoteMediatorAccessor<Key, Value> r7 = r6.$remoteMediatorAccessor
                if (r7 == 0) goto L3d
                r6.L$0 = r1
                r6.label = r4
                java.lang.Object r7 = r7.initialize(r6)
                if (r7 != r0) goto L3a
                return r0
            L3a:
                androidx.paging.RemoteMediator$InitializeAction r7 = (androidx.paging.RemoteMediator.InitializeAction) r7
                goto L3e
            L3d:
                r7 = r2
            L3e:
                androidx.paging.RemoteMediator$InitializeAction r5 = androidx.paging.RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH
                if (r7 != r5) goto L43
                goto L44
            L43:
                r4 = 0
            L44:
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
                r6.L$0 = r2
                r6.label = r3
                java.lang.Object r7 = r1.emit(r7, r6)
                if (r7 != r0) goto L53
                return r0
            L53:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher$flow$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [Key] */
    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "Value", "", "previousGeneration", "triggerRemoteRefresh", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$2", f = "PageFetcher.kt", l = {73, 77}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcher$flow$1$2, reason: invalid class name */
    static final class AnonymousClass2<Key> extends SuspendLambda implements Function3<PageFetcher.GenerationInfo<Key, Value>, Boolean, Continuation<? super PageFetcher.GenerationInfo<Key, Value>>, Object> {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $remoteMediatorAccessor;
        /* synthetic */ Object L$0;
        Object L$1;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor, PageFetcher<Key, Value> pageFetcher, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = pageFetcher;
        }

        public final Object invoke(PageFetcher.GenerationInfo<Key, Value> generationInfo, boolean z, Continuation<? super PageFetcher.GenerationInfo<Key, Value>> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$remoteMediatorAccessor, this.this$0, continuation);
            anonymousClass2.L$0 = generationInfo;
            anonymousClass2.Z$0 = z;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Boolean bool, Object obj2) {
            return invoke((PageFetcher.GenerationInfo) obj, bool.booleanValue(), (Continuation) obj2);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x008c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0106  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 313
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher$flow$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: PageFetcher.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.paging.PageFetcher$flow$1$2$1, reason: invalid class name */
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
            AnonymousClass1(Object obj) {
                super(0, obj, PageFetcher.class, "refresh", "refresh()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((PageFetcher) this.receiver).refresh();
            }
        }
    }

    /* compiled from: PageFetcher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.paging.PageFetcher$flow$1$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 implements FlowCollector, FunctionAdapter {
        final /* synthetic */ SimpleProducerScope<PagingData<Value>> $tmp0;

        AnonymousClass4(SimpleProducerScope<PagingData<Value>> simpleProducerScope) {
            this.$tmp0 = simpleProducerScope;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(2, this.$tmp0, SimpleProducerScope.class, "send", "send(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(PagingData<Value> pagingData, Continuation<? super Unit> continuation) {
            Object objSend = this.$tmp0.send(pagingData, continuation);
            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((PagingData) obj, (Continuation<? super Unit>) continuation);
        }
    }
}
