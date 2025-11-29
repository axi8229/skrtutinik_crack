package ru.yoomoney.sdk.kassa.payments.userAuth.di;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.F1;
import ru.yoomoney.sdk.kassa.payments.userAuth.InterfaceC2538a;
import ru.yoomoney.sdk.kassa.payments.userAuth.K;
import ru.yoomoney.sdk.kassa.payments.userAuth.r;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1 {
    public final /* synthetic */ F a;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.tmx.a b;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.payment.b c;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.secure.j d;
    public final /* synthetic */ F1 e;
    public final /* synthetic */ InterfaceC2538a f;
    public final /* synthetic */ PaymentParameters g;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.payment.c h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PaymentParameters paymentParameters, F f, ru.yoomoney.sdk.kassa.payments.payment.b bVar, ru.yoomoney.sdk.kassa.payments.payment.c cVar, F1 f1, ru.yoomoney.sdk.kassa.payments.secure.j jVar, ru.yoomoney.sdk.kassa.payments.tmx.a aVar, InterfaceC2538a interfaceC2538a) {
        super(1);
        this.a = f;
        this.b = aVar;
        this.c = bVar;
        this.d = jVar;
        this.e = f1;
        this.f = interfaceC2538a;
        this.g = paymentParameters;
        this.h = cVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return new r(this.a, new K(RuntimeViewModel.getShowState(), RuntimeViewModel.getSource(), this.b, this.c, this.d, this.e, this.f, this.g, this.h));
    }
}
