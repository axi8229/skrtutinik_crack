package ru.yoomoney.sdk.auth.password.create.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordErrorResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordSuccessResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/impl/AccountPasswordCreateInteractorImpl;", "Lru/yoomoney/sdk/auth/password/create/impl/AccountPasswordCreateInteractor;", "Lru/yoomoney/sdk/auth/password/create/impl/BasePasswordCreateInteractorImpl;", "passwordChangeRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "changePassword", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "password", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePasswordChangeSetPasswordResponse", "response", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordResponse;", "submitPassword", "action", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$Submit;", "(Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$Submit;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountPasswordCreateInteractorImpl extends BasePasswordCreateInteractorImpl implements AccountPasswordCreateInteractor {
    private final PasswordChangeRepository passwordChangeRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.CHANGE_PASSWORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.password.create.impl.AccountPasswordCreateInteractorImpl", f = "AccountPasswordCreateInteractor.kt", l = {45, 52}, m = "changePassword")
    public static final class a extends ContinuationImpl {
        public AccountPasswordCreateInteractorImpl a;
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
            return AccountPasswordCreateInteractorImpl.this.changePassword(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountPasswordCreateInteractorImpl(PasswordChangeRepository passwordChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        super(passwordRecoveryRepository, serverTimeRepository);
        Intrinsics.checkNotNullParameter(passwordChangeRepository, "passwordChangeRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
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
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePassword(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.password.create.PasswordCreate.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.password.create.impl.AccountPasswordCreateInteractorImpl.changePassword(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PasswordCreate.Action handlePasswordChangeSetPasswordResponse(PasswordChangeSetPasswordResponse response) {
        if (response instanceof PasswordChangeSetPasswordSuccessResponse) {
            return new PasswordCreate.Action.SetPasswordSuccess(((PasswordChangeSetPasswordSuccessResponse) response).getProcess());
        }
        if (response instanceof PasswordChangeSetPasswordErrorResponse) {
            return new PasswordCreate.Action.SetPasswordFail(((PasswordChangeSetPasswordErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.yoomoney.sdk.auth.password.create.impl.BasePasswordCreateInteractor
    public Object submitPassword(PasswordCreate.Action.Submit submit, String str, Continuation<? super PasswordCreate.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[submit.getProcessType().ordinal()];
        if (i == 1) {
            return changePassword(str, submit.getProcessId(), continuation);
        }
        if (i == 2) {
            return recoverPassword(submit.getProcessId(), str, continuation);
        }
        throw new IllegalArgumentException("no command for interaction " + this);
    }
}
