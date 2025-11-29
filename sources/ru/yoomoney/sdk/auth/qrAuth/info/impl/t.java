package ru.yoomoney.sdk.auth.qrAuth.info.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class t extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<QrAuthInfo.State, QrAuthInfo.Action, QrAuthInfo.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(RuntimeViewModelDependencies<QrAuthInfo.State, QrAuthInfo.Action, QrAuthInfo.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> builder) {
        Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new s(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
