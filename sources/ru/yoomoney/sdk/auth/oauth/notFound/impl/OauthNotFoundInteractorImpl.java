package ru.yoomoney.sdk.auth.oauth.notFound.impl;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/oauth/notFound/impl/OauthNotFoundInteractorImpl;", "Lru/yoomoney/sdk/auth/oauth/notFound/impl/OauthNotFoundInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;Lru/yoomoney/sdk/auth/api/login/LoginRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/yooprofiler/YooProfiler;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/api/Origin;)V", "initAuthorization", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initEnrollment", "initRegistration", "processType", "Lru/yoomoney/sdk/auth/Config$ProcessType;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/Config$ProcessType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initRegistrationV2", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthNotFoundInteractorImpl implements OauthNotFoundInteractor {
    private final EnrollmentRepository enrollmentRepository;
    private final LoginRepository loginRepository;
    private final Origin origin;
    private final YooProfiler profiler;
    private final RegistrationV2Repository registrationV2Repository;
    private final ResultData resultData;
    private final ServerTimeRepository serverTimeRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Config.ProcessType.values().length];
            try {
                iArr[Config.ProcessType.ENROLLMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Config.ProcessType.REGISTRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Config.ProcessType.LOGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Config.ProcessType.MIGRATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Config.ProcessType.LOGIN_SBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Config.ProcessType.LOGIN_VK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Config.ProcessType.LOGIN_ESIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl", f = "OauthNotFoundInteractor.kt", l = {95, 96}, m = "initAuthorization")
    public static final class a extends ContinuationImpl {
        public OauthNotFoundInteractorImpl a;
        public String b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return OauthNotFoundInteractorImpl.this.initAuthorization(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl", f = "OauthNotFoundInteractor.kt", l = {49, 50}, m = "initEnrollment")
    public static final class b extends ContinuationImpl {
        public OauthNotFoundInteractorImpl a;
        public String b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return OauthNotFoundInteractorImpl.this.initEnrollment(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl", f = "OauthNotFoundInteractor.kt", l = {72, 73}, m = "initRegistrationV2")
    public static final class c extends ContinuationImpl {
        public OauthNotFoundInteractorImpl a;
        public String b;
        public /* synthetic */ Object c;
        public int e;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return OauthNotFoundInteractorImpl.this.initRegistrationV2(null, this);
        }
    }

    public OauthNotFoundInteractorImpl(EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, LoginRepository loginRepository, ServerTimeRepository serverTimeRepository, YooProfiler profiler, ResultData resultData, Origin origin) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.enrollmentRepository = enrollmentRepository;
        this.registrationV2Repository = registrationV2Repository;
        this.loginRepository = loginRepository;
        this.serverTimeRepository = serverTimeRepository;
        this.profiler = profiler;
        this.resultData = resultData;
        this.origin = origin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initEnrollment(java.lang.String r9, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound.Action> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r10
            ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl r9 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.getValue()
            goto L6f
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.String r9 = r0.b
            ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            goto L5a
        L46:
            kotlin.ResultKt.throwOnFailure(r10)
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository r10 = r8.serverTimeRepository
            r0.a = r8
            r0.b = r9
            r0.e = r4
            java.lang.Object r10 = r10.init(r0)
            if (r10 != r1) goto L58
            return r1
        L58:
            r10 = r9
            r9 = r8
        L5a:
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository r2 = r9.enrollmentRepository
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentLoginOauthRequest r4 = new ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentLoginOauthRequest
            r4.<init>(r10)
            r0.a = r9
            r10 = 0
            r0.b = r10
            r0.e = r3
            java.lang.Object r10 = r2.mo3254enrollmentgIAlus(r4, r0)
            if (r10 != r1) goto L6f
            return r1
        L6f:
            boolean r0 = kotlin.Result.m2634isSuccessimpl(r10)
            if (r0 == 0) goto Lae
            r0 = r10
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentResponse r0 = (ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentResponse) r0
            java.lang.String r0 = r0.getTmxSessionId()
            if (r0 == 0) goto Lae
            ru.yoomoney.sdk.yooprofiler.YooProfiler r1 = r9.profiler
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r3 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.LOGIN
            r6 = 12
            r7 = 0
            r4 = 0
            r5 = 0
            r2 = r0
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result r1 = ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profileWithSessionId$default(r1, r2, r3, r4, r5, r6, r7)
            ru.yoomoney.sdk.auth.ResultData r2 = r9.resultData
            boolean r3 = r1 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success
            if (r3 == 0) goto L99
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result$Success r1 = (ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success) r1
            java.lang.String r0 = r1.getSessionId()
            goto L9d
        L99:
            boolean r1 = r1 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Fail
            if (r1 == 0) goto La8
        L9d:
            r2.setTmxSessionId(r0)
            ru.yoomoney.sdk.auth.ResultData r9 = r9.resultData
            ru.yoomoney.sdk.auth.OauthResult$OauthLinkStatus r0 = ru.yoomoney.sdk.auth.OauthResult.OauthLinkStatus.ACCOUNT_CREATED
            r9.setOauthLinkStatus(r0)
            goto Lae
        La8:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        Lae:
            java.lang.Throwable r9 = kotlin.Result.m2631exceptionOrNullimpl(r10)
            if (r9 != 0) goto Lc0
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentResponse r10 = (ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentResponse) r10
            ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound$Action$EnrollmentSuccess r9 = new ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound$Action$EnrollmentSuccess
            ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess r10 = r10.getProcess()
            r9.<init>(r10)
            goto Lcd
        Lc0:
            ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound$Action$EnrollmentFailure r10 = new ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound$Action$EnrollmentFailure
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r9 = (ru.yoomoney.sdk.auth.api.model.Failure) r9
            r10.<init>(r9)
            r9 = r10
        Lcd:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl.initEnrollment(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initRegistrationV2(java.lang.String r9, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound.Action> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl.c
            if (r0 == 0) goto L13
            r0 = r10
            ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl$c r0 = (ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl$c r0 = new ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl$c
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl r9 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.getValue()
            goto L6f
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.String r9 = r0.b
            ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            goto L5a
        L46:
            kotlin.ResultKt.throwOnFailure(r10)
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository r10 = r8.serverTimeRepository
            r0.a = r8
            r0.b = r9
            r0.e = r4
            java.lang.Object r10 = r10.init(r0)
            if (r10 != r1) goto L58
            return r1
        L58:
            r10 = r9
            r9 = r8
        L5a:
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository r2 = r9.registrationV2Repository
            ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration$LoginOauth r4 = new ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration$LoginOauth
            r4.<init>(r10)
            r0.a = r9
            r10 = 0
            r0.b = r10
            r0.e = r3
            java.lang.Object r10 = r2.mo3297initRegistrationgIAlus(r4, r0)
            if (r10 != r1) goto L6f
            return r1
        L6f:
            boolean r0 = kotlin.Result.m2634isSuccessimpl(r10)
            if (r0 == 0) goto Lae
            r0 = r10
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit r0 = (ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit) r0
            java.lang.String r0 = r0.getTmxSessionId()
            if (r0 == 0) goto Lae
            ru.yoomoney.sdk.yooprofiler.YooProfiler r1 = r9.profiler
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r3 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.LOGIN
            r6 = 12
            r7 = 0
            r4 = 0
            r5 = 0
            r2 = r0
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result r1 = ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profileWithSessionId$default(r1, r2, r3, r4, r5, r6, r7)
            ru.yoomoney.sdk.auth.ResultData r2 = r9.resultData
            boolean r3 = r1 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success
            if (r3 == 0) goto L99
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result$Success r1 = (ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success) r1
            java.lang.String r0 = r1.getSessionId()
            goto L9d
        L99:
            boolean r1 = r1 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Fail
            if (r1 == 0) goto La8
        L9d:
            r2.setTmxSessionId(r0)
            ru.yoomoney.sdk.auth.ResultData r9 = r9.resultData
            ru.yoomoney.sdk.auth.OauthResult$OauthLinkStatus r0 = ru.yoomoney.sdk.auth.OauthResult.OauthLinkStatus.ACCOUNT_CREATED
            r9.setOauthLinkStatus(r0)
            goto Lae
        La8:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        Lae:
            java.lang.Throwable r9 = kotlin.Result.m2631exceptionOrNullimpl(r10)
            if (r9 != 0) goto Lc0
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit r10 = (ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit) r10
            ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound$Action$RegistrationSuccess r9 = new ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound$Action$RegistrationSuccess
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess r10 = r10.getRegistrationProcess()
            r9.<init>(r10)
            goto Lcd
        Lc0:
            ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound$Action$RegistrationFailure r10 = new ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound$Action$RegistrationFailure
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r9 = (ru.yoomoney.sdk.auth.api.model.Failure) r9
            r10.<init>(r9)
            r9 = r10
        Lcd:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl.initRegistrationV2(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object initAuthorization(java.lang.String r9, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound.Action> r10) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl.initAuthorization(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractor
    public Object initRegistration(String str, Config.ProcessType processType, Continuation<? super OauthNotFound.Action> continuation) {
        switch (WhenMappings.$EnumSwitchMapping$0[processType.ordinal()]) {
            case 1:
                return initEnrollment(str, continuation);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return initRegistrationV2(str, continuation);
            default:
                throw new IllegalArgumentException("process type is not supported = " + processType);
        }
    }
}
