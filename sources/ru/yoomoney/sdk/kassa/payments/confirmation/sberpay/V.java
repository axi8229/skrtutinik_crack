package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class V extends Lambda implements Function1 {
    public final /* synthetic */ X a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(X x) {
        super(1);
        this.a = x;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return Out.INSTANCE.invoke(C2209t.a, new U(RuntimeViewModel, this.a));
    }
}
