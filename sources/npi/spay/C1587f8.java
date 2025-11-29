package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.f8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1587f8 implements Factory {
    public final C1534d5 a;
    public final Provider b;
    public final Provider c;

    public C1587f8(C1534d5 c1534d5, Provider provider, Provider provider2) {
        this.a = c1534d5;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C2034x7((C1955u3) this.a.get(), (Ih) this.b.get(), (InterfaceC1495bg) this.c.get());
    }
}
