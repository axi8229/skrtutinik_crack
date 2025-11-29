package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/StepProcessRulesViolationError;", "", "(Ljava/lang/String;I)V", "INVALID_STEP", "UNKNOWN_ENUM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepProcessRulesViolationError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StepProcessRulesViolationError[] $VALUES;

    @JsonProperty("InvalidStep")
    public static final StepProcessRulesViolationError INVALID_STEP = new StepProcessRulesViolationError("INVALID_STEP", 0);

    @JsonEnumDefaultValue
    public static final StepProcessRulesViolationError UNKNOWN_ENUM = new StepProcessRulesViolationError("UNKNOWN_ENUM", 1);

    private static final /* synthetic */ StepProcessRulesViolationError[] $values() {
        return new StepProcessRulesViolationError[]{INVALID_STEP, UNKNOWN_ENUM};
    }

    static {
        StepProcessRulesViolationError[] stepProcessRulesViolationErrorArr$values = $values();
        $VALUES = stepProcessRulesViolationErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(stepProcessRulesViolationErrorArr$values);
    }

    private StepProcessRulesViolationError(String str, int i) {
    }

    public static EnumEntries<StepProcessRulesViolationError> getEntries() {
        return $ENTRIES;
    }

    public static StepProcessRulesViolationError valueOf(String str) {
        return (StepProcessRulesViolationError) Enum.valueOf(StepProcessRulesViolationError.class, str);
    }

    public static StepProcessRulesViolationError[] values() {
        return (StepProcessRulesViolationError[]) $VALUES.clone();
    }
}
