package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.data.dto.MerchantDataWithPurchase;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\bHÆ\u0003J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lspay/sdk/domain/model/request/ListOfCardsWithPurchaseRequestBody;", "", "sessionId", "", "merchantLogin", "priorityCardOnly", "", "purchase", "Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;)V", "getMerchantLogin", "()Ljava/lang/String;", "getPriorityCardOnly", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPurchase", "()Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "getSessionId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;)Lspay/sdk/domain/model/request/ListOfCardsWithPurchaseRequestBody;", "equals", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListOfCardsWithPurchaseRequestBody {
    private final String merchantLogin;
    private final Boolean priorityCardOnly;
    private final MerchantDataWithPurchase.Purchase purchase;
    private final String sessionId;

    public ListOfCardsWithPurchaseRequestBody(String sessionId, String str, Boolean bool, MerchantDataWithPurchase.Purchase purchase) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        this.sessionId = sessionId;
        this.merchantLogin = str;
        this.priorityCardOnly = bool;
        this.purchase = purchase;
    }

    public static /* synthetic */ ListOfCardsWithPurchaseRequestBody copy$default(ListOfCardsWithPurchaseRequestBody listOfCardsWithPurchaseRequestBody, String str, String str2, Boolean bool, MerchantDataWithPurchase.Purchase purchase, int i, Object obj) {
        if ((i & 1) != 0) {
            str = listOfCardsWithPurchaseRequestBody.sessionId;
        }
        if ((i & 2) != 0) {
            str2 = listOfCardsWithPurchaseRequestBody.merchantLogin;
        }
        if ((i & 4) != 0) {
            bool = listOfCardsWithPurchaseRequestBody.priorityCardOnly;
        }
        if ((i & 8) != 0) {
            purchase = listOfCardsWithPurchaseRequestBody.purchase;
        }
        return listOfCardsWithPurchaseRequestBody.copy(str, str2, bool, purchase);
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
    public final MerchantDataWithPurchase.Purchase getPurchase() {
        return this.purchase;
    }

    public final ListOfCardsWithPurchaseRequestBody copy(String sessionId, String merchantLogin, Boolean priorityCardOnly, MerchantDataWithPurchase.Purchase purchase) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return new ListOfCardsWithPurchaseRequestBody(sessionId, merchantLogin, priorityCardOnly, purchase);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListOfCardsWithPurchaseRequestBody)) {
            return false;
        }
        ListOfCardsWithPurchaseRequestBody listOfCardsWithPurchaseRequestBody = (ListOfCardsWithPurchaseRequestBody) other;
        return Intrinsics.areEqual(this.sessionId, listOfCardsWithPurchaseRequestBody.sessionId) && Intrinsics.areEqual(this.merchantLogin, listOfCardsWithPurchaseRequestBody.merchantLogin) && Intrinsics.areEqual(this.priorityCardOnly, listOfCardsWithPurchaseRequestBody.priorityCardOnly) && Intrinsics.areEqual(this.purchase, listOfCardsWithPurchaseRequestBody.purchase);
    }

    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public final Boolean getPriorityCardOnly() {
        return this.priorityCardOnly;
    }

    public final MerchantDataWithPurchase.Purchase getPurchase() {
        return this.purchase;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        int iHashCode = this.sessionId.hashCode() * 31;
        String str = this.merchantLogin;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.priorityCardOnly;
        return this.purchase.hashCode() + ((iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "ListOfCardsWithPurchaseRequestBody(sessionId=" + this.sessionId + ", merchantLogin=" + this.merchantLogin + ", priorityCardOnly=" + this.priorityCardOnly + ", purchase=" + this.purchase + ')';
    }

    public /* synthetic */ ListOfCardsWithPurchaseRequestBody(String str, String str2, Boolean bool, MerchantDataWithPurchase.Purchase purchase, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, purchase);
    }
}
