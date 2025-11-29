package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody;
import spay.sdk.domain.model.request.ListOfCardsWithPurchaseRequestBody;
import spay.sdk.domain.model.request.PaymentBnplPlanRequestBody;

/* loaded from: classes4.dex */
public final class Uk {
    public final ListOfCardsWithOrderIdRequestBody a;
    public final PaymentBnplPlanRequestBody b;
    public final String c;

    public Uk(ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody, ListOfCardsWithPurchaseRequestBody listOfCardsWithPurchaseRequestBody, PaymentBnplPlanRequestBody paymentBnplPlanRequestBody, String authorization) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        this.a = listOfCardsWithOrderIdRequestBody;
        this.b = paymentBnplPlanRequestBody;
        this.c = authorization;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uk)) {
            return false;
        }
        Uk uk = (Uk) obj;
        return Intrinsics.areEqual(this.a, uk.a) && Intrinsics.areEqual(null, null) && Intrinsics.areEqual(this.b, uk.b) && Intrinsics.areEqual(this.c, uk.c);
    }

    public final int hashCode() {
        ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody = this.a;
        int iHashCode = (listOfCardsWithOrderIdRequestBody == null ? 0 : listOfCardsWithOrderIdRequestBody.hashCode()) * 961;
        PaymentBnplPlanRequestBody paymentBnplPlanRequestBody = this.b;
        return this.c.hashCode() + ((iHashCode + (paymentBnplPlanRequestBody != null ? paymentBnplPlanRequestBody.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OrderScreenInteractorRequestParams(listOfCardsWithOrderIdRequestBody=");
        sb.append(this.a);
        sb.append(", listOfCardsWithPurchaseRequestBody=null, paymentPlanBnplRequestBody=");
        sb.append(this.b);
        sb.append(", authorization=");
        return Q1.a(sb, this.c, ')');
    }
}
