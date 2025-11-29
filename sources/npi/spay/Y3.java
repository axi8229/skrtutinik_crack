package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Y3 implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public Y3(C1534d5 c1534d5, Provider provider, Ri ri, Provider provider2, Provider provider3) {
        this.a = c1534d5;
        this.b = provider;
        this.c = ri;
        this.d = provider2;
        this.e = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C1632h3((C1955u3) this.a.get(), (Ih) this.b.get(), (Gk) this.c.get(), (InterfaceC1495bg) this.d.get(), (Ei) this.e.get());
    }
}
