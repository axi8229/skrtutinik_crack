package com.sputnik.data.repositories.service_payments;

import com.sputnik.data.api.ServicePaymentsApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.payments.DataPaymentReceipt;
import com.sputnik.data.entities.service_payments.DataIntercomPayRequest;
import com.sputnik.data.entities.service_payments.DataIntercomPaymentInfo;
import com.sputnik.data.entities.service_payments.DataPaymentHistory;
import com.sputnik.data.entities.service_payments.DataPaymentItem;
import com.sputnik.data.entities.service_payments.DataPromisePayment;
import com.sputnik.data.entities.service_payments.DataServiceAccountInfo;
import com.sputnik.data.mappers.service_payments.DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentHistoryToDomainPaymentHistoryMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentItemToDomainPaymentItemMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentReceiptToDomainPaymentReceiptMapper;
import com.sputnik.data.mappers.service_payments.DataPromisePaymentToDomainPromisePaymentMapper;
import com.sputnik.data.mappers.service_payments.DataServiceAccountInfoToDomainServiceAccountInfoMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.service_payments.DomainIntercomPaymentInfo;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import com.sputnik.domain.entities.service_payments.DomainPaymentItem;
import com.sputnik.domain.entities.service_payments.DomainPaymentReceipt;
import com.sputnik.domain.entities.service_payments.DomainPromisePayment;
import com.sputnik.domain.entities.service_payments.DomainServiceAccountInfo;
import com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository;
import java.util.List;
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

