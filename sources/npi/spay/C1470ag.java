package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.ag, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1470ag implements Factory {
    public final Provider a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public C1470ag(Ne ne, Provider provider, Provider provider2, Provider provider3) {
        this.a = ne;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C2015wd((InterfaceC2073yl) this.a.get(), (Ei) this.b.get(), (InterfaceC1495bg) this.c.get(), (Ih) this.d.get());
    }
}
