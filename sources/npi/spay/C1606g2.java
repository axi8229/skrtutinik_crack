package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.g2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1606g2 extends AbstractC1855q2 {
    public final ListOfCardsResponseBody.PaymentToolInfo.Tool a;
    public final boolean b;

    public C1606g2(ListOfCardsResponseBody.PaymentToolInfo.Tool tool, boolean z) {
        super(0);
        this.a = tool;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1606g2)) {
            return false;
        }
        C1606g2 c1606g2 = (C1606g2) obj;
        return Intrinsics.areEqual(this.a, c1606g2.a) && this.b == c1606g2.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        ListOfCardsResponseBody.PaymentToolInfo.Tool tool = this.a;
        int iHashCode = (tool == null ? 0 : tool.hashCode()) * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OnPayOnlineAction(selectedPaymentToolInfo=");
        sb.append(this.a);
        sb.append(", isBnplEnabled=");
        return AbstractC1901s.a(sb, this.b, ')');
    }
}
