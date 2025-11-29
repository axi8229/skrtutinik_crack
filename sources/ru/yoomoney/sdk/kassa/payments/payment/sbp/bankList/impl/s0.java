package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import android.content.pm.PackageManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class s0 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ w0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(w0 w0Var, Continuation continuation) {
        super(1, continuation);
        this.b = w0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new s0(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new s0(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PackageManager.NameNotFoundException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            w0 w0Var = this.b;
            d0 d0Var = w0Var.b;
            String str = w0Var.c.a;
            this.a = 1;
            obj = ((j0) d0Var).b(str, this);
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
