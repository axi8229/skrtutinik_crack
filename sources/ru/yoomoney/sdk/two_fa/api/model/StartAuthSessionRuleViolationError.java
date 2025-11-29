package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: StartAuthSessionRuleViolationError.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/StartAuthSessionRuleViolationError;", "", "(Ljava/lang/String;I)V", "ILLEGAL_PROCESS_STATE", "SESSION_NOT_AVAILABLE", "VELOCITY_CHECK_ERROR", "UNKNOWN_ENUM", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartAuthSessionRuleViolationError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StartAuthSessionRuleViolationError[] $VALUES;

    @JsonProperty("IllegalProcessState")
    public static final StartAuthSessionRuleViolationError ILLEGAL_PROCESS_STATE = new StartAuthSessionRuleViolationError("ILLEGAL_PROCESS_STATE", 0);

    @JsonProperty("SessionNotAvailable")
    public static final StartAuthSessionRuleViolationError SESSION_NOT_AVAILABLE = new StartAuthSessionRuleViolationError("SESSION_NOT_AVAILABLE", 1);

    @JsonProperty("VelocityCheckError")
    public static final StartAuthSessionRuleViolationError VELOCITY_CHECK_ERROR = new StartAuthSessionRuleViolationError("VELOCITY_CHECK_ERROR", 2);

    @JsonEnumDefaultValue
    public static final StartAuthSessionRuleViolationError UNKNOWN_ENUM = new StartAuthSessionRuleViolationError("UNKNOWN_ENUM", 3);

    private static final /* synthetic */ StartAuthSessionRuleViolationError[] $values() {
        return new StartAuthSessionRuleViolationError[]{ILLEGAL_PROCESS_STATE, SESSION_NOT_AVAILABLE, VELOCITY_CHECK_ERROR, UNKNOWN_ENUM};
    }

    public static EnumEntries<StartAuthSessionRuleViolationError> getEntries() {
        return $ENTRIES;
    }

    public static StartAuthSessionRuleViolationError valueOf(String str) {
        return (StartAuthSessionRuleViolationError) Enum.valueOf(StartAuthSessionRuleViolationError.class, str);
    }

    public static StartAuthSessionRuleViolationError[] values() {
        return (StartAuthSessionRuleViolationError[]) $VALUES.clone();
    }

    private StartAuthSessionRuleViolationError(String str, int i) {
    }

    static {
        StartAuthSessionRuleViolationError[] startAuthSessionRuleViolationErrorArr$values = $values();
        $VALUES = startAuthSessionRuleViolationErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(startAuthSessionRuleViolationErrorArr$values);
    }
}
