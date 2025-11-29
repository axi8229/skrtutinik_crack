package ru.yoomoney.sdk.auth.password.create.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.password.create.impl.PasswordCreateBusinessLogic$handleContentState$4$1", f = "PasswordCreateBusinessLogic.kt", l = {54}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class d extends SuspendLambda implements Function1<Continuation<? super PasswordCreate.Action>, Object> {
    public int a;
    public final /* synthetic */ PasswordCreateBusinessLogic b;
    public final /* synthetic */ PasswordCreate.State.Content c;
    public final /* synthetic */ PasswordCreate.Action d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Continuation continuation, PasswordCreate.Action action, PasswordCreate.State.Content content, PasswordCreateBusinessLogic passwordCreateBusinessLogic) {
        super(1, continuation);
        this.b = passwordCreateBusinessLogic;
        this.c = content;
        this.d = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        PasswordCreateBusinessLogic passwordCreateBusinessLogic = this.b;
        return new d(continuation, this.d, this.c, passwordCreateBusinessLogic);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PasswordCreate.Action> continuation) {
        return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BasePasswordCreateInteractor basePasswordCreateInteractor = this.b.interactor;
            PasswordCreate.State.Content content = this.c;
            PasswordCreate.Action.ValidateBeforeSubmit validateBeforeSubmit = (PasswordCreate.Action.ValidateBeforeSubmit) this.d;
            this.a = 1;
            obj = basePasswordCreateInteractor.validateBeforeSubmit(content, validateBeforeSubmit, this);
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
