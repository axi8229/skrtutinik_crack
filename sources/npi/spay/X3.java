package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes4.dex */
public final class X3 implements Factory {
    public final C1557e3 a;

    public X3(C1557e3 c1557e3) {
        this.a = c1557e3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (InterfaceC1788na) Preconditions.checkNotNullFromProvides(new C1662i8());
    }
}
