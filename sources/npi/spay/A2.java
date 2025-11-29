package npi.spay;

import android.os.Parcelable;
import androidx.lifecycle.ViewModelKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import spay.sdk.api.PaymentResult;
import spay.sdk.b;

/* loaded from: classes4.dex */
public final class A2 extends AbstractC1810o7 {
    public final Ei e;
    public final InterfaceC1495bg f;
    public final Qb g;
    public final C7 h;
    public final W0 i;
    public final Ek j;
    public final C2014wc k;
    public final C1876qn l;
    public final F9 m;
    public final U5 n;
    public final C1993vg o;
    public final MutableStateFlow p;
    public final StateFlow q;
    public final StateFlow r;
    public final StateFlow s;
    public Sg t;
    public PaymentResult u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A2(Ei sPayStorage, Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, C1955u3 metricFacade, Gk clearUtil, Qb authHandler, C7 fullEmissionUseCase, W0 bankAuthenticator, Ek biometricAuthenticator, C2014wc createSdkOtpCodeUseCase, C1876qn resourceManager, F9 appNameUtil, U5 getDeviceInfoUseCase, C1993vg featuresHandler) {
        super(metricFacade, sPayDataContract, clearUtil, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(clearUtil, "clearUtil");
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        Intrinsics.checkNotNullParameter(fullEmissionUseCase, "fullEmissionUseCase");
        Intrinsics.checkNotNullParameter(bankAuthenticator, "bankAuthenticator");
        Intrinsics.checkNotNullParameter(biometricAuthenticator, "biometricAuthenticator");
        Intrinsics.checkNotNullParameter(createSdkOtpCodeUseCase, "createSdkOtpCodeUseCase");
        Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
        Intrinsics.checkNotNullParameter(appNameUtil, "appNameUtil");
        Intrinsics.checkNotNullParameter(getDeviceInfoUseCase, "getDeviceInfoUseCase");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        this.e = sPayStorage;
        this.f = sPaySdkReducer;
        this.g = authHandler;
        this.h = fullEmissionUseCase;
        this.i = bankAuthenticator;
        this.j = biometricAuthenticator;
        this.k = createSdkOtpCodeUseCase;
        this.l = resourceManager;
        this.m = appNameUtil;
        this.n = getDeviceInfoUseCase;
        this.o = featuresHandler;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(new C2064yc(new C1784n6(K2.a)));
        this.p = MutableStateFlow;
        this.q = FlowKt.asStateFlow(MutableStateFlow);
        Flow flowMapLatest = FlowKt.mapLatest(c(), new C2079z2(null));
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        this.r = FlowKt.stateIn(flowMapLatest, viewModelScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), Boolean.TRUE);
        this.s = FlowKt.stateIn(FlowKt.mapLatest(c(), new C2054y2(this, sPayDataContract, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new C2029x2(this, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(npi.spay.A2 r25, npi.spay.C2085z8 r26, npi.spay.C1874ql r27, kotlin.coroutines.Continuation r28) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.A2.a(npi.spay.A2, npi.spay.z8, npi.spay.ql, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final StateFlow c() {
        return ((C1822oj) this.e).b;
    }

    public final Boolean d() {
        C1709k6 c1709k6 = this.o.b;
        if (c1709k6 != null) {
            return Boolean.valueOf(c1709k6.a);
        }
        return null;
    }

    @Override // npi.spay.AbstractC1810o7, npi.spay.AbstractC1819og
    public final void a(AbstractC1794ng event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.a(event);
        if (Intrinsics.areEqual(event, C1883r6.a)) {
            Function1<? super PaymentResult, Unit> function1 = b.a.d;
            if (function1 != null) {
                Parcelable cancel = this.u;
                if (cancel == null) {
                    cancel = new PaymentResult.Cancel((String) FlowKt.asStateFlow(((Di) this.b).B).getValue());
                }
                function1.invoke(cancel);
                Unit unit = Unit.INSTANCE;
            }
            C1560e6 event2 = new C1560e6(EnumC1505c1.MACPay, null, C0.MAC, null, null, null, null, 122);
            Intrinsics.checkNotNullParameter(event2, "event");
            this.a.a(event2);
            C1982v5 c1982v5 = this.c;
            if (c1982v5 != null) {
                c1982v5.invoke();
            }
        }
    }
}
