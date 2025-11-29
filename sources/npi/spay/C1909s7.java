package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.s7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1909s7 implements Factory {
    public final L5 a;
    public final Provider b;
    public final C1534d5 c;

    public C1909s7(L5 l5, Provider provider, C1534d5 c1534d5) {
        this.a = l5;
        this.b = provider;
        this.c = c1534d5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        L5 l5 = this.a;
        InterfaceC1943tg secureSharedPreferences = (InterfaceC1943tg) this.b.get();
        C1955u3 metricFacade = (C1955u3) this.c.get();
        l5.getClass();
        Intrinsics.checkNotNullParameter(secureSharedPreferences, "secureSharedPreferences");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        return (H4) Preconditions.checkNotNullFromProvides(new H4(secureSharedPreferences, metricFacade));
    }
}
