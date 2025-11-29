package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* compiled from: PageFetcherSnapshot.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PageEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1", f = "PageFetcherSnapshot.kt", l = {646, 168, 657}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class PageFetcherSnapshot$pageEventFlow$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcherSnapshot$pageEventFlow$1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super PageFetcherSnapshot$pageEventFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PageFetcherSnapshot$pageEventFlow$1 pageFetcherSnapshot$pageEventFlow$1 = new PageFetcherSnapshot$pageEventFlow$1(this.this$0, continuation);
        pageFetcherSnapshot$pageEventFlow$1.L$0 = obj;
        return pageFetcherSnapshot$pageEventFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SimpleProducerScope<PageEvent<Value>> simpleProducerScope, Continuation<? super Unit> continuation) {
        return ((PageFetcherSnapshot$pageEventFlow$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2", f = "PageFetcherSnapshot.kt", l = {91}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$cancelableChannelFlow;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, SimpleProducerScope<PageEvent<Value>> simpleProducerScope, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = pageFetcherSnapshot;
            this.$$this$cancelableChannelFlow = simpleProducerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$$this$cancelableChannelFlow, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PageFetcherSnapshot.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/PageEvent;", "emit", "(Landroidx/paging/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$cancelableChannelFlow;

            AnonymousClass1(SimpleProducerScope<PageEvent<Value>> simpleProducerScope) {
                this.$$this$cancelableChannelFlow = simpleProducerScope;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(androidx.paging.PageEvent<Value> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r6
                    androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 r0 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 r0 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.throwOnFailure(r6)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                    goto L3f
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.throwOnFailure(r6)
                    androidx.paging.SimpleProducerScope<androidx.paging.PageEvent<Value>> r6 = r4.$$this$cancelableChannelFlow     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                    r0.label = r3     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                    java.lang.Object r5 = r6.send(r5, r0)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                    if (r5 != r1) goto L3f
                    return r1
                L3f:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1.AnonymousClass2.AnonymousClass1.emit(androidx.paging.PageEvent, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((PageEvent) obj, (Continuation<? super Unit>) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowConsumeAsFlow = FlowKt.consumeAsFlow(((PageFetcherSnapshot) this.this$0).pageEventCh);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$cancelableChannelFlow);
                this.label = 1;
                if (flowConsumeAsFlow.collect(anonymousClass1, this) == coroutine_suspended) {
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

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3", f = "PageFetcherSnapshot.kt", l = {105}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Unit> $retryChannel;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Channel<Unit> channel, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = pageFetcherSnapshot;
            this.$retryChannel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$retryChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flow = ((PageFetcherSnapshot) this.this$0).retryFlow;
                final Channel<Unit> channel = this.$retryChannel;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.paging.PageFetcherSnapshot.pageEventFlow.1.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Unit) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                        channel.mo2240trySendJP2dKIU(unit);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
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

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4", f = "PageFetcherSnapshot.kt", l = {110}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Unit> $retryChannel;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Channel<Unit> channel, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$retryChannel = channel;
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$retryChannel, this.this$0, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Flow flowConsumeAsFlow = FlowKt.consumeAsFlow(this.$retryChannel);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, coroutineScope);
                this.label = 1;
                if (flowConsumeAsFlow.collect(anonymousClass1, this) == coroutine_suspended) {
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

        /* compiled from: PageFetcherSnapshot.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "emit", "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$launch;
            final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

            /* compiled from: PageFetcherSnapshot.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LoadType.values().length];
                    try {
                        iArr[LoadType.REFRESH.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            AnonymousClass1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, CoroutineScope coroutineScope) {
                this.this$0 = pageFetcherSnapshot;
                this.$$this$launch = coroutineScope;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Unit) obj, (Continuation<? super Unit>) continuation);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:107:0x0386  */
            /* JADX WARN: Removed duplicated region for block: B:108:0x038a  */
            /* JADX WARN: Removed duplicated region for block: B:116:0x03de A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:117:0x03df  */
            /* JADX WARN: Removed duplicated region for block: B:120:0x03e7  */
            /* JADX WARN: Removed duplicated region for block: B:126:0x0419  */
            /* JADX WARN: Removed duplicated region for block: B:136:0x0434  */
            /* JADX WARN: Removed duplicated region for block: B:144:0x0471 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:145:0x0472  */
            /* JADX WARN: Removed duplicated region for block: B:153:0x048e  */
            /* JADX WARN: Removed duplicated region for block: B:154:0x0492  */
            /* JADX WARN: Removed duplicated region for block: B:162:0x04e4 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:163:0x04e5  */
            /* JADX WARN: Removed duplicated region for block: B:166:0x04ea  */
            /* JADX WARN: Removed duplicated region for block: B:173:0x051d  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0259  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x026c  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x027a  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x027e  */
            /* JADX WARN: Removed duplicated region for block: B:70:0x02d0 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:71:0x02d1  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x02d9  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x030a  */
            /* JADX WARN: Removed duplicated region for block: B:90:0x0325  */
            /* JADX WARN: Removed duplicated region for block: B:98:0x0367 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:99:0x0368  */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v14, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v39, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v68, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v86 */
            /* JADX WARN: Type inference failed for: r1v87 */
            /* JADX WARN: Type inference failed for: r1v89 */
            /* JADX WARN: Type inference failed for: r1v90 */
            /* JADX WARN: Type inference failed for: r1v92 */
            /* JADX WARN: Type inference failed for: r1v93 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(kotlin.Unit r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
                /*
                    Method dump skipped, instructions count: 1370
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1.AnonymousClass4.AnonymousClass1.emit(kotlin.Unit, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }
}
