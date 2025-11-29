package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class W extends Lambda implements Function1 {
    public final /* synthetic */ X a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(X x) {
        super(1);
        this.a = x;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        Function2 showState = RuntimeViewModel.getShowState();
        Function2 showEffect = RuntimeViewModel.getShowEffect();
        Function1 source = RuntimeViewModel.getSource();
        X x = this.a;
        I i = x.a;
        Q q = x.b;
        return new C2200j(showState, showEffect, source, i, q.a, q.b);
    }
}