/* compiled from: ServicePaymentsRepository.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002BS\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017H\u0016J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00180\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00180\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0!0\u00180\u0017H\u0016J&\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00180\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00180\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/sputnik/data/repositories/service_payments/ServicePaymentsRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/service_payments/IServicePaymentsRepository;", "servicePaymentsApi", "Lcom/sputnik/data/api/ServicePaymentsApi;", "dataPaymentHistoryToDomainPaymentHistoryMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;", "dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapper", "Lcom/sputnik/data/mappers/service_payments/DataPaymentHistoryToDomainPaymentHistoryMapper;", "dataObjectPaymentItemToDomainPaymentItemObjectMapper", "Lcom/sputnik/data/mappers/service_payments/DataPaymentItemToDomainPaymentItemMapper;", "dataPromisedPaymentToDomainPromisedPayment", "Lcom/sputnik/data/mappers/service_payments/DataPromisePaymentToDomainPromisePaymentMapper;", "dataIntercomPaymentInfoToDomainIntercomPaymentInfo", "Lcom/sputnik/data/mappers/service_payments/DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper;", "dataServiceAccountInfoToDomainServiceAccountInfo", "Lcom/sputnik/data/mappers/service_payments/DataServiceAccountInfoToDomainServiceAccountInfoMapper;", "dataPaymentReceiptToDomainPaymentReceiptMapper", "Lcom/sputnik/data/mappers/service_payments/DataPaymentReceiptToDomainPaymentReceiptMapper;", "(Lcom/sputnik/data/api/ServicePaymentsApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/mappers/service_payments/DataPaymentHistoryToDomainPaymentHistoryMapper;Lcom/sputnik/data/mappers/service_payments/DataPaymentItemToDomainPaymentItemMapper;Lcom/sputnik/data/mappers/service_payments/DataPromisePaymentToDomainPromisePaymentMapper;Lcom/sputnik/data/mappers/service_payments/DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper;Lcom/sputnik/data/mappers/service_payments/DataServiceAccountInfoToDomainServiceAccountInfoMapper;Lcom/sputnik/data/mappers/service_payments/DataPaymentReceiptToDomainPaymentReceiptMapper;)V", "getAccountInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/service_payments/DomainServiceAccountInfo;", "getLastPaymentOfAccrual", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentReceipt;", "uuid", "", "getPayment", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentItem;", "getServicePayments", "", "payIntercom", "Lcom/sputnik/domain/entities/service_payments/DomainIntercomPaymentInfo;", "paymentToken", "promisePayment", "Lcom/sputnik/domain/entities/service_payments/DomainPromisePayment;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServicePaymentsRepository extends BaseApiResponse implements IServicePaymentsRepository {
    private final DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper dataIntercomPaymentInfoToDomainIntercomPaymentInfo;
    private final DataPaymentHistoryToDomainPaymentHistoryMapper dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapper;
    private final DataPaymentItemToDomainPaymentItemMapper dataObjectPaymentItemToDomainPaymentItemObjectMapper;
    private final ListMapper<DataPaymentHistory, DomainPaymentHistory> dataPaymentHistoryToDomainPaymentHistoryMapper;
    private final DataPaymentReceiptToDomainPaymentReceiptMapper dataPaymentReceiptToDomainPaymentReceiptMapper;
    private final DataPromisePaymentToDomainPromisePaymentMapper dataPromisedPaymentToDomainPromisedPayment;
    private final DataServiceAccountInfoToDomainServiceAccountInfoMapper dataServiceAccountInfoToDomainServiceAccountInfo;
    private final ServicePaymentsApi servicePaymentsApi;

    public ServicePaymentsRepository(ServicePaymentsApi servicePaymentsApi, ListMapper<DataPaymentHistory, DomainPaymentHistory> dataPaymentHistoryToDomainPaymentHistoryMapper, DataPaymentHistoryToDomainPaymentHistoryMapper dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapper, DataPaymentItemToDomainPaymentItemMapper dataObjectPaymentItemToDomainPaymentItemObjectMapper, DataPromisePaymentToDomainPromisePaymentMapper dataPromisedPaymentToDomainPromisedPayment, DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper dataIntercomPaymentInfoToDomainIntercomPaymentInfo, DataServiceAccountInfoToDomainServiceAccountInfoMapper dataServiceAccountInfoToDomainServiceAccountInfo, DataPaymentReceiptToDomainPaymentReceiptMapper dataPaymentReceiptToDomainPaymentReceiptMapper) {
        Intrinsics.checkNotNullParameter(servicePaymentsApi, "servicePaymentsApi");
        Intrinsics.checkNotNullParameter(dataPaymentHistoryToDomainPaymentHistoryMapper, "dataPaymentHistoryToDomainPaymentHistoryMapper");
        Intrinsics.checkNotNullParameter(dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapper, "dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapper");
        Intrinsics.checkNotNullParameter(dataObjectPaymentItemToDomainPaymentItemObjectMapper, "dataObjectPaymentItemToDomainPaymentItemObjectMapper");
        Intrinsics.checkNotNullParameter(dataPromisedPaymentToDomainPromisedPayment, "dataPromisedPaymentToDomainPromisedPayment");
        Intrinsics.checkNotNullParameter(dataIntercomPaymentInfoToDomainIntercomPaymentInfo, "dataIntercomPaymentInfoToDomainIntercomPaymentInfo");
        Intrinsics.checkNotNullParameter(dataServiceAccountInfoToDomainServiceAccountInfo, "dataServiceAccountInfoToDomainServiceAccountInfo");
        Intrinsics.checkNotNullParameter(dataPaymentReceiptToDomainPaymentReceiptMapper, "dataPaymentReceiptToDomainPaymentReceiptMapper");
        this.servicePaymentsApi = servicePaymentsApi;
        this.dataPaymentHistoryToDomainPaymentHistoryMapper = dataPaymentHistoryToDomainPaymentHistoryMapper;
        this.dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapper = dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapper;
        this.dataObjectPaymentItemToDomainPaymentItemObjectMapper = dataObjectPaymentItemToDomainPaymentItemObjectMapper;
        this.dataPromisedPaymentToDomainPromisedPayment = dataPromisedPaymentToDomainPromisedPayment;
        this.dataIntercomPaymentInfoToDomainIntercomPaymentInfo = dataIntercomPaymentInfoToDomainIntercomPaymentInfo;
        this.dataServiceAccountInfoToDomainServiceAccountInfo = dataServiceAccountInfoToDomainServiceAccountInfo;
        this.dataPaymentReceiptToDomainPaymentReceiptMapper = dataPaymentReceiptToDomainPaymentReceiptMapper;
    }

    /* compiled from: ServicePaymentsRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getServicePayments$1", f = "ServicePaymentsRepository.kt", l = {32, 32}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getServicePayments$1, reason: invalid class name and case insensitive filesystem */
    static final class C07381 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataPaymentHistory>>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07381(Continuation<? super C07381> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07381 c07381 = ServicePaymentsRepository.this.new C07381(continuation);
            c07381.L$0 = obj;
            return c07381;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataPaymentHistory>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataPaymentHistory>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataPaymentHistory>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07381) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ServicePaymentsRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getServicePayments$1$1", f = "ServicePaymentsRepository.kt", l = {33}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getServicePayments$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02561 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataPaymentHistory>>>, Object> {
            int label;
            final /* synthetic */ ServicePaymentsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02561(ServicePaymentsRepository servicePaymentsRepository, Continuation<? super C02561> continuation) {
                super(1, continuation);
                this.this$0 = servicePaymentsRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02561(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataPaymentHistory>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataPaymentHistory>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataPaymentHistory>>> continuation) {
                return ((C02561) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ServicePaymentsApi servicePaymentsApi = this.this$0.servicePaymentsApi;
                    this.label = 1;
                    obj = servicePaymentsApi.getPayments(this);
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
                ServicePaymentsRepository servicePaymentsRepository = ServicePaymentsRepository.this;
                C02561 c02561 = new C02561(servicePaymentsRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = servicePaymentsRepository.safeApiCall(c02561, this);
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

    @Override // com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository
    public Flow<Resource<List<DomainPaymentHistory>>> getServicePayments() {
        return FlowKt.flow(new ServicePaymentsRepository$getServicePayments$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07381(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: ServicePaymentsRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/service_payments/DataPromisePayment;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$promisePayment$1", f = "ServicePaymentsRepository.kt", l = {42, 42}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$promisePayment$1, reason: invalid class name and case insensitive filesystem */
    static final class C07401 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPromisePayment>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07401(String str, Continuation<? super C07401> continuation) {
            super(2, continuation);
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07401 c07401 = ServicePaymentsRepository.this.new C07401(this.$uuid, continuation);
            c07401.L$0 = obj;
            return c07401;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPromisePayment>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPromisePayment>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPromisePayment>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07401) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ServicePaymentsRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/service_payments/DataPromisePayment;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$promisePayment$1$1", f = "ServicePaymentsRepository.kt", l = {43}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$promisePayment$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02581 extends SuspendLambda implements Function1<Continuation<? super Response<DataPromisePayment>>, Object> {
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ ServicePaymentsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02581(ServicePaymentsRepository servicePaymentsRepository, String str, Continuation<? super C02581> continuation) {
                super(1, continuation);
                this.this$0 = servicePaymentsRepository;
                this.$uuid = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02581(this.this$0, this.$uuid, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPromisePayment>> continuation) {
                return ((C02581) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ServicePaymentsApi servicePaymentsApi = this.this$0.servicePaymentsApi;
                    String str = this.$uuid;
                    this.label = 1;
                    obj = servicePaymentsApi.promisePayment(str, this);
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
                ServicePaymentsRepository servicePaymentsRepository = ServicePaymentsRepository.this;
                C02581 c02581 = new C02581(servicePaymentsRepository, this.$uuid, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = servicePaymentsRepository.safeApiCall(c02581, this);
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

    @Override // com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository
    public Flow<Resource<DomainPromisePayment>> promisePayment(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flow(new ServicePaymentsRepository$promisePayment$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07401(uuid, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: ServicePaymentsRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/service_payments/DataIntercomPaymentInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$payIntercom$1", f = "ServicePaymentsRepository.kt", l = {55, 55}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$payIntercom$1, reason: invalid class name and case insensitive filesystem */
    static final class C07391 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataIntercomPaymentInfo>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $paymentToken;
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07391(String str, String str2, Continuation<? super C07391> continuation) {
            super(2, continuation);
            this.$uuid = str;
            this.$paymentToken = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07391 c07391 = ServicePaymentsRepository.this.new C07391(this.$uuid, this.$paymentToken, continuation);
            c07391.L$0 = obj;
            return c07391;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataIntercomPaymentInfo>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataIntercomPaymentInfo>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataIntercomPaymentInfo>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07391) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ServicePaymentsRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/service_payments/DataIntercomPaymentInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$payIntercom$1$1", f = "ServicePaymentsRepository.kt", l = {56}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$payIntercom$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02571 extends SuspendLambda implements Function1<Continuation<? super Response<DataIntercomPaymentInfo>>, Object> {
            final /* synthetic */ String $paymentToken;
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ ServicePaymentsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02571(ServicePaymentsRepository servicePaymentsRepository, String str, String str2, Continuation<? super C02571> continuation) {
                super(1, continuation);
                this.this$0 = servicePaymentsRepository;
                this.$uuid = str;
                this.$paymentToken = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02571(this.this$0, this.$uuid, this.$paymentToken, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataIntercomPaymentInfo>> continuation) {
                return ((C02571) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ServicePaymentsApi servicePaymentsApi = this.this$0.servicePaymentsApi;
                    String str = this.$uuid;
                    DataIntercomPayRequest dataIntercomPayRequest = new DataIntercomPayRequest(this.$paymentToken);
                    this.label = 1;
                    obj = servicePaymentsApi.payIntercom(str, dataIntercomPayRequest, this);
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
                ServicePaymentsRepository servicePaymentsRepository = ServicePaymentsRepository.this;
                C02571 c02571 = new C02571(servicePaymentsRepository, this.$uuid, this.$paymentToken, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = servicePaymentsRepository.safeApiCall(c02571, this);
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

    @Override // com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository
    public Flow<Resource<DomainIntercomPaymentInfo>> payIntercom(String uuid, String paymentToken) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flow(new ServicePaymentsRepository$payIntercom$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07391(uuid, paymentToken, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: ServicePaymentsRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/service_payments/DataPaymentItem;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getPayment$1", f = "ServicePaymentsRepository.kt", l = {65, 65}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getPayment$1, reason: invalid class name and case insensitive filesystem */
    static final class C07371 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPaymentItem>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07371(String str, Continuation<? super C07371> continuation) {
            super(2, continuation);
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07371 c07371 = ServicePaymentsRepository.this.new C07371(this.$uuid, continuation);
            c07371.L$0 = obj;
            return c07371;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPaymentItem>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPaymentItem>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPaymentItem>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07371) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ServicePaymentsRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/service_payments/DataPaymentItem;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getPayment$1$1", f = "ServicePaymentsRepository.kt", l = {66}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getPayment$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02551 extends SuspendLambda implements Function1<Continuation<? super Response<DataPaymentItem>>, Object> {
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ ServicePaymentsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02551(ServicePaymentsRepository servicePaymentsRepository, String str, Continuation<? super C02551> continuation) {
                super(1, continuation);
                this.this$0 = servicePaymentsRepository;
                this.$uuid = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02551(this.this$0, this.$uuid, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPaymentItem>> continuation) {
                return ((C02551) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ServicePaymentsApi servicePaymentsApi = this.this$0.servicePaymentsApi;
                    String str = this.$uuid;
                    this.label = 1;
                    obj = servicePaymentsApi.getPayment(str, this);
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
                ServicePaymentsRepository servicePaymentsRepository = ServicePaymentsRepository.this;
                C02551 c02551 = new C02551(servicePaymentsRepository, this.$uuid, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = servicePaymentsRepository.safeApiCall(c02551, this);
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

    @Override // com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository
    public Flow<Resource<DomainPaymentItem>> getPayment(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flow(new ServicePaymentsRepository$getPayment$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07371(uuid, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: ServicePaymentsRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/service_payments/DataServiceAccountInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getAccountInfo$1", f = "ServicePaymentsRepository.kt", l = {75, 75}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getAccountInfo$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataServiceAccountInfo>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ServicePaymentsRepository.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataServiceAccountInfo>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataServiceAccountInfo>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataServiceAccountInfo>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ServicePaymentsRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/service_payments/DataServiceAccountInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getAccountInfo$1$1", f = "ServicePaymentsRepository.kt", l = {76}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getAccountInfo$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02531 extends SuspendLambda implements Function1<Continuation<? super Response<DataServiceAccountInfo>>, Object> {
            int label;
            final /* synthetic */ ServicePaymentsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02531(ServicePaymentsRepository servicePaymentsRepository, Continuation<? super C02531> continuation) {
                super(1, continuation);
                this.this$0 = servicePaymentsRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02531(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataServiceAccountInfo>> continuation) {
                return ((C02531) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ServicePaymentsApi servicePaymentsApi = this.this$0.servicePaymentsApi;
                    this.label = 1;
                    obj = servicePaymentsApi.getAccountInfo(this);
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
                ServicePaymentsRepository servicePaymentsRepository = ServicePaymentsRepository.this;
                C02531 c02531 = new C02531(servicePaymentsRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = servicePaymentsRepository.safeApiCall(c02531, this);
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

    @Override // com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository
    public Flow<Resource<DomainServiceAccountInfo>> getAccountInfo() {
        return FlowKt.flow(new ServicePaymentsRepository$getAccountInfo$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: ServicePaymentsRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/payments/DataPaymentReceipt;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getLastPaymentOfAccrual$1", f = "ServicePaymentsRepository.kt", l = {85, 85}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getLastPaymentOfAccrual$1, reason: invalid class name and case insensitive filesystem */
    static final class C07361 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPaymentReceipt>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07361(String str, Continuation<? super C07361> continuation) {
            super(2, continuation);
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07361 c07361 = ServicePaymentsRepository.this.new C07361(this.$uuid, continuation);
            c07361.L$0 = obj;
            return c07361;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPaymentReceipt>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPaymentReceipt>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPaymentReceipt>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07361) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ServicePaymentsRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/payments/DataPaymentReceipt;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getLastPaymentOfAccrual$1$1", f = "ServicePaymentsRepository.kt", l = {86}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.service_payments.ServicePaymentsRepository$getLastPaymentOfAccrual$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02541 extends SuspendLambda implements Function1<Continuation<? super Response<DataPaymentReceipt>>, Object> {
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ ServicePaymentsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02541(ServicePaymentsRepository servicePaymentsRepository, String str, Continuation<? super C02541> continuation) {
                super(1, continuation);
                this.this$0 = servicePaymentsRepository;
                this.$uuid = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02541(this.this$0, this.$uuid, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPaymentReceipt>> continuation) {
                return ((C02541) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ServicePaymentsApi servicePaymentsApi = this.this$0.servicePaymentsApi;
                    String str = this.$uuid;
                    this.label = 1;
                    obj = ServicePaymentsApi.DefaultImpls.getLastPaymentOfAccrual$default(servicePaymentsApi, str, null, this, 2, null);
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
                ServicePaymentsRepository servicePaymentsRepository = ServicePaymentsRepository.this;
                C02541 c02541 = new C02541(servicePaymentsRepository, this.$uuid, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = servicePaymentsRepository.safeApiCall(c02541, this);
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

    @Override // com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository
    public Flow<Resource<DomainPaymentReceipt>> getLastPaymentOfAccrual(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flow(new ServicePaymentsRepository$getLastPaymentOfAccrual$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07361(uuid, null)), Dispatchers.getIO()), null, this));
    }
}
