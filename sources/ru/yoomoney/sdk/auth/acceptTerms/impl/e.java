package ru.yoomoney.sdk.auth.acceptTerms.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsBusinessLogic$handleProgressState$2$1", f = "AcceptTermsBusinessLogic.kt", l = {37}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class e extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ AcceptTermsBusinessLogic b;
    public final /* synthetic */ AcceptTerms.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AcceptTermsBusinessLogic acceptTermsBusinessLogic, AcceptTerms.Action action, Continuation<? super e> continuation) {
        super(1, continuation);
        this.b = acceptTermsBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new e(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new e(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            AcceptTerms.Effect.ShowError showError = new AcceptTerms.Effect.ShowError(((AcceptTerms.Action.Fail) this.c).getFailure());
            this.a = 1;
            if (function2.invoke(showError, this) == coroutine_suspended) {
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
