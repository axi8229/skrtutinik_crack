package ru.yoomoney.sdk.auth.password.finish.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.password.finish.PasswordFinish;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.password.finish.impl.PasswordFinishBusinessLogic$handleLogin$1$1", f = "PasswordFinishBusinessLogic.kt", l = {38}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class d extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ PasswordFinishBusinessLogic b;
    public final /* synthetic */ PasswordFinish.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PasswordFinishBusinessLogic passwordFinishBusinessLogic, PasswordFinish.Action action, Continuation<? super d> continuation) {
        super(1, continuation);
        this.b = passwordFinishBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new d(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new d(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            PasswordFinish.Effect.FinishWithResult finishWithResult = new PasswordFinish.Effect.FinishWithResult(((PasswordFinish.Action.CloseWithResult) this.c).getData());
            this.a = 1;
            if (function2.invoke(finishWithResult, this) == coroutine_suspended) {
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
