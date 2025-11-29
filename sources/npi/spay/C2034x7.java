package npi.spay;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.x7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2034x7 extends Ti {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2034x7(C1955u3 metricFacade, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
    }

    @Override // npi.spay.Ti
    public final Unit a(AbstractC1646hh event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof C1596fh)) {
            return super.a(event);
        }
        a(EnumC1595fg.LC_STATUS_ERROR_VIEW_APPEARED);
        return Unit.INSTANCE;
    }
}
