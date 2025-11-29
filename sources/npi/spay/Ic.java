package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Ic implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public Ic(C1534d5 c1534d5, Provider provider, Provider provider2, Provider provider3, Xg xg) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = xg;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Ub((C1955u3) this.a.get(), (Ih) this.b.get(), (InterfaceC1495bg) this.c.get(), (Ei) this.d.get(), (I9) this.e.get());
    }
}
