package ru.yoomoney.sdk.auth.api.enrollment;

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
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcceptTermsResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPasswordRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPasswordResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSuggestAccountContinueResponse;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\rJ,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\rJ,\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u001cH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\rJ$\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\t2\u0006\u0010\u0013\u001a\u00020$H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&J,\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020)H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J,\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020.H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J,\u00101\u001a\b\u0012\u0004\u0012\u0002020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u000203H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J$\u00106\u001a\b\u0012\u0004\u0012\u0002070\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "api", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentApi;", "getToken", "Lkotlin/Function0;", "", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentApi;Lkotlin/jvm/functions/Function0;)V", "acceptTerms", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentAcceptTermsResponse;", "enrollmentProcessId", "acceptTerms-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireAuthorization", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentAcquireAuthorizationResponse;", "acquireAuthorization-gIAlu-s", "confirmEmail", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResponse;", "request", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "enrollment", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentRequest;", "enrollment-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailRequest;", "setEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPasswordRequest;", "setPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneRequest;", "setPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suggestAccount", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSuggestAccountContinueResponse;", "suggestAccount-gIAlu-s", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EnrollmentRepositoryImpl implements EnrollmentRepository {
    private final EnrollmentApi api;
    private final Function0<String> getToken;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {36}, m = "acceptTerms-gIAlu-s")
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
            Object objMo3248acceptTermsgIAlus = EnrollmentRepositoryImpl.this.mo3248acceptTermsgIAlus(null, this);
            return objMo3248acceptTermsgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3248acceptTermsgIAlus : Result.m2627boximpl(objMo3248acceptTermsgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$acceptTerms$2", f = "EnrollmentRepositoryImpl.kt", l = {37}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentAcceptTermsResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentAcceptTermsResponse>> continuation) {
            return EnrollmentRepositoryImpl.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = enrollmentApi.acceptTerms(str, str2, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {99}, m = "acquireAuthorization-gIAlu-s")
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
            Object objMo3249acquireAuthorizationgIAlus = EnrollmentRepositoryImpl.this.mo3249acquireAuthorizationgIAlus(null, this);
            return objMo3249acquireAuthorizationgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3249acquireAuthorizationgIAlus : Result.m2627boximpl(objMo3249acquireAuthorizationgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$acquireAuthorization$2", f = "EnrollmentRepositoryImpl.kt", l = {100}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentAcquireAuthorizationResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new d(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentAcquireAuthorizationResponse>> continuation) {
            return EnrollmentRepositoryImpl.this.new d(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = enrollmentApi.acquireAuthorization(str, str2, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {85}, m = "confirmEmail-0E7RQCE")
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
            Object objMo3250confirmEmail0E7RQCE = EnrollmentRepositoryImpl.this.mo3250confirmEmail0E7RQCE(null, null, this);
            return objMo3250confirmEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3250confirmEmail0E7RQCE : Result.m2627boximpl(objMo3250confirmEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$confirmEmail$2", f = "EnrollmentRepositoryImpl.kt", l = {86}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentConfirmEmailResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ EnrollmentConfirmEmailRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, EnrollmentConfirmEmailRequest enrollmentConfirmEmailRequest, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = enrollmentConfirmEmailRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new f(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentConfirmEmailResponse>> continuation) {
            return ((f) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                EnrollmentConfirmEmailRequest enrollmentConfirmEmailRequest = this.d;
                this.a = 1;
                obj = enrollmentApi.confirmEmail(str, str2, enrollmentConfirmEmailRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {92}, m = "confirmEmailResend-gIAlu-s")
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
            Object objMo3251confirmEmailResendgIAlus = EnrollmentRepositoryImpl.this.mo3251confirmEmailResendgIAlus(null, this);
            return objMo3251confirmEmailResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3251confirmEmailResendgIAlus : Result.m2627boximpl(objMo3251confirmEmailResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$confirmEmailResend$2", f = "EnrollmentRepositoryImpl.kt", l = {93}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentConfirmEmailResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, Continuation<? super h> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new h(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentConfirmEmailResendResponse>> continuation) {
            return EnrollmentRepositoryImpl.this.new h(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = enrollmentApi.confirmEmailResend(str, str2, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {50}, m = "confirmPhone-0E7RQCE")
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
            Object objMo3252confirmPhone0E7RQCE = EnrollmentRepositoryImpl.this.mo3252confirmPhone0E7RQCE(null, null, this);
            return objMo3252confirmPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3252confirmPhone0E7RQCE : Result.m2627boximpl(objMo3252confirmPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$confirmPhone$2", f = "EnrollmentRepositoryImpl.kt", l = {51}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentConfirmPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ EnrollmentConfirmPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, EnrollmentConfirmPhoneRequest enrollmentConfirmPhoneRequest, Continuation<? super j> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = enrollmentConfirmPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new j(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentConfirmPhoneResponse>> continuation) {
            return ((j) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                EnrollmentConfirmPhoneRequest enrollmentConfirmPhoneRequest = this.d;
                this.a = 1;
                obj = enrollmentApi.confirmPhone(str, str2, enrollmentConfirmPhoneRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {57}, m = "confirmPhoneResend-gIAlu-s")
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
            Object objMo3253confirmPhoneResendgIAlus = EnrollmentRepositoryImpl.this.mo3253confirmPhoneResendgIAlus(null, this);
            return objMo3253confirmPhoneResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3253confirmPhoneResendgIAlus : Result.m2627boximpl(objMo3253confirmPhoneResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$confirmPhoneResend$2", f = "EnrollmentRepositoryImpl.kt", l = {58}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentConfirmPhoneResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, Continuation<? super l> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new l(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentConfirmPhoneResendResponse>> continuation) {
            return EnrollmentRepositoryImpl.this.new l(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = enrollmentApi.confirmPhoneResend(str, str2, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {30}, m = "enrollment-gIAlu-s")
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
            Object objMo3254enrollmentgIAlus = EnrollmentRepositoryImpl.this.mo3254enrollmentgIAlus(null, this);
            return objMo3254enrollmentgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3254enrollmentgIAlus : Result.m2627boximpl(objMo3254enrollmentgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$enrollment$2", f = "EnrollmentRepositoryImpl.kt", l = {31}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentResponse>>, Object> {
        public int a;
        public final /* synthetic */ EnrollmentRequest c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(EnrollmentRequest enrollmentRequest, Continuation<? super n> continuation) {
            super(1, continuation);
            this.c = enrollmentRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new n(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentResponse>> continuation) {
            return EnrollmentRepositoryImpl.this.new n(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                EnrollmentRequest enrollmentRequest = this.c;
                this.a = 1;
                obj = enrollmentApi.enrollment(str, enrollmentRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {78}, m = "setEmail-0E7RQCE")
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
            Object objMo3255setEmail0E7RQCE = EnrollmentRepositoryImpl.this.mo3255setEmail0E7RQCE(null, null, this);
            return objMo3255setEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3255setEmail0E7RQCE : Result.m2627boximpl(objMo3255setEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$setEmail$2", f = "EnrollmentRepositoryImpl.kt", l = {79}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentSetEmailResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ EnrollmentSetEmailRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(String str, EnrollmentSetEmailRequest enrollmentSetEmailRequest, Continuation<? super p> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = enrollmentSetEmailRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new p(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentSetEmailResponse>> continuation) {
            return ((p) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                EnrollmentSetEmailRequest enrollmentSetEmailRequest = this.d;
                this.a = 1;
                obj = enrollmentApi.setEmail(str, str2, enrollmentSetEmailRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {64}, m = "setPassword-0E7RQCE")
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
            Object objMo3256setPassword0E7RQCE = EnrollmentRepositoryImpl.this.mo3256setPassword0E7RQCE(null, null, this);
            return objMo3256setPassword0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3256setPassword0E7RQCE : Result.m2627boximpl(objMo3256setPassword0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$setPassword$2", f = "EnrollmentRepositoryImpl.kt", l = {65}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentSetPasswordResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ EnrollmentSetPasswordRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(String str, EnrollmentSetPasswordRequest enrollmentSetPasswordRequest, Continuation<? super r> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = enrollmentSetPasswordRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new r(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentSetPasswordResponse>> continuation) {
            return ((r) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                EnrollmentSetPasswordRequest enrollmentSetPasswordRequest = this.d;
                this.a = 1;
                obj = enrollmentApi.setPassword(str, str2, enrollmentSetPasswordRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {43}, m = "setPhone-0E7RQCE")
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
            Object objMo3257setPhone0E7RQCE = EnrollmentRepositoryImpl.this.mo3257setPhone0E7RQCE(null, null, this);
            return objMo3257setPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3257setPhone0E7RQCE : Result.m2627boximpl(objMo3257setPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$setPhone$2", f = "EnrollmentRepositoryImpl.kt", l = {44}, m = "invokeSuspend")
    public static final class t extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentSetPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ EnrollmentSetPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(String str, EnrollmentSetPhoneRequest enrollmentSetPhoneRequest, Continuation<? super t> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = enrollmentSetPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new t(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentSetPhoneResponse>> continuation) {
            return ((t) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                EnrollmentSetPhoneRequest enrollmentSetPhoneRequest = this.d;
                this.a = 1;
                obj = enrollmentApi.setPhone(str, str2, enrollmentSetPhoneRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl", f = "EnrollmentRepositoryImpl.kt", l = {71}, m = "suggestAccount-gIAlu-s")
    public static final class u extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public u(Continuation<? super u> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3258suggestAccountgIAlus = EnrollmentRepositoryImpl.this.mo3258suggestAccountgIAlus(null, this);
            return objMo3258suggestAccountgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3258suggestAccountgIAlus : Result.m2627boximpl(objMo3258suggestAccountgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$suggestAccount$2", f = "EnrollmentRepositoryImpl.kt", l = {72}, m = "invokeSuspend")
    public static final class v extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnrollmentSuggestAccountContinueResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(String str, Continuation<? super v> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EnrollmentRepositoryImpl.this.new v(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnrollmentSuggestAccountContinueResponse>> continuation) {
            return EnrollmentRepositoryImpl.this.new v(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnrollmentApi enrollmentApi = EnrollmentRepositoryImpl.this.api;
                String str = (String) EnrollmentRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = enrollmentApi.suggestAccountContinue(str, str2, this);
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

    public EnrollmentRepositoryImpl(EnrollmentApi api, Function0<String> getToken) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(getToken, "getToken");
        this.api = api;
        this.getToken = getToken;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: acceptTerms-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3248acceptTermsgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcceptTermsResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$a
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$b r6 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$b
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3248acceptTermsgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: acquireAuthorization-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3249acquireAuthorizationgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$d r6 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$d
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3249acquireAuthorizationgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: confirmEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3250confirmEmail0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$e
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$f r7 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$f
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3250confirmEmail0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: confirmEmailResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3251confirmEmailResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.g
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$g r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$g r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$g
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$h r6 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$h
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3251confirmEmailResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: confirmPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3252confirmPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.i
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$i r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$i r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$i
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$j r7 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$j
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3252confirmPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: confirmPhoneResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3253confirmPhoneResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.k
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$k r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$k r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$k
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$l r6 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$l
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3253confirmPhoneResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: enrollment-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3254enrollmentgIAlus(ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentRequest r5, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.m
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$m r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$m r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$m
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$n r6 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$n
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3254enrollmentgIAlus(ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: setEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3255setEmail0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.o
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$o r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$o r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$o
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$p r7 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$p
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3255setEmail0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: setPassword-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3256setPassword0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPasswordRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPasswordResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.q
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$q r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.q) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$q r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$q
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$r r7 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$r
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3256setPassword0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: setPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3257setPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.s
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$s r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.s) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$s r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$s
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$t r7 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$t
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3257setPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository
    /* renamed from: suggestAccount-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3258suggestAccountgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSuggestAccountContinueResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.u
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$u r0 = (ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.u) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$u r0 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$u
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
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$v r6 = new ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl$v
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl.mo3258suggestAccountgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
