package ru.yoomoney.sdk.auth.email.enter.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.email.enter.impl.EmailEnterBusinessLogic$handleContentState$6$2", f = "EmailEnterBusinessLogic.kt", l = {58}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class h extends SuspendLambda implements Function1<Continuation<? super EmailEnter.Action>, Object> {
    public int a;
    public final /* synthetic */ EmailEnterBusinessLogic b;
    public final /* synthetic */ EmailEnter.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(EmailEnterBusinessLogic emailEnterBusinessLogic, EmailEnter.Action action, Continuation<? super h> continuation) {
        super(1, continuation);
        this.b = emailEnterBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new h(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super EmailEnter.Action> continuation) {
        return new h(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BaseEmailEnterInteractor baseEmailEnterInteractor = this.b.interactor;
            String processId = ((EmailEnter.Action.ConfirmEmail) this.c).getProcessId();
            this.a = 1;
            obj = baseEmailEnterInteractor.registrationConfirmEmail(processId, this);
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
