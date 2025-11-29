package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Zg implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public Zg(C1534d5 c1534d5, Provider provider, Provider provider2, Provider provider3) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C1955u3 c1955u3 = (C1955u3) this.a.get();
        return new C1869qg((Ih) this.b.get(), (InterfaceC1495bg) this.d.get(), (Ei) this.c.get(), c1955u3);
    }
}
