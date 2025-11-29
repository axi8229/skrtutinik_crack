package npi.spay;

import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.location.DeviceOrientationRequest;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* renamed from: npi.spay.o4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1807o4 extends Lk implements InterfaceC1859q6 {
    public CountDownTimerC1537d8 d;
    public long e;
    public final long f;
    public final C1633h4 g;
    public final C1608g4 h;
    public final StateFlow i;
    public final StateFlow j;
    public final MutableStateFlow k;
    public final StateFlow l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1807o4(C1955u3 metricFacade, Ih sPayDataContract, Ei sPayStorage, InterfaceC1495bg sPaySdkReducer, C1993vg featuresHandler) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        this.e = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;
        this.f = 1000L;
        this.g = new C1633h4(this);
        this.h = new C1608g4(this);
        C1822oj c1822oj = (C1822oj) sPayStorage;
        Flow flowMapLatest = FlowKt.mapLatest(new C1782n4(new C1707k4(c1822oj.a())), new C1533d4(null));
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        StateFlow stateFlowStateIn = FlowKt.stateIn(flowMapLatest, viewModelScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.i = stateFlowStateIn;
        this.j = FlowKt.stateIn(FlowKt.combine(((Di) sPayDataContract).n(), c1822oj.a(), new C1583f4(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.k = MutableStateFlow;
        this.l = FlowKt.stateIn(FlowKt.combine(FlowKt.filterNotNull(stateFlowStateIn), MutableStateFlow, new C1558e4(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        if (c1822oj.b().a() instanceof C1531d2) {
            a(new CountDownTimerC1537d8(e(), c(), a(), b()));
            CountDownTimerC1537d8 countDownTimerC1537d8D = d();
            if (countDownTimerC1537d8D != null) {
                countDownTimerC1537d8D.start();
            }
        }
    }

    @Override // npi.spay.InterfaceC1859q6
    public final Function1 a() {
        return this.g;
    }

    @Override // npi.spay.InterfaceC1859q6
    public final Function0 b() {
        return this.h;
    }

    public final long c() {
        return this.f;
    }

    public final CountDownTimerC1537d8 d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public final void a(CountDownTimerC1537d8 countDownTimerC1537d8) {
        this.d = countDownTimerC1537d8;
    }

    @Override // npi.spay.AbstractC1819og
    public final void a(AbstractC1794ng event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!Intrinsics.areEqual(event, C1744lg.a)) {
            if (!Intrinsics.areEqual(event, C1769mg.a)) {
                return;
            }
            try {
                CountDownTimerC1537d8 countDownTimerC1537d8 = this.d;
                if (countDownTimerC1537d8 != null) {
                    countDownTimerC1537d8.cancel();
                }
            } catch (UninitializedPropertyAccessException unused) {
            }
        }
        this.i.getValue();
    }
}
