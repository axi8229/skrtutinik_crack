package ru.yoomoney.sdk.auth.password.create.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.password.create.impl.PasswordCreateBusinessLogic$handleContentState$8$1", f = "PasswordCreateBusinessLogic.kt", l = {83}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class i extends SuspendLambda implements Function1<Continuation<? super PasswordCreate.Action>, Object> {
    public int a;
    public final /* synthetic */ PasswordCreateBusinessLogic b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PasswordCreateBusinessLogic passwordCreateBusinessLogic, Continuation<? super i> continuation) {
        super(1, continuation);
        this.b = passwordCreateBusinessLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new i(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PasswordCreate.Action> continuation) {
        return new i(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BasePasswordCreateInteractor basePasswordCreateInteractor = this.b.interactor;
            this.a = 1;
            obj = basePasswordCreateInteractor.generatePassword(this);
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
