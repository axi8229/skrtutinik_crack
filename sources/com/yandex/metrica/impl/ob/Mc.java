package com.yandex.metrica.impl.ob;

import android.location.Location;

/* loaded from: classes3.dex */
class Mc {
    private final Bc a;
    private final C0973hc b;
    private final Sc c;
    private final Rb d;

    public Mc(Nc nc) {
        Oc oc = new Oc(nc.a.a);
        Sb sb = nc.a;
        this(nc, oc, new Sc(sb.a, nc.b, nc.c, nc.d, nc.e, sb.b), new Rb(nc.c, nc.d, nc.e));
    }

    public void a() {
        this.c.a();
    }

    public Location b() {
        return this.a.b();
    }

    public void c() {
        this.a.a();
        this.b.b();
    }

    public void d() {
        this.a.c();
        this.b.d();
    }

    public void e() {
        this.a.d();
        this.b.e();
    }

    private Mc(Nc nc, Oc oc, Sc sc, Rb rb) {
        this(nc, oc, Cc.a(nc, sc, rb, oc.a()), sc, rb);
    }

    public void a(C1178pi c1178pi) {
        this.c.a(c1178pi);
        this.a.a(c1178pi);
    }

    public void a(C1097mc c1097mc) {
        this.c.a(c1097mc);
        this.d.a(c1097mc);
        this.a.a(c1097mc);
        this.b.a(c1097mc);
    }

    private Mc(Nc nc, Oc oc, Cc cc, Sc sc, Rb rb) {
        this(nc, oc, cc, new Pc(nc.a.a, nc.c, sc, rb, nc.b.d()), sc, rb);
    }

    private Mc(Nc nc, Oc oc, Cc cc, Pc pc, Sc sc, Rb rb) {
        this(nc, new Bc(cc, pc), new C0973hc(C0998ic.a(nc, sc, rb, oc.c(), oc.b())), sc, rb);
    }

    Mc(Nc nc, Bc bc, C0973hc c0973hc, Sc sc, Rb rb) {
        this.a = bc;
        this.b = c0973hc;
        this.c = sc;
        this.d = rb;
    }
}
