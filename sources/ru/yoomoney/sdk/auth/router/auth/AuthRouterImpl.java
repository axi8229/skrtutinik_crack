package ru.yoomoney.sdk.auth.router.auth;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessAcceptTerms;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessAcquireAuthorization;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessFailure;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessSetEmail;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessSetPassword;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessSetPhone;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessSuccess;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessSuggestAccount;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessAcquireAuthorization;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessChooseAccount;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessEnterIdentifier;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessEnterPassword;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessFailure;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessSuccess;
import ru.yoomoney.sdk.auth.api.migration.model.EmailInputSuggestions;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcess;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessAcquireAuthorization;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessFailure;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessSetEmail;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessSetPassword;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessSetPhone;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessSetYandexToken;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcessSuccess;
import ru.yoomoney.sdk.auth.api.migration.model.PhoneInputSuggestions;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidOauthSecret;
import ru.yoomoney.sdk.auth.api.model.ErrorOauthAccountNotConnected;
import ru.yoomoney.sdk.auth.api.model.NotNeedMigration;
import ru.yoomoney.sdk.auth.api.model.NotRegistered;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.model.Suggestion;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessChooseAccount;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessEnterPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessFailure;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSetPassword;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSuccess;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.router.Router;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0003J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0013H\u0017J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/router/auth/AuthRouterImpl;", "Lru/yoomoney/sdk/auth/router/Router;", "productType", "Lru/yoomoney/sdk/auth/Config$ProductType;", "(Lru/yoomoney/sdk/auth/Config$ProductType;)V", "handleLoginProcessFailure", "", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessFailure;", "handleMigrationProcessFailure", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessFailure;", "handleMigrationProcessSetEmail", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessSetEmail;", "handleMigrationProcessSetPhone", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessSetPhone;", "handlePasswordRecoveryProcessSuccess", "handleRegistrationProcessSetEmail", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$SetEmail;", "next", "Lru/yoomoney/sdk/auth/api/Process;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "nextEnrollment", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "nextLogin", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "nextMigration", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "nextPasswordRecovery", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "reset", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthRouterImpl extends Router {
    private final Config.ProductType productType;

    public AuthRouterImpl(Config.ProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.productType = productType;
    }

    private final int handleLoginProcessFailure(LoginProcessFailure process) {
        ProcessError error = process.getError();
        return error instanceof ErrorOauthAccountNotConnected ? R.id.oauthNotFoundFragment : error instanceof ErrorInvalidOauthSecret ? R.id.oauthFailureFragment : R.id.authFinishingFailureFragment;
    }

    private final int nextEnrollment(EnrollmentProcess process) {
        return process instanceof EnrollmentProcessSetPhone ? R.id.phoneEnterFragment : process instanceof EnrollmentProcessConfirmPhone ? R.id.phoneConfirmFragment : process instanceof EnrollmentProcessSetPassword ? R.id.passwordCreateFragment : process instanceof EnrollmentProcessSetEmail ? R.id.emailEnterFragment : process instanceof EnrollmentProcessConfirmEmail ? R.id.emailConfirmFragment : process instanceof EnrollmentProcessSuggestAccount ? R.id.selectAccountFragment : ((process instanceof EnrollmentProcessAcquireAuthorization) || (process instanceof EnrollmentProcessSuccess)) ? R.id.authFinishingSuccessFragment : (!(process instanceof EnrollmentProcessFailure) && (process instanceof EnrollmentProcessAcceptTerms)) ? R.id.acceptTermsFragment : R.id.authFinishingFailureFragment;
    }

    private final int nextLogin(LoginProcess process) {
        return process instanceof LoginProcessEnterIdentifier ? R.id.loginEnterFragment : process instanceof LoginProcessConfirmPhone ? R.id.phoneConfirmFragment : process instanceof LoginProcessConfirmEmail ? R.id.emailConfirmFragment : process instanceof LoginProcessChooseAccount ? R.id.selectAccountFragment : process instanceof LoginProcessEnterPassword ? R.id.passwordEnterFragment : ((process instanceof LoginProcessAcquireAuthorization) || (process instanceof LoginProcessSuccess)) ? R.id.authFinishingSuccessFragment : process instanceof LoginProcessFailure ? handleLoginProcessFailure((LoginProcessFailure) process) : R.id.authFinishingFailureFragment;
    }

    private final int nextMigration(MigrationProcess process) {
        if (process instanceof MigrationProcessSetPhone) {
            return handleMigrationProcessSetPhone((MigrationProcessSetPhone) process);
        }
        if (process instanceof MigrationProcessConfirmPhone) {
            return R.id.phoneConfirmFragment;
        }
        if (process instanceof MigrationProcessSetPassword) {
            return R.id.passwordCreateFragment;
        }
        if (process instanceof MigrationProcessSetEmail) {
            return handleMigrationProcessSetEmail((MigrationProcessSetEmail) process);
        }
        if (process instanceof MigrationProcessConfirmEmail) {
            return R.id.emailConfirmFragment;
        }
        if (process instanceof MigrationProcessSetYandexToken) {
            return R.id.yandexAcquireWebViewFragment;
        }
        if ((process instanceof MigrationProcessAcquireAuthorization) || (process instanceof MigrationProcessSuccess)) {
            return R.id.authFinishingSuccessFragment;
        }
        if (process instanceof MigrationProcessFailure) {
            return handleMigrationProcessFailure((MigrationProcessFailure) process);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int nextPasswordRecovery(PasswordRecoveryProcess process) {
        if (process instanceof PasswordRecoveryProcessEnterPhone) {
            return R.id.phoneEnterFragment;
        }
        if (process instanceof PasswordRecoveryProcessChooseAccount) {
            return R.id.selectAccountFragment;
        }
        if (process instanceof PasswordRecoveryProcessConfirmPhone) {
            return R.id.phoneConfirmFragment;
        }
        if (process instanceof PasswordRecoveryProcessConfirmEmail) {
            return R.id.emailConfirmFragment;
        }
        if (process instanceof PasswordRecoveryProcessSetPassword) {
            return R.id.passwordCreateFragment;
        }
        if (process instanceof PasswordRecoveryProcessFailure) {
            return R.id.authFinishingFailureFragment;
        }
        if (process instanceof PasswordRecoveryProcessSuccess) {
            return handlePasswordRecoveryProcessSuccess();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int handleMigrationProcessFailure(MigrationProcessFailure process) {
        Intrinsics.checkNotNullParameter(process, "process");
        ProcessError error = process.getError();
        return Intrinsics.areEqual(error, NotNeedMigration.INSTANCE) ? R.id.yandexAcquireLoginFragment : Intrinsics.areEqual(error, NotRegistered.INSTANCE) ? R.id.yandexAcquireRegistrationFragment : R.id.authFinishingFailureFragment;
    }

    public final int handleMigrationProcessSetEmail(MigrationProcessSetEmail process) {
        List<Suggestion> items;
        Intrinsics.checkNotNullParameter(process, "process");
        EmailInputSuggestions suggestion = process.getInputType().getSuggestion();
        return (suggestion == null || (items = suggestion.getItems()) == null || items.isEmpty()) ? R.id.emailEnterFragment : R.id.emailSelectFragment;
    }

    public final int handleMigrationProcessSetPhone(MigrationProcessSetPhone process) {
        List<Suggestion> items;
        Intrinsics.checkNotNullParameter(process, "process");
        PhoneInputSuggestions suggestion = process.getInputType().getSuggestion();
        return (suggestion == null || (items = suggestion.getItems()) == null || items.isEmpty()) ? R.id.phoneEnterFragment : R.id.phoneSelectFragment;
    }

    public final int handlePasswordRecoveryProcessSuccess() {
        return this.productType == Config.ProductType.WEBBANKIR ? R.id.passwordFinishFragment : R.id.loginEnterFragment;
    }

    public final int handleRegistrationProcessSetEmail(RegistrationProcess.SetEmail process) {
        Intrinsics.checkNotNullParameter(process, "process");
        List<Account> accounts = process.getAccounts();
        if (accounts == null || accounts.isEmpty()) {
            return R.id.emailEnterFragment;
        }
        int i = R.id.selectAccountFragment;
        getBackStack$auth_release().push(Integer.valueOf(i));
        return i;
    }

    @Override // ru.yoomoney.sdk.auth.router.Router
    public int next(Process process) {
        int iNextPasswordRecovery;
        Intrinsics.checkNotNullParameter(process, "process");
        if (process instanceof EnrollmentProcess) {
            iNextPasswordRecovery = nextEnrollment((EnrollmentProcess) process);
        } else if (process instanceof LoginProcess) {
            iNextPasswordRecovery = nextLogin((LoginProcess) process);
        } else if (process instanceof MigrationProcess) {
            iNextPasswordRecovery = nextMigration((MigrationProcess) process);
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
        return R.id.authLoadingFragment;
    }

    @Override // ru.yoomoney.sdk.auth.router.Router
    public int next(RegistrationProcess process) {
        int iHandleRegistrationProcessSetEmail;
        Intrinsics.checkNotNullParameter(process, "process");
        if (process instanceof RegistrationProcess.SetEmail) {
            iHandleRegistrationProcessSetEmail = handleRegistrationProcessSetEmail((RegistrationProcess.SetEmail) process);
        } else if (process instanceof RegistrationProcess.SetPassword) {
            iHandleRegistrationProcessSetEmail = R.id.passwordCreateFragment;
        } else if (process instanceof RegistrationProcess.SetPhone) {
            iHandleRegistrationProcessSetEmail = R.id.phoneEnterFragment;
        } else if ((process instanceof RegistrationProcess.AcquireAuthorization) || (process instanceof RegistrationProcess.Success)) {
            iHandleRegistrationProcessSetEmail = R.id.authFinishingSuccessFragment;
        } else {
            if (!(process instanceof RegistrationProcess.Failure)) {
                throw new IllegalArgumentException("unsupported process: " + process);
            }
            iHandleRegistrationProcessSetEmail = R.id.authFinishingFailureFragment;
        }
        setCurrentFragmentId$auth_release(iHandleRegistrationProcessSetEmail);
        if (process.getAddToBackStack()) {
            getBackStack$auth_release().push(Integer.valueOf(iHandleRegistrationProcessSetEmail));
        }
        return iHandleRegistrationProcessSetEmail;
    }
}
