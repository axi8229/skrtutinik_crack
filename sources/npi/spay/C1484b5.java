package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.b5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1484b5 implements Factory {
    public final C1508c4 a;
    public final Provider b;
    public final Provider c;

    public C1484b5(C1508c4 c1508c4, Provider provider, Provider provider2) {
        this.a = c1508c4;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C1508c4 c1508c4 = this.a;
        Ei sPayStorage = (Ei) this.b.get();
        C1993vg featuresHandler = (C1993vg) this.c.get();
        c1508c4.getClass();
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        return (no) Preconditions.checkNotNullFromProvides(new no(sPayStorage, featuresHandler));
    }
}
