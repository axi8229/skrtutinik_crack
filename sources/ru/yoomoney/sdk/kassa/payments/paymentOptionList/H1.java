package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u;

/* loaded from: classes5.dex */
public final class H1 extends ContinuationImpl {
    public I1 a;
    public String b;
    public AbstractC2336u c;
    public List d;
    public /* synthetic */ Object e;
    public final /* synthetic */ I1 f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H1(I1 i1, Continuation continuation) {
        super(continuation);
        this.f = i1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(null, null, this);
    }
}
