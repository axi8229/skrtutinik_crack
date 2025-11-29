package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Vc {
    private final C1315vc a;
    private final Xj b;
    private final H2 c;
    private final C1196qc d;
    private final C0895e9 e;

    public Vc(C1315vc c1315vc, H2 h2, C0895e9 c0895e9) {
        this(c1315vc, F0.g().v(), h2, c0895e9, F0.g().i());
    }

    private void a() {
        boolean zG = this.e.g();
        this.a.a(zG);
        this.c.a(zG);
        this.b.a(zG);
        this.d.c();
    }

    public void b(Object obj) {
        this.a.b(obj);
        this.b.b();
    }

    public Vc(C1315vc c1315vc, Xj xj, H2 h2, C0895e9 c0895e9, C1196qc c1196qc) {
        this.a = c1315vc;
        this.b = xj;
        this.c = h2;
        this.e = c0895e9;
        this.d = c1196qc;
        c1196qc.a(xj);
        a();
    }

    public void a(Object obj) {
        this.a.a(obj);
        this.b.a();
    }

    public void a(boolean z) {
        this.a.a(z);
        this.b.a(z);
        this.c.a(z);
        this.e.d(z);
    }

    public void a(C1178pi c1178pi) {
        this.d.a(c1178pi);
        this.c.a(c1178pi);
        this.b.a(c1178pi);
    }
}
