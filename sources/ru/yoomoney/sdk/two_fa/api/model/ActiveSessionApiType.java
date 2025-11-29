package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ActiveSessionApiType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;", "", "(Ljava/lang/String;I)V", "PUSH_CODE", "PUSH_APP", "UNKNOWN_ENUM", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActiveSessionApiType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ActiveSessionApiType[] $VALUES;

    @JsonProperty("PushCode")
    public static final ActiveSessionApiType PUSH_CODE = new ActiveSessionApiType("PUSH_CODE", 0);

    @JsonProperty("PushApp")
    public static final ActiveSessionApiType PUSH_APP = new ActiveSessionApiType("PUSH_APP", 1);

    @JsonEnumDefaultValue
    public static final ActiveSessionApiType UNKNOWN_ENUM = new ActiveSessionApiType("UNKNOWN_ENUM", 2);

    private static final /* synthetic */ ActiveSessionApiType[] $values() {
        return new ActiveSessionApiType[]{PUSH_CODE, PUSH_APP, UNKNOWN_ENUM};
    }

    public static EnumEntries<ActiveSessionApiType> getEntries() {
        return $ENTRIES;
    }

    public static ActiveSessionApiType valueOf(String str) {
        return (ActiveSessionApiType) Enum.valueOf(ActiveSessionApiType.class, str);
    }

    public static ActiveSessionApiType[] values() {
        return (ActiveSessionApiType[]) $VALUES.clone();
    }

    private ActiveSessionApiType(String str, int i) {
    }

    static {
        ActiveSessionApiType[] activeSessionApiTypeArr$values = $values();
        $VALUES = activeSessionApiTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(activeSessionApiTypeArr$values);
    }
}
