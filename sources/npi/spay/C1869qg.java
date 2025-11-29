package npi.spay;

import androidx.lifecycle.ViewModelKt;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
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
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.qg, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1869qg extends Lk {
    public static final /* synthetic */ KProperty[] j = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(C1869qg.class, "screenMode", "getScreenMode()Lspay/sdk/domain/OrderScreenMode;", 0))};
    public final Ei d;
    public final InterfaceC1495bg e;
    public final ReadWriteProperty f;
    public final StateFlow g;
    public final StateFlow h;
    public final StateFlow i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1869qg(Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage, C1955u3 metricFacade) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.d = sPayStorage;
        this.e = sPaySdkReducer;
        this.f = Delegates.INSTANCE.notNull();
        Di di = (Di) sPayDataContract;
        MutableStateFlow mutableStateFlowG = di.g();
        Flow flowMapLatest = FlowKt.mapLatest(mutableStateFlowG, new C1964uc(null));
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        this.g = FlowKt.stateIn(flowMapLatest, viewModelScope, companion.getEagerly(), null);
        this.h = FlowKt.stateIn(FlowKt.combine(FlowKt.filterNotNull(di.f()), FlowKt.filterNotNull(mutableStateFlowG), new Ud(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.i = FlowKt.asStateFlow(MutableStateFlow);
        C1822oj c1822oj = (C1822oj) sPayStorage;
        if (!(c1822oj.b().a() instanceof C1730l2)) {
            throw new De(c1822oj.b().toString());
        }
        AbstractC1855q2 abstractC1855q2A = c1822oj.b().a();
        Intrinsics.checkNotNull(abstractC1855q2A, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.OrderScreenSelectCard");
        C1730l2 c1730l2 = (C1730l2) abstractC1855q2A;
        a(c1730l2.a());
        MutableStateFlow.setValue(c1730l2.b());
    }

    public final void a(I0 event) {
        Object next;
        C1560e6 event2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, F0.a)) {
            event2 = new C1560e6(EnumC1953u1.LC_LIST_CARD_VIEW_APPEARED, EnumC1877r0.LIST_CARD_VIEW, C0.LC, null, null, null, null, 120);
        } else {
            if (!Intrinsics.areEqual(event, G0.a)) {
                if (!(event instanceof H0)) {
                    throw new NoWhenBranchMatchedException();
                }
                M3 m3 = ((H0) event).a;
                C1560e6 event3 = new C1560e6(EnumC1953u1.TOUCH_CARD, EnumC1877r0.LIST_CARD_VIEW, C0.TOUCH, null, null, null, null, 120);
                Intrinsics.checkNotNullParameter(event3, "event");
                this.a.a(event3);
                List list = (List) this.g.getValue();
                if (list != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (Intrinsics.areEqual(((ListOfCardsResponseBody.PaymentToolInfo.Tool) next).getCardNumber(), m3.o)) {
                                break;
                            }
                        }
                    }
                    ListOfCardsResponseBody.PaymentToolInfo.Tool incomeSelectedCard = (ListOfCardsResponseBody.PaymentToolInfo.Tool) next;
                    if (incomeSelectedCard != null) {
                        C1822oj c1822oj = (C1822oj) this.d;
                        c1822oj.getClass();
                        Intrinsics.checkNotNullParameter(incomeSelectedCard, "incomeSelectedCard");
                        MutableStateFlow mutableStateFlow = c1822oj.a;
                        mutableStateFlow.setValue(C1604g0.a((C1604g0) mutableStateFlow.getValue(), null, incomeSelectedCard, false, 5));
                    }
                }
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new Ke(this, null), 3, null);
                return;
            }
            event2 = new C1560e6(EnumC1953u1.LC_LIST_CARD_VIEW_DISAPPEARED, EnumC1877r0.LIST_CARD_VIEW, C0.LC, null, null, null, null, 120);
        }
        Intrinsics.checkNotNullParameter(event2, "event");
        this.a.a(event2);
    }

    public final void a(InterfaceC1850pm interfaceC1850pm) {
        this.f.setValue(this, j[0], interfaceC1850pm);
    }
}
