package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import androidx.annotation.Keep;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "", "(Ljava/lang/String;I)V", "YOO_MONEY", "GOOGLE_PAY", "BANK_CARD", "SBERBANK", "SBP", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentMethodType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaymentMethodType[] $VALUES;

    @Keep
    public static final PaymentMethodType YOO_MONEY = new PaymentMethodType("YOO_MONEY", 0);

    @Deprecated
    @Keep
    public static final PaymentMethodType GOOGLE_PAY = new PaymentMethodType("GOOGLE_PAY", 1);

    @Keep
    public static final PaymentMethodType BANK_CARD = new PaymentMethodType("BANK_CARD", 2);

    @Keep
    public static final PaymentMethodType SBERBANK = new PaymentMethodType("SBERBANK", 3);

    @Keep
    public static final PaymentMethodType SBP = new PaymentMethodType("SBP", 4);

    private static final /* synthetic */ PaymentMethodType[] $values() {
        return new PaymentMethodType[]{YOO_MONEY, GOOGLE_PAY, BANK_CARD, SBERBANK, SBP};
    }

    static {
        PaymentMethodType[] paymentMethodTypeArr$values = $values();
        $VALUES = paymentMethodTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(paymentMethodTypeArr$values);
    }

    private PaymentMethodType(String str, int i) {
    }

    public static EnumEntries<PaymentMethodType> getEntries() {
        return $ENTRIES;
    }

    public static PaymentMethodType valueOf(String str) {
        return (PaymentMethodType) Enum.valueOf(PaymentMethodType.class, str);
    }

    public static PaymentMethodType[] values() {
        return (PaymentMethodType[]) $VALUES.clone();
    }
}
