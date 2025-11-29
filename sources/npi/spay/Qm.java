package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes4.dex */
public final class Qm extends Ti {
    public final StateFlow f;
    public final StateFlow g;
    public final Flow h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Qm(C1955u3 metricFacade, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, C1928t1 helperManager, C1993vg featuresHandler, Ei sPayStorage, InterfaceC1728l0 sPaySdkConfigRepository) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(helperManager, "helperManager");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        Di di = (Di) sPayDataContract;
        Flow flowMapLatest = FlowKt.mapLatest(di.i(), new Nm(null));
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        StateFlow stateFlowStateIn = FlowKt.stateIn(flowMapLatest, viewModelScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.f = FlowKt.stateIn(FlowKt.combine(di.f(), stateFlowStateIn, new Pm(helperManager, sPaySdkConfigRepository, sPayStorage, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.g = FlowKt.stateIn(FlowKt.mapLatest(FlowKt.filterNotNull(stateFlowStateIn), new Om(helperManager, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.h = FlowKt.mapLatest(((C1822oj) sPayStorage).a(), new Mm(featuresHandler, null));
    }

    @Override // npi.spay.Ti
    public final Unit a(AbstractC1646hh event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof C1596fh)) {
            return super.a(event);
        }
        a(EnumC1595fg.LC_STATUS_SUCCESS_VIEW_APPEARED);
        return Unit.INSTANCE;
    }
}
