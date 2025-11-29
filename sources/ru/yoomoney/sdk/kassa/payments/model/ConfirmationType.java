package ru.yoomoney.sdk.kassa.payments.model;

import androidx.annotation.Keep;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.android.SystemUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/model/ConfirmationType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EXTERNAL", "REDIRECT", "MOBILE_APPLICATION", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConfirmationType[] $VALUES;
    private final String value;

    @Keep
    public static final ConfirmationType EXTERNAL = new ConfirmationType("EXTERNAL", 0, "external");

    @Keep
    public static final ConfirmationType REDIRECT = new ConfirmationType("REDIRECT", 1, "redirect");

    @Keep
    public static final ConfirmationType MOBILE_APPLICATION = new ConfirmationType("MOBILE_APPLICATION", 2, "mobile_application");

    @Keep
    public static final ConfirmationType UNKNOWN = new ConfirmationType("UNKNOWN", 3, SystemUtils.UNKNOWN);

    private static final /* synthetic */ ConfirmationType[] $values() {
        return new ConfirmationType[]{EXTERNAL, REDIRECT, MOBILE_APPLICATION, UNKNOWN};
    }

    static {
        ConfirmationType[] confirmationTypeArr$values = $values();
        $VALUES = confirmationTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(confirmationTypeArr$values);
    }

    private ConfirmationType(String str, int i, String str2) {
        this.value = str2;
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

    public final String getValue() {
        return this.value;
    }
}
