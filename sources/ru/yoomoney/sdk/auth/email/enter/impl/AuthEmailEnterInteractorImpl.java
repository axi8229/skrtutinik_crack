package ru.yoomoney.sdk.auth.email.enter.impl;

import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010 J\u001e\u0010\"\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/impl/AuthEmailEnterInteractorImpl;", "Lru/yoomoney/sdk/auth/email/enter/impl/AuthEmailEnterInteractor;", "Lru/yoomoney/sdk/auth/email/enter/impl/BaseEmailEnterInteractorImpl;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "handleConfirmEmailRegistrationProcess", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "result", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "handleMigrationSetEmailSuccessResponse", "response", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailResponse;", "handleSendEmailEnrollmentProcess", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailResponse;", "handleSendEmailRegistrationProcess", "registrationConfirmEmail", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEmail", "action", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmail;", Scopes.EMAIL, "(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmail;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEmailEnrollment", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEmailMigration", "sendEmailRegistration", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthEmailEnterInteractorImpl extends BaseEmailEnterInteractorImpl implements AuthEmailEnterInteractor {
    private final EnrollmentRepository enrollmentRepository;
    private final MigrationRepository migrationRepository;
    private final RegistrationV2Repository registrationV2Repository;

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
                iArr[ProcessType.REGISTRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProcessType.MIGRATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl", f = "AuthEmailEnterInteractor.kt", l = {44, 49}, m = "registrationConfirmEmail")
    public static final class a extends ContinuationImpl {
        public AuthEmailEnterInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AuthEmailEnterInteractorImpl.this.registrationConfirmEmail(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl", f = "AuthEmailEnterInteractor.kt", l = {63, 70}, m = "sendEmailEnrollment")
    public static final class b extends ContinuationImpl {
        public AuthEmailEnterInteractorImpl a;
        public String b;
        public String c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthEmailEnterInteractorImpl.this.sendEmailEnrollment(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl", f = "AuthEmailEnterInteractor.kt", l = {105, 112}, m = "sendEmailMigration")
    public static final class c extends ContinuationImpl {
        public AuthEmailEnterInteractorImpl a;
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
            return AuthEmailEnterInteractorImpl.this.sendEmailMigration(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl", f = "AuthEmailEnterInteractor.kt", l = {84, 91}, m = "sendEmailRegistration")
    public static final class d extends ContinuationImpl {
        public AuthEmailEnterInteractorImpl a;
        public String b;
        public String c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthEmailEnterInteractorImpl.this.sendEmailRegistration(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthEmailEnterInteractorImpl(EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository) {
        super(serverTimeRepository);
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.enrollmentRepository = enrollmentRepository;
        this.registrationV2Repository = registrationV2Repository;
        this.migrationRepository = migrationRepository;
    }

    private final EmailEnter.Action handleConfirmEmailRegistrationProcess(RegistrationProcess result) {
        return result instanceof RegistrationProcess.Failure ? new EmailEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((RegistrationProcess.Failure) result).getError())) : new EmailEnter.Action.ConfirmEmailSuccess(result);
    }

    private final EmailEnter.Action handleMigrationSetEmailSuccessResponse(MigrationSetEmailResponse response) {
        if (response instanceof MigrationSetEmailSuccessResponse) {
            return new EmailEnter.Action.SendEmailSuccess(((MigrationSetEmailSuccessResponse) response).getProcess());
        }
        if (response instanceof MigrationSetEmailErrorResponse) {
            return new EmailEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((MigrationSetEmailErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailEnter.Action handleSendEmailEnrollmentProcess(EnrollmentSetEmailResponse result) {
        if (result instanceof EnrollmentSetEmailSuccessResponse) {
            return new EmailEnter.Action.SendEmailSuccess(((EnrollmentSetEmailSuccessResponse) result).getProcess());
        }
        if (result instanceof EnrollmentSetEmailErrorResponse) {
            return new EmailEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((EnrollmentSetEmailErrorResponse) result).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailEnter.Action handleSendEmailRegistrationProcess(RegistrationProcess result) {
        return result instanceof RegistrationProcess.Failure ? new EmailEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((RegistrationProcess.Failure) result).getError())) : new EmailEnter.Action.SendEmailRegistrationSuccess(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x009c -> B:34:0x009f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendEmailEnrollment(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.enter.EmailEnter.Action> r13) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl.sendEmailEnrollment(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object sendEmailMigration(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.enter.EmailEnter.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl.sendEmailMigration(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0097 -> B:34:0x009a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendEmailRegistration(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.enter.EmailEnter.Action> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl.d
            if (r0 == 0) goto L13
            r0 = r13
            ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl$d r0 = (ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl.d) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl$d r0 = new ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl$d
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.g
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L50
            if (r2 == r5) goto L3e
            if (r2 != r3) goto L36
            int r11 = r0.d
            java.lang.String r12 = r0.c
            java.lang.String r2 = r0.b
            ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r13)
            goto L9a
        L36:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3e:
            int r11 = r0.d
            java.lang.String r12 = r0.c
            java.lang.String r2 = r0.b
            ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r13 = r13.getValue()
            goto L70
        L50:
            kotlin.ResultKt.throwOnFailure(r13)
            r2 = r10
            r13 = r5
        L55:
            r6 = 6
            if (r13 >= r6) goto Lba
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository r6 = r2.registrationV2Repository
            r0.a = r2
            r0.b = r11
            r0.c = r12
            r0.d = r13
            r0.g = r5
            java.lang.Object r6 = r6.mo3298setEmail0E7RQCE(r11, r12, r0)
            if (r6 != r1) goto L6b
            return r1
        L6b:
            r9 = r2
            r2 = r11
            r11 = r13
            r13 = r6
            r6 = r9
        L70:
            java.lang.Throwable r7 = kotlin.Result.m2631exceptionOrNullimpl(r13)
            boolean r8 = r7 instanceof ru.yoomoney.sdk.auth.api.model.Failure
            if (r8 == 0) goto L7b
            ru.yoomoney.sdk.auth.api.model.Failure r7 = (ru.yoomoney.sdk.auth.api.model.Failure) r7
            goto L7c
        L7b:
            r7 = r4
        L7c:
            boolean r8 = r7 instanceof ru.yoomoney.sdk.auth.api.model.ProcessingRequestFailure
            if (r8 == 0) goto L9f
            r8 = 5
            if (r11 >= r8) goto L9f
            ru.yoomoney.sdk.auth.api.model.ProcessingRequestFailure r7 = (ru.yoomoney.sdk.auth.api.model.ProcessingRequestFailure) r7
            long r7 = r7.getRetryAfter()
            r0.a = r6
            r0.b = r2
            r0.c = r12
            r0.d = r11
            r0.g = r3
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r7, r0)
            if (r13 != r1) goto L9a
            return r1
        L9a:
            int r13 = r11 + 1
            r11 = r2
            r2 = r6
            goto L55
        L9f:
            java.lang.Throwable r11 = kotlin.Result.m2631exceptionOrNullimpl(r13)
            if (r11 != 0) goto Lac
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess r13 = (ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess) r13
            ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action r11 = r6.handleSendEmailRegistrationProcess(r13)
            goto Lb9
        Lac:
            ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$ShowFailure r12 = new ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$ShowFailure
            java.lang.String r13 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r13)
            ru.yoomoney.sdk.auth.api.model.Failure r11 = (ru.yoomoney.sdk.auth.api.model.Failure) r11
            r12.<init>(r11)
            r11 = r12
        Lb9:
            return r11
        Lba:
            ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$ShowFailure r11 = new ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$ShowFailure
            ru.yoomoney.sdk.auth.api.model.TechnicalFailure r12 = new ru.yoomoney.sdk.auth.api.model.TechnicalFailure
            r12.<init>(r4, r5, r4)
            r11.<init>(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl.sendEmailRegistration(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008e -> B:34:0x0091). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.email.enter.impl.BaseEmailEnterInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object registrationConfirmEmail(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.enter.EmailEnter.Action> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl.a
            if (r0 == 0) goto L13
            r0 = r12
            ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl$a r0 = (ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl$a r0 = new ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl$a
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L3b
            if (r2 != r3) goto L33
            int r11 = r0.c
            java.lang.String r2 = r0.b
            ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r12)
            goto L91
        L33:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            int r11 = r0.c
            java.lang.String r2 = r0.b
            ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r12 = r12.getValue()
            goto L69
        L4b:
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r10
            r12 = r5
        L50:
            r6 = 6
            if (r12 >= r6) goto Lb1
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository r6 = r2.registrationV2Repository
            r0.a = r2
            r0.b = r11
            r0.c = r12
            r0.f = r5
            java.lang.Object r6 = r6.mo3295confirmEmailgIAlus(r11, r0)
            if (r6 != r1) goto L64
            return r1
        L64:
            r9 = r2
            r2 = r11
            r11 = r12
            r12 = r6
            r6 = r9
        L69:
            java.lang.Throwable r7 = kotlin.Result.m2631exceptionOrNullimpl(r12)
            boolean r8 = r7 instanceof ru.yoomoney.sdk.auth.api.model.Failure
            if (r8 == 0) goto L74
            ru.yoomoney.sdk.auth.api.model.Failure r7 = (ru.yoomoney.sdk.auth.api.model.Failure) r7
            goto L75
        L74:
            r7 = r4
        L75:
            boolean r8 = r7 instanceof ru.yoomoney.sdk.auth.api.model.ProcessingRequestFailure
            if (r8 == 0) goto L96
            r8 = 5
            if (r11 >= r8) goto L96
            ru.yoomoney.sdk.auth.api.model.ProcessingRequestFailure r7 = (ru.yoomoney.sdk.auth.api.model.ProcessingRequestFailure) r7
            long r7 = r7.getRetryAfter()
            r0.a = r6
            r0.b = r2
            r0.c = r11
            r0.f = r3
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r7, r0)
            if (r12 != r1) goto L91
            return r1
        L91:
            int r12 = r11 + 1
            r11 = r2
            r2 = r6
            goto L50
        L96:
            java.lang.Throwable r11 = kotlin.Result.m2631exceptionOrNullimpl(r12)
            if (r11 != 0) goto La3
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess r12 = (ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess) r12
            ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action r11 = r6.handleConfirmEmailRegistrationProcess(r12)
            goto Lb0
        La3:
            ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$ShowFailure r12 = new ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$ShowFailure
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r11 = (ru.yoomoney.sdk.auth.api.model.Failure) r11
            r12.<init>(r11)
            r11 = r12
        Lb0:
            return r11
        Lb1:
            ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$ShowFailure r11 = new ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$ShowFailure
            ru.yoomoney.sdk.auth.api.model.TechnicalFailure r12 = new ru.yoomoney.sdk.auth.api.model.TechnicalFailure
            r12.<init>(r4, r5, r4)
            r11.<init>(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl.registrationConfirmEmail(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.email.enter.impl.BaseEmailEnterInteractor
    public Object sendEmail(EmailEnter.Action.SendEmail sendEmail, String str, Continuation<? super EmailEnter.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[sendEmail.getProcessType().ordinal()];
        if (i == 1) {
            return sendEmailEnrollment(sendEmail.getProcessId(), str, continuation);
        }
        if (i == 2) {
            return sendEmailRegistration(sendEmail.getProcessId(), str, continuation);
        }
        if (i == 3) {
            return sendEmailMigration(sendEmail.getProcessId(), str, continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }
}
