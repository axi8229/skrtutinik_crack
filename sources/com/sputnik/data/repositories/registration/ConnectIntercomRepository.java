package com.sputnik.data.repositories.registration;

import com.sputnik.data.api.ConnectIntercomApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.connect_intercom.DataActivationCode;
import com.sputnik.data.entities.entry.DataEntry;
import com.sputnik.data.mappers.connect_intercom.DataActivationCodeToDomainActivationCodeMapper;
import com.sputnik.data.mappers.entry.DataEntryToDomainEntryMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.connect_intercom.DomainActivationCode;
import com.sputnik.domain.entities.entry.DomainEntry;
import com.sputnik.domain.repositories.registration.IConnectIntercomRepository;
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

/* compiled from: ConnectIntercomRepository.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0016J\u001e\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/sputnik/data/repositories/registration/ConnectIntercomRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/registration/IConnectIntercomRepository;", "connectIntercomApi", "Lcom/sputnik/data/api/ConnectIntercomApi;", "dataActivationCodeToDomainActivationCodeMapper", "Lcom/sputnik/data/mappers/connect_intercom/DataActivationCodeToDomainActivationCodeMapper;", "dataEntryToDomainEntryMapper", "Lcom/sputnik/data/mappers/entry/DataEntryToDomainEntryMapper;", "(Lcom/sputnik/data/api/ConnectIntercomApi;Lcom/sputnik/data/mappers/connect_intercom/DataActivationCodeToDomainActivationCodeMapper;Lcom/sputnik/data/mappers/entry/DataEntryToDomainEntryMapper;)V", "connectToIntercom", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/connect_intercom/DomainActivationCode;", "loadEntry", "Lcom/sputnik/domain/entities/entry/DomainEntry;", "entryUUID", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectIntercomRepository extends BaseApiResponse implements IConnectIntercomRepository {
    private final ConnectIntercomApi connectIntercomApi;
    private final DataActivationCodeToDomainActivationCodeMapper dataActivationCodeToDomainActivationCodeMapper;
    private final DataEntryToDomainEntryMapper dataEntryToDomainEntryMapper;

    public ConnectIntercomRepository(ConnectIntercomApi connectIntercomApi, DataActivationCodeToDomainActivationCodeMapper dataActivationCodeToDomainActivationCodeMapper, DataEntryToDomainEntryMapper dataEntryToDomainEntryMapper) {
        Intrinsics.checkNotNullParameter(connectIntercomApi, "connectIntercomApi");
        Intrinsics.checkNotNullParameter(dataActivationCodeToDomainActivationCodeMapper, "dataActivationCodeToDomainActivationCodeMapper");
        Intrinsics.checkNotNullParameter(dataEntryToDomainEntryMapper, "dataEntryToDomainEntryMapper");
        this.connectIntercomApi = connectIntercomApi;
        this.dataActivationCodeToDomainActivationCodeMapper = dataActivationCodeToDomainActivationCodeMapper;
        this.dataEntryToDomainEntryMapper = dataEntryToDomainEntryMapper;
    }

    /* compiled from: ConnectIntercomRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/connect_intercom/DataActivationCode;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.registration.ConnectIntercomRepository$connectToIntercom$1", f = "ConnectIntercomRepository.kt", l = {25, 25}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.registration.ConnectIntercomRepository$connectToIntercom$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataActivationCode>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ConnectIntercomRepository.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataActivationCode>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataActivationCode>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataActivationCode>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ConnectIntercomRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/connect_intercom/DataActivationCode;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.registration.ConnectIntercomRepository$connectToIntercom$1$1", f = "ConnectIntercomRepository.kt", l = {26}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.registration.ConnectIntercomRepository$connectToIntercom$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02451 extends SuspendLambda implements Function1<Continuation<? super Response<DataActivationCode>>, Object> {
            int label;
            final /* synthetic */ ConnectIntercomRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02451(ConnectIntercomRepository connectIntercomRepository, Continuation<? super C02451> continuation) {
                super(1, continuation);
                this.this$0 = connectIntercomRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02451(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataActivationCode>> continuation) {
                return ((C02451) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ConnectIntercomApi connectIntercomApi = this.this$0.connectIntercomApi;
                    this.label = 1;
                    obj = connectIntercomApi.connectToIntercom(this);
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
                ConnectIntercomRepository connectIntercomRepository = ConnectIntercomRepository.this;
                C02451 c02451 = new C02451(connectIntercomRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = connectIntercomRepository.safeApiCall(c02451, this);
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

    @Override // com.sputnik.domain.repositories.registration.IConnectIntercomRepository
    public Flow<Resource<DomainActivationCode>> connectToIntercom() {
        return FlowKt.flow(new ConnectIntercomRepository$connectToIntercom$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: ConnectIntercomRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/entry/DataEntry;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$1", f = "ConnectIntercomRepository.kt", l = {35, 35}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$1, reason: invalid class name and case insensitive filesystem */
    static final class C07351 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataEntry>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $entryUUID;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07351(String str, Continuation<? super C07351> continuation) {
            super(2, continuation);
            this.$entryUUID = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07351 c07351 = ConnectIntercomRepository.this.new C07351(this.$entryUUID, continuation);
            c07351.L$0 = obj;
            return c07351;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataEntry>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataEntry>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataEntry>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07351) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ConnectIntercomRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/entry/DataEntry;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$1$1", f = "ConnectIntercomRepository.kt", l = {37, 39}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.registration.ConnectIntercomRepository$loadEntry$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02461 extends SuspendLambda implements Function1<Continuation<? super Response<DataEntry>>, Object> {
            final /* synthetic */ String $entryUUID;
            int label;
            final /* synthetic */ ConnectIntercomRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02461(String str, ConnectIntercomRepository connectIntercomRepository, Continuation<? super C02461> continuation) {
                super(1, continuation);
                this.$entryUUID = str;
                this.this$0 = connectIntercomRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02461(this.$entryUUID, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataEntry>> continuation) {
                return ((C02461) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return (Response) obj;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return (Response) obj;
                }
                ResultKt.throwOnFailure(obj);
                if (this.$entryUUID == null) {
                    ConnectIntercomApi connectIntercomApi = this.this$0.connectIntercomApi;
                    this.label = 1;
                    obj = connectIntercomApi.getEntrySingleAddress(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (Response) obj;
                }
                ConnectIntercomApi connectIntercomApi2 = this.this$0.connectIntercomApi;
                String str = this.$entryUUID;
                this.label = 2;
                obj = connectIntercomApi2.getEntry(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (Response) obj;
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
                ConnectIntercomRepository connectIntercomRepository = ConnectIntercomRepository.this;
                C02461 c02461 = new C02461(this.$entryUUID, connectIntercomRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = connectIntercomRepository.safeApiCall(c02461, this);
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

    @Override // com.sputnik.domain.repositories.registration.IConnectIntercomRepository
    public Flow<Resource<DomainEntry>> loadEntry(String entryUUID) {
        return FlowKt.flow(new ConnectIntercomRepository$loadEntry$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07351(entryUUID, null)), Dispatchers.getIO()), null, this));
    }
}
