package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthPaymentState;", "", "(Ljava/lang/String;I)V", "SUCCESS", "REFUSED", "AUTH_REQUIRED", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthPaymentState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AuthPaymentState[] $VALUES;

    @JsonProperty("Success")
    public static final AuthPaymentState SUCCESS = new AuthPaymentState("SUCCESS", 0);

    @JsonProperty("Refused")
    public static final AuthPaymentState REFUSED = new AuthPaymentState("REFUSED", 1);

    @JsonProperty("AuthRequired")
    public static final AuthPaymentState AUTH_REQUIRED = new AuthPaymentState("AUTH_REQUIRED", 2);

    @JsonEnumDefaultValue
    public static final AuthPaymentState UNKNOWN = new AuthPaymentState("UNKNOWN", 3);

    private static final /* synthetic */ AuthPaymentState[] $values() {
        return new AuthPaymentState[]{SUCCESS, REFUSED, AUTH_REQUIRED, UNKNOWN};
    }

    static {
        AuthPaymentState[] authPaymentStateArr$values = $values();
        $VALUES = authPaymentStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(authPaymentStateArr$values);
    }

    private AuthPaymentState(String str, int i) {
    }

    public static EnumEntries<AuthPaymentState> getEntries() {
        return $ENTRIES;
    }

    public static AuthPaymentState valueOf(String str) {
        return (AuthPaymentState) Enum.valueOf(AuthPaymentState.class, str);
    }

    public static AuthPaymentState[] values() {
        return (AuthPaymentState[]) $VALUES.clone();
    }
}
