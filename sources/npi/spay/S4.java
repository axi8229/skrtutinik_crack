package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes4.dex */
public final class S4 implements Factory {
    public final C1557e3 a;

    public S4(C1557e3 c1557e3) {
        this.a = c1557e3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (C1523cj) Preconditions.checkNotNullFromProvides(new C1523cj());
    }
}
