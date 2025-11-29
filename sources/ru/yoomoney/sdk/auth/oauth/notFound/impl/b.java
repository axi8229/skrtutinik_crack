package ru.yoomoney.sdk.auth.oauth.notFound.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundBusinessLogic$handleContentState$1$2", f = "OauthNotFoundBusinessLogic.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class b extends SuspendLambda implements Function1<Continuation<? super OauthNotFound.Action>, Object> {
    public int a;
    public final /* synthetic */ OauthNotFoundBusinessLogic b;
    public final /* synthetic */ OauthNotFound.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(OauthNotFoundBusinessLogic oauthNotFoundBusinessLogic, OauthNotFound.Action action, Continuation<? super b> continuation) {
        super(1, continuation);
        this.b = oauthNotFoundBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new b(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super OauthNotFound.Action> continuation) {
        return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            OauthNotFoundInteractor oauthNotFoundInteractor = this.b.interactor;
            String processId = ((OauthNotFound.Action.StartRegistration) this.c).getProcessId();
            Config.ProcessType processType = this.b.config.getProcessType();
            this.a = 1;
            obj = oauthNotFoundInteractor.initRegistration(processId, processType, this);
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
