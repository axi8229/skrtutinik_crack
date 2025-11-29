package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "", "(Ljava/lang/String;I)V", "REDIRECT", "EXTERNAL", "MOBILE_APPLICATION", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConfirmationType[] $VALUES;

    @JsonProperty("redirect")
    public static final ConfirmationType REDIRECT = new ConfirmationType("REDIRECT", 0);

    @JsonProperty("external")
    public static final ConfirmationType EXTERNAL = new ConfirmationType("EXTERNAL", 1);

    @JsonProperty("mobile_application")
    public static final ConfirmationType MOBILE_APPLICATION = new ConfirmationType("MOBILE_APPLICATION", 2);

    @JsonEnumDefaultValue
    public static final ConfirmationType UNKNOWN = new ConfirmationType("UNKNOWN", 3);

    private static final /* synthetic */ ConfirmationType[] $values() {
        return new ConfirmationType[]{REDIRECT, EXTERNAL, MOBILE_APPLICATION, UNKNOWN};
    }

    static {
        ConfirmationType[] confirmationTypeArr$values = $values();
        $VALUES = confirmationTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(confirmationTypeArr$values);
    }

    private ConfirmationType(String str, int i) {
    }

    public static EnumEntries<ConfirmationType> getEntries() {
        return $ENTRIES;
    }

    public static ConfirmationType valueOf(String str) {
        return (ConfirmationType) Enum.valueOf(ConfirmationType.class, str);
    }

    public static ConfirmationType[] values() {
        return (ConfirmationType[]) $VALUES.clone();
    }
}
