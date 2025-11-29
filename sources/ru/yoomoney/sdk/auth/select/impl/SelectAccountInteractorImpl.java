package ru.yoomoney.sdk.auth.select.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSuggestAccountContinueErrorResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSuggestAccountContinueResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSuggestAccountContinueSuccessResponse;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountErrorResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountSuccessResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.select.SelectAccount;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001eH\u0002J&\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0016J0\u0010\"\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%H\u0096@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010(J\"\u0010)\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lru/yoomoney/sdk/auth/select/impl/SelectAccountInteractorImpl;", "Lru/yoomoney/sdk/auth/select/impl/SelectAccountInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/auth/api/login/LoginRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;)V", "checkExpiration", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "uid", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/ProcessType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chooseAccount", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chooseAccountWhenPasswordRecovery", "handleEnrollmentSuggestAccountContinueResponse", "response", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSuggestAccountContinueResponse;", "handleLoginChooseAccountSuccessResponse", "Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountResponse;", "handleLoginSuccessResponse", "Lru/yoomoney/sdk/auth/api/login/method/LoginResponse;", "handleProcessType", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "setEmail", "prefilledEmail", "addToBackStack", "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmailEnrollment", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmailRegistration", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectAccountInteractorImpl implements SelectAccountInteractor {
    private final EnrollmentRepository enrollmentRepository;
    private final LoginRepository loginRepository;
    private final PasswordRecoveryRepository passwordRecoveryRepository;
    private final ServerTimeRepository serverTimeRepository;

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
                iArr[ProcessType.LOGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl", f = "SelectAccountInteractor.kt", l = {138, 144}, m = "chooseAccount")
    public static final class a extends ContinuationImpl {
        public SelectAccountInteractorImpl a;
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
            return SelectAccountInteractorImpl.this.chooseAccount(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl", f = "SelectAccountInteractor.kt", l = {159}, m = "chooseAccountWhenPasswordRecovery")
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
            return SelectAccountInteractorImpl.this.chooseAccountWhenPasswordRecovery(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl", f = "SelectAccountInteractor.kt", l = {128}, m = "login")
    public static final class c extends ContinuationImpl {
        public SelectAccountInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return SelectAccountInteractorImpl.this.login(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl", f = "SelectAccountInteractor.kt", l = {94, 99}, m = "setEmailEnrollment")
    public static final class d extends ContinuationImpl {
        public SelectAccountInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return SelectAccountInteractorImpl.this.setEmailEnrollment(null, this);
        }
    }

    public SelectAccountInteractorImpl(EnrollmentRepository enrollmentRepository, ServerTimeRepository serverTimeRepository, LoginRepository loginRepository, PasswordRecoveryRepository passwordRecoveryRepository) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        this.enrollmentRepository = enrollmentRepository;
        this.serverTimeRepository = serverTimeRepository;
        this.loginRepository = loginRepository;
        this.passwordRecoveryRepository = passwordRecoveryRepository;
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
    public final java.lang.Object chooseAccount(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.select.SelectAccount.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl.chooseAccount(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object chooseAccountWhenPasswordRecovery(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.select.SelectAccount.Action> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl$b
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
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository r7 = r4.passwordRecoveryRepository
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountRequest r2 = new ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountRequest
            r2.<init>(r6)
            r0.c = r3
            java.lang.Object r5 = r7.mo3286chooseAccount0E7RQCE(r5, r2, r0)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L5c
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountResponse r5 = (ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountResponse) r5
            ru.yoomoney.sdk.auth.select.SelectAccount$Action$PasswordRecoverySelectAccountSuccess r6 = new ru.yoomoney.sdk.auth.select.SelectAccount$Action$PasswordRecoverySelectAccountSuccess
            ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess r5 = r5.getProcess()
            r6.<init>(r5)
            goto L69
        L5c:
            ru.yoomoney.sdk.auth.select.SelectAccount$Action$ShowFailure r5 = new ru.yoomoney.sdk.auth.select.SelectAccount$Action$ShowFailure
            java.lang.String r7 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
            r6 = r5
        L69:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl.chooseAccountWhenPasswordRecovery(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SelectAccount.Action handleEnrollmentSuggestAccountContinueResponse(EnrollmentSuggestAccountContinueResponse response) {
        if (response instanceof EnrollmentSuggestAccountContinueSuccessResponse) {
            return new SelectAccount.Action.EnrollmentSuccess(((EnrollmentSuggestAccountContinueSuccessResponse) response).getProcess());
        }
        if (response instanceof EnrollmentSuggestAccountContinueErrorResponse) {
            return new SelectAccount.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((EnrollmentSuggestAccountContinueErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final SelectAccount.Action handleLoginChooseAccountSuccessResponse(LoginChooseAccountResponse response) {
        if (response instanceof LoginChooseAccountSuccessResponse) {
            return new SelectAccount.Action.SelectAccountSuccess(((LoginChooseAccountSuccessResponse) response).getProcess());
        }
        if (response instanceof LoginChooseAccountErrorResponse) {
            return new SelectAccount.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((LoginChooseAccountErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final SelectAccount.Action handleLoginSuccessResponse(LoginResponse response) {
        if (response instanceof LoginSuccessResponse) {
            return new SelectAccount.Action.SelectAccountSuccess(((LoginSuccessResponse) response).getProcess());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleProcessType(ProcessType processType, String str, String str2, Continuation<? super SelectAccount.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[processType.ordinal()];
        if (i == 1 || i == 2) {
            return login(str2, str, continuation);
        }
        if (i == 3) {
            return chooseAccount(str2, str, continuation);
        }
        if (i == 4) {
            return chooseAccountWhenPasswordRecovery(str2, str, continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object login(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.select.SelectAccount.Action> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl.c
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl$c r0 = (ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl$c r0 = new ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r6 = r7.getValue()
            goto L4f
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.login.LoginRepository r7 = r4.loginRepository
            ru.yoomoney.sdk.auth.api.login.method.LoginEnrollmentRequest r2 = new ru.yoomoney.sdk.auth.api.login.method.LoginEnrollmentRequest
            r2.<init>(r5, r6)
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r7.mo3270logingIAlus(r2, r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r5 = r4
        L4f:
            java.lang.Throwable r7 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r7 != 0) goto L5c
            ru.yoomoney.sdk.auth.api.login.method.LoginResponse r6 = (ru.yoomoney.sdk.auth.api.login.method.LoginResponse) r6
            ru.yoomoney.sdk.auth.select.SelectAccount$Action r5 = r5.handleLoginSuccessResponse(r6)
            goto L68
        L5c:
            ru.yoomoney.sdk.auth.select.SelectAccount$Action$ShowFailure r5 = new ru.yoomoney.sdk.auth.select.SelectAccount$Action$ShowFailure
            java.lang.String r6 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r6)
            ru.yoomoney.sdk.auth.api.model.Failure r7 = (ru.yoomoney.sdk.auth.api.model.Failure) r7
            r5.<init>(r7)
        L68:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl.login(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setEmailEnrollment(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.select.SelectAccount.Action> r12) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractorImpl.setEmailEnrollment(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SelectAccount.Action setEmailRegistration(String processId, String prefilledEmail, boolean addToBackStack) {
        return new SelectAccount.Action.RegistrationSuccess(new RegistrationProcess.SetEmail(processId, addToBackStack, prefilledEmail, null));
    }

    @Override // ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractor
    public Object checkExpiration(String str, OffsetDateTime offsetDateTime, String str2, ProcessType processType, Continuation<? super SelectAccount.Action> continuation) {
        return (offsetDateTime == null || !offsetDateTime.isBefore(this.serverTimeRepository.getCurrentDateTime())) ? handleProcessType(processType, str2, str, continuation) : SelectAccount.Action.Expired.INSTANCE;
    }

    @Override // ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractor
    public Object setEmail(ProcessType processType, String str, String str2, boolean z, Continuation<? super SelectAccount.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[processType.ordinal()];
        if (i == 1) {
            return setEmailEnrollment(str, continuation);
        }
        if (i == 2) {
            return setEmailRegistration(str, str2, z);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }
}
