package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2353i extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ c0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2353i(c0 c0Var, Continuation continuation) {
        super(1, continuation);
        this.b = c0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2353i(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C2353i(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c0 c0Var = this.b;
            d0 d0Var = c0Var.d;
            String str = c0Var.f;
            this.a = 1;
            obj = ((j0) d0Var).a(str, this);
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
