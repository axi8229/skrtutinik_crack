package ru.yoomoney.sdk.auth.api.account.emailChange;

import com.google.android.gms.common.Scopes;
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
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailForgotResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneForgotResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordRequest;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailRequest;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailSuccessResponse;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0016J,\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u001cH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0016J$\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0016J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\fH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J,\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020+H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\b\u0010.\u001a\u00020\u0005H\u0002J,\u0010/\u001a\b\u0012\u0004\u0012\u0002000\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "api", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeApi;", "token", "", "(Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeApi;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "confirmEmail", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailResponse;", "changeEmailProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailForgot", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailForgotResponse;", "confirmEmailForgot-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneForgotResponse;", "confirmPhoneForgot-gIAlu-s", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", Scopes.EMAIL, "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailSuccessResponse;", "email-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPassword", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordResponse;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordRequest;", "enterPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareAuthorizationHeader", "setEmail", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailResponse;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailRequest;", "setEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailChangeRepositoryImpl implements EmailChangeRepository {
    private final EmailChangeApi api;
    private String token;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl", f = "EmailChangeRepositoryImpl.kt", l = {33}, m = "confirmEmail-0E7RQCE")
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
            Object objMo3214confirmEmail0E7RQCE = EmailChangeRepositoryImpl.this.mo3214confirmEmail0E7RQCE(null, null, this);
            return objMo3214confirmEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3214confirmEmail0E7RQCE : Result.m2627boximpl(objMo3214confirmEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$confirmEmail$2", f = "EmailChangeRepositoryImpl.kt", l = {34}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends EmailChangeConfirmEmailResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ EmailChangeConfirmEmailRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, EmailChangeConfirmEmailRequest emailChangeConfirmEmailRequest, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = emailChangeConfirmEmailRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EmailChangeRepositoryImpl.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EmailChangeConfirmEmailResponse>> continuation) {
            return ((b) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailChangeApi emailChangeApi = EmailChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = EmailChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                EmailChangeConfirmEmailRequest emailChangeConfirmEmailRequest = this.d;
                this.a = 1;
                obj = emailChangeApi.confirmEmail(strPrepareAuthorizationHeader, str, emailChangeConfirmEmailRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl", f = "EmailChangeRepositoryImpl.kt", l = {52}, m = "confirmEmailForgot-gIAlu-s")
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
            Object objMo3215confirmEmailForgotgIAlus = EmailChangeRepositoryImpl.this.mo3215confirmEmailForgotgIAlus(null, this);
            return objMo3215confirmEmailForgotgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3215confirmEmailForgotgIAlus : Result.m2627boximpl(objMo3215confirmEmailForgotgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$confirmEmailForgot$2", f = "EmailChangeRepositoryImpl.kt", l = {53}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends EmailChangeConfirmEmailForgotResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EmailChangeRepositoryImpl.this.new d(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EmailChangeConfirmEmailForgotResponse>> continuation) {
            return EmailChangeRepositoryImpl.this.new d(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailChangeApi emailChangeApi = EmailChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = EmailChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = emailChangeApi.confirmEmailForgot(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl", f = "EmailChangeRepositoryImpl.kt", l = {43}, m = "confirmEmailResend-gIAlu-s")
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
            Object objMo3216confirmEmailResendgIAlus = EmailChangeRepositoryImpl.this.mo3216confirmEmailResendgIAlus(null, this);
            return objMo3216confirmEmailResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3216confirmEmailResendgIAlus : Result.m2627boximpl(objMo3216confirmEmailResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$confirmEmailResend$2", f = "EmailChangeRepositoryImpl.kt", l = {44}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends EmailChangeConfirmEmailResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EmailChangeRepositoryImpl.this.new f(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EmailChangeConfirmEmailResendResponse>> continuation) {
            return EmailChangeRepositoryImpl.this.new f(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailChangeApi emailChangeApi = EmailChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = EmailChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = emailChangeApi.confirmEmailResend(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl", f = "EmailChangeRepositoryImpl.kt", l = {62}, m = "confirmPhone-0E7RQCE")
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
            Object objMo3217confirmPhone0E7RQCE = EmailChangeRepositoryImpl.this.mo3217confirmPhone0E7RQCE(null, null, this);
            return objMo3217confirmPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3217confirmPhone0E7RQCE : Result.m2627boximpl(objMo3217confirmPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$confirmPhone$2", f = "EmailChangeRepositoryImpl.kt", l = {63}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Result<? extends EmailChangeConfirmPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ EmailChangeConfirmPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, EmailChangeConfirmPhoneRequest emailChangeConfirmPhoneRequest, Continuation<? super h> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = emailChangeConfirmPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EmailChangeRepositoryImpl.this.new h(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EmailChangeConfirmPhoneResponse>> continuation) {
            return ((h) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailChangeApi emailChangeApi = EmailChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = EmailChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                EmailChangeConfirmPhoneRequest emailChangeConfirmPhoneRequest = this.d;
                this.a = 1;
                obj = emailChangeApi.confirmPhone(strPrepareAuthorizationHeader, str, emailChangeConfirmPhoneRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl", f = "EmailChangeRepositoryImpl.kt", l = {81}, m = "confirmPhoneForgot-gIAlu-s")
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
            Object objMo3218confirmPhoneForgotgIAlus = EmailChangeRepositoryImpl.this.mo3218confirmPhoneForgotgIAlus(null, this);
            return objMo3218confirmPhoneForgotgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3218confirmPhoneForgotgIAlus : Result.m2627boximpl(objMo3218confirmPhoneForgotgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$confirmPhoneForgot$2", f = "EmailChangeRepositoryImpl.kt", l = {82}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements Function1<Continuation<? super Result<? extends EmailChangeConfirmPhoneForgotResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, Continuation<? super j> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EmailChangeRepositoryImpl.this.new j(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EmailChangeConfirmPhoneForgotResponse>> continuation) {
            return EmailChangeRepositoryImpl.this.new j(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailChangeApi emailChangeApi = EmailChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = EmailChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = emailChangeApi.confirmPhoneForgot(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl", f = "EmailChangeRepositoryImpl.kt", l = {72}, m = "confirmPhoneResend-gIAlu-s")
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
            Object objMo3219confirmPhoneResendgIAlus = EmailChangeRepositoryImpl.this.mo3219confirmPhoneResendgIAlus(null, this);
            return objMo3219confirmPhoneResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3219confirmPhoneResendgIAlus : Result.m2627boximpl(objMo3219confirmPhoneResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$confirmPhoneResend$2", f = "EmailChangeRepositoryImpl.kt", l = {73}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements Function1<Continuation<? super Result<? extends EmailChangeConfirmPhoneResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, Continuation<? super l> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EmailChangeRepositoryImpl.this.new l(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EmailChangeConfirmPhoneResendResponse>> continuation) {
            return EmailChangeRepositoryImpl.this.new l(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailChangeApi emailChangeApi = EmailChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = EmailChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = emailChangeApi.confirmPhoneResend(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl", f = "EmailChangeRepositoryImpl.kt", l = {24}, m = "email-IoAF18A")
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
            Object objMo3220emailIoAF18A = EmailChangeRepositoryImpl.this.mo3220emailIoAF18A(this);
            return objMo3220emailIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3220emailIoAF18A : Result.m2627boximpl(objMo3220emailIoAF18A);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$email$2", f = "EmailChangeRepositoryImpl.kt", l = {25}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements Function1<Continuation<? super Result<? extends EmailSuccessResponse>>, Object> {
        public int a;

        public n(Continuation<? super n> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EmailChangeRepositoryImpl.this.new n(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EmailSuccessResponse>> continuation) {
            return EmailChangeRepositoryImpl.this.new n(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailChangeApi emailChangeApi = EmailChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = EmailChangeRepositoryImpl.this.prepareAuthorizationHeader();
                this.a = 1;
                obj = emailChangeApi.email(strPrepareAuthorizationHeader, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl", f = "EmailChangeRepositoryImpl.kt", l = {91}, m = "enterPassword-0E7RQCE")
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
            Object objMo3221enterPassword0E7RQCE = EmailChangeRepositoryImpl.this.mo3221enterPassword0E7RQCE(null, null, this);
            return objMo3221enterPassword0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3221enterPassword0E7RQCE : Result.m2627boximpl(objMo3221enterPassword0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$enterPassword$2", f = "EmailChangeRepositoryImpl.kt", l = {92}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements Function1<Continuation<? super Result<? extends EmailChangeEnterPasswordResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ EmailChangeEnterPasswordRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(String str, EmailChangeEnterPasswordRequest emailChangeEnterPasswordRequest, Continuation<? super p> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = emailChangeEnterPasswordRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EmailChangeRepositoryImpl.this.new p(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EmailChangeEnterPasswordResponse>> continuation) {
            return ((p) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailChangeApi emailChangeApi = EmailChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = EmailChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                EmailChangeEnterPasswordRequest emailChangeEnterPasswordRequest = this.d;
                this.a = 1;
                obj = emailChangeApi.enterPassword(strPrepareAuthorizationHeader, str, emailChangeEnterPasswordRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl", f = "EmailChangeRepositoryImpl.kt", l = {102}, m = "setEmail-0E7RQCE")
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
            Object objMo3222setEmail0E7RQCE = EmailChangeRepositoryImpl.this.mo3222setEmail0E7RQCE(null, null, this);
            return objMo3222setEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3222setEmail0E7RQCE : Result.m2627boximpl(objMo3222setEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$setEmail$2", f = "EmailChangeRepositoryImpl.kt", l = {103}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements Function1<Continuation<? super Result<? extends EmailChangeSetEmailResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ EmailChangeSetEmailRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(String str, EmailChangeSetEmailRequest emailChangeSetEmailRequest, Continuation<? super r> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = emailChangeSetEmailRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EmailChangeRepositoryImpl.this.new r(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EmailChangeSetEmailResponse>> continuation) {
            return ((r) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailChangeApi emailChangeApi = EmailChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = EmailChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                EmailChangeSetEmailRequest emailChangeSetEmailRequest = this.d;
                this.a = 1;
                obj = emailChangeApi.setEmail(strPrepareAuthorizationHeader, str, emailChangeSetEmailRequest, this);
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

    public EmailChangeRepositoryImpl(EmailChangeApi api, String token) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(token, "token");
        this.api = api;
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareAuthorizationHeader() {
        return "Bearer " + getToken();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    /* renamed from: confirmEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3214confirmEmail0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$a
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
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$b r7 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$b
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.mo3214confirmEmail0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    /* renamed from: confirmEmailForgot-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3215confirmEmailForgotgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailForgotResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$d r6 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$d
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.mo3215confirmEmailForgotgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    /* renamed from: confirmEmailResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3216confirmEmailResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$e
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
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$f r6 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$f
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.mo3216confirmEmailResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    /* renamed from: confirmPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3217confirmPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.g
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$g r0 = (ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$g r0 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$g
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
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$h r7 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$h
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.mo3217confirmPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    /* renamed from: confirmPhoneForgot-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3218confirmPhoneForgotgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneForgotResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.i
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$i r0 = (ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$i r0 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$i
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
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$j r6 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$j
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.mo3218confirmPhoneForgotgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    /* renamed from: confirmPhoneResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3219confirmPhoneResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.k
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$k r0 = (ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$k r0 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$k
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
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$l r6 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$l
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.mo3219confirmPhoneResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    /* renamed from: email-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3220emailIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailSuccessResponse>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.m
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$m r0 = (ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$m r0 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$m
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
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$n r5 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$n
            r2 = 0
            r5.<init>(r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r5, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.mo3220emailIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    /* renamed from: enterPassword-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3221enterPassword0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.o
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$o r0 = (ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$o r0 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$o
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
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$p r7 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$p
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.mo3221enterPassword0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    public String getToken() {
        return this.token;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    /* renamed from: setEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3222setEmail0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.q
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$q r0 = (ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.q) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$q r0 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$q
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
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$r r7 = new ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl$r
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepositoryImpl.mo3222setEmail0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository
    public void setToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.token = str;
    }
}
