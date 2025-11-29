package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Ul implements Factory {
    public final Provider a;
    public final Provider b;

    public Ul(Ne ne, Provider provider) {
        this.a = ne;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Hk((InterfaceC2073yl) this.a.get(), (InterfaceC1495bg) this.b.get());
    }
}
