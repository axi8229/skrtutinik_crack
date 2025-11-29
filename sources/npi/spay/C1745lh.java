package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.ListOfCardsWithPurchaseRequestBody;

/* renamed from: npi.spay.lh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1745lh {
    public final String a;
    public final ListOfCardsWithPurchaseRequestBody b;

    public C1745lh(String authorization, ListOfCardsWithPurchaseRequestBody listOfCardsWithPurchaseRequestBody) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(listOfCardsWithPurchaseRequestBody, "listOfCardsWithPurchaseRequestBody");
        this.a = authorization;
        this.b = listOfCardsWithPurchaseRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1745lh)) {
            return false;
        }
        C1745lh c1745lh = (C1745lh) obj;
        return Intrinsics.areEqual(this.a, c1745lh.a) && Intrinsics.areEqual(this.b, c1745lh.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetListOfCardsWithPurchaseUseCaseRequestParams(authorization=" + this.a + ", listOfCardsWithPurchaseRequestBody=" + this.b + ')';
    }
}
