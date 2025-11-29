package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.rg, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1893rg implements Factory {
    public final Le a;
    public final Provider b;
    public final C1899rm c;

    public C1893rg(Le le, C1703k0 c1703k0, C1899rm c1899rm) {
        this.a = le;
        this.b = c1703k0;
        this.c = c1899rm;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Le le = this.a;
        C1876qn resourceManager = (C1876qn) this.b.get();
        InterfaceC1713ka commonRepository = (InterfaceC1713ka) this.c.get();
        le.getClass();
        Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        return (InterfaceC1846pi) Preconditions.checkNotNullFromProvides(new Qi(resourceManager, commonRepository));
    }
}
