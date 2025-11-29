package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.c5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1509c5 implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public C1509c5(C1534d5 c1534d5, Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C1807o4((C1955u3) this.a.get(), (Ih) this.b.get(), (Ei) this.c.get(), (InterfaceC1495bg) this.d.get(), (C1993vg) this.e.get());
    }
}
