package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.T;

/* loaded from: classes5.dex */
public final class g extends ContinuationImpl {
    public h a;
    public Amount b;
    public AbstractC2335t c;
    public String d;
    public boolean e;
    public /* synthetic */ Object f;
    public final /* synthetic */ h g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, Continuation continuation) {
        super(continuation);
        this.g = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.a((Amount) null, (T) null, false, (AbstractC2335t) null, (String) null, (String) null, (Continuation) this);
    }
}
