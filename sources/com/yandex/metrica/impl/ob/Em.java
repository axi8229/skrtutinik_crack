package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public enum Em {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);

    private final int a;

    Em(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public static Em a(Integer num) {
        if (num != null) {
            Em[] emArrValues = values();
            for (int i = 0; i < 3; i++) {
                Em em = emArrValues[i];
                if (em.a == num.intValue()) {
                    return em;
                }
            }
        }
        return NONE;
    }
}
