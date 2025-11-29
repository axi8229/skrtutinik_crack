package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class He implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public He(Provider provider, Provider provider2, Provider provider3, Provider provider4, C1470ag c1470ag, Provider provider5, C1534d5 c1534d5) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = c1470ag;
        this.g = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C1889rc((C1955u3) this.a.get(), (Ih) this.b.get(), (InterfaceC1495bg) this.c.get(), (Ei) this.d.get(), (Qb) this.e.get(), (C2015wd) this.f.get(), (H4) this.g.get());
    }
}
