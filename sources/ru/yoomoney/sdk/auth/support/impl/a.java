package ru.yoomoney.sdk.auth.support.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.auth.support.TechnicalSupport;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.support.impl.TechnicalSupportBusinessLogic$handleContentState$1$1", f = "TechnicalSupportBusinessLogic.kt", l = {29}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class a extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ TechnicalSupportBusinessLogic b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TechnicalSupportBusinessLogic technicalSupportBusinessLogic, Continuation<? super a> continuation) {
        super(1, continuation);
        this.b = technicalSupportBusinessLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new a(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new a(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.showEffect;
            TechnicalSupport.Effect.CallPhone callPhone = TechnicalSupport.Effect.CallPhone.INSTANCE;
            this.a = 1;
            if (function2.invoke(callPhone, this) == coroutine_suspended) {
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
