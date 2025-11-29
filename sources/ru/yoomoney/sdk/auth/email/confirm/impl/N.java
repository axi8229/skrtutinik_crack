package ru.yoomoney.sdk.auth.email.confirm.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class N extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(RuntimeViewModelDependencies<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
        Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new M(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
