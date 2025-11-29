package ru.yoomoney.sdk.auth.api.login.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.login.LoginEnter;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.impl.LoginEnterBusinessLogic$handleContentState$2$1", f = "LoginEnterBusinessLogic.kt", l = {37}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class b extends SuspendLambda implements Function1<Continuation<? super LoginEnter.Action>, Object> {
    public int a;
    public final /* synthetic */ LoginEnterBusinessLogic b;
    public final /* synthetic */ LoginEnter.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(LoginEnterBusinessLogic loginEnterBusinessLogic, LoginEnter.Action action, Continuation<? super b> continuation) {
        super(1, continuation);
        this.b = loginEnterBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new b(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super LoginEnter.Action> continuation) {
        return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoginEnterInteractor loginEnterInteractor = this.b.interactor;
            String processId = ((LoginEnter.Action.CheckExpiration) this.c).getProcessId();
            OffsetDateTime expireAt = ((LoginEnter.Action.CheckExpiration) this.c).getExpireAt();
            this.a = 1;
            obj = loginEnterInteractor.checkExpiration(processId, expireAt, this);
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
