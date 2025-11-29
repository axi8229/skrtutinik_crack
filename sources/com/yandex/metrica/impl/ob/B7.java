package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class B7 {
    private static final B7 c = new B7(new C0818b7());
    private final C0818b7 a;
    private a b = a.BLANK;

    private enum a {
        BLANK,
        LOADING_ERROR,
        LOADED
    }

    B7(C0818b7 c0818b7) {
        this.a = c0818b7;
    }

    public static B7 a() {
        return c;
    }

    public synchronized boolean b() {
        a aVar = this.b;
        a aVar2 = a.LOADED;
        if (aVar == aVar2) {
            return true;
        }
        if (aVar == a.LOADING_ERROR) {
            return false;
        }
        try {
            this.a.getClass();
            System.loadLibrary("appmetrica-service-native");
            this.b = aVar2;
            return true;
        } catch (Throwable unused) {
            this.b = a.LOADING_ERROR;
            return false;
        }
    }
}
