package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class L1 {
    public static final K1 c;
    public static int d;
    public static final /* synthetic */ L1[] e;
    public final boolean a;
    public final boolean b;

    static {
        L1[] l1Arr = {new L1("RECURRENT_AND_BIND", 0, true, true), new L1("RECURRENT_AND_NO_BIND", 1, true, false), new L1("NO_RECURRENT_AND_BIND", 2, false, true), new L1("NO_RECURRENT_AND_NO_BIND", 3, false, false)};
        e = l1Arr;
        EnumEntriesKt.enumEntries(l1Arr);
        c = new K1();
    }

    public L1(String str, int i, boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public static L1 valueOf(String str) {
        return (L1) Enum.valueOf(L1.class, str);
    }

    public static L1[] values() {
        return (L1[]) e.clone();
    }
}
