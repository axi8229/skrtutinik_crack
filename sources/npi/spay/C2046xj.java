package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;

/* renamed from: npi.spay.xj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2046xj extends SuspendLambda implements Function2 {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Jj c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2046xj(Jj jj, Continuation continuation) {
        super(2, continuation);
        this.c = jj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2046xj c2046xj = new C2046xj(this.c, continuation);
        c2046xj.b = obj;
        return c2046xj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C2046xj c2046xj = new C2046xj(this.c, (Continuation) obj2);
        c2046xj.b = (PaymentPlanBnplResponseBody) obj;
        return c2046xj.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String offerText;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            B4 b4 = (B4) this.b;
            ResultKt.throwOnFailure(obj);
            return b4;
        }
        ResultKt.throwOnFailure(obj);
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = (PaymentPlanBnplResponseBody) this.b;
        B4 b4E = (paymentPlanBnplResponseBody == null || (offerText = paymentPlanBnplResponseBody.getOfferText()) == null) ? null : AbstractC1946tj.e(offerText);
        if (b4E != null) {
            C1824ol c1824ol = this.c.h;
            C1551dm c1551dm = new C1551dm(b4E.b);
            this.b = b4E;
            this.a = 1;
            Dispatchers.getIO();
            c1824ol.getClass();
            if (c1824ol.a(c1551dm, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return b4E;
    }
}
