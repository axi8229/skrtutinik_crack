package ru.yoomoney.sdk.auth.oauth.notFound.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundViewModelFactory$create$1$1$1", f = "OauthNotFoundViewModelFactory.kt", l = {22}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class q extends SuspendLambda implements Function1<Continuation<? super OauthNotFound.Action>, Object> {
    public int a;
    public final /* synthetic */ RuntimeViewModelDependencies<OauthNotFound.State, OauthNotFound.Action, OauthNotFound.Effect> b;
    public final /* synthetic */ Out.Builder<OauthNotFound.State.Content, OauthNotFound.Action> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(RuntimeViewModelDependencies<OauthNotFound.State, OauthNotFound.Action, OauthNotFound.Effect> runtimeViewModelDependencies, Out.Builder<OauthNotFound.State.Content, OauthNotFound.Action> builder, Continuation<? super q> continuation) {
        super(1, continuation);
        this.b = runtimeViewModelDependencies;
        this.c = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new q(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super OauthNotFound.Action> continuation) {
        return new q(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<OauthNotFound.State, Continuation<? super OauthNotFound.Action>, Object> showState = this.b.getShowState();
            OauthNotFound.State.Content state = this.c.getState();
            this.a = 1;
            obj = showState.invoke(state, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
