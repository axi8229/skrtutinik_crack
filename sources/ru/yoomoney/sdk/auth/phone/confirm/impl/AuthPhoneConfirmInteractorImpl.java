package ru.yoomoney.sdk.auth.phone.confirm.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_transport_type_e;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001fJ\u001e\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001dJ\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001fJ\u001e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001dJ\u0016\u0010#\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/impl/AuthPhoneConfirmInteractorImpl;", "Lru/yoomoney/sdk/auth/phone/confirm/impl/AuthPhoneConfirmInteractor;", "Lru/yoomoney/sdk/auth/phone/confirm/impl/BasePhoneConfirmInteractorImpl;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;Lru/yoomoney/sdk/auth/api/login/LoginRepository;Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "confirmPhone", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "action", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeValid;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeValid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Forgot;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Forgot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Retry;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Retry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enrollmentConfirmPhone", "code", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enrollmentConfirmPhoneResend", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginConfirmPhone", "loginConfirmPhoneResend", "migrationConfirmPhone", "migrationConfirmPhoneResend", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthPhoneConfirmInteractorImpl extends BasePhoneConfirmInteractorImpl implements AuthPhoneConfirmInteractor {
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl", f = "AuthPhoneConfirmInteractor.kt", l = {67, 74}, m = "enrollmentConfirmPhone")
    public static final class a extends ContinuationImpl {
        public AuthPhoneConfirmInteractorImpl a;
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
            return AuthPhoneConfirmInteractorImpl.this.enrollmentConfirmPhone(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl", f = "AuthPhoneConfirmInteractor.kt", l = {157}, m = "enrollmentConfirmPhoneResend")
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return AuthPhoneConfirmInteractorImpl.this.enrollmentConfirmPhoneResend(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl", f = "AuthPhoneConfirmInteractor.kt", l = {95, 102}, m = "loginConfirmPhone")
    public static final class c extends ContinuationImpl {
        public AuthPhoneConfirmInteractorImpl a;
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
            return AuthPhoneConfirmInteractorImpl.this.loginConfirmPhone(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl", f = "AuthPhoneConfirmInteractor.kt", l = {172}, m = "loginConfirmPhoneResend")
    public static final class d extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return AuthPhoneConfirmInteractorImpl.this.loginConfirmPhoneResend(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl", f = "AuthPhoneConfirmInteractor.kt", l = {123, pjsip_transport_type_e.PJSIP_TRANSPORT_TCP6}, m = "migrationConfirmPhone")
    public static final class e extends ContinuationImpl {
        public AuthPhoneConfirmInteractorImpl a;
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
            return AuthPhoneConfirmInteractorImpl.this.migrationConfirmPhone(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl", f = "AuthPhoneConfirmInteractor.kt", l = {187}, m = "migrationConfirmPhoneResend")
    public static final class f extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return AuthPhoneConfirmInteractorImpl.this.migrationConfirmPhoneResend(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthPhoneConfirmInteractorImpl(EnrollmentRepository enrollmentRepository, LoginRepository loginRepository, MigrationRepository migrationRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        super(serverTimeRepository, passwordRecoveryRepository);
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enrollmentConfirmPhone(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.enrollmentConfirmPhone(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enrollmentConfirmPhoneResend(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl$b
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
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository r6 = r4.enrollmentRepository
            r0.c = r3
            java.lang.Object r5 = r6.mo3253confirmPhoneResendgIAlus(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L77
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendResponse r5 = (ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendResponse) r5
            boolean r6 = r5 instanceof ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendSuccessResponse
            if (r6 == 0) goto L5d
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneSuccess r6 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneSuccess
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendSuccessResponse r5 = (ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendSuccessResponse) r5
            ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess r5 = r5.getProcess()
            r6.<init>(r5)
            goto L84
        L5d:
            boolean r6 = r5 instanceof ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendErrorResponse
            if (r6 == 0) goto L71
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneFail r6 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneFail
            ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendErrorResponse r5 = (ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendErrorResponse) r5
            ru.yoomoney.sdk.auth.api.model.ProcessError r5 = r5.getError()
            ru.yoomoney.sdk.auth.api.model.FeatureFailure r5 = ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt.toFailure(r5)
            r6.<init>(r5)
            goto L84
        L71:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L77:
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$TechnicalError r5 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$TechnicalError
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
            r6 = r5
        L84:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.enrollmentConfirmPhoneResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loginConfirmPhone(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.loginConfirmPhone(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loginConfirmPhoneResend(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.d
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl$d r0 = (ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl$d r0 = new ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl$d
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
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.login.LoginRepository r6 = r4.loginRepository
            r0.c = r3
            java.lang.Object r5 = r6.mo3266confirmPhoneResendgIAlus(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L77
            ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendResponse r5 = (ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendResponse) r5
            boolean r6 = r5 instanceof ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendSuccessResponse
            if (r6 == 0) goto L5d
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneSuccess r6 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneSuccess
            ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendSuccessResponse r5 = (ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendSuccessResponse) r5
            ru.yoomoney.sdk.auth.api.login.model.LoginProcess r5 = r5.getProcess()
            r6.<init>(r5)
            goto L84
        L5d:
            boolean r6 = r5 instanceof ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendErrorResponse
            if (r6 == 0) goto L71
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneFail r6 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneFail
            ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendErrorResponse r5 = (ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendErrorResponse) r5
            ru.yoomoney.sdk.auth.api.model.ProcessError r5 = r5.getError()
            ru.yoomoney.sdk.auth.api.model.FeatureFailure r5 = ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt.toFailure(r5)
            r6.<init>(r5)
            goto L84
        L71:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L77:
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$TechnicalError r5 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$TechnicalError
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
            r6 = r5
        L84:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.loginConfirmPhoneResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object migrationConfirmPhone(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.migrationConfirmPhone(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object migrationConfirmPhoneResend(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.f
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl$f r0 = (ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl$f r0 = new ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl$f
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
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.migration.MigrationRepository r6 = r4.migrationRepository
            r0.c = r3
            java.lang.Object r5 = r6.mo3275confirmPhoneResendgIAlus(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L77
            ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendResponse r5 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendResponse) r5
            boolean r6 = r5 instanceof ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendSuccessResponse
            if (r6 == 0) goto L5d
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneSuccess r6 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneSuccess
            ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendSuccessResponse r5 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendSuccessResponse) r5
            ru.yoomoney.sdk.auth.api.migration.model.MigrationProcess r5 = r5.getProcess()
            r6.<init>(r5)
            goto L84
        L5d:
            boolean r6 = r5 instanceof ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendErrorResponse
            if (r6 == 0) goto L71
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneFail r6 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneFail
            ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendErrorResponse r5 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendErrorResponse) r5
            ru.yoomoney.sdk.auth.api.model.ProcessError r5 = r5.getError()
            ru.yoomoney.sdk.auth.api.model.FeatureFailure r5 = ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt.toFailure(r5)
            r6.<init>(r5)
            goto L84
        L71:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L77:
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$TechnicalError r5 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$TechnicalError
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
            r6 = r5
        L84:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl.migrationConfirmPhoneResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractor
    public Object confirmPhone(PhoneConfirm.Action.CodeValid codeValid, Continuation<? super PhoneConfirm.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[codeValid.getProcessType().ordinal()];
        if (i == 1) {
            return enrollmentConfirmPhone(codeValid.getValue(), codeValid.getProcessId(), continuation);
        }
        if (i == 2) {
            return loginConfirmPhone(codeValid.getValue(), codeValid.getProcessId(), continuation);
        }
        if (i == 3) {
            return migrationConfirmPhone(codeValid.getValue(), codeValid.getProcessId(), continuation);
        }
        if (i == 4) {
            return passwordRecoveryConfirmPhone(codeValid.getValue(), codeValid.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractor
    public Object confirmPhoneForgot(PhoneConfirm.Action.Forgot forgot, Continuation<? super PhoneConfirm.Action> continuation) {
        throw new IllegalArgumentException("no command for process " + this);
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractor
    public Object confirmPhoneResend(PhoneConfirm.Action.Retry retry, Continuation<? super PhoneConfirm.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[retry.getProcessType().ordinal()];
        if (i == 1) {
            return enrollmentConfirmPhoneResend(retry.getProcessId(), continuation);
        }
        if (i == 2) {
            return loginConfirmPhoneResend(retry.getProcessId(), continuation);
        }
        if (i == 3) {
            return migrationConfirmPhoneResend(retry.getProcessId(), continuation);
        }
        if (i == 4) {
            return passwordRecoveryConfirmPhoneResend(retry.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }
}
