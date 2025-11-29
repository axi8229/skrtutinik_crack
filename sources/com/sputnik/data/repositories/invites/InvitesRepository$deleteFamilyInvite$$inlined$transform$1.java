package com.sputnik.data.repositories.invites;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.invites.DomainFamilyInvite;
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
@DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1", f = "InvitesRepository.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class InvitesRepository$deleteFamilyInvite$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DomainFamilyInvite>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvitesRepository$deleteFamilyInvite$$inlined$transform$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$this_transform = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InvitesRepository$deleteFamilyInvite$$inlined$transform$1 invitesRepository$deleteFamilyInvite$$inlined$transform$1 = new InvitesRepository$deleteFamilyInvite$$inlined$transform$1(this.$this_transform, continuation);
        invitesRepository$deleteFamilyInvite$$inlined$transform$1.L$0 = obj;
        return invitesRepository$deleteFamilyInvite$$inlined$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Resource<? extends DomainFamilyInvite>> flowCollector, Continuation<? super Unit> continuation) {
        return ((InvitesRepository$deleteFamilyInvite$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector);
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
    /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<Resource<? extends DomainFamilyInvite>> $$this$flow;

        /* compiled from: Emitters.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1$1", f = "InvitesRepository.kt", l = {223}, m = "emit")
        /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01751 extends ContinuationImpl {
            int label;
            /* synthetic */ Object result;

            public C01751(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector) {
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1.AnonymousClass1.C01751
                if (r0 == 0) goto L13
                r0 = r6
                com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1$1$1 r0 = (com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1.AnonymousClass1.C01751) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1$1$1 r0 = new com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1$1$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.throwOnFailure(r6)
                goto L47
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlinx.coroutines.flow.FlowCollector<com.sputnik.domain.common.Resource<? extends com.sputnik.domain.entities.invites.DomainFamilyInvite>> r6 = r4.$$this$flow
                com.sputnik.domain.common.Resource r5 = (com.sputnik.domain.common.Resource) r5
                com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1 r2 = new kotlin.jvm.functions.Function1<com.sputnik.data.entities.invites.DataFamilyInvite, com.sputnik.domain.entities.invites.DomainFamilyInvite>() { // from class: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1
                    static {
                        /*
                            com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1 r0 = new com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT (r0 I:com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1) com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1.INSTANCE com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1.<clinit>():void");
                    }

                    {
                        /*
                            r1 = this;
                            r0 = 1
                            r1.<init>(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1.<init>():void");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ com.sputnik.domain.entities.invites.DomainFamilyInvite invoke(com.sputnik.data.entities.invites.DataFamilyInvite r1) {
                        /*
                            r0 = this;
                            com.sputnik.data.entities.invites.DataFamilyInvite r1 = (com.sputnik.data.entities.invites.DataFamilyInvite) r1
                            com.sputnik.domain.entities.invites.DomainFamilyInvite r1 = r0.invoke(r1)
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1.invoke(java.lang.Object):java.lang.Object");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final com.sputnik.domain.entities.invites.DomainFamilyInvite invoke(com.sputnik.data.entities.invites.DataFamilyInvite r11) {
                        /*
                            r10 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                            com.sputnik.domain.entities.invites.DomainFamilyInvite r0 = new com.sputnik.domain.entities.invites.DomainFamilyInvite
                            java.lang.Integer r2 = r11.getId()
                            java.lang.String r3 = r11.getPhone()
                            java.lang.String r4 = r11.getState()
                            java.lang.String r5 = r11.getFlatUuid()
                            java.lang.Integer r6 = r11.getFlatNumber()
                            java.lang.String r7 = r11.getFullAddress()
                            java.lang.String r8 = r11.getCreatedAt()
                            java.lang.String r9 = r11.getUpdatedAt()
                            r1 = r0
                            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$2$1.invoke(com.sputnik.data.entities.invites.DataFamilyInvite):com.sputnik.domain.entities.invites.DomainFamilyInvite");
                    }
                }
                com.sputnik.domain.common.Resource r5 = r5.map(r2)
                r0.label = r3
                java.lang.Object r5 = r6.emit(r5, r0)
                if (r5 != r1) goto L47
                return r1
            L47:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
