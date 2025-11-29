package ru.yoomoney.sdk.kassa.payments.paymentMethodInfo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class c extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ d b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, Continuation continuation) {
        super(continuation);
        this.b = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.a(null, this);
    }
}
