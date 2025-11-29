package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.t7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1934t7 implements Factory {
    public final Vl a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public C1934t7(Vl vl, Ne ne, Provider provider, Provider provider2, Provider provider3, Provider provider4, C1653i c1653i) {
        this.a = vl;
        this.b = ne;
        this.c = provider;
        this.d = provider2;
        this.e = provider3;
        this.f = provider4;
        this.g = c1653i;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC2073yl sPayRepository = (InterfaceC2073yl) this.b.get();
        InterfaceC1495bg sPaySdkReducer = (InterfaceC1495bg) this.c.get();
        Ih sPayDataContract = (Ih) this.d.get();
        Ei sPayStorage = (Ei) this.e.get();
        C1993vg featuresHandler = (C1993vg) this.f.get();
        C1612g8 fraudMonResultHandler = (C1612g8) this.g.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(fraudMonResultHandler, "fraudMonResultHandler");
        return (Nk) Preconditions.checkNotNullFromProvides(new Nk(sPayDataContract, sPaySdkReducer, sPayRepository, sPayStorage, fraudMonResultHandler, featuresHandler));
    }
}
