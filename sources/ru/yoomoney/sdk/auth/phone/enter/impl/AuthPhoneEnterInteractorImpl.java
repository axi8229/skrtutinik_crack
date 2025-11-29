package ru.yoomoney.sdk.auth.phone.enter.impl;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_transport_type_e;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneErrorResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneSuccessResponse;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneErrorResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneRawRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J&\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010$J&\u0010%\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010$J&\u0010&\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/impl/AuthPhoneEnterInteractorImpl;", "Lru/yoomoney/sdk/auth/phone/enter/impl/AuthPhoneEnterInteractor;", "Lru/yoomoney/sdk/auth/phone/enter/impl/BasePhoneEnterInteractorImpl;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "handleEnrollmentSetPhoneResponse", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "response", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneResponse;", "handleMigrationSetPhoneResponse", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneResponse;", "handlePhoneEnterRegistrationProcess", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "handleRegistrationSetPhoneProcess", "registrationConfirmPhone", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "action", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SetPhone;", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SetPhone;Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhoneEnrollment", "phone", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhoneMigration", "setPhoneRegistration", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthPhoneEnterInteractorImpl extends BasePhoneEnterInteractorImpl implements AuthPhoneEnterInteractor {
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
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl", f = "AuthPhoneEnterInteractor.kt", l = {55, 61}, m = "registrationConfirmPhone")
    public static final class a extends ContinuationImpl {
        public AuthPhoneEnterInteractorImpl a;
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
            return AuthPhoneEnterInteractorImpl.this.registrationConfirmPhone(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl", f = "AuthPhoneEnterInteractor.kt", l = {79, 86}, m = "setPhoneEnrollment")
    public static final class b extends ContinuationImpl {
        public AuthPhoneEnterInteractorImpl a;
        public String b;
        public CountryCallingCode c;
        public String d;
        public int e;
        public /* synthetic */ Object f;
        public int h;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return AuthPhoneEnterInteractorImpl.this.setPhoneEnrollment(null, null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl", f = "AuthPhoneEnterInteractor.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_DTLS6, 139}, m = "setPhoneMigration")
    public static final class c extends ContinuationImpl {
        public AuthPhoneEnterInteractorImpl a;
        public String b;
        public MigrationSetPhoneRawRequest c;
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
            return AuthPhoneEnterInteractorImpl.this.setPhoneMigration(null, null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl", f = "AuthPhoneEnterInteractor.kt", l = {104, 112}, m = "setPhoneRegistration")
    public static final class d extends ContinuationImpl {
        public AuthPhoneEnterInteractorImpl a;
        public String b;
        public CountryCallingCode c;
        public String d;
        public int e;
        public /* synthetic */ Object f;
        public int h;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return AuthPhoneEnterInteractorImpl.this.setPhoneRegistration(null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthPhoneEnterInteractorImpl(EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, MigrationRepository migrationRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        super(passwordRecoveryRepository, serverTimeRepository);
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.enrollmentRepository = enrollmentRepository;
        this.registrationV2Repository = registrationV2Repository;
        this.migrationRepository = migrationRepository;
    }

    private final PhoneEnter.Action handleEnrollmentSetPhoneResponse(EnrollmentSetPhoneResponse response) {
        if (response instanceof EnrollmentSetPhoneSuccessResponse) {
            return new PhoneEnter.Action.PhoneSetSuccess(((EnrollmentSetPhoneSuccessResponse) response).getProcess());
        }
        if (response instanceof EnrollmentSetPhoneErrorResponse) {
            return new PhoneEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((EnrollmentSetPhoneErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PhoneEnter.Action handleMigrationSetPhoneResponse(MigrationSetPhoneResponse response) {
        if (response instanceof MigrationSetPhoneSuccessResponse) {
            return new PhoneEnter.Action.PhoneSetSuccess(((MigrationSetPhoneSuccessResponse) response).getProcess());
        }
        if (response instanceof MigrationSetPhoneErrorResponse) {
            return new PhoneEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((MigrationSetPhoneErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PhoneEnter.Action handlePhoneEnterRegistrationProcess(RegistrationProcess process) {
        return process instanceof RegistrationProcess.Failure ? new PhoneEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((RegistrationProcess.Failure) process).getError())) : new PhoneEnter.Action.PhoneConfirmSuccess(process);
    }

    private final PhoneEnter.Action handleRegistrationSetPhoneProcess(RegistrationProcess process) {
        return process instanceof RegistrationProcess.Failure ? new PhoneEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((RegistrationProcess.Failure) process).getError())) : new PhoneEnter.Action.RegistrationPhoneSetSuccess(process);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c4 -> B:13:0x0036). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setPhoneEnrollment(java.lang.String r12, ru.yoomoney.sdk.auth.api.model.CountryCallingCode r13, java.lang.String r14, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.enter.PhoneEnter.Action> r15) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl.setPhoneEnrollment(java.lang.String, ru.yoomoney.sdk.auth.api.model.CountryCallingCode, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00b8 -> B:13:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setPhoneMigration(java.lang.String r10, ru.yoomoney.sdk.auth.api.model.CountryCallingCode r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.enter.PhoneEnter.Action> r13) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl.setPhoneMigration(java.lang.String, ru.yoomoney.sdk.auth.api.model.CountryCallingCode, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a9 -> B:13:0x0036). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setPhoneRegistration(java.lang.String r12, ru.yoomoney.sdk.auth.api.model.CountryCallingCode r13, java.lang.String r14, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.enter.PhoneEnter.Action> r15) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl.setPhoneRegistration(java.lang.String, ru.yoomoney.sdk.auth.api.model.CountryCallingCode, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008e -> B:34:0x0091). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.phone.enter.impl.BasePhoneEnterInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object registrationConfirmPhone(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.enter.PhoneEnter.Action> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl.a
            if (r0 == 0) goto L13
            r0 = r12
            ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl$a r0 = (ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl$a r0 = new ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl$a
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
            ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl r6 = r0.a
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
            ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl r6 = r0.a
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
            java.lang.Object r6 = r6.mo3296confirmPhonegIAlus(r11, r0)
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
            ru.yoomoney.sdk.auth.phone.enter.PhoneEnter$Action r11 = r6.handlePhoneEnterRegistrationProcess(r12)
            goto Lb0
        La3:
            ru.yoomoney.sdk.auth.phone.enter.PhoneEnter$Action$ShowFailure r12 = new ru.yoomoney.sdk.auth.phone.enter.PhoneEnter$Action$ShowFailure
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r11 = (ru.yoomoney.sdk.auth.api.model.Failure) r11
            r12.<init>(r11)
            r11 = r12
        Lb0:
            return r11
        Lb1:
            ru.yoomoney.sdk.auth.phone.enter.PhoneEnter$Action$ShowFailure r11 = new ru.yoomoney.sdk.auth.phone.enter.PhoneEnter$Action$ShowFailure
            ru.yoomoney.sdk.auth.api.model.TechnicalFailure r12 = new ru.yoomoney.sdk.auth.api.model.TechnicalFailure
            r12.<init>(r4, r5, r4)
            r11.<init>(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractorImpl.registrationConfirmPhone(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.phone.enter.impl.BasePhoneEnterInteractor
    public Object setPhone(PhoneEnter.Action.SetPhone setPhone, CountryCallingCode countryCallingCode, Continuation<? super PhoneEnter.Action> continuation) throws IOException {
        String phone = setPhone.getPhone();
        StringBuilder sb = new StringBuilder();
        int length = phone.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = phone.charAt(i);
            if (Character.isDigit(cCharAt) || cCharAt == '+') {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        int i2 = WhenMappings.$EnumSwitchMapping$0[setPhone.getProcessType().ordinal()];
        if (i2 == 1) {
            return setPhoneEnrollment(setPhone.getProcessId(), countryCallingCode, string, continuation);
        }
        if (i2 == 2) {
            return setPhoneRegistration(setPhone.getProcessId(), countryCallingCode, string, continuation);
        }
        if (i2 == 3) {
            return setPhoneMigration(setPhone.getProcessId(), countryCallingCode, string, continuation);
        }
        if (i2 == 4) {
            return setPhonePasswordRecovery(setPhone.getProcessId(), setPhone.getPhone(), continuation);
        }
        throw new IllegalArgumentException("no command for interaction " + this);
    }
}
