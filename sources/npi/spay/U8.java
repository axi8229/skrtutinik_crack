package npi.spay;

import android.net.Uri;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import spay.sdk.api.SPayHelpers;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class U8 extends AbstractC1810o7 {
    public final InterfaceC1495bg e;
    public final C1928t1 f;
    public final Y1 g;
    public Uri h;
    public final MutableStateFlow i;
    public final StateFlow j;
    public final MutableStateFlow k;
    public final StateFlow l;
    public final MutableStateFlow m;
    public final StateFlow n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U8(C1955u3 metricFacade, Ih sPayDataContract, Gk clearSdkUtil, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage, C1928t1 helperManager) {
        super(metricFacade, sPayDataContract, clearSdkUtil, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(clearSdkUtil, "clearSdkUtil");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(helperManager, "helperManager");
        this.e = sPaySdkReducer;
        this.f = helperManager;
        AbstractC1855q2 abstractC1855q2A = ((C1604g0) ((C1822oj) sPayStorage).a().getValue()).a();
        Intrinsics.checkNotNull(abstractC1855q2A, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.HelpersState");
        this.g = (Y1) abstractC1855q2A;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.i = MutableStateFlow;
        this.j = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.k = MutableStateFlow2;
        this.l = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this.m = MutableStateFlow3;
        this.n = FlowKt.asStateFlow(MutableStateFlow3);
        d();
        c();
    }

    public final void a(Ca noMatchingCardsHelperEvent) {
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        C1955u3 c1955u32;
        C1560e6 c1560e62;
        Intrinsics.checkNotNullParameter(noMatchingCardsHelperEvent, "noMatchingCardsHelperEvent");
        if (Intrinsics.areEqual(noMatchingCardsHelperEvent, C2062ya.a)) {
            c1955u32 = this.a;
            c1560e62 = new C1560e6(EnumC1602fn.TOUCH_CANCEL, EnumC1877r0.NO_ACTIVE_CARDS_VIEW, C0.TOUCH, null, null, null, null, 120);
        } else {
            if (!Intrinsics.areEqual(noMatchingCardsHelperEvent, C2087za.a)) {
                if (Intrinsics.areEqual(noMatchingCardsHelperEvent, Aa.a)) {
                    c1955u3 = this.a;
                    c1560e6 = new C1560e6(EnumC1602fn.LC_NO_ACTIVE_CARDS_VIEW_APPEARED, EnumC1877r0.NO_ACTIVE_CARDS_VIEW, C0.LCStart, null, null, null, null, 120);
                } else {
                    if (!Intrinsics.areEqual(noMatchingCardsHelperEvent, Ba.a)) {
                        return;
                    }
                    c1955u3 = this.a;
                    c1560e6 = new C1560e6(EnumC1602fn.LC_NO_ACTIVE_CARDS_VIEW_DISAPPEARED, EnumC1877r0.NO_ACTIVE_CARDS_VIEW, C0.LCEnd, null, null, null, null, 120);
                }
                c1955u3.a(c1560e6);
                return;
            }
            this.m.tryEmit(new C2064yc(this.h));
            c1955u32 = this.a;
            c1560e62 = new C1560e6(EnumC1602fn.TOUCH_ISSUE_CARD, EnumC1877r0.NO_ACTIVE_CARDS_VIEW, C0.TOUCH, null, null, null, null, 120);
        }
        c1955u32.a(c1560e62);
        ((Jh) this.e).a(C1975un.a);
    }

    public final void c() {
        ListOfCardsResponseBody.PromoInfo.BannerData bannerData;
        ListOfCardsResponseBody.PromoInfo.BannerData.Buttons buttons;
        List listA = this.g.a.a();
        if (listA == null || (bannerData = (ListOfCardsResponseBody.PromoInfo.BannerData) CollectionsKt.firstOrNull(listA)) == null) {
            return;
        }
        List<ListOfCardsResponseBody.PromoInfo.BannerData.Buttons> buttons2 = bannerData.getButtons();
        this.h = Uri.parse((buttons2 == null || (buttons = (ListOfCardsResponseBody.PromoInfo.BannerData.Buttons) CollectionsKt.firstOrNull((List) buttons2)) == null) ? null : buttons.getDeeplink());
        this.k.tryEmit(bannerData);
    }

    public final void d() {
        this.i.tryEmit(CollectionsKt.toList(((Di) this.f.b).A).contains(SPayHelpers.DEBIT_CARD) ? T8.DEBIT_CARD : T8.ERROR);
    }
}
