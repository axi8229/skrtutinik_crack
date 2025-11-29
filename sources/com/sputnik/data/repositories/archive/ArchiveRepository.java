package com.sputnik.data.repositories.archive;

import com.sputnik.data.api.ServicesApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.archive.DataArchiveResponse;
import com.sputnik.data.entities.archive.DataFlussonic;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import com.sputnik.domain.entities.archive.DomainFlussonic;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.repositories.archive.IArchiveRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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

/* compiled from: ArchiveRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BA\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/sputnik/data/repositories/archive/ArchiveRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/archive/IArchiveRepository;", "Lcom/sputnik/data/api/ServicesApi;", "archiveApi", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/archive/DataFlussonic;", "Lcom/sputnik/domain/entities/archive/DomainFlussonic;", "listMapper", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/archive/DataArchiveResponse;", "Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;", "archiveMapper", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Lcom/sputnik/data/api/ServicesApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/domain/common/Mapper;Lcom/sputnik/data/local/PrefManager;)V", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "getArchiveUrls", "()Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/data/api/ServicesApi;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/local/PrefManager;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveRepository extends BaseApiResponse implements IArchiveRepository {
    private final ServicesApi archiveApi;
    private final Mapper<DataArchiveResponse, DomainArchiveUrls> archiveMapper;
    private final ListMapper<DataFlussonic, DomainFlussonic> listMapper;
    private final PrefManager prefManager;

    public ArchiveRepository(ServicesApi archiveApi, ListMapper<DataFlussonic, DomainFlussonic> listMapper, Mapper<DataArchiveResponse, DomainArchiveUrls> archiveMapper, PrefManager prefManager) {
        Intrinsics.checkNotNullParameter(archiveApi, "archiveApi");
        Intrinsics.checkNotNullParameter(listMapper, "listMapper");
        Intrinsics.checkNotNullParameter(archiveMapper, "archiveMapper");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.archiveApi = archiveApi;
        this.listMapper = listMapper;
        this.archiveMapper = archiveMapper;
        this.prefManager = prefManager;
    }

    /* compiled from: ArchiveRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/archive/DataArchiveResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.archive.ArchiveRepository$getArchiveUrls$1", f = "ArchiveRepository.kt", l = {41, 41}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.archive.ArchiveRepository$getArchiveUrls$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataArchiveResponse>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ArchiveRepository.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataArchiveResponse>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataArchiveResponse>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataArchiveResponse>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ArchiveRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/archive/DataArchiveResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.archive.ArchiveRepository$getArchiveUrls$1$1", f = "ArchiveRepository.kt", l = {42}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.archive.ArchiveRepository$getArchiveUrls$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01241 extends SuspendLambda implements Function1<Continuation<? super Response<DataArchiveResponse>>, Object> {
            int label;
            final /* synthetic */ ArchiveRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01241(ArchiveRepository archiveRepository, Continuation<? super C01241> continuation) {
                super(1, continuation);
                this.this$0 = archiveRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01241(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataArchiveResponse>> continuation) {
                return ((C01241) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object objBoxLong;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ServicesApi servicesApi = this.this$0.archiveApi;
                    LoginState.Session.Address currentAddress = this.this$0.prefManager.getCurrentAddress();
                    if (currentAddress == null || (objBoxLong = currentAddress.getId()) == null) {
                        objBoxLong = Boxing.boxLong(-1L);
                    }
                    String string = objBoxLong.toString();
                    this.label = 1;
                    obj = servicesApi.getArchiveLinksUrl(string, this);
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
                ArchiveRepository archiveRepository = ArchiveRepository.this;
                C01241 c01241 = new C01241(archiveRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = archiveRepository.safeApiCall(c01241, this);
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

    @Override // com.sputnik.domain.repositories.archive.IArchiveRepository
    public Flow<Resource<DomainArchiveUrls>> getArchiveUrls() {
        return FlowKt.flow(new ArchiveRepository$getArchiveUrls$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO()), null, this));
    }
}
