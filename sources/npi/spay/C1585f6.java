package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.f6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1585f6 extends Lk {
    public final InterfaceC1495bg d;
    public final C1661i7 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1585f6(Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage, C1955u3 metricFacade) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        this.d = sPaySdkReducer;
        C1822oj c1822oj = (C1822oj) sPayStorage;
        AbstractC1855q2 abstractC1855q2A = c1822oj.b().a();
        if (!(abstractC1855q2A instanceof C1581f2)) {
            throw new De(c1822oj.b().toString());
        }
        this.e = new C1661i7(((C1581f2) abstractC1855q2A).a());
    }
}
