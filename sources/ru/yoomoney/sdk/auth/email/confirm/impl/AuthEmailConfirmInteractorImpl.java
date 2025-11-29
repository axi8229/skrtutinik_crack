package ru.yoomoney.sdk.auth.email.confirm.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResendErrorResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResendSuccessResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendErrorResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendSuccessResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResendErrorResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResendSuccessResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020,H\u0002J\u001e\u0010-\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001dJ\u0016\u0010.\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001fJ\u001e\u0010/\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001dJ\u0016\u00100\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/impl/AuthEmailConfirmInteractorImpl;", "Lru/yoomoney/sdk/auth/email/confirm/impl/AuthEmailConfirmInteractor;", "Lru/yoomoney/sdk/auth/email/confirm/impl/BaseEmailConfirmInteractorImpl;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;Lru/yoomoney/sdk/auth/api/login/LoginRepository;Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "confirmEmail", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "code", "", "action", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Submit;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Submit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailForgot", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Forgot;", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Forgot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Retry;", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Retry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enrollmentConfirmEmail", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enrollmentConfirmEmailResend", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEnrollmentConfirmEmailResendResponse", "response", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResendResponse;", "handleEnrollmentConfirmEmailResponse", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResponse;", "handleLoginConfirmEmailResendResponse", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailResendResponse;", "handleLoginConfirmEmailResponse", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailResponse;", "handleMigrationConfirmEmailResendResponse", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailResendResponse;", "handleMigrationConfirmEmailResponse", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailResponse;", "loginConfirmEmail", "loginConfirmEmailResend", "migrationConfirmEmail", "migrationConfirmEmailResend", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthEmailConfirmInteractorImpl extends BaseEmailConfirmInteractorImpl implements AuthEmailConfirmInteractor {
    private final EnrollmentRepository enrollmentRepository;
    private final LoginRepository loginRepository;
    private final MigrationRepository migrationRepository;

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
                iArr[ProcessType.LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProcessType.MIGRATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl", f = "AuthEmailConfirmInteractor.kt", l = {72, 79}, m = "enrollmentConfirmEmail")
    public static final class a extends ContinuationImpl {
        public AuthEmailConfirmInteractorImpl a;
        public String b;
        public String c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthEmailConfirmInteractorImpl.this.enrollmentConfirmEmail(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl", f = "AuthEmailConfirmInteractor.kt", l = {134}, m = "enrollmentConfirmEmailResend")
    public static final class b extends ContinuationImpl {
        public AuthEmailConfirmInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return AuthEmailConfirmInteractorImpl.this.enrollmentConfirmEmailResend(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl", f = "AuthEmailConfirmInteractor.kt", l = {93, 100}, m = "loginConfirmEmail")
    public static final class c extends ContinuationImpl {
        public AuthEmailConfirmInteractorImpl a;
        public String b;
        public String c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthEmailConfirmInteractorImpl.this.loginConfirmEmail(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl", f = "AuthEmailConfirmInteractor.kt", l = {140}, m = "loginConfirmEmailResend")
    public static final class d extends ContinuationImpl {
        public AuthEmailConfirmInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return AuthEmailConfirmInteractorImpl.this.loginConfirmEmailResend(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl", f = "AuthEmailConfirmInteractor.kt", l = {114, 121}, m = "migrationConfirmEmail")
    public static final class e extends ContinuationImpl {
        public AuthEmailConfirmInteractorImpl a;
        public String b;
        public String c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthEmailConfirmInteractorImpl.this.migrationConfirmEmail(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl", f = "AuthEmailConfirmInteractor.kt", l = {146}, m = "migrationConfirmEmailResend")
    public static final class f extends ContinuationImpl {
        public AuthEmailConfirmInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return AuthEmailConfirmInteractorImpl.this.migrationConfirmEmailResend(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthEmailConfirmInteractorImpl(EnrollmentRepository enrollmentRepository, LoginRepository loginRepository, MigrationRepository migrationRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        super(passwordRecoveryRepository, serverTimeRepository);
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.enrollmentRepository = enrollmentRepository;
        this.loginRepository = loginRepository;
        this.migrationRepository = migrationRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enrollmentConfirmEmail(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.enrollmentConfirmEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enrollmentConfirmEmailResend(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl r5 = r0.a
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
            java.lang.Object r6 = r6.mo3251confirmEmailResendgIAlus(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r5 = r4
        L4a:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r0 != 0) goto L57
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResendResponse r6 = (ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResendResponse) r6
            ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action r5 = r5.handleEnrollmentConfirmEmailResendResponse(r6)
            goto L63
        L57:
            ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action$ConfirmEmailTechnicalError r5 = new ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action$ConfirmEmailTechnicalError
            java.lang.String r6 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r6)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r5.<init>(r0)
        L63:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.enrollmentConfirmEmailResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final EmailConfirm.Action handleEnrollmentConfirmEmailResendResponse(EnrollmentConfirmEmailResendResponse response) {
        if (response instanceof EnrollmentConfirmEmailResendSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((EnrollmentConfirmEmailResendSuccessResponse) response).getProcess());
        }
        if (response instanceof EnrollmentConfirmEmailResendErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((EnrollmentConfirmEmailResendErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handleEnrollmentConfirmEmailResponse(EnrollmentConfirmEmailResponse response) {
        if (response instanceof EnrollmentConfirmEmailSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((EnrollmentConfirmEmailSuccessResponse) response).getProcess());
        }
        if (response instanceof EnrollmentConfirmEmailErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((EnrollmentConfirmEmailErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handleLoginConfirmEmailResendResponse(LoginConfirmEmailResendResponse response) {
        if (response instanceof LoginConfirmEmailResendSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((LoginConfirmEmailResendSuccessResponse) response).getProcess());
        }
        if (response instanceof LoginConfirmEmailResendErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((LoginConfirmEmailResendErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handleLoginConfirmEmailResponse(LoginConfirmEmailResponse response) {
        if (response instanceof LoginConfirmEmailSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((LoginConfirmEmailSuccessResponse) response).getProcess());
        }
        if (response instanceof LoginConfirmEmailErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((LoginConfirmEmailErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handleMigrationConfirmEmailResendResponse(MigrationConfirmEmailResendResponse response) {
        if (response instanceof MigrationConfirmEmailResendSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((MigrationConfirmEmailResendSuccessResponse) response).getProcess());
        }
        if (response instanceof MigrationConfirmEmailResendErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((MigrationConfirmEmailResendErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handleMigrationConfirmEmailResponse(MigrationConfirmEmailResponse response) {
        if (response instanceof MigrationConfirmEmailSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((MigrationConfirmEmailSuccessResponse) response).getProcess());
        }
        if (response instanceof MigrationConfirmEmailErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((MigrationConfirmEmailErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loginConfirmEmail(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.loginConfirmEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loginConfirmEmailResend(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.d
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl$d r0 = (ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl$d r0 = new ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl$d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl r5 = r0.a
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
            ru.yoomoney.sdk.auth.api.login.LoginRepository r6 = r4.loginRepository
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r6.mo3264confirmEmailResendgIAlus(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r5 = r4
        L4a:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r0 != 0) goto L57
            ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendResponse r6 = (ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendResponse) r6
            ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action r5 = r5.handleLoginConfirmEmailResendResponse(r6)
            goto L63
        L57:
            ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action$ConfirmEmailTechnicalError r5 = new ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action$ConfirmEmailTechnicalError
            java.lang.String r6 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r6)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r5.<init>(r0)
        L63:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.loginConfirmEmailResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object migrationConfirmEmail(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.migrationConfirmEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object migrationConfirmEmailResend(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.f
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl$f r0 = (ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.f) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl$f r0 = new ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl r5 = r0.a
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
            java.lang.Object r6 = r6.mo3273confirmEmailResendgIAlus(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r5 = r4
        L4a:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r0 != 0) goto L57
            ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResendResponse r6 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResendResponse) r6
            ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action r5 = r5.handleMigrationConfirmEmailResendResponse(r6)
            goto L63
        L57:
            ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action$ConfirmEmailTechnicalError r5 = new ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action$ConfirmEmailTechnicalError
            java.lang.String r6 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r6)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r5.<init>(r0)
        L63:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractorImpl.migrationConfirmEmailResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    public Object confirmEmail(String str, EmailConfirm.Action.Submit submit, Continuation<? super EmailConfirm.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[submit.getProcessType().ordinal()];
        if (i == 1) {
            return enrollmentConfirmEmail(str, submit.getProcessId(), continuation);
        }
        if (i == 2) {
            return loginConfirmEmail(str, submit.getProcessId(), continuation);
        }
        if (i == 3) {
            return migrationConfirmEmail(str, submit.getProcessId(), continuation);
        }
        if (i == 4) {
            return passwordRecoveryConfirmEmail(str, submit.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }

    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    public Object confirmEmailForgot(EmailConfirm.Action.Forgot forgot, Continuation<? super EmailConfirm.Action> continuation) {
        throw new IllegalArgumentException("no command for interaction " + this);
    }

    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    public Object confirmEmailResend(EmailConfirm.Action.Retry retry, Continuation<? super EmailConfirm.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[retry.getProcessType().ordinal()];
        if (i == 1) {
            return enrollmentConfirmEmailResend(retry.getProcessId(), continuation);
        }
        if (i == 2) {
            return loginConfirmEmailResend(retry.getProcessId(), continuation);
        }
        if (i == 3) {
            return migrationConfirmEmailResend(retry.getProcessId(), continuation);
        }
        if (i == 4) {
            return passwordRecoveryConfirmEmailResend(retry.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }
}
