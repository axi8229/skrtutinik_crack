package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes4.dex */
public final class Ub extends Lk {
    public final I9 d;
    public final MutableStateFlow e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ub(C1955u3 metricFacade, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage, I9 logFileManager) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(logFileManager, "logFileManager");
        this.d = logFileManager;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.e = MutableStateFlow;
        FlowKt.asStateFlow(MutableStateFlow);
        c();
    }

    public final void c() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new Tb(this, null), 3, null);
    }
}
