package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.a1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2461a1 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ E1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2461a1(E1 e1, Continuation continuation) {
        super(1, continuation);
        this.b = e1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2461a1(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C2461a1(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            E1 e1 = this.b;
            F1 f1 = e1.d;
            Amount amount = e1.e.getAmount();
            String str = this.b.f;
            this.a = 1;
            obj = ((I1) f1).a(amount, str, this);
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
