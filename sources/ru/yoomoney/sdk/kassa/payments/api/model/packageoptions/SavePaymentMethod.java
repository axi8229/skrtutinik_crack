package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "", "(Ljava/lang/String;I)V", "isAllowed", "", "ALLOWED", "FORBIDDEN", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavePaymentMethod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SavePaymentMethod[] $VALUES;

    @JsonProperty("allowed")
    public static final SavePaymentMethod ALLOWED = new SavePaymentMethod("ALLOWED", 0);

    @JsonProperty("forbidden")
    public static final SavePaymentMethod FORBIDDEN = new SavePaymentMethod("FORBIDDEN", 1);

    @JsonEnumDefaultValue
    public static final SavePaymentMethod UNKNOWN = new SavePaymentMethod("UNKNOWN", 2);

    private static final /* synthetic */ SavePaymentMethod[] $values() {
        return new SavePaymentMethod[]{ALLOWED, FORBIDDEN, UNKNOWN};
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

    public final boolean isAllowed() {
        return this == ALLOWED;
    }
}
