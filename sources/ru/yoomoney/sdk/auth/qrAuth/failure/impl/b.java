package ru.yoomoney.sdk.auth.qrAuth.failure.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.qrAuth.failure.QrAuthFailureContract;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.qrAuth.failure.impl.QrAuthFailureBusinessLogic$handleContentState$2$1", f = "QrAuthFailureBusinessLogic.kt", l = {33}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class b extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ QrAuthFailureBusinessLogic b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(QrAuthFailureBusinessLogic qrAuthFailureBusinessLogic, Continuation<? super b> continuation) {
        super(1, continuation);
        this.b = qrAuthFailureBusinessLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new b(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new b(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            QrAuthFailureContract.Effect.ShowScanScreen showScanScreen = QrAuthFailureContract.Effect.ShowScanScreen.INSTANCE;
            this.a = 1;
            if (function2.invoke(showScanScreen, this) == coroutine_suspended) {
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
