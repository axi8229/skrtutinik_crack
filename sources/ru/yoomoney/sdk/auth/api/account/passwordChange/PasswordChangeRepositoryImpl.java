package ru.yoomoney.sdk.auth.api.account.passwordChange;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailForgotResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneForgotResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordForgotResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordRequest;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordRequest;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordSuccessResponse;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0016J,\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u001cH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0016J$\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0016J,\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020'H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J$\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010\u0016J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\fH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J\b\u00101\u001a\u00020\u0005H\u0002J,\u00102\u001a\b\u0012\u0004\u0012\u0002030\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000204H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "api", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeApi;", "token", "", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "(Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeApi;Ljava/lang/String;Lru/yoomoney/sdk/auth/location/LocationHeaderManager;)V", "getToken", "()Ljava/lang/String;", "confirmEmail", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailResponse;", "changePasswordProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailForgot", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailForgotResponse;", "confirmEmailForgot-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneForgotResponse;", "confirmPhoneForgot-gIAlu-s", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "enterPassword", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordResponse;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordRequest;", "enterPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPasswordForgot", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordForgotResponse;", "enterPasswordForgot-gIAlu-s", "password", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordSuccessResponse;", "password-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareAuthorizationHeader", "setPassword", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordRequest;", "setPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordChangeRepositoryImpl implements PasswordChangeRepository {
    private final PasswordChangeApi api;
    private final LocationHeaderManager locationHeaderManager;
    private final String token;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {36}, m = "confirmEmail-0E7RQCE")
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
            Object objMo3223confirmEmail0E7RQCE = PasswordChangeRepositoryImpl.this.mo3223confirmEmail0E7RQCE(null, null, this);
            return objMo3223confirmEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3223confirmEmail0E7RQCE : Result.m2627boximpl(objMo3223confirmEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$confirmEmail$2", f = "PasswordChangeRepositoryImpl.kt", l = {37}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordChangeConfirmEmailResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PasswordChangeConfirmEmailRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, PasswordChangeConfirmEmailRequest passwordChangeConfirmEmailRequest, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = passwordChangeConfirmEmailRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordChangeConfirmEmailResponse>> continuation) {
            return ((b) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                PasswordChangeConfirmEmailRequest passwordChangeConfirmEmailRequest = this.d;
                this.a = 1;
                obj = passwordChangeApi.confirmEmail(strPrepareAuthorizationHeader, str, passwordChangeConfirmEmailRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {46}, m = "confirmEmailForgot-gIAlu-s")
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
            Object objMo3224confirmEmailForgotgIAlus = PasswordChangeRepositoryImpl.this.mo3224confirmEmailForgotgIAlus(null, this);
            return objMo3224confirmEmailForgotgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3224confirmEmailForgotgIAlus : Result.m2627boximpl(objMo3224confirmEmailForgotgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$confirmEmailForgot$2", f = "PasswordChangeRepositoryImpl.kt", l = {47}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordChangeConfirmEmailForgotResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new d(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordChangeConfirmEmailForgotResponse>> continuation) {
            return PasswordChangeRepositoryImpl.this.new d(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = passwordChangeApi.confirmEmailForgot(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {55}, m = "confirmEmailResend-gIAlu-s")
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
            Object objMo3225confirmEmailResendgIAlus = PasswordChangeRepositoryImpl.this.mo3225confirmEmailResendgIAlus(null, this);
            return objMo3225confirmEmailResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3225confirmEmailResendgIAlus : Result.m2627boximpl(objMo3225confirmEmailResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$confirmEmailResend$2", f = "PasswordChangeRepositoryImpl.kt", l = {56}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordChangeConfirmEmailResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new f(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordChangeConfirmEmailResendResponse>> continuation) {
            return PasswordChangeRepositoryImpl.this.new f(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = passwordChangeApi.confirmEmailResend(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {65}, m = "confirmPhone-0E7RQCE")
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
            Object objMo3226confirmPhone0E7RQCE = PasswordChangeRepositoryImpl.this.mo3226confirmPhone0E7RQCE(null, null, this);
            return objMo3226confirmPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3226confirmPhone0E7RQCE : Result.m2627boximpl(objMo3226confirmPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$confirmPhone$2", f = "PasswordChangeRepositoryImpl.kt", l = {66}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordChangeConfirmPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PasswordChangeConfirmPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, PasswordChangeConfirmPhoneRequest passwordChangeConfirmPhoneRequest, Continuation<? super h> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = passwordChangeConfirmPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new h(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordChangeConfirmPhoneResponse>> continuation) {
            return ((h) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                PasswordChangeConfirmPhoneRequest passwordChangeConfirmPhoneRequest = this.d;
                this.a = 1;
                obj = passwordChangeApi.confirmPhone(strPrepareAuthorizationHeader, str, passwordChangeConfirmPhoneRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {75}, m = "confirmPhoneForgot-gIAlu-s")
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
            Object objMo3227confirmPhoneForgotgIAlus = PasswordChangeRepositoryImpl.this.mo3227confirmPhoneForgotgIAlus(null, this);
            return objMo3227confirmPhoneForgotgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3227confirmPhoneForgotgIAlus : Result.m2627boximpl(objMo3227confirmPhoneForgotgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$confirmPhoneForgot$2", f = "PasswordChangeRepositoryImpl.kt", l = {76}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordChangeConfirmPhoneForgotResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, Continuation<? super j> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new j(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordChangeConfirmPhoneForgotResponse>> continuation) {
            return PasswordChangeRepositoryImpl.this.new j(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = passwordChangeApi.confirmPhoneForgot(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {84}, m = "confirmPhoneResend-gIAlu-s")
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
            Object objMo3228confirmPhoneResendgIAlus = PasswordChangeRepositoryImpl.this.mo3228confirmPhoneResendgIAlus(null, this);
            return objMo3228confirmPhoneResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3228confirmPhoneResendgIAlus : Result.m2627boximpl(objMo3228confirmPhoneResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$confirmPhoneResend$2", f = "PasswordChangeRepositoryImpl.kt", l = {85}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordChangeConfirmPhoneResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, Continuation<? super l> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new l(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordChangeConfirmPhoneResendResponse>> continuation) {
            return PasswordChangeRepositoryImpl.this.new l(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = passwordChangeApi.confirmPhoneResend(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {106}, m = "enterPassword-0E7RQCE")
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
            Object objMo3229enterPassword0E7RQCE = PasswordChangeRepositoryImpl.this.mo3229enterPassword0E7RQCE(null, null, this);
            return objMo3229enterPassword0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3229enterPassword0E7RQCE : Result.m2627boximpl(objMo3229enterPassword0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$enterPassword$2", f = "PasswordChangeRepositoryImpl.kt", l = {107}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordChangeEnterPasswordResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PasswordChangeEnterPasswordRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(String str, PasswordChangeEnterPasswordRequest passwordChangeEnterPasswordRequest, Continuation<? super n> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = passwordChangeEnterPasswordRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new n(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordChangeEnterPasswordResponse>> continuation) {
            return ((n) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                PasswordChangeEnterPasswordRequest passwordChangeEnterPasswordRequest = this.d;
                this.a = 1;
                obj = passwordChangeApi.enterPassword(strPrepareAuthorizationHeader, str, passwordChangeEnterPasswordRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {116}, m = "enterPasswordForgot-gIAlu-s")
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
            Object objMo3230enterPasswordForgotgIAlus = PasswordChangeRepositoryImpl.this.mo3230enterPasswordForgotgIAlus(null, this);
            return objMo3230enterPasswordForgotgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3230enterPasswordForgotgIAlus : Result.m2627boximpl(objMo3230enterPasswordForgotgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$enterPasswordForgot$2", f = "PasswordChangeRepositoryImpl.kt", l = {117}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordChangeEnterPasswordForgotResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(String str, Continuation<? super p> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new p(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordChangeEnterPasswordForgotResponse>> continuation) {
            return PasswordChangeRepositoryImpl.this.new p(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = passwordChangeApi.enterPasswordForgot(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {27}, m = "password-IoAF18A")
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
            Object objMo3231passwordIoAF18A = PasswordChangeRepositoryImpl.this.mo3231passwordIoAF18A(this);
            return objMo3231passwordIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3231passwordIoAF18A : Result.m2627boximpl(objMo3231passwordIoAF18A);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$password$2", f = "PasswordChangeRepositoryImpl.kt", l = {28}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordSuccessResponse>>, Object> {
        public int a;

        public r(Continuation<? super r> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new r(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordSuccessResponse>> continuation) {
            return PasswordChangeRepositoryImpl.this.new r(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                this.a = 1;
                obj = passwordChangeApi.password(strPrepareAuthorizationHeader, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl", f = "PasswordChangeRepositoryImpl.kt", l = {94}, m = "setPassword-0E7RQCE")
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
            Object objMo3232setPassword0E7RQCE = PasswordChangeRepositoryImpl.this.mo3232setPassword0E7RQCE(null, null, this);
            return objMo3232setPassword0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3232setPassword0E7RQCE : Result.m2627boximpl(objMo3232setPassword0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$setPassword$2", f = "PasswordChangeRepositoryImpl.kt", l = {95}, m = "invokeSuspend")
    public static final class t extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordChangeSetPasswordResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PasswordChangeSetPasswordRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(String str, PasswordChangeSetPasswordRequest passwordChangeSetPasswordRequest, Continuation<? super t> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = passwordChangeSetPasswordRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordChangeRepositoryImpl.this.new t(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordChangeSetPasswordResponse>> continuation) {
            return ((t) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordChangeApi passwordChangeApi = PasswordChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PasswordChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String locationHeader = PasswordChangeRepositoryImpl.this.locationHeaderManager.getLocationHeader();
                String str = this.c;
                PasswordChangeSetPasswordRequest passwordChangeSetPasswordRequest = this.d;
                this.a = 1;
                obj = passwordChangeApi.setPassword(strPrepareAuthorizationHeader, locationHeader, str, passwordChangeSetPasswordRequest, this);
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

    public PasswordChangeRepositoryImpl(PasswordChangeApi api, String token, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        this.api = api;
        this.token = token;
        this.locationHeaderManager = locationHeaderManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareAuthorizationHeader() {
        return "Bearer " + getToken();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: confirmEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3223confirmEmail0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$a
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
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$b r7 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$b
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3223confirmEmail0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: confirmEmailForgot-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3224confirmEmailForgotgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailForgotResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$d r6 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$d
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3224confirmEmailForgotgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: confirmEmailResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3225confirmEmailResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$e
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
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$f r6 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$f
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3225confirmEmailResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: confirmPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3226confirmPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.g
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$g r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$g r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$g
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
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$h r7 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$h
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3226confirmPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: confirmPhoneForgot-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3227confirmPhoneForgotgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneForgotResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.i
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$i r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$i r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$i
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
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$j r6 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$j
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3227confirmPhoneForgotgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: confirmPhoneResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3228confirmPhoneResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.k
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$k r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$k r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$k
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
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$l r6 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$l
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3228confirmPhoneResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: enterPassword-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3229enterPassword0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.m
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$m r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$m r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$m
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
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$n r7 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$n
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3229enterPassword0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: enterPasswordForgot-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3230enterPasswordForgotgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordForgotResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.o
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$o r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$o r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$o
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
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$p r6 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$p
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3230enterPasswordForgotgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    public String getToken() {
        return this.token;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: password-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3231passwordIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordSuccessResponse>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.q
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$q r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.q) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$q r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$q
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r5)
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$r r5 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$r
            r2 = 0
            r5.<init>(r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r5, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3231passwordIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository
    /* renamed from: setPassword-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3232setPassword0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.s
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$s r0 = (ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.s) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$s r0 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$s
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
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$t r7 = new ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl$t
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepositoryImpl.mo3232setPassword0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
