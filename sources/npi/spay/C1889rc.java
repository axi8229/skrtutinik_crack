package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* renamed from: npi.spay.rc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1889rc extends AbstractC1819og {
    public static final /* synthetic */ KProperty[] h = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(C1889rc.class, "screenMode", "getScreenMode()Lspay/sdk/domain/ReturnScreenType;", 0))};
    public final InterfaceC1495bg c;
    public final C2015wd d;
    public final H4 e;
    public final ReadWriteProperty f;
    public final StateFlow g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1889rc(C1955u3 metricFacade, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage, Qb authHandler, C2015wd revokeRefreshTokenUseCase, H4 setCookieHandler) {
        super(metricFacade, sPayDataContract, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        Intrinsics.checkNotNullParameter(revokeRefreshTokenUseCase, "revokeRefreshTokenUseCase");
        Intrinsics.checkNotNullParameter(setCookieHandler, "setCookieHandler");
        this.c = sPaySdkReducer;
        this.d = revokeRefreshTokenUseCase;
        this.e = setCookieHandler;
        this.f = Delegates.INSTANCE.notNull();
        this.g = FlowKt.stateIn(FlowKt.mapLatest(FlowKt.filterNotNull(((Di) sPayDataContract).h()), new C1865qc(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), null);
        C1822oj c1822oj = (C1822oj) sPayStorage;
        if (!(c1822oj.b().a() instanceof C1481b2)) {
            throw new De(c1822oj.b().toString());
        }
        AbstractC1855q2 abstractC1855q2A = c1822oj.b().a();
        Intrinsics.checkNotNull(abstractC1855q2A, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.UserProfile");
        a(((C1481b2) abstractC1855q2A).a());
    }

    public final void a(InterfaceC1812o9 interfaceC1812o9) {
        this.f.setValue(this, h[0], interfaceC1812o9);
    }

    public final void a(Ta userProfileFragmentEvent) {
        InterfaceC1495bg interfaceC1495bg;
        co c2050xn;
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        Intrinsics.checkNotNullParameter(userProfileFragmentEvent, "userProfileFragmentEvent");
        if (Intrinsics.areEqual(userProfileFragmentEvent, Ra.a)) {
            EnumC1875qm enumC1875qm = EnumC1875qm.LC_PROFILE_VIEW_APPEARED;
            c1955u3 = this.a;
            c1560e6 = new C1560e6(enumC1875qm, EnumC1877r0.PROFILE_VIEW, C0.LC, null, null, null, null, 120);
        } else {
            if (!Intrinsics.areEqual(userProfileFragmentEvent, Sa.a)) {
                if (!Intrinsics.areEqual(userProfileFragmentEvent, Pa.a)) {
                    if (Intrinsics.areEqual(userProfileFragmentEvent, Qa.a)) {
                        this.a.a(new C1560e6(EnumC1875qm.TOUCH_LOG_OUT, EnumC1877r0.PROFILE_VIEW, C0.TOUCH, null, null, null, null, 120));
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new Hd(this, null), 3, null);
                        return;
                    }
                    return;
                }
                C1560e6 event = new C1560e6(EnumC1875qm.TOUCH_BACK, EnumC1877r0.PROFILE_VIEW, C0.TOUCH, null, null, null, null, 120);
                Intrinsics.checkNotNullParameter(event, "event");
                this.a.a(event);
                ReadWriteProperty readWriteProperty = this.f;
                KProperty<?>[] kPropertyArr = h;
                InterfaceC1812o9 interfaceC1812o9 = (InterfaceC1812o9) readWriteProperty.getValue(this, kPropertyArr[0]);
                if (interfaceC1812o9 instanceof C1762m9) {
                    interfaceC1495bg = this.c;
                    InterfaceC1812o9 interfaceC1812o92 = (InterfaceC1812o9) this.f.getValue(this, kPropertyArr[0]);
                    Intrinsics.checkNotNull(interfaceC1812o92, "null cannot be cast to non-null type spay.sdk.domain.ReturnScreenType.ReturnHelpersScreenType");
                    c2050xn = new bo(((C1762m9) interfaceC1812o92).a);
                } else {
                    if (!(interfaceC1812o9 instanceof C1787n9)) {
                        return;
                    }
                    interfaceC1495bg = this.c;
                    InterfaceC1812o9 interfaceC1812o93 = (InterfaceC1812o9) this.f.getValue(this, kPropertyArr[0]);
                    Intrinsics.checkNotNull(interfaceC1812o93, "null cannot be cast to non-null type spay.sdk.domain.ReturnScreenType.ReturnOrderScreenType");
                    ((C1787n9) interfaceC1812o93).getClass();
                    c2050xn = new C2050xn(C1825om.a, false);
                }
                ((Jh) interfaceC1495bg).a(c2050xn);
                return;
            }
            EnumC1875qm enumC1875qm2 = EnumC1875qm.LC_PROFILE_VIEW_DISAPPEARED;
            c1955u3 = this.a;
            c1560e6 = new C1560e6(enumC1875qm2, EnumC1877r0.PROFILE_VIEW, C0.LC, null, null, null, null, 120);
        }
        c1955u3.a(c1560e6);
    }
}
