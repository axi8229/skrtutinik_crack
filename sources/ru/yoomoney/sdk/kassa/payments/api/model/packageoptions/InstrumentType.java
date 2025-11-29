package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;", "", "(Ljava/lang/String;I)V", "WALLET", "LINKED_BANK_CARD", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InstrumentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InstrumentType[] $VALUES;

    @JsonProperty("wallet")
    public static final InstrumentType WALLET = new InstrumentType("WALLET", 0);

    @JsonProperty("linked_bank_card")
    public static final InstrumentType LINKED_BANK_CARD = new InstrumentType("LINKED_BANK_CARD", 1);

    private static final /* synthetic */ InstrumentType[] $values() {
        return new InstrumentType[]{WALLET, LINKED_BANK_CARD};
    }

    static {
        InstrumentType[] instrumentTypeArr$values = $values();
        $VALUES = instrumentTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(instrumentTypeArr$values);
    }

    private InstrumentType(String str, int i) {
    }

    public static EnumEntries<InstrumentType> getEntries() {
        return $ENTRIES;
    }

    public static InstrumentType valueOf(String str) {
        return (InstrumentType) Enum.valueOf(InstrumentType.class, str);
    }

    public static InstrumentType[] values() {
        return (InstrumentType[]) $VALUES.clone();
    }
}
