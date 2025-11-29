package ru.yoomoney.sdk.yoopinning;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.yoopinning.PinningException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: KidType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/yoopinning/KidType;", "", "int", "", "(Ljava/lang/String;ILjava/lang/String;)V", "PRIMARY", "SECONDARY", "Companion", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KidType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KidType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final KidType PRIMARY = new KidType("PRIMARY", 0, "1");
    public static final KidType SECONDARY = new KidType("SECONDARY", 1, "2");

    private static final /* synthetic */ KidType[] $values() {
        return new KidType[]{PRIMARY, SECONDARY};
    }

    public static EnumEntries<KidType> getEntries() {
        return $ENTRIES;
    }

    public static KidType valueOf(String str) {
        return (KidType) Enum.valueOf(KidType.class, str);
    }

    public static KidType[] values() {
        return (KidType[]) $VALUES.clone();
    }

    private KidType(String str, int i, String str2) {
    }

    static {
        KidType[] kidTypeArr$values = $values();
        $VALUES = kidTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(kidTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: KidType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/yoopinning/KidType$Companion;", "", "()V", "fromString", "Lru/yoomoney/sdk/yoopinning/KidType;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KidType fromString(String value) throws PinningException.KeyTypeException {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, "1")) {
                return KidType.PRIMARY;
            }
            if (Intrinsics.areEqual(value, "2")) {
                return KidType.SECONDARY;
            }
            throw new PinningException.KeyTypeException(value);
        }
    }
}
