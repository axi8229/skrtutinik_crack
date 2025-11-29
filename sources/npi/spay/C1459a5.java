package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.a5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1459a5 implements Factory {
    public final Provider a;
    public final Provider b;

    public C1459a5(Ne ne, Provider provider) {
        this.a = ne;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C1731l3((InterfaceC2073yl) this.a.get(), (Ih) this.b.get());
    }
}
