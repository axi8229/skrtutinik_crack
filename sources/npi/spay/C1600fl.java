package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.fl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1600fl implements Factory {
    public final Provider a;
    public final C1534d5 b;

    public C1600fl(Provider provider, C1534d5 c1534d5) {
        this.a = provider;
        this.b = c1534d5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Ek((Qb) this.a.get(), (C1955u3) this.b.get());
    }
}
