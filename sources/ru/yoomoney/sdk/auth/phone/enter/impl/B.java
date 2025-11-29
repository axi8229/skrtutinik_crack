package ru.yoomoney.sdk.auth.phone.enter.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class B extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.PreLoad, PhoneEnter.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<PhoneEnter.State, PhoneEnter.Action, PhoneEnter.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(RuntimeViewModelDependencies<PhoneEnter.State, PhoneEnter.Action, PhoneEnter.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends PhoneEnter.State.PreLoad, PhoneEnter.Action> builder) {
        Out.Builder<? extends PhoneEnter.State.PreLoad, PhoneEnter.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new A(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
