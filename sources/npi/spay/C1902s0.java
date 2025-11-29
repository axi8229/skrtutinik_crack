package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.s0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1902s0 implements Factory {
    public final C1453a a;
    public final Provider b;

    public C1902s0(C1453a c1453a, Provider provider) {
        this.a = c1453a;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C1453a c1453a = this.a;
        InterfaceC1495bg sPaySdkReducer = (InterfaceC1495bg) this.b.get();
        c1453a.getClass();
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        return (InterfaceC1626gm) Preconditions.checkNotNullFromProvides(new C1502bn(sPaySdkReducer));
    }
}
