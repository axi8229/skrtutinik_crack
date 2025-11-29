package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CheckAuthSessionRuleViolationError.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/CheckAuthSessionRuleViolationError;", "", "(Ljava/lang/String;I)V", "ILLEGAL_PROCESS_STATE", "ACTIVE_SESSION_IS_EXPIRED", "NO_ATTEMPTS_LEFT", "INVALID_SECRET", "INVALID_UID", "UNKNOWN_ENUM", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckAuthSessionRuleViolationError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CheckAuthSessionRuleViolationError[] $VALUES;

    @JsonProperty("IllegalProcessState")
    public static final CheckAuthSessionRuleViolationError ILLEGAL_PROCESS_STATE = new CheckAuthSessionRuleViolationError("ILLEGAL_PROCESS_STATE", 0);

    @JsonProperty("ActiveSessionIsExpired")
    public static final CheckAuthSessionRuleViolationError ACTIVE_SESSION_IS_EXPIRED = new CheckAuthSessionRuleViolationError("ACTIVE_SESSION_IS_EXPIRED", 1);

    @JsonProperty("NoAttemptsLeft")
    public static final CheckAuthSessionRuleViolationError NO_ATTEMPTS_LEFT = new CheckAuthSessionRuleViolationError("NO_ATTEMPTS_LEFT", 2);

    @JsonProperty("InvalidSecret")
    public static final CheckAuthSessionRuleViolationError INVALID_SECRET = new CheckAuthSessionRuleViolationError("INVALID_SECRET", 3);

    @JsonProperty("InvalidUid")
    public static final CheckAuthSessionRuleViolationError INVALID_UID = new CheckAuthSessionRuleViolationError("INVALID_UID", 4);

    @JsonEnumDefaultValue
    public static final CheckAuthSessionRuleViolationError UNKNOWN_ENUM = new CheckAuthSessionRuleViolationError("UNKNOWN_ENUM", 5);

    private static final /* synthetic */ CheckAuthSessionRuleViolationError[] $values() {
        return new CheckAuthSessionRuleViolationError[]{ILLEGAL_PROCESS_STATE, ACTIVE_SESSION_IS_EXPIRED, NO_ATTEMPTS_LEFT, INVALID_SECRET, INVALID_UID, UNKNOWN_ENUM};
    }

    public static EnumEntries<CheckAuthSessionRuleViolationError> getEntries() {
        return $ENTRIES;
    }

    public static CheckAuthSessionRuleViolationError valueOf(String str) {
        return (CheckAuthSessionRuleViolationError) Enum.valueOf(CheckAuthSessionRuleViolationError.class, str);
    }

    public static CheckAuthSessionRuleViolationError[] values() {
        return (CheckAuthSessionRuleViolationError[]) $VALUES.clone();
    }

    private CheckAuthSessionRuleViolationError(String str, int i) {
    }

    static {
        CheckAuthSessionRuleViolationError[] checkAuthSessionRuleViolationErrorArr$values = $values();
        $VALUES = checkAuthSessionRuleViolationErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(checkAuthSessionRuleViolationErrorArr$values);
    }
}
