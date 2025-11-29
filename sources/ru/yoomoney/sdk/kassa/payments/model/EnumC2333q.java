package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ru.yoomoney.sdk.kassa.payments.model.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC2333q {
    public static final EnumC2333q a;
    public static final EnumC2333q b;
    public static final EnumC2333q c;
    public static final EnumC2333q d;
    public static final EnumC2333q e;
    public static final EnumC2333q f;
    public static final EnumC2333q g;
    public static final EnumC2333q h;
    public static final EnumC2333q i;
    public static final EnumC2333q j;
    public static final EnumC2333q k;
    public static final EnumC2333q l;
    public static final EnumC2333q m;
    public static final EnumC2333q n;
    public static final EnumC2333q o;
    public static final EnumC2333q p;
    public static final /* synthetic */ EnumC2333q[] q;

    static {
        EnumC2333q enumC2333q = new EnumC2333q("MASTER_CARD", 0);
        a = enumC2333q;
        EnumC2333q enumC2333q2 = new EnumC2333q("VISA", 1);
        b = enumC2333q2;
        EnumC2333q enumC2333q3 = new EnumC2333q("MIR", 2);
        c = enumC2333q3;
        EnumC2333q enumC2333q4 = new EnumC2333q("AMERICAN_EXPRESS", 3);
        d = enumC2333q4;
        EnumC2333q enumC2333q5 = new EnumC2333q("JCB", 4);
        e = enumC2333q5;
        EnumC2333q enumC2333q6 = new EnumC2333q("CUP", 5);
        f = enumC2333q6;
        EnumC2333q enumC2333q7 = new EnumC2333q("DINERS_CLUB", 6);
        g = enumC2333q7;
        EnumC2333q enumC2333q8 = new EnumC2333q("BANK_CARD", 7);
        h = enumC2333q8;
        EnumC2333q enumC2333q9 = new EnumC2333q("DISCOVER_CARD", 8);
        i = enumC2333q9;
        EnumC2333q enumC2333q10 = new EnumC2333q("INSTA_PAYMENT", 9);
        j = enumC2333q10;
        EnumC2333q enumC2333q11 = new EnumC2333q("INSTA_PAYMENT_TM", 10);
        k = enumC2333q11;
        EnumC2333q enumC2333q12 = new EnumC2333q("LASER", 11);
        l = enumC2333q12;
        EnumC2333q enumC2333q13 = new EnumC2333q("DANKORT", 12);
        m = enumC2333q13;
        EnumC2333q enumC2333q14 = new EnumC2333q("SOLO", 13);
        n = enumC2333q14;
        EnumC2333q enumC2333q15 = new EnumC2333q("SWITCH", 14);
        o = enumC2333q15;
        EnumC2333q enumC2333q16 = new EnumC2333q("UNKNOWN", 15);
        p = enumC2333q16;
        EnumC2333q[] enumC2333qArr = {enumC2333q, enumC2333q2, enumC2333q3, enumC2333q4, enumC2333q5, enumC2333q6, enumC2333q7, enumC2333q8, enumC2333q9, enumC2333q10, enumC2333q11, enumC2333q12, enumC2333q13, enumC2333q14, enumC2333q15, enumC2333q16};
        q = enumC2333qArr;
        EnumEntriesKt.enumEntries(enumC2333qArr);
    }

    public EnumC2333q(String str, int i2) {
    }

    public static EnumC2333q valueOf(String str) {
        return (EnumC2333q) Enum.valueOf(EnumC2333q.class, str);
    }

    public static EnumC2333q[] values() {
        return (EnumC2333q[]) q.clone();
    }
}
