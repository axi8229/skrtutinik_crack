package com.sputnik.data.repositories.invites;

import com.sputnik.data.api.InvitesApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.invites.DataFamilyInvite;
import com.sputnik.data.entities.invites.DataFamilyInvites;
import com.sputnik.data.entities.invites.DataInvite;
import com.sputnik.data.entities.invites.DataManageInvites;
import com.sputnik.data.mappers.invites.DataFamilyInvitesToDomainFamilyInvitesMapper;
import com.sputnik.data.mappers.invites.DataInviteToDomainInviteMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.invites.DomainFamilyInvite;
import com.sputnik.domain.entities.invites.DomainFamilyInvites;
import com.sputnik.domain.entities.invites.DomainInvite;
import com.sputnik.domain.repositories.invites.IInvitesRepository;
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

/* compiled from: InvitesRepository.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B3\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00120\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00120\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J:\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001e0\u00120\u00112\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0016J$\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00120\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00120\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0014H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/sputnik/data/repositories/invites/InvitesRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/invites/IInvitesRepository;", "api", "Lcom/sputnik/data/api/InvitesApi;", "listMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/invites/DataInvite;", "Lcom/sputnik/domain/entities/invites/DomainInvite;", "mapper", "Lcom/sputnik/data/mappers/invites/DataInviteToDomainInviteMapper;", "familyInvitesMapper", "Lcom/sputnik/data/mappers/invites/DataFamilyInvitesToDomainFamilyInvitesMapper;", "(Lcom/sputnik/data/api/InvitesApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/mappers/invites/DataInviteToDomainInviteMapper;Lcom/sputnik/data/mappers/invites/DataFamilyInvitesToDomainFamilyInvitesMapper;)V", "getApi", "()Lcom/sputnik/data/api/InvitesApi;", "acceptInvite", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "id", "", "source", "declineInvite", "deleteFamilyInvite", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvite;", "addressId", "", "getFamilyInvites", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvites;", "getInvites", "", "version", "platform", "app", "locale", "resendFamilyInvite", "sendFamilyInvite", "phone", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InvitesRepository extends BaseApiResponse implements IInvitesRepository {
    private final InvitesApi api;
    private final DataFamilyInvitesToDomainFamilyInvitesMapper familyInvitesMapper;
    private final ListMapper<DataInvite, DomainInvite> listMapper;
    private final DataInviteToDomainInviteMapper mapper;

    public final InvitesApi getApi() {
        return this.api;
    }

    public InvitesRepository(InvitesApi api, ListMapper<DataInvite, DomainInvite> listMapper, DataInviteToDomainInviteMapper mapper, DataFamilyInvitesToDomainFamilyInvitesMapper familyInvitesMapper) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(listMapper, "listMapper");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(familyInvitesMapper, "familyInvitesMapper");
        this.api = api;
        this.listMapper = listMapper;
        this.mapper = mapper;
        this.familyInvitesMapper = familyInvitesMapper;
    }

    /* compiled from: InvitesRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/invites/DataInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$getInvites$1", f = "InvitesRepository.kt", l = {34, 34}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$getInvites$1, reason: invalid class name and case insensitive filesystem */
    static final class C07031 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataInvite>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $app;
        final /* synthetic */ String $locale;
        final /* synthetic */ String $platform;
        final /* synthetic */ int $version;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07031(int i, String str, String str2, String str3, Continuation<? super C07031> continuation) {
            super(2, continuation);
            this.$version = i;
            this.$platform = str;
            this.$app = str2;
            this.$locale = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07031 c07031 = InvitesRepository.this.new C07031(this.$version, this.$platform, this.$app, this.$locale, continuation);
            c07031.L$0 = obj;
            return c07031;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataInvite>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataInvite>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataInvite>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07031) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: InvitesRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/invites/DataInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$getInvites$1$1", f = "InvitesRepository.kt", l = {35}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$getInvites$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01841 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataInvite>>>, Object> {
            final /* synthetic */ String $app;
            final /* synthetic */ String $locale;
            final /* synthetic */ String $platform;
            final /* synthetic */ int $version;
            int label;
            final /* synthetic */ InvitesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01841(InvitesRepository invitesRepository, int i, String str, String str2, String str3, Continuation<? super C01841> continuation) {
                super(1, continuation);
                this.this$0 = invitesRepository;
                this.$version = i;
                this.$platform = str;
                this.$app = str2;
                this.$locale = str3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01841(this.this$0, this.$version, this.$platform, this.$app, this.$locale, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataInvite>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataInvite>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataInvite>>> continuation) {
                return ((C01841) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InvitesApi api = this.this$0.getApi();
                    int i2 = this.$version;
                    String str = this.$platform;
                    String str2 = this.$app;
                    String str3 = this.$locale;
                    this.label = 1;
                    obj = api.getInvites(i2, str, str2, str3, this);
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
                InvitesRepository invitesRepository = InvitesRepository.this;
                C01841 c01841 = new C01841(invitesRepository, this.$version, this.$platform, this.$app, this.$locale, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = invitesRepository.safeApiCall(c01841, this);
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

    @Override // com.sputnik.domain.repositories.invites.IInvitesRepository
    public Flow<Resource<List<DomainInvite>>> getInvites(int version, String platform, String app, String locale) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return FlowKt.flow(new InvitesRepository$getInvites$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07031(version, platform, app, locale, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: InvitesRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/invites/DomainInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$acceptInvite$1", f = "InvitesRepository.kt", l = {47, 47}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$acceptInvite$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DomainInvite>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ String $source;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$source = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = InvitesRepository.this.new AnonymousClass1(this.$id, this.$source, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DomainInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DomainInvite>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DomainInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: InvitesRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/domain/entities/invites/DomainInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$acceptInvite$1$1", f = "InvitesRepository.kt", l = {47}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$acceptInvite$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01801 extends SuspendLambda implements Function1<Continuation<? super Response<DomainInvite>>, Object> {
            final /* synthetic */ String $id;
            final /* synthetic */ String $source;
            int label;
            final /* synthetic */ InvitesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01801(InvitesRepository invitesRepository, String str, String str2, Continuation<? super C01801> continuation) {
                super(1, continuation);
                this.this$0 = invitesRepository;
                this.$id = str;
                this.$source = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01801(this.this$0, this.$id, this.$source, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DomainInvite>> continuation) {
                return ((C01801) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InvitesApi api = this.this$0.getApi();
                    String str = this.$id;
                    DataManageInvites dataManageInvites = new DataManageInvites(this.$source);
                    this.label = 1;
                    obj = api.acceptInvite(str, dataManageInvites, this);
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
                InvitesRepository invitesRepository = InvitesRepository.this;
                C01801 c01801 = new C01801(invitesRepository, this.$id, this.$source, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = invitesRepository.safeApiCall(c01801, this);
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

    @Override // com.sputnik.domain.repositories.invites.IInvitesRepository
    public Flow<Resource<DomainInvite>> acceptInvite(String id, String source) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(source, "source");
        return FlowKt.flow(new InvitesRepository$acceptInvite$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(id, source, null)), Dispatchers.getIO()), null));
    }

    /* compiled from: InvitesRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/invites/DomainInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$declineInvite$1", f = "InvitesRepository.kt", l = {62, 62}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$declineInvite$1, reason: invalid class name and case insensitive filesystem */
    static final class C07001 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DomainInvite>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ String $source;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07001(String str, String str2, Continuation<? super C07001> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$source = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07001 c07001 = InvitesRepository.this.new C07001(this.$id, this.$source, continuation);
            c07001.L$0 = obj;
            return c07001;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DomainInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DomainInvite>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DomainInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07001) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: InvitesRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/domain/entities/invites/DomainInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$declineInvite$1$1", f = "InvitesRepository.kt", l = {62}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$declineInvite$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01811 extends SuspendLambda implements Function1<Continuation<? super Response<DomainInvite>>, Object> {
            final /* synthetic */ String $id;
            final /* synthetic */ String $source;
            int label;
            final /* synthetic */ InvitesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01811(InvitesRepository invitesRepository, String str, String str2, Continuation<? super C01811> continuation) {
                super(1, continuation);
                this.this$0 = invitesRepository;
                this.$id = str;
                this.$source = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01811(this.this$0, this.$id, this.$source, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DomainInvite>> continuation) {
                return ((C01811) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InvitesApi api = this.this$0.getApi();
                    String str = this.$id;
                    DataManageInvites dataManageInvites = new DataManageInvites(this.$source);
                    this.label = 1;
                    obj = api.declineInvite(str, dataManageInvites, this);
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
                InvitesRepository invitesRepository = InvitesRepository.this;
                C01811 c01811 = new C01811(invitesRepository, this.$id, this.$source, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = invitesRepository.safeApiCall(c01811, this);
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

    @Override // com.sputnik.domain.repositories.invites.IInvitesRepository
    public Flow<Resource<DomainInvite>> declineInvite(String id, String source) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(source, "source");
        return FlowKt.flow(new InvitesRepository$declineInvite$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07001(id, source, null)), Dispatchers.getIO()), null));
    }

    /* compiled from: InvitesRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/invites/DataFamilyInvites;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$getFamilyInvites$1", f = "InvitesRepository.kt", l = {77, 77}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$getFamilyInvites$1, reason: invalid class name and case insensitive filesystem */
    static final class C07021 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataFamilyInvites>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07021(int i, Continuation<? super C07021> continuation) {
            super(2, continuation);
            this.$addressId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07021 c07021 = InvitesRepository.this.new C07021(this.$addressId, continuation);
            c07021.L$0 = obj;
            return c07021;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataFamilyInvites>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataFamilyInvites>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataFamilyInvites>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07021) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: InvitesRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/invites/DataFamilyInvites;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$getFamilyInvites$1$1", f = "InvitesRepository.kt", l = {78}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$getFamilyInvites$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01831 extends SuspendLambda implements Function1<Continuation<? super Response<DataFamilyInvites>>, Object> {
            final /* synthetic */ int $addressId;
            int label;
            final /* synthetic */ InvitesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01831(InvitesRepository invitesRepository, int i, Continuation<? super C01831> continuation) {
                super(1, continuation);
                this.this$0 = invitesRepository;
                this.$addressId = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01831(this.this$0, this.$addressId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataFamilyInvites>> continuation) {
                return ((C01831) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InvitesApi api = this.this$0.getApi();
                    String strValueOf = String.valueOf(this.$addressId);
                    this.label = 1;
                    obj = api.getFamilyInvites(strValueOf, this);
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
                InvitesRepository invitesRepository = InvitesRepository.this;
                C01831 c01831 = new C01831(invitesRepository, this.$addressId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = invitesRepository.safeApiCall(c01831, this);
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

    @Override // com.sputnik.domain.repositories.invites.IInvitesRepository
    public Flow<Resource<DomainFamilyInvites>> getFamilyInvites(int addressId) {
        return FlowKt.flow(new InvitesRepository$getFamilyInvites$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07021(addressId, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: InvitesRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/invites/DataFamilyInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$sendFamilyInvite$1", f = "InvitesRepository.kt", l = {90, 90}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$sendFamilyInvite$1, reason: invalid class name and case insensitive filesystem */
    static final class C07051 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataFamilyInvite>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ String $phone;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07051(int i, String str, Continuation<? super C07051> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$phone = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07051 c07051 = InvitesRepository.this.new C07051(this.$addressId, this.$phone, continuation);
            c07051.L$0 = obj;
            return c07051;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataFamilyInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataFamilyInvite>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataFamilyInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07051) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: InvitesRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/invites/DataFamilyInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$sendFamilyInvite$1$1", f = "InvitesRepository.kt", l = {91}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$sendFamilyInvite$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01861 extends SuspendLambda implements Function1<Continuation<? super Response<DataFamilyInvite>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ String $phone;
            int label;
            final /* synthetic */ InvitesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01861(InvitesRepository invitesRepository, int i, String str, Continuation<? super C01861> continuation) {
                super(1, continuation);
                this.this$0 = invitesRepository;
                this.$addressId = i;
                this.$phone = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01861(this.this$0, this.$addressId, this.$phone, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataFamilyInvite>> continuation) {
                return ((C01861) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InvitesApi api = this.this$0.getApi();
                    String strValueOf = String.valueOf(this.$addressId);
                    String str = this.$phone;
                    this.label = 1;
                    obj = api.sendFamilyInvite(strValueOf, str, this);
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
                InvitesRepository invitesRepository = InvitesRepository.this;
                C01861 c01861 = new C01861(invitesRepository, this.$addressId, this.$phone, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = invitesRepository.safeApiCall(c01861, this);
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

    @Override // com.sputnik.domain.repositories.invites.IInvitesRepository
    public Flow<Resource<DomainFamilyInvite>> sendFamilyInvite(int addressId, String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        return FlowKt.flow(new InvitesRepository$sendFamilyInvite$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07051(addressId, phone, null)), Dispatchers.getIO()), null));
    }

    /* compiled from: InvitesRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/invites/DataFamilyInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$resendFamilyInvite$1", f = "InvitesRepository.kt", l = {113, 113}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$resendFamilyInvite$1, reason: invalid class name and case insensitive filesystem */
    static final class C07041 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataFamilyInvite>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ String $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07041(int i, String str, Continuation<? super C07041> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07041 c07041 = InvitesRepository.this.new C07041(this.$addressId, this.$id, continuation);
            c07041.L$0 = obj;
            return c07041;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataFamilyInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataFamilyInvite>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataFamilyInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07041) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: InvitesRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/invites/DataFamilyInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$resendFamilyInvite$1$1", f = "InvitesRepository.kt", l = {114}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$resendFamilyInvite$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01851 extends SuspendLambda implements Function1<Continuation<? super Response<DataFamilyInvite>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ String $id;
            int label;
            final /* synthetic */ InvitesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01851(InvitesRepository invitesRepository, int i, String str, Continuation<? super C01851> continuation) {
                super(1, continuation);
                this.this$0 = invitesRepository;
                this.$addressId = i;
                this.$id = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01851(this.this$0, this.$addressId, this.$id, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataFamilyInvite>> continuation) {
                return ((C01851) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InvitesApi api = this.this$0.getApi();
                    String strValueOf = String.valueOf(this.$addressId);
                    String str = this.$id;
                    this.label = 1;
                    obj = api.resendFamilyInvite(strValueOf, str, this);
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
                InvitesRepository invitesRepository = InvitesRepository.this;
                C01851 c01851 = new C01851(invitesRepository, this.$addressId, this.$id, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = invitesRepository.safeApiCall(c01851, this);
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

    @Override // com.sputnik.domain.repositories.invites.IInvitesRepository
    public Flow<Resource<DomainFamilyInvite>> resendFamilyInvite(int addressId, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.flow(new InvitesRepository$resendFamilyInvite$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07041(addressId, id, null)), Dispatchers.getIO()), null));
    }

    /* compiled from: InvitesRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/invites/DataFamilyInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$1", f = "InvitesRepository.kt", l = {136, 136}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$1, reason: invalid class name and case insensitive filesystem */
    static final class C07011 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataFamilyInvite>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ String $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07011(int i, String str, Continuation<? super C07011> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07011 c07011 = InvitesRepository.this.new C07011(this.$addressId, this.$id, continuation);
            c07011.L$0 = obj;
            return c07011;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataFamilyInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataFamilyInvite>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataFamilyInvite>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07011) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: InvitesRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/invites/DataFamilyInvite;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$1$1", f = "InvitesRepository.kt", l = {137}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.invites.InvitesRepository$deleteFamilyInvite$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01821 extends SuspendLambda implements Function1<Continuation<? super Response<DataFamilyInvite>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ String $id;
            int label;
            final /* synthetic */ InvitesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01821(InvitesRepository invitesRepository, int i, String str, Continuation<? super C01821> continuation) {
                super(1, continuation);
                this.this$0 = invitesRepository;
                this.$addressId = i;
                this.$id = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01821(this.this$0, this.$addressId, this.$id, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataFamilyInvite>> continuation) {
                return ((C01821) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InvitesApi api = this.this$0.getApi();
                    String strValueOf = String.valueOf(this.$addressId);
                    String str = this.$id;
                    this.label = 1;
                    obj = api.deleteFamilyInvite(strValueOf, str, this);
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
                InvitesRepository invitesRepository = InvitesRepository.this;
                C01821 c01821 = new C01821(invitesRepository, this.$addressId, this.$id, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = invitesRepository.safeApiCall(c01821, this);
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

    @Override // com.sputnik.domain.repositories.invites.IInvitesRepository
    public Flow<Resource<DomainFamilyInvite>> deleteFamilyInvite(int addressId, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.flow(new InvitesRepository$deleteFamilyInvite$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07011(addressId, id, null)), Dispatchers.getIO()), null));
    }
}
