package ru.yoomoney.sdk.auth.api.migration;

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
import ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPasswordRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPasswordResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenResponse;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u001bH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u000fJ$\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000b2\u0006\u0010\u0012\u001a\u00020#H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J,\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020(H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J,\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020-H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J,\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u000202H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104J,\u00105\u001a\b\u0012\u0004\u0012\u0002060\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u000207H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/MigrationRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "api", "Lru/yoomoney/sdk/auth/api/migration/MigrationApi;", "getToken", "Lkotlin/Function0;", "", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "(Lru/yoomoney/sdk/auth/api/migration/MigrationApi;Lkotlin/jvm/functions/Function0;Lru/yoomoney/sdk/auth/location/LocationHeaderManager;)V", "acquireAuthorization", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationAcquireAuthorizationResponse;", "migrationProcessId", "acquireAuthorization-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailResponse;", "request", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "migration", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationRequest;", "migration-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/migration/method/MigrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailRequest;", "setEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPasswordRequest;", "setPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneRequest;", "setPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setYandexToken", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenRequest;", "setYandexToken-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MigrationRepositoryImpl implements MigrationRepository {
    private final MigrationApi api;
    private final Function0<String> getToken;
    private final LocationHeaderManager locationHeaderManager;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {92}, m = "acquireAuthorization-gIAlu-s")
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
            Object objMo3271acquireAuthorizationgIAlus = MigrationRepositoryImpl.this.mo3271acquireAuthorizationgIAlus(null, this);
            return objMo3271acquireAuthorizationgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3271acquireAuthorizationgIAlus : Result.m2627boximpl(objMo3271acquireAuthorizationgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$acquireAuthorization$2", f = "MigrationRepositoryImpl.kt", l = {93}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationAcquireAuthorizationResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationAcquireAuthorizationResponse>> continuation) {
            return MigrationRepositoryImpl.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                String locationHeader = MigrationRepositoryImpl.this.locationHeaderManager.getLocationHeader();
                String str2 = this.c;
                this.a = 1;
                obj = migrationApi.acquireAuthorization(str, locationHeader, str2, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {80}, m = "confirmEmail-0E7RQCE")
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
            Object objMo3272confirmEmail0E7RQCE = MigrationRepositoryImpl.this.mo3272confirmEmail0E7RQCE(null, null, this);
            return objMo3272confirmEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3272confirmEmail0E7RQCE : Result.m2627boximpl(objMo3272confirmEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$confirmEmail$2", f = "MigrationRepositoryImpl.kt", l = {81}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationConfirmEmailResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ MigrationConfirmEmailRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, MigrationConfirmEmailRequest migrationConfirmEmailRequest, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = migrationConfirmEmailRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new d(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationConfirmEmailResponse>> continuation) {
            return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                MigrationConfirmEmailRequest migrationConfirmEmailRequest = this.d;
                this.a = 1;
                obj = migrationApi.confirmEmail(str, str2, migrationConfirmEmailRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {86}, m = "confirmEmailResend-gIAlu-s")
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
            Object objMo3273confirmEmailResendgIAlus = MigrationRepositoryImpl.this.mo3273confirmEmailResendgIAlus(null, this);
            return objMo3273confirmEmailResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3273confirmEmailResendgIAlus : Result.m2627boximpl(objMo3273confirmEmailResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$confirmEmailResend$2", f = "MigrationRepositoryImpl.kt", l = {87}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationConfirmEmailResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new f(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationConfirmEmailResendResponse>> continuation) {
            return MigrationRepositoryImpl.this.new f(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = migrationApi.confirmEmailResend(str, str2, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {53}, m = "confirmPhone-0E7RQCE")
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
            Object objMo3274confirmPhone0E7RQCE = MigrationRepositoryImpl.this.mo3274confirmPhone0E7RQCE(null, null, this);
            return objMo3274confirmPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3274confirmPhone0E7RQCE : Result.m2627boximpl(objMo3274confirmPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$confirmPhone$2", f = "MigrationRepositoryImpl.kt", l = {54}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationConfirmPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ MigrationConfirmPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, MigrationConfirmPhoneRequest migrationConfirmPhoneRequest, Continuation<? super h> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = migrationConfirmPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new h(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationConfirmPhoneResponse>> continuation) {
            return ((h) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                MigrationConfirmPhoneRequest migrationConfirmPhoneRequest = this.d;
                this.a = 1;
                obj = migrationApi.confirmPhone(str, str2, migrationConfirmPhoneRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {59}, m = "confirmPhoneResend-gIAlu-s")
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
            Object objMo3275confirmPhoneResendgIAlus = MigrationRepositoryImpl.this.mo3275confirmPhoneResendgIAlus(null, this);
            return objMo3275confirmPhoneResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3275confirmPhoneResendgIAlus : Result.m2627boximpl(objMo3275confirmPhoneResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$confirmPhoneResend$2", f = "MigrationRepositoryImpl.kt", l = {60}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationConfirmPhoneResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, Continuation<? super j> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new j(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationConfirmPhoneResendResponse>> continuation) {
            return MigrationRepositoryImpl.this.new j(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                this.a = 1;
                obj = migrationApi.confirmPhoneResend(str, str2, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {32}, m = "migration-gIAlu-s")
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
            Object objMo3276migrationgIAlus = MigrationRepositoryImpl.this.mo3276migrationgIAlus(null, this);
            return objMo3276migrationgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3276migrationgIAlus : Result.m2627boximpl(objMo3276migrationgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$migration$2", f = "MigrationRepositoryImpl.kt", l = {33}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationResponse>>, Object> {
        public int a;
        public final /* synthetic */ MigrationRequest c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(MigrationRequest migrationRequest, Continuation<? super l> continuation) {
            super(1, continuation);
            this.c = migrationRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new l(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationResponse>> continuation) {
            return MigrationRepositoryImpl.this.new l(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                MigrationRequest migrationRequest = this.c;
                this.a = 1;
                obj = migrationApi.migration(str, migrationRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {73}, m = "setEmail-0E7RQCE")
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
            Object objMo3277setEmail0E7RQCE = MigrationRepositoryImpl.this.mo3277setEmail0E7RQCE(null, null, this);
            return objMo3277setEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3277setEmail0E7RQCE : Result.m2627boximpl(objMo3277setEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$setEmail$2", f = "MigrationRepositoryImpl.kt", l = {74}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationSetEmailResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ MigrationSetEmailRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(String str, MigrationSetEmailRequest migrationSetEmailRequest, Continuation<? super n> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = migrationSetEmailRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new n(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationSetEmailResponse>> continuation) {
            return ((n) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                MigrationSetEmailRequest migrationSetEmailRequest = this.d;
                this.a = 1;
                obj = migrationApi.setEmail(str, str2, migrationSetEmailRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {66}, m = "setPassword-0E7RQCE")
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
            Object objMo3278setPassword0E7RQCE = MigrationRepositoryImpl.this.mo3278setPassword0E7RQCE(null, null, this);
            return objMo3278setPassword0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3278setPassword0E7RQCE : Result.m2627boximpl(objMo3278setPassword0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$setPassword$2", f = "MigrationRepositoryImpl.kt", l = {67}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationSetPasswordResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ MigrationSetPasswordRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(String str, MigrationSetPasswordRequest migrationSetPasswordRequest, Continuation<? super p> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = migrationSetPasswordRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new p(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationSetPasswordResponse>> continuation) {
            return ((p) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                MigrationSetPasswordRequest migrationSetPasswordRequest = this.d;
                this.a = 1;
                obj = migrationApi.setPassword(str, str2, migrationSetPasswordRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {46}, m = "setPhone-0E7RQCE")
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
            Object objMo3279setPhone0E7RQCE = MigrationRepositoryImpl.this.mo3279setPhone0E7RQCE(null, null, this);
            return objMo3279setPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3279setPhone0E7RQCE : Result.m2627boximpl(objMo3279setPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$setPhone$2", f = "MigrationRepositoryImpl.kt", l = {47}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationSetPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ MigrationSetPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(String str, MigrationSetPhoneRequest migrationSetPhoneRequest, Continuation<? super r> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = migrationSetPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new r(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationSetPhoneResponse>> continuation) {
            return ((r) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                MigrationSetPhoneRequest migrationSetPhoneRequest = this.d;
                this.a = 1;
                obj = migrationApi.setPhone(str, str2, migrationSetPhoneRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl", f = "MigrationRepositoryImpl.kt", l = {39}, m = "setYandexToken-0E7RQCE")
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
            Object objMo3280setYandexToken0E7RQCE = MigrationRepositoryImpl.this.mo3280setYandexToken0E7RQCE(null, null, this);
            return objMo3280setYandexToken0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3280setYandexToken0E7RQCE : Result.m2627boximpl(objMo3280setYandexToken0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$setYandexToken$2", f = "MigrationRepositoryImpl.kt", l = {40}, m = "invokeSuspend")
    public static final class t extends SuspendLambda implements Function1<Continuation<? super Result<? extends MigrationSetYandexTokenResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ MigrationSetYandexTokenRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(String str, MigrationSetYandexTokenRequest migrationSetYandexTokenRequest, Continuation<? super t> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = migrationSetYandexTokenRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return MigrationRepositoryImpl.this.new t(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends MigrationSetYandexTokenResponse>> continuation) {
            return ((t) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MigrationApi migrationApi = MigrationRepositoryImpl.this.api;
                String str = (String) MigrationRepositoryImpl.this.getToken.invoke();
                String str2 = this.c;
                MigrationSetYandexTokenRequest migrationSetYandexTokenRequest = this.d;
                this.a = 1;
                obj = migrationApi.setYandexToken(str, str2, migrationSetYandexTokenRequest, this);
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

    public MigrationRepositoryImpl(MigrationApi api, Function0<String> getToken, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(getToken, "getToken");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        this.api = api;
        this.getToken = getToken;
        this.locationHeaderManager = locationHeaderManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: acquireAuthorization-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3271acquireAuthorizationgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$a
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$b r6 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$b
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3271acquireAuthorizationgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: confirmEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3272confirmEmail0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$d r7 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$d
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3272confirmEmail0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: confirmEmailResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3273confirmEmailResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$e
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$f r6 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$f
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3273confirmEmailResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: confirmPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3274confirmPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.g
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$g r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$g r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$g
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$h r7 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$h
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3274confirmPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: confirmPhoneResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3275confirmPhoneResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.i
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$i r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$i r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$i
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$j r6 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$j
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3275confirmPhoneResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: migration-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3276migrationgIAlus(ru.yoomoney.sdk.auth.api.migration.method.MigrationRequest r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.k
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$k r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$k r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$k
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$l r6 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$l
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3276migrationgIAlus(ru.yoomoney.sdk.auth.api.migration.method.MigrationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: setEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3277setEmail0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.m
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$m r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$m r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$m
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$n r7 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$n
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3277setEmail0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: setPassword-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3278setPassword0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPasswordRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPasswordResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.o
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$o r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$o r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$o
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$p r7 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$p
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3278setPassword0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: setPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3279setPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.q
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$q r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.q) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$q r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$q
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$r r7 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$r
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3279setPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.MigrationRepository
    /* renamed from: setYandexToken-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3280setYandexToken0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.s
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$s r0 = (ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.s) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$s r0 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$s
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
            ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$t r7 = new ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl$t
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl.mo3280setYandexToken0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
