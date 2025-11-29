package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;

/* loaded from: classes4.dex */
public final class Tk extends Lk implements InterfaceC1859q6 {
    public CountDownTimerC1537d8 d;
    public long e;
    public final long f;
    public final Li g;
    public final Ki h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tk(Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage, C1955u3 metricFacade) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.e = 4000L;
        this.f = 1000L;
        this.g = new Li(this);
        this.h = new Ki(this);
        FlowKt.stateIn(FlowKt.mapLatest(((C1822oj) sPayStorage).a(), new C1499bk(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), null);
    }

    @Override // npi.spay.InterfaceC1859q6
    public final Function1 a() {
        return this.g;
    }

    @Override // npi.spay.InterfaceC1859q6
    public final Function0 b() {
        return this.h;
    }

    @Override // npi.spay.AbstractC1819og
    public final void a(AbstractC1794ng viewState) {
        CountDownTimerC1537d8 countDownTimerC1537d8;
        Intrinsics.checkNotNullParameter(viewState, "event");
        super.a(viewState);
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        if (Intrinsics.areEqual(viewState, C1744lg.a)) {
            this.d = new CountDownTimerC1537d8(this.e, this.f, new K4(this), new C1932t5(this));
            return;
        }
        if (Intrinsics.areEqual(viewState, C1719kg.a)) {
            CountDownTimerC1537d8 countDownTimerC1537d82 = this.d;
            if (countDownTimerC1537d82 != null) {
                countDownTimerC1537d82.start();
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(viewState, C1694jg.a) || (countDownTimerC1537d8 = this.d) == null) {
            return;
        }
        countDownTimerC1537d8.cancel();
    }
}
