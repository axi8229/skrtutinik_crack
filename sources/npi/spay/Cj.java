package npi.spay;

import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.bnpl.BnplPayment;
import spay.sdk.domain.model.response.bnpl.GraphBnpl;

/* loaded from: classes4.dex */
public final class Cj extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public Cj(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Cj cj = new Cj(continuation);
        cj.a = obj;
        return cj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Cj cj = new Cj((Continuation) obj2);
        cj.a = (PaymentPlanBnplResponseBody) obj;
        return cj.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GraphBnpl graphBnpl;
        List<BnplPayment> payments;
        Bk bkA;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = (PaymentPlanBnplResponseBody) this.a;
        if (paymentPlanBnplResponseBody == null || (graphBnpl = paymentPlanBnplResponseBody.getGraphBnpl()) == null || (payments = graphBnpl.getPayments()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(payments, 10));
        int i = 0;
        for (Object obj2 : payments) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            BnplPayment bnplPayment = (BnplPayment) obj2;
            if (i == 0) {
                bkA = new C2097zk(R$string.spay_bnpl_graph_first_item_write_off, CollectionsKt.emptyList());
            } else {
                String date = bnplPayment.getDate();
                bkA = AbstractC1854q1.a(date, "text", date);
            }
            arrayList.add(new Jd(bkA, bnplPayment.getAmount(), bnplPayment.getCurrencyCode(), i == 0, i == paymentPlanBnplResponseBody.getGraphBnpl().getPayments().size() - 1));
            i = i2;
        }
        return arrayList;
    }
}
