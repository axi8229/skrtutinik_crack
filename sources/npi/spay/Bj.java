package npi.spay;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import spay.sdk.domain.model.response.OrderScreenDataResponse;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.bnpl.BnplPayment;
import spay.sdk.domain.model.response.bnpl.GraphBnpl;

/* loaded from: classes4.dex */
public final class Bj extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ Ih b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bj(Ih ih, Continuation continuation) {
        super(2, continuation);
        this.b = ih;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Bj bj = new Bj(this.b, continuation);
        bj.a = obj;
        return bj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Bj bj = new Bj(this.b, (Continuation) obj2);
        bj.a = (OrderScreenDataResponse) obj;
        return bj.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GraphBnpl graphBnpl;
        List<BnplPayment> payments;
        BnplPayment bnplPayment;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        OrderScreenDataResponse orderScreenDataResponse = (OrderScreenDataResponse) this.a;
        Long lBoxLong = null;
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = orderScreenDataResponse != null ? orderScreenDataResponse.getPaymentPlanBnplResponseBody() : null;
        Ih ih = this.b;
        if (paymentPlanBnplResponseBody != null && (graphBnpl = paymentPlanBnplResponseBody.getGraphBnpl()) != null && (payments = graphBnpl.getPayments()) != null && (bnplPayment = (BnplPayment) CollectionsKt.firstOrNull((List) payments)) != null) {
            lBoxLong = Boxing.boxLong(bnplPayment.getAmount());
        }
        ((Di) ih).o.setValue(lBoxLong);
        return paymentPlanBnplResponseBody;
    }
}
