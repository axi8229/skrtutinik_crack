package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class o extends ContinuationImpl {
    public r a;
    public /* synthetic */ Object b;
    public final /* synthetic */ r c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(r rVar, Continuation continuation) {
        super(continuation);
        this.c = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, this);
    }
}
