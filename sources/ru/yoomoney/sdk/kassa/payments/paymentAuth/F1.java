package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class F1 extends ContinuationImpl {
    public G1 a;
    public boolean b;
    public /* synthetic */ Object c;
    public final /* synthetic */ G1 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F1(G1 g1, Continuation continuation) {
        super(continuation);
        this.d = g1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, false, this);
    }
}
