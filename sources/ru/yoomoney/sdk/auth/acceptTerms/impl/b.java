package ru.yoomoney.sdk.auth.acceptTerms.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsBusinessLogic$handleContentState$1$2", f = "AcceptTermsBusinessLogic.kt", l = {49}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class b extends SuspendLambda implements Function1<Continuation<? super AcceptTerms.Action>, Object> {
    public int a;
    public final /* synthetic */ AcceptTermsBusinessLogic b;
    public final /* synthetic */ AcceptTerms.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AcceptTermsBusinessLogic acceptTermsBusinessLogic, AcceptTerms.Action action, Continuation<? super b> continuation) {
        super(1, continuation);
        this.b = acceptTermsBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new b(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AcceptTerms.Action> continuation) {
        return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AcceptTermsInteractor acceptTermsInteractor = this.b.interactor;
            String processId = ((AcceptTerms.Action.Accept) this.c).getProcessId();
            this.a = 1;
            obj = acceptTermsInteractor.acceptTerms(processId, this);
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
