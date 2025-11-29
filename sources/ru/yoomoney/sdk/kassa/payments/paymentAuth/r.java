package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u;

/* loaded from: classes5.dex */
public final class r extends ContinuationImpl {
    public AbstractC2336u a;
    public String b;
    public /* synthetic */ Object c;
    public final /* synthetic */ C2445t d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C2445t c2445t, Continuation continuation) {
        super(continuation);
        this.d = c2445t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, null, this);
    }
}
