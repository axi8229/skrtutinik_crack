package ru.yoomoney.sdk.auth.socialAccounts.sberId.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.socialAccounts.sberId.SberId;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class m extends Lambda implements Function1<Out.Builder<? extends SberId.State.Empty, SberId.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<SberId.State, SberId.Action, SberId.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(RuntimeViewModelDependencies<SberId.State, SberId.Action, SberId.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends SberId.State.Empty, SberId.Action> builder) {
        Out.Builder<? extends SberId.State.Empty, SberId.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new l(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
