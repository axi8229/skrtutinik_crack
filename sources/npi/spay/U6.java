package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class U6 implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public U6(C1534d5 c1534d5, Provider provider, Provider provider2, Provider provider3) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C1585f6((Ih) this.b.get(), (InterfaceC1495bg) this.c.get(), (Ei) this.d.get(), (C1955u3) this.a.get());
    }
}
