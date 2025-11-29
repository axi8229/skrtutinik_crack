package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C2342a;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C2343b;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C2344c;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class c0 implements Function2 {
    public final Function2 a;
    public final Function2 b;
    public final Function1 c;
    public final d0 d;
    public final String e;
    public final String f;

    public c0(Function2 showState, Function2 showEffect, Function1 source, d0 interactor, String confirmationUrl, String paymentId) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        this.a = showState;
        this.b = showEffect;
        this.c = source;
        this.d = interactor;
        this.e = confirmationUrl;
        this.f = paymentId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v7, types: [ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Out.Companion companion;
        Function c2351g;
        ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.t tVar;
        ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C state = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C) obj;
        ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.o action = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.o) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.z) {
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.z zVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.z) state;
            if (!(action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.i)) {
                return action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.f ? Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v(((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.f) action).a, false), new L(this)) : action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.e ? Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.u(((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.e) action).a), new N(this)) : Out.INSTANCE.skip(zVar, this.c);
            }
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.i iVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.i) action;
            return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A(iVar.a, iVar.b), new J(this));
        }
        if (state instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.u) {
            return action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.d ? Out.INSTANCE.invoke(ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.z.a, new C2360p(this)) : Out.INSTANCE.skip((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.u) state, this.c);
        }
        if (state instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A) {
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A a = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A) state;
            if (action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.g) {
                return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v(a.b, true), new P(this));
            }
            if (action instanceof C2343b) {
                return Out.INSTANCE.invoke(a, new S(this));
            }
            if (action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.n) {
                return Out.INSTANCE.invoke(a, new H(this, ((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.n) action).a));
            }
            if (action instanceof C2344c) {
                return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.B(a.a, a.b), new C2357m(this));
            }
            if (action instanceof C2342a) {
                return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.t(((C2342a) action).a, a), new C2347c(this));
            }
            return Out.INSTANCE.skip(a, this.c);
        }
        if (!(state instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v)) {
            if (state instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.B) {
                ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.B b = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.B) state;
                return action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.k ? Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A(b.a, b.b), new X(this)) : action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.j ? Out.INSTANCE.invoke(b, new Z(this)) : action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.l ? Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.y(((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.l) action).a, b.a, b.b), new b0(this)) : Out.INSTANCE.skip(b, this.c);
            }
            if (state instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.w) {
                ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.w wVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.w) state;
                return action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.k ? Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v(wVar.a, wVar.b), new B(this)) : action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.j ? Out.INSTANCE.invoke(wVar, new D(this)) : action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.l ? Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.x(((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.l) action).a, wVar.a, wVar.b), new F(this)) : Out.INSTANCE.skip(wVar, this.c);
            }
            if (state instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.y) {
                ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.y yVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.y) state;
                return ((action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.h) || Intrinsics.areEqual(action, C2344c.a)) ? Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.B(yVar.b, yVar.c), new V(this)) : Out.INSTANCE.skip(yVar, this.c);
            }
            if (state instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.x) {
                ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.x xVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.x) state;
                if ((action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.h) || Intrinsics.areEqual(action, C2344c.a)) {
                    return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.w(xVar.c, xVar.b), new C2369z(this));
                }
                return Out.INSTANCE.skip(xVar, this.c);
            }
            if (!(state instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.t)) {
                throw new NoWhenBranchMatchedException();
            }
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.t tVar2 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.t) state;
            if (action instanceof C2343b) {
                companion = Out.INSTANCE;
                ?? r9 = tVar2.b;
                c2351g = new C2349e(this);
                tVar = r9;
            } else {
                if (!(action instanceof C2344c)) {
                    return Out.INSTANCE.skip(tVar2, this.c);
                }
                companion = Out.INSTANCE;
                c2351g = new C2351g(this);
                tVar = tVar2;
            }
            return companion.invoke(tVar, c2351g);
        }
        ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v vVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v) state;
        if (action instanceof C2343b) {
            return Out.INSTANCE.invoke(vVar, new C2362s(this, vVar));
        }
        if (action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.i) {
            return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A(((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.i) action).a, vVar.a), new C2364u(this));
        }
        if (action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.n) {
            return Out.INSTANCE.invoke(vVar, new H(this, ((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.n) action).a));
        }
        if (action instanceof C2344c) {
            return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.w(vVar.b, vVar.a), new C2354j(this));
        }
        if (action instanceof C2342a) {
            return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.t(((C2342a) action).a, vVar), new C2347c(this));
        }
        if (!(action instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.m)) {
            return Out.INSTANCE.skip(vVar, this.c);
        }
        Out.Companion companion2 = Out.INSTANCE;
        String searchText = ((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.m) action).a;
        d0 d0Var = this.d;
        List banks = vVar.a;
        ((j0) d0Var).getClass();
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Intrinsics.checkNotNullParameter(banks, "banks");
        ArrayList searchedBanks = new ArrayList();
        for (Object obj3 : banks) {
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a aVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a) obj3;
            if (StringsKt.contains((CharSequence) aVar.c, (CharSequence) searchText, true) || StringsKt.contains((CharSequence) aVar.b, (CharSequence) searchText, true)) {
                searchedBanks.add(obj3);
            }
        }
        List bankList = vVar.a;
        boolean z = vVar.b;
        Intrinsics.checkNotNullParameter(bankList, "bankList");
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Intrinsics.checkNotNullParameter(searchedBanks, "searchedBanks");
        return companion2.invoke(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v(bankList, z, searchText, searchedBanks), new C2366w(this));
    }
}
