package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes4.dex */
public final class Eh extends Ti {
    public final StateFlow f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Eh(C1955u3 metricFacade, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, InterfaceC1728l0 sPaySdkConfigRepository) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        this.f = FlowKt.stateIn(FlowKt.mapLatest(c(), new Dh(sPaySdkConfigRepository, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), null);
    }

    @Override // npi.spay.Ti
    public final Unit a(AbstractC1646hh event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof C1596fh)) {
            return super.a(event);
        }
        a(EnumC1595fg.LC_STATUS_IN_PROGRESS_VIEW_APPEARED);
        return Unit.INSTANCE;
    }
}
