package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.Interceptor;

/* renamed from: npi.spay.xf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2042xf implements Factory {
    public final Jc a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public C2042xf(Jc jc, S4 s4, Provider provider, Provider provider2) {
        this.a = jc;
        this.b = s4;
        this.c = provider;
        this.d = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return (Interceptor) Preconditions.checkNotNullFromProvides(this.a.a((C1523cj) this.b.get(), (Ih) this.c.get(), (C1740lc) this.d.get()));
    }
}
