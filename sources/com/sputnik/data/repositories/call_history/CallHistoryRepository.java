package com.sputnik.data.repositories.call_history;

import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;
import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.data.api.CallApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.call.DataCall;
import com.sputnik.data.entities.call_history.DataCallHistory;
import com.sputnik.data.mappers.call.DataCallToDomainCallMapper;
import com.sputnik.data.mappers.call_history.DataCallHistoryToDomainCallHistoryMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.DomainCall;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import com.sputnik.domain.repositories.call_history.ICallHistoryRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import retrofit2.Response;

/* compiled from: CallHistoryRepository.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/sputnik/data/repositories/call_history/CallHistoryRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;", "Landroidx/paging/PagingData;", "Lcom/sputnik/domain/entities/call_history/DomainCallHistory;", "callHistoryApi", "Lcom/sputnik/data/api/CallApi;", "callMapper", "Lcom/sputnik/data/mappers/call/DataCallToDomainCallMapper;", "mapper", "Lcom/sputnik/data/mappers/call_history/DataCallHistoryToDomainCallHistoryMapper;", "pagingSource", "Lcom/sputnik/data/repositories/call_history/CallHistoryPageSource;", "(Lcom/sputnik/data/api/CallApi;Lcom/sputnik/data/mappers/call/DataCallToDomainCallMapper;Lcom/sputnik/data/mappers/call_history/DataCallHistoryToDomainCallHistoryMapper;Lcom/sputnik/data/repositories/call_history/CallHistoryPageSource;)V", "deleteCall", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/call/DomainCall;", FailedBinderCallBack.CALLER_ID, "", "loadCallHistory", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallHistoryRepository extends BaseApiResponse implements ICallHistoryRepository<PagingData<DomainCallHistory>> {
    private final CallApi callHistoryApi;
    private final DataCallToDomainCallMapper callMapper;
    private final DataCallHistoryToDomainCallHistoryMapper mapper;
    private final CallHistoryPageSource pagingSource;

    public CallHistoryRepository(CallApi callHistoryApi, DataCallToDomainCallMapper callMapper, DataCallHistoryToDomainCallHistoryMapper mapper, CallHistoryPageSource pagingSource) {
        Intrinsics.checkNotNullParameter(callHistoryApi, "callHistoryApi");
        Intrinsics.checkNotNullParameter(callMapper, "callMapper");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        this.callHistoryApi = callHistoryApi;
        this.callMapper = callMapper;
        this.mapper = mapper;
        this.pagingSource = pagingSource;
    }

    @Override // com.sputnik.domain.repositories.call_history.ICallHistoryRepository
    public Flow<PagingData<DomainCallHistory>> loadCallHistory() {
        return FlowKt.flow(new CallHistoryRepository$loadCallHistory$$inlined$transform$1(FlowKt.flowOn(new Pager(new PagingConfig(20, 0, false, 20, 0, 0, 50, null), null, new Function0<PagingSource<Integer, DataCallHistory>>() { // from class: com.sputnik.data.repositories.call_history.CallHistoryRepository.loadCallHistory.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PagingSource<Integer, DataCallHistory> invoke() {
                return CallHistoryRepository.this.pagingSource;
            }
        }, 2, null).getFlow(), Dispatchers.getIO()), null, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object loadCallHistory$lambda$0$map(DataCallHistoryToDomainCallHistoryMapper dataCallHistoryToDomainCallHistoryMapper, DataCallHistory dataCallHistory, Continuation continuation) {
        return dataCallHistoryToDomainCallHistoryMapper.map(dataCallHistory);
    }

    /* compiled from: CallHistoryRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/call/DataCall;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.call_history.CallHistoryRepository$deleteCall$1", f = "CallHistoryRepository.kt", l = {45, 45}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.call_history.CallHistoryRepository$deleteCall$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataCall>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $callId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = CallHistoryRepository.this.new AnonymousClass1(this.$callId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataCall>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataCall>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataCall>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CallHistoryRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/call/DataCall;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.call_history.CallHistoryRepository$deleteCall$1$1", f = "CallHistoryRepository.kt", l = {45}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.call_history.CallHistoryRepository$deleteCall$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01381 extends SuspendLambda implements Function1<Continuation<? super Response<DataCall>>, Object> {
            final /* synthetic */ String $callId;
            int label;
            final /* synthetic */ CallHistoryRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01381(CallHistoryRepository callHistoryRepository, String str, Continuation<? super C01381> continuation) {
                super(1, continuation);
                this.this$0 = callHistoryRepository;
                this.$callId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01381(this.this$0, this.$callId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataCall>> continuation) {
                return ((C01381) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CallApi callApi = this.this$0.callHistoryApi;
                    String str = this.$callId;
                    this.label = 1;
                    obj = callApi.deleteCall(str, this);
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
                CallHistoryRepository callHistoryRepository = CallHistoryRepository.this;
                C01381 c01381 = new C01381(callHistoryRepository, this.$callId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = callHistoryRepository.safeApiCall(c01381, this);
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

    @Override // com.sputnik.domain.repositories.call_history.ICallHistoryRepository
    public Flow<Resource<DomainCall>> deleteCall(String callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        return FlowKt.flow(new CallHistoryRepository$deleteCall$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(callId, null)), Dispatchers.getIO()), null, this));
    }
}
