package ru.yoomoney.sdk.auth.phone.select.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.phone.select.PhoneSelect;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectBusinessLogic$handleContentState$2$1", f = "PhoneSelectBusinessLogic.kt", l = {60}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class b extends SuspendLambda implements Function1<Continuation<? super PhoneSelect.Action>, Object> {
    public int a;
    public final /* synthetic */ PhoneSelectBusinessLogic b;
    public final /* synthetic */ PhoneSelect.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PhoneSelectBusinessLogic phoneSelectBusinessLogic, PhoneSelect.Action action, Continuation<? super b> continuation) {
        super(1, continuation);
        this.b = phoneSelectBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new b(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PhoneSelect.Action> continuation) {
        return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PhoneSelectInteractor phoneSelectInteractor = this.b.interactor;
            String processId = ((PhoneSelect.Action.CheckExpiration) this.c).getProcessId();
            OffsetDateTime expireAt = ((PhoneSelect.Action.CheckExpiration) this.c).getExpireAt();
            this.a = 1;
            obj = phoneSelectInteractor.checkExpiration(processId, expireAt, this);
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
