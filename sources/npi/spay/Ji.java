package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes4.dex */
public final class Ji implements Factory {
    public final C1620gg a;

    public Ji(C1620gg c1620gg) {
        this.a = c1620gg;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (C1898rl) Preconditions.checkNotNullFromProvides(new C1898rl());
    }
}
