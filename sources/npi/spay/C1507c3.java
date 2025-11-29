package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.c3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1507c3 implements Factory {
    public final Vl a;
    public final C1478b b;
    public final Provider c;

    public C1507c3(Vl vl, C1478b c1478b, Provider provider) {
        this.a = vl;
        this.b = c1478b;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC1847pj fingerprintInteractor = (InterfaceC1847pj) this.b.get();
        Ih sPayDataContract = (Ih) this.c.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(fingerprintInteractor, "fingerprintInteractor");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        return (U5) Preconditions.checkNotNullFromProvides(new U5(fingerprintInteractor, sPayDataContract));
    }
}
