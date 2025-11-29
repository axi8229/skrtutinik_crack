package ru.yoomoney.sdk.auth.finishing.success.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.ProcessKt;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessSuccess;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessSuccess;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcess;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessSuccess;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\u0016\u0010'\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\u0016\u0010(\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingSuccessInteractorImpl;", "Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingSuccessInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "accountRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "config", "Lru/yoomoney/sdk/auth/Config;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;Lru/yoomoney/sdk/auth/api/login/LoginRepository;Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;Lru/yoomoney/sdk/auth/api/account/AccountRepository;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/ResultData;)V", "account", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "action", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAccount;", "(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAccount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireAuthorization", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAcquire;", "(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAcquire;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enrollmentAcquireAuthorization", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEnrollmentAcquireAuthorizationProcess", "process", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "handleLoginAcquireAuthorizationProcess", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "handleMigrationAcquireAuthorizationProcess", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "handleRegistrationAcquireAuthorizationProcess", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "loginAcquireAuthorization", "migrationAcquireAuthorization", "registrationAcquireAuthorization", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthFinishingSuccessInteractorImpl implements AuthFinishingSuccessInteractor {
    private final AccountRepository accountRepository;
    private final Config config;
    private final EnrollmentRepository enrollmentRepository;
    private final LoginRepository loginRepository;
    private final MigrationRepository migrationRepository;
    private final RegistrationV2Repository registrationV2Repository;
    private final ResultData resultData;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.ENROLLMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.MIGRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProcessType.LOGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProcessType.REGISTRATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl", f = "AuthFinishingSuccessInteractor.kt", l = {61}, m = "account")
    public static final class a extends ContinuationImpl {
        public AuthFinishingSuccess.Action.LoadAccount a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return AuthFinishingSuccessInteractorImpl.this.account(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl", f = "AuthFinishingSuccessInteractor.kt", l = {80}, m = "enrollmentAcquireAuthorization")
    public static final class b extends ContinuationImpl {
        public AuthFinishingSuccessInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return AuthFinishingSuccessInteractorImpl.this.enrollmentAcquireAuthorization(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl", f = "AuthFinishingSuccessInteractor.kt", l = {115, 119}, m = "loginAcquireAuthorization")
    public static final class c extends ContinuationImpl {
        public AuthFinishingSuccessInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AuthFinishingSuccessInteractorImpl.this.loginAcquireAuthorization(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl", f = "AuthFinishingSuccessInteractor.kt", l = {97}, m = "migrationAcquireAuthorization")
    public static final class d extends ContinuationImpl {
        public AuthFinishingSuccessInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return AuthFinishingSuccessInteractorImpl.this.migrationAcquireAuthorization(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl", f = "AuthFinishingSuccessInteractor.kt", l = {140, 146}, m = "registrationAcquireAuthorization")
    public static final class e extends ContinuationImpl {
        public AuthFinishingSuccessInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AuthFinishingSuccessInteractorImpl.this.registrationAcquireAuthorization(null, this);
        }
    }

    public AuthFinishingSuccessInteractorImpl(EnrollmentRepository enrollmentRepository, LoginRepository loginRepository, RegistrationV2Repository registrationV2Repository, MigrationRepository migrationRepository, AccountRepository accountRepository, Config config, ResultData resultData) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        this.enrollmentRepository = enrollmentRepository;
        this.loginRepository = loginRepository;
        this.registrationV2Repository = registrationV2Repository;
        this.migrationRepository = migrationRepository;
        this.accountRepository = accountRepository;
        this.config = config;
        this.resultData = resultData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enrollmentAcquireAuthorization(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.getValue()
            goto L4a
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository r6 = r4.enrollmentRepository
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r6.mo3249acquireAuthorizationgIAlus(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r5 = r4
        L4a:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r0 != 0) goto L7b
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationResponse r6 = (ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationResponse) r6
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationSuccessResponse
            if (r0 == 0) goto L61
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationSuccessResponse r6 = (ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationSuccessResponse) r6
            ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess r6 = r6.getProcess()
            ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action r5 = r5.handleEnrollmentAcquireAuthorizationProcess(r6)
            goto L87
        L61:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationErrorResponse
            if (r5 == 0) goto L75
            ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAcquire r5 = new ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAcquire
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationErrorResponse r6 = (ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationErrorResponse) r6
            ru.yoomoney.sdk.auth.api.model.ProcessError r6 = r6.getError()
            ru.yoomoney.sdk.auth.api.model.FeatureFailure r6 = ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt.toFailure(r6)
            r5.<init>(r6)
            goto L87
        L75:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L7b:
            ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAcquire r5 = new ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAcquire
            java.lang.String r6 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r6)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r5.<init>(r0)
        L87:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.enrollmentAcquireAuthorization(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AuthFinishingSuccess.Action handleEnrollmentAcquireAuthorizationProcess(EnrollmentProcess process) {
        if (!(process instanceof EnrollmentProcessSuccess)) {
            return new AuthFinishingSuccess.Action.NextStep(process);
        }
        ProcessType processType = ProcessKt.toProcessType(process);
        EnrollmentProcessSuccess enrollmentProcessSuccess = (EnrollmentProcessSuccess) process;
        return new AuthFinishingSuccess.Action.LoadAccount(processType, enrollmentProcessSuccess.getAccessToken(), enrollmentProcessSuccess.getBindSocialAccountResult());
    }

    private final AuthFinishingSuccess.Action handleLoginAcquireAuthorizationProcess(LoginProcess process) {
        if (!(process instanceof LoginProcessSuccess)) {
            return new AuthFinishingSuccess.Action.NextStep(process);
        }
        ProcessType processType = ProcessKt.toProcessType(process);
        LoginProcessSuccess loginProcessSuccess = (LoginProcessSuccess) process;
        return new AuthFinishingSuccess.Action.LoadAccount(processType, loginProcessSuccess.getAccessToken(), loginProcessSuccess.getBindSocialAccountResult());
    }

    private final AuthFinishingSuccess.Action handleMigrationAcquireAuthorizationProcess(MigrationProcess process) {
        if (!(process instanceof MigrationProcessSuccess)) {
            return new AuthFinishingSuccess.Action.NextStep(process);
        }
        ProcessType processType = ProcessKt.toProcessType(process);
        MigrationProcessSuccess migrationProcessSuccess = (MigrationProcessSuccess) process;
        return new AuthFinishingSuccess.Action.LoadAccount(processType, migrationProcessSuccess.getAccessToken(), migrationProcessSuccess.getBindSocialAccountResult());
    }

    private final AuthFinishingSuccess.Action handleRegistrationAcquireAuthorizationProcess(RegistrationProcess process) {
        if (!(process instanceof RegistrationProcess.Success)) {
            return process instanceof RegistrationProcess.Failure ? new AuthFinishingSuccess.Action.FailAcquire(ProcessErrorExtensionsKt.toFailure(((RegistrationProcess.Failure) process).getError())) : new AuthFinishingSuccess.Action.NextRegistrationStep(process);
        }
        RegistrationProcess.Success success = (RegistrationProcess.Success) process;
        return new AuthFinishingSuccess.Action.LoadAccount(ProcessType.REGISTRATION, success.getAccessToken(), success.getBindSocialAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loginAcquireAuthorization(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess.Action> r12) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.loginAcquireAuthorization(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object migrationAcquireAuthorization(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.d
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl$d r0 = (ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl$d r0 = new ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl$d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.getValue()
            goto L4a
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.migration.MigrationRepository r6 = r4.migrationRepository
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r6.mo3271acquireAuthorizationgIAlus(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r5 = r4
        L4a:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r0 != 0) goto L7b
            ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationResponse r6 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationResponse) r6
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationSuccessResponse
            if (r0 == 0) goto L61
            ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationSuccessResponse r6 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationSuccessResponse) r6
            ru.yoomoney.sdk.auth.api.migration.model.MigrationProcess r6 = r6.getProcess()
            ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action r5 = r5.handleMigrationAcquireAuthorizationProcess(r6)
            goto L87
        L61:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationErrorResponse
            if (r5 == 0) goto L75
            ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAcquire r5 = new ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAcquire
            ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationErrorResponse r6 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationErrorResponse) r6
            ru.yoomoney.sdk.auth.api.model.ProcessError r6 = r6.getError()
            ru.yoomoney.sdk.auth.api.model.FeatureFailure r6 = ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt.toFailure(r6)
            r5.<init>(r6)
            goto L87
        L75:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L7b:
            ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAcquire r5 = new ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAcquire
            java.lang.String r6 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r6)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r5.<init>(r0)
        L87:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.migrationAcquireAuthorization(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008e -> B:34:0x0091). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object registrationAcquireAuthorization(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess.Action> r12) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.registrationAcquireAuthorization(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object account(ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess.Action.LoadAccount r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl$a r0 = (ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl$a r0 = new ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$LoadAccount r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.getValue()
            goto L4d
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.account.AccountRepository r6 = r4.accountRepository
            java.lang.String r2 = r5.getAccessToken()
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = r6.mo3209accountgIAlus(r2, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r0 != 0) goto L67
            ru.yoomoney.sdk.auth.api.account.model.UserAccount r6 = (ru.yoomoney.sdk.auth.api.account.model.UserAccount) r6
            ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$SuccessAccount r0 = new ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$SuccessAccount
            ru.yoomoney.sdk.auth.api.ProcessType r1 = r5.getProcessType()
            java.lang.String r2 = r5.getAccessToken()
            ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult r5 = r5.getBindSocialAccountResult()
            r0.<init>(r1, r2, r6, r5)
            goto L7c
        L67:
            ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAccount r6 = new ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$FailAccount
            ru.yoomoney.sdk.auth.api.ProcessType r1 = r5.getProcessType()
            java.lang.String r5 = r5.getAccessToken()
            java.lang.String r2 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r6.<init>(r1, r5, r0)
            r0 = r6
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl.account(ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess$Action$LoadAccount, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractor
    public Object acquireAuthorization(AuthFinishingSuccess.Action.LoadAcquire loadAcquire, Continuation<? super AuthFinishingSuccess.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[loadAcquire.getProcessType().ordinal()];
        if (i == 1) {
            return enrollmentAcquireAuthorization(loadAcquire.getProcessId(), continuation);
        }
        if (i == 2) {
            return migrationAcquireAuthorization(loadAcquire.getProcessId(), continuation);
        }
        if (i == 3) {
            return loginAcquireAuthorization(loadAcquire.getProcessId(), continuation);
        }
        if (i == 4) {
            return registrationAcquireAuthorization(loadAcquire.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }
}
