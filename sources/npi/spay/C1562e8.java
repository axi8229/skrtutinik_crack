package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.e8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1562e8 implements Factory {
    public final Vl a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public C1562e8(Vl vl, Ne ne, Provider provider, Provider provider2) {
        this.a = vl;
        this.b = ne;
        this.c = provider;
        this.d = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC2073yl sPayRepository = (InterfaceC2073yl) this.b.get();
        InterfaceC1495bg sPaySdkReducer = (InterfaceC1495bg) this.c.get();
        C1993vg featuresHandler = (C1993vg) this.d.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        return (r) Preconditions.checkNotNullFromProvides(new r(sPayRepository, sPaySdkReducer, featuresHandler));
    }
}
