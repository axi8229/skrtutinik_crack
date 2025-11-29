package npi.spay;

import android.net.Uri;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import spay.sdk.api.SPayHelpers;
import spay.sdk.domain.model.PayPartsStatus;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;
import timber.log.Timber;

/* renamed from: npi.spay.zh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2094zh extends AbstractC1810o7 {
    public final InterfaceC1495bg e;
    public final Ei f;
    public final C1993vg g;
    public final StateFlow h;
    public final MutableStateFlow i;
    public final StateFlow j;
    public final MutableStateFlow k;
    public final StateFlow l;
    public final MutableStateFlow m;
    public final StateFlow n;
    public final StateFlow o;
    public final C2069yh p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2094zh(C1955u3 metricFacade, Ih sPayDataContract, Gk clearSdkUtil, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage, C1928t1 helperManager, InterfaceC1728l0 sPaySdkConfigRepository, C1993vg featuresHandler) {
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList;
        InterfaceC2020wi c1651hm;
        ListOfCardsResponseBody.PromoInfo.BannerData.Buttons buttons;
        ListOfCardsResponseBody.PromoInfo.BannerData.Buttons buttons2;
        ListOfCardsResponseBody.PromoInfo.BannerData.Buttons buttons3;
        super(metricFacade, sPayDataContract, clearSdkUtil, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(clearSdkUtil, "clearSdkUtil");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(helperManager, "helperManager");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        this.e = sPaySdkReducer;
        this.f = sPayStorage;
        this.g = featuresHandler;
        Di di = (Di) sPayDataContract;
        String strJoinToString$default = null;
        Flow flowMapLatest = FlowKt.mapLatest(di.i(), new C1919sh(null));
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        StateFlow stateFlowStateIn = FlowKt.stateIn(flowMapLatest, viewModelScope, companion.getEagerly(), null);
        this.h = stateFlowStateIn;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.i = MutableStateFlow;
        this.j = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.k = MutableStateFlow2;
        this.l = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this.m = MutableStateFlow3;
        this.n = FlowKt.asStateFlow(MutableStateFlow3);
        this.o = FlowKt.stateIn(new C1994vh(FlowKt.filterNotNull(stateFlowStateIn), sPaySdkConfigRepository), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        this.p = new C2069yh(FlowKt.filterNotNull(stateFlowStateIn), this);
        C1822oj c1822oj = (C1822oj) sPayStorage;
        if (!(c1822oj.b().a() instanceof Y1)) {
            throw new De(c1822oj.b().toString());
        }
        AbstractC1855q2 abstractC1855q2A = c1822oj.b().a();
        Intrinsics.checkNotNull(abstractC1855q2A, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.HelpersState");
        List listA = ((Y1) abstractC1855q2A).a().a();
        if (listA != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listA) {
                if (!Intrinsics.areEqual(((ListOfCardsResponseBody.PromoInfo.BannerData) obj).getType(), SPayHelpers.DEBIT_CARD.getTag())) {
                    arrayList.add(obj);
                }
            }
            MutableStateFlow mutableStateFlow = this.i;
            Collection collection = (Collection) mutableStateFlow.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ListOfCardsResponseBody.PromoInfo.BannerData bannerData = (ListOfCardsResponseBody.PromoInfo.BannerData) it.next();
                if (arrayList.size() == 1) {
                    String header = bannerData.getHeader();
                    String str = header == null ? "" : header;
                    String text = bannerData.getText();
                    String str2 = text == null ? "" : text;
                    List<ListOfCardsResponseBody.PromoInfo.BannerData.Buttons> buttons4 = bannerData.getButtons();
                    String deeplink = (buttons4 == null || (buttons3 = (ListOfCardsResponseBody.PromoInfo.BannerData.Buttons) CollectionsKt.firstOrNull((List) buttons4)) == null) ? null : buttons3.getDeeplink();
                    String str3 = deeplink == null ? "" : deeplink;
                    String iconUrl = bannerData.getIconUrl();
                    c1651hm = new Ma(str, str2, str3, iconUrl == null ? "" : iconUrl, bannerData.getType());
                } else if (Intrinsics.areEqual(bannerData.getType(), SPayHelpers.BNPL.getTag())) {
                    String header2 = bannerData.getHeader();
                    String str4 = header2 == null ? "" : header2;
                    String text2 = bannerData.getText();
                    String str5 = text2 == null ? "" : text2;
                    List<ListOfCardsResponseBody.PromoInfo.BannerData.Buttons> buttons5 = bannerData.getButtons();
                    String deeplink2 = (buttons5 == null || (buttons2 = (ListOfCardsResponseBody.PromoInfo.BannerData.Buttons) CollectionsKt.firstOrNull((List) buttons5)) == null) ? null : buttons2.getDeeplink();
                    String str6 = deeplink2 == null ? "" : deeplink2;
                    String iconUrl2 = bannerData.getIconUrl();
                    c1651hm = new Zj(str4, str5, str6, iconUrl2 == null ? "" : iconUrl2, bannerData.getType());
                } else {
                    String header3 = bannerData.getHeader();
                    String str7 = header3 == null ? "" : header3;
                    String text3 = bannerData.getText();
                    String str8 = text3 == null ? "" : text3;
                    List<ListOfCardsResponseBody.PromoInfo.BannerData.Buttons> buttons6 = bannerData.getButtons();
                    String deeplink3 = (buttons6 == null || (buttons = (ListOfCardsResponseBody.PromoInfo.BannerData.Buttons) CollectionsKt.firstOrNull((List) buttons6)) == null) ? null : buttons.getDeeplink();
                    String str9 = deeplink3 == null ? "" : deeplink3;
                    String iconUrl3 = bannerData.getIconUrl();
                    c1651hm = new C1651hm(str7, str8, str9, iconUrl3 == null ? "" : iconUrl3, bannerData.getType());
                }
                arrayList2.add(c1651hm);
            }
            mutableStateFlow.setValue(CollectionsKt.plus(collection, (Iterable) arrayList2));
        }
        List<H9> listA2 = helperManager.a();
        Timber.INSTANCE.d("helperManager.getHints(): " + listA2, new Object[0]);
        MutableStateFlow mutableStateFlow2 = this.k;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA2, 10));
        for (H9 h9 : listA2) {
            arrayList3.add(new C2012wa(h9.a(), h9.b()));
        }
        mutableStateFlow2.setValue(arrayList3);
        Timber.Companion companion2 = Timber.INSTANCE;
        StringBuilder sb = new StringBuilder("CardsList amounts: ");
        ListOfCardsResponseBody listOfCardsResponseBody = (ListOfCardsResponseBody) this.h.getValue();
        if (listOfCardsResponseBody != null && (paymentToolInfo = listOfCardsResponseBody.getPaymentToolInfo()) != null && (toolList = paymentToolInfo.getToolList()) != null) {
            strJoinToString$default = CollectionsKt.joinToString$default(toolList, null, null, null, 0, null, C1870qh.a, 31, null);
        }
        sb.append(strJoinToString$default);
        sb.append("\nBNPL amount required: ");
        sb.append(di.m());
        companion2.d(sb.toString(), new Object[0]);
    }

    public final void a(AbstractC1742le mainHelpersEvent) {
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        Intrinsics.checkNotNullParameter(mainHelpersEvent, "mainHelpersEvent");
        if (Intrinsics.areEqual(mainHelpersEvent, C1593fe.a)) {
            this.a.a(new C1560e6(EnumC1573ej.TOUCH_CANCEL, EnumC1877r0.HELPERS_VIEW, C0.TOUCH, null, null, null, null, 120));
            ((Jh) this.e).a(C1975un.a);
            return;
        }
        if (Intrinsics.areEqual(mainHelpersEvent, C1618ge.a)) {
            if (((Collection) this.k.getValue()).isEmpty()) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C1894rh(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(mainHelpersEvent, C1692je.a)) {
            c1955u3 = this.a;
            c1560e6 = new C1560e6(EnumC1573ej.LC_HELPERS_VIEW_APPEARED, EnumC1877r0.HELPERS_VIEW, C0.LCStart, null, null, null, null, 120);
        } else {
            if (!Intrinsics.areEqual(mainHelpersEvent, C1717ke.a)) {
                if (!(mainHelpersEvent instanceof C1668ie)) {
                    if (Intrinsics.areEqual(mainHelpersEvent, C1643he.a)) {
                        InterfaceC1495bg interfaceC1495bg = this.e;
                        AbstractC1855q2 abstractC1855q2 = ((C1604g0) ((C1822oj) this.f).b.getValue()).a;
                        Intrinsics.checkNotNull(abstractC1855q2, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.HelpersState");
                        ((Jh) interfaceC1495bg).a(new Bn(new C1762m9(((Y1) abstractC1855q2).a)));
                        return;
                    }
                    return;
                }
                C1668ie c1668ie = (C1668ie) mainHelpersEvent;
                if (c1668ie.a.b().length() > 0) {
                    this.m.setValue(new C2064yc(Uri.parse(c1668ie.a.b())));
                    ((Jh) this.e).a(C1975un.a);
                } else if (Intrinsics.areEqual(c1668ie.a.a(), SPayHelpers.BNPL.getTag())) {
                    long jM = ((Di) this.b).m();
                    C1993vg c1993vg = this.g;
                    EnumC1628h tag = EnumC1628h.BNPL;
                    c1993vg.getClass();
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
                    if (interfaceC2089zc != null) {
                        interfaceC2089zc.a(new C1983v6(true));
                    }
                    Di di = (Di) this.b;
                    di.o.setValue(Long.valueOf(jM));
                    PayPartsStatus status = PayPartsStatus.ONLY_PARTS_PAY;
                    Intrinsics.checkNotNullParameter(status, "status");
                    Intrinsics.checkNotNullParameter(status, "<set-?>");
                    di.y = status;
                    ((Jh) this.e).a(Dn.a);
                }
                if (c1668ie.a.b().length() > 0) {
                    this.m.setValue(new C2064yc(Uri.parse(c1668ie.a.b())));
                }
                this.a.a(new C1560e6(Intrinsics.areEqual(c1668ie.a.a(), SPayHelpers.SBP.getTag()) ? EnumC1573ej.TOUCH_MAKE_TRANSFER : EnumC1573ej.TOUCH_MAKE_CARD, EnumC1877r0.HELPERS_VIEW, C0.TOUCH, null, null, null, null, 120));
                return;
            }
            c1955u3 = this.a;
            c1560e6 = new C1560e6(EnumC1573ej.LC_HELPERS_VIEW_DISAPPEARED, EnumC1877r0.HELPERS_VIEW, C0.LCEnd, null, null, null, null, 120);
        }
        c1955u3.a(c1560e6);
    }
}
