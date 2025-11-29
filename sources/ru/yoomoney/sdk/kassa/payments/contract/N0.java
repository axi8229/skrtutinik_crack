package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.M1;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class N0 extends Lambda implements Function1 {
    public final /* synthetic */ O0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N0(O0 o0) {
        super(1);
        this.a = o0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        O0 o0 = this.a;
        ru.yoomoney.sdk.kassa.payments.metrics.F f = o0.e;
        PaymentParameters paymentParameters = o0.c;
        Function2 showState = RuntimeViewModel.getShowState();
        Function2 showEffect = RuntimeViewModel.getShowEffect();
        Function1 source = RuntimeViewModel.getSource();
        O0 o02 = this.a;
        X0 x0 = o02.b;
        ru.yoomoney.sdk.kassa.payments.logout.c cVar = o02.d;
        ru.yoomoney.sdk.kassa.payments.model.B b = o02.g;
        ru.yoomoney.sdk.kassa.payments.payment.c cVar2 = o02.h;
        M1 m1 = o02.k;
        ru.yoomoney.sdk.kassa.payments.secure.j jVar = o02.i;
        ru.yoomoney.sdk.kassa.payments.config.f fVar = o02.l;
        String strA = R0.a(o02.a);
        O0 o03 = this.a;
        P p = new P(showState, showEffect, source, paymentParameters, x0, cVar, b, cVar2, jVar, m1, fVar, strA, o03.m, o03.n);
        O0 o04 = this.a;
        return new C2253t(f, p, o04.f, o04.c, o04.j, new M0(o04));
    }
}
