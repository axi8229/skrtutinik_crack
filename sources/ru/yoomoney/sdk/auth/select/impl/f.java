package ru.yoomoney.sdk.auth.select.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.select.SelectAccount;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.select.impl.SelectAccountBusinessLogic$handleContentState$4$1", f = "SelectAccountBusinessLogic.kt", l = {52}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class f extends SuspendLambda implements Function1<Continuation<? super SelectAccount.Action>, Object> {
    public int a;
    public final /* synthetic */ SelectAccountBusinessLogic b;
    public final /* synthetic */ SelectAccount.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(SelectAccountBusinessLogic selectAccountBusinessLogic, SelectAccount.Action action, Continuation<? super f> continuation) {
        super(1, continuation);
        this.b = selectAccountBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new f(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super SelectAccount.Action> continuation) {
        return new f(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SelectAccountInteractor selectAccountInteractor = this.b.interactor;
            String processId = ((SelectAccount.Action.SelectAccount) this.c).getProcessId();
            OffsetDateTime expireAt = ((SelectAccount.Action.SelectAccount) this.c).getExpireAt();
            String uid = ((SelectAccount.Action.SelectAccount) this.c).getUid();
            ProcessType processType = ((SelectAccount.Action.SelectAccount) this.c).getProcessType();
            this.a = 1;
            obj = selectAccountInteractor.checkExpiration(processId, expireAt, uid, processType, this);
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
