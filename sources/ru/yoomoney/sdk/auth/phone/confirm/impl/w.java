package ru.yoomoney.sdk.auth.phone.confirm.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class w extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<PhoneConfirm.State, PhoneConfirm.Action, PhoneConfirm.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(RuntimeViewModelDependencies<PhoneConfirm.State, PhoneConfirm.Action, PhoneConfirm.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
        Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new v(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
