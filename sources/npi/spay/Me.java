package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Me implements Factory {
    public final Provider a;
    public final Provider b;

    public Me(Ne ne, Provider provider) {
        this.a = ne;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C2014wc((InterfaceC2073yl) this.a.get(), (InterfaceC1495bg) this.b.get());
    }
}
