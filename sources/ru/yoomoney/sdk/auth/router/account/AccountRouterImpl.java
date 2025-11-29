package ru.yoomoney.sdk.auth.router.account;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.account.model.ChangeEmailConfirmEmail;
import ru.yoomoney.sdk.auth.api.account.model.ChangeEmailConfirmPhone;
import ru.yoomoney.sdk.auth.api.account.model.ChangeEmailEnterPassword;
import ru.yoomoney.sdk.auth.api.account.model.ChangeEmailFailure;
import ru.yoomoney.sdk.auth.api.account.model.ChangeEmailProcess;
import ru.yoomoney.sdk.auth.api.account.model.ChangeEmailSetEmail;
import ru.yoomoney.sdk.auth.api.account.model.ChangeEmailSuccess;
import ru.yoomoney.sdk.auth.api.account.model.ChangePasswordConfirmEmail;
import ru.yoomoney.sdk.auth.api.account.model.ChangePasswordConfirmPhone;
import ru.yoomoney.sdk.auth.api.account.model.ChangePasswordEnterPassword;
import ru.yoomoney.sdk.auth.api.account.model.ChangePasswordFailure;
import ru.yoomoney.sdk.auth.api.account.model.ChangePasswordProcess;
import ru.yoomoney.sdk.auth.api.account.model.ChangePasswordSetPassword;
import ru.yoomoney.sdk.auth.api.account.model.ChangePasswordSuccess;
import ru.yoomoney.sdk.auth.api.account.model.ChangePhoneConfirmPhone;
import ru.yoomoney.sdk.auth.api.account.model.ChangePhoneFailure;
import ru.yoomoney.sdk.auth.api.account.model.ChangePhoneProcess;
import ru.yoomoney.sdk.auth.api.account.model.ChangePhoneSetPhone;
import ru.yoomoney.sdk.auth.api.account.model.ChangePhoneSuccess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessChooseAccount;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessEnterPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessFailure;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSetPassword;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSuccess;
import ru.yoomoney.sdk.auth.router.Router;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/router/account/AccountRouterImpl;", "Lru/yoomoney/sdk/auth/router/Router;", "()V", "homeId", "", "getHomeId$auth_release", "()I", "next", "process", "Lru/yoomoney/sdk/auth/api/Process;", "nextChangeEmail", "Lru/yoomoney/sdk/auth/api/account/model/ChangeEmailProcess;", "nextChangePassword", "Lru/yoomoney/sdk/auth/api/account/model/ChangePasswordProcess;", "nextChangePhone", "Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneProcess;", "nextPasswordRecovery", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "reset", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountRouterImpl extends Router {
    private final int homeId = R.id.passportProfileFragment;

    private final int nextChangeEmail(ChangeEmailProcess process) {
        if (process instanceof ChangeEmailConfirmPhone) {
            return R.id.phoneConfirmFragment;
        }
        if (process instanceof ChangeEmailEnterPassword) {
            return R.id.passwordEnterFragment;
        }
        if (process instanceof ChangeEmailConfirmEmail) {
            return R.id.emailConfirmFragment;
        }
        if (process instanceof ChangeEmailSetEmail) {
            return R.id.emailEnterFragment;
        }
        if (process instanceof ChangeEmailSuccess) {
            return getHomeId();
        }
        if (process instanceof ChangeEmailFailure) {
            return R.id.authFinishingFailureFragment;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int nextChangePassword(ChangePasswordProcess process) {
        if (process instanceof ChangePasswordConfirmEmail) {
            return R.id.emailConfirmFragment;
        }
        if (process instanceof ChangePasswordConfirmPhone) {
            return R.id.phoneConfirmFragment;
        }
        if (process instanceof ChangePasswordSetPassword) {
            return R.id.passwordCreateFragment;
        }
        if (process instanceof ChangePasswordEnterPassword) {
            return R.id.passwordEnterFragment;
        }
        if (process instanceof ChangePasswordSuccess) {
            return R.id.passwordFinishFragment;
        }
        if (process instanceof ChangePasswordFailure) {
            return R.id.authFinishingFailureFragment;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int nextChangePhone(ChangePhoneProcess process) {
        if (process instanceof ChangePhoneConfirmPhone) {
            return R.id.phoneConfirmFragment;
        }
        if (process instanceof ChangePhoneSetPhone) {
            return R.id.phoneEnterFragment;
        }
        if (process instanceof ChangePhoneSuccess) {
            return R.id.passportProfileFragment;
        }
        if (process instanceof ChangePhoneFailure) {
            return R.id.authFinishingFailureFragment;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int nextPasswordRecovery(PasswordRecoveryProcess process) {
        if (process instanceof PasswordRecoveryProcessConfirmPhone) {
            return R.id.phoneConfirmFragment;
        }
        if (process instanceof PasswordRecoveryProcessConfirmEmail) {
            return R.id.emailConfirmFragment;
        }
        if (process instanceof PasswordRecoveryProcessEnterPhone) {
            return R.id.phoneEnterFragment;
        }
        if (process instanceof PasswordRecoveryProcessChooseAccount) {
            return R.id.selectAccountFragment;
        }
        if (process instanceof PasswordRecoveryProcessSetPassword) {
            return R.id.passwordCreateFragment;
        }
        if (process instanceof PasswordRecoveryProcessSuccess) {
            return R.id.passwordFinishFragment;
        }
        if (process instanceof PasswordRecoveryProcessFailure) {
            return R.id.authFinishingFailureFragment;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.yoomoney.sdk.auth.router.Router
    /* renamed from: getHomeId$auth_release, reason: from getter */
    public int getHomeId() {
        return this.homeId;
    }

    @Override // ru.yoomoney.sdk.auth.router.Router
    public int next(Process process) {
        int iNextPasswordRecovery;
        Intrinsics.checkNotNullParameter(process, "process");
        if (process instanceof ChangeEmailProcess) {
            iNextPasswordRecovery = nextChangeEmail((ChangeEmailProcess) process);
        } else if (process instanceof ChangePhoneProcess) {
            iNextPasswordRecovery = nextChangePhone((ChangePhoneProcess) process);
        } else if (process instanceof ChangePasswordProcess) {
            iNextPasswordRecovery = nextChangePassword((ChangePasswordProcess) process);
        } else {
            if (!(process instanceof PasswordRecoveryProcess)) {
                throw new IllegalArgumentException("unknown process: " + process);
            }
            iNextPasswordRecovery = nextPasswordRecovery((PasswordRecoveryProcess) process);
        }
        setCurrentFragmentId$auth_release(iNextPasswordRecovery);
        if (process.getAddToBackStack()) {
            getBackStack$auth_release().push(Integer.valueOf(iNextPasswordRecovery));
        }
        return iNextPasswordRecovery;
    }

    @Override // ru.yoomoney.sdk.auth.router.Router
    public int reset() {
        getBackStack$auth_release().clear();
        return R.id.passportProfileFragment;
    }
}
