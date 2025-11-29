package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Kh implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;

    public Kh(C1534d5 c1534d5, Provider provider, Provider provider2) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Tg((C1955u3) this.a.get(), (Ih) this.b.get(), (InterfaceC1495bg) this.c.get());
    }
}
