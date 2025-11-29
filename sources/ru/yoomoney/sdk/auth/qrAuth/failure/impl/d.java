package ru.yoomoney.sdk.auth.qrAuth.failure.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.qrAuth.failure.QrAuthFailureContract;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class d extends Lambda implements Function1<Out.Builder<? extends QrAuthFailureContract.State.Content, QrAuthFailureContract.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<QrAuthFailureContract.State, QrAuthFailureContract.Action, QrAuthFailureContract.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(RuntimeViewModelDependencies<QrAuthFailureContract.State, QrAuthFailureContract.Action, QrAuthFailureContract.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends QrAuthFailureContract.State.Content, QrAuthFailureContract.Action> builder) {
        Out.Builder<? extends QrAuthFailureContract.State.Content, QrAuthFailureContract.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new c(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
