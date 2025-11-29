package ru.yoomoney.sdk.auth.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/RegistrationRuleViolationType;", "", "(Ljava/lang/String;I)V", "EMAIL_ALREADY_TAKEN", "PHONE_NUMBER_LIMIT_REACHED", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RegistrationRuleViolationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegistrationRuleViolationType[] $VALUES;
    public static final RegistrationRuleViolationType EMAIL_ALREADY_TAKEN = new RegistrationRuleViolationType("EMAIL_ALREADY_TAKEN", 0);
    public static final RegistrationRuleViolationType PHONE_NUMBER_LIMIT_REACHED = new RegistrationRuleViolationType("PHONE_NUMBER_LIMIT_REACHED", 1);

    private static final /* synthetic */ RegistrationRuleViolationType[] $values() {
        return new RegistrationRuleViolationType[]{EMAIL_ALREADY_TAKEN, PHONE_NUMBER_LIMIT_REACHED};
    }

    static {
        RegistrationRuleViolationType[] registrationRuleViolationTypeArr$values = $values();
        $VALUES = registrationRuleViolationTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(registrationRuleViolationTypeArr$values);
    }

    private RegistrationRuleViolationType(String str, int i) {
    }

    public static EnumEntries<RegistrationRuleViolationType> getEntries() {
        return $ENTRIES;
    }

    public static RegistrationRuleViolationType valueOf(String str) {
        return (RegistrationRuleViolationType) Enum.valueOf(RegistrationRuleViolationType.class, str);
    }

    public static RegistrationRuleViolationType[] values() {
        return (RegistrationRuleViolationType[]) $VALUES.clone();
    }
}
