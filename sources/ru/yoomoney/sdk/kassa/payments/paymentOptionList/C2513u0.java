package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.kassa.payments.di.module.C2279m;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.u0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2513u0 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ E1 b;
    public final /* synthetic */ BankCardPaymentOption c;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.model.Q d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2513u0(E1 e1, BankCardPaymentOption bankCardPaymentOption, ru.yoomoney.sdk.kassa.payments.model.Q q, Continuation continuation) {
        super(1, continuation);
        this.b = e1;
        this.c = bankCardPaymentOption;
        this.d = q;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2513u0(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C2513u0) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.b;
            G g = new G(new ru.yoomoney.sdk.kassa.payments.payment.tokenize.k(this.c.getId(), false, this.d, false, (AbstractC2335t) ((C2279m) this.b.i).invoke(this.c), null));
            this.a = 1;
            if (function2.invoke(g, this) == coroutine_suspended) {
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
