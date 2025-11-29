package ru.yoomoney.sdk.kassa.payments.navigation;

import java.io.Serializable;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class f implements Serializable {
    public static final f a;
    public static final f b;
    public static final /* synthetic */ f[] c;

    static {
        f fVar = new f("SUCCESS", 0);
        a = fVar;
        f fVar2 = new f("CANCEL", 1);
        b = fVar2;
        f[] fVarArr = {fVar, fVar2};
        c = fVarArr;
        EnumEntriesKt.enumEntries(fVarArr);
    }

    public f(String str, int i) {
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) c.clone();
    }
}
