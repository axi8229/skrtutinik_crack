package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class E9 implements Factory {
    public final Provider a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;
    public final Provider h;

    public E9(M5 m5, Q4 q4, Provider provider, Provider provider2, C2098zl c2098zl, Provider provider3, Provider provider4, Provider provider5) {
        this.a = m5;
        this.b = q4;
        this.c = provider;
        this.d = provider2;
        this.e = c2098zl;
        this.f = provider3;
        this.g = provider4;
        this.h = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C7((Dc) this.a.get(), (Dg) this.b.get(), (InterfaceC1495bg) this.c.get(), (Ih) this.d.get(), (Zk) this.e.get(), (C1993vg) this.f.get(), (no) this.g.get(), (Ei) this.h.get());
    }
}
