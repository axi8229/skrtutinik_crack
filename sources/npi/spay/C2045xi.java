package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.xi, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2045xi implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;
    public final Provider h;

    public C2045xi(C1534d5 c1534d5, Provider provider, Ri ri, Provider provider2, Provider provider3, C2039xc c2039xc, Provider provider4, Provider provider5) {
        this.a = c1534d5;
        this.b = provider;
        this.c = ri;
        this.d = provider2;
        this.e = provider3;
        this.f = c2039xc;
        this.g = provider4;
        this.h = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C2094zh((C1955u3) this.a.get(), (Ih) this.b.get(), (Gk) this.c.get(), (InterfaceC1495bg) this.d.get(), (Ei) this.e.get(), (C1928t1) this.f.get(), (InterfaceC1728l0) this.g.get(), (C1993vg) this.h.get());
    }
}
