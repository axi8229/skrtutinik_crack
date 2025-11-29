package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class C8 implements Factory {
    public final Vl a;
    public final Provider b;
    public final Provider c;
    public final C1653i d;

    public C8(Vl vl, Ne ne, Provider provider, C1653i c1653i) {
        this.a = vl;
        this.b = ne;
        this.c = provider;
        this.d = c1653i;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC2073yl sPayRepository = (InterfaceC2073yl) this.b.get();
        InterfaceC1495bg sPaySdkReducer = (InterfaceC1495bg) this.c.get();
        C1612g8 fraudMonResultHandler = (C1612g8) this.d.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(fraudMonResultHandler, "fraudMonResultHandler");
        return (E7) Preconditions.checkNotNullFromProvides(new E7(sPayRepository, sPaySdkReducer, fraudMonResultHandler));
    }
}
