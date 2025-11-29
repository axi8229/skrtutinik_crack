package ru.yoomoney.sdk.auth.acceptTerms.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class h extends Lambda implements Function1<Out.Builder<? extends AcceptTerms.State.Content, AcceptTerms.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<AcceptTerms.State, AcceptTerms.Action, AcceptTerms.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(RuntimeViewModelDependencies<AcceptTerms.State, AcceptTerms.Action, AcceptTerms.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends AcceptTerms.State.Content, AcceptTerms.Action> builder) {
        Out.Builder<? extends AcceptTerms.State.Content, AcceptTerms.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new g(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
