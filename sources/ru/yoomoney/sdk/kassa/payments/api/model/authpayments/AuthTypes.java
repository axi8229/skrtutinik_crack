package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthTypes;", "", "(Ljava/lang/String;I)V", "SMS", "TOTP", "SECURE_PASSWORD", "EMERGENCY", "PUSH", "OAUTH_TOKEN", "PUSH_CODE", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthTypes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AuthTypes[] $VALUES;

    @JsonProperty("Sms")
    public static final AuthTypes SMS = new AuthTypes("SMS", 0);

    @JsonProperty("Totp")
    public static final AuthTypes TOTP = new AuthTypes("TOTP", 1);

    @JsonProperty("SecurePassword")
    public static final AuthTypes SECURE_PASSWORD = new AuthTypes("SECURE_PASSWORD", 2);

    @JsonProperty("Emergency")
    public static final AuthTypes EMERGENCY = new AuthTypes("EMERGENCY", 3);

    @JsonProperty("Push")
    public static final AuthTypes PUSH = new AuthTypes("PUSH", 4);

    @JsonProperty("OauthToken")
    public static final AuthTypes OAUTH_TOKEN = new AuthTypes("OAUTH_TOKEN", 5);

    @JsonProperty("PushCode")
    public static final AuthTypes PUSH_CODE = new AuthTypes("PUSH_CODE", 6);

    @JsonEnumDefaultValue
    public static final AuthTypes UNKNOWN = new AuthTypes("UNKNOWN", 7);

    private static final /* synthetic */ AuthTypes[] $values() {
        return new AuthTypes[]{SMS, TOTP, SECURE_PASSWORD, EMERGENCY, PUSH, OAUTH_TOKEN, PUSH_CODE, UNKNOWN};
    }

    static {
        AuthTypes[] authTypesArr$values = $values();
        $VALUES = authTypesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(authTypesArr$values);
    }

    private AuthTypes(String str, int i) {
    }

    public static EnumEntries<AuthTypes> getEntries() {
        return $ENTRIES;
    }

    public static AuthTypes valueOf(String str) {
        return (AuthTypes) Enum.valueOf(AuthTypes.class, str);
    }

    public static AuthTypes[] values() {
        return (AuthTypes[]) $VALUES.clone();
    }
}
