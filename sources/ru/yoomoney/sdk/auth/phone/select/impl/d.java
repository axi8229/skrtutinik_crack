package ru.yoomoney.sdk.auth.phone.select.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.phone.select.PhoneSelect;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectBusinessLogic$handleContentState$3$2", f = "PhoneSelectBusinessLogic.kt", l = {70}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class d extends SuspendLambda implements Function1<Continuation<? super PhoneSelect.Action>, Object> {
    public int a;
    public final /* synthetic */ PhoneSelectBusinessLogic b;
    public final /* synthetic */ PhoneSelect.Action c;
    public final /* synthetic */ PhoneSelect.State.Content d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PhoneSelectBusinessLogic phoneSelectBusinessLogic, PhoneSelect.Action action, PhoneSelect.State.Content content, Continuation<? super d> continuation) {
        super(1, continuation);
        this.b = phoneSelectBusinessLogic;
        this.c = action;
        this.d = content;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new d(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PhoneSelect.Action> continuation) {
        return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PhoneSelectInteractor phoneSelectInteractor = this.b.interactor;
            String processId = ((PhoneSelect.Action.Submit) this.c).getProcessId();
            String id = this.d.getSelected().getId();
            this.a = 1;
            obj = phoneSelectInteractor.setPhone(processId, id, this);
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
