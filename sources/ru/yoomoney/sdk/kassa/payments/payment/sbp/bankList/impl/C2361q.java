package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import android.content.pm.PackageManager;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2361q extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ c0 b;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2361q(c0 c0Var, ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v vVar, Continuation continuation) {
        super(1, continuation);
        this.b = c0Var;
        this.c = vVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2361q(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C2361q(this.b, this.c, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PackageManager.NameNotFoundException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            d0 d0Var = this.b.d;
            List list = this.c.a;
            this.a = 1;
            obj = ((j0) d0Var).a(list, this);
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
