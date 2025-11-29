package com.sputnik.data.repositories.auth;

import com.sputnik.data.api.AuthApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.auth.DataApplyRegistration;
import com.sputnik.data.entities.auth.DataApplyRegistrationResponse;
import com.sputnik.data.entities.auth.DataConfirmRequest;
import com.sputnik.data.entities.auth.DataConfirmResponse;
import com.sputnik.data.entities.auth.DataRequestInfo;
import com.sputnik.data.mappers.auth.DataApplyRegistrationToDomainApplyRegistrationMapper;
import com.sputnik.data.mappers.auth.DataConfirmRegistrationToDomainConfirmRegistrationMapper;
import com.sputnik.data.mappers.auth.DataConfirmToDomainConfirmMapper;
import com.sputnik.data.mappers.auth.DataPhoneRequestToDomainPhoneRequestMapper;
import com.sputnik.data.mappers.auth.DataRequestInfoToDomainRequestInfoMapper;
import com.sputnik.data.processors.NetworkProcessUtils;
import com.sputnik.data.processors.NetworkString;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.DomainApplyRegistration;
import com.sputnik.domain.entities.auth.DomainConfirmResponse;
import com.sputnik.domain.entities.auth.DomainRequestInfo;
import com.sputnik.domain.repositories.auth.IAuthRepository;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
import org.pjsip.pjsua2.pjsip_transport_type_e;
import retrofit2.Response;

