package ru.yoomoney.sdk.auth.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/api/Origin;", "", "(Ljava/lang/String;I)V", "WALLET", "CHECKOUT", "CORPORATE_BANKING", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Origin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Origin[] $VALUES;

    @SerializedName("Wallet")
    public static final Origin WALLET = new Origin("WALLET", 0);

    @SerializedName("Checkout")
    public static final Origin CHECKOUT = new Origin("CHECKOUT", 1);

    @SerializedName("CorporateBanking")
    public static final Origin CORPORATE_BANKING = new Origin("CORPORATE_BANKING", 2);

    private static final /* synthetic */ Origin[] $values() {
        return new Origin[]{WALLET, CHECKOUT, CORPORATE_BANKING};
    }

    static {
        Origin[] originArr$values = $values();
        $VALUES = originArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(originArr$values);
    }

    private Origin(String str, int i) {
    }

    public static EnumEntries<Origin> getEntries() {
        return $ENTRIES;
    }

    public static Origin valueOf(String str) {
        return (Origin) Enum.valueOf(Origin.class, str);
    }

    public static Origin[] values() {
        return (Origin[]) $VALUES.clone();
    }
}
