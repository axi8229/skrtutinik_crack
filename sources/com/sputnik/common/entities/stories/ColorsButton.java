package com.sputnik.common.entities.stories;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: StoryButton.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/entities/stories/ColorsButton;", "", "(Ljava/lang/String;I)V", "blue", "pink", "transparent", "green", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ColorsButton {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ColorsButton[] $VALUES;
    public static final ColorsButton blue = new ColorsButton("blue", 0);
    public static final ColorsButton pink = new ColorsButton("pink", 1);
    public static final ColorsButton transparent = new ColorsButton("transparent", 2);
    public static final ColorsButton green = new ColorsButton("green", 3);

    private static final /* synthetic */ ColorsButton[] $values() {
        return new ColorsButton[]{blue, pink, transparent, green};
    }

    public static ColorsButton valueOf(String str) {
        return (ColorsButton) Enum.valueOf(ColorsButton.class, str);
    }

    public static ColorsButton[] values() {
        return (ColorsButton[]) $VALUES.clone();
    }

    private ColorsButton(String str, int i) {
    }

    static {
        ColorsButton[] colorsButtonArr$values = $values();
        $VALUES = colorsButtonArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(colorsButtonArr$values);
    }
}
