package ru.yoomoney.sdk.auth.auxToken.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class l extends Lambda implements Function1<Out.Builder<? extends AuxTokenIssue.State.LoadingAuxAuthorizationInfo, AuxTokenIssue.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<AuxTokenIssue.State, AuxTokenIssue.Action, AuxTokenIssue.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(RuntimeViewModelDependencies<AuxTokenIssue.State, AuxTokenIssue.Action, AuxTokenIssue.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends AuxTokenIssue.State.LoadingAuxAuthorizationInfo, AuxTokenIssue.Action> builder) {
        Out.Builder<? extends AuxTokenIssue.State.LoadingAuxAuthorizationInfo, AuxTokenIssue.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new k(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
