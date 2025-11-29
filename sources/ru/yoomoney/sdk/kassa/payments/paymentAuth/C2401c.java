package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2401c extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ C2428l b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2401c(C2428l c2428l, Continuation continuation) {
        super(continuation);
        this.b = c2428l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.a((String) null, this);
    }
}
