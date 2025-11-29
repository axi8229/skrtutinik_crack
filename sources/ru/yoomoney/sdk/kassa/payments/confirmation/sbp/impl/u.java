package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class u extends ContinuationImpl {
    public String a;
    public /* synthetic */ Object b;
    public final /* synthetic */ v c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, Continuation continuation) {
        super(continuation);
        this.c = vVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, null, this);
    }
}
