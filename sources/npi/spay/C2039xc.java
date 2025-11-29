package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.xc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2039xc implements Factory {
    public final Vl a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public C2039xc(Vl vl, Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.a = vl;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        C1993vg featuresHandler = (C1993vg) this.b.get();
        Ih sPayDataContract = (Ih) this.c.get();
        Ei sPayStorage = (Ei) this.d.get();
        InterfaceC1728l0 sPaySdkConfigRepository = (InterfaceC1728l0) this.e.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        return (C1928t1) Preconditions.checkNotNullFromProvides(new C1928t1(featuresHandler, sPayDataContract, sPayStorage, sPaySdkConfigRepository));
    }
}
