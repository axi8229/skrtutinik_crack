package ru.yoomoney.sdk.auth.nickname.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.nickname.Nickname;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class i extends Lambda implements Function1<Out.Builder<? extends Nickname.State.Content, Nickname.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<Nickname.State, Nickname.Action, Nickname.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(RuntimeViewModelDependencies<Nickname.State, Nickname.Action, Nickname.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends Nickname.State.Content, Nickname.Action> builder) {
        Out.Builder<? extends Nickname.State.Content, Nickname.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new h(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
