package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ri implements Factory {
    public final C1895ri a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public Ri(C1895ri c1895ri, Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.a = c1895ri;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C1895ri c1895ri = this.a;
        Ih dataContract = (Ih) this.b.get();
        Ei sPayStorage = (Ei) this.c.get();
        C1993vg featuresHandler = (C1993vg) this.d.get();
        Qb authHandler = (Qb) this.e.get();
        c1895ri.getClass();
        Intrinsics.checkNotNullParameter(dataContract, "dataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        return (Gk) Preconditions.checkNotNullFromProvides(new Gk(dataContract, sPayStorage, featuresHandler, authHandler));
    }
}
