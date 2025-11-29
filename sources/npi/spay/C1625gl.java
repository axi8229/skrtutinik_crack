package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.gl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1625gl implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public C1625gl(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, Zm zm, C1534d5 c1534d5) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = zm;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Jj((C1955u3) this.a.get(), (Ih) this.b.get(), (Ei) this.c.get(), (InterfaceC1495bg) this.d.get(), (C1993vg) this.e.get(), (Qb) this.f.get(), (C1824ol) this.g.get());
    }
}
