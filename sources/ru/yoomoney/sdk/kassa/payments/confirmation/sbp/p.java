package ru.yoomoney.sdk.kassa.payments.confirmation.sbp;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class p extends Lambda implements Function1 {
    public final /* synthetic */ r a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(r rVar) {
        super(1);
        this.a = rVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return Out.INSTANCE.invoke(j.a, new o(RuntimeViewModel, this.a));
    }
}
