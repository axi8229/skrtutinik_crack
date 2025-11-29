package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class f0 extends ContinuationImpl {
    public j0 a;
    public String b;
    public /* synthetic */ Object c;
    public final /* synthetic */ j0 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(j0 j0Var, Continuation continuation) {
        super(continuation);
        this.d = j0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((String) null, this);
    }
}
