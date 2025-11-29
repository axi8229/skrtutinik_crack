package ru.yoomoney.sdk.auth.api.login;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.login.method.LoginAcquireAuthorizationResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterIdentifierRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterIdentifierResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterPasswordRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterPasswordResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginResponse;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0019H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u000fJ,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020!H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J$\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u000fJ,\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020)H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J,\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020.H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J,\u00101\u001a\b\u0012\u0004\u0012\u0002020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u000203H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J$\u00106\u001a\b\u0012\u0004\u0012\u0002070\u000b2\u0006\u0010\u0013\u001a\u000208H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "api", "Lru/yoomoney/sdk/auth/api/login/LoginApi;", "getToken", "Lkotlin/Function0;", "", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "(Lru/yoomoney/sdk/auth/api/login/LoginApi;Lkotlin/jvm/functions/Function0;Lru/yoomoney/sdk/auth/location/LocationHeaderManager;)V", "acquireAuthorization", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/login/method/LoginAcquireAuthorizationResponse;", "loginProcessId", "acquireAuthorization-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chooseAccount", "Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountResponse;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "request", "Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountRequest;", "chooseAccount-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "enterIdentifier", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterIdentifierResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterIdentifierRequest;", "enterIdentifier-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginEnterIdentifierRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCode", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeRequest;", "enterOauthCode-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPassword", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterPasswordResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterPasswordRequest;", "enterPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginEnterPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lru/yoomoney/sdk/auth/api/login/method/LoginResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;", "login-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginRepositoryImpl implements LoginRepository {
    private final LoginApi api;
    private final Function0<String> getToken;
    private final LocationHeaderManager locationHeaderManager;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {92}, m = "acquireAuthorization-gIAlu-s")
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3261acquireAuthorizationgIAlus = LoginRepositoryImpl.this.mo3261acquireAuthorizationgIAlus(null, this);
            return objMo3261acquireAuthorizationgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3261acquireAuthorizationgIAlus : Result.m2627boximpl(objMo3261acquireAuthorizationgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$acquireAuthorization$2", f = "LoginRepositoryImpl.kt", l = {93}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginAcquireAuthorizationResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginAcquireAuthorizationResponse>> continuation) {
            return LoginRepositoryImpl.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                String locationHeader = LoginRepositoryImpl.this.locationHeaderManager.getLocationHeader();
                String str2 = this.c;
                this.a = 1;
                obj = loginApi.acquireAuthorization(str, locationHeader, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {79}, m = "chooseAccount-0E7RQCE")
    public static final class c extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3262chooseAccount0E7RQCE = LoginRepositoryImpl.this.mo3262chooseAccount0E7RQCE(null, null, this);
            return objMo3262chooseAccount0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3262chooseAccount0E7RQCE : Result.m2627boximpl(objMo3262chooseAccount0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$chooseAccount$2", f = "LoginRepositoryImpl.kt", l = {80}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginChooseAccountResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ LoginChooseAccountRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, LoginChooseAccountRequest loginChooseAccountRequest, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = loginChooseAccountRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new d(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginChooseAccountResponse>> continuation) {
            return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                LoginChooseAccountRequest loginChooseAccountRequest = this.d;
                this.a = 1;
                obj = loginApi.chooseAccount(str, str2, loginChooseAccountRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {66}, m = "confirmEmail-0E7RQCE")
    public static final class e extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3263confirmEmail0E7RQCE = LoginRepositoryImpl.this.mo3263confirmEmail0E7RQCE(null, null, this);
            return objMo3263confirmEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3263confirmEmail0E7RQCE : Result.m2627boximpl(objMo3263confirmEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$confirmEmail$2", f = "LoginRepositoryImpl.kt", l = {67}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginConfirmEmailResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ LoginConfirmEmailRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, LoginConfirmEmailRequest loginConfirmEmailRequest, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = loginConfirmEmailRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new f(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginConfirmEmailResponse>> continuation) {
            return ((f) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                LoginConfirmEmailRequest loginConfirmEmailRequest = this.d;
                this.a = 1;
                obj = loginApi.confirmEmail(str, str2, loginConfirmEmailRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {72}, m = "confirmEmailResend-gIAlu-s")
    public static final class g extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3264confirmEmailResendgIAlus = LoginRepositoryImpl.this.mo3264confirmEmailResendgIAlus(null, this);
            return objMo3264confirmEmailResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3264confirmEmailResendgIAlus : Result.m2627boximpl(objMo3264confirmEmailResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$confirmEmailResend$2", f = "LoginRepositoryImpl.kt", l = {73}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginConfirmEmailResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, Continuation<? super h> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new h(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginConfirmEmailResendResponse>> continuation) {
            return LoginRepositoryImpl.this.new h(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = loginApi.confirmEmailResend(str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {53}, m = "confirmPhone-0E7RQCE")
    public static final class i extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3265confirmPhone0E7RQCE = LoginRepositoryImpl.this.mo3265confirmPhone0E7RQCE(null, null, this);
            return objMo3265confirmPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3265confirmPhone0E7RQCE : Result.m2627boximpl(objMo3265confirmPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$confirmPhone$2", f = "LoginRepositoryImpl.kt", l = {54}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginConfirmPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ LoginConfirmPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, LoginConfirmPhoneRequest loginConfirmPhoneRequest, Continuation<? super j> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = loginConfirmPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new j(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginConfirmPhoneResponse>> continuation) {
            return ((j) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                LoginConfirmPhoneRequest loginConfirmPhoneRequest = this.d;
                this.a = 1;
                obj = loginApi.confirmPhone(str, str2, loginConfirmPhoneRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {59}, m = "confirmPhoneResend-gIAlu-s")
    public static final class k extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3266confirmPhoneResendgIAlus = LoginRepositoryImpl.this.mo3266confirmPhoneResendgIAlus(null, this);
            return objMo3266confirmPhoneResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3266confirmPhoneResendgIAlus : Result.m2627boximpl(objMo3266confirmPhoneResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$confirmPhoneResend$2", f = "LoginRepositoryImpl.kt", l = {60}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginConfirmPhoneResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, Continuation<? super l> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new l(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginConfirmPhoneResendResponse>> continuation) {
            return LoginRepositoryImpl.this.new l(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = loginApi.confirmPhoneResend(str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {46}, m = "enterIdentifier-0E7RQCE")
    public static final class m extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public m(Continuation<? super m> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3267enterIdentifier0E7RQCE = LoginRepositoryImpl.this.mo3267enterIdentifier0E7RQCE(null, null, this);
            return objMo3267enterIdentifier0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3267enterIdentifier0E7RQCE : Result.m2627boximpl(objMo3267enterIdentifier0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$enterIdentifier$2", f = "LoginRepositoryImpl.kt", l = {47}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginEnterIdentifierResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ LoginEnterIdentifierRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(String str, LoginEnterIdentifierRequest loginEnterIdentifierRequest, Continuation<? super n> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = loginEnterIdentifierRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new n(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginEnterIdentifierResponse>> continuation) {
            return ((n) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                LoginEnterIdentifierRequest loginEnterIdentifierRequest = this.d;
                this.a = 1;
                obj = loginApi.enterIdentifier(str, str2, loginEnterIdentifierRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {39}, m = "enterOauthCode-0E7RQCE")
    public static final class o extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public o(Continuation<? super o> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3268enterOauthCode0E7RQCE = LoginRepositoryImpl.this.mo3268enterOauthCode0E7RQCE(null, null, this);
            return objMo3268enterOauthCode0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3268enterOauthCode0E7RQCE : Result.m2627boximpl(objMo3268enterOauthCode0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$enterOauthCode$2", f = "LoginRepositoryImpl.kt", l = {40}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginEnterOauthCodeResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ LoginEnterOauthCodeRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(String str, LoginEnterOauthCodeRequest loginEnterOauthCodeRequest, Continuation<? super p> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = loginEnterOauthCodeRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new p(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginEnterOauthCodeResponse>> continuation) {
            return ((p) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                LoginEnterOauthCodeRequest loginEnterOauthCodeRequest = this.d;
                this.a = 1;
                obj = loginApi.enterOauthCode(str, str2, loginEnterOauthCodeRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {86}, m = "enterPassword-0E7RQCE")
    public static final class q extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public q(Continuation<? super q> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3269enterPassword0E7RQCE = LoginRepositoryImpl.this.mo3269enterPassword0E7RQCE(null, null, this);
            return objMo3269enterPassword0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3269enterPassword0E7RQCE : Result.m2627boximpl(objMo3269enterPassword0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$enterPassword$2", f = "LoginRepositoryImpl.kt", l = {87}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginEnterPasswordResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ LoginEnterPasswordRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(String str, LoginEnterPasswordRequest loginEnterPasswordRequest, Continuation<? super r> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = loginEnterPasswordRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new r(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginEnterPasswordResponse>> continuation) {
            return ((r) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                LoginEnterPasswordRequest loginEnterPasswordRequest = this.d;
                this.a = 1;
                obj = loginApi.enterPassword(str, str2, loginEnterPasswordRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl", f = "LoginRepositoryImpl.kt", l = {32}, m = "login-gIAlu-s")
    public static final class s extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public s(Continuation<? super s> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3270logingIAlus = LoginRepositoryImpl.this.mo3270logingIAlus(null, this);
            return objMo3270logingIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3270logingIAlus : Result.m2627boximpl(objMo3270logingIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$login$2", f = "LoginRepositoryImpl.kt", l = {33}, m = "invokeSuspend")
    public static final class t extends SuspendLambda implements Function1<Continuation<? super Result<? extends LoginResponse>>, Object> {
        public int a;
        public final /* synthetic */ LoginRequest c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(LoginRequest loginRequest, Continuation<? super t> continuation) {
            super(1, continuation);
            this.c = loginRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginRepositoryImpl.this.new t(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends LoginResponse>> continuation) {
            return LoginRepositoryImpl.this.new t(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoginApi loginApi = LoginRepositoryImpl.this.api;
                String str = (String) LoginRepositoryImpl.this.getToken.invoke();
                LoginRequest loginRequest = this.c;
                this.a = 1;
                obj = loginApi.login(str, loginRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    public LoginRepositoryImpl(LoginApi api, Function0<String> getToken, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(getToken, "getToken");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        this.api = api;
        this.getToken = getToken;
        this.locationHeaderManager = locationHeaderManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: acquireAuthorization-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3261acquireAuthorizationgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginAcquireAuthorizationResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$b r6 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$b
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3261acquireAuthorizationgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: chooseAccount-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3262chooseAccount0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$d r7 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$d
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3262chooseAccount0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: confirmEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3263confirmEmail0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$f r7 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$f
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3263confirmEmail0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: confirmEmailResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3264confirmEmailResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.g
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$g r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$g r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$h r6 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$h
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3264confirmEmailResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: confirmPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3265confirmPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.i
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$i r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$i r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$j r7 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$j
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3265confirmPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: confirmPhoneResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3266confirmPhoneResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.k
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$k r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$k r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$k
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$l r6 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$l
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3266confirmPhoneResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: enterIdentifier-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3267enterIdentifier0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.login.method.LoginEnterIdentifierRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginEnterIdentifierResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.m
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$m r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$m r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$m
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$n r7 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$n
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3267enterIdentifier0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.login.method.LoginEnterIdentifierRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: enterOauthCode-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3268enterOauthCode0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.o
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$o r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$o r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$o
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$p r7 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$p
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3268enterOauthCode0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: enterPassword-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3269enterPassword0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.login.method.LoginEnterPasswordRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginEnterPasswordResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.q
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$q r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.q) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$q r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$q
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$r r7 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$r
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3269enterPassword0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.login.method.LoginEnterPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.login.LoginRepository
    /* renamed from: login-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3270logingIAlus(ru.yoomoney.sdk.auth.api.login.method.LoginRequest r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.login.method.LoginResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.s
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$s r0 = (ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.s) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$s r0 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$s
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$t r6 = new ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl$t
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl.mo3270logingIAlus(ru.yoomoney.sdk.auth.api.login.method.LoginRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
