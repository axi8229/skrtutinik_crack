package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.PayPartsStatus;

/* renamed from: npi.spay.a4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1458a4 extends Lk implements InterfaceC2010w8 {
    public final InterfaceC1495bg d;
    public final StateFlow e;
    public final MutableStateFlow f;
    public final StateFlow g;
    public final StateFlow h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1458a4(Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage, C1955u3 metricFacade) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        this.d = sPaySdkReducer;
        StateFlow stateFlowA = ((Di) sPayDataContract).a();
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        StateFlow stateFlowAsStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.e = stateFlowAsStateFlow;
        MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.f = MutableStateFlow2;
        this.g = FlowKt.asStateFlow(MutableStateFlow2);
        this.h = FlowKt.stateIn(FlowKt.combine(stateFlowA, stateFlowAsStateFlow, new C1706k3(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), null);
        C1822oj c1822oj = (C1822oj) sPayStorage;
        if (!(c1822oj.b().a() instanceof C1705k2)) {
            throw new De(c1822oj.b().toString());
        }
        AbstractC1855q2 abstractC1855q2A = c1822oj.b().a();
        Intrinsics.checkNotNull(abstractC1855q2A, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.OrderScreenData");
        MutableStateFlow.setValue(((C1705k2) abstractC1855q2A).c());
    }

    public final void a(R3 event) {
        C1560e6 event2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, N3.a)) {
            C1560e6 event3 = new C1560e6(T0.TOUCH_BACK, EnumC1877r0.WEB_VIEW, C0.TOUCH, null, null, null, null, 120);
            Intrinsics.checkNotNullParameter(event3, "event");
            this.a.a(event3);
            ((Jh) this.d).a(((Di) this.b).y == PayPartsStatus.ONLY_PARTS_PAY ? C1950tn.a : new C2050xn(C1800nm.a, false));
            return;
        }
        if (!Intrinsics.areEqual(event, O3.a)) {
            if (Intrinsics.areEqual(event, P3.a)) {
                event2 = new C1560e6(T0.LC_WEB_VIEW_APPEARED, EnumC1877r0.WEB_VIEW, C0.LC, null, null, null, null, 120);
            } else {
                if (!Intrinsics.areEqual(event, Q3.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                event2 = new C1560e6(T0.LC_WEB_VIEW_DISAPPEARED, EnumC1877r0.WEB_VIEW, C0.LC, null, null, null, null, 120);
            }
            Intrinsics.checkNotNullParameter(event2, "event");
            this.a.a(event2);
            return;
        }
        C1560e6 event4 = new C1560e6(T0.TOUCH_SHARE, EnumC1877r0.WEB_VIEW, C0.TOUCH, null, null, null, null, 120);
        Intrinsics.checkNotNullParameter(event4, "event");
        this.a.a(event4);
        String str = (String) this.e.getValue();
        if (str != null) {
            int i = R$string.spay_bnpl_share_link_message;
            Object[] args = {str};
            Intrinsics.checkNotNullParameter(args, "args");
            this.f.setValue(new C2064yc(new C2097zk(i, ArraysKt.toList(args))));
        }
    }

    @Override // npi.spay.InterfaceC2010w8
    public final boolean a(String str) {
        String str2 = (String) this.e.getValue();
        if (str2 != null) {
            return StringsKt.contains$default((CharSequence) String.valueOf(str), (CharSequence) str2, false, 2, (Object) null);
        }
        return false;
    }
}
