package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class A9 implements Factory {
    public final Vl a;
    public final Provider b;
    public final Provider c;

    public A9(Vl vl, Ne ne, Provider provider) {
        this.a = vl;
        this.b = ne;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC2073yl sPayRepository = (InterfaceC2073yl) this.b.get();
        InterfaceC1495bg sPaySdkReducer = (InterfaceC1495bg) this.c.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        return (C1987va) Preconditions.checkNotNullFromProvides(new C1987va(sPayRepository, sPaySdkReducer));
    }
}
