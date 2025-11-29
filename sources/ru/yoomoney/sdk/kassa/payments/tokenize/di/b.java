package ru.yoomoney.sdk.kassa.payments.tokenize.di;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1 {
    public final /* synthetic */ RuntimeViewModelDependencies a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(RuntimeViewModelDependencies runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new a(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
