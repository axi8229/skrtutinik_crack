package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Lk extends AbstractC1819og {
    public final InterfaceC1495bg c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Lk(C1955u3 metricFacade, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.c = sPaySdkReducer;
    }
}
