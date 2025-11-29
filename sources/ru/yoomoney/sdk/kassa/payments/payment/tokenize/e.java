package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.T;
import ru.yoomoney.sdk.kassa.payments.model.U;

/* loaded from: classes5.dex */
public final class e extends ContinuationImpl {
    public h a;
    public T b;
    public U c;
    public AbstractC2335t d;
    public boolean e;
    public boolean f;
    public /* synthetic */ Object g;
    public final /* synthetic */ h h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, Continuation continuation) {
        super(continuation);
        this.h = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.h.a((Amount) null, (T) null, (U) null, false, false, (AbstractC2335t) null, (Continuation) this);
    }
}
