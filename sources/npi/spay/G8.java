package npi.spay;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes4.dex */
public final class G8 extends Lk implements InterfaceC1859q6 {
    public final F4 d;
    public final MutableStateFlow e;
    public final StateFlow f;
    public CountDownTimerC1537d8 g;
    public long h;
    public final long i;
    public final F8 j;
    public final E8 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G8(C1955u3 metricFacade, Ih sPayDataContract, F4 restoreSessionIdUseCase, InterfaceC1495bg sPaySdkReducer) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(restoreSessionIdUseCase, "restoreSessionIdUseCase");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.d = restoreSessionIdUseCase;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.e = MutableStateFlow;
        this.f = FlowKt.asStateFlow(MutableStateFlow);
        this.h = 4000L;
        this.i = 1000L;
        this.j = new F8(this);
        this.k = new E8(this);
    }

    @Override // npi.spay.InterfaceC1859q6
    public final Function1 a() {
        return this.j;
    }

    @Override // npi.spay.InterfaceC1859q6
    public final Function0 b() {
        return this.k;
    }

    @Override // npi.spay.AbstractC1819og
    public final void a(AbstractC1794ng viewState) {
        CountDownTimerC1537d8 countDownTimerC1537d8;
        Intrinsics.checkNotNullParameter(viewState, "event");
        super.a(viewState);
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        if (Intrinsics.areEqual(viewState, C1744lg.a)) {
            this.g = new CountDownTimerC1537d8(this.h, this.i, new K4(this), new C1932t5(this));
            return;
        }
        if (Intrinsics.areEqual(viewState, C1719kg.a)) {
            CountDownTimerC1537d8 countDownTimerC1537d82 = this.g;
            if (countDownTimerC1537d82 != null) {
                countDownTimerC1537d82.start();
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(viewState, C1694jg.a) || (countDownTimerC1537d8 = this.g) == null) {
            return;
        }
        countDownTimerC1537d8.cancel();
    }
}
