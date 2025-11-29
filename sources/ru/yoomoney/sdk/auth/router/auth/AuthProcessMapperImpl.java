package ru.yoomoney.sdk.auth.router.auth;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.google.android.gms.common.Scopes;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessKt;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessAcceptTerms;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessAcquireAuthorization;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessFailure;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessForceLogin;
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
import ru.yoomoney.sdk.auth.api.migration.model.PhoneInputRaw;
import ru.yoomoney.sdk.auth.api.migration.model.PhoneInputSuggestions;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.api.model.Suggestion;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessChooseAccount;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessEnterPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessFailure;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSetPassword;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSuccess;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.PrefilledPhone;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/router/auth/AuthProcessMapperImpl;", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "()V", "fromEnrollment", "Landroid/os/Bundle;", "process", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "fromLogin", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "fromMigration", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "fromPasswordRecovery", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "toBundle", "Lru/yoomoney/sdk/auth/api/Process;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthProcessMapperImpl implements ProcessMapper {
    private final Bundle fromEnrollment(EnrollmentProcess process) {
        if (process instanceof EnrollmentProcessSetPhone) {
            EnrollmentProcessSetPhone enrollmentProcessSetPhone = (EnrollmentProcessSetPhone) process;
            return BundleKt.bundleOf(TuplesKt.to("countryCodes", enrollmentProcessSetPhone.getCountryCallingCodes().toArray(new CountryCallingCode[0])), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to("prefilledPhone", enrollmentProcessSetPhone.getPrefilledPhone()));
        }
        if (process instanceof EnrollmentProcessConfirmPhone) {
            EnrollmentProcessConfirmPhone enrollmentProcessConfirmPhone = (EnrollmentProcessConfirmPhone) process;
            return BundleKt.bundleOf(TuplesKt.to("secretLength", Integer.valueOf(enrollmentProcessConfirmPhone.getSecretLength())), TuplesKt.to("nextResendFrom", enrollmentProcessConfirmPhone.getNextResendFrom()), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("phone", enrollmentProcessConfirmPhone.getPhone()), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof EnrollmentProcessConfirmEmail) {
            EnrollmentProcessConfirmEmail enrollmentProcessConfirmEmail = (EnrollmentProcessConfirmEmail) process;
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(enrollmentProcessConfirmEmail.getSecretLength())), TuplesKt.to("nextResendFrom", enrollmentProcessConfirmEmail.getNextResendFrom()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to(Scopes.EMAIL, enrollmentProcessConfirmEmail.getEmail()));
        }
        if (process instanceof EnrollmentProcessSuggestAccount) {
            return BundleKt.bundleOf(TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("accounts", ((EnrollmentProcessSuggestAccount) process).getAccounts().toArray(new Account[0])), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof EnrollmentProcessSetPassword) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to("isEmailSet", Boolean.valueOf(((EnrollmentProcessSetPassword) process).isEmailSet())));
        }
        if (process instanceof EnrollmentProcessSetEmail) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to("prefilledEmail", ((EnrollmentProcessSetEmail) process).getPrefilledEmail()));
        }
        if (process instanceof EnrollmentProcessAcquireAuthorization) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()));
        }
        if (process instanceof EnrollmentProcessSuccess) {
            EnrollmentProcessSuccess enrollmentProcessSuccess = (EnrollmentProcessSuccess) process;
            return BundleKt.bundleOf(TuplesKt.to(YooMoneyAuth.KEY_ACCESS_TOKEN, enrollmentProcessSuccess.getAccessToken()), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("bindSocialAccountResult", enrollmentProcessSuccess.getBindSocialAccountResult()));
        }
        if (process instanceof EnrollmentProcessFailure) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("processError", ((EnrollmentProcessFailure) process).getError()));
        }
        if (process instanceof EnrollmentProcessForceLogin) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to("uid", ((EnrollmentProcessForceLogin) process).getUid()));
        }
        if (process instanceof EnrollmentProcessAcceptTerms) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Bundle fromLogin(LoginProcess process) {
        if (process instanceof LoginProcessEnterIdentifier) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof LoginProcessConfirmPhone) {
            LoginProcessConfirmPhone loginProcessConfirmPhone = (LoginProcessConfirmPhone) process;
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(loginProcessConfirmPhone.getSecretLength())), TuplesKt.to("nextResendFrom", loginProcessConfirmPhone.getNextResendFrom()), TuplesKt.to("phone", loginProcessConfirmPhone.getPhone()), TuplesKt.to("nextResendFrom", loginProcessConfirmPhone.getNextResendFrom()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof LoginProcessConfirmEmail) {
            LoginProcessConfirmEmail loginProcessConfirmEmail = (LoginProcessConfirmEmail) process;
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(loginProcessConfirmEmail.getSecretLength())), TuplesKt.to("nextResendFrom", loginProcessConfirmEmail.getNextResendFrom()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof LoginProcessEnterPassword) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("account", ((LoginProcessEnterPassword) process).getAccount()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof LoginProcessChooseAccount) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("accounts", ((LoginProcessChooseAccount) process).getAccounts().toArray(new Account[0])), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof LoginProcessAcquireAuthorization) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("applicationInfo", ((LoginProcessAcquireAuthorization) process).getApplicationInfo()));
        }
        if (!(process instanceof LoginProcessSuccess)) {
            return process instanceof LoginProcessFailure ? BundleKt.bundleOf(TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("processError", ((LoginProcessFailure) process).getError())) : BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        Pair pair = TuplesKt.to("processType", ProcessKt.toProcessType(process));
        Pair pair2 = TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId());
        LoginProcessSuccess loginProcessSuccess = (LoginProcessSuccess) process;
        return BundleKt.bundleOf(pair, pair2, TuplesKt.to(YooMoneyAuth.KEY_ACCESS_TOKEN, loginProcessSuccess.getAccessToken()), TuplesKt.to("bindSocialAccountResult", loginProcessSuccess.getBindSocialAccountResult()));
    }

    private final Bundle fromMigration(MigrationProcess process) {
        List<Suggestion> listEmptyList;
        List<Suggestion> items;
        List<CountryCallingCode> countryCallingCodes;
        if (process instanceof MigrationProcessSetPhone) {
            MigrationProcessSetPhone migrationProcessSetPhone = (MigrationProcessSetPhone) process;
            PhoneInputRaw raw = migrationProcessSetPhone.getInputType().getRaw();
            Suggestion[] suggestionArr = null;
            Pair pair = TuplesKt.to("countryCodes", (raw == null || (countryCallingCodes = raw.getCountryCallingCodes()) == null) ? null : (CountryCallingCode[]) countryCallingCodes.toArray(new CountryCallingCode[0]));
            PhoneInputSuggestions suggestion = migrationProcessSetPhone.getInputType().getSuggestion();
            if (suggestion != null && (items = suggestion.getItems()) != null) {
                suggestionArr = (Suggestion[]) items.toArray(new Suggestion[0]);
            }
            return BundleKt.bundleOf(pair, TuplesKt.to("suggestions", suggestionArr), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof MigrationProcessConfirmPhone) {
            MigrationProcessConfirmPhone migrationProcessConfirmPhone = (MigrationProcessConfirmPhone) process;
            return BundleKt.bundleOf(TuplesKt.to("secretLength", Integer.valueOf(migrationProcessConfirmPhone.getSecretLength())), TuplesKt.to("nextResendFrom", migrationProcessConfirmPhone.getNextResendFrom()), TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("phone", migrationProcessConfirmPhone.getPhone()), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof MigrationProcessSetPassword) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()), TuplesKt.to("isEmailSet", Boolean.valueOf(((MigrationProcessSetPassword) process).isEmailSet())));
        }
        if (process instanceof MigrationProcessConfirmEmail) {
            MigrationProcessConfirmEmail migrationProcessConfirmEmail = (MigrationProcessConfirmEmail) process;
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("secretLength", Integer.valueOf(migrationProcessConfirmEmail.getSecretLength())), TuplesKt.to("nextResendFrom", migrationProcessConfirmEmail.getNextResendFrom()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof MigrationProcessSetEmail) {
            Pair pair2 = TuplesKt.to("processType", ProcessKt.toProcessType(process));
            Pair pair3 = TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId());
            EmailInputSuggestions suggestion2 = ((MigrationProcessSetEmail) process).getInputType().getSuggestion();
            if (suggestion2 == null || (listEmptyList = suggestion2.getItems()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return BundleKt.bundleOf(pair2, pair3, TuplesKt.to("suggestions", listEmptyList.toArray(new Suggestion[0])), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof MigrationProcessSuccess) {
            MigrationProcessSuccess migrationProcessSuccess = (MigrationProcessSuccess) process;
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to(YooMoneyAuth.KEY_ACCESS_TOKEN, migrationProcessSuccess.getAccessToken()), TuplesKt.to("bindSocialAccountResult", migrationProcessSuccess.getBindSocialAccountResult()));
        }
        if (process instanceof MigrationProcessAcquireAuthorization) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("applicationInfo", ((MigrationProcessAcquireAuthorization) process).getApplicationInfo()));
        }
        if (process instanceof MigrationProcessSetYandexToken) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("expireAt", process.getExpireAt()));
        }
        if (process instanceof MigrationProcessFailure) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessKt.toProcessType(process)), TuplesKt.to("processError", ((MigrationProcessFailure) process).getError()));
        }
        throw new NoWhenBranchMatchedException();
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
        if (process instanceof EnrollmentProcess) {
            return fromEnrollment((EnrollmentProcess) process);
        }
        if (process instanceof LoginProcess) {
            return fromLogin((LoginProcess) process);
        }
        if (process instanceof MigrationProcess) {
            return fromMigration((MigrationProcess) process);
        }
        if (process instanceof PasswordRecoveryProcess) {
            return fromPasswordRecovery((PasswordRecoveryProcess) process);
        }
        throw new IllegalArgumentException("unknown process: " + process);
    }

    @Override // ru.yoomoney.sdk.auth.router.ProcessMapper
    public Bundle toBundle(RegistrationProcess process) {
        Intrinsics.checkNotNullParameter(process, "process");
        if (process instanceof RegistrationProcess.SetEmail) {
            Pair pair = TuplesKt.to("processType", ProcessType.REGISTRATION);
            Pair pair2 = TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId());
            RegistrationProcess.SetEmail setEmail = (RegistrationProcess.SetEmail) process;
            List<Account> accounts = setEmail.getAccounts();
            return BundleKt.bundleOf(pair, pair2, TuplesKt.to("accounts", accounts != null ? (Account[]) accounts.toArray(new Account[0]) : null), TuplesKt.to("prefilledEmail", setEmail.getPrefilledEmail()), TuplesKt.to("isAddedToBackstack", Boolean.valueOf(process.getAddToBackStack())));
        }
        if (process instanceof RegistrationProcess.SetPassword) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessType.REGISTRATION), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("isEmailSet", Boolean.TRUE));
        }
        if (process instanceof RegistrationProcess.SetPhone) {
            Pair pair3 = TuplesKt.to("processType", ProcessType.REGISTRATION);
            Pair pair4 = TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId());
            RegistrationProcess.SetPhone setPhone = (RegistrationProcess.SetPhone) process;
            Pair pair5 = TuplesKt.to("countryCodes", setPhone.getCountryCallingCodes().toArray(new CountryCallingCode[0]));
            PrefilledPhone prefilledPhone = setPhone.getPrefilledPhone();
            Pair pair6 = TuplesKt.to("prefilledPhone", prefilledPhone != null ? prefilledPhone.getValue() : null);
            PrefilledPhone prefilledPhone2 = setPhone.getPrefilledPhone();
            return BundleKt.bundleOf(pair3, pair4, pair5, pair6, TuplesKt.to("prefilledCountryCallingCode", prefilledPhone2 != null ? prefilledPhone2.getCountryCallingCode() : null), TuplesKt.to("isAddedToBackstack", Boolean.valueOf(process.getAddToBackStack())));
        }
        if (process instanceof RegistrationProcess.Success) {
            RegistrationProcess.Success success = (RegistrationProcess.Success) process;
            return BundleKt.bundleOf(TuplesKt.to(YooMoneyAuth.KEY_ACCESS_TOKEN, success.getAccessToken()), TuplesKt.to("processType", ProcessType.REGISTRATION), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()), TuplesKt.to("bindSocialAccountResult", success.getBindSocialAccount()));
        }
        if (process instanceof RegistrationProcess.AcquireAuthorization) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessType.REGISTRATION), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, process.getId()));
        }
        if (process instanceof RegistrationProcess.Failure) {
            return BundleKt.bundleOf(TuplesKt.to("processType", ProcessType.REGISTRATION), TuplesKt.to("processError", ((RegistrationProcess.Failure) process).getError()));
        }
        throw new IllegalArgumentException("unsupported process: " + process);
    }
}
