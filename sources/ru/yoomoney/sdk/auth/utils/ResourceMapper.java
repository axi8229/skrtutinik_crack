package ru.yoomoney.sdk.auth.utils;

import android.content.Context;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.model.ErrorAccountForRecoveryNotFound;
import ru.yoomoney.sdk.auth.api.model.ErrorAccountNotFound;
import ru.yoomoney.sdk.auth.api.model.ErrorCodeExpired;
import ru.yoomoney.sdk.auth.api.model.ErrorContactTechnicalSupport;
import ru.yoomoney.sdk.auth.api.model.ErrorEmailAlreadyTaken;
import ru.yoomoney.sdk.auth.api.model.ErrorEmailQuarantined;
import ru.yoomoney.sdk.auth.api.model.ErrorFraudSuspected;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidCode;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidOauthSecret;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidPassword;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidPasswordOrAccount;
import ru.yoomoney.sdk.auth.api.model.ErrorMaxSucceededPasswordAttemptsReached;
import ru.yoomoney.sdk.auth.api.model.ErrorMaxWrongPasswordAttemptsReached;
import ru.yoomoney.sdk.auth.api.model.ErrorPasswordRequirementsViolated;
import ru.yoomoney.sdk.auth.api.model.ErrorPhoneIsAlreadyAssignedToAccountWithoutEmail;
import ru.yoomoney.sdk.auth.api.model.ErrorPhoneIsSameAsCurrent;
import ru.yoomoney.sdk.auth.api.model.ErrorSocialAccountAlreadyBound;
import ru.yoomoney.sdk.auth.api.model.ErrorTooFrequentlyResend;
import ru.yoomoney.sdk.auth.api.model.ErrorTooManyLinkedAccountsToPhone;
import ru.yoomoney.sdk.auth.api.model.ErrorUserTemporaryBanned;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.FeatureFailure;
import ru.yoomoney.sdk.auth.api.model.IllegalParametersFailure;
import ru.yoomoney.sdk.auth.api.model.NetworkConnectionFailure;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.model.RegistrationProcessError;
import ru.yoomoney.sdk.auth.api.model.RegistrationRuleViolationFailure;
import ru.yoomoney.sdk.auth.api.model.RegistrationRuleViolationType;
import ru.yoomoney.sdk.auth.api.model.SocialAccountAuthFailure;
import ru.yoomoney.sdk.auth.api.model.SocialAccountFailure;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "map", "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "mapRegistrationProcessError", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "mapRegistrationRuleViolation", "ruleType", "Lru/yoomoney/sdk/auth/api/model/RegistrationRuleViolationType;", "mapServiceProviderToStringName", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "resetProcessDialog", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResourceMapper {
    private final Context context;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

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
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OauthServiceProvider.values().length];
            try {
                iArr2[OauthServiceProvider.VK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OauthServiceProvider.SBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[OauthServiceProvider.ESIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[RegistrationRuleViolationType.values().length];
            try {
                iArr3[RegistrationRuleViolationType.EMAIL_ALREADY_TAKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[RegistrationRuleViolationType.PHONE_NUMBER_LIMIT_REACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public ResourceMapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final String mapRegistrationProcessError(RegistrationProcessError error) {
        Context context;
        int i;
        if (Intrinsics.areEqual(error, RegistrationProcessError.AuthorizationIssueLimitExceeded.INSTANCE)) {
            context = this.context;
            i = R.string.auth_registration_error_authorization_issue_limit_exceeded;
        } else if (Intrinsics.areEqual(error, RegistrationProcessError.EmailAlreadyTaken.INSTANCE)) {
            context = this.context;
            i = R.string.auth_registration_error_email_already_taken;
        } else if (Intrinsics.areEqual(error, RegistrationProcessError.FatalError.INSTANCE)) {
            context = this.context;
            i = R.string.auth_registration_error_fatal_error;
        } else if (Intrinsics.areEqual(error, RegistrationProcessError.PhoneNumberLimitReached.INSTANCE)) {
            context = this.context;
            i = R.string.auth_registration_error_phone_number_limit_reached;
        } else if (Intrinsics.areEqual(error, RegistrationProcessError.ProcessExpired.INSTANCE)) {
            context = this.context;
            i = R.string.auth_registration_error_process_expired;
        } else {
            if (!Intrinsics.areEqual(error, RegistrationProcessError.RegistrationForbidden.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            context = this.context;
            i = R.string.auth_registration_error_registration_forbidden;
        }
        String string = context.getString(i);
        Intrinsics.checkNotNull(string);
        return string;
    }

    private final String mapRegistrationRuleViolation(RegistrationRuleViolationType ruleType) {
        Context context;
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$2[ruleType.ordinal()];
        if (i2 == 1) {
            context = this.context;
            i = R.string.auth_registration_error_email_already_taken;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            context = this.context;
            i = R.string.auth_registration_error_phone_number_limit_reached;
        }
        String string = context.getString(i);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final String map(Failure failure) {
        Context context;
        int i;
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failure instanceof NetworkConnectionFailure) {
            context = this.context;
            i = R.string.auth_network_connection_error;
        } else {
            if (failure instanceof FeatureFailure) {
                return map(((FeatureFailure) failure).getError());
            }
            if (failure instanceof SocialAccountFailure) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                SocialAccountFailure socialAccountFailure = (SocialAccountFailure) failure;
                String str = String.format(map(socialAccountFailure.getError()), Arrays.copyOf(new Object[]{mapServiceProviderToStringName(socialAccountFailure.getService())}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
            if (failure instanceof IllegalParametersFailure) {
                context = this.context;
                i = R.string.auth_illegal_parameters_common_error;
            } else if (failure instanceof SocialAccountAuthFailure) {
                context = this.context;
                i = R.string.auth_default_social_account_login_error;
            } else {
                if (failure instanceof RegistrationRuleViolationFailure) {
                    return mapRegistrationRuleViolation(((RegistrationRuleViolationFailure) failure).getRule());
                }
                context = this.context;
                i = R.string.auth_default_error;
            }
        }
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String mapServiceProviderToStringName(OauthServiceProvider serviceProvider) {
        Context context;
        int i;
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        int i2 = WhenMappings.$EnumSwitchMapping$1[serviceProvider.ordinal()];
        if (i2 == 1) {
            context = this.context;
            i = R.string.auth_social_account_name_vk_id;
        } else if (i2 == 2) {
            context = this.context;
            i = R.string.auth_social_account_name_sber_id;
        } else {
            if (i2 != 3) {
                return "";
            }
            context = this.context;
            i = R.string.auth_social_account_name_esia;
        }
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String resetProcessDialog(ProcessType processType) {
        Context context;
        int i;
        Intrinsics.checkNotNullParameter(processType, "processType");
        int i2 = WhenMappings.$EnumSwitchMapping$0[processType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            context = this.context;
            i = R.string.auth_reset_process_dialog_message_enrollment;
        } else if (i2 != 3) {
            context = this.context;
            i = R.string.auth_reset_process_dialog_message_other;
        } else {
            context = this.context;
            i = R.string.auth_reset_process_dialog_message_login;
        }
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final String map(ProcessError error) {
        Context context;
        int i;
        Context context2;
        int i2;
        if (error instanceof RegistrationProcessError) {
            return mapRegistrationProcessError((RegistrationProcessError) error);
        }
        if (error instanceof ErrorPasswordRequirementsViolated) {
            return ((ErrorPasswordRequirementsViolated) error).getTitle();
        }
        if (error instanceof ErrorTooManyLinkedAccountsToPhone) {
            context = this.context;
            i = R.string.auth_phone_too_many_accounts_error;
        } else {
            if (error instanceof ErrorInvalidCode) {
                int attemptsLeft = ((ErrorInvalidCode) error).getAttemptsLeft();
                if (attemptsLeft == 0) {
                    context2 = this.context;
                    i2 = R.string.auth_error_invalid_code_no_attempts;
                } else if (attemptsLeft != 1) {
                    context2 = this.context;
                    i2 = R.string.auth_error_invalid_code;
                } else {
                    context2 = this.context;
                    i2 = R.string.auth_error_invalid_code_last_attempt;
                }
                String string = context2.getString(i2);
                Intrinsics.checkNotNull(string);
                return string;
            }
            if (error instanceof ErrorCodeExpired) {
                context = this.context;
                i = R.string.auth_error_code_expired_error;
            } else if (error instanceof ErrorEmailAlreadyTaken) {
                context = this.context;
                i = R.string.auth_email_already_taken_error;
            } else if (error instanceof ErrorEmailQuarantined) {
                context = this.context;
                i = R.string.auth_email_quarantined_error;
            } else if (error instanceof ErrorTooFrequentlyResend) {
                context = this.context;
                i = R.string.auth_too_frequently_resend_error;
            } else if (error instanceof ErrorUserTemporaryBanned) {
                context = this.context;
                i = R.string.auth_user_temporary_banned_error;
            } else if (error instanceof ErrorFraudSuspected) {
                context = this.context;
                i = R.string.auth_fraud_suspected_error;
            } else if (error instanceof ErrorInvalidPasswordOrAccount) {
                context = this.context;
                i = R.string.auth_password_enter_invalid_password_or_account_error;
            } else if (error instanceof ErrorInvalidPassword) {
                context = this.context;
                i = R.string.auth_password_enter_invalid_password_error;
            } else if (error instanceof ErrorAccountNotFound) {
                context = this.context;
                i = R.string.auth_account_not_found;
            } else if (error instanceof ErrorMaxWrongPasswordAttemptsReached) {
                context = this.context;
                i = R.string.auth_max_wrong_password_attempts_reached;
            } else if (error instanceof ErrorMaxSucceededPasswordAttemptsReached) {
                context = this.context;
                i = R.string.auth_max_succeeded_password_attempts_reached;
            } else if (error instanceof ErrorContactTechnicalSupport) {
                context = this.context;
                i = R.string.auth_contact_technical_support;
            } else if (error instanceof ErrorPhoneIsAlreadyAssignedToAccountWithoutEmail) {
                context = this.context;
                i = R.string.auth_phone_is_already_assigned_to_account_without_email;
            } else if (error instanceof ErrorPhoneIsSameAsCurrent) {
                context = this.context;
                i = R.string.auth_phone_is_same_as_current;
            } else if (error instanceof ErrorAccountForRecoveryNotFound) {
                context = this.context;
                i = R.string.auth_account_not_found_error;
            } else if (error instanceof ErrorSocialAccountAlreadyBound) {
                context = this.context;
                i = R.string.auth_social_account_already_bound_error;
            } else if (error instanceof ErrorInvalidOauthSecret) {
                context = this.context;
                i = R.string.auth_social_account_invalid_oauth;
            } else {
                context = this.context;
                i = R.string.auth_default_error;
            }
        }
        String string2 = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }
}
