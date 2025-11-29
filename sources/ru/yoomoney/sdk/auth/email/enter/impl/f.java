package ru.yoomoney.sdk.auth.email.enter.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.email.enter.impl.EmailEnterBusinessLogic$handleContentState$5$2", f = "EmailEnterBusinessLogic.kt", l = {54}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class f extends SuspendLambda implements Function1<Continuation<? super EmailEnter.Action>, Object> {
    public int a;
    public final /* synthetic */ EmailEnterBusinessLogic b;
    public final /* synthetic */ EmailEnter.Action c;
    public final /* synthetic */ EmailEnter.State.Content d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(EmailEnterBusinessLogic emailEnterBusinessLogic, EmailEnter.Action action, EmailEnter.State.Content content, Continuation<? super f> continuation) {
        super(1, continuation);
        this.b = emailEnterBusinessLogic;
        this.c = action;
        this.d = content;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new f(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super EmailEnter.Action> continuation) {
        return ((f) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BaseEmailEnterInteractor baseEmailEnterInteractor = this.b.interactor;
            EmailEnter.Action.SendEmail sendEmail = (EmailEnter.Action.SendEmail) this.c;
            String email = this.d.getEmail();
            this.a = 1;
            obj = baseEmailEnterInteractor.sendEmail(sendEmail, email, this);
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
