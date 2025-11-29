package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2410f extends ContinuationImpl {
    public C2428l a;
    public String b;
    public /* synthetic */ Object c;
    public final /* synthetic */ C2428l d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2410f(C2428l c2428l, Continuation continuation) {
        super(continuation);
        this.d = c2428l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((AbstractC2336u) null, (String) null, this);
    }
}
