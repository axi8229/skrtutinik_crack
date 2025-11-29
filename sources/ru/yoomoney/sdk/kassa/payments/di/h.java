package ru.yoomoney.sdk.kassa.payments.di;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.model.B;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.E1;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.F1;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.T;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class h extends Lambda implements Function1 {
    public final /* synthetic */ i a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar) {
        super(1);
        this.a = iVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        F f = this.a.d;
        Function2 showState = RuntimeViewModel.getShowState();
        Function2 showEffect = RuntimeViewModel.getShowEffect();
        Function1 source = RuntimeViewModel.getSource();
        i iVar = this.a;
        F1 f1 = iVar.b;
        ru.yoomoney.sdk.kassa.payments.logout.c cVar = iVar.g;
        PaymentParameters paymentParameters = iVar.c;
        String str = iVar.a.a;
        B b = iVar.h;
        E1 e1 = new E1(showState, showEffect, source, f1, paymentParameters, str, cVar, iVar.i, b, iVar.j, iVar.l, new g(iVar), iVar.f);
        i iVar2 = this.a;
        return new T(f, e1, iVar2.e, iVar2.f);
    }
}
