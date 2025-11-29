package com.sputnik.common.entities.camera;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CamerasFiltering.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/sputnik/common/entities/camera/CamerasFiltering$ListTypes", "", "Lcom/sputnik/common/entities/camera/CamerasFiltering$ListTypes;", "<init>", "(Ljava/lang/String;I)V", "all", "main_screen", "widget", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CamerasFiltering$ListTypes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CamerasFiltering$ListTypes[] $VALUES;
    public static final CamerasFiltering$ListTypes all = new CamerasFiltering$ListTypes("all", 0);
    public static final CamerasFiltering$ListTypes main_screen = new CamerasFiltering$ListTypes("main_screen", 1);
    public static final CamerasFiltering$ListTypes widget = new CamerasFiltering$ListTypes("widget", 2);

    private static final /* synthetic */ CamerasFiltering$ListTypes[] $values() {
        return new CamerasFiltering$ListTypes[]{all, main_screen, widget};
    }

    public static CamerasFiltering$ListTypes valueOf(String str) {
        return (CamerasFiltering$ListTypes) Enum.valueOf(CamerasFiltering$ListTypes.class, str);
    }

    public static CamerasFiltering$ListTypes[] values() {
        return (CamerasFiltering$ListTypes[]) $VALUES.clone();
    }

    private CamerasFiltering$ListTypes(String str, int i) {
    }

    static {
        CamerasFiltering$ListTypes[] camerasFiltering$ListTypesArr$values = $values();
        $VALUES = camerasFiltering$ListTypesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(camerasFiltering$ListTypesArr$values);
    }
}
