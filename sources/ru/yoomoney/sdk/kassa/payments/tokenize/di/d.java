package ru.yoomoney.sdk.kassa.payments.tokenize.di;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.metrics.InterfaceC2309s;
import ru.yoomoney.sdk.kassa.payments.metrics.V;
import ru.yoomoney.sdk.kassa.payments.metrics.e0;
import ru.yoomoney.sdk.kassa.payments.secure.j;
import ru.yoomoney.sdk.kassa.payments.tokenize.C2524a;
import ru.yoomoney.sdk.kassa.payments.tokenize.I;
import ru.yoomoney.sdk.kassa.payments.tokenize.s;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class d extends Lambda implements Function1 {
    public final /* synthetic */ F a;
    public final /* synthetic */ InterfaceC2309s b;
    public final /* synthetic */ I c;
    public final /* synthetic */ e0 d;
    public final /* synthetic */ j e;
    public final /* synthetic */ V f;
    public final /* synthetic */ PaymentParameters g;
    public final /* synthetic */ UiParameters h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PaymentParameters paymentParameters, UiParameters uiParameters, InterfaceC2309s interfaceC2309s, F f, V v, e0 e0Var, j jVar, I i) {
        super(1);
        this.a = f;
        this.b = interfaceC2309s;
        this.c = i;
        this.d = e0Var;
        this.e = jVar;
        this.f = v;
        this.g = paymentParameters;
        this.h = uiParameters;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return new C2524a(this.a, this.b, new s(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource(), this.c), this.d, this.e, this.f, this.g, this.h);
    }
}
