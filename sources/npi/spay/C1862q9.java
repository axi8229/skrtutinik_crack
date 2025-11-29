package npi.spay;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.q9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1862q9 implements Factory {
    public final C1910s8 a;
    public final Provider b;
    public final Provider c;

    public C1862q9(C1910s8 c1910s8, Factory factory, Provider provider) {
        this.a = c1910s8;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C1910s8 c1910s8 = this.a;
        Context context = (Context) this.b.get();
        C1993vg featuresHandler = (C1993vg) this.c.get();
        c1910s8.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        return (Qb) Preconditions.checkNotNullFromProvides(new Ec(context, featuresHandler));
    }
}
