package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes4.dex */
public final class U9 implements Factory {
    public final C1985v8 a;

    public U9(C1985v8 c1985v8) {
        this.a = c1985v8;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (InterfaceC1997vk) Preconditions.checkNotNullFromProvides(new Y7());
    }
}
