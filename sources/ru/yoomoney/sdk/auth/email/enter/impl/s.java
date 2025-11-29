package ru.yoomoney.sdk.auth.email.enter.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class s extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<EmailEnter.State, EmailEnter.Action, EmailEnter.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(RuntimeViewModelDependencies<EmailEnter.State, EmailEnter.Action, EmailEnter.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
        Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new r(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
