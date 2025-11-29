package com.yandex.metrica.impl.ob;

import org.json.JSONException;

/* loaded from: classes3.dex */
public class O3 {
    private final Y8 a;
    private final C0819b8 b;

    public O3(C0819b8 c0819b8) {
        this(c0819b8, new Y8(c0819b8));
    }

    public int a() {
        int iB = this.b.b();
        this.b.a(iB + 1);
        return iB;
    }

    O3(C0819b8 c0819b8, Y8 y8) {
        this.b = c0819b8;
        this.a = y8;
    }

    public int a(int i) throws JSONException {
        int iA = this.a.a(i);
        this.a.a(i, iA + 1);
        return iA;
    }
}
