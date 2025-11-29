package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class I1 extends ContinuationImpl {
    public J1 a;
    public boolean b;
    public /* synthetic */ Object c;
    public final /* synthetic */ J1 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I1(J1 j1, Continuation continuation) {
        super(continuation);
        this.d = j1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(this, null, false);
    }
}
