package ru.yoomoney.sdk.gui.widgetV2.sticker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: StickerViewType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/sticker/StickerViewType;", "", "(Ljava/lang/String;I)V", "CASHBACK", "CREDIT", "PERCENT", "OFFER", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StickerViewType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StickerViewType[] $VALUES;
    public static final StickerViewType CASHBACK = new StickerViewType("CASHBACK", 0);
    public static final StickerViewType CREDIT = new StickerViewType("CREDIT", 1);
    public static final StickerViewType PERCENT = new StickerViewType("PERCENT", 2);
    public static final StickerViewType OFFER = new StickerViewType("OFFER", 3);

    private static final /* synthetic */ StickerViewType[] $values() {
        return new StickerViewType[]{CASHBACK, CREDIT, PERCENT, OFFER};
    }

    public static StickerViewType valueOf(String str) {
        return (StickerViewType) Enum.valueOf(StickerViewType.class, str);
    }

    public static StickerViewType[] values() {
        return (StickerViewType[]) $VALUES.clone();
    }

    private StickerViewType(String str, int i) {
    }

    static {
        StickerViewType[] stickerViewTypeArr$values = $values();
        $VALUES = stickerViewTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(stickerViewTypeArr$values);
    }
}
