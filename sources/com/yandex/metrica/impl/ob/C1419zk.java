package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.zk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1419zk {
    private final Tk a;
    private final C1006il b;
    private final C1006il c;
    private final C1006il d;

    C1419zk(C0932fl c0932fl) {
        this(new Tk(c0932fl == null ? null : c0932fl.e), new C1006il(c0932fl == null ? null : c0932fl.f), new C1006il(c0932fl == null ? null : c0932fl.h), new C1006il(c0932fl != null ? c0932fl.g : null));
    }

    void a(C0932fl c0932fl) {
        this.a.d(c0932fl.e);
        this.b.d(c0932fl.f);
        this.c.d(c0932fl.h);
        this.d.d(c0932fl.g);
    }

    AbstractC1395yk<?> b() {
        return this.b;
    }

    AbstractC1395yk<?> c() {
        return this.a;
    }

    AbstractC1395yk<?> d() {
        return this.c;
    }

    synchronized AbstractC1395yk<?> a() {
        return this.d;
    }

    C1419zk(Tk tk, C1006il c1006il, C1006il c1006il2, C1006il c1006il3) {
        this.a = tk;
        this.b = c1006il;
        this.c = c1006il2;
        this.d = c1006il3;
    }
}
