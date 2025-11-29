package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;

/* loaded from: classes4.dex */
public final class Md extends SuspendLambda implements Function2 {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Td c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Md(Td td, Continuation continuation) {
        super(2, continuation);
        this.c = td;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Md md = new Md(this.c, continuation);
        md.b = obj;
        return md;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Md md = new Md(this.c, (Continuation) obj2);
        md.b = (PaymentPlanBnplResponseBody) obj;
        return md.invokeSuspend(Unit.INSTANCE);
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
            C1824ol c1824ol = this.c.f;
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
