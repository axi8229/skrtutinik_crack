package ru.yoomoney.sdk.auth.finishing.success.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class p extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<AuthFinishingSuccess.State, AuthFinishingSuccess.Action, AuthFinishingSuccess.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(RuntimeViewModelDependencies<AuthFinishingSuccess.State, AuthFinishingSuccess.Action, AuthFinishingSuccess.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> builder) {
        Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new o(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
