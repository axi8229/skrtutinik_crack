package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.oa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1813oa implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public C1813oa(C1534d5 c1534d5, Provider provider, C1783n5 c1783n5, Provider provider2) {
        this.a = c1534d5;
        this.b = provider;
        this.c = c1783n5;
        this.d = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new G8((C1955u3) this.a.get(), (Ih) this.b.get(), (F4) this.c.get(), (InterfaceC1495bg) this.d.get());
    }
}
