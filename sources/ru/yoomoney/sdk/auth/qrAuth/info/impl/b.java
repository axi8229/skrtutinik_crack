package ru.yoomoney.sdk.auth.qrAuth.info.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoBusinessLogic$handStateContent$1$2", f = "QrAuthInfoBusinessLogic.kt", l = {70}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class b extends SuspendLambda implements Function1<Continuation<? super QrAuthInfo.Action>, Object> {
    public int a;
    public final /* synthetic */ QrAuthInfoBusinessLogic b;
    public final /* synthetic */ QrAuthInfo.Action c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(QrAuthInfoBusinessLogic qrAuthInfoBusinessLogic, QrAuthInfo.Action action, Continuation<? super b> continuation) {
        super(1, continuation);
        this.b = qrAuthInfoBusinessLogic;
        this.c = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new b(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super QrAuthInfo.Action> continuation) {
        return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            QrAuthInfoInteractor qrAuthInfoInteractor = this.b.interactor;
            String processId = ((QrAuthInfo.Action.Accept) this.c).getProcessId();
            this.a = 1;
            obj = qrAuthInfoInteractor.accept(processId, this);
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
