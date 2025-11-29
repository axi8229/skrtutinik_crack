package ru.yoomoney.sdk.auth.api.login.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.api.login.LoginEnter;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class m extends Lambda implements Function1<Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<LoginEnter.State, LoginEnter.Action, LoginEnter.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(RuntimeViewModelDependencies<LoginEnter.State, LoginEnter.Action, LoginEnter.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> builder) {
        Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new l(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
