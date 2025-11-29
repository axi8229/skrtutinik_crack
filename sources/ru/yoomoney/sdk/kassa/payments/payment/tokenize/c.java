package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.T;

/* loaded from: classes5.dex */
public final class c extends ContinuationImpl {
    public d a;
    public /* synthetic */ Object b;
    public final /* synthetic */ d c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, Continuation continuation) {
        super(continuation);
        this.c = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((T) null, (Q) null, (Amount) null, false, (String) null, (AbstractC2335t) null, (Continuation) this);
    }
}
