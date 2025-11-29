package bz;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: bz.q0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0546q0 implements Factory {
    public final Provider a;
    public final Provider b;

    public C0546q0(Provider provider, Provider provider2) {
        this.a = provider;
        this.b = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return (L1) Preconditions.checkNotNull(new D(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
