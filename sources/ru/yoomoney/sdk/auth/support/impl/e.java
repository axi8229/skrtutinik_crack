package ru.yoomoney.sdk.auth.support.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.support.TechnicalSupport;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class e extends Lambda implements Function1<Out.Builder<? extends TechnicalSupport.State.Content, TechnicalSupport.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<TechnicalSupport.State, TechnicalSupport.Action, TechnicalSupport.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(RuntimeViewModelDependencies<TechnicalSupport.State, TechnicalSupport.Action, TechnicalSupport.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends TechnicalSupport.State.Content, TechnicalSupport.Action> builder) {
        Out.Builder<? extends TechnicalSupport.State.Content, TechnicalSupport.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new d(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
