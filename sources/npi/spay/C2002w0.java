package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.w0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2002w0 implements Factory {
    public final Vl a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public C2002w0(Vl vl, Ne ne, Provider provider, Provider provider2, Provider provider3) {
        this.a = vl;
        this.b = ne;
        this.c = provider;
        this.d = provider2;
        this.e = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC2073yl sPayRepository = (InterfaceC2073yl) this.b.get();
        InterfaceC1495bg sPaySdkReducer = (InterfaceC1495bg) this.c.get();
        Qb authHandler = (Qb) this.d.get();
        H4 setCookieHandler = (H4) this.e.get();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        Intrinsics.checkNotNullParameter(setCookieHandler, "setCookieHandler");
        return (B0) Preconditions.checkNotNullFromProvides(new B0(sPayRepository, sPaySdkReducer, authHandler, setCookieHandler));
    }
}
