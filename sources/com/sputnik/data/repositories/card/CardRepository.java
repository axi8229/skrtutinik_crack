package com.sputnik.data.repositories.card;

import com.sputnik.data.api.CardApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.card.DataConfirmation;
import com.sputnik.data.entities.card.DataPayment;
import com.sputnik.data.entities.card.DataPaymentState;
import com.sputnik.data.mappers.card.DataConfirmationToDomainConfirmationMapper;
import com.sputnik.data.mappers.card.DataPaymentStateToDomainPaymentStateMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.card.DomainConfirmation;
import com.sputnik.domain.entities.card.DomainPaymentState;
import com.sputnik.domain.repositories.card.ICardRepository;
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

/* compiled from: CardRepository.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\f0\u000bH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/sputnik/data/repositories/card/CardRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/card/ICardRepository;", "cardApi", "Lcom/sputnik/data/api/CardApi;", "dataConfirmationToDomainConfirmationMapper", "Lcom/sputnik/data/mappers/card/DataConfirmationToDomainConfirmationMapper;", "dataPaymentStateToDomainPaymentStateMapper", "Lcom/sputnik/data/mappers/card/DataPaymentStateToDomainPaymentStateMapper;", "(Lcom/sputnik/data/api/CardApi;Lcom/sputnik/data/mappers/card/DataConfirmationToDomainConfirmationMapper;Lcom/sputnik/data/mappers/card/DataPaymentStateToDomainPaymentStateMapper;)V", "addNewCard", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/card/DomainConfirmation;", "paymentToken", "", "paymentMethodType", "getLastCardPayment", "Lcom/sputnik/domain/entities/card/DomainPaymentState;", "removeCard", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CardRepository extends BaseApiResponse implements ICardRepository {
    private final CardApi cardApi;
    private final DataConfirmationToDomainConfirmationMapper dataConfirmationToDomainConfirmationMapper;
    private final DataPaymentStateToDomainPaymentStateMapper dataPaymentStateToDomainPaymentStateMapper;

    public CardRepository(CardApi cardApi, DataConfirmationToDomainConfirmationMapper dataConfirmationToDomainConfirmationMapper, DataPaymentStateToDomainPaymentStateMapper dataPaymentStateToDomainPaymentStateMapper) {
        Intrinsics.checkNotNullParameter(cardApi, "cardApi");
        Intrinsics.checkNotNullParameter(dataConfirmationToDomainConfirmationMapper, "dataConfirmationToDomainConfirmationMapper");
        Intrinsics.checkNotNullParameter(dataPaymentStateToDomainPaymentStateMapper, "dataPaymentStateToDomainPaymentStateMapper");
        this.cardApi = cardApi;
        this.dataConfirmationToDomainConfirmationMapper = dataConfirmationToDomainConfirmationMapper;
        this.dataPaymentStateToDomainPaymentStateMapper = dataPaymentStateToDomainPaymentStateMapper;
    }

    /* compiled from: CardRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/card/DataConfirmation;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.card.CardRepository$addNewCard$1", f = "CardRepository.kt", l = {32, 32}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.card.CardRepository$addNewCard$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataConfirmation>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $paymentMethodType;
        final /* synthetic */ String $paymentToken;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$paymentMethodType = str;
            this.$paymentToken = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = CardRepository.this.new AnonymousClass1(this.$paymentMethodType, this.$paymentToken, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataConfirmation>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataConfirmation>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataConfirmation>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CardRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/card/DataConfirmation;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.card.CardRepository$addNewCard$1$1", f = "CardRepository.kt", l = {33}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.card.CardRepository$addNewCard$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01491 extends SuspendLambda implements Function1<Continuation<? super Response<DataConfirmation>>, Object> {
            final /* synthetic */ String $paymentMethodType;
            final /* synthetic */ String $paymentToken;
            int label;
            final /* synthetic */ CardRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01491(CardRepository cardRepository, String str, String str2, Continuation<? super C01491> continuation) {
                super(1, continuation);
                this.this$0 = cardRepository;
                this.$paymentMethodType = str;
                this.$paymentToken = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01491(this.this$0, this.$paymentMethodType, this.$paymentToken, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataConfirmation>> continuation) {
                return ((C01491) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CardApi cardApi = this.this$0.cardApi;
                    DataPayment dataPayment = new DataPayment(this.$paymentMethodType, this.$paymentToken);
                    this.label = 1;
                    obj = cardApi.addNewCard(dataPayment, this);
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
                CardRepository cardRepository = CardRepository.this;
                C01491 c01491 = new C01491(cardRepository, this.$paymentMethodType, this.$paymentToken, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = cardRepository.safeApiCall(c01491, this);
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

    @Override // com.sputnik.domain.repositories.card.ICardRepository
    public Flow<Resource<DomainConfirmation>> addNewCard(String paymentToken, String paymentMethodType) {
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        return FlowKt.flow(new CardRepository$addNewCard$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(paymentMethodType, paymentToken, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: CardRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.card.CardRepository$removeCard$1", f = "CardRepository.kt", l = {47, 47}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.card.CardRepository$removeCard$1, reason: invalid class name and case insensitive filesystem */
    static final class C06921 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C06921(Continuation<? super C06921> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06921 c06921 = CardRepository.this.new C06921(continuation);
            c06921.L$0 = obj;
            return c06921;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06921) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CardRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.card.CardRepository$removeCard$1$1", f = "CardRepository.kt", l = {47}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.card.CardRepository$removeCard$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01511 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            int label;
            final /* synthetic */ CardRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01511(CardRepository cardRepository, Continuation<? super C01511> continuation) {
                super(1, continuation);
                this.this$0 = cardRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01511(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01511) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CardApi cardApi = this.this$0.cardApi;
                    this.label = 1;
                    obj = cardApi.removeCard(this);
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
                CardRepository cardRepository = CardRepository.this;
                C01511 c01511 = new C01511(cardRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = cardRepository.safeApiCall(c01511, this);
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

    @Override // com.sputnik.domain.repositories.card.ICardRepository
    public Flow<Resource<Unit>> removeCard() {
        return FlowKt.flowOn(FlowKt.flow(new C06921(null)), Dispatchers.getIO());
    }

    /* compiled from: CardRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/card/DataPaymentState;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.card.CardRepository$getLastCardPayment$1", f = "CardRepository.kt", l = {53, 53}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.card.CardRepository$getLastCardPayment$1, reason: invalid class name and case insensitive filesystem */
    static final class C06911 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPaymentState>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C06911(Continuation<? super C06911> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06911 c06911 = CardRepository.this.new C06911(continuation);
            c06911.L$0 = obj;
            return c06911;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPaymentState>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPaymentState>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPaymentState>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06911) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CardRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/card/DataPaymentState;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.card.CardRepository$getLastCardPayment$1$1", f = "CardRepository.kt", l = {53}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.card.CardRepository$getLastCardPayment$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01501 extends SuspendLambda implements Function1<Continuation<? super Response<DataPaymentState>>, Object> {
            int label;
            final /* synthetic */ CardRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01501(CardRepository cardRepository, Continuation<? super C01501> continuation) {
                super(1, continuation);
                this.this$0 = cardRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01501(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPaymentState>> continuation) {
                return ((C01501) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CardApi cardApi = this.this$0.cardApi;
                    this.label = 1;
                    obj = cardApi.getLastPaymentStatus("sputnikTieCard", this);
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
                CardRepository cardRepository = CardRepository.this;
                C01501 c01501 = new C01501(cardRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = cardRepository.safeApiCall(c01501, this);
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

    @Override // com.sputnik.domain.repositories.card.ICardRepository
    public Flow<Resource<DomainPaymentState>> getLastCardPayment() {
        return FlowKt.flow(new CardRepository$getLastCardPayment$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06911(null)), Dispatchers.getIO()), null, this));
    }
}
