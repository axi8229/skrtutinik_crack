package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.domain.model.request.PaymentBnplPlanRequestBody;

/* renamed from: npi.spay.wm, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2024wm extends ContinuationImpl {
    public Hm a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Hm c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2024wm(Hm hm, Continuation continuation) {
        super(continuation);
        this.c = hm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((String) null, (PaymentBnplPlanRequestBody) null, this);
    }
}
