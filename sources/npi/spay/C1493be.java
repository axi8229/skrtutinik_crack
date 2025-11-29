package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody;

/* renamed from: npi.spay.be, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1493be {
    public final String a;
    public final ListOfCardsWithOrderIdRequestBody b;

    public C1493be(String authorization, ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(listOfCardsWithOrderIdRequestBody, "listOfCardsWithOrderIdRequestBody");
        this.a = authorization;
        this.b = listOfCardsWithOrderIdRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1493be)) {
            return false;
        }
        C1493be c1493be = (C1493be) obj;
        return Intrinsics.areEqual(this.a, c1493be.a) && Intrinsics.areEqual(this.b, c1493be.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetListOfCardsWithOrderIdUseCaseRequestParams(authorization=" + this.a + ", listOfCardsWithOrderIdRequestBody=" + this.b + ')';
    }
}
