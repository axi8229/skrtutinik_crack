package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.AuthWithOrderIdRequestBody;
import spay.sdk.domain.model.request.AuthWithPurchaseRequestBody;
import spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody;
import spay.sdk.domain.model.request.ListOfCardsWithPurchaseRequestBody;

/* loaded from: classes4.dex */
public final class N8 {
    public final String a;
    public final C2085z8 b;
    public final ListOfCardsWithOrderIdRequestBody c;
    public final ListOfCardsWithPurchaseRequestBody d;
    public final AuthWithOrderIdRequestBody e;
    public final AuthWithPurchaseRequestBody f;

    public N8(String authorization, C2085z8 cardSelectionData, ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody, ListOfCardsWithPurchaseRequestBody listOfCardsWithPurchaseRequestBody, AuthWithOrderIdRequestBody authWithOrderIdRequestBody, AuthWithPurchaseRequestBody authWithPurchaseRequestBody) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(cardSelectionData, "cardSelectionData");
        this.a = authorization;
        this.b = cardSelectionData;
        this.c = listOfCardsWithOrderIdRequestBody;
        this.d = listOfCardsWithPurchaseRequestBody;
        this.e = authWithOrderIdRequestBody;
        this.f = authWithPurchaseRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N8)) {
            return false;
        }
        N8 n8 = (N8) obj;
        return Intrinsics.areEqual(this.a, n8.a) && Intrinsics.areEqual(this.b, n8.b) && Intrinsics.areEqual(this.c, n8.c) && Intrinsics.areEqual(this.d, n8.d) && Intrinsics.areEqual(this.e, n8.e) && Intrinsics.areEqual(this.f, n8.f);
    }

    public final int hashCode() {
        int iHashCode = (this.b.a.hashCode() + (this.a.hashCode() * 31)) * 31;
        ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody = this.c;
        int iHashCode2 = (iHashCode + (listOfCardsWithOrderIdRequestBody == null ? 0 : listOfCardsWithOrderIdRequestBody.hashCode())) * 31;
        ListOfCardsWithPurchaseRequestBody listOfCardsWithPurchaseRequestBody = this.d;
        int iHashCode3 = (iHashCode2 + (listOfCardsWithPurchaseRequestBody == null ? 0 : listOfCardsWithPurchaseRequestBody.hashCode())) * 31;
        AuthWithOrderIdRequestBody authWithOrderIdRequestBody = this.e;
        int iHashCode4 = (iHashCode3 + (authWithOrderIdRequestBody == null ? 0 : authWithOrderIdRequestBody.hashCode())) * 31;
        AuthWithPurchaseRequestBody authWithPurchaseRequestBody = this.f;
        return iHashCode4 + (authWithPurchaseRequestBody != null ? authWithPurchaseRequestBody.hashCode() : 0);
    }

    public final String toString() {
        return "GetFullEmissionUseCaseRequestParams(authorization=" + this.a + ", cardSelectionData=" + this.b + ", listOfCardsWithOrderIdRequestBody=" + this.c + ", listOfCardsWithPurchaseRequestBody=" + this.d + ", authWithOrderIdRequestBody=" + this.e + ", authWithPurchaseRequestBody=" + this.f + ')';
    }
}
