package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class J extends ContinuationImpl {
    public L a;
    public String b;
    public String c;
    public /* synthetic */ Object d;
    public final /* synthetic */ L e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(L l, Continuation continuation) {
        super(continuation);
        this.e = l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, null, null, this);
    }
}
