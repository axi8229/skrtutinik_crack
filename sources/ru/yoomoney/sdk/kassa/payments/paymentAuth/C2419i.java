package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2419i extends ContinuationImpl {
    public C2428l a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C2428l c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2419i(C2428l c2428l, Continuation continuation) {
        super(continuation);
        this.c = c2428l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((C2434n) null, this);
    }
}
