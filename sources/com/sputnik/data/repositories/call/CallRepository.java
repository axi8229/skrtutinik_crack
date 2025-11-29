package com.sputnik.data.repositories.call;

import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.data.api.CallApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.call.DataCall;
import com.sputnik.data.entities.call.DataSipAccount;
import com.sputnik.data.mappers.call.DataCallToDomainCallMapper;
import com.sputnik.data.mappers.call.DataSipCallToDomainSipCallMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.DomainCall;
import com.sputnik.domain.entities.call.DomainSipAccount;
import com.sputnik.domain.repositories.call.ICallRepository;
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

/* compiled from: CallRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001e\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\f0\u000bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/sputnik/data/repositories/call/CallRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/call/ICallRepository;", "callApi", "Lcom/sputnik/data/api/CallApi;", "callMapper", "Lcom/sputnik/data/mappers/call/DataCallToDomainCallMapper;", "calSipMapper", "Lcom/sputnik/data/mappers/call/DataSipCallToDomainSipCallMapper;", "(Lcom/sputnik/data/api/CallApi;Lcom/sputnik/data/mappers/call/DataCallToDomainCallMapper;Lcom/sputnik/data/mappers/call/DataSipCallToDomainSipCallMapper;)V", "acceptCall", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", FailedBinderCallBack.CALLER_ID, "", "getCall", "Lcom/sputnik/domain/entities/call/DomainCall;", "getSipAccount", "Lcom/sputnik/domain/entities/call/DomainSipAccount;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallRepository extends BaseApiResponse implements ICallRepository {
    private final DataSipCallToDomainSipCallMapper calSipMapper;
    private final CallApi callApi;
    private final DataCallToDomainCallMapper callMapper;

    public CallRepository(CallApi callApi, DataCallToDomainCallMapper callMapper, DataSipCallToDomainSipCallMapper calSipMapper) {
        Intrinsics.checkNotNullParameter(callApi, "callApi");
        Intrinsics.checkNotNullParameter(callMapper, "callMapper");
        Intrinsics.checkNotNullParameter(calSipMapper, "calSipMapper");
        this.callApi = callApi;
        this.callMapper = callMapper;
        this.calSipMapper = calSipMapper;
    }

    /* compiled from: CallRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/call/DataCall;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.call.CallRepository$getCall$1", f = "CallRepository.kt", l = {25, 25}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.call.CallRepository$getCall$1, reason: invalid class name and case insensitive filesystem */
    static final class C06841 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataCall>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $callId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06841(String str, Continuation<? super C06841> continuation) {
            super(2, continuation);
            this.$callId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06841 c06841 = CallRepository.this.new C06841(this.$callId, continuation);
            c06841.L$0 = obj;
            return c06841;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataCall>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataCall>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataCall>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06841) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CallRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/call/DataCall;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.call.CallRepository$getCall$1$1", f = "CallRepository.kt", l = {25}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.call.CallRepository$getCall$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01341 extends SuspendLambda implements Function1<Continuation<? super Response<DataCall>>, Object> {
            final /* synthetic */ String $callId;
            int label;
            final /* synthetic */ CallRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01341(CallRepository callRepository, String str, Continuation<? super C01341> continuation) {
                super(1, continuation);
                this.this$0 = callRepository;
                this.$callId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01341(this.this$0, this.$callId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataCall>> continuation) {
                return ((C01341) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CallApi callApi = this.this$0.callApi;
                    String str = this.$callId;
                    this.label = 1;
                    obj = callApi.getCall(str, this);
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
                CallRepository callRepository = CallRepository.this;
                C01341 c01341 = new C01341(callRepository, this.$callId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = callRepository.safeApiCall(c01341, this);
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

    @Override // com.sputnik.domain.repositories.call.ICallRepository
    public Flow<Resource<DomainCall>> getCall(String callId) {
        return FlowKt.flow(new CallRepository$getCall$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06841(callId, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: CallRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.call.CallRepository$acceptCall$1", f = "CallRepository.kt", l = {33, 33}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.call.CallRepository$acceptCall$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
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
            AnonymousClass1 anonymousClass1 = CallRepository.this.new AnonymousClass1(this.$callId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CallRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.call.CallRepository$acceptCall$1$1", f = "CallRepository.kt", l = {33}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.call.CallRepository$acceptCall$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01331 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $callId;
            int label;
            final /* synthetic */ CallRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01331(CallRepository callRepository, String str, Continuation<? super C01331> continuation) {
                super(1, continuation);
                this.this$0 = callRepository;
                this.$callId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01331(this.this$0, this.$callId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01331) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CallApi callApi = this.this$0.callApi;
                    String str = this.$callId;
                    this.label = 1;
                    obj = callApi.acceptCall(str, this);
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
                CallRepository callRepository = CallRepository.this;
                C01331 c01331 = new C01331(callRepository, this.$callId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = callRepository.safeApiCall(c01331, this);
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

    @Override // com.sputnik.domain.repositories.call.ICallRepository
    public Flow<Resource<Unit>> acceptCall(String callId) {
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(callId, null)), Dispatchers.getIO());
    }

    /* compiled from: CallRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/call/DataSipAccount;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.call.CallRepository$getSipAccount$1", f = "CallRepository.kt", l = {39, 39}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.call.CallRepository$getSipAccount$1, reason: invalid class name and case insensitive filesystem */
    static final class C06851 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataSipAccount>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C06851(Continuation<? super C06851> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06851 c06851 = CallRepository.this.new C06851(continuation);
            c06851.L$0 = obj;
            return c06851;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataSipAccount>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataSipAccount>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataSipAccount>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06851) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CallRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/call/DataSipAccount;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.call.CallRepository$getSipAccount$1$1", f = "CallRepository.kt", l = {39}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.call.CallRepository$getSipAccount$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01351 extends SuspendLambda implements Function1<Continuation<? super Response<DataSipAccount>>, Object> {
            int label;
            final /* synthetic */ CallRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01351(CallRepository callRepository, Continuation<? super C01351> continuation) {
                super(1, continuation);
                this.this$0 = callRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01351(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataSipAccount>> continuation) {
                return ((C01351) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CallApi callApi = this.this$0.callApi;
                    this.label = 1;
                    obj = callApi.getSipAccount(this);
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
                CallRepository callRepository = CallRepository.this;
                C01351 c01351 = new C01351(callRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = callRepository.safeApiCall(c01351, this);
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

    @Override // com.sputnik.domain.repositories.call.ICallRepository
    public Flow<Resource<DomainSipAccount>> getSipAccount() {
        return FlowKt.flow(new CallRepository$getSipAccount$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06851(null)), Dispatchers.getIO()), null, this));
    }
}
