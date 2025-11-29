package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
public final class f extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ m b;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(m mVar, ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e eVar, Continuation continuation) {
        super(1, continuation);
        this.b = mVar;
        this.c = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new f(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new f(this.b, this.c, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.b;
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e eVar = this.c;
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.g gVar = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.g(eVar.a, eVar.b);
            this.a = 1;
            if (function2.invoke(gVar, this) == coroutine_suspended) {
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
