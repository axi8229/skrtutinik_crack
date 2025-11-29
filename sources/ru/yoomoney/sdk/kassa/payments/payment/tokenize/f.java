package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.T;

/* loaded from: classes5.dex */
public final class f extends ContinuationImpl {
    public h a;
    public Q b;
    public Amount c;
    public String d;
    public AbstractC2335t e;
    public boolean f;
    public /* synthetic */ Object g;
    public final /* synthetic */ h h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, Continuation continuation) {
        super(continuation);
        this.h = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.h.a((T) null, (Q) null, (Amount) null, false, (String) null, (AbstractC2335t) null, (Continuation) this);
    }
}
