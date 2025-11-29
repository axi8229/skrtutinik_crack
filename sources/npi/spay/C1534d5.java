package npi.spay;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.d5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1534d5 implements Factory {
    public final C1832p4 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final C1962ua e;

    public C1534d5(C1832p4 c1832p4, Factory factory, Provider provider, Provider provider2, C1962ua c1962ua) {
        this.a = c1832p4;
        this.b = factory;
        this.c = provider;
        this.d = provider2;
        this.e = c1962ua;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C1832p4 c1832p4 = this.a;
        Context context = (Context) this.b.get();
        C1993vg featuresHandler = (C1993vg) this.c.get();
        Ih sPayDataContract = (Ih) this.d.get();
        F9 appNameUtil = (F9) this.e.get();
        c1832p4.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(appNameUtil, "appNameUtil");
        return (C1955u3) Preconditions.checkNotNullFromProvides(new C1955u3(context, featuresHandler, sPayDataContract, appNameUtil));
    }
}
