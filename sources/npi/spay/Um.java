package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Um implements Factory {
    public final Vl a;
    public final C1478b b;
    public final Provider c;
    public final Provider d;
    public final C1534d5 e;

    public Um(Vl vl, C1478b c1478b, Provider provider, Provider provider2, C1534d5 c1534d5) {
        this.a = vl;
        this.b = c1478b;
        this.c = provider;
        this.d = provider2;
        this.e = c1534d5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC1847pj fingerprintInteractor = (InterfaceC1847pj) this.b.get();
        Ei sPayStorage = (Ei) this.c.get();
        InterfaceC1495bg reducer = (InterfaceC1495bg) this.d.get();
        C1955u3 metricFacade = (C1955u3) this.e.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(fingerprintInteractor, "fingerprintInteractor");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        return (Lj) Preconditions.checkNotNullFromProvides(new Lj(fingerprintInteractor, sPayStorage, reducer, metricFacade));
    }
}
