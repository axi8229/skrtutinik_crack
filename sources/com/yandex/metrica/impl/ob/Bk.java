package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
class Bk {
    private final Ak a;
    private final Ak b;
    private final Ak c;
    private final Ak d;

    static class a {
        a() {
        }
    }

    Bk(C1419zk c1419zk, C0932fl c0932fl) {
        this(new Ak(c1419zk.c(), a(c0932fl.e)), new Ak(c1419zk.b(), a(c0932fl.f)), new Ak(c1419zk.d(), a(c0932fl.h)), new Ak(c1419zk.a(), a(c0932fl.g)));
    }

    Ak a() {
        return this.d;
    }

    Ak b() {
        return this.b;
    }

    Ak c() {
        return this.a;
    }

    Ak d() {
        return this.c;
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    Bk(Ak ak, Ak ak2, Ak ak3, Ak ak4) {
        this.a = ak;
        this.b = ak2;
        this.c = ak3;
        this.d = ak4;
    }
}
