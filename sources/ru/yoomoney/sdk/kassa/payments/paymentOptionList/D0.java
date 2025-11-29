package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import java.util.List;
import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;

/* loaded from: classes5.dex */
public final class D0 extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ E1 b;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.model.T c;
    public final /* synthetic */ C2514v d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D0(E1 e1, ru.yoomoney.sdk.kassa.payments.model.T t, C2514v c2514v, Continuation continuation) {
        super(1, continuation);
        this.b = e1;
        this.c = t;
        this.d = c2514v;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new D0(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((D0) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.b;
            List<ru.yoomoney.sdk.kassa.payments.model.Q> paymentInstruments = ((BankCardPaymentOption) this.c).getPaymentInstruments();
            C2514v c2514v = this.d;
            for (ru.yoomoney.sdk.kassa.payments.model.Q q : paymentInstruments) {
                if (Intrinsics.areEqual(q.a, c2514v.b)) {
                    I i2 = new I(q);
                    this.a = 1;
                    if (function2.invoke(i2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }
}
