package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class qo implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public qo(Provider provider, Provider provider2, C2039xc c2039xc, Provider provider3, Provider provider4, Provider provider5, C1534d5 c1534d5) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
        this.d = c2039xc;
        this.e = provider3;
        this.f = provider4;
        this.g = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Qm((C1955u3) this.a.get(), (Ih) this.b.get(), (InterfaceC1495bg) this.c.get(), (C1928t1) this.d.get(), (C1993vg) this.e.get(), (Ei) this.f.get(), (InterfaceC1728l0) this.g.get());
    }
}
