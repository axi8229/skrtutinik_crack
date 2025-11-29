package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;", "", "(Ljava/lang/String;I)V", "SIMPLIFIED", "FULL", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IdentificationRequirement {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IdentificationRequirement[] $VALUES;

    @JsonProperty("simplified")
    public static final IdentificationRequirement SIMPLIFIED = new IdentificationRequirement("SIMPLIFIED", 0);

    @JsonProperty("full")
    public static final IdentificationRequirement FULL = new IdentificationRequirement("FULL", 1);

    @JsonEnumDefaultValue
    public static final IdentificationRequirement UNKNOWN = new IdentificationRequirement("UNKNOWN", 2);

    private static final /* synthetic */ IdentificationRequirement[] $values() {
        return new IdentificationRequirement[]{SIMPLIFIED, FULL, UNKNOWN};
    }

    static {
        IdentificationRequirement[] identificationRequirementArr$values = $values();
        $VALUES = identificationRequirementArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(identificationRequirementArr$values);
    }

    private IdentificationRequirement(String str, int i) {
    }

    public static EnumEntries<IdentificationRequirement> getEntries() {
        return $ENTRIES;
    }

    public static IdentificationRequirement valueOf(String str) {
        return (IdentificationRequirement) Enum.valueOf(IdentificationRequirement.class, str);
    }

    public static IdentificationRequirement[] values() {
        return (IdentificationRequirement[]) $VALUES.clone();
    }
}
