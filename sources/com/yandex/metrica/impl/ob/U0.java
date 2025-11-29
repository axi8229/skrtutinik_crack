package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public enum U0 {
    OK("OK"),
    IDENTIFIER_PROVIDER_UNAVAILABLE("IDENTIFIER_PROVIDER_UNAVAILABLE"),
    INVALID_ADV_ID("INVALID_ADV_ID"),
    NO_STARTUP("NO_STARTUP"),
    FEATURE_DISABLED("FEATURE_DISABLED"),
    UNKNOWN("UNKNOWN");

    private final String a;

    U0(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public static U0 a(String str) {
        U0[] u0ArrValues = values();
        for (int i = 0; i < 6; i++) {
            U0 u0 = u0ArrValues[i];
            if (u0.a.equals(str)) {
                return u0;
            }
        }
        return UNKNOWN;
    }
}
