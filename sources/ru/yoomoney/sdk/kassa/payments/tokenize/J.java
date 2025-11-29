package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.model.T;

/* loaded from: classes5.dex */
public final class J extends ContinuationImpl {
    public K a;
    public ru.yoomoney.sdk.kassa.payments.payment.tokenize.i b;
    public T c;
    public /* synthetic */ Object d;
    public final /* synthetic */ K e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(K k, Continuation continuation) {
        super(continuation);
        this.e = k;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, this);
    }
}
