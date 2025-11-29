package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody;

/* loaded from: classes4.dex */
public final class Cm extends ContinuationImpl {
    public Hm a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Hm c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cm(Hm hm, Continuation continuation) {
        super(continuation);
        this.c = hm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((String) null, (PaymentTokenWithOrderIdRequestBody) null, this);
    }
}
