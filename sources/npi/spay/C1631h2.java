package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.h2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1631h2 extends AbstractC1855q2 {
    public final ListOfCardsResponseBody.PaymentToolInfo.Tool a;
    public final boolean b;

    public C1631h2(ListOfCardsResponseBody.PaymentToolInfo.Tool tool, boolean z) {
        super(0);
        this.a = tool;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1631h2)) {
            return false;
        }
        C1631h2 c1631h2 = (C1631h2) obj;
        return Intrinsics.areEqual(this.a, c1631h2.a) && this.b == c1631h2.b;
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
        StringBuilder sb = new StringBuilder("OnPerformPayOrderAction(selectedPaymentToolInfo=");
        sb.append(this.a);
        sb.append(", bnplEnabled=");
        return AbstractC1901s.a(sb, this.b, ')');
    }
}
