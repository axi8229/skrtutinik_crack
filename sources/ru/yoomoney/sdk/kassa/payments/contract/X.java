package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final /* synthetic */ class X extends FunctionReferenceImpl implements Function1 {
    public X(Object obj) {
        super(1, obj, C2264y0.class, "showEffect", "showEffect(Lru/yoomoney/sdk/kassa/payments/contract/Contract$Effect;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ru.yoomoney.sdk.kassa.payments.navigation.c cVarB;
        ru.yoomoney.sdk.kassa.payments.navigation.v jVar;
        AbstractC2244o p0 = (AbstractC2244o) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        C2264y0 c2264y0 = (C2264y0) this.receiver;
        int i = C2264y0.$r8$clinit;
        c2264y0.getClass();
        if (p0 instanceof C2242n) {
            ((ru.yoomoney.sdk.kassa.payments.navigation.a) c2264y0.b()).a(new ru.yoomoney.sdk.kassa.payments.navigation.o(((C2242n) p0).a));
        } else {
            if (Intrinsics.areEqual(p0, C2240m.a)) {
                c2264y0.getParentFragmentManager().popBackStack();
                cVarB = c2264y0.b();
                jVar = new ru.yoomoney.sdk.kassa.payments.navigation.j(null);
            } else if (Intrinsics.areEqual(p0, C2238l.a)) {
                cVarB = c2264y0.b();
                jVar = ru.yoomoney.sdk.kassa.payments.navigation.p.a;
            }
            ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVarB).a(jVar);
        }
        return Unit.INSTANCE;
    }
}
