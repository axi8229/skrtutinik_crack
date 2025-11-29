package ru.yoomoney.sdk.kassa.payments.api.model.paymentmethod;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/BankCardSourceResponse;", "", "(Ljava/lang/String;I)V", "APPLE_PAY", "GOOGLE_PAY", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankCardSourceResponse {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankCardSourceResponse[] $VALUES;

    @JsonProperty("apple_pay")
    public static final BankCardSourceResponse APPLE_PAY = new BankCardSourceResponse("APPLE_PAY", 0);

    @JsonProperty("google_pay")
    public static final BankCardSourceResponse GOOGLE_PAY = new BankCardSourceResponse("GOOGLE_PAY", 1);

    @JsonEnumDefaultValue
    public static final BankCardSourceResponse UNKNOWN = new BankCardSourceResponse("UNKNOWN", 2);

    private static final /* synthetic */ BankCardSourceResponse[] $values() {
        return new BankCardSourceResponse[]{APPLE_PAY, GOOGLE_PAY, UNKNOWN};
    }

    static {
        BankCardSourceResponse[] bankCardSourceResponseArr$values = $values();
        $VALUES = bankCardSourceResponseArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(bankCardSourceResponseArr$values);
    }

    private BankCardSourceResponse(String str, int i) {
    }

    public static EnumEntries<BankCardSourceResponse> getEntries() {
        return $ENTRIES;
    }

    public static BankCardSourceResponse valueOf(String str) {
        return (BankCardSourceResponse) Enum.valueOf(BankCardSourceResponse.class, str);
    }

    public static BankCardSourceResponse[] values() {
        return (BankCardSourceResponse[]) $VALUES.clone();
    }
}
