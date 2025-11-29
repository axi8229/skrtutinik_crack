package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public enum D0 {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);

    public final int a;

    D0(int i) {
        this.a = i;
    }

    public static D0 a(Integer num) {
        if (num != null) {
            D0[] d0ArrValues = values();
            for (int i = 0; i < 3; i++) {
                D0 d0 = d0ArrValues[i];
                if (d0.a == num.intValue()) {
                    return d0;
                }
            }
        }
        return UNKNOWN;
    }
}
