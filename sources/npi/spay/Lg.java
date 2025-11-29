package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Lg implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;
    public final Provider h;
    public final Provider i;

    public Lg(C1534d5 c1534d5, Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, C2039xc c2039xc, Provider provider6, Provider provider7) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = c2039xc;
        this.h = provider6;
        this.i = provider7;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Xf((C1955u3) this.a.get(), (Ih) this.b.get(), (C1993vg) this.c.get(), (Ei) this.d.get(), (InterfaceC1495bg) this.e.get(), (Qb) this.f.get(), (C1928t1) this.g.get(), (InterfaceC1728l0) this.h.get(), (no) this.i.get());
    }
}
