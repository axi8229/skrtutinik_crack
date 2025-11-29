package ru.yoomoney.sdk.kassa.payments.paymentAuth.di;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.E1;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.H0;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.H1;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.P;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class e extends Lambda implements Function1 {
    public final /* synthetic */ F a;
    public final /* synthetic */ H1 b;
    public final /* synthetic */ E1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(F f, E1 e1, H1 h1) {
        super(1);
        this.a = f;
        this.b = h1;
        this.c = e1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return new P(this.a, new H0(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource(), this.b, this.c));
    }
}
