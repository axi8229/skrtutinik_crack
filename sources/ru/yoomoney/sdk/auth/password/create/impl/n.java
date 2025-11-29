package ru.yoomoney.sdk.auth.password.create.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;
import ru.yoomoney.sdk.march.Out;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.password.create.impl.PasswordCreateBusinessLogic$handleProgressState$2$2", f = "PasswordCreateBusinessLogic.kt", l = {118}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class n extends SuspendLambda implements Function1<Continuation<? super PasswordCreate.Action>, Object> {
    public int a;
    public final /* synthetic */ PasswordCreateBusinessLogic b;
    public final /* synthetic */ Out.Builder<PasswordCreate.State.Content, PasswordCreate.Action> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PasswordCreateBusinessLogic passwordCreateBusinessLogic, Out.Builder<PasswordCreate.State.Content, PasswordCreate.Action> builder, Continuation<? super n> continuation) {
        super(1, continuation);
        this.b = passwordCreateBusinessLogic;
        this.c = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new n(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PasswordCreate.Action> continuation) {
        return new n(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showState;
            PasswordCreate.State.Content state = this.c.getState();
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
