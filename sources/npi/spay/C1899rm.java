package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.rm, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1899rm implements Factory {
    public final C2048xl a;
    public final C1474ak b;
    public final O5 c;
    public final X3 d;
    public final Provider e;
    public final Provider f;

    public C1899rm(C2048xl c2048xl, C1474ak c1474ak, O5 o5, X3 x3, Provider provider, C1534d5 c1534d5) {
        this.a = c2048xl;
        this.b = c1474ak;
        this.c = o5;
        this.d = x3;
        this.e = provider;
        this.f = c1534d5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2048xl c2048xl = this.a;
        InterfaceC1536d7 sdkFlowSPayApi = (InterfaceC1536d7) this.b.get();
        InterfaceC1788na networkErrorHandler = (InterfaceC1788na) this.c.get();
        InterfaceC1788na apiResponseErrorHandler = (InterfaceC1788na) this.d.get();
        Ih sPayDataContract = (Ih) this.e.get();
        J9 networkErrorHandlerImpl = new J9();
        C1662i8 apiResponseErrorHandlerImpl = new C1662i8();
        C1955u3 metricFacade = (C1955u3) this.f.get();
        c2048xl.getClass();
        Intrinsics.checkNotNullParameter(sdkFlowSPayApi, "sdkFlowSPayApi");
        Intrinsics.checkNotNullParameter(networkErrorHandler, "networkErrorHandler");
        Intrinsics.checkNotNullParameter(apiResponseErrorHandler, "apiResponseErrorHandler");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(networkErrorHandlerImpl, "networkErrorHandlerImpl");
        Intrinsics.checkNotNullParameter(apiResponseErrorHandlerImpl, "apiResponseErrorHandlerImpl");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        return (InterfaceC1713ka) Preconditions.checkNotNullFromProvides(new Db(sdkFlowSPayApi, sPayDataContract, networkErrorHandler, apiResponseErrorHandler, apiResponseErrorHandlerImpl, networkErrorHandlerImpl, metricFacade));
    }
}
