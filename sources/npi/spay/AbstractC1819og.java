package npi.spay;

import androidx.lifecycle.ViewModel;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.og, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1819og extends ViewModel {
    public final C1955u3 a;
    public final Ih b;

    public AbstractC1819og(C1955u3 metricFacade, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer) {
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.a = metricFacade;
        this.b = sPayDataContract;
    }

    public void a(AbstractC1794ng event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, C1645hg.a) || Intrinsics.areEqual(event, C1669ig.a) || Intrinsics.areEqual(event, C1694jg.a) || Intrinsics.areEqual(event, C1719kg.a) || Intrinsics.areEqual(event, C1744lg.a)) {
            return;
        }
        Intrinsics.areEqual(event, C1769mg.a);
    }
}
