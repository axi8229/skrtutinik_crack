package npi.spay;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes4.dex */
public abstract class Ti extends Lk {
    public final MutableStateFlow d;
    public final StateFlow e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ti(C1955u3 metricFacade, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.d = StateFlowKt.MutableStateFlow(new C2064yc(null));
        this.e = ((Di) sPayDataContract).n();
    }

    public Unit a(AbstractC1646hh event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, C1621gh.a)) {
            a(EnumC1595fg.LC_STATUS_VIEW_DISAPPEARED);
        } else if (Intrinsics.areEqual(event, C1571eh.a)) {
            ((Jh) this.c).a(C1975un.a);
        }
        return Unit.INSTANCE;
    }

    public final StateFlow c() {
        return FlowKt.asStateFlow(this.d);
    }

    public final void a(EnumC1595fg action) {
        Intrinsics.checkNotNullParameter(action, "action");
        C1560e6 event = new C1560e6(action, EnumC1877r0.STATUS_VIEW, C0.LC, null, null, null, null, 120);
        Intrinsics.checkNotNullParameter(event, "event");
        this.a.a(event);
    }
}
