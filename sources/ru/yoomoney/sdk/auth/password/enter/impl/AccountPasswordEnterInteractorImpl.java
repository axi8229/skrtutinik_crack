package ru.yoomoney.sdk.auth.password.enter.impl;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordErrorResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordSuccessResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordErrorResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/impl/AccountPasswordEnterInteractorImpl;", "Lru/yoomoney/sdk/auth/password/enter/impl/AccountPasswordEnterInteractor;", "Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractorImpl;", "emailChangeRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "passwordChangeRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "(Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/auth/api/Origin;Lru/yoomoney/sdk/yooprofiler/YooProfiler;)V", "enterPassword", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;", "action", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$Submit;", "(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$Submit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPasswordChangeEmail", "password", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPasswordChangePassword", "handleEmailChangeEnterPasswordResponse", "result", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordResponse;", "handlePasswordChangeEnterPasswordResponse", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordResponse;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountPasswordEnterInteractorImpl extends BasePasswordEnterInteractorImpl implements AccountPasswordEnterInteractor {
    private final EmailChangeRepository emailChangeRepository;
    private final PasswordChangeRepository passwordChangeRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.CHANGE_EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.CHANGE_PASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.password.enter.impl.AccountPasswordEnterInteractorImpl", f = "AccountPasswordEnterInteractor.kt", l = {55, 62}, m = "enterPasswordChangeEmail")
    public static final class a extends ContinuationImpl {
        public AccountPasswordEnterInteractorImpl a;
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
            return AccountPasswordEnterInteractorImpl.this.enterPasswordChangeEmail(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.password.enter.impl.AccountPasswordEnterInteractorImpl", f = "AccountPasswordEnterInteractor.kt", l = {76, 83}, m = "enterPasswordChangePassword")
    public static final class b extends ContinuationImpl {
        public AccountPasswordEnterInteractorImpl a;
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
            return AccountPasswordEnterInteractorImpl.this.enterPasswordChangePassword(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountPasswordEnterInteractorImpl(EmailChangeRepository emailChangeRepository, PasswordChangeRepository passwordChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository, Origin origin, YooProfiler profiler) {
        super(passwordRecoveryRepository, serverTimeRepository, origin, profiler);
        Intrinsics.checkNotNullParameter(emailChangeRepository, "emailChangeRepository");
        Intrinsics.checkNotNullParameter(passwordChangeRepository, "passwordChangeRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        this.emailChangeRepository = emailChangeRepository;
        this.passwordChangeRepository = passwordChangeRepository;
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
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enterPasswordChangeEmail(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.password.enter.PasswordEnter.Action> r13) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.password.enter.impl.AccountPasswordEnterInteractorImpl.enterPasswordChangeEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enterPasswordChangePassword(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.password.enter.PasswordEnter.Action> r13) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.password.enter.impl.AccountPasswordEnterInteractorImpl.enterPasswordChangePassword(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PasswordEnter.Action handleEmailChangeEnterPasswordResponse(EmailChangeEnterPasswordResponse result) {
        if (result instanceof EmailChangeEnterPasswordSuccessResponse) {
            return new PasswordEnter.Action.EnterPasswordSuccess(((EmailChangeEnterPasswordSuccessResponse) result).getProcess());
        }
        if (result instanceof EmailChangeEnterPasswordErrorResponse) {
            return handlePasswordEnterFailure(ProcessErrorExtensionsKt.toFailure(((EmailChangeEnterPasswordErrorResponse) result).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PasswordEnter.Action handlePasswordChangeEnterPasswordResponse(PasswordChangeEnterPasswordResponse result) {
        if (result instanceof PasswordChangeEnterPasswordSuccessResponse) {
            return new PasswordEnter.Action.EnterPasswordSuccess(((PasswordChangeEnterPasswordSuccessResponse) result).getProcess());
        }
        if (result instanceof PasswordChangeEnterPasswordErrorResponse) {
            return handlePasswordEnterFailure(ProcessErrorExtensionsKt.toFailure(((PasswordChangeEnterPasswordErrorResponse) result).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractor
    public Object enterPassword(PasswordEnter.Action.Submit submit, Continuation<? super PasswordEnter.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[submit.getProcessType().ordinal()];
        if (i == 1) {
            return enterPasswordChangeEmail(submit.getPassword(), submit.getProcessId(), continuation);
        }
        if (i == 2) {
            return enterPasswordChangePassword(submit.getPassword(), submit.getProcessId(), continuation);
        }
        if (i == 3) {
            return recoverPassword(continuation);
        }
        throw new IllegalArgumentException("no command for interaction " + this);
    }
}
