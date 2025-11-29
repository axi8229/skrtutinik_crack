package ru.yoomoney.sdk.auth.select.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/select/adapter/SelectAccountItemType;", "", "(Ljava/lang/String;I)V", "NEW_ACCOUNT_ITEM", "HEADER_ITEM", "ACCOUNT_ITEM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectAccountItemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SelectAccountItemType[] $VALUES;
    public static final SelectAccountItemType NEW_ACCOUNT_ITEM = new SelectAccountItemType("NEW_ACCOUNT_ITEM", 0);
    public static final SelectAccountItemType HEADER_ITEM = new SelectAccountItemType("HEADER_ITEM", 1);
    public static final SelectAccountItemType ACCOUNT_ITEM = new SelectAccountItemType("ACCOUNT_ITEM", 2);

    private static final /* synthetic */ SelectAccountItemType[] $values() {
        return new SelectAccountItemType[]{NEW_ACCOUNT_ITEM, HEADER_ITEM, ACCOUNT_ITEM};
    }

    static {
        SelectAccountItemType[] selectAccountItemTypeArr$values = $values();
        $VALUES = selectAccountItemTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(selectAccountItemTypeArr$values);
    }

    private SelectAccountItemType(String str, int i) {
    }

    public static EnumEntries<SelectAccountItemType> getEntries() {
        return $ENTRIES;
    }

    public static SelectAccountItemType valueOf(String str) {
        return (SelectAccountItemType) Enum.valueOf(SelectAccountItemType.class, str);
    }

    public static SelectAccountItemType[] values() {
        return (SelectAccountItemType[]) $VALUES.clone();
    }
}
