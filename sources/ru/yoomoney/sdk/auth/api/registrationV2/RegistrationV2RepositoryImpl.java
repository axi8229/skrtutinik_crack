package ru.yoomoney.sdk.auth.api.registrationV2;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Headers;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.model.ProcessingRequestFailure;
import ru.yoomoney.sdk.auth.api.registrationV2.api.RegistrationV2Api;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationAuthorizationAcquireResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationEmailConfirmResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationEmailSetRequest;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationEmailSetResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationInitResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPasswordSetRequest;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPasswordSetResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPhoneConfirmResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPhoneSetRequest;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPhoneSetResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.DomainExtensionsKt;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.core_api.ApiErrorBodyResponse;
import ru.yoomoney.sdk.core_api.ApiResponse;
import ru.yoomoney.sdk.core_api.ProcessApiResponseBody;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000eJ$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000eJ$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u001cJ4\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2RepositoryImpl;", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "api", "Lru/yoomoney/sdk/auth/api/registrationV2/api/RegistrationV2Api;", "xApplicationUserAgent", "", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/RegistrationV2Api;Ljava/lang/String;Lru/yoomoney/sdk/auth/location/LocationHeaderManager;)V", "acquireAuthorization", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "acquireAuthorization-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "confirmEmail-gIAlu-s", "confirmPhone", "confirmPhone-gIAlu-s", "initRegistration", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationInit;", "request", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration;", "initRegistration-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", Scopes.EMAIL, "setEmail-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", AppMeasurementSdk.ConditionalUserProperty.VALUE, "setPassword-0E7RQCE", "setPhone", "phone", "countryCode", "setPhone-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RegistrationV2RepositoryImpl implements RegistrationV2Repository {
    private final RegistrationV2Api api;
    private final LocationHeaderManager locationHeaderManager;
    private final String xApplicationUserAgent;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl", f = "RegistrationV2RepositoryImpl.kt", l = {167}, m = "acquireAuthorization-gIAlu-s")
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
            Object objMo3294acquireAuthorizationgIAlus = RegistrationV2RepositoryImpl.this.mo3294acquireAuthorizationgIAlus(null, this);
            return objMo3294acquireAuthorizationgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3294acquireAuthorizationgIAlus : Result.m2627boximpl(objMo3294acquireAuthorizationgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$acquireAuthorization$2", f = "RegistrationV2RepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends RegistrationProcess>>, Object> {
        public final /* synthetic */ String b;

        public static final class a extends Lambda implements Function2<RegistrationAuthorizationAcquireResponse, Headers, Result<? extends RegistrationProcess>> {
            public static final a a = new a();

            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Result<? extends RegistrationProcess> invoke(RegistrationAuthorizationAcquireResponse registrationAuthorizationAcquireResponse, Headers headers) {
                RegistrationAuthorizationAcquireResponse response = registrationAuthorizationAcquireResponse;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(DomainExtensionsKt.toDomainRegistrationProcess(response.getProcess())));
            }
        }

        /* renamed from: ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$b$b, reason: collision with other inner class name */
        public static final class C0304b extends Lambda implements Function1<ApiErrorBodyResponse, Result<? extends RegistrationProcess>> {
            public static final C0304b a = new C0304b();

            public C0304b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                ApiErrorBodyResponse it = apiErrorBodyResponse;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(ApiV2ExtentionsKt.toFailure(it))));
            }
        }

        public static final class c extends Lambda implements Function1<ProcessApiResponseBody, Result<? extends RegistrationProcess>> {
            public static final c a = new c();

            public c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ProcessApiResponseBody processApiResponseBody) {
                ProcessApiResponseBody it = processApiResponseBody;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(it.getRetryAfter()))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation<? super b> continuation) {
            super(1, continuation);
            this.b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return RegistrationV2RepositoryImpl.this.new b(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends RegistrationProcess>> continuation) {
            return RegistrationV2RepositoryImpl.this.new b(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return ApiResponse.fold$default(RegistrationV2RepositoryImpl.this.api.registrationRegistrationProcessIdAuthorizationAcquirePost(this.b, RegistrationV2RepositoryImpl.this.xApplicationUserAgent, RegistrationV2RepositoryImpl.this.locationHeaderManager.getLocationHeader()), a.a, C0304b.a, c.a, null, 8, null);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl", f = "RegistrationV2RepositoryImpl.kt", l = {121}, m = "confirmEmail-gIAlu-s")
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
            Object objMo3295confirmEmailgIAlus = RegistrationV2RepositoryImpl.this.mo3295confirmEmailgIAlus(null, this);
            return objMo3295confirmEmailgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3295confirmEmailgIAlus : Result.m2627boximpl(objMo3295confirmEmailgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$confirmEmail$2", f = "RegistrationV2RepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends RegistrationProcess>>, Object> {
        public final /* synthetic */ String b;

        public static final class a extends Lambda implements Function2<RegistrationEmailConfirmResponse, Headers, Result<? extends RegistrationProcess>> {
            public static final a a = new a();

            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Result<? extends RegistrationProcess> invoke(RegistrationEmailConfirmResponse registrationEmailConfirmResponse, Headers headers) {
                RegistrationEmailConfirmResponse response = registrationEmailConfirmResponse;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(DomainExtensionsKt.toDomainRegistrationProcess(response.getProcess())));
            }
        }

        public static final class b extends Lambda implements Function1<ApiErrorBodyResponse, Result<? extends RegistrationProcess>> {
            public static final b a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                ApiErrorBodyResponse it = apiErrorBodyResponse;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(ApiV2ExtentionsKt.toFailure(it))));
            }
        }

        public static final class c extends Lambda implements Function1<ProcessApiResponseBody, Result<? extends RegistrationProcess>> {
            public static final c a = new c();

            public c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ProcessApiResponseBody processApiResponseBody) {
                ProcessApiResponseBody it = processApiResponseBody;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(it.getRetryAfter()))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Continuation<? super d> continuation) {
            super(1, continuation);
            this.b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return RegistrationV2RepositoryImpl.this.new d(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends RegistrationProcess>> continuation) {
            return RegistrationV2RepositoryImpl.this.new d(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return ApiResponse.fold$default(RegistrationV2RepositoryImpl.this.api.registrationRegistrationProcessIdEmailConfirmPost(this.b, RegistrationV2RepositoryImpl.this.xApplicationUserAgent), a.a, b.a, c.a, null, 8, null);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl", f = "RegistrationV2RepositoryImpl.kt", l = {75}, m = "confirmPhone-gIAlu-s")
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
            Object objMo3296confirmPhonegIAlus = RegistrationV2RepositoryImpl.this.mo3296confirmPhonegIAlus(null, this);
            return objMo3296confirmPhonegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3296confirmPhonegIAlus : Result.m2627boximpl(objMo3296confirmPhonegIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$confirmPhone$2", f = "RegistrationV2RepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends RegistrationProcess>>, Object> {
        public final /* synthetic */ String b;

        public static final class a extends Lambda implements Function2<RegistrationPhoneConfirmResponse, Headers, Result<? extends RegistrationProcess>> {
            public static final a a = new a();

            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Result<? extends RegistrationProcess> invoke(RegistrationPhoneConfirmResponse registrationPhoneConfirmResponse, Headers headers) {
                RegistrationPhoneConfirmResponse response = registrationPhoneConfirmResponse;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(DomainExtensionsKt.toDomainRegistrationProcess(response.getProcess())));
            }
        }

        public static final class b extends Lambda implements Function1<ApiErrorBodyResponse, Result<? extends RegistrationProcess>> {
            public static final b a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                ApiErrorBodyResponse it = apiErrorBodyResponse;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(ApiV2ExtentionsKt.toFailure(it))));
            }
        }

        public static final class c extends Lambda implements Function1<ProcessApiResponseBody, Result<? extends RegistrationProcess>> {
            public static final c a = new c();

            public c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ProcessApiResponseBody processApiResponseBody) {
                ProcessApiResponseBody it = processApiResponseBody;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(it.getRetryAfter()))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(1, continuation);
            this.b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return RegistrationV2RepositoryImpl.this.new f(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends RegistrationProcess>> continuation) {
            return RegistrationV2RepositoryImpl.this.new f(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return ApiResponse.fold$default(RegistrationV2RepositoryImpl.this.api.registrationRegistrationProcessIdPhoneConfirmPost(this.b, RegistrationV2RepositoryImpl.this.xApplicationUserAgent), a.a, b.a, c.a, null, 8, null);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl", f = "RegistrationV2RepositoryImpl.kt", l = {27}, m = "initRegistration-gIAlu-s")
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
            Object objMo3297initRegistrationgIAlus = RegistrationV2RepositoryImpl.this.mo3297initRegistrationgIAlus(null, this);
            return objMo3297initRegistrationgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3297initRegistrationgIAlus : Result.m2627boximpl(objMo3297initRegistrationgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$initRegistration$2", f = "RegistrationV2RepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Result<? extends RegistrationInit>>, Object> {
        public final /* synthetic */ Registration b;

        public static final class a extends Lambda implements Function2<RegistrationInitResponse, Headers, Result<? extends RegistrationInit>> {
            public static final a a = new a();

            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Result<? extends RegistrationInit> invoke(RegistrationInitResponse registrationInitResponse, Headers headers) {
                RegistrationInitResponse response = registrationInitResponse;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(DomainExtensionsKt.toDomainRegistrationInit(response)));
            }
        }

        public static final class b extends Lambda implements Function1<ApiErrorBodyResponse, Result<? extends RegistrationInit>> {
            public static final b a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationInit> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                ApiErrorBodyResponse it = apiErrorBodyResponse;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(ApiV2ExtentionsKt.toFailure(it))));
            }
        }

        public static final class c extends Lambda implements Function1<ProcessApiResponseBody, Result<? extends RegistrationInit>> {
            public static final c a = new c();

            public c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationInit> invoke(ProcessApiResponseBody processApiResponseBody) {
                ProcessApiResponseBody it = processApiResponseBody;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(it.getRetryAfter()))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Registration registration, Continuation<? super h> continuation) {
            super(1, continuation);
            this.b = registration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return RegistrationV2RepositoryImpl.this.new h(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends RegistrationInit>> continuation) {
            return RegistrationV2RepositoryImpl.this.new h(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return ApiResponse.fold$default(RegistrationV2RepositoryImpl.this.api.registrationPost(DomainExtensionsKt.toApiRegistrationRequest(this.b), RegistrationV2RepositoryImpl.this.xApplicationUserAgent), a.a, b.a, c.a, null, 8, null);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl", f = "RegistrationV2RepositoryImpl.kt", l = {97}, m = "setEmail-0E7RQCE")
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
            Object objMo3298setEmail0E7RQCE = RegistrationV2RepositoryImpl.this.mo3298setEmail0E7RQCE(null, null, this);
            return objMo3298setEmail0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3298setEmail0E7RQCE : Result.m2627boximpl(objMo3298setEmail0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$setEmail$2", f = "RegistrationV2RepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements Function1<Continuation<? super Result<? extends RegistrationProcess>>, Object> {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public static final class a extends Lambda implements Function2<RegistrationEmailSetResponse, Headers, Result<? extends RegistrationProcess>> {
            public static final a a = new a();

            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Result<? extends RegistrationProcess> invoke(RegistrationEmailSetResponse registrationEmailSetResponse, Headers headers) {
                RegistrationEmailSetResponse response = registrationEmailSetResponse;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(DomainExtensionsKt.toDomainRegistrationProcess(response.getProcess())));
            }
        }

        public static final class b extends Lambda implements Function1<ApiErrorBodyResponse, Result<? extends RegistrationProcess>> {
            public static final b a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                ApiErrorBodyResponse it = apiErrorBodyResponse;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(ApiV2ExtentionsKt.toFailure(it))));
            }
        }

        public static final class c extends Lambda implements Function1<ProcessApiResponseBody, Result<? extends RegistrationProcess>> {
            public static final c a = new c();

            public c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ProcessApiResponseBody processApiResponseBody) {
                ProcessApiResponseBody it = processApiResponseBody;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(it.getRetryAfter()))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, String str2, Continuation<? super j> continuation) {
            super(1, continuation);
            this.b = str;
            this.c = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return RegistrationV2RepositoryImpl.this.new j(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends RegistrationProcess>> continuation) {
            return ((j) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            RegistrationV2Api registrationV2Api = RegistrationV2RepositoryImpl.this.api;
            RegistrationEmailSetRequest registrationEmailSetRequest = new RegistrationEmailSetRequest(this.b);
            return ApiResponse.fold$default(registrationV2Api.registrationRegistrationProcessIdEmailSetPost(this.c, RegistrationV2RepositoryImpl.this.xApplicationUserAgent, registrationEmailSetRequest), a.a, b.a, c.a, null, 8, null);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl", f = "RegistrationV2RepositoryImpl.kt", l = {143}, m = "setPassword-0E7RQCE")
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
            Object objMo3299setPassword0E7RQCE = RegistrationV2RepositoryImpl.this.mo3299setPassword0E7RQCE(null, null, this);
            return objMo3299setPassword0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3299setPassword0E7RQCE : Result.m2627boximpl(objMo3299setPassword0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$setPassword$2", f = "RegistrationV2RepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements Function1<Continuation<? super Result<? extends RegistrationProcess>>, Object> {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public static final class a extends Lambda implements Function2<RegistrationPasswordSetResponse, Headers, Result<? extends RegistrationProcess>> {
            public static final a a = new a();

            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Result<? extends RegistrationProcess> invoke(RegistrationPasswordSetResponse registrationPasswordSetResponse, Headers headers) {
                RegistrationPasswordSetResponse response = registrationPasswordSetResponse;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(DomainExtensionsKt.toDomainRegistrationProcess(response.getProcess())));
            }
        }

        public static final class b extends Lambda implements Function1<ApiErrorBodyResponse, Result<? extends RegistrationProcess>> {
            public static final b a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                ApiErrorBodyResponse it = apiErrorBodyResponse;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(ApiV2ExtentionsKt.toFailure(it))));
            }
        }

        public static final class c extends Lambda implements Function1<ProcessApiResponseBody, Result<? extends RegistrationProcess>> {
            public static final c a = new c();

            public c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ProcessApiResponseBody processApiResponseBody) {
                ProcessApiResponseBody it = processApiResponseBody;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(it.getRetryAfter()))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, String str2, Continuation<? super l> continuation) {
            super(1, continuation);
            this.b = str;
            this.c = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return RegistrationV2RepositoryImpl.this.new l(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends RegistrationProcess>> continuation) {
            return ((l) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return ApiResponse.fold$default(RegistrationV2RepositoryImpl.this.api.registrationRegistrationProcessIdPasswordSetPost(this.b, new RegistrationPasswordSetRequest(this.c), RegistrationV2RepositoryImpl.this.xApplicationUserAgent), a.a, b.a, c.a, null, 8, null);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl", f = "RegistrationV2RepositoryImpl.kt", l = {50}, m = "setPhone-BWLJW6A")
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
            Object objMo3300setPhoneBWLJW6A = RegistrationV2RepositoryImpl.this.mo3300setPhoneBWLJW6A(null, null, null, this);
            return objMo3300setPhoneBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3300setPhoneBWLJW6A : Result.m2627boximpl(objMo3300setPhoneBWLJW6A);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$setPhone$2", f = "RegistrationV2RepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements Function1<Continuation<? super Result<? extends RegistrationProcess>>, Object> {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public static final class a extends Lambda implements Function2<RegistrationPhoneSetResponse, Headers, Result<? extends RegistrationProcess>> {
            public static final a a = new a();

            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Result<? extends RegistrationProcess> invoke(RegistrationPhoneSetResponse registrationPhoneSetResponse, Headers headers) {
                RegistrationPhoneSetResponse response = registrationPhoneSetResponse;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(DomainExtensionsKt.toDomainRegistrationProcess(response.getProcess())));
            }
        }

        public static final class b extends Lambda implements Function1<ApiErrorBodyResponse, Result<? extends RegistrationProcess>> {
            public static final b a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                ApiErrorBodyResponse it = apiErrorBodyResponse;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(ApiV2ExtentionsKt.toFailure(it))));
            }
        }

        public static final class c extends Lambda implements Function1<ProcessApiResponseBody, Result<? extends RegistrationProcess>> {
            public static final c a = new c();

            public c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<? extends RegistrationProcess> invoke(ProcessApiResponseBody processApiResponseBody) {
                ProcessApiResponseBody it = processApiResponseBody;
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2627boximpl(Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(it.getRetryAfter()))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(String str, String str2, String str3, Continuation<? super n> continuation) {
            super(1, continuation);
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return RegistrationV2RepositoryImpl.this.new n(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends RegistrationProcess>> continuation) {
            return ((n) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return ApiResponse.fold$default(RegistrationV2RepositoryImpl.this.api.registrationRegistrationProcessIdPhoneSetPost(this.b, new RegistrationPhoneSetRequest(this.c, this.d), RegistrationV2RepositoryImpl.this.xApplicationUserAgent), a.a, b.a, c.a, null, 8, null);
        }
    }

    public RegistrationV2RepositoryImpl(RegistrationV2Api api, String xApplicationUserAgent, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(xApplicationUserAgent, "xApplicationUserAgent");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        this.api = api;
        this.xApplicationUserAgent = xApplicationUserAgent;
        this.locationHeaderManager = locationHeaderManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository
    /* renamed from: acquireAuthorization-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3294acquireAuthorizationgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$a
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
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$b r6 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$b
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.mo3294acquireAuthorizationgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository
    /* renamed from: confirmEmail-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3295confirmEmailgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$d r6 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$d
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.mo3295confirmEmailgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository
    /* renamed from: confirmPhone-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3296confirmPhonegIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$e
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
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$f r6 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$f
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.mo3296confirmPhonegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository
    /* renamed from: initRegistration-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3297initRegistrationgIAlus(ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration r5, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.g
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$g r0 = (ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$g r0 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$g
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
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$h r6 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$h
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.mo3297initRegistrationgIAlus(ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository
    /* renamed from: setEmail-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3298setEmail0E7RQCE(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.i
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$i r0 = (ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$i r0 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$i
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
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$j r7 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$j
            r2 = 0
            r7.<init>(r6, r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.mo3298setEmail0E7RQCE(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository
    /* renamed from: setPassword-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3299setPassword0E7RQCE(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.k
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$k r0 = (ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$k r0 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$k
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
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$l r7 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$l
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.mo3299setPassword0E7RQCE(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository
    /* renamed from: setPhone-BWLJW6A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3300setPhoneBWLJW6A(java.lang.String r11, java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.m
            if (r0 == 0) goto L13
            r0 = r14
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$m r0 = (ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$m r0 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$m
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r11 = r14.getValue()
            goto L4e
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            kotlin.ResultKt.throwOnFailure(r14)
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$n r14 = new ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl$n
            r9 = 0
            r4 = r14
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r11 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r14, r0)
            if (r11 != r1) goto L4e
            return r1
        L4e:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl.mo3300setPhoneBWLJW6A(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
