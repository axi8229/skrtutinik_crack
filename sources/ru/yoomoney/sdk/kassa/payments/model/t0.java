package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class t0 {
    public static final t0 a;
    public static final t0 b;
    public static final t0 c;
    public static final /* synthetic */ t0[] d;

    static {
        t0 t0Var = new t0("IN_PROGRESS", 0);
        a = t0Var;
        t0 t0Var2 = new t0("FINISHED", 1);
        b = t0Var2;
        t0 t0Var3 = new t0("UNKNOWN", 2);
        c = t0Var3;
        t0[] t0VarArr = {t0Var, t0Var2, t0Var3};
        d = t0VarArr;
        EnumEntriesKt.enumEntries(t0VarArr);
    }

    public t0(String str, int i) {
    }

    public static t0 valueOf(String str) {
        return (t0) Enum.valueOf(t0.class, str);
    }

    public static t0[] values() {
        return (t0[]) d.clone();
    }
}
