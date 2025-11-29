package npi.spay;

import bz.C0555t1;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1478b implements Factory {
    public final Rl a;
    public final Sm b;
    public final C1927t0 c;

    public C1478b(Rl rl, Sm sm, C1927t0 c1927t0) {
        this.a = rl;
        this.b = sm;
        this.c = c1927t0;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Rl rl = this.a;
        C0555t1 fingerprintSdkFactory = (C0555t1) this.b.get();
        C1853q0 systemProperties = (C1853q0) this.c.get();
        rl.getClass();
        Intrinsics.checkNotNullParameter(fingerprintSdkFactory, "fingerprintSdkFactory");
        Intrinsics.checkNotNullParameter(systemProperties, "systemProperties");
        return (InterfaceC1847pj) Preconditions.checkNotNullFromProvides(new C2022wk(fingerprintSdkFactory, systemProperties));
    }
}
