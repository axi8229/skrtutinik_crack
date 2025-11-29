package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationPasswordSetRulesViolationError;", "", "(Ljava/lang/String;I)V", "PROCESS_NOT_FOUND", "PASSWORD_TOO_SHORT", "PASSWORD_TOO_LONG", "CAPITAL_LETTER_REQUIRED", "LOWERCASE_LETTER_REQUIRED", "DIGIT_REQUIRED", "UNACCEPTABLE_CHARACTER", "UNKNOWN_ENUM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RegistrationPasswordSetRulesViolationError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegistrationPasswordSetRulesViolationError[] $VALUES;

    @JsonProperty("ProcessNotFound")
    public static final RegistrationPasswordSetRulesViolationError PROCESS_NOT_FOUND = new RegistrationPasswordSetRulesViolationError("PROCESS_NOT_FOUND", 0);

    @JsonProperty("PasswordTooShort")
    public static final RegistrationPasswordSetRulesViolationError PASSWORD_TOO_SHORT = new RegistrationPasswordSetRulesViolationError("PASSWORD_TOO_SHORT", 1);

    @JsonProperty("PasswordTooLong")
    public static final RegistrationPasswordSetRulesViolationError PASSWORD_TOO_LONG = new RegistrationPasswordSetRulesViolationError("PASSWORD_TOO_LONG", 2);

    @JsonProperty("CapitalLetterRequired")
    public static final RegistrationPasswordSetRulesViolationError CAPITAL_LETTER_REQUIRED = new RegistrationPasswordSetRulesViolationError("CAPITAL_LETTER_REQUIRED", 3);

    @JsonProperty("LowercaseLetterRequired")
    public static final RegistrationPasswordSetRulesViolationError LOWERCASE_LETTER_REQUIRED = new RegistrationPasswordSetRulesViolationError("LOWERCASE_LETTER_REQUIRED", 4);

    @JsonProperty("DigitRequired")
    public static final RegistrationPasswordSetRulesViolationError DIGIT_REQUIRED = new RegistrationPasswordSetRulesViolationError("DIGIT_REQUIRED", 5);

    @JsonProperty("UnacceptableCharacter")
    public static final RegistrationPasswordSetRulesViolationError UNACCEPTABLE_CHARACTER = new RegistrationPasswordSetRulesViolationError("UNACCEPTABLE_CHARACTER", 6);

    @JsonEnumDefaultValue
    public static final RegistrationPasswordSetRulesViolationError UNKNOWN_ENUM = new RegistrationPasswordSetRulesViolationError("UNKNOWN_ENUM", 7);

    private static final /* synthetic */ RegistrationPasswordSetRulesViolationError[] $values() {
        return new RegistrationPasswordSetRulesViolationError[]{PROCESS_NOT_FOUND, PASSWORD_TOO_SHORT, PASSWORD_TOO_LONG, CAPITAL_LETTER_REQUIRED, LOWERCASE_LETTER_REQUIRED, DIGIT_REQUIRED, UNACCEPTABLE_CHARACTER, UNKNOWN_ENUM};
    }

    static {
        RegistrationPasswordSetRulesViolationError[] registrationPasswordSetRulesViolationErrorArr$values = $values();
        $VALUES = registrationPasswordSetRulesViolationErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(registrationPasswordSetRulesViolationErrorArr$values);
    }

    private RegistrationPasswordSetRulesViolationError(String str, int i) {
    }

    public static EnumEntries<RegistrationPasswordSetRulesViolationError> getEntries() {
        return $ENTRIES;
    }

    public static RegistrationPasswordSetRulesViolationError valueOf(String str) {
        return (RegistrationPasswordSetRulesViolationError) Enum.valueOf(RegistrationPasswordSetRulesViolationError.class, str);
    }

    public static RegistrationPasswordSetRulesViolationError[] values() {
        return (RegistrationPasswordSetRulesViolationError[]) $VALUES.clone();
    }
}
