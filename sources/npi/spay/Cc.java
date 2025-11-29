package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes4.dex */
public final class Cc extends AbstractC1810o7 {
    public final W1 e;
    public final MutableStateFlow f;
    public final StateFlow g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cc(C1955u3 metricFacade, Ih sPayDataContract, Gk clearSdkUtil, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage) {
        super(metricFacade, sPayDataContract, clearSdkUtil, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(clearSdkUtil, "clearSdkUtil");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        AbstractC1855q2 abstractC1855q2A = ((C1604g0) ((C1822oj) sPayStorage).a().getValue()).a();
        Intrinsics.checkNotNull(abstractC1855q2A, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.FraudMonReview");
        this.e = (W1) abstractC1855q2A;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.f = MutableStateFlow;
        this.g = FlowKt.asStateFlow(MutableStateFlow);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new Ac(this, null), 3, null);
    }
}
