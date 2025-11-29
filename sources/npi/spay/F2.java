package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;
import sberid.sdk.auth.login.SberIDLoginManager;

/* loaded from: classes4.dex */
public final class F2 implements Factory {
    public final Provider a;
    public final C1534d5 b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public F2(Provider provider, Provider provider2, Provider provider3, Xe xe, Provider provider4, Provider provider5, C1534d5 c1534d5) {
        this.a = provider;
        this.b = c1534d5;
        this.c = provider2;
        this.d = provider3;
        this.e = xe;
        this.f = provider4;
        this.g = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new W0((Ih) this.a.get(), (C1955u3) this.b.get(), (InterfaceC1626gm) this.c.get(), (Qb) this.d.get(), (SberIDLoginManager) this.e.get(), (InterfaceC1495bg) this.f.get(), (InterfaceC1728l0) this.g.get());
    }
}
