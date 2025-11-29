package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class B6 implements Factory {
    public final L5 a;
    public final Provider b;

    public B6(L5 l5, Provider provider) {
        this.a = l5;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        L5 l5 = this.a;
        H4 setCookieHandler = (H4) this.b.get();
        l5.getClass();
        Intrinsics.checkNotNullParameter(setCookieHandler, "setCookieHandler");
        return (C1740lc) Preconditions.checkNotNullFromProvides(new C1740lc(setCookieHandler));
    }
}
