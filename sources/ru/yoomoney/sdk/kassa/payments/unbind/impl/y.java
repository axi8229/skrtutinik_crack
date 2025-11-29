package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class y extends ContinuationImpl {
    public z a;
    public /* synthetic */ Object b;
    public final /* synthetic */ z c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(z zVar, Continuation continuation) {
        super(continuation);
        this.c = zVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, this);
    }
}
