package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.ch, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1521ch implements Factory {
    public final Vl a;
    public final Provider b;
    public final Provider c;
    public final C1534d5 d;

    public C1521ch(Vl vl, Provider provider, Provider provider2, C1534d5 c1534d5) {
        this.a = vl;
        this.b = provider;
        this.c = provider2;
        this.d = c1534d5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        Ei sPayStorage = (Ei) this.b.get();
        Ih sPayDataContract = (Ih) this.c.get();
        C1955u3 metricFacade = (C1955u3) this.d.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        return (InterfaceC1495bg) Preconditions.checkNotNullFromProvides(new Jh(sPayStorage, sPayDataContract, metricFacade));
    }
}
