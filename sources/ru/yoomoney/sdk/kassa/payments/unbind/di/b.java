package ru.yoomoney.sdk.kassa.payments.unbind.di;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.unbind.impl.w;
import ru.yoomoney.sdk.kassa.payments.unbind.impl.x;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1 {
    public final /* synthetic */ x a;
    public final /* synthetic */ F b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(F f, x xVar) {
        super(1);
        this.a = xVar;
        this.b = f;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return new ru.yoomoney.sdk.kassa.payments.unbind.a(this.b, new w(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource(), this.a));
    }
}
