package ru.yoomoney.sdk.kassa.payments.paymentMethodInfo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class e extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ f b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Continuation continuation) {
        super(continuation);
        this.b = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.a(null, this);
    }
}
