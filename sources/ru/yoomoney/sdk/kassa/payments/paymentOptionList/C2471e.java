package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2471e extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ C2474f b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2471e(C2474f c2474f, Continuation continuation) {
        super(continuation);
        this.b = c2474f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.a(this);
    }
}
