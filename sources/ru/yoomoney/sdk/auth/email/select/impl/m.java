package ru.yoomoney.sdk.auth.email.select.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.email.select.EmailSelect;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class m extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Initial, EmailSelect.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<EmailSelect.State, EmailSelect.Action, EmailSelect.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(RuntimeViewModelDependencies<EmailSelect.State, EmailSelect.Action, EmailSelect.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends EmailSelect.State.Initial, EmailSelect.Action> builder) {
        Out.Builder<? extends EmailSelect.State.Initial, EmailSelect.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new l(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
