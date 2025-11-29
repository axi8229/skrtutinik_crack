package ru.yoomoney.sdk.auth.router.account;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.google.android.gms.common.Scopes;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessKt;
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
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessChooseAccount;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessEnterPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessFailure;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSetPassword;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSuccess;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/router/account/AccountProcessMapperImpl;", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "()V", "fromChangeEmail", "Landroid/os/Bundle;", "process", "Lru/yoomoney/sdk/auth/api/account/model/ChangeEmailProcess;", "fromChangePassword", "Lru/yoomoney/sdk/auth/api/account/model/ChangePasswordProcess;", "fromChangePhone", "Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneProcess;", "fromPasswordRecovery", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "toBundle", "Lru/yoomoney/sdk/auth/api/Process;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountProcessMapperImpl implements ProcessMapper {
    private final Bundle fromChangeEmail(ChangeEmailProcess process) {
        if (process instanceof ChangeEmailConfirmEmail) {
            ChangeEmailConfirmEmail changeEmailConfirmEmail = (ChangeEmailConfirmEmail) process;
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(changeEmailConfirmEmail.getSecretLength())), TuplesKt.to("nextResendFrom", changeEmailConfirmEmail.getNextResendFrom()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to(Scopes.EMAIL, changeEmailConfirmEmail.getEmail()), TuplesKt.to("isCurrentUserAccountEmail", Boolean.valueOf(changeEmailConfirmEmail.isCurrentUserAccountEmail())));
        }
        if (!(process instanceof ChangeEmailConfirmPhone)) {
            return process instanceof ChangeEmailEnterPassword ? BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("account", null), TuplesKt.to("expireAt", process.getExpireAt())) : process instanceof ChangeEmailSetEmail ? BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt())) : process instanceof ChangeEmailSuccess ? BundleKt.bundleOf(TuplesKt.to("account", ((ChangeEmailSuccess) process).getAccount()), TuplesKt.to("processTypeCode", Integer.valueOf(ProcessKt.toProcessType(process).ordinal()))) : process instanceof ChangeEmailFailure ? BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("processError", ((ChangeEmailFailure) process).getError())) : BundleKt.bundleOf(TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        ChangeEmailConfirmPhone changeEmailConfirmPhone = (ChangeEmailConfirmPhone) process;
        return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(changeEmailConfirmPhone.getSecretLength())), TuplesKt.to("nextResendFrom", changeEmailConfirmPhone.getNextResendFrom()), TuplesKt.to("phone", changeEmailConfirmPhone.getPhone()), TuplesKt.to("expireAt", process.getExpireAt()));
    }

    private final Bundle fromChangePassword(ChangePasswordProcess process) {
        if (process instanceof ChangePasswordConfirmEmail) {
            ChangePasswordConfirmEmail changePasswordConfirmEmail = (ChangePasswordConfirmEmail) process;
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(changePasswordConfirmEmail.getSecretLength())), TuplesKt.to("nextResendFrom", changePasswordConfirmEmail.getNextResendFrom()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to(Scopes.EMAIL, changePasswordConfirmEmail.getEmail()));
        }
        if (!(process instanceof ChangePasswordConfirmPhone)) {
            return process instanceof ChangePasswordSetPassword ? BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt())) : process instanceof ChangePasswordEnterPassword ? BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("account", null), TuplesKt.to("expireAt", process.getExpireAt())) : process instanceof ChangePasswordSuccess ? BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("account", ((ChangePasswordSuccess) process).getAccount()), TuplesKt.to("processTypeCode", Integer.valueOf(ProcessKt.toProcessType(process).ordinal()))) : process instanceof ChangePasswordFailure ? BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("processError", ((ChangePasswordFailure) process).getError())) : BundleKt.bundleOf(TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        ChangePasswordConfirmPhone changePasswordConfirmPhone = (ChangePasswordConfirmPhone) process;
        return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(changePasswordConfirmPhone.getSecretLength())), TuplesKt.to("nextResendFrom", changePasswordConfirmPhone.getNextResendFrom()), TuplesKt.to("phone", changePasswordConfirmPhone.getPhone()), TuplesKt.to("expireAt", process.getExpireAt()));
    }

    private final Bundle fromChangePhone(ChangePhoneProcess process) {
        if (process instanceof ChangePhoneConfirmPhone) {
            ChangePhoneConfirmPhone changePhoneConfirmPhone = (ChangePhoneConfirmPhone) process;
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(changePhoneConfirmPhone.getSecretLength())), TuplesKt.to("nextResendFrom", changePhoneConfirmPhone.getNextResendFrom()), TuplesKt.to("phone", changePhoneConfirmPhone.getPhone()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (!(process instanceof ChangePhoneSetPhone)) {
            return process instanceof ChangePhoneSuccess ? BundleKt.bundleOf(TuplesKt.to("account", ((ChangePhoneSuccess) process).getAccount()), TuplesKt.to("processTypeCode", Integer.valueOf(ProcessKt.toProcessType(process).ordinal()))) : process instanceof ChangePhoneFailure ? BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("processError", ((ChangePhoneFailure) process).getError())) : BundleKt.bundleOf(TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        List<CountryCallingCode> countryCallingCodes = ((ChangePhoneSetPhone) process).getCountryCallingCodes();
        return BundleKt.bundleOf(TuplesKt.to("countryCodes", countryCallingCodes != null ? (CountryCallingCode[]) countryCallingCodes.toArray(new CountryCallingCode[0]) : null), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
    }

    private final Bundle fromPasswordRecovery(PasswordRecoveryProcess process) {
        if (process instanceof PasswordRecoveryProcessEnterPhone) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("countryCodes", new CountryCallingCode[0]), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof PasswordRecoveryProcessChooseAccount) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("accounts", ((PasswordRecoveryProcessChooseAccount) process).getAccounts().toArray(new Account[0])), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof PasswordRecoveryProcessConfirmPhone) {
            PasswordRecoveryProcessConfirmPhone passwordRecoveryProcessConfirmPhone = (PasswordRecoveryProcessConfirmPhone) process;
            return BundleKt.bundleOf(TuplesKt.to("secretLength", Integer.valueOf(passwordRecoveryProcessConfirmPhone.getSecretLength())), TuplesKt.to("nextResendFrom", passwordRecoveryProcessConfirmPhone.getNextResendFrom()), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("phone", passwordRecoveryProcessConfirmPhone.getPhone()), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof PasswordRecoveryProcessConfirmEmail) {
            PasswordRecoveryProcessConfirmEmail passwordRecoveryProcessConfirmEmail = (PasswordRecoveryProcessConfirmEmail) process;
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(passwordRecoveryProcessConfirmEmail.getSecretLength())), TuplesKt.to("nextResendFrom", passwordRecoveryProcessConfirmEmail.getNextResendFrom()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to(Scopes.EMAIL, passwordRecoveryProcessConfirmEmail.getEmail()));
        }
        if (process instanceof PasswordRecoveryProcessSetPassword) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to("isEmailSet", Boolean.FALSE));
        }
        if (process instanceof PasswordRecoveryProcessFailure) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("processError", ((PasswordRecoveryProcessFailure) process).getError()));
        }
        if (process instanceof PasswordRecoveryProcessSuccess) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to("passwordRecoverySuccess", Boolean.TRUE));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.yoomoney.sdk.auth.router.ProcessMapper
    public Bundle toBundle(Process process) {
        Intrinsics.checkNotNullParameter(process, "process");
        if (process instanceof ChangeEmailProcess) {
            return fromChangeEmail((ChangeEmailProcess) process);
        }
        if (process instanceof ChangePhoneProcess) {
            return fromChangePhone((ChangePhoneProcess) process);
        }
        if (process instanceof ChangePasswordProcess) {
            return fromChangePassword((ChangePasswordProcess) process);
        }
        if (process instanceof PasswordRecoveryProcess) {
            return fromPasswordRecovery((PasswordRecoveryProcess) process);
        }
        throw new IllegalArgumentException("unknown process: " + process);
    }

    @Override // ru.yoomoney.sdk.auth.router.ProcessMapper
    public Bundle toBundle(RegistrationProcess registrationProcess) {
        return ProcessMapper.DefaultImpls.toBundle(this, registrationProcess);
    }
}
