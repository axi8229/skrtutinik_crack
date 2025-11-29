package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2462b extends ContinuationImpl {
    public C2465c a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C2465c c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2462b(C2465c c2465c, Continuation continuation) {
        super(continuation);
        this.c = c2465c;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, null, this);
    }
}
