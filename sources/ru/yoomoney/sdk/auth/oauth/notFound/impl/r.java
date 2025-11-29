package ru.yoomoney.sdk.auth.oauth.notFound.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class r extends Lambda implements Function1<Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<OauthNotFound.State, OauthNotFound.Action, OauthNotFound.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(RuntimeViewModelDependencies<OauthNotFound.State, OauthNotFound.Action, OauthNotFound.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> builder) {
        Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new q(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
