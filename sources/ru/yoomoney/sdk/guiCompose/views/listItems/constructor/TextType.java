package ru.yoomoney.sdk.guiCompose.views.listItems.constructor;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ListItemsData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;", "", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TextType[] $VALUES;
    public static final TextType PRIMARY = new TextType("PRIMARY", 0);
    public static final TextType SECONDARY = new TextType("SECONDARY", 1);

    private static final /* synthetic */ TextType[] $values() {
        return new TextType[]{PRIMARY, SECONDARY};
    }

    public static TextType valueOf(String str) {
        return (TextType) Enum.valueOf(TextType.class, str);
    }

    public static TextType[] values() {
        return (TextType[]) $VALUES.clone();
    }

    private TextType(String str, int i) {
    }

    static {
        TextType[] textTypeArr$values = $values();
        $VALUES = textTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(textTypeArr$values);
    }
}
