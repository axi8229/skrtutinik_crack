package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class U5 extends Id {
    public final InterfaceC1847pj a;
    public final Ih b;

    public U5(InterfaceC1847pj fingerprintInteractor, Ih sPayDataContract) {
        Intrinsics.checkNotNullParameter(fingerprintInteractor, "fingerprintInteractor");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        this.a = fingerprintInteractor;
        this.b = sPayDataContract;
    }
}
