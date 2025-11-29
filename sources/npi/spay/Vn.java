package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Vn extends co {
    public final Boolean a;
    public final ListOfCardsResponseBody.PaymentToolInfo.Tool b;
    public final Boolean c;

    public Vn(Boolean bool, ListOfCardsResponseBody.PaymentToolInfo.Tool tool, Boolean bool2) {
        super(0);
        this.a = bool;
        this.b = tool;
        this.c = bool2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vn)) {
            return false;
        }
        Vn vn = (Vn) obj;
        return Intrinsics.areEqual(this.a, vn.a) && Intrinsics.areEqual(this.b, vn.b) && Intrinsics.areEqual(this.c, vn.c);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        ListOfCardsResponseBody.PaymentToolInfo.Tool tool = this.b;
        int iHashCode2 = (iHashCode + (tool == null ? 0 : tool.hashCode())) * 31;
        Boolean bool2 = this.c;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final String toString() {
        return "PerformPayOrderAction(isRequestOTPRequired=" + this.a + ", selectedPaymentToolInfo=" + this.b + ", isBnplEnabled=" + this.c + ')';
    }
}
