package ru.yoomoney.sdk.auth.password.create.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.password.create.impl.PasswordCreateBusinessLogic$handleContentState$6$2", f = "PasswordCreateBusinessLogic.kt", l = {75}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class g extends SuspendLambda implements Function1<Continuation<? super PasswordCreate.Action>, Object> {
    public int a;
    public final /* synthetic */ PasswordCreateBusinessLogic b;
    public final /* synthetic */ PasswordCreate.Action c;
    public final /* synthetic */ PasswordCreate.State.Content d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Continuation continuation, PasswordCreate.Action action, PasswordCreate.State.Content content, PasswordCreateBusinessLogic passwordCreateBusinessLogic) {
        super(1, continuation);
        this.b = passwordCreateBusinessLogic;
        this.c = action;
        this.d = content;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new g(continuation, this.c, this.d, this.b);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PasswordCreate.Action> continuation) {
        return ((g) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BasePasswordCreateInteractor basePasswordCreateInteractor = this.b.interactor;
            PasswordCreate.Action.Submit submit = (PasswordCreate.Action.Submit) this.c;
            String firstPassword = this.d.getFirstPassword();
            this.a = 1;
            obj = basePasswordCreateInteractor.submitPassword(submit, firstPassword, this);
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
