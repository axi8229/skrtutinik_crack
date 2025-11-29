package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Lj extends AbstractC1914sc {
    public final InterfaceC1847pj a;
    public final InterfaceC1495bg b;
    public final C1955u3 c;

    public Lj(InterfaceC1847pj fingerprintInteractor, Ei sPayStorage, InterfaceC1495bg sPaySdkReducer, C1955u3 metricUtil) {
        Intrinsics.checkNotNullParameter(fingerprintInteractor, "fingerprintInteractor");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(metricUtil, "metricUtil");
        this.a = fingerprintInteractor;
        this.b = sPaySdkReducer;
        this.c = metricUtil;
    }
}
