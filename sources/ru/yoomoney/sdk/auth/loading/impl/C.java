package ru.yoomoney.sdk.auth.loading.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.loading.AuthLoading;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class C extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<AuthLoading.State, AuthLoading.Action, AuthLoading.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(RuntimeViewModelDependencies<AuthLoading.State, AuthLoading.Action, AuthLoading.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
        Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new B(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
