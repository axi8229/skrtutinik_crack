package com.sputnik.common.entities.camera;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CamerasFiltering.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/sputnik/common/entities/camera/CamerasFiltering$OrderTypes", "", "Lcom/sputnik/common/entities/camera/CamerasFiltering$OrderTypes;", "<init>", "(Ljava/lang/String;I)V", "main_screen", "widget", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CamerasFiltering$OrderTypes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CamerasFiltering$OrderTypes[] $VALUES;
    public static final CamerasFiltering$OrderTypes main_screen = new CamerasFiltering$OrderTypes("main_screen", 0);
    public static final CamerasFiltering$OrderTypes widget = new CamerasFiltering$OrderTypes("widget", 1);

    private static final /* synthetic */ CamerasFiltering$OrderTypes[] $values() {
        return new CamerasFiltering$OrderTypes[]{main_screen, widget};
    }

    public static CamerasFiltering$OrderTypes valueOf(String str) {
        return (CamerasFiltering$OrderTypes) Enum.valueOf(CamerasFiltering$OrderTypes.class, str);
    }

    public static CamerasFiltering$OrderTypes[] values() {
        return (CamerasFiltering$OrderTypes[]) $VALUES.clone();
    }

    private CamerasFiltering$OrderTypes(String str, int i) {
    }

    static {
        CamerasFiltering$OrderTypes[] camerasFiltering$OrderTypesArr$values = $values();
        $VALUES = camerasFiltering$OrderTypesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(camerasFiltering$OrderTypesArr$values);
    }
}
