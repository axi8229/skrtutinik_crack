package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.n8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1786n8 implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public C1786n8(Provider provider, Provider provider2, Provider provider3, Ul ul, Me me2, Ji ji, C1534d5 c1534d5) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = ul;
        this.f = me2;
        this.g = ji;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C2081z4((C1955u3) this.a.get(), (Ih) this.b.get(), (InterfaceC1495bg) this.c.get(), (Ei) this.d.get(), (Hk) this.e.get(), (C2014wc) this.f.get(), (C1898rl) this.g.get());
    }
}
