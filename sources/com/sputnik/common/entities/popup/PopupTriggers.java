package com.sputnik.common.entities.popup;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PopupTriggers.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/sputnik/common/entities/popup/PopupTriggers;", "", "(Ljava/lang/String;I)V", "main", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PopupTriggers {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PopupTriggers[] $VALUES;
    public static final PopupTriggers main = new PopupTriggers("main", 0);

    private static final /* synthetic */ PopupTriggers[] $values() {
        return new PopupTriggers[]{main};
    }

    public static PopupTriggers valueOf(String str) {
        return (PopupTriggers) Enum.valueOf(PopupTriggers.class, str);
    }

    public static PopupTriggers[] values() {
        return (PopupTriggers[]) $VALUES.clone();
    }

    private PopupTriggers(String str, int i) {
    }

    static {
        PopupTriggers[] popupTriggersArr$values = $values();
        $VALUES = popupTriggersArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(popupTriggersArr$values);
    }
}
