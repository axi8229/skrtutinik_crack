package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.model.j0;

/* loaded from: classes5.dex */
public final class K extends ContinuationImpl {
    public L a;
    public String b;
    public String c;
    public j0 d;
    public /* synthetic */ Object e;
    public final /* synthetic */ L f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(L l, Continuation continuation) {
        super(continuation);
        this.f = l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(null, null, this);
    }
}
