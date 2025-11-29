package sputnik.axmor.com.sputnik.entities.gorserv;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GorservCategories.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/gorserv/GorservCategories;", "", "(Ljava/lang/String;I)V", "br", "el", "st", "po", "bt", "tel", "kp", "sm", "pf", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GorservCategories {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GorservCategories[] $VALUES;
    public static final GorservCategories br = new GorservCategories("br", 0);
    public static final GorservCategories el = new GorservCategories("el", 1);
    public static final GorservCategories st = new GorservCategories("st", 2);
    public static final GorservCategories po = new GorservCategories("po", 3);
    public static final GorservCategories bt = new GorservCategories("bt", 4);
    public static final GorservCategories tel = new GorservCategories("tel", 5);
    public static final GorservCategories kp = new GorservCategories("kp", 6);
    public static final GorservCategories sm = new GorservCategories("sm", 7);
    public static final GorservCategories pf = new GorservCategories("pf", 8);

    private static final /* synthetic */ GorservCategories[] $values() {
        return new GorservCategories[]{br, el, st, po, bt, tel, kp, sm, pf};
    }

    public static GorservCategories valueOf(String str) {
        return (GorservCategories) Enum.valueOf(GorservCategories.class, str);
    }

    public static GorservCategories[] values() {
        return (GorservCategories[]) $VALUES.clone();
    }

    private GorservCategories(String str, int i) {
    }

    static {
        GorservCategories[] gorservCategoriesArr$values = $values();
        $VALUES = gorservCategoriesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(gorservCategoriesArr$values);
    }
}
