package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001b"}, d2 = {"Lspay/sdk/domain/model/request/ListOfCardsWithOrderIdRequestBody;", "", "sessionId", "", "merchantLogin", "priorityCardOnly", "", "orderId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getMerchantLogin", "()Ljava/lang/String;", "getOrderId", "getPriorityCardOnly", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSessionId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lspay/sdk/domain/model/request/ListOfCardsWithOrderIdRequestBody;", "equals", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListOfCardsWithOrderIdRequestBody {
    private final String merchantLogin;
    private final String orderId;
    private final Boolean priorityCardOnly;
    private final String sessionId;

    public ListOfCardsWithOrderIdRequestBody(String sessionId, String str, Boolean bool, String orderId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        this.sessionId = sessionId;
        this.merchantLogin = str;
        this.priorityCardOnly = bool;
        this.orderId = orderId;
    }

    public static /* synthetic */ ListOfCardsWithOrderIdRequestBody copy$default(ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody, String str, String str2, Boolean bool, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = listOfCardsWithOrderIdRequestBody.sessionId;
        }
        if ((i & 2) != 0) {
            str2 = listOfCardsWithOrderIdRequestBody.merchantLogin;
        }
        if ((i & 4) != 0) {
            bool = listOfCardsWithOrderIdRequestBody.priorityCardOnly;
        }
        if ((i & 8) != 0) {
            str3 = listOfCardsWithOrderIdRequestBody.orderId;
        }
        return listOfCardsWithOrderIdRequestBody.copy(str, str2, bool, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getPriorityCardOnly() {
        return this.priorityCardOnly;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    public final ListOfCardsWithOrderIdRequestBody copy(String sessionId, String merchantLogin, Boolean priorityCardOnly, String orderId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        return new ListOfCardsWithOrderIdRequestBody(sessionId, merchantLogin, priorityCardOnly, orderId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListOfCardsWithOrderIdRequestBody)) {
            return false;
        }
        ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody = (ListOfCardsWithOrderIdRequestBody) other;
        return Intrinsics.areEqual(this.sessionId, listOfCardsWithOrderIdRequestBody.sessionId) && Intrinsics.areEqual(this.merchantLogin, listOfCardsWithOrderIdRequestBody.merchantLogin) && Intrinsics.areEqual(this.priorityCardOnly, listOfCardsWithOrderIdRequestBody.priorityCardOnly) && Intrinsics.areEqual(this.orderId, listOfCardsWithOrderIdRequestBody.orderId);
    }

    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final Boolean getPriorityCardOnly() {
        return this.priorityCardOnly;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        int iHashCode = this.sessionId.hashCode() * 31;
        String str = this.merchantLogin;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.priorityCardOnly;
        return this.orderId.hashCode() + ((iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListOfCardsWithOrderIdRequestBody(sessionId=");
        sb.append(this.sessionId);
        sb.append(", merchantLogin=");
        sb.append(this.merchantLogin);
        sb.append(", priorityCardOnly=");
        sb.append(this.priorityCardOnly);
        sb.append(", orderId=");
        return Q1.a(sb, this.orderId, ')');
    }

    public /* synthetic */ ListOfCardsWithOrderIdRequestBody(String str, String str2, Boolean bool, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, str3);
    }
}
