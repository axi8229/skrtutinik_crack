package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2477g extends ContinuationImpl {
    public C2480h a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C2480h c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2477g(C2480h c2480h, Continuation continuation) {
        super(continuation);
        this.c = c2480h;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, null, this);
    }
}
