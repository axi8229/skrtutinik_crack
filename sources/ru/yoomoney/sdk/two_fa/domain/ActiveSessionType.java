package ru.yoomoney.sdk.two_fa.domain;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Domain.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/two_fa/domain/ActiveSessionType;", "", "(Ljava/lang/String;I)V", "PUSH_CODE", "PUSH_APP", "UNKNOWN_ENUM", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActiveSessionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ActiveSessionType[] $VALUES;
    public static final ActiveSessionType PUSH_CODE = new ActiveSessionType("PUSH_CODE", 0);
    public static final ActiveSessionType PUSH_APP = new ActiveSessionType("PUSH_APP", 1);
    public static final ActiveSessionType UNKNOWN_ENUM = new ActiveSessionType("UNKNOWN_ENUM", 2);

    private static final /* synthetic */ ActiveSessionType[] $values() {
        return new ActiveSessionType[]{PUSH_CODE, PUSH_APP, UNKNOWN_ENUM};
    }

    public static EnumEntries<ActiveSessionType> getEntries() {
        return $ENTRIES;
    }

    public static ActiveSessionType valueOf(String str) {
        return (ActiveSessionType) Enum.valueOf(ActiveSessionType.class, str);
    }

    public static ActiveSessionType[] values() {
        return (ActiveSessionType[]) $VALUES.clone();
    }

    private ActiveSessionType(String str, int i) {
    }

    static {
        ActiveSessionType[] activeSessionTypeArr$values = $values();
        $VALUES = activeSessionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(activeSessionTypeArr$values);
    }
}
