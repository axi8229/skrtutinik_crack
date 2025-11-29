package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.g0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1604g0 {
    public final AbstractC1855q2 a;
    public final ListOfCardsResponseBody.PaymentToolInfo.Tool b;
    public final boolean c;

    public /* synthetic */ C1604g0() {
        this(C1456a2.a, null, false);
    }

    public static C1604g0 a(C1604g0 c1604g0, AbstractC1855q2 state, ListOfCardsResponseBody.PaymentToolInfo.Tool tool, boolean z, int i) {
        if ((i & 1) != 0) {
            state = c1604g0.a;
        }
        if ((i & 2) != 0) {
            tool = c1604g0.b;
        }
        if ((i & 4) != 0) {
            z = c1604g0.c;
        }
        c1604g0.getClass();
        Intrinsics.checkNotNullParameter(state, "state");
        return new C1604g0(state, tool, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1604g0)) {
            return false;
        }
        C1604g0 c1604g0 = (C1604g0) obj;
        return Intrinsics.areEqual(this.a, c1604g0.a) && Intrinsics.areEqual(this.b, c1604g0.b) && this.c == c1604g0.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        ListOfCardsResponseBody.PaymentToolInfo.Tool tool = this.b;
        int iHashCode2 = (iHashCode + (tool == null ? 0 : tool.hashCode())) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Outcome(state=");
        sb.append(this.a);
        sb.append(", selectedCard=");
        sb.append(this.b);
        sb.append(", isError=");
        return AbstractC1901s.a(sb, this.c, ')');
    }

    public C1604g0(AbstractC1855q2 state, ListOfCardsResponseBody.PaymentToolInfo.Tool tool, boolean z) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = state;
        this.b = tool;
        this.c = z;
    }

    public final AbstractC1855q2 a() {
        return this.a;
    }
}
