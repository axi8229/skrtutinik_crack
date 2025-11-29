package ru.yoomoney.sdk.auth.password.enter.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class u extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(RuntimeViewModelDependencies<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
        Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new t(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
