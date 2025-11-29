package ru.yoomoney.sdk.auth.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RuleViolationType;", "", "(Ljava/lang/String;I)V", "INVALID_ACCESS_CODE", "AUTHORIZATION_REVOKED", "UNSUPPORTED_SOCIAL_ACCOUNT", "PROCESS_EXPIRED", "INVALID_STEP", "PROCESS_NOT_FOUND", "ILLEGAL_PROCESS_STATE", "INVALID_CLIENT_ID", "REGISTRATION_FORBIDDEN", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RuleViolationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RuleViolationType[] $VALUES;

    @SerializedName("InvalidAccessCode")
    public static final RuleViolationType INVALID_ACCESS_CODE = new RuleViolationType("INVALID_ACCESS_CODE", 0);

    @SerializedName("AuthorizationRevoked")
    public static final RuleViolationType AUTHORIZATION_REVOKED = new RuleViolationType("AUTHORIZATION_REVOKED", 1);

    @SerializedName("UnsupportedSocialAccount")
    public static final RuleViolationType UNSUPPORTED_SOCIAL_ACCOUNT = new RuleViolationType("UNSUPPORTED_SOCIAL_ACCOUNT", 2);

    @SerializedName("ProcessExpired")
    public static final RuleViolationType PROCESS_EXPIRED = new RuleViolationType("PROCESS_EXPIRED", 3);

    @SerializedName("InvalidStep")
    public static final RuleViolationType INVALID_STEP = new RuleViolationType("INVALID_STEP", 4);

    @SerializedName("ProcessNotFound")
    public static final RuleViolationType PROCESS_NOT_FOUND = new RuleViolationType("PROCESS_NOT_FOUND", 5);

    @SerializedName("IllegalProcessState")
    public static final RuleViolationType ILLEGAL_PROCESS_STATE = new RuleViolationType("ILLEGAL_PROCESS_STATE", 6);

    @SerializedName("InvalidClientId")
    public static final RuleViolationType INVALID_CLIENT_ID = new RuleViolationType("INVALID_CLIENT_ID", 7);

    @SerializedName("RegistrationForbidden")
    public static final RuleViolationType REGISTRATION_FORBIDDEN = new RuleViolationType("REGISTRATION_FORBIDDEN", 8);

    private static final /* synthetic */ RuleViolationType[] $values() {
        return new RuleViolationType[]{INVALID_ACCESS_CODE, AUTHORIZATION_REVOKED, UNSUPPORTED_SOCIAL_ACCOUNT, PROCESS_EXPIRED, INVALID_STEP, PROCESS_NOT_FOUND, ILLEGAL_PROCESS_STATE, INVALID_CLIENT_ID, REGISTRATION_FORBIDDEN};
    }

    static {
        RuleViolationType[] ruleViolationTypeArr$values = $values();
        $VALUES = ruleViolationTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(ruleViolationTypeArr$values);
    }

    private RuleViolationType(String str, int i) {
    }

    public static EnumEntries<RuleViolationType> getEntries() {
        return $ENTRIES;
    }

    public static RuleViolationType valueOf(String str) {
        return (RuleViolationType) Enum.valueOf(RuleViolationType.class, str);
    }

    public static RuleViolationType[] values() {
        return (RuleViolationType[]) $VALUES.clone();
    }
}
