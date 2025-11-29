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

@DebugMetadata(c = "ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundBusinessLogic$handleProgressRegistrationState$1$1", f = "OauthNotFoundBusinessLogic.kt", l = {52}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class i extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ OauthNotFoundBusinessLogic b;
    public final /* synthetic */ OauthNotFound.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(OauthNotFoundBusinessLogic oauthNotFoundBusinessLogic, OauthNotFound.Action action, Continuation<? super i> continuation) {
        super(1, continuation);
        this.b = oauthNotFoundBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new i(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new i(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            OauthNotFound.Effect.ShowNextRegistrationStep showNextRegistrationStep = new OauthNotFound.Effect.ShowNextRegistrationStep(((OauthNotFound.Action.RegistrationSuccess) this.c).getProcess());
            this.a = 1;
            if (function2.invoke(showNextRegistrationStep, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
