package com.sputnik.common.entities.promotion;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ScreenVariants.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/entities/promotion/ScreenVariants;", "", "(Ljava/lang/String;I)V", "text", "close_icon", "accelerating_icon", "none", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenVariants {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScreenVariants[] $VALUES;
    public static final ScreenVariants text = new ScreenVariants("text", 0);
    public static final ScreenVariants close_icon = new ScreenVariants("close_icon", 1);
    public static final ScreenVariants accelerating_icon = new ScreenVariants("accelerating_icon", 2);
    public static final ScreenVariants none = new ScreenVariants("none", 3);

    private static final /* synthetic */ ScreenVariants[] $values() {
        return new ScreenVariants[]{text, close_icon, accelerating_icon, none};
    }

    public static ScreenVariants valueOf(String str) {
        return (ScreenVariants) Enum.valueOf(ScreenVariants.class, str);
    }

    public static ScreenVariants[] values() {
        return (ScreenVariants[]) $VALUES.clone();
    }

    private ScreenVariants(String str, int i) {
    }

    static {
        ScreenVariants[] screenVariantsArr$values = $values();
        $VALUES = screenVariantsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(screenVariantsArr$values);
    }
}
