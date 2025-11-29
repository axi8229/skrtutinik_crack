package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class M5 implements Factory {
    public final Vl a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public M5(Vl vl, Ne ne, Provider provider, Provider provider2) {
        this.a = vl;
        this.b = ne;
        this.c = provider;
        this.d = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC2073yl sPayRepository = (InterfaceC2073yl) this.b.get();
        Ih sPayDataContract = (Ih) this.c.get();
        InterfaceC1495bg sPaySdkReducer = (InterfaceC1495bg) this.d.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        return (Dc) Preconditions.checkNotNullFromProvides(new Dc(sPayRepository, sPayDataContract, sPaySdkReducer));
    }
}
