package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Dg extends Va {
    public final InterfaceC2073yl a;
    public final Ih b;

    public Dg(InterfaceC2073yl sPayRepository, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.a = sPayRepository;
        this.b = sPayDataContract;
    }
}
