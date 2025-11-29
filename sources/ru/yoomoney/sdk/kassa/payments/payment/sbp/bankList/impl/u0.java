package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class u0 extends Lambda implements Function1 {
    public final /* synthetic */ w0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(w0 w0Var) {
        super(1);
        this.a = w0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return Out.INSTANCE.invoke(ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.z.a, new t0(RuntimeViewModel, this.a));
    }
}
