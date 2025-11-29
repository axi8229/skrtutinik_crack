package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.w0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2517w0 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ E1 b;
    public final /* synthetic */ BankCardPaymentOption c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2517w0(E1 e1, BankCardPaymentOption bankCardPaymentOption, Continuation continuation) {
        super(1, continuation);
        this.b = e1;
        this.c = bankCardPaymentOption;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2517w0(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C2517w0(this.b, this.c, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.b;
            F f = new F(this.c.getId(), null);
            this.a = 1;
            if (function2.invoke(f, this) == coroutine_suspended) {
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
