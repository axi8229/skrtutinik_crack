package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.c2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1506c2 extends AbstractC1855q2 {
    public final ListOfCardsResponseBody a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1506c2(ListOfCardsResponseBody listOfCardsResponseBody) {
        super(0);
        Intrinsics.checkNotNullParameter(listOfCardsResponseBody, "listOfCardsResponseBody");
        this.a = listOfCardsResponseBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1506c2) && Intrinsics.areEqual(this.a, ((C1506c2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ListOfCardsResult(listOfCardsResponseBody=" + this.a + ')';
    }
}
