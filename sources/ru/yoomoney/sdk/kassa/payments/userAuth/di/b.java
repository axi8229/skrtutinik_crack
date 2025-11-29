package ru.yoomoney.sdk.kassa.payments.userAuth.di;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.userAuth.C2553p;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1 {
    public static final b a = new b();

    public b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RuntimeViewModelDependencies RuntimeViewModel = (RuntimeViewModelDependencies) obj;
        Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
        return Out.INSTANCE.skip(C2553p.a, RuntimeViewModel.getSource());
    }
}
