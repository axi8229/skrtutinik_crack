package ru.yoomoney.sdk.auth.select.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.select.SelectAccount;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.select.impl.SelectAccountBusinessLogic$handleContentState$11$1", f = "SelectAccountBusinessLogic.kt", l = {95}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class c extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ SelectAccountBusinessLogic b;
    public final /* synthetic */ SelectAccount.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SelectAccountBusinessLogic selectAccountBusinessLogic, SelectAccount.Action action, Continuation<? super c> continuation) {
        super(1, continuation);
        this.b = selectAccountBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new c(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new c(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            SelectAccount.Effect.ShowEnrollmentStep showEnrollmentStep = new SelectAccount.Effect.ShowEnrollmentStep(((SelectAccount.Action.EnrollmentSuccess) this.c).getEnrollmentProcess());
            this.a = 1;
            if (function2.invoke(showEnrollmentStep, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
