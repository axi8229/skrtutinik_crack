package ru.yoomoney.sdk.guiCompose.theme;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RippleTheme.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/RippleType;", "", "(Ljava/lang/String;I)V", "Default", "Inverse", "Colored", "AlwaysWhite", "AlwaysBlack", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RippleType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RippleType[] $VALUES;
    public static final RippleType Default = new RippleType("Default", 0);
    public static final RippleType Inverse = new RippleType("Inverse", 1);
    public static final RippleType Colored = new RippleType("Colored", 2);
    public static final RippleType AlwaysWhite = new RippleType("AlwaysWhite", 3);
    public static final RippleType AlwaysBlack = new RippleType("AlwaysBlack", 4);

    private static final /* synthetic */ RippleType[] $values() {
        return new RippleType[]{Default, Inverse, Colored, AlwaysWhite, AlwaysBlack};
    }

    public static RippleType valueOf(String str) {
        return (RippleType) Enum.valueOf(RippleType.class, str);
    }

    public static RippleType[] values() {
        return (RippleType[]) $VALUES.clone();
    }

    private RippleType(String str, int i) {
    }

    static {
        RippleType[] rippleTypeArr$values = $values();
        $VALUES = rippleTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(rippleTypeArr$values);
    }
}
