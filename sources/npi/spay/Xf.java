package npi.spay;

import androidx.lifecycle.ViewModelKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import spay.sdk.domain.model.PayPartsStatus;
import spay.sdk.domain.model.response.OrderScreenDataResponse;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class Xf extends Lk {
    public static final /* synthetic */ KProperty[] C = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Xf.class, "screenMode", "getScreenMode()Lspay/sdk/domain/OrderScreenMode;", 0))};
    public final MutableStateFlow A;
    public final StateFlow B;
    public final C1993vg d;
    public final Ei e;
    public final InterfaceC1495bg f;
    public final Qb g;
    public final C1928t1 h;
    public final no i;
    public final ReadWriteProperty j;
    public final boolean k;
    public final StateFlow l;
    public final StateFlow m;
    public final Flow n;
    public final StateFlow o;
    public final StateFlow p;
    public final StateFlow q;
    public final StateFlow r;
    public final StateFlow s;
    public final StateFlow t;
    public final PayPartsStatus u;
    public final StateFlow v;
    public final MutableStateFlow w;
    public final StateFlow x;
    public final MutableStateFlow y;
    public final StateFlow z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xf(C1955u3 metricFacade, Ih sPayDataContract, C1993vg featuresHandler, Ei sPayStorage, InterfaceC1495bg sPaySdkReducer, Qb authHandler, C1928t1 helperManager, InterfaceC1728l0 sPaySdkConfigRepository, no selectCardPreparationHelper) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        Intrinsics.checkNotNullParameter(helperManager, "helperManager");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        Intrinsics.checkNotNullParameter(selectCardPreparationHelper, "selectCardPreparationHelper");
        this.d = featuresHandler;
        this.e = sPayStorage;
        this.f = sPaySdkReducer;
        this.g = authHandler;
        this.h = helperManager;
        this.i = selectCardPreparationHelper;
        this.j = Delegates.INSTANCE.notNull();
        Di di = (Di) sPayDataContract;
        StateFlow stateFlowI = di.i();
        Flow flowMapLatest = FlowKt.mapLatest(stateFlowI, new Gf(null));
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        StateFlow stateFlowStateIn = FlowKt.stateIn(flowMapLatest, viewModelScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.l = stateFlowStateIn;
        StateFlow stateFlowStateIn2 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowStateIn, new Hf(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.m = stateFlowStateIn2;
        this.n = FlowKt.mapLatest(FlowKt.filterNotNull(stateFlowStateIn2), new Df(this, null));
        StateFlow stateFlowStateIn3 = FlowKt.stateIn(FlowKt.mapLatest(stateFlowI, new Cf(null)), ViewModelKt.getViewModelScope(this), companion.getEagerly(), null);
        this.o = stateFlowStateIn3;
        this.p = FlowKt.stateIn(new Kf(FlowKt.filterNotNull(stateFlowStateIn)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.q = FlowKt.stateIn(FlowKt.combine(FlowKt.filterNotNull(stateFlowStateIn), FlowKt.filterNotNull(stateFlowStateIn2), new Ef(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        StateFlow stateFlowStateIn4 = FlowKt.stateIn(new Nf(stateFlowI), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.r = stateFlowStateIn4;
        this.s = FlowKt.stateIn(new Qf(stateFlowStateIn4), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), Boolean.FALSE);
        this.t = FlowKt.stateIn(new Tf(FlowKt.filterNotNull(stateFlowStateIn)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.u = di.o();
        this.v = FlowKt.stateIn(new Wf(stateFlowStateIn3, this, di, sPaySdkConfigRepository), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.w = MutableStateFlow;
        this.x = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.y = MutableStateFlow2;
        this.z = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow MutableStateFlow3 = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this.A = MutableStateFlow3;
        this.B = FlowKt.asStateFlow(MutableStateFlow3);
        C1822oj c1822oj = (C1822oj) sPayStorage;
        if (!(c1822oj.b().a() instanceof C1705k2)) {
            throw new De(c1822oj.b().toString());
        }
        AbstractC1855q2 abstractC1855q2A = c1822oj.b().a();
        Intrinsics.checkNotNull(abstractC1855q2A, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.OrderScreenData");
        a(((C1705k2) abstractC1855q2A).b());
        AbstractC1855q2 abstractC1855q2A2 = c1822oj.b().a();
        Intrinsics.checkNotNull(abstractC1855q2A2, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.OrderScreenData");
        this.k = ((C1705k2) abstractC1855q2A2).a();
    }

    public final void a(AbstractC2016we orderFragmentEvent) {
        InterfaceC1495bg interfaceC1495bg;
        co bn;
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList;
        long jA;
        ListOfCardsResponseBody listOfCardsResponseBody;
        ListOfCardsResponseBody.OrderInfo orderInfo;
        ListOfCardsResponseBody.OrderInfo.OrderAmount orderAmount;
        ListOfCardsResponseBody listOfCardsResponseBody2;
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo2;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList2;
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        Intrinsics.checkNotNullParameter(orderFragmentEvent, "orderFragmentEvent");
        if (Intrinsics.areEqual(orderFragmentEvent, C1966ue.a)) {
            K7 k7 = K7.LC_PAY_VIEW_APPEARED;
            c1955u3 = this.a;
            c1560e6 = new C1560e6(k7, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120);
        } else {
            if (!Intrinsics.areEqual(orderFragmentEvent, C1991ve.a)) {
                if (orderFragmentEvent instanceof C1867qe) {
                    if (((Collection) this.A.getValue()).isEmpty()) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new Ff(this, null), 3, null);
                    return;
                }
                boolean z = false;
                if (Intrinsics.areEqual(orderFragmentEvent, C1891re.a)) {
                    ListOfCardsResponseBody.PaymentToolInfo.Tool tool = (ListOfCardsResponseBody.PaymentToolInfo.Tool) this.m.getValue();
                    if (tool == null || (listOfCardsResponseBody2 = (ListOfCardsResponseBody) this.l.getValue()) == null || (paymentToolInfo2 = listOfCardsResponseBody2.getPaymentToolInfo()) == null || (toolList2 = paymentToolInfo2.getToolList()) == null) {
                        return;
                    }
                    for (ListOfCardsResponseBody.PaymentToolInfo.Tool tool2 : toolList2) {
                        if (Intrinsics.areEqual(tool2.getCardNumber(), tool.getCardNumber())) {
                            K7 k72 = K7.TOUCH_PAY;
                            EnumC1877r0 enumC1877r0 = EnumC1877r0.PAY_VIEW;
                            C1560e6 event = new C1560e6(k72, enumC1877r0, C0.TOUCH, null, null, null, null, 120);
                            Intrinsics.checkNotNullParameter(event, "event");
                            this.a.a(event);
                            boolean zC = c();
                            if (zC) {
                                C1560e6 event2 = new C1560e6(K7.LC_PAY_BNPL_START, enumC1877r0, C0.LC, null, null, null, null, 120);
                                Intrinsics.checkNotNullParameter(event2, "event");
                                this.a.a(event2);
                            }
                            C1993vg featuresHandler = this.d;
                            Qb authHandler = this.g;
                            Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
                            Intrinsics.checkNotNullParameter(authHandler, "authHandler");
                            EnumC1628h tag = EnumC1628h.REFRESH_TOKEN;
                            featuresHandler.getClass();
                            Intrinsics.checkNotNullParameter(tag, "tag");
                            InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) featuresHandler.c.get(tag);
                            if (interfaceC2089zc != null && ((Boolean) interfaceC2089zc.a((Pe) null)).booleanValue()) {
                                z = ((Ec) authHandler).e;
                            }
                            ((Jh) this.f).a(new Vn(Boolean.valueOf(z), tool2, Boolean.valueOf(zC)));
                            return;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (Intrinsics.areEqual(orderFragmentEvent, C1842pe.a)) {
                    C1560e6 event3 = new C1560e6(K7.TOUCH_CANCEL, EnumC1877r0.PAY_VIEW, C0.TOUCH, null, null, null, null, 120);
                    Intrinsics.checkNotNullParameter(event3, "event");
                    this.a.a(event3);
                    ((Jh) this.c).a(C1975un.a);
                    return;
                }
                if (Intrinsics.areEqual(orderFragmentEvent, C1817oe.a)) {
                    C1560e6 event4 = new C1560e6(K7.TOUCH_BNPL, EnumC1877r0.PAY_VIEW, C0.TOUCH, null, null, null, null, 120);
                    Intrinsics.checkNotNullParameter(event4, "event");
                    this.a.a(event4);
                    if (((PaymentPlanBnplResponseBody) this.o.getValue()) != null) {
                        ((Jh) this.f).a(new C2050xn(C1800nm.a, false));
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(orderFragmentEvent, C1916se.a)) {
                    ListOfCardsResponseBody listOfCardsResponseBody3 = (ListOfCardsResponseBody) this.l.getValue();
                    if (listOfCardsResponseBody3 == null || (paymentToolInfo = listOfCardsResponseBody3.getPaymentToolInfo()) == null || (toolList = paymentToolInfo.getToolList()) == null) {
                        return;
                    }
                    Iterator<ListOfCardsResponseBody.PaymentToolInfo.Tool> it = toolList.iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        }
                        String cardNumber = it.next().getCardNumber();
                        ListOfCardsResponseBody.PaymentToolInfo.Tool tool3 = ((C1604g0) ((C1822oj) this.e).b.getValue()).b;
                        if (Intrinsics.areEqual(cardNumber, tool3 != null ? tool3.getCardNumber() : null)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    Integer numValueOf = i == -1 ? null : Integer.valueOf(i);
                    if (numValueOf == null) {
                        return;
                    }
                    int iIntValue = numValueOf.intValue();
                    no noVar = this.i;
                    if (c()) {
                        jA = ((Di) this.b).m();
                    } else {
                        OrderScreenDataResponse orderScreenDataResponse = (OrderScreenDataResponse) ((Di) this.b).k.getValue();
                        jA = AbstractC2095zi.a((orderScreenDataResponse == null || (listOfCardsResponseBody = orderScreenDataResponse.getListOfCardsResponseBody()) == null || (orderInfo = listOfCardsResponseBody.getOrderInfo()) == null || (orderAmount = orderInfo.getOrderAmount()) == null) ? null : Long.valueOf(orderAmount.getAmount()));
                    }
                    Oi oiA = noVar.a(toolList, iIntValue, jA);
                    Timber.INSTANCE.d("handleSelectCardBtnClicked: preparedList - " + oiA, new Object[0]);
                    C1560e6 event5 = new C1560e6(K7.TOUCH_CARD, EnumC1877r0.PAY_VIEW, C0.TOUCH, null, null, null, null, 120);
                    Intrinsics.checkNotNullParameter(event5, "event");
                    this.a.a(event5);
                    interfaceC1495bg = this.f;
                    bn = new C1925sn((InterfaceC1850pm) this.j.getValue(this, C[0]), null, false);
                } else {
                    if (!Intrinsics.areEqual(orderFragmentEvent, C1941te.a)) {
                        return;
                    }
                    interfaceC1495bg = this.f;
                    bn = new Bn(new C1787n9());
                }
                ((Jh) interfaceC1495bg).a(bn);
                return;
            }
            K7 k73 = K7.LC_PAY_VIEW_DISAPPEARED;
            c1955u3 = this.a;
            c1560e6 = new C1560e6(k73, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120);
        }
        c1955u3.a(c1560e6);
    }

    public final boolean c() {
        C1993vg c1993vg = this.d;
        EnumC1628h tag = EnumC1628h.BNPL;
        c1993vg.getClass();
        Intrinsics.checkNotNullParameter(tag, "tag");
        InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
        if (interfaceC2089zc != null && ((Boolean) interfaceC2089zc.a(EnumC1908s6.BY_USER)).booleanValue()) {
            C1993vg c1993vg2 = this.d;
            c1993vg2.getClass();
            Intrinsics.checkNotNullParameter(tag, "tag");
            InterfaceC2089zc interfaceC2089zc2 = (InterfaceC2089zc) c1993vg2.c.get(tag);
            if (interfaceC2089zc2 != null && ((Boolean) interfaceC2089zc2.a(EnumC1908s6.BY_SYSTEM)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void a(InterfaceC1850pm interfaceC1850pm) {
        this.j.setValue(this, C[0], interfaceC1850pm);
    }
}
