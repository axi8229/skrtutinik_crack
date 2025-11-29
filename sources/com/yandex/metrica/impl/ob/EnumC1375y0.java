package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.y0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC1375y0 {
    NATIVE(0),
    JS(1);

    public final int a;

    EnumC1375y0(int i) {
        this.a = i;
    }

    public static EnumC1375y0 a(int i) {
        EnumC1375y0[] enumC1375y0ArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            EnumC1375y0 enumC1375y0 = enumC1375y0ArrValues[i2];
            if (enumC1375y0.a == i) {
                return enumC1375y0;
            }
        }
        return NATIVE;
    }
}
