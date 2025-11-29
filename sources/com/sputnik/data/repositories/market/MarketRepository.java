package com.sputnik.data.repositories.market;

import com.sputnik.data.api.MarketApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.market.DataMarket;
import com.sputnik.data.entities.market.service.DataService;
import com.sputnik.data.entities.market.subscription.DataSubscription;
import com.sputnik.data.entities.subscriptions.DataMarketV2;
import com.sputnik.data.entities.subscriptions.items.DataMarketItem;
import com.sputnik.data.entities.subscriptions.services.DataOuterService;
import com.sputnik.data.entities.subscriptions.subscriptions.DataBaseSubscription;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.market.DomainMarket;
import com.sputnik.domain.entities.market.services.DomainService;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import com.sputnik.domain.entities.subscriptions.DomainMarketV2;
import com.sputnik.domain.entities.subscriptions.items.DomainMarketItem;
import com.sputnik.domain.entities.subscriptions.services.DomainOuterService;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import com.sputnik.domain.repositories.market.IMarketRepository;
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

/* compiled from: MarketRepository.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0087\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0006\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0006\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0006\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0006¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001c0\u001b0\u001aH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001b0\u001aH\u0016J\"\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u001b0\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001c0\u001b0\u001aH\u0016R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/sputnik/data/repositories/market/MarketRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/market/IMarketRepository;", "marketApi", "Lcom/sputnik/data/api/MarketApi;", "dataSubscriptionToDomainSubscriptionMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/market/subscription/DataSubscription;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;", "dataMarketToDomainMarketMapper", "Lcom/sputnik/data/entities/market/DataMarket;", "Lcom/sputnik/domain/entities/market/DomainMarket;", "dataMarketV2ToDomainMarketV2Mapper", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBaseSubscription;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;", "dataOuterServiceToDomainOuterServiceMapper", "Lcom/sputnik/data/entities/subscriptions/services/DataOuterService;", "Lcom/sputnik/domain/entities/subscriptions/services/DomainOuterService;", "dataMarketItemToDomainMarketItemMapper", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem;", "dataServiceToDomainServiceMapper", "Lcom/sputnik/data/entities/market/service/DataService;", "Lcom/sputnik/domain/entities/market/services/DomainService;", "(Lcom/sputnik/data/api/MarketApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/domain/common/ListMapper;)V", "getMarket", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "getMarketV2", "Lcom/sputnik/domain/entities/subscriptions/DomainMarketV2;", "getServices", "addressId", "", "getSubscriptions", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MarketRepository extends BaseApiResponse implements IMarketRepository {
    private final ListMapper<DataMarketItem, DomainMarketItem> dataMarketItemToDomainMarketItemMapper;
    private final ListMapper<DataMarket, DomainMarket> dataMarketToDomainMarketMapper;
    private final ListMapper<DataBaseSubscription, DomainBaseSubscription> dataMarketV2ToDomainMarketV2Mapper;
    private final ListMapper<DataOuterService, DomainOuterService> dataOuterServiceToDomainOuterServiceMapper;
    private final ListMapper<DataService, DomainService> dataServiceToDomainServiceMapper;
    private final ListMapper<DataSubscription, DomainSubscription> dataSubscriptionToDomainSubscriptionMapper;
    private final MarketApi marketApi;

    public MarketRepository(MarketApi marketApi, ListMapper<DataSubscription, DomainSubscription> dataSubscriptionToDomainSubscriptionMapper, ListMapper<DataMarket, DomainMarket> dataMarketToDomainMarketMapper, ListMapper<DataBaseSubscription, DomainBaseSubscription> dataMarketV2ToDomainMarketV2Mapper, ListMapper<DataOuterService, DomainOuterService> dataOuterServiceToDomainOuterServiceMapper, ListMapper<DataMarketItem, DomainMarketItem> dataMarketItemToDomainMarketItemMapper, ListMapper<DataService, DomainService> dataServiceToDomainServiceMapper) {
        Intrinsics.checkNotNullParameter(marketApi, "marketApi");
        Intrinsics.checkNotNullParameter(dataSubscriptionToDomainSubscriptionMapper, "dataSubscriptionToDomainSubscriptionMapper");
        Intrinsics.checkNotNullParameter(dataMarketToDomainMarketMapper, "dataMarketToDomainMarketMapper");
        Intrinsics.checkNotNullParameter(dataMarketV2ToDomainMarketV2Mapper, "dataMarketV2ToDomainMarketV2Mapper");
        Intrinsics.checkNotNullParameter(dataOuterServiceToDomainOuterServiceMapper, "dataOuterServiceToDomainOuterServiceMapper");
        Intrinsics.checkNotNullParameter(dataMarketItemToDomainMarketItemMapper, "dataMarketItemToDomainMarketItemMapper");
        Intrinsics.checkNotNullParameter(dataServiceToDomainServiceMapper, "dataServiceToDomainServiceMapper");
        this.marketApi = marketApi;
        this.dataSubscriptionToDomainSubscriptionMapper = dataSubscriptionToDomainSubscriptionMapper;
        this.dataMarketToDomainMarketMapper = dataMarketToDomainMarketMapper;
        this.dataMarketV2ToDomainMarketV2Mapper = dataMarketV2ToDomainMarketV2Mapper;
        this.dataOuterServiceToDomainOuterServiceMapper = dataOuterServiceToDomainOuterServiceMapper;
        this.dataMarketItemToDomainMarketItemMapper = dataMarketItemToDomainMarketItemMapper;
        this.dataServiceToDomainServiceMapper = dataServiceToDomainServiceMapper;
    }

    /* compiled from: MarketRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/market/DataMarket;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getMarket$1", f = "MarketRepository.kt", l = {40, 41, 41}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getMarket$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataMarket>>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = MarketRepository.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataMarket>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataMarket>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataMarket>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[RETURN] */
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
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r7)
                goto L64
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L59
            L26:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r6.L$0 = r7
                r6.label = r5
                java.lang.Object r1 = r7.emit(r1, r6)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r7
            L47:
                com.sputnik.data.repositories.market.MarketRepository r7 = com.sputnik.data.repositories.market.MarketRepository.this
                com.sputnik.data.repositories.market.MarketRepository$getMarket$1$1 r5 = new com.sputnik.data.repositories.market.MarketRepository$getMarket$1$1
                r5.<init>(r7, r2)
                r6.L$0 = r1
                r6.label = r4
                java.lang.Object r7 = r7.safeApiCall(r5, r6)
                if (r7 != r0) goto L59
                return r0
            L59:
                r6.L$0 = r2
                r6.label = r3
                java.lang.Object r7 = r1.emit(r7, r6)
                if (r7 != r0) goto L64
                return r0
            L64:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.market.MarketRepository.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: MarketRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/market/DataMarket;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getMarket$1$1", f = "MarketRepository.kt", l = {41}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getMarket$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02121 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataMarket>>>, Object> {
            int label;
            final /* synthetic */ MarketRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02121(MarketRepository marketRepository, Continuation<? super C02121> continuation) {
                super(1, continuation);
                this.this$0 = marketRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02121(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataMarket>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataMarket>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataMarket>>> continuation) {
                return ((C02121) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MarketApi marketApi = this.this$0.marketApi;
                    this.label = 1;
                    obj = marketApi.getMarket(this);
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
    }

    @Override // com.sputnik.domain.repositories.market.IMarketRepository
    public Flow<Resource<List<DomainMarket>>> getMarket() {
        return FlowKt.flow(new MarketRepository$getMarket$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: MarketRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/subscriptions/DataMarketV2;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getMarketV2$1", f = "MarketRepository.kt", l = {49, 50, 50}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getMarketV2$1, reason: invalid class name and case insensitive filesystem */
    static final class C07141 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataMarketV2>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07141(Continuation<? super C07141> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07141 c07141 = MarketRepository.this.new C07141(continuation);
            c07141.L$0 = obj;
            return c07141;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataMarketV2>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataMarketV2>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataMarketV2>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07141) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[RETURN] */
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
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r7)
                goto L64
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L59
            L26:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r6.L$0 = r7
                r6.label = r5
                java.lang.Object r1 = r7.emit(r1, r6)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r7
            L47:
                com.sputnik.data.repositories.market.MarketRepository r7 = com.sputnik.data.repositories.market.MarketRepository.this
                com.sputnik.data.repositories.market.MarketRepository$getMarketV2$1$1 r5 = new com.sputnik.data.repositories.market.MarketRepository$getMarketV2$1$1
                r5.<init>(r7, r2)
                r6.L$0 = r1
                r6.label = r4
                java.lang.Object r7 = r7.safeApiCall(r5, r6)
                if (r7 != r0) goto L59
                return r0
            L59:
                r6.L$0 = r2
                r6.label = r3
                java.lang.Object r7 = r1.emit(r7, r6)
                if (r7 != r0) goto L64
                return r0
            L64:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.market.MarketRepository.C07141.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: MarketRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/subscriptions/DataMarketV2;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getMarketV2$1$1", f = "MarketRepository.kt", l = {50}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getMarketV2$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02131 extends SuspendLambda implements Function1<Continuation<? super Response<DataMarketV2>>, Object> {
            int label;
            final /* synthetic */ MarketRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02131(MarketRepository marketRepository, Continuation<? super C02131> continuation) {
                super(1, continuation);
                this.this$0 = marketRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02131(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataMarketV2>> continuation) {
                return ((C02131) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MarketApi marketApi = this.this$0.marketApi;
                    this.label = 1;
                    obj = MarketApi.DefaultImpls.getMarketNew$default(marketApi, 0, this, 1, null);
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
    }

    @Override // com.sputnik.domain.repositories.market.IMarketRepository
    public Flow<Resource<DomainMarketV2>> getMarketV2() {
        return FlowKt.flow(new MarketRepository$getMarketV2$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07141(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: MarketRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/market/subscription/DataSubscription;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getSubscriptions$1", f = "MarketRepository.kt", l = {78, 78}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getSubscriptions$1, reason: invalid class name and case insensitive filesystem */
    static final class C07161 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataSubscription>>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07161(Continuation<? super C07161> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07161 c07161 = MarketRepository.this.new C07161(continuation);
            c07161.L$0 = obj;
            return c07161;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataSubscription>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataSubscription>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataSubscription>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07161) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MarketRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/market/subscription/DataSubscription;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getSubscriptions$1$1", f = "MarketRepository.kt", l = {78}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getSubscriptions$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02151 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataSubscription>>>, Object> {
            int label;
            final /* synthetic */ MarketRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02151(MarketRepository marketRepository, Continuation<? super C02151> continuation) {
                super(1, continuation);
                this.this$0 = marketRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02151(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataSubscription>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataSubscription>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataSubscription>>> continuation) {
                return ((C02151) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MarketApi marketApi = this.this$0.marketApi;
                    this.label = 1;
                    obj = marketApi.getSubscriptions(this);
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
                MarketRepository marketRepository = MarketRepository.this;
                C02151 c02151 = new C02151(marketRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = marketRepository.safeApiCall(c02151, this);
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

    @Override // com.sputnik.domain.repositories.market.IMarketRepository
    public Flow<Resource<List<DomainSubscription>>> getSubscriptions() {
        return FlowKt.flow(new MarketRepository$getSubscriptions$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07161(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: MarketRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/market/service/DataService;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getServices$1", f = "MarketRepository.kt", l = {88, 88}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getServices$1, reason: invalid class name and case insensitive filesystem */
    static final class C07151 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataService>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07151(int i, Continuation<? super C07151> continuation) {
            super(2, continuation);
            this.$addressId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07151 c07151 = MarketRepository.this.new C07151(this.$addressId, continuation);
            c07151.L$0 = obj;
            return c07151;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataService>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataService>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataService>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07151) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MarketRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/market/service/DataService;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.market.MarketRepository$getServices$1$1", f = "MarketRepository.kt", l = {88}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.market.MarketRepository$getServices$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02141 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataService>>>, Object> {
            final /* synthetic */ int $addressId;
            int label;
            final /* synthetic */ MarketRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02141(MarketRepository marketRepository, int i, Continuation<? super C02141> continuation) {
                super(1, continuation);
                this.this$0 = marketRepository;
                this.$addressId = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02141(this.this$0, this.$addressId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataService>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataService>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataService>>> continuation) {
                return ((C02141) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MarketApi marketApi = this.this$0.marketApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    this.label = 1;
                    obj = marketApi.getServices(strValueOf, this);
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
                MarketRepository marketRepository = MarketRepository.this;
                C02141 c02141 = new C02141(marketRepository, this.$addressId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = marketRepository.safeApiCall(c02141, this);
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

    @Override // com.sputnik.domain.repositories.market.IMarketRepository
    public Flow<Resource<List<DomainService>>> getServices(int addressId) {
        return FlowKt.flow(new MarketRepository$getServices$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07151(addressId, null)), Dispatchers.getIO()), null, this));
    }
}
