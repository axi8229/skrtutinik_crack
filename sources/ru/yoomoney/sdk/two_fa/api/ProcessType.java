package ru.yoomoney.sdk.two_fa.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ProcessType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/ProcessType;", "", "(Ljava/lang/String;I)V", "REGISTRATION", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProcessType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProcessType[] $VALUES;
    public static final ProcessType REGISTRATION = new ProcessType("REGISTRATION", 0);

    private static final /* synthetic */ ProcessType[] $values() {
        return new ProcessType[]{REGISTRATION};
    }

    public static EnumEntries<ProcessType> getEntries() {
        return $ENTRIES;
    }

    public static ProcessType valueOf(String str) {
        return (ProcessType) Enum.valueOf(ProcessType.class, str);
    }

    public static ProcessType[] values() {
        return (ProcessType[]) $VALUES.clone();
    }

    private ProcessType(String str, int i) {
    }

    static {
        ProcessType[] processTypeArr$values = $values();
        $VALUES = processTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(processTypeArr$values);
    }
}
