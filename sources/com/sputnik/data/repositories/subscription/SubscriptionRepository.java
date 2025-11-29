package com.sputnik.data.repositories.subscription;

import com.sputnik.data.api.SubscriptionApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.card.DataPaymentState;
import com.sputnik.data.entities.market.subscription.DataSubscriptionStart;
import com.sputnik.data.mappers.card.DataPaymentStateToDomainPaymentStateMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionStartToDomainSubscriptionStartMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.card.DomainPaymentState;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionStart;
import com.sputnik.domain.repositories.subscription.ISubscriptionRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import retrofit2.Response;

/* compiled from: SubscriptionRepository.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J8\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/sputnik/data/repositories/subscription/SubscriptionRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/subscription/ISubscriptionRepository;", "subscriptionApi", "Lcom/sputnik/data/api/SubscriptionApi;", "dataPaymentStateToDomainPaymentStateMapper", "Lcom/sputnik/data/mappers/card/DataPaymentStateToDomainPaymentStateMapper;", "dataSubscriptionStartToDomainSubscriptionStartMapper", "Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionStartToDomainSubscriptionStartMapper;", "(Lcom/sputnik/data/api/SubscriptionApi;Lcom/sputnik/data/mappers/card/DataPaymentStateToDomainPaymentStateMapper;Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionStartToDomainSubscriptionStartMapper;)V", "getLastCardPayment", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/card/DomainPaymentState;", "id", "", "startSubscription", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionStart;", "plan", "paymentToken", "paymentMethod", "stopSubscription", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscriptionRepository extends BaseApiResponse implements ISubscriptionRepository {
    private final DataPaymentStateToDomainPaymentStateMapper dataPaymentStateToDomainPaymentStateMapper;
    private final DataSubscriptionStartToDomainSubscriptionStartMapper dataSubscriptionStartToDomainSubscriptionStartMapper;
    private final SubscriptionApi subscriptionApi;

    public SubscriptionRepository(SubscriptionApi subscriptionApi, DataPaymentStateToDomainPaymentStateMapper dataPaymentStateToDomainPaymentStateMapper, DataSubscriptionStartToDomainSubscriptionStartMapper dataSubscriptionStartToDomainSubscriptionStartMapper) {
        Intrinsics.checkNotNullParameter(subscriptionApi, "subscriptionApi");
        Intrinsics.checkNotNullParameter(dataPaymentStateToDomainPaymentStateMapper, "dataPaymentStateToDomainPaymentStateMapper");
        Intrinsics.checkNotNullParameter(dataSubscriptionStartToDomainSubscriptionStartMapper, "dataSubscriptionStartToDomainSubscriptionStartMapper");
        this.subscriptionApi = subscriptionApi;
        this.dataPaymentStateToDomainPaymentStateMapper = dataPaymentStateToDomainPaymentStateMapper;
        this.dataSubscriptionStartToDomainSubscriptionStartMapper = dataSubscriptionStartToDomainSubscriptionStartMapper;
    }

    /* compiled from: SubscriptionRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionStart;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.subscription.SubscriptionRepository$startSubscription$1", f = "SubscriptionRepository.kt", l = {30, 30}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.subscription.SubscriptionRepository$startSubscription$1, reason: invalid class name and case insensitive filesystem */
    static final class C07421 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataSubscriptionStart>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ String $paymentMethod;
        final /* synthetic */ String $paymentToken;
        final /* synthetic */ String $plan;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07421(String str, String str2, String str3, String str4, Continuation<? super C07421> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$plan = str2;
            this.$paymentToken = str3;
            this.$paymentMethod = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07421 c07421 = SubscriptionRepository.this.new C07421(this.$id, this.$plan, this.$paymentToken, this.$paymentMethod, continuation);
            c07421.L$0 = obj;
            return c07421;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataSubscriptionStart>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataSubscriptionStart>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataSubscriptionStart>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07421) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SubscriptionRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionStart;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.subscription.SubscriptionRepository$startSubscription$1$1", f = "SubscriptionRepository.kt", l = {31}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.subscription.SubscriptionRepository$startSubscription$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02661 extends SuspendLambda implements Function1<Continuation<? super Response<DataSubscriptionStart>>, Object> {
            final /* synthetic */ String $id;
            final /* synthetic */ String $paymentMethod;
            final /* synthetic */ String $paymentToken;
            final /* synthetic */ String $plan;
            int label;
            final /* synthetic */ SubscriptionRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02661(SubscriptionRepository subscriptionRepository, String str, String str2, String str3, String str4, Continuation<? super C02661> continuation) {
                super(1, continuation);
                this.this$0 = subscriptionRepository;
                this.$id = str;
                this.$plan = str2;
                this.$paymentToken = str3;
                this.$paymentMethod = str4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02661(this.this$0, this.$id, this.$plan, this.$paymentToken, this.$paymentMethod, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataSubscriptionStart>> continuation) {
                return ((C02661) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SubscriptionApi subscriptionApi = this.this$0.subscriptionApi;
                    String str = this.$id;
                    String str2 = this.$plan;
                    String str3 = this.$paymentToken;
                    String str4 = this.$paymentMethod;
                    this.label = 1;
                    obj = subscriptionApi.startSubscription(str, str2, str3, str4, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                SubscriptionRepository subscriptionRepository = SubscriptionRepository.this;
                C02661 c02661 = new C02661(subscriptionRepository, this.$id, this.$plan, this.$paymentToken, this.$paymentMethod, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = subscriptionRepository.safeApiCall(c02661, this);
                if (obj == coroutine_suspended) {
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
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.sputnik.domain.repositories.subscription.ISubscriptionRepository
    public Flow<Resource<DomainSubscriptionStart>> startSubscription(String id, String plan, String paymentToken, String paymentMethod) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(plan, "plan");
        return FlowKt.flow(new SubscriptionRepository$startSubscription$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07421(id, plan, paymentToken, paymentMethod, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: SubscriptionRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/card/DataPaymentState;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.subscription.SubscriptionRepository$getLastCardPayment$1", f = "SubscriptionRepository.kt", l = {45, 45}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.subscription.SubscriptionRepository$getLastCardPayment$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPaymentState>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = SubscriptionRepository.this.new AnonymousClass1(this.$id, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPaymentState>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPaymentState>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPaymentState>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SubscriptionRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/card/DataPaymentState;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.subscription.SubscriptionRepository$getLastCardPayment$1$1", f = "SubscriptionRepository.kt", l = {45}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.subscription.SubscriptionRepository$getLastCardPayment$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02651 extends SuspendLambda implements Function1<Continuation<? super Response<DataPaymentState>>, Object> {
            final /* synthetic */ String $id;
            int label;
            final /* synthetic */ SubscriptionRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02651(SubscriptionRepository subscriptionRepository, String str, Continuation<? super C02651> continuation) {
                super(1, continuation);
                this.this$0 = subscriptionRepository;
                this.$id = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02651(this.this$0, this.$id, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPaymentState>> continuation) {
                return ((C02651) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SubscriptionApi subscriptionApi = this.this$0.subscriptionApi;
                    String str = this.$id;
                    this.label = 1;
                    obj = subscriptionApi.getLastPaymentStatus(str, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                SubscriptionRepository subscriptionRepository = SubscriptionRepository.this;
                C02651 c02651 = new C02651(subscriptionRepository, this.$id, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = subscriptionRepository.safeApiCall(c02651, this);
                if (obj == coroutine_suspended) {
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
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.sputnik.domain.repositories.subscription.ISubscriptionRepository
    public Flow<Resource<DomainPaymentState>> getLastCardPayment(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.flow(new SubscriptionRepository$getLastCardPayment$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(id, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: SubscriptionRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.subscription.SubscriptionRepository$stopSubscription$1", f = "SubscriptionRepository.kt", l = {53, 53}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.subscription.SubscriptionRepository$stopSubscription$1, reason: invalid class name and case insensitive filesystem */
    static final class C07431 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07431(String str, Continuation<? super C07431> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07431 c07431 = SubscriptionRepository.this.new C07431(this.$id, continuation);
            c07431.L$0 = obj;
            return c07431;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07431) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SubscriptionRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.subscription.SubscriptionRepository$stopSubscription$1$1", f = "SubscriptionRepository.kt", l = {53}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.subscription.SubscriptionRepository$stopSubscription$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02671 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $id;
            int label;
            final /* synthetic */ SubscriptionRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02671(SubscriptionRepository subscriptionRepository, String str, Continuation<? super C02671> continuation) {
                super(1, continuation);
                this.this$0 = subscriptionRepository;
                this.$id = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02671(this.this$0, this.$id, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02671) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SubscriptionApi subscriptionApi = this.this$0.subscriptionApi;
                    String str = this.$id;
                    this.label = 1;
                    obj = subscriptionApi.cancelSubscription(str, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                SubscriptionRepository subscriptionRepository = SubscriptionRepository.this;
                C02671 c02671 = new C02671(subscriptionRepository, this.$id, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = subscriptionRepository.safeApiCall(c02671, this);
                if (obj == coroutine_suspended) {
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
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.sputnik.domain.repositories.subscription.ISubscriptionRepository
    public Flow<Resource<Unit>> stopSubscription(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.flowOn(FlowKt.flow(new C07431(id, null)), Dispatchers.getIO());
    }
}
