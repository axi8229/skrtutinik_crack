package ru.yoomoney.sdk.auth.email.confirm.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.EmailConfirmBusinessLogic$handleProgressState$3$2", f = "EmailConfirmBusinessLogic.kt", l = {217}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class p extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
    public int a;
    public final /* synthetic */ EmailConfirmBusinessLogic b;
    public final /* synthetic */ EmailConfirm.State.Progress c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(EmailConfirmBusinessLogic emailConfirmBusinessLogic, EmailConfirm.State.Progress progress, Continuation<? super p> continuation) {
        super(1, continuation);
        this.b = emailConfirmBusinessLogic;
        this.c = progress;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new p(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
        return new p(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BaseEmailConfirmInteractor baseEmailConfirmInteractor = this.b.interactor;
            String code = this.c.getCode();
            int secretLength = this.c.getSecretLength();
            this.a = 1;
            obj = baseEmailConfirmInteractor.validateCode(code, secretLength, this);
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
