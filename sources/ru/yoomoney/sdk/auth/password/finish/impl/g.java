package ru.yoomoney.sdk.auth.password.finish.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.password.finish.PasswordFinish;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class g extends Lambda implements Function1<Out.Builder<? extends PasswordFinish.State.Content, PasswordFinish.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<PasswordFinish.State, PasswordFinish.Action, PasswordFinish.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(RuntimeViewModelDependencies<PasswordFinish.State, PasswordFinish.Action, PasswordFinish.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends PasswordFinish.State.Content, PasswordFinish.Action> builder) {
        Out.Builder<? extends PasswordFinish.State.Content, PasswordFinish.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new f(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
