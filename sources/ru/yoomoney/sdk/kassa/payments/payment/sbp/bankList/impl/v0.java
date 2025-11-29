package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class v0 extends Lambda implements Function1 {
    public final /* synthetic */ w0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(w0 w0Var) {
        super(1);
        this.a = w0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        ru.yoomoney.sdk.kassa.payments.metrics.F f = this.a.a;
        Function2 showState = RuntimeViewModel.getShowState();
        Function2 showEffect = RuntimeViewModel.getShowEffect();
        Function1 source = RuntimeViewModel.getSource();
        w0 w0Var = this.a;
        d0 d0Var = w0Var.b;
        q0 q0Var = w0Var.c;
        return new C2345a(f, new c0(showState, showEffect, source, d0Var, q0Var.a, q0Var.b));
    }
}
