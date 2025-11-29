package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class X0 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ E1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X0(E1 e1, Continuation continuation) {
        super(1, continuation);
        this.b = e1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new X0(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new X0(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ru.yoomoney.sdk.kassa.payments.logout.c cVar = this.b.g;
            this.a = 1;
            if (((ru.yoomoney.sdk.kassa.payments.logout.d) cVar).a() == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return C2512u.a;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return (C) obj;
            }
            ResultKt.throwOnFailure(obj);
        }
        if (this.b.e.getPaymentMethodTypes().size() == 1) {
            Function2 function2 = this.b.b;
            D d = D.a;
            this.a = 2;
            if (function2.invoke(d, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return C2512u.a;
        }
        E1 e1 = this.b;
        F1 f1 = e1.d;
        Amount amount = e1.e.getAmount();
        this.a = 3;
        obj = ((I1) f1).a(amount, null, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return (C) obj;
    }
}
