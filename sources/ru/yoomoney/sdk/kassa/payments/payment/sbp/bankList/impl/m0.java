package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import android.content.Context;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class m0 extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ p0 b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(p0 p0Var, Continuation continuation) {
        super(continuation);
        this.b = p0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        Object objA = this.b.a((Context) null, this);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m2627boximpl(objA);
    }
}
