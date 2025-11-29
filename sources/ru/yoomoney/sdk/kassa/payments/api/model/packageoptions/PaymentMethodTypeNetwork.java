package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "YOO_MONEY", "GOOGLE_PAY", "BANK_CARD", "SBERBANK", "SBP", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentMethodTypeNetwork {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaymentMethodTypeNetwork[] $VALUES;
    private final String value;

    @JsonProperty("yoo_money")
    public static final PaymentMethodTypeNetwork YOO_MONEY = new PaymentMethodTypeNetwork("YOO_MONEY", 0, "yoo_money");

    @JsonProperty("google_pay")
    public static final PaymentMethodTypeNetwork GOOGLE_PAY = new PaymentMethodTypeNetwork("GOOGLE_PAY", 1, "google_pay");

    @JsonProperty("bank_card")
    public static final PaymentMethodTypeNetwork BANK_CARD = new PaymentMethodTypeNetwork("BANK_CARD", 2, "bank_card");

    @JsonProperty("sberbank")
    public static final PaymentMethodTypeNetwork SBERBANK = new PaymentMethodTypeNetwork("SBERBANK", 3, "sberbank");

    @JsonProperty("sbp")
    public static final PaymentMethodTypeNetwork SBP = new PaymentMethodTypeNetwork("SBP", 4, "sbp");

    @JsonEnumDefaultValue
    public static final PaymentMethodTypeNetwork UNKNOWN = new PaymentMethodTypeNetwork("UNKNOWN", 5, "");

    private static final /* synthetic */ PaymentMethodTypeNetwork[] $values() {
        return new PaymentMethodTypeNetwork[]{YOO_MONEY, GOOGLE_PAY, BANK_CARD, SBERBANK, SBP, UNKNOWN};
    }

    static {
        PaymentMethodTypeNetwork[] paymentMethodTypeNetworkArr$values = $values();
        $VALUES = paymentMethodTypeNetworkArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(paymentMethodTypeNetworkArr$values);
    }

    private PaymentMethodTypeNetwork(String str, int i, String str2) {
        this.value = str2;
    }

    public static EnumEntries<PaymentMethodTypeNetwork> getEntries() {
        return $ENTRIES;
    }

    public static PaymentMethodTypeNetwork valueOf(String str) {
        return (PaymentMethodTypeNetwork) Enum.valueOf(PaymentMethodTypeNetwork.class, str);
    }

    public static PaymentMethodTypeNetwork[] values() {
        return (PaymentMethodTypeNetwork[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