/* compiled from: AuthRepository.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJM\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00170\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00170\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010#R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010$R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010&R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010'R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010(¨\u0006)"}, d2 = {"Lcom/sputnik/data/repositories/auth/AuthRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/auth/IAuthRepository;", "Lcom/sputnik/data/api/AuthApi;", "authApi", "Lcom/sputnik/data/mappers/auth/DataConfirmToDomainConfirmMapper;", "mapper", "Lcom/sputnik/data/mappers/auth/DataPhoneRequestToDomainPhoneRequestMapper;", "phoneRequestMapper", "Lcom/sputnik/data/mappers/auth/DataApplyRegistrationToDomainApplyRegistrationMapper;", "applyRegistrationMapper", "Lcom/sputnik/data/mappers/auth/DataConfirmRegistrationToDomainConfirmRegistrationMapper;", "confirmRegistrationMapper", "Lcom/sputnik/data/mappers/auth/DataRequestInfoToDomainRequestInfoMapper;", "requestMapper", "<init>", "(Lcom/sputnik/data/api/AuthApi;Lcom/sputnik/data/mappers/auth/DataConfirmToDomainConfirmMapper;Lcom/sputnik/data/mappers/auth/DataPhoneRequestToDomainPhoneRequestMapper;Lcom/sputnik/data/mappers/auth/DataApplyRegistrationToDomainApplyRegistrationMapper;Lcom/sputnik/data/mappers/auth/DataConfirmRegistrationToDomainConfirmRegistrationMapper;Lcom/sputnik/data/mappers/auth/DataRequestInfoToDomainRequestInfoMapper;)V", "", "phone", "locale", "app", "platform", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/auth/DomainApplyRegistration;", "apply", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "requestId", "authCode", "Lcom/sputnik/domain/entities/auth/DomainConfirmResponse;", "confirm", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/entities/auth/DomainRequestInfo;", "getRequest", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/data/api/AuthApi;", "Lcom/sputnik/data/mappers/auth/DataConfirmToDomainConfirmMapper;", "Lcom/sputnik/data/mappers/auth/DataPhoneRequestToDomainPhoneRequestMapper;", "Lcom/sputnik/data/mappers/auth/DataApplyRegistrationToDomainApplyRegistrationMapper;", "Lcom/sputnik/data/mappers/auth/DataConfirmRegistrationToDomainConfirmRegistrationMapper;", "Lcom/sputnik/data/mappers/auth/DataRequestInfoToDomainRequestInfoMapper;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthRepository extends BaseApiResponse implements IAuthRepository {
    private final DataApplyRegistrationToDomainApplyRegistrationMapper applyRegistrationMapper;
    private final AuthApi authApi;
    private final DataConfirmRegistrationToDomainConfirmRegistrationMapper confirmRegistrationMapper;
    private final DataConfirmToDomainConfirmMapper mapper;
    private final DataPhoneRequestToDomainPhoneRequestMapper phoneRequestMapper;
    private final DataRequestInfoToDomainRequestInfoMapper requestMapper;

    public AuthRepository(AuthApi authApi, DataConfirmToDomainConfirmMapper mapper, DataPhoneRequestToDomainPhoneRequestMapper phoneRequestMapper, DataApplyRegistrationToDomainApplyRegistrationMapper applyRegistrationMapper, DataConfirmRegistrationToDomainConfirmRegistrationMapper confirmRegistrationMapper, DataRequestInfoToDomainRequestInfoMapper requestMapper) {
        Intrinsics.checkNotNullParameter(authApi, "authApi");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(phoneRequestMapper, "phoneRequestMapper");
        Intrinsics.checkNotNullParameter(applyRegistrationMapper, "applyRegistrationMapper");
        Intrinsics.checkNotNullParameter(confirmRegistrationMapper, "confirmRegistrationMapper");
        Intrinsics.checkNotNullParameter(requestMapper, "requestMapper");
        this.authApi = authApi;
        this.mapper = mapper;
        this.phoneRequestMapper = phoneRequestMapper;
        this.applyRegistrationMapper = applyRegistrationMapper;
        this.confirmRegistrationMapper = confirmRegistrationMapper;
        this.requestMapper = requestMapper;
    }

    /* compiled from: AuthRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/auth/DataApplyRegistrationResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.auth.AuthRepository$apply$1", f = "AuthRepository.kt", l = {90, 90}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.auth.AuthRepository$apply$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataApplyRegistrationResponse>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $app;
        final /* synthetic */ String $locale;
        final /* synthetic */ String $phone;
        final /* synthetic */ String $platform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, String str4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$phone = str;
            this.$locale = str2;
            this.$platform = str3;
            this.$app = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = AuthRepository.this.new AnonymousClass1(this.$phone, this.$locale, this.$platform, this.$app, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataApplyRegistrationResponse>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataApplyRegistrationResponse>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataApplyRegistrationResponse>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AuthRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/auth/DataApplyRegistrationResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.auth.AuthRepository$apply$1$1", f = "AuthRepository.kt", l = {91}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.auth.AuthRepository$apply$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01281 extends SuspendLambda implements Function1<Continuation<? super Response<DataApplyRegistrationResponse>>, Object> {
            final /* synthetic */ String $app;
            final /* synthetic */ String $locale;
            final /* synthetic */ String $phone;
            final /* synthetic */ String $platform;
            int label;
            final /* synthetic */ AuthRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01281(AuthRepository authRepository, String str, String str2, String str3, String str4, Continuation<? super C01281> continuation) {
                super(1, continuation);
                this.this$0 = authRepository;
                this.$phone = str;
                this.$locale = str2;
                this.$platform = str3;
                this.$app = str4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01281(this.this$0, this.$phone, this.$locale, this.$platform, this.$app, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataApplyRegistrationResponse>> continuation) {
                return ((C01281) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuthApi authApi = this.this$0.authApi;
                    DataApplyRegistration dataApplyRegistration = new DataApplyRegistration(this.$phone, this.$locale, this.$platform, this.$app, 0L, 16, null);
                    this.label = 1;
                    obj = authApi.apply(dataApplyRegistration, this);
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
                AuthRepository authRepository = AuthRepository.this;
                C01281 c01281 = new C01281(authRepository, this.$phone, this.$locale, this.$platform, this.$app, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = authRepository.safeApiCall(c01281, this);
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

    @Override // com.sputnik.domain.repositories.auth.IAuthRepository
    public Flow<Resource<DomainApplyRegistration>> apply(String phone, String locale, String app, String platform) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(platform, "platform");
        return FlowKt.flow(new AuthRepository$apply$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(phone, locale, platform, app, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: AuthRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/auth/DataConfirmResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.auth.AuthRepository$confirm$1", f = "AuthRepository.kt", l = {113, 113}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.auth.AuthRepository$confirm$1, reason: invalid class name and case insensitive filesystem */
    static final class C06821 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataConfirmResponse>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $app;
        final /* synthetic */ String $authCode;
        final /* synthetic */ String $phone;
        final /* synthetic */ String $platform;
        final /* synthetic */ String $requestId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06821(String str, String str2, String str3, String str4, String str5, Continuation<? super C06821> continuation) {
            super(2, continuation);
            this.$requestId = str;
            this.$authCode = str2;
            this.$platform = str3;
            this.$app = str4;
            this.$phone = str5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06821 c06821 = AuthRepository.this.new C06821(this.$requestId, this.$authCode, this.$platform, this.$app, this.$phone, continuation);
            c06821.L$0 = obj;
            return c06821;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataConfirmResponse>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataConfirmResponse>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataConfirmResponse>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06821) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AuthRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/auth/DataConfirmResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.auth.AuthRepository$confirm$1$1", f = "AuthRepository.kt", l = {114}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.auth.AuthRepository$confirm$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01291 extends SuspendLambda implements Function1<Continuation<? super Response<DataConfirmResponse>>, Object> {
            final /* synthetic */ String $app;
            final /* synthetic */ String $authCode;
            final /* synthetic */ String $phone;
            final /* synthetic */ String $platform;
            final /* synthetic */ String $requestId;
            int label;
            final /* synthetic */ AuthRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01291(AuthRepository authRepository, String str, String str2, String str3, String str4, String str5, Continuation<? super C01291> continuation) {
                super(1, continuation);
                this.this$0 = authRepository;
                this.$requestId = str;
                this.$authCode = str2;
                this.$platform = str3;
                this.$app = str4;
                this.$phone = str5;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01291(this.this$0, this.$requestId, this.$authCode, this.$platform, this.$app, this.$phone, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataConfirmResponse>> continuation) {
                return ((C01291) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuthApi authApi = this.this$0.authApi;
                    String strValueOf = String.valueOf(this.$requestId);
                    DataConfirmRequest dataConfirmRequest = new DataConfirmRequest(this.$requestId, this.$authCode, this.$platform, this.$app, this.$phone, 0L, 32, null);
                    this.label = 1;
                    obj = authApi.confirm(strValueOf, dataConfirmRequest, this);
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
                AuthRepository authRepository = AuthRepository.this;
                C01291 c01291 = new C01291(authRepository, this.$requestId, this.$authCode, this.$platform, this.$app, this.$phone, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = authRepository.safeApiCall(c01291, this);
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

    @Override // com.sputnik.domain.repositories.auth.IAuthRepository
    public Flow<Resource<DomainConfirmResponse>> confirm(String requestId, String authCode, String platform, String app, String phone) {
        return FlowKt.flow(new AuthRepository$confirm$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06821(requestId, authCode, platform, app, phone, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: AuthRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/auth/DataRequestInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.auth.AuthRepository$getRequest$1", f = "AuthRepository.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6, pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.auth.AuthRepository$getRequest$1, reason: invalid class name and case insensitive filesystem */
    static final class C06831 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataRequestInfo>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $phone;
        final /* synthetic */ String $requestId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06831(String str, String str2, Continuation<? super C06831> continuation) {
            super(2, continuation);
            this.$phone = str;
            this.$requestId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06831 c06831 = AuthRepository.this.new C06831(this.$phone, this.$requestId, continuation);
            c06831.L$0 = obj;
            return c06831;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataRequestInfo>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataRequestInfo>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataRequestInfo>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06831) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AuthRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/auth/DataRequestInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.auth.AuthRepository$getRequest$1$1", f = "AuthRepository.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_TCP6}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.auth.AuthRepository$getRequest$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01301 extends SuspendLambda implements Function1<Continuation<? super Response<DataRequestInfo>>, Object> {
            final /* synthetic */ String $phone;
            final /* synthetic */ String $requestId;
            int label;
            final /* synthetic */ AuthRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01301(AuthRepository authRepository, String str, String str2, Continuation<? super C01301> continuation) {
                super(1, continuation);
                this.this$0 = authRepository;
                this.$phone = str;
                this.$requestId = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01301(this.this$0, this.$phone, this.$requestId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataRequestInfo>> continuation) {
                return ((C01301) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuthApi authApi = this.this$0.authApi;
                    String strProcess = NetworkProcessUtils.INSTANCE.process(this.$phone + "-" + (System.currentTimeMillis() / 1000), NetworkString.INSTANCE.getString());
                    String strValueOf = String.valueOf(this.$requestId);
                    this.label = 1;
                    obj = authApi.getRequest(strProcess, strValueOf, this);
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
                AuthRepository authRepository = AuthRepository.this;
                C01301 c01301 = new C01301(authRepository, this.$phone, this.$requestId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = authRepository.safeApiCall(c01301, this);
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

    @Override // com.sputnik.domain.repositories.auth.IAuthRepository
    public Flow<Resource<DomainRequestInfo>> getRequest(String requestId, String phone) {
        return FlowKt.flow(new AuthRepository$getRequest$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06831(phone, requestId, null)), Dispatchers.getIO()), null, this));
    }
}
