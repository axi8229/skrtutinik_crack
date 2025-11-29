package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;

/* loaded from: classes4.dex */
public final class Td extends Lk {
    public final InterfaceC1495bg d;
    public final C1993vg e;
    public final C1824ol f;
    public final StateFlow g;
    public final StateFlow h;
    public final StateFlow i;
    public final StateFlow j;
    public final StateFlow k;
    public final StateFlow l;
    public final StateFlow m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Td(C1955u3 metricFacade, Ih sPayDataContract, Ei sPayStorage, InterfaceC1495bg sPaySdkReducer, C1993vg featuresHandler, C1824ol getAgreementLinksTitlesUseCase) {
        String offerText;
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(getAgreementLinksTitlesUseCase, "getAgreementLinksTitlesUseCase");
        this.d = sPaySdkReducer;
        this.e = featuresHandler;
        this.f = getAgreementLinksTitlesUseCase;
        Di di = (Di) sPayDataContract;
        StateFlow stateFlowI = di.i();
        this.g = FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(Integer.valueOf(di.l())));
        Flow flowMapLatest = FlowKt.mapLatest(stateFlowI, new Pd(null));
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        StateFlow stateFlowStateIn = FlowKt.stateIn(flowMapLatest, viewModelScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.h = stateFlowStateIn;
        StateFlow stateFlowStateIn2 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowStateIn, new Qd(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.i = stateFlowStateIn2;
        StateFlow stateFlowStateIn3 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowStateIn2, new Rd(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        StateFlow stateFlowStateIn4 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowStateIn, new Md(this, null)), ViewModelKt.getViewModelScope(this), companion.getEagerly(), null);
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = (PaymentPlanBnplResponseBody) stateFlowStateIn.getValue();
        this.j = FlowKt.stateIn(FlowKt.combine(stateFlowStateIn4, StateFlowKt.MutableStateFlow((paymentPlanBnplResponseBody == null || (offerText = paymentPlanBnplResponseBody.getOfferText()) == null) ? null : AbstractC1946tj.e(offerText)), new Ld(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.k = FlowKt.stateIn(FlowKt.combine(stateFlowStateIn3, FlowKt.stateIn(FlowKt.mapLatest(stateFlowI, new Od(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null), new Sd(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        StateFlow stateFlowK = di.k();
        this.l = stateFlowK;
        this.m = FlowKt.stateIn(FlowKt.mapLatest(stateFlowK, new Nd(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), Boolean.FALSE);
        C1822oj c1822oj = (C1822oj) sPayStorage;
        if (!(c1822oj.b().a() instanceof C1705k2)) {
            throw new De(c1822oj.b().toString());
        }
    }

    public final void a(AbstractC1664ia event) {
        C1560e6 event2;
        C1560e6 event3;
        CoroutineScope viewModelScope;
        CoroutineDispatcher io2;
        Function2 c1844pg;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, C1514ca.a)) {
            viewModelScope = ViewModelKt.getViewModelScope(this);
            io2 = Dispatchers.getIO();
            c1844pg = new Je(this, null);
        } else {
            if (!Intrinsics.areEqual(event, C1539da.a)) {
                if (Intrinsics.areEqual(event, C1564ea.a)) {
                    event3 = new C1560e6(Ok.LC_BNPL_VIEW_APPEARED, EnumC1877r0.BNPL_VIEW, C0.LC, null, null, null, null, 120);
                } else {
                    if (!Intrinsics.areEqual(event, C1589fa.a)) {
                        if (!(event instanceof C1614ga)) {
                            if (!(event instanceof C1639ha)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            ((Di) this.b).g.setValue(Boolean.valueOf(((C1639ha) event).a));
                            C1560e6 event4 = new C1560e6(Ok.TOUCH_APPROVE_BNPL, EnumC1877r0.BNPL_VIEW, C0.TOUCH, null, null, null, null, 120);
                            Intrinsics.checkNotNullParameter(event4, "event");
                            this.a.a(event4);
                            return;
                        }
                        C1614ga c1614ga = (C1614ga) event;
                        int i = c1614ga.a;
                        String str = c1614ga.b;
                        if (i != 0) {
                            if (i == 1) {
                                event2 = new C1560e6(Ok.TOUCH_AGREEMENT_VIEW, EnumC1877r0.BNPL_VIEW, C0.TOUCH, null, null, null, null, 120);
                            }
                            ((Jh) this.d).a(new C2000vn(str));
                            return;
                        }
                        event2 = new C1560e6(Ok.TOUCH_CONTRACT_VIEW, EnumC1877r0.BNPL_VIEW, C0.TOUCH, null, null, null, null, 120);
                        Intrinsics.checkNotNullParameter(event2, "event");
                        this.a.a(event2);
                        ((Jh) this.d).a(new C2000vn(str));
                        return;
                    }
                    event3 = new C1560e6(Ok.LC_BNPL_VIEW_DISAPPEARED, EnumC1877r0.BNPL_VIEW, C0.LC, null, null, null, null, 120);
                }
                Intrinsics.checkNotNullParameter(event3, "event");
                this.a.a(event3);
                return;
            }
            viewModelScope = ViewModelKt.getViewModelScope(this);
            io2 = Dispatchers.getIO();
            c1844pg = new C1844pg(this, null);
        }
        BuildersKt__Builders_commonKt.launch$default(viewModelScope, io2, null, c1844pg, 2, null);
    }
}
