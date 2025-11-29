package ru.yoomoney.sdk.auth.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001a\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ErrorType;", "", "(Ljava/lang/String;I)V", "PASSWORD_REQUIREMENTS_VIOLATED", "TOO_FREQUENTLY_RESEND", "FRAUD_SUSPECTED", "EMAIL_QUARANTINED", "EMAIL_ALREADY_TAKEN", "CODE_EXPIRED", "INVALID_CODE", "INVALID_PASSWORD_OR_ACCOUNT", "TEMPORARY_BANNED", "TOO_MANY_ACCOUNTS", "PROCESSING_REQUEST", "NOT_NEED_MIGRATION", "NOT_REGISTERED", "CONTACT_TECHNICAL_SUPPORT", "INVALID_PASSWORD", "ACCOUNT_NOT_FOUND", "MAX_WRONG_PASSWORD_ATTEMPTS_REACHED", "MAX_SUCCEEDED_PASSWORD_ATTEMPTS_REACHED", "PHONE_IS_SAME_AS_CURRENT", "PHONE_IS_ALREADY_ASSIGNED_TO_ACCOUNT_WITHOUT_EMAIL", "ACCOUNT_FOR_RECOVERY_NOT_FOUND", "OAUTH_ACCOUNT_NOT_CONNECTED", "INVALID_OAUTH_SECRET", "SOCIAL_ACCOUNT_ALREADY_BOUND", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ErrorType[] $VALUES;

    @SerializedName("PasswordRequirementsViolated")
    public static final ErrorType PASSWORD_REQUIREMENTS_VIOLATED = new ErrorType("PASSWORD_REQUIREMENTS_VIOLATED", 0);

    @SerializedName("TooFrequentlyResend")
    public static final ErrorType TOO_FREQUENTLY_RESEND = new ErrorType("TOO_FREQUENTLY_RESEND", 1);

    @SerializedName("FraudSuspected")
    public static final ErrorType FRAUD_SUSPECTED = new ErrorType("FRAUD_SUSPECTED", 2);

    @SerializedName("EmailQuarantined")
    public static final ErrorType EMAIL_QUARANTINED = new ErrorType("EMAIL_QUARANTINED", 3);

    @SerializedName("EmailAlreadyTaken")
    public static final ErrorType EMAIL_ALREADY_TAKEN = new ErrorType("EMAIL_ALREADY_TAKEN", 4);

    @SerializedName("CodeExpired")
    public static final ErrorType CODE_EXPIRED = new ErrorType("CODE_EXPIRED", 5);

    @SerializedName("InvalidCode")
    public static final ErrorType INVALID_CODE = new ErrorType("INVALID_CODE", 6);

    @SerializedName("InvalidPasswordOrAccount")
    public static final ErrorType INVALID_PASSWORD_OR_ACCOUNT = new ErrorType("INVALID_PASSWORD_OR_ACCOUNT", 7);

    @SerializedName("TemporaryBanned")
    public static final ErrorType TEMPORARY_BANNED = new ErrorType("TEMPORARY_BANNED", 8);

    @SerializedName("TooManyAccounts")
    public static final ErrorType TOO_MANY_ACCOUNTS = new ErrorType("TOO_MANY_ACCOUNTS", 9);

    @SerializedName("ProcessingRequest")
    public static final ErrorType PROCESSING_REQUEST = new ErrorType("PROCESSING_REQUEST", 10);

    @SerializedName("NotNeedMigration")
    public static final ErrorType NOT_NEED_MIGRATION = new ErrorType("NOT_NEED_MIGRATION", 11);

    @SerializedName("NotRegistered")
    public static final ErrorType NOT_REGISTERED = new ErrorType("NOT_REGISTERED", 12);

    @SerializedName("ContactTechnicalSupport")
    public static final ErrorType CONTACT_TECHNICAL_SUPPORT = new ErrorType("CONTACT_TECHNICAL_SUPPORT", 13);

    @SerializedName("InvalidPassword")
    public static final ErrorType INVALID_PASSWORD = new ErrorType("INVALID_PASSWORD", 14);

    @SerializedName("AccountNotFound")
    public static final ErrorType ACCOUNT_NOT_FOUND = new ErrorType("ACCOUNT_NOT_FOUND", 15);

    @SerializedName("MaxWrongPasswordAttemptsReached")
    public static final ErrorType MAX_WRONG_PASSWORD_ATTEMPTS_REACHED = new ErrorType("MAX_WRONG_PASSWORD_ATTEMPTS_REACHED", 16);

    @SerializedName("MaxSucceededPasswordAttemptsReached")
    public static final ErrorType MAX_SUCCEEDED_PASSWORD_ATTEMPTS_REACHED = new ErrorType("MAX_SUCCEEDED_PASSWORD_ATTEMPTS_REACHED", 17);

    @SerializedName("PhoneIsSameAsCurrent")
    public static final ErrorType PHONE_IS_SAME_AS_CURRENT = new ErrorType("PHONE_IS_SAME_AS_CURRENT", 18);

    @SerializedName("PhoneIsAlreadyAssignedToAccountWithoutEmail")
    public static final ErrorType PHONE_IS_ALREADY_ASSIGNED_TO_ACCOUNT_WITHOUT_EMAIL = new ErrorType("PHONE_IS_ALREADY_ASSIGNED_TO_ACCOUNT_WITHOUT_EMAIL", 19);

    @SerializedName("AccountForRecoveryNotFound")
    public static final ErrorType ACCOUNT_FOR_RECOVERY_NOT_FOUND = new ErrorType("ACCOUNT_FOR_RECOVERY_NOT_FOUND", 20);

    @SerializedName("OauthAccountNotConnected")
    public static final ErrorType OAUTH_ACCOUNT_NOT_CONNECTED = new ErrorType("OAUTH_ACCOUNT_NOT_CONNECTED", 21);

    @SerializedName("InvalidOauthSecret")
    public static final ErrorType INVALID_OAUTH_SECRET = new ErrorType("INVALID_OAUTH_SECRET", 22);

    @SerializedName("SocialAccountAlreadyBound")
    public static final ErrorType SOCIAL_ACCOUNT_ALREADY_BOUND = new ErrorType("SOCIAL_ACCOUNT_ALREADY_BOUND", 23);

    private static final /* synthetic */ ErrorType[] $values() {
        return new ErrorType[]{PASSWORD_REQUIREMENTS_VIOLATED, TOO_FREQUENTLY_RESEND, FRAUD_SUSPECTED, EMAIL_QUARANTINED, EMAIL_ALREADY_TAKEN, CODE_EXPIRED, INVALID_CODE, INVALID_PASSWORD_OR_ACCOUNT, TEMPORARY_BANNED, TOO_MANY_ACCOUNTS, PROCESSING_REQUEST, NOT_NEED_MIGRATION, NOT_REGISTERED, CONTACT_TECHNICAL_SUPPORT, INVALID_PASSWORD, ACCOUNT_NOT_FOUND, MAX_WRONG_PASSWORD_ATTEMPTS_REACHED, MAX_SUCCEEDED_PASSWORD_ATTEMPTS_REACHED, PHONE_IS_SAME_AS_CURRENT, PHONE_IS_ALREADY_ASSIGNED_TO_ACCOUNT_WITHOUT_EMAIL, ACCOUNT_FOR_RECOVERY_NOT_FOUND, OAUTH_ACCOUNT_NOT_CONNECTED, INVALID_OAUTH_SECRET, SOCIAL_ACCOUNT_ALREADY_BOUND};
    }

    static {
        ErrorType[] errorTypeArr$values = $values();
        $VALUES = errorTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(errorTypeArr$values);
    }

    private ErrorType(String str, int i) {
    }

    public static EnumEntries<ErrorType> getEntries() {
        return $ENTRIES;
    }

    public static ErrorType valueOf(String str) {
        return (ErrorType) Enum.valueOf(ErrorType.class, str);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) $VALUES.clone();
    }
}
