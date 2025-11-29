package com.yandex.metrica;

@Deprecated
/* loaded from: classes3.dex */
public enum b {
    PHONE("phone"),
    TABLET("tablet"),
    TV("tv");

    private final String a;

    b(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public static b a(String str) {
        b[] bVarArrValues = values();
        for (int i = 0; i < 3; i++) {
            b bVar = bVarArrValues[i];
            if (bVar.a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }
}
