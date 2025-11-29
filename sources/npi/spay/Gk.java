package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.b;
import spay.sdk.domain.model.PayPartsStatus;
import spay.sdk.domain.model.response.OrderScreenDataResponse;
import spay.sdk.view.BnplButtonCompositeView;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class Gk {
    public final Ih a;
    public final Ei b;
    public final C1993vg c;
    public final Qb d;

    public Gk(Ih sPayDataContract, Ei sPayStorage, C1993vg featuresHandler, Qb authHandler) {
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        this.a = sPayDataContract;
        this.b = sPayStorage;
        this.c = featuresHandler;
        this.d = authHandler;
    }

    public final void a(boolean z) {
        spay.sdk.d dVar;
        C1993vg c1993vg = this.c;
        EnumC1628h tag = EnumC1628h.BNPL;
        c1993vg.getClass();
        Intrinsics.checkNotNullParameter(tag, "tag");
        InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
        if (interfaceC2089zc != null) {
            interfaceC2089zc.a(new C1983v6(false));
        }
        Di di = (Di) this.a;
        di.getClass();
        Hh type = Hh.ALL;
        Intrinsics.checkNotNullParameter(type, "type");
        Timber.INSTANCE.d("clearCache ALL", new Object[0]);
        di.r.tryEmit(null);
        di.s.tryEmit(null);
        di.c = null;
        di.d = null;
        di.e = null;
        di.f.setValue(null);
        di.a((OrderScreenDataResponse) null);
        di.m = null;
        di.o.setValue(null);
        di.p = false;
        di.q = null;
        C1822oj c1822oj = (C1822oj) this.b;
        c1822oj.getClass();
        C1604g0 income = new C1604g0(C1456a2.a, null, false);
        Intrinsics.checkNotNullParameter(income, "income");
        c1822oj.a.setValue(income);
        C1993vg c1993vg2 = this.c;
        c1993vg2.getClass();
        Intrinsics.checkNotNullParameter(tag, "tag");
        InterfaceC2089zc interfaceC2089zc2 = (InterfaceC2089zc) c1993vg2.c.get(tag);
        if (interfaceC2089zc2 != null) {
            interfaceC2089zc2.a(new C1983v6(false));
        }
        Ec ec = (Ec) this.d;
        ec.getClass();
        Ua authDataMode = Ua.ALL;
        Intrinsics.checkNotNullParameter(authDataMode, "authDataMode");
        ec.b = false;
        ec.c = false;
        ec.d = false;
        synchronized (b.a.a) {
            try {
                dVar = spay.sdk.d.f;
                if (dVar == null) {
                    spay.sdk.d.f = new spay.sdk.d();
                    dVar = spay.sdk.d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } finally {
            }
        }
        dVar.getClass();
        b.a.b = null;
        b.a.c = null;
        b.a.d = null;
        spay.sdk.d.f = null;
        Di di2 = (Di) this.a;
        di2.getClass();
        di2.x = 0;
        ((Di) this.a).g.setValue(Boolean.TRUE);
        BnplButtonCompositeView.c = false;
        if (z) {
            Ih ih = this.a;
            PayPartsStatus status = PayPartsStatus.BASE_PAY;
            Di di3 = (Di) ih;
            di3.getClass();
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(status, "<set-?>");
            di3.y = status;
        }
        AbstractC1765mc.a = true;
    }
}
