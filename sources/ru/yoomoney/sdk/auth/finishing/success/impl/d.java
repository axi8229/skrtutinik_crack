package ru.yoomoney.sdk.auth.finishing.success.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessBusinessLogic$handleErrorAccountState$1$2", f = "AuthFinishingSuccessBusinessLogic.kt", l = {95}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class d extends SuspendLambda implements Function1<Continuation<? super AuthFinishingSuccess.Action>, Object> {
    public int a;
    public final /* synthetic */ AuthFinishingSuccessBusinessLogic b;
    public final /* synthetic */ AuthFinishingSuccess.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AuthFinishingSuccessBusinessLogic authFinishingSuccessBusinessLogic, AuthFinishingSuccess.Action action, Continuation<? super d> continuation) {
        super(1, continuation);
        this.b = authFinishingSuccessBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new d(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AuthFinishingSuccess.Action> continuation) {
        return new d(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuthFinishingSuccessInteractor authFinishingSuccessInteractor = this.b.interactor;
            AuthFinishingSuccess.Action.LoadAccount loadAccount = (AuthFinishingSuccess.Action.LoadAccount) this.c;
            this.a = 1;
            obj = authFinishingSuccessInteractor.account(loadAccount, this);
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
