package ru.yoomoney.sdk.auth.phone.confirm.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.PhoneConfirmBusinessLogic$processStateContentAction$8$2", f = "PhoneConfirmBusinessLogic.kt", l = {78}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class k extends SuspendLambda implements Function1<Continuation<? super PhoneConfirm.Action>, Object> {
    public int a;
    public final /* synthetic */ PhoneConfirmBusinessLogic b;
    public final /* synthetic */ PhoneConfirm.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PhoneConfirmBusinessLogic phoneConfirmBusinessLogic, PhoneConfirm.Action action, Continuation<? super k> continuation) {
        super(1, continuation);
        this.b = phoneConfirmBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new k(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PhoneConfirm.Action> continuation) {
        return new k(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BasePhoneConfirmInteractor basePhoneConfirmInteractor = this.b.interactor;
            PhoneConfirm.Action.Forgot forgot = (PhoneConfirm.Action.Forgot) this.c;
            this.a = 1;
            obj = basePhoneConfirmInteractor.confirmPhoneForgot(forgot, this);
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
