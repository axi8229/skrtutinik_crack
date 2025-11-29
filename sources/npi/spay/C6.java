package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class C6 implements Factory {
    public final Vl a;
    public final Provider b;

    public C6(Vl vl, Provider provider) {
        this.a = vl;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC1495bg reducer = (InterfaceC1495bg) this.b.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        return (C1970ui) Preconditions.checkNotNullFromProvides(new C1970ui(reducer));
    }
}
