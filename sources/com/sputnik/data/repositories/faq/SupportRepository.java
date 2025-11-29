package com.sputnik.data.repositories.faq;

import com.sputnik.data.api.SupportApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.faq.DataFaq;
import com.sputnik.data.entities.faq.DataFaqObject;
import com.sputnik.data.entities.support.DataAnnounce;
import com.sputnik.data.entities.support.DataCompanyContacts;
import com.sputnik.data.mappers.faq.DataFaqToDomainFaqMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.faq.DomainFaq;
import com.sputnik.domain.entities.faq.DomainFaqObject;
import com.sputnik.domain.entities.support.DomainAnnounce;
import com.sputnik.domain.entities.support.DomainCompanyContacts;
import com.sputnik.domain.repositories.support.ISupportRepository;
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

/* compiled from: SupportRepository.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B-\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001b\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010 ¨\u0006!"}, d2 = {"Lcom/sputnik/data/repositories/faq/SupportRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/support/ISupportRepository;", "Lcom/sputnik/data/api/SupportApi;", "api", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/faq/DataFaq;", "Lcom/sputnik/domain/entities/faq/DomainFaq;", "listMapper", "Lcom/sputnik/data/mappers/faq/DataFaqToDomainFaqMapper;", "mapper", "<init>", "(Lcom/sputnik/data/api/SupportApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/mappers/faq/DataFaqToDomainFaqMapper;)V", "", "locale", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/faq/DomainFaqObject;", "getFaq", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "", "addressId", "Lcom/sputnik/domain/entities/support/DomainCompanyContacts;", "getCompanyContacts", "(I)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/entities/support/DomainAnnounce;", "getAnnounce", "Lcom/sputnik/data/api/SupportApi;", "getApi", "()Lcom/sputnik/data/api/SupportApi;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/faq/DataFaqToDomainFaqMapper;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SupportRepository extends BaseApiResponse implements ISupportRepository {
    private final SupportApi api;
    private final ListMapper<DataFaq, DomainFaq> listMapper;
    private final DataFaqToDomainFaqMapper mapper;

    public final SupportApi getApi() {
        return this.api;
    }

    public SupportRepository(SupportApi api, ListMapper<DataFaq, DomainFaq> listMapper, DataFaqToDomainFaqMapper mapper) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(listMapper, "listMapper");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.api = api;
        this.listMapper = listMapper;
        this.mapper = mapper;
    }

    /* compiled from: SupportRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/faq/DataFaqObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.faq.SupportRepository$getFaq$3", f = "SupportRepository.kt", l = {39, 39}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.faq.SupportRepository$getFaq$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataFaqObject>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $locale;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$locale = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = SupportRepository.this.new AnonymousClass3(this.$locale, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataFaqObject>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataFaqObject>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataFaqObject>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SupportRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/faq/DataFaqObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.faq.SupportRepository$getFaq$3$1", f = "SupportRepository.kt", l = {39}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.faq.SupportRepository$getFaq$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataFaqObject>>>, Object> {
            final /* synthetic */ String $locale;
            int label;
            final /* synthetic */ SupportRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SupportRepository supportRepository, String str, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = supportRepository;
                this.$locale = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$locale, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataFaqObject>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataFaqObject>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataFaqObject>>> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SupportApi api = this.this$0.getApi();
                    String str = this.$locale;
                    this.label = 1;
                    obj = api.getFaq2(str, this);
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
                SupportRepository supportRepository = SupportRepository.this;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(supportRepository, this.$locale, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = supportRepository.safeApiCall(anonymousClass1, this);
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

    @Override // com.sputnik.domain.repositories.support.ISupportRepository
    public Flow<Resource<List<DomainFaqObject>>> getFaq(String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return FlowKt.flow(new SupportRepository$getFaq$$inlined$transform$2(FlowKt.flowOn(FlowKt.flow(new AnonymousClass3(locale, null)), Dispatchers.getIO()), null));
    }

    /* compiled from: SupportRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/support/DataCompanyContacts;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.faq.SupportRepository$getCompanyContacts$1", f = "SupportRepository.kt", l = {87, 87}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.faq.SupportRepository$getCompanyContacts$1, reason: invalid class name and case insensitive filesystem */
    static final class C06981 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataCompanyContacts>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06981(int i, Continuation<? super C06981> continuation) {
            super(2, continuation);
            this.$addressId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06981 c06981 = SupportRepository.this.new C06981(this.$addressId, continuation);
            c06981.L$0 = obj;
            return c06981;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataCompanyContacts>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataCompanyContacts>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataCompanyContacts>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06981) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SupportRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/support/DataCompanyContacts;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.faq.SupportRepository$getCompanyContacts$1$1", f = "SupportRepository.kt", l = {87}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.faq.SupportRepository$getCompanyContacts$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01651 extends SuspendLambda implements Function1<Continuation<? super Response<DataCompanyContacts>>, Object> {
            final /* synthetic */ int $addressId;
            int label;
            final /* synthetic */ SupportRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01651(SupportRepository supportRepository, int i, Continuation<? super C01651> continuation) {
                super(1, continuation);
                this.this$0 = supportRepository;
                this.$addressId = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01651(this.this$0, this.$addressId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataCompanyContacts>> continuation) {
                return ((C01651) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SupportApi api = this.this$0.getApi();
                    String strValueOf = String.valueOf(this.$addressId);
                    this.label = 1;
                    obj = api.getCompanyContacts(strValueOf, this);
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
                SupportRepository supportRepository = SupportRepository.this;
                C01651 c01651 = new C01651(supportRepository, this.$addressId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = supportRepository.safeApiCall(c01651, this);
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

    @Override // com.sputnik.domain.repositories.support.ISupportRepository
    public Flow<Resource<DomainCompanyContacts>> getCompanyContacts(int addressId) {
        return FlowKt.flow(new SupportRepository$getCompanyContacts$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06981(addressId, null)), Dispatchers.getIO()), null));
    }

    /* compiled from: SupportRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/support/DataAnnounce;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.faq.SupportRepository$getAnnounce$1", f = "SupportRepository.kt", l = {106, 106}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.faq.SupportRepository$getAnnounce$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataAnnounce>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $locale;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$locale = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = SupportRepository.this.new AnonymousClass1(this.$locale, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataAnnounce>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataAnnounce>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataAnnounce>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SupportRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/support/DataAnnounce;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.faq.SupportRepository$getAnnounce$1$1", f = "SupportRepository.kt", l = {106}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.faq.SupportRepository$getAnnounce$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01641 extends SuspendLambda implements Function1<Continuation<? super Response<DataAnnounce>>, Object> {
            final /* synthetic */ String $locale;
            int label;
            final /* synthetic */ SupportRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01641(SupportRepository supportRepository, String str, Continuation<? super C01641> continuation) {
                super(1, continuation);
                this.this$0 = supportRepository;
                this.$locale = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01641(this.this$0, this.$locale, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataAnnounce>> continuation) {
                return ((C01641) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SupportApi api = this.this$0.getApi();
                    String str = this.$locale;
                    this.label = 1;
                    obj = api.getAnnounce(str, this);
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
                SupportRepository supportRepository = SupportRepository.this;
                C01641 c01641 = new C01641(supportRepository, this.$locale, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = supportRepository.safeApiCall(c01641, this);
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

    @Override // com.sputnik.domain.repositories.support.ISupportRepository
    public Flow<Resource<DomainAnnounce>> getAnnounce(String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return FlowKt.flow(new SupportRepository$getAnnounce$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(locale, null)), Dispatchers.getIO()), null));
    }
}
