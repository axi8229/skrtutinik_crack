package com.sputnik.common.ui.view.onboarding.shapes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ShapeType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/sputnik/common/ui/view/onboarding/shapes/ShapeType;", "", "(Ljava/lang/String;I)V", "CIRCLE", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShapeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ShapeType[] $VALUES;
    public static final ShapeType CIRCLE = new ShapeType("CIRCLE", 0);

    private static final /* synthetic */ ShapeType[] $values() {
        return new ShapeType[]{CIRCLE};
    }

    public static ShapeType valueOf(String str) {
        return (ShapeType) Enum.valueOf(ShapeType.class, str);
    }

    public static ShapeType[] values() {
        return (ShapeType[]) $VALUES.clone();
    }

    private ShapeType(String str, int i) {
    }

    static {
        ShapeType[] shapeTypeArr$values = $values();
        $VALUES = shapeTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(shapeTypeArr$values);
    }
}
