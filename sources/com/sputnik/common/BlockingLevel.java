package com.sputnik.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GlobalVariables.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sputnik/common/BlockingLevel;", "", "(Ljava/lang/String;I)V", "NONE", "PARTIAL", "FULL", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlockingLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BlockingLevel[] $VALUES;
    public static final BlockingLevel NONE = new BlockingLevel("NONE", 0);
    public static final BlockingLevel PARTIAL = new BlockingLevel("PARTIAL", 1);
    public static final BlockingLevel FULL = new BlockingLevel("FULL", 2);

    private static final /* synthetic */ BlockingLevel[] $values() {
        return new BlockingLevel[]{NONE, PARTIAL, FULL};
    }

    public static BlockingLevel valueOf(String str) {
        return (BlockingLevel) Enum.valueOf(BlockingLevel.class, str);
    }

    public static BlockingLevel[] values() {
        return (BlockingLevel[]) $VALUES.clone();
    }

    private BlockingLevel(String str, int i) {
    }

    static {
        BlockingLevel[] blockingLevelArr$values = $values();
        $VALUES = blockingLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(blockingLevelArr$values);
    }
}
