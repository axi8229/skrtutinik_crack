package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.vl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1998vl implements Factory {
    public final Provider a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;

    public C1998vl(M5 m5, Q4 q4, C1459a5 c1459a5, Provider provider, Provider provider2, C2039xc c2039xc) {
        this.a = m5;
        this.b = q4;
        this.c = c1459a5;
        this.d = provider;
        this.e = provider2;
        this.f = c2039xc;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C1697jj((Dc) this.a.get(), (Dg) this.b.get(), (C1731l3) this.c.get(), (Ih) this.d.get(), (Ei) this.e.get(), (C1928t1) this.f.get());
    }
}
