package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody;

/* loaded from: classes4.dex */
public final class Fm extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ Hm b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fm(Hm hm, Continuation continuation) {
        super(continuation);
        this.b = hm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.b((String) null, (PaymentTokenWithOrderIdRequestBody) null, this);
    }
}
