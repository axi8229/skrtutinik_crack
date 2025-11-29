package com.sputnik.data.repositories.gorserv;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.sputnik.data.api.GorservApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.gorserv.DataCreateTicketRequest;
import com.sputnik.data.entities.gorserv.DataCreateTicketResponse;
import com.sputnik.data.entities.gorserv.DataGorservCatalog;
import com.sputnik.data.mappers.gorserv.DataGorservCatalogToDomainGorservCatalogMapper;
import com.sputnik.data.mappers.gorserv.DataGorservCreateTicketToDomainGorservCreateTicketMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.gorserv.DomainGorservCatalog;
import com.sputnik.domain.entities.gorserv.DomainGorservTicket;
import com.sputnik.domain.repositories.gorserv.IGorservRepository;
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

/* compiled from: GorservRepository.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B3\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ6\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0016J:\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00180\u00120\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/sputnik/data/repositories/gorserv/GorservRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/gorserv/IGorservRepository;", "api", "Lcom/sputnik/data/api/GorservApi;", "listMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/gorserv/DataGorservCatalog;", "Lcom/sputnik/domain/entities/gorserv/DomainGorservCatalog;", "listMapperTicket", "Lcom/sputnik/data/mappers/gorserv/DataGorservCreateTicketToDomainGorservCreateTicketMapper;", "mapper", "Lcom/sputnik/data/mappers/gorserv/DataGorservCatalogToDomainGorservCatalogMapper;", "(Lcom/sputnik/data/api/GorservApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/mappers/gorserv/DataGorservCreateTicketToDomainGorservCreateTicketMapper;Lcom/sputnik/data/mappers/gorserv/DataGorservCatalogToDomainGorservCatalogMapper;)V", "getApi", "()Lcom/sputnik/data/api/GorservApi;", "createTicket", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/gorserv/DomainGorservTicket;", "category", "", CrashHianalyticsData.MESSAGE, "phones", "", "getGorservCatalog", "version", "", "platform", "app", "locale", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GorservRepository extends BaseApiResponse implements IGorservRepository {
    private final GorservApi api;
    private final ListMapper<DataGorservCatalog, DomainGorservCatalog> listMapper;
    private final DataGorservCreateTicketToDomainGorservCreateTicketMapper listMapperTicket;
    private final DataGorservCatalogToDomainGorservCatalogMapper mapper;

    public final GorservApi getApi() {
        return this.api;
    }

    public GorservRepository(GorservApi api, ListMapper<DataGorservCatalog, DomainGorservCatalog> listMapper, DataGorservCreateTicketToDomainGorservCreateTicketMapper listMapperTicket, DataGorservCatalogToDomainGorservCatalogMapper mapper) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(listMapper, "listMapper");
        Intrinsics.checkNotNullParameter(listMapperTicket, "listMapperTicket");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.api = api;
        this.listMapper = listMapper;
        this.listMapperTicket = listMapperTicket;
        this.mapper = mapper;
    }

    /* compiled from: GorservRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/gorserv/DataGorservCatalog;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.gorserv.GorservRepository$getGorservCatalog$1", f = "GorservRepository.kt", l = {35, 35}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.gorserv.GorservRepository$getGorservCatalog$1, reason: invalid class name and case insensitive filesystem */
    static final class C06991 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataGorservCatalog>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $app;
        final /* synthetic */ String $locale;
        final /* synthetic */ String $platform;
        final /* synthetic */ int $version;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06991(int i, String str, String str2, String str3, Continuation<? super C06991> continuation) {
            super(2, continuation);
            this.$version = i;
            this.$platform = str;
            this.$app = str2;
            this.$locale = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06991 c06991 = GorservRepository.this.new C06991(this.$version, this.$platform, this.$app, this.$locale, continuation);
            c06991.L$0 = obj;
            return c06991;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataGorservCatalog>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataGorservCatalog>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataGorservCatalog>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06991) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: GorservRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/gorserv/DataGorservCatalog;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.gorserv.GorservRepository$getGorservCatalog$1$1", f = "GorservRepository.kt", l = {35}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.gorserv.GorservRepository$getGorservCatalog$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01701 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataGorservCatalog>>>, Object> {
            final /* synthetic */ String $app;
            final /* synthetic */ String $locale;
            final /* synthetic */ String $platform;
            final /* synthetic */ int $version;
            int label;
            final /* synthetic */ GorservRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01701(GorservRepository gorservRepository, int i, String str, String str2, String str3, Continuation<? super C01701> continuation) {
                super(1, continuation);
                this.this$0 = gorservRepository;
                this.$version = i;
                this.$platform = str;
                this.$app = str2;
                this.$locale = str3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01701(this.this$0, this.$version, this.$platform, this.$app, this.$locale, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataGorservCatalog>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataGorservCatalog>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataGorservCatalog>>> continuation) {
                return ((C01701) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GorservApi api = this.this$0.getApi();
                    int i2 = this.$version;
                    String str = this.$platform;
                    String str2 = this.$app;
                    String str3 = this.$locale;
                    this.label = 1;
                    obj = api.getCatalogs(i2, str, str2, str3, this);
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
                GorservRepository gorservRepository = GorservRepository.this;
                C01701 c01701 = new C01701(gorservRepository, this.$version, this.$platform, this.$app, this.$locale, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = gorservRepository.safeApiCall(c01701, this);
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

    @Override // com.sputnik.domain.repositories.gorserv.IGorservRepository
    public Flow<Resource<List<DomainGorservCatalog>>> getGorservCatalog(int version, String platform, String app, String locale) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return FlowKt.flow(new GorservRepository$getGorservCatalog$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06991(version, platform, app, locale, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: GorservRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/gorserv/DataCreateTicketResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.gorserv.GorservRepository$createTicket$1", f = "GorservRepository.kt", l = {45, 45}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.gorserv.GorservRepository$createTicket$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataCreateTicketResponse>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $category;
        final /* synthetic */ String $message;
        final /* synthetic */ List<String> $phones;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, List<String> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$category = str;
            this.$message = str2;
            this.$phones = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = GorservRepository.this.new AnonymousClass1(this.$category, this.$message, this.$phones, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataCreateTicketResponse>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataCreateTicketResponse>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataCreateTicketResponse>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: GorservRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/gorserv/DataCreateTicketResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.gorserv.GorservRepository$createTicket$1$1", f = "GorservRepository.kt", l = {45}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.gorserv.GorservRepository$createTicket$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01691 extends SuspendLambda implements Function1<Continuation<? super Response<DataCreateTicketResponse>>, Object> {
            final /* synthetic */ String $category;
            final /* synthetic */ String $message;
            final /* synthetic */ List<String> $phones;
            int label;
            final /* synthetic */ GorservRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01691(GorservRepository gorservRepository, String str, String str2, List<String> list, Continuation<? super C01691> continuation) {
                super(1, continuation);
                this.this$0 = gorservRepository;
                this.$category = str;
                this.$message = str2;
                this.$phones = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01691(this.this$0, this.$category, this.$message, this.$phones, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataCreateTicketResponse>> continuation) {
                return ((C01691) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GorservApi api = this.this$0.getApi();
                    DataCreateTicketRequest dataCreateTicketRequest = new DataCreateTicketRequest(this.$category, this.$message, this.$phones);
                    this.label = 1;
                    obj = api.createTicket(dataCreateTicketRequest, this);
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
                GorservRepository gorservRepository = GorservRepository.this;
                C01691 c01691 = new C01691(gorservRepository, this.$category, this.$message, this.$phones, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = gorservRepository.safeApiCall(c01691, this);
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

    @Override // com.sputnik.domain.repositories.gorserv.IGorservRepository
    public Flow<Resource<DomainGorservTicket>> createTicket(String category, String message, List<String> phones) {
        Intrinsics.checkNotNullParameter(phones, "phones");
        return FlowKt.flow(new GorservRepository$createTicket$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(category, message, phones, null)), Dispatchers.getIO()), null, this));
    }
}
