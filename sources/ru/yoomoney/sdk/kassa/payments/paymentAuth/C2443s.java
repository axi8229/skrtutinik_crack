package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2443s extends ContinuationImpl {
    public AbstractC2336u a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C2445t c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2443s(C2445t c2445t, Continuation continuation) {
        super(continuation);
        this.c = c2445t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, this);
    }
}
