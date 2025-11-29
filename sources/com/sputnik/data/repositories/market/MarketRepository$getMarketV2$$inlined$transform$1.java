package com.sputnik.data.repositories.market;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.subscriptions.DomainMarketV2;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1", f = "MarketRepository.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MarketRepository$getMarketV2$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DomainMarketV2>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MarketRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketRepository$getMarketV2$$inlined$transform$1(Flow flow, Continuation continuation, MarketRepository marketRepository) {
        super(2, continuation);
        this.$this_transform = flow;
        this.this$0 = marketRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MarketRepository$getMarketV2$$inlined$transform$1 marketRepository$getMarketV2$$inlined$transform$1 = new MarketRepository$getMarketV2$$inlined$transform$1(this.$this_transform, continuation, this.this$0);
        marketRepository$getMarketV2$$inlined$transform$1.L$0 = obj;
        return marketRepository$getMarketV2$$inlined$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Resource<? extends DomainMarketV2>> flowCollector, Continuation<? super Unit> continuation) {
        return ((MarketRepository$getMarketV2$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<Resource<? extends DomainMarketV2>> $$this$flow;
        final /* synthetic */ MarketRepository this$0;

        /* compiled from: Emitters.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1$1", f = "MarketRepository.kt", l = {224, 226}, m = "emit")
        /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02091 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            /* synthetic */ Object result;

            public C02091(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, MarketRepository marketRepository) {
            this.this$0 = marketRepository;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(3:12|31|32)(2:13|14))(1:15))(2:16|(2:18|(1:20)(1:21))(7:23|33|24|28|(1:30)|31|32))|22|33|24|28|(0)|31|32) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0085, code lost:
        
            r13 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
        
            r13.printStackTrace();
            r13 = com.sputnik.domain.common.Resource.INSTANCE.success(new com.sputnik.domain.entities.subscriptions.DomainMarketV2(null, null, null, 4, null));
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
            /*
                r12 = this;
                boolean r0 = r14 instanceof com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1.AnonymousClass1.C02091
                if (r0 == 0) goto L13
                r0 = r14
                com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1$1$1 r0 = (com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1.AnonymousClass1.C02091) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1$1$1 r0 = new com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1$1$1
                r0.<init>(r14)
            L18:
                java.lang.Object r14 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L45
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.throwOnFailure(r14)
                goto Laa
            L2d:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L35:
                java.lang.Object r13 = r0.L$2
                kotlinx.coroutines.flow.FlowCollector r13 = (kotlinx.coroutines.flow.FlowCollector) r13
                java.lang.Object r2 = r0.L$1
                com.sputnik.domain.common.Resource r2 = (com.sputnik.domain.common.Resource) r2
                java.lang.Object r4 = r0.L$0
                com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1$1 r4 = (com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1.AnonymousClass1) r4
                kotlin.ResultKt.throwOnFailure(r14)
                goto L76
            L45:
                kotlin.ResultKt.throwOnFailure(r14)
                kotlinx.coroutines.flow.FlowCollector<com.sputnik.domain.common.Resource<? extends com.sputnik.domain.entities.subscriptions.DomainMarketV2>> r14 = r12.$$this$flow
                r2 = r13
                com.sputnik.domain.common.Resource r2 = (com.sputnik.domain.common.Resource) r2
                java.lang.Exception r13 = r2.getError()
                boolean r13 = r13 instanceof com.google.gson.JsonSyntaxException
                if (r13 == 0) goto L78
                com.sputnik.domain.common.Resource$Success r13 = new com.sputnik.domain.common.Resource$Success
                com.sputnik.domain.entities.subscriptions.DomainMarketV2 r11 = new com.sputnik.domain.entities.subscriptions.DomainMarketV2
                r9 = 7
                r10 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r5 = r11
                r5.<init>(r6, r7, r8, r9, r10)
                r13.<init>(r11)
                r0.L$0 = r12
                r0.L$1 = r2
                r0.L$2 = r14
                r0.label = r4
                java.lang.Object r13 = r14.emit(r13, r0)
                if (r13 != r1) goto L74
                return r1
            L74:
                r4 = r12
                r13 = r14
            L76:
                r14 = r13
                goto L79
            L78:
                r4 = r12
            L79:
                com.sputnik.data.repositories.market.MarketRepository$getMarketV2$2$1 r13 = new com.sputnik.data.repositories.market.MarketRepository$getMarketV2$2$1     // Catch: java.lang.Exception -> L85
                com.sputnik.data.repositories.market.MarketRepository r4 = r4.this$0     // Catch: java.lang.Exception -> L85
                r13.<init>()     // Catch: java.lang.Exception -> L85
                com.sputnik.domain.common.Resource r13 = r2.map(r13)     // Catch: java.lang.Exception -> L85
                goto L9a
            L85:
                r13 = move-exception
                r13.printStackTrace()
                com.sputnik.domain.common.Resource$Companion r13 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.entities.subscriptions.DomainMarketV2 r2 = new com.sputnik.domain.entities.subscriptions.DomainMarketV2
                r8 = 4
                r9 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r4 = r2
                r4.<init>(r5, r6, r7, r8, r9)
                com.sputnik.domain.common.Resource r13 = r13.success(r2)
            L9a:
                r2 = 0
                r0.L$0 = r2
                r0.L$1 = r2
                r0.L$2 = r2
                r0.label = r3
                java.lang.Object r13 = r14.emit(r13, r0)
                if (r13 != r1) goto Laa
                return r1
            Laa:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.market.MarketRepository$getMarketV2$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
