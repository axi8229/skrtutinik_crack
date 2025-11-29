package ru.yoomoney.sdk.auth.finishing.failure.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailure;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class g extends Lambda implements Function1<Out.Builder<? extends AuthFinishingFailure.State.Init, AuthFinishingFailure.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<AuthFinishingFailure.State, AuthFinishingFailure.Action, AuthFinishingFailure.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(RuntimeViewModelDependencies<AuthFinishingFailure.State, AuthFinishingFailure.Action, AuthFinishingFailure.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends AuthFinishingFailure.State.Init, AuthFinishingFailure.Action> builder) {
        Out.Builder<? extends AuthFinishingFailure.State.Init, AuthFinishingFailure.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new f(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
