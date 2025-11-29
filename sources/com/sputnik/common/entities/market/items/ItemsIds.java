package com.sputnik.common.entities.market.items;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ItemsIds.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/entities/market/items/ItemsIds;", "", "(Ljava/lang/String;I)V", "licensed_keys", "yandex_catalog", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ItemsIds {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ItemsIds[] $VALUES;
    public static final ItemsIds licensed_keys = new ItemsIds("licensed_keys", 0);
    public static final ItemsIds yandex_catalog = new ItemsIds("yandex_catalog", 1);

    private static final /* synthetic */ ItemsIds[] $values() {
        return new ItemsIds[]{licensed_keys, yandex_catalog};
    }

    public static ItemsIds valueOf(String str) {
        return (ItemsIds) Enum.valueOf(ItemsIds.class, str);
    }

    public static ItemsIds[] values() {
        return (ItemsIds[]) $VALUES.clone();
    }

    private ItemsIds(String str, int i) {
    }

    static {
        ItemsIds[] itemsIdsArr$values = $values();
        $VALUES = itemsIdsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(itemsIdsArr$values);
    }
}
