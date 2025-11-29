package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2489k extends ContinuationImpl {
    public C2495m a;
    public Amount b;
    public AbstractC2336u c;
    public /* synthetic */ Object d;
    public final /* synthetic */ C2495m e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2489k(C2495m c2495m, Continuation continuation) {
        super(continuation);
        this.e = c2495m;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, null, this);
    }
}
