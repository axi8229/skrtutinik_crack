package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2416h extends ContinuationImpl {
    public C2428l a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C2428l c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2416h(C2428l c2428l, Continuation continuation) {
        super(continuation);
        this.c = c2428l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((Continuation) this, (Amount) null, false);
    }
}
