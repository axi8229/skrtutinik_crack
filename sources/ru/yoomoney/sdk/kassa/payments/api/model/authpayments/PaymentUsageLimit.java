package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/PaymentUsageLimit;", "", "(Ljava/lang/String;I)V", "SINGLE", "MULTIPLE", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentUsageLimit {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaymentUsageLimit[] $VALUES;

    @JsonProperty("Single")
    public static final PaymentUsageLimit SINGLE = new PaymentUsageLimit("SINGLE", 0);

    @JsonProperty("Multiple")
    public static final PaymentUsageLimit MULTIPLE = new PaymentUsageLimit("MULTIPLE", 1);

    private static final /* synthetic */ PaymentUsageLimit[] $values() {
        return new PaymentUsageLimit[]{SINGLE, MULTIPLE};
    }

    static {
        PaymentUsageLimit[] paymentUsageLimitArr$values = $values();
        $VALUES = paymentUsageLimitArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(paymentUsageLimitArr$values);
    }

    private PaymentUsageLimit(String str, int i) {
    }

    public static EnumEntries<PaymentUsageLimit> getEntries() {
        return $ENTRIES;
    }

    public static PaymentUsageLimit valueOf(String str) {
        return (PaymentUsageLimit) Enum.valueOf(PaymentUsageLimit.class, str);
    }

    public static PaymentUsageLimit[] values() {
        return (PaymentUsageLimit[]) $VALUES.clone();
    }
}
