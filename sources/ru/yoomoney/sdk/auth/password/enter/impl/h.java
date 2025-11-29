package ru.yoomoney.sdk.auth.password.enter.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.password.enter.impl.PasswordEnterBusinessLogic$handleContentState$6$2", f = "PasswordEnterBusinessLogic.kt", l = {54}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class h extends SuspendLambda implements Function1<Continuation<? super PasswordEnter.Action>, Object> {
    public int a;
    public final /* synthetic */ PasswordEnterBusinessLogic b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PasswordEnterBusinessLogic passwordEnterBusinessLogic, Continuation<? super h> continuation) {
        super(1, continuation);
        this.b = passwordEnterBusinessLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new h(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PasswordEnter.Action> continuation) {
        return new h(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BasePasswordEnterInteractor basePasswordEnterInteractor = this.b.interactor;
            this.a = 1;
            obj = basePasswordEnterInteractor.recoverPassword(this);
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
