package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationSetEmailRulesViolationError;", "", "(Ljava/lang/String;I)V", "EMAIL_ALREADY_TAKEN", "UNKNOWN_ENUM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RegistrationSetEmailRulesViolationError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegistrationSetEmailRulesViolationError[] $VALUES;

    @JsonProperty("EmailAlreadyTaken")
    public static final RegistrationSetEmailRulesViolationError EMAIL_ALREADY_TAKEN = new RegistrationSetEmailRulesViolationError("EMAIL_ALREADY_TAKEN", 0);

    @JsonEnumDefaultValue
    public static final RegistrationSetEmailRulesViolationError UNKNOWN_ENUM = new RegistrationSetEmailRulesViolationError("UNKNOWN_ENUM", 1);

    private static final /* synthetic */ RegistrationSetEmailRulesViolationError[] $values() {
        return new RegistrationSetEmailRulesViolationError[]{EMAIL_ALREADY_TAKEN, UNKNOWN_ENUM};
    }

    static {
        RegistrationSetEmailRulesViolationError[] registrationSetEmailRulesViolationErrorArr$values = $values();
        $VALUES = registrationSetEmailRulesViolationErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(registrationSetEmailRulesViolationErrorArr$values);
    }

    private RegistrationSetEmailRulesViolationError(String str, int i) {
    }

    public static EnumEntries<RegistrationSetEmailRulesViolationError> getEntries() {
        return $ENTRIES;
    }

    public static RegistrationSetEmailRulesViolationError valueOf(String str) {
        return (RegistrationSetEmailRulesViolationError) Enum.valueOf(RegistrationSetEmailRulesViolationError.class, str);
    }

    public static RegistrationSetEmailRulesViolationError[] values() {
        return (RegistrationSetEmailRulesViolationError[]) $VALUES.clone();
    }
}
