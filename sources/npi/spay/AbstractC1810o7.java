package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.o7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1810o7 extends AbstractC1819og {
    public C1982v5 c;
    public C2007w5 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1810o7(C1955u3 metricFacade, Ih sPayDataContract, Gk clearUtil, InterfaceC1495bg sPaySdkReducer) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(clearUtil, "clearUtil");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
    }

    @Override // npi.spay.AbstractC1819og
    public void a(AbstractC1794ng event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.a(event);
        Intrinsics.areEqual(event, C1883r6.a);
    }
}
