package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class L0 extends Lambda implements Function1 {
    public final /* synthetic */ O0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L0(O0 o0) {
        super(1);
        this.a = o0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return Out.INSTANCE.invoke(r.a, new K0(RuntimeViewModel, this.a));
    }
}
