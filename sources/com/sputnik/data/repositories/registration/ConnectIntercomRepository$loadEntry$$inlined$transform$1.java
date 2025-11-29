package com.sputnik.data.repositories.registration;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.entry.DomainEntry;
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
@DebugMetadata(c = "com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1", f = "ConnectIntercomRepository.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ConnectIntercomRepository$loadEntry$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DomainEntry>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConnectIntercomRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectIntercomRepository$loadEntry$$inlined$transform$1(Flow flow, Continuation continuation, ConnectIntercomRepository connectIntercomRepository) {
        super(2, continuation);
        this.$this_transform = flow;
        this.this$0 = connectIntercomRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConnectIntercomRepository$loadEntry$$inlined$transform$1 connectIntercomRepository$loadEntry$$inlined$transform$1 = new ConnectIntercomRepository$loadEntry$$inlined$transform$1(this.$this_transform, continuation, this.this$0);
        connectIntercomRepository$loadEntry$$inlined$transform$1.L$0 = obj;
        return connectIntercomRepository$loadEntry$$inlined$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Resource<? extends DomainEntry>> flowCollector, Continuation<? super Unit> continuation) {
        return ((ConnectIntercomRepository$loadEntry$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
    /* renamed from: com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<Resource<? extends DomainEntry>> $$this$flow;
        final /* synthetic */ ConnectIntercomRepository this$0;

        /* compiled from: Emitters.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1$1", f = "ConnectIntercomRepository.kt", l = {223}, m = "emit")
        /* renamed from: com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02441 extends ContinuationImpl {
            int label;
            /* synthetic */ Object result;

            public C02441(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, ConnectIntercomRepository connectIntercomRepository) {
            this.this$0 = connectIntercomRepository;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1.AnonymousClass1.C02441
                if (r0 == 0) goto L13
                r0 = r7
                com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1$1$1 r0 = (com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1.AnonymousClass1.C02441) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1$1$1 r0 = new com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1$1$1
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.throwOnFailure(r7)
                goto L50
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.flow.FlowCollector<com.sputnik.domain.common.Resource<? extends com.sputnik.domain.entities.entry.DomainEntry>> r7 = r5.$$this$flow
                com.sputnik.domain.common.Resource r6 = (com.sputnik.domain.common.Resource) r6
                com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$2$1 r2 = new com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$2$1
                com.sputnik.data.repositories.registration.ConnectIntercomRepository r4 = r5.this$0
                com.sputnik.data.mappers.entry.DataEntryToDomainEntryMapper r4 = com.sputnik.data.repositories.registration.ConnectIntercomRepository.access$getDataEntryToDomainEntryMapper$p(r4)
                r2.<init>(r4)
                com.sputnik.domain.common.Resource r6 = r6.map(r2)
                r0.label = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L50
                return r1
            L50:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
