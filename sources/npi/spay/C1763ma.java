package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.ma, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1763ma implements Factory {
    public final Vl a;
    public final Provider b;
    public final C1899rm c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public C1763ma(Vl vl, Ne ne, C1899rm c1899rm, Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.a = vl;
        this.b = ne;
        this.c = c1899rm;
        this.d = provider;
        this.e = provider2;
        this.f = provider3;
        this.g = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC2073yl sPayRepository = (InterfaceC2073yl) this.b.get();
        InterfaceC1713ka commonRepository = (InterfaceC1713ka) this.c.get();
        InterfaceC1495bg sPaySdkReducer = (InterfaceC1495bg) this.d.get();
        Ih sPayDataContract = (Ih) this.e.get();
        C1993vg featuresHandler = (C1993vg) this.f.get();
        InterfaceC1728l0 sPaySdkConfigRepository = (InterfaceC1728l0) this.g.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        return (C1543de) Preconditions.checkNotNullFromProvides(new C1543de(sPayRepository, commonRepository, sPaySdkReducer, sPayDataContract, featuresHandler, sPaySdkConfigRepository));
    }
}
