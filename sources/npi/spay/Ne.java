package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ne implements Factory {
    public final Vl a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final C1534d5 e;
    public final O5 f;

    public Ne(Vl vl, Provider provider, Provider provider2, Provider provider3, C1534d5 c1534d5, O5 o5) {
        this.a = vl;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = c1534d5;
        this.f = o5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Vl vl = this.a;
        InterfaceC1797nj sPayDataSource = (InterfaceC1797nj) this.b.get();
        Ih sPayDataContract = (Ih) this.c.get();
        C1993vg featuresHandler = (C1993vg) this.d.get();
        C1955u3 metricFacade = (C1955u3) this.e.get();
        InterfaceC1788na networkErrorHandler = (InterfaceC1788na) this.f.get();
        J9 networkErrorHandlerImpl = new J9();
        C1662i8 apiResponseErrorHandlerImpl = new C1662i8();
        vl.getClass();
        Intrinsics.checkNotNullParameter(sPayDataSource, "sPayDataSource");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(networkErrorHandler, "networkErrorHandler");
        Intrinsics.checkNotNullParameter(networkErrorHandlerImpl, "networkErrorHandlerImpl");
        Intrinsics.checkNotNullParameter(apiResponseErrorHandlerImpl, "apiResponseErrorHandlerImpl");
        return (InterfaceC2073yl) Preconditions.checkNotNullFromProvides(new Hm(sPayDataSource, sPayDataContract, featuresHandler, metricFacade, networkErrorHandler, networkErrorHandlerImpl, apiResponseErrorHandlerImpl));
    }
}
