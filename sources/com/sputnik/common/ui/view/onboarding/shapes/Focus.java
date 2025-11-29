package com.sputnik.common.ui.view.onboarding.shapes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Focus.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;", "", "(Ljava/lang/String;I)V", "MINIMUM", "NORMAL", "ALL", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Focus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Focus[] $VALUES;
    public static final Focus MINIMUM = new Focus("MINIMUM", 0);
    public static final Focus NORMAL = new Focus("NORMAL", 1);
    public static final Focus ALL = new Focus("ALL", 2);

    private static final /* synthetic */ Focus[] $values() {
        return new Focus[]{MINIMUM, NORMAL, ALL};
    }

    public static Focus valueOf(String str) {
        return (Focus) Enum.valueOf(Focus.class, str);
    }

    public static Focus[] values() {
        return (Focus[]) $VALUES.clone();
    }

    private Focus(String str, int i) {
    }

    static {
        Focus[] focusArr$values = $values();
        $VALUES = focusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(focusArr$values);
    }
}
