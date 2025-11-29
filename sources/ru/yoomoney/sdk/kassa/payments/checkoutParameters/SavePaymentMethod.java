package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/SavePaymentMethod;", "", "(Ljava/lang/String;I)V", "ON", "OFF", "USER_SELECTS", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavePaymentMethod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SavePaymentMethod[] $VALUES;

    @Keep
    public static final SavePaymentMethod ON = new SavePaymentMethod("ON", 0);

    @Keep
    public static final SavePaymentMethod OFF = new SavePaymentMethod("OFF", 1);

    @Keep
    public static final SavePaymentMethod USER_SELECTS = new SavePaymentMethod("USER_SELECTS", 2);

    private static final /* synthetic */ SavePaymentMethod[] $values() {
        return new SavePaymentMethod[]{ON, OFF, USER_SELECTS};
    }

    static {
        SavePaymentMethod[] savePaymentMethodArr$values = $values();
        $VALUES = savePaymentMethodArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(savePaymentMethodArr$values);
    }

    private SavePaymentMethod(String str, int i) {
    }

    public static EnumEntries<SavePaymentMethod> getEntries() {
        return $ENTRIES;
    }

    public static SavePaymentMethod valueOf(String str) {
        return (SavePaymentMethod) Enum.valueOf(SavePaymentMethod.class, str);
    }

    public static SavePaymentMethod[] values() {
        return (SavePaymentMethod[]) $VALUES.clone();
    }
}
