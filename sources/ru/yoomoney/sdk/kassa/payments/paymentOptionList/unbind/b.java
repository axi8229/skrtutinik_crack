package ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class b extends ContinuationImpl {
    public c a;
    public /* synthetic */ Object b;
    public final /* synthetic */ c c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, Continuation continuation) {
        super(continuation);
        this.c = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, this);
    }
}
