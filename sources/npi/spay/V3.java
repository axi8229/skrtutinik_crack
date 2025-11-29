package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class V3 implements Factory {
    public final Vl a;
    public final Provider b;

    public V3(Vl vl, Provider provider) {
        this.a = vl;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        Ih sPayDataContract = (Ih) this.b.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        return (C1937ta) Preconditions.checkNotNullFromProvides(new C1937ta(sPayDataContract));
    }
}
