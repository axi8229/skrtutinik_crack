package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.y7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2059y7 implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public C2059y7(Provider provider, Ri ri, Provider provider2, Provider provider3, Provider provider4, Provider provider5, C1534d5 c1534d5) {
        this.a = c1534d5;
        this.b = provider;
        this.c = ri;
        this.d = provider2;
        this.e = provider3;
        this.f = provider4;
        this.g = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new K6((C1955u3) this.a.get(), (Ih) this.b.get(), (Gk) this.c.get(), (InterfaceC1495bg) this.d.get(), (Ei) this.e.get(), (C1993vg) this.f.get(), (Qb) this.g.get());
    }
}
