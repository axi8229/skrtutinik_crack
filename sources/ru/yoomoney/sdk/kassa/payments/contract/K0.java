package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class K0 extends Lambda implements Function1 {
    public final /* synthetic */ RuntimeViewModelDependencies a;
    public final /* synthetic */ O0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K0(RuntimeViewModelDependencies runtimeViewModelDependencies, O0 o0) {
        super(1);
        this.a = runtimeViewModelDependencies;
        this.b = o0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new I0(this.a, invoke, null));
        CoreKt.input(invoke, new J0(this.b, null));
        return Unit.INSTANCE;
    }
}
