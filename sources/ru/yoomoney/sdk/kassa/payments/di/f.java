package ru.yoomoney.sdk.kassa.payments.di;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.P;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function1 {
    public final /* synthetic */ i a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i iVar) {
        super(1);
        this.a = iVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return Out.INSTANCE.invoke(new P(this.a.l.a().getYooMoneyLogoUrlLight()), new e(RuntimeViewModel, this.a));
    }
}
