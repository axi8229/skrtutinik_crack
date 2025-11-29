package ru.yoomoney.sdk.auth.finishing.failure.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailure;
import ru.yoomoney.sdk.march.Out;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.finishing.failure.impl.AuthFinishingFailureBusinessLogic$handleInitState$1$1", f = "AuthFinishingFailureBusinessLogic.kt", l = {31}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class e extends SuspendLambda implements Function1<Continuation<? super AuthFinishingFailure.Action>, Object> {
    public int a;
    public final /* synthetic */ AuthFinishingFailureBusinessLogic b;
    public final /* synthetic */ Out.Builder<AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AuthFinishingFailureBusinessLogic authFinishingFailureBusinessLogic, Out.Builder<AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> builder, Continuation<? super e> continuation) {
        super(1, continuation);
        this.b = authFinishingFailureBusinessLogic;
        this.c = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new e(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AuthFinishingFailure.Action> continuation) {
        return new e(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showState;
            AuthFinishingFailure.State.Content state = this.c.getState();
            this.a = 1;
            obj = function2.invoke(state, this);
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
