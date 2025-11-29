package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: npi.spay.t0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1927t0 implements Factory {
    public final Rl a;

    public C1927t0(Rl rl) {
        this.a = rl;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (C1853q0) Preconditions.checkNotNullFromProvides(new C1853q0());
    }
}
