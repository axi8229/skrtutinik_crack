package ru.yoomoney.sdk.kassa.payments.confirmation.sbp;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes5.dex */
public final class o extends Lambda implements Function1 {
    public final /* synthetic */ RuntimeViewModelDependencies a;
    public final /* synthetic */ r b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(RuntimeViewModelDependencies runtimeViewModelDependencies, r rVar) {
        super(1);
        this.a = runtimeViewModelDependencies;
        this.b = rVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new m(this.a, invoke, null));
        CoreKt.input(invoke, new n(this.b, null));
        return Unit.INSTANCE;
    }
}
