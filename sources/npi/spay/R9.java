package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes4.dex */
public final class R9 implements Factory {
    public final C1910s8 a;

    public R9(C1910s8 c1910s8) {
        this.a = c1910s8;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (C1993vg) Preconditions.checkNotNullFromProvides(new C1993vg());
    }
}
