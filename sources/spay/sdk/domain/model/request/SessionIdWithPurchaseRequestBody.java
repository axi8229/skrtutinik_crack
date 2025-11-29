package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.data.dto.MerchantDataWithPurchase;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lspay/sdk/domain/model/request/SessionIdWithPurchaseRequestBody;", "", "redirectUri", "", "merchantLogin", "purchase", "Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "(Ljava/lang/String;Ljava/lang/String;Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;)V", "getMerchantLogin", "()Ljava/lang/String;", "getPurchase", "()Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "getRedirectUri", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionIdWithPurchaseRequestBody {
    private final String merchantLogin;
    private final MerchantDataWithPurchase.Purchase purchase;
    private final String redirectUri;

    public SessionIdWithPurchaseRequestBody(String redirectUri, String str, MerchantDataWithPurchase.Purchase purchase) {
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        this.redirectUri = redirectUri;
        this.merchantLogin = str;
        this.purchase = purchase;
    }

    public static /* synthetic */ SessionIdWithPurchaseRequestBody copy$default(SessionIdWithPurchaseRequestBody sessionIdWithPurchaseRequestBody, String str, String str2, MerchantDataWithPurchase.Purchase purchase, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sessionIdWithPurchaseRequestBody.redirectUri;
        }
        if ((i & 2) != 0) {
            str2 = sessionIdWithPurchaseRequestBody.merchantLogin;
        }
        if ((i & 4) != 0) {
            purchase = sessionIdWithPurchaseRequestBody.purchase;
        }
        return sessionIdWithPurchaseRequestBody.copy(str, str2, purchase);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRedirectUri() {
        return this.redirectUri;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component3, reason: from getter */
    public final MerchantDataWithPurchase.Purchase getPurchase() {
        return this.purchase;
    }

    public final SessionIdWithPurchaseRequestBody copy(String redirectUri, String merchantLogin, MerchantDataWithPurchase.Purchase purchase) {
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return new SessionIdWithPurchaseRequestBody(redirectUri, merchantLogin, purchase);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionIdWithPurchaseRequestBody)) {
            return false;
        }
        SessionIdWithPurchaseRequestBody sessionIdWithPurchaseRequestBody = (SessionIdWithPurchaseRequestBody) other;
        return Intrinsics.areEqual(this.redirectUri, sessionIdWithPurchaseRequestBody.redirectUri) && Intrinsics.areEqual(this.merchantLogin, sessionIdWithPurchaseRequestBody.merchantLogin) && Intrinsics.areEqual(this.purchase, sessionIdWithPurchaseRequestBody.purchase);
    }

    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public final MerchantDataWithPurchase.Purchase getPurchase() {
        return this.purchase;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public int hashCode() {
        int iHashCode = this.redirectUri.hashCode() * 31;
        String str = this.merchantLogin;
        return this.purchase.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public String toString() {
        return "SessionIdWithPurchaseRequestBody(redirectUri=" + this.redirectUri + ", merchantLogin=" + this.merchantLogin + ", purchase=" + this.purchase + ')';
    }

    public /* synthetic */ SessionIdWithPurchaseRequestBody(String str, String str2, MerchantDataWithPurchase.Purchase purchase, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, purchase);
    }
}
