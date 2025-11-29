package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class M7 extends Lk {
    public final InterfaceC1495bg d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M7(Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage, C1955u3 metricFacade) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.d = sPaySdkReducer;
        C1822oj c1822oj = (C1822oj) sPayStorage;
        if (!(c1822oj.b().a() instanceof C1805o2)) {
            throw new De(c1822oj.b().toString());
        }
    }
}
