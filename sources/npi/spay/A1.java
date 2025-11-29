package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import spay.sdk.domain.model.response.SPaySdkConfig;

/* loaded from: classes4.dex */
public final class A1 extends Lk {
    public final StateFlow d;
    public final MutableStateFlow e;
    public final StateFlow f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A1(C1955u3 metricFacade, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, InterfaceC1728l0 sPaySdkConfigRepository) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        this.d = FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(new C2064yc(Boolean.FALSE)));
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.e = MutableStateFlow;
        this.f = FlowKt.asStateFlow(MutableStateFlow);
        a(sPaySdkConfigRepository);
    }

    public final void a(InterfaceC1728l0 interfaceC1728l0) {
        MutableStateFlow mutableStateFlow = this.e;
        SPaySdkConfig sPaySdkConfig = ((O0) interfaceC1728l0).c;
        if (sPaySdkConfig == null) {
            throw C1808o5.a;
        }
        mutableStateFlow.tryEmit(sPaySdkConfig.getLocalization().getPayError());
    }
}
