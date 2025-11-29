package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class N0 extends SuspendLambda implements Function1 {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.model.T a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N0(ru.yoomoney.sdk.kassa.payments.model.T t, Continuation continuation) {
        super(1, continuation);
        this.a = t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new N0(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new N0(this.a, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return new C2522z(this.a.getId(), null);
    }
}
