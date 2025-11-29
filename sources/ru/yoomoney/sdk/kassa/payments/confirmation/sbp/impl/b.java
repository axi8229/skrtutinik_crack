package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class b extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ m b;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.confirmation.sbp.a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(m mVar, ru.yoomoney.sdk.kassa.payments.confirmation.sbp.a aVar, Continuation continuation) {
        super(1, continuation);
        this.b = mVar;
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new b(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new b(this.b, this.c, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            s sVar = this.b.d;
            String str = this.c.a;
            this.a = 1;
            obj = ((v) sVar).a(str, this);
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
