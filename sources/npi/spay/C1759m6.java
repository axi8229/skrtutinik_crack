package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.m6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1759m6 implements Factory {
    public final Provider a;
    public final Provider b;
    public final Provider c;
    public final C1534d5 d;
    public final Provider e;
    public final Provider f;
    public final Provider g;
    public final Provider h;
    public final Provider i;
    public final Provider j;
    public final Provider k;
    public final Provider l;
    public final Provider m;
    public final Provider n;

    public C1759m6(Provider provider, Provider provider2, Provider provider3, C1534d5 c1534d5, Ri ri, Provider provider4, E9 e9, F2 f2, C1600fl c1600fl, Me me2, C1971uj c1971uj, Oh oh, C1507c3 c1507c3, Provider provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = c1534d5;
        this.e = ri;
        this.f = provider4;
        this.g = e9;
        this.h = f2;
        this.i = c1600fl;
        this.j = me2;
        this.k = c1971uj;
        this.l = oh;
        this.m = c1507c3;
        this.n = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new A2((Ei) this.a.get(), (Ih) this.b.get(), (InterfaceC1495bg) this.c.get(), (C1955u3) this.d.get(), (Gk) this.e.get(), (Qb) this.f.get(), (C7) this.g.get(), (W0) this.h.get(), (Ek) this.i.get(), (C2014wc) this.j.get(), (C1876qn) this.k.get(), (F9) this.l.get(), (U5) this.m.get(), (C1993vg) this.n.get());
    }
}
