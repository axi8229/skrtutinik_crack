package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import spay.sdk.domain.model.PayPartsStatus;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;

/* loaded from: classes4.dex */
public final class Jj extends Lk {
    public final Ei d;
    public final InterfaceC1495bg e;
    public final C1993vg f;
    public final Qb g;
    public final C1824ol h;
    public final C1825om i;
    public final StateFlow j;
    public final StateFlow k;
    public final StateFlow l;
    public final StateFlow m;
    public final StateFlow n;
    public final StateFlow o;
    public final StateFlow p;
    public final StateFlow q;
    public final StateFlow r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Jj(C1955u3 metricFacade, Ih sPayDataContract, Ei sPayStorage, InterfaceC1495bg sPaySdkReducer, C1993vg featuresHandler, Qb authHandler, C1824ol getAgreementLinksTitlesUseCase) {
        String offerText;
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        Intrinsics.checkNotNullParameter(getAgreementLinksTitlesUseCase, "getAgreementLinksTitlesUseCase");
        this.d = sPayStorage;
        this.e = sPaySdkReducer;
        this.f = featuresHandler;
        this.g = authHandler;
        this.h = getAgreementLinksTitlesUseCase;
        this.i = C1825om.a;
        Di di = (Di) sPayDataContract;
        StateFlow stateFlowI = di.i();
        this.j = FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(Integer.valueOf(di.l())));
        this.k = di.k();
        c();
        Flow flowMapLatest = FlowKt.mapLatest(stateFlowI, new Aj(null));
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        StateFlow stateFlowStateIn = FlowKt.stateIn(flowMapLatest, viewModelScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.l = stateFlowStateIn;
        StateFlow stateFlowStateIn2 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowI, new Bj(di, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.m = stateFlowStateIn2;
        StateFlow stateFlowStateIn3 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowStateIn2, new Cj(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.n = stateFlowStateIn3;
        StateFlow stateFlowStateIn4 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowStateIn3, new Dj(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        StateFlow stateFlowStateIn5 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowI, new C2096zj(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        FlowKt.stateIn(new Hj(stateFlowI), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        StateFlow stateFlowStateIn6 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowStateIn, new Ej(this, di, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.o = stateFlowStateIn6;
        this.p = FlowKt.stateIn(FlowKt.combine(FlowKt.filterNotNull(stateFlowStateIn), FlowKt.filterNotNull(stateFlowStateIn6), new C2071yj(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.q = FlowKt.stateIn(FlowKt.combine(stateFlowStateIn4, stateFlowStateIn5, new Ij(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        StateFlow stateFlowStateIn7 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowStateIn2, new C2046xj(this, null)), ViewModelKt.getViewModelScope(this), companion.getEagerly(), null);
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = (PaymentPlanBnplResponseBody) stateFlowStateIn2.getValue();
        this.r = FlowKt.stateIn(FlowKt.combine(stateFlowStateIn7, StateFlowKt.MutableStateFlow((paymentPlanBnplResponseBody == null || (offerText = paymentPlanBnplResponseBody.getOfferText()) == null) ? null : AbstractC1946tj.e(offerText)), new C2021wj(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(npi.spay.AbstractC1733l5 r15) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Jj.a(npi.spay.l5):void");
    }

    public final void c() {
        PayPartsStatus payPartsStatus = ((Di) this.b).y;
        Intrinsics.checkNotNullParameter(payPartsStatus, "payPartsStatus");
        AbstractC1765mc.a = false;
    }
}
