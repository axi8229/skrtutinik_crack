package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
public final class Y0 extends ContinuationImpl {
    public Z0 a;
    public String b;
    public ru.yoomoney.sdk.kassa.payments.model.T c;
    public /* synthetic */ Object d;
    public final /* synthetic */ Z0 e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y0(Z0 z0, Continuation continuation) {
        super(continuation);
        this.e = z0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(0, null, this);
    }
}
