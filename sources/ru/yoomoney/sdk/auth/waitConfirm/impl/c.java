package ru.yoomoney.sdk.auth.waitConfirm.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmation;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class c extends Lambda implements Function1<Out.Builder<? extends WaitConfirmation.State.Content, WaitConfirmation.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(RuntimeViewModelDependencies<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends WaitConfirmation.State.Content, WaitConfirmation.Action> builder) {
        Out.Builder<? extends WaitConfirmation.State.Content, WaitConfirmation.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new b(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
