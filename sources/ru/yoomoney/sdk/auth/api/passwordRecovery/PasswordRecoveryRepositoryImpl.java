package ru.yoomoney.sdk.auth.api.passwordRecovery;

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
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordResponse;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0014H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u001dH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ$\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u001aJ,\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020%H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J$\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u000b2\u0006\u0010\u000e\u001a\u00020*H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,J,\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020/H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "api", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryApi;", "getToken", "Lkotlin/Function0;", "", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "(Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryApi;Lkotlin/jvm/functions/Function0;Lru/yoomoney/sdk/auth/location/LocationHeaderManager;)V", "chooseAccount", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryChooseAccountResponse;", "passwordRecoveryProcessId", "request", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryChooseAccountRequest;", "chooseAccount-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryChooseAccountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhone", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "enterPhone", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneRequest;", "enterPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passwordRecovery", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryRequest;", "passwordRecovery-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordRequest;", "setPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordRecoveryRepositoryImpl implements PasswordRecoveryRepository {
    private final PasswordRecoveryApi api;
    private final Function0<String> getToken;
    private final LocationHeaderManager locationHeaderManager;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl", f = "PasswordRecoveryRepositoryImpl.kt", l = {81}, m = "chooseAccount-0E7RQCE")
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
            Object objMo3286chooseAccount0E7RQCE = PasswordRecoveryRepositoryImpl.this.mo3286chooseAccount0E7RQCE(null, null, this);
            return objMo3286chooseAccount0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3286chooseAccount0E7RQCE : Result.m2627boximpl(objMo3286chooseAccount0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$chooseAccount$2", f = "PasswordRecoveryRepositoryImpl.kt", l = {82}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordRecoveryChooseAccountResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PasswordRecoveryChooseAccountRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, PasswordRecoveryChooseAccountRequest passwordRecoveryChooseAccountRequest, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = passwordRecoveryChooseAccountRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordRecoveryChooseAccountResponse>> continuation) {
            return ((b) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordRecoveryApi passwordRecoveryApi = PasswordRecoveryRepositoryImpl.this.api;
                String str = (String) PasswordRecoveryRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                PasswordRecoveryChooseAccountRequest passwordRecoveryChooseAccountRequest = this.d;
                this.a = 1;
                obj = passwordRecoveryApi.chooseAccount(str, str2, passwordRecoveryChooseAccountRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl", f = "PasswordRecoveryRepositoryImpl.kt", l = {68}, m = "confirmEmail-0E7RQCE")
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
            Object objMo3287confirmEmail0E7RQCE = PasswordRecoveryRepositoryImpl.this.mo3287confirmEmail0E7RQCE(null, null, this);
            return objMo3287confirmEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3287confirmEmail0E7RQCE : Result.m2627boximpl(objMo3287confirmEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$confirmEmail$2", f = "PasswordRecoveryRepositoryImpl.kt", l = {69}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordRecoveryConfirmEmailResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PasswordRecoveryConfirmEmailRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, PasswordRecoveryConfirmEmailRequest passwordRecoveryConfirmEmailRequest, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = passwordRecoveryConfirmEmailRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new d(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordRecoveryConfirmEmailResponse>> continuation) {
            return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordRecoveryApi passwordRecoveryApi = PasswordRecoveryRepositoryImpl.this.api;
                String str = (String) PasswordRecoveryRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                PasswordRecoveryConfirmEmailRequest passwordRecoveryConfirmEmailRequest = this.d;
                this.a = 1;
                obj = passwordRecoveryApi.confirmEmail(str, str2, passwordRecoveryConfirmEmailRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl", f = "PasswordRecoveryRepositoryImpl.kt", l = {74}, m = "confirmEmailResend-gIAlu-s")
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
            Object objMo3288confirmEmailResendgIAlus = PasswordRecoveryRepositoryImpl.this.mo3288confirmEmailResendgIAlus(null, this);
            return objMo3288confirmEmailResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3288confirmEmailResendgIAlus : Result.m2627boximpl(objMo3288confirmEmailResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$confirmEmailResend$2", f = "PasswordRecoveryRepositoryImpl.kt", l = {75}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordRecoveryConfirmEmailResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new f(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordRecoveryConfirmEmailResendResponse>> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new f(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordRecoveryApi passwordRecoveryApi = PasswordRecoveryRepositoryImpl.this.api;
                String str = (String) PasswordRecoveryRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = passwordRecoveryApi.confirmEmailResend(str, str2, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl", f = "PasswordRecoveryRepositoryImpl.kt", l = {43}, m = "confirmPhone-0E7RQCE")
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
            Object objMo3289confirmPhone0E7RQCE = PasswordRecoveryRepositoryImpl.this.mo3289confirmPhone0E7RQCE(null, null, this);
            return objMo3289confirmPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3289confirmPhone0E7RQCE : Result.m2627boximpl(objMo3289confirmPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$confirmPhone$2", f = "PasswordRecoveryRepositoryImpl.kt", l = {44}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordRecoveryConfirmPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PasswordRecoveryConfirmPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, PasswordRecoveryConfirmPhoneRequest passwordRecoveryConfirmPhoneRequest, Continuation<? super h> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = passwordRecoveryConfirmPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new h(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordRecoveryConfirmPhoneResponse>> continuation) {
            return ((h) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordRecoveryApi passwordRecoveryApi = PasswordRecoveryRepositoryImpl.this.api;
                String str = (String) PasswordRecoveryRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                PasswordRecoveryConfirmPhoneRequest passwordRecoveryConfirmPhoneRequest = this.d;
                this.a = 1;
                obj = passwordRecoveryApi.confirmPhone(str, str2, passwordRecoveryConfirmPhoneRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl", f = "PasswordRecoveryRepositoryImpl.kt", l = {49}, m = "confirmPhoneResend-gIAlu-s")
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
            Object objMo3290confirmPhoneResendgIAlus = PasswordRecoveryRepositoryImpl.this.mo3290confirmPhoneResendgIAlus(null, this);
            return objMo3290confirmPhoneResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3290confirmPhoneResendgIAlus : Result.m2627boximpl(objMo3290confirmPhoneResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$confirmPhoneResend$2", f = "PasswordRecoveryRepositoryImpl.kt", l = {50}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordRecoveryConfirmPhoneResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, Continuation<? super j> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new j(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordRecoveryConfirmPhoneResendResponse>> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new j(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordRecoveryApi passwordRecoveryApi = PasswordRecoveryRepositoryImpl.this.api;
                String str = (String) PasswordRecoveryRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = passwordRecoveryApi.confirmPhoneResend(str, str2, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl", f = "PasswordRecoveryRepositoryImpl.kt", l = {36}, m = "enterPhone-0E7RQCE")
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
            Object objMo3291enterPhone0E7RQCE = PasswordRecoveryRepositoryImpl.this.mo3291enterPhone0E7RQCE(null, null, this);
            return objMo3291enterPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3291enterPhone0E7RQCE : Result.m2627boximpl(objMo3291enterPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$enterPhone$2", f = "PasswordRecoveryRepositoryImpl.kt", l = {37}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordRecoveryEnterPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PasswordRecoveryEnterPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, PasswordRecoveryEnterPhoneRequest passwordRecoveryEnterPhoneRequest, Continuation<? super l> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = passwordRecoveryEnterPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new l(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordRecoveryEnterPhoneResponse>> continuation) {
            return ((l) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordRecoveryApi passwordRecoveryApi = PasswordRecoveryRepositoryImpl.this.api;
                String str = (String) PasswordRecoveryRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                PasswordRecoveryEnterPhoneRequest passwordRecoveryEnterPhoneRequest = this.d;
                this.a = 1;
                obj = passwordRecoveryApi.enterPhone(str, str2, passwordRecoveryEnterPhoneRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl", f = "PasswordRecoveryRepositoryImpl.kt", l = {29}, m = "passwordRecovery-gIAlu-s")
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
            Object objMo3292passwordRecoverygIAlus = PasswordRecoveryRepositoryImpl.this.mo3292passwordRecoverygIAlus(null, this);
            return objMo3292passwordRecoverygIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3292passwordRecoverygIAlus : Result.m2627boximpl(objMo3292passwordRecoverygIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$passwordRecovery$2", f = "PasswordRecoveryRepositoryImpl.kt", l = {30}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordRecoveryResponse>>, Object> {
        public int a;
        public final /* synthetic */ PasswordRecoveryRequest c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(PasswordRecoveryRequest passwordRecoveryRequest, Continuation<? super n> continuation) {
            super(1, continuation);
            this.c = passwordRecoveryRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new n(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordRecoveryResponse>> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new n(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordRecoveryApi passwordRecoveryApi = PasswordRecoveryRepositoryImpl.this.api;
                String str = (String) PasswordRecoveryRepositoryImpl.this.getToken.invoke();
                PasswordRecoveryRequest passwordRecoveryRequest = this.c;
                this.a = 1;
                obj = passwordRecoveryApi.passwordRecovery(str, passwordRecoveryRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl", f = "PasswordRecoveryRepositoryImpl.kt", l = {56}, m = "setPassword-0E7RQCE")
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
            Object objMo3293setPassword0E7RQCE = PasswordRecoveryRepositoryImpl.this.mo3293setPassword0E7RQCE(null, null, this);
            return objMo3293setPassword0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3293setPassword0E7RQCE : Result.m2627boximpl(objMo3293setPassword0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$setPassword$2", f = "PasswordRecoveryRepositoryImpl.kt", l = {57}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements Function1<Continuation<? super Result<? extends PasswordRecoverySetPasswordResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PasswordRecoverySetPasswordRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(String str, PasswordRecoverySetPasswordRequest passwordRecoverySetPasswordRequest, Continuation<? super p> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = passwordRecoverySetPasswordRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PasswordRecoveryRepositoryImpl.this.new p(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PasswordRecoverySetPasswordResponse>> continuation) {
            return ((p) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PasswordRecoveryApi passwordRecoveryApi = PasswordRecoveryRepositoryImpl.this.api;
                String str = (String) PasswordRecoveryRepositoryImpl.this.getToken.invoke();
                String locationHeader = PasswordRecoveryRepositoryImpl.this.locationHeaderManager.getLocationHeader();
                String str2 = this.c;
                PasswordRecoverySetPasswordRequest passwordRecoverySetPasswordRequest = this.d;
                this.a = 1;
                obj = passwordRecoveryApi.setPassword(str, locationHeader, str2, passwordRecoverySetPasswordRequest, this);
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

    public PasswordRecoveryRepositoryImpl(PasswordRecoveryApi api, Function0<String> getToken, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(getToken, "getToken");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        this.api = api;
        this.getToken = getToken;
        this.locationHeaderManager = locationHeaderManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository
    /* renamed from: chooseAccount-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3286chooseAccount0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$a
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
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$b r7 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$b
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.mo3286chooseAccount0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository
    /* renamed from: confirmEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3287confirmEmail0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$d r7 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$d
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.mo3287confirmEmail0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository
    /* renamed from: confirmEmailResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3288confirmEmailResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$e
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
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$f r6 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$f
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.mo3288confirmEmailResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository
    /* renamed from: confirmPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3289confirmPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.g
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$g r0 = (ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$g r0 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$g
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
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$h r7 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$h
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.mo3289confirmPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository
    /* renamed from: confirmPhoneResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3290confirmPhoneResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.i
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$i r0 = (ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$i r0 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$i
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
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$j r6 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$j
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.mo3290confirmPhoneResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository
    /* renamed from: enterPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3291enterPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.k
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$k r0 = (ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$k r0 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$k
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
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$l r7 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$l
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.mo3291enterPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository
    /* renamed from: passwordRecovery-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3292passwordRecoverygIAlus(ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryRequest r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.m
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$m r0 = (ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$m r0 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$m
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
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$n r6 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$n
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.mo3292passwordRecoverygIAlus(ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository
    /* renamed from: setPassword-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3293setPassword0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.o
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$o r0 = (ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$o r0 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$o
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
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$p r7 = new ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl$p
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl.mo3293setPassword0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
