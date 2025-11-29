package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class q extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ r b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, Continuation continuation) {
        super(continuation);
        this.b = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.b(null, this);
    }
}
