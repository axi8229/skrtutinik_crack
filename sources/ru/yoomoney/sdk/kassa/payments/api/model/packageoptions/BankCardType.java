package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;", "", "(Ljava/lang/String;I)V", "MASTER_CARD", "VISA", "MIR", "AMERICAN_EXPRESS", "JCB", "CUP", "DINERS_CLUB", "BANK_CARD", "DISCOVER_CARD", "INSTA_PAYMENT", "INSTA_PAYMENT_TM", "LASER", "DANKORT", "SOLO", "SWITCH", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankCardType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankCardType[] $VALUES;

    @JsonProperty("MasterCard")
    public static final BankCardType MASTER_CARD = new BankCardType("MASTER_CARD", 0);

    @JsonProperty("Visa")
    public static final BankCardType VISA = new BankCardType("VISA", 1);

    @JsonProperty("MIR")
    public static final BankCardType MIR = new BankCardType("MIR", 2);

    @JsonProperty("AmericanExpress")
    public static final BankCardType AMERICAN_EXPRESS = new BankCardType("AMERICAN_EXPRESS", 3);

    @JsonProperty("JCB")
    public static final BankCardType JCB = new BankCardType("JCB", 4);

    @JsonProperty("CUP")
    public static final BankCardType CUP = new BankCardType("CUP", 5);

    @JsonProperty("DinersClub")
    public static final BankCardType DINERS_CLUB = new BankCardType("DINERS_CLUB", 6);

    @JsonProperty("BankCard")
    public static final BankCardType BANK_CARD = new BankCardType("BANK_CARD", 7);

    @JsonProperty("DiscoverCard")
    public static final BankCardType DISCOVER_CARD = new BankCardType("DISCOVER_CARD", 8);

    @JsonProperty("InstaPayment")
    public static final BankCardType INSTA_PAYMENT = new BankCardType("INSTA_PAYMENT", 9);

    @JsonProperty("InstaPaymentTM")
    public static final BankCardType INSTA_PAYMENT_TM = new BankCardType("INSTA_PAYMENT_TM", 10);

    @JsonProperty("Laser")
    public static final BankCardType LASER = new BankCardType("LASER", 11);

    @JsonProperty("Dankort")
    public static final BankCardType DANKORT = new BankCardType("DANKORT", 12);

    @JsonProperty("Solo")
    public static final BankCardType SOLO = new BankCardType("SOLO", 13);

    @JsonProperty("Switch")
    public static final BankCardType SWITCH = new BankCardType("SWITCH", 14);

    @JsonEnumDefaultValue
    public static final BankCardType UNKNOWN = new BankCardType("UNKNOWN", 15);

    private static final /* synthetic */ BankCardType[] $values() {
        return new BankCardType[]{MASTER_CARD, VISA, MIR, AMERICAN_EXPRESS, JCB, CUP, DINERS_CLUB, BANK_CARD, DISCOVER_CARD, INSTA_PAYMENT, INSTA_PAYMENT_TM, LASER, DANKORT, SOLO, SWITCH, UNKNOWN};
    }

    static {
        BankCardType[] bankCardTypeArr$values = $values();
        $VALUES = bankCardTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(bankCardTypeArr$values);
    }

    private BankCardType(String str, int i) {
    }

    public static EnumEntries<BankCardType> getEntries() {
        return $ENTRIES;
    }

    public static BankCardType valueOf(String str) {
        return (BankCardType) Enum.valueOf(BankCardType.class, str);
    }

    public static BankCardType[] values() {
        return (BankCardType[]) $VALUES.clone();
    }
}
