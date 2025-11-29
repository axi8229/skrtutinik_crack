package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;
import spay.sdk.data.dto.MerchantDataWithPurchase;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003Ja\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006&"}, d2 = {"Lspay/sdk/domain/model/request/AuthWithPurchaseRequestBody;", "", "redirectUri", "", "authCode", "sessionId", "state", "deviceInfo", "purchase", "Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "merchantLogin", "resourceName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;Ljava/lang/String;Ljava/lang/String;)V", "getAuthCode", "()Ljava/lang/String;", "getDeviceInfo", "getMerchantLogin", "getPurchase", "()Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "getRedirectUri", "getResourceName", "getSessionId", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthWithPurchaseRequestBody {
    private final String authCode;
    private final String deviceInfo;
    private final String merchantLogin;
    private final MerchantDataWithPurchase.Purchase purchase;
    private final String redirectUri;
    private final String resourceName;
    private final String sessionId;
    private final String state;

    public AuthWithPurchaseRequestBody(String str, String str2, String sessionId, String str3, String deviceInfo, MerchantDataWithPurchase.Purchase purchase, String str4, String resourceName) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        this.redirectUri = str;
        this.authCode = str2;
        this.sessionId = sessionId;
        this.state = str3;
        this.deviceInfo = deviceInfo;
        this.purchase = purchase;
        this.merchantLogin = str4;
        this.resourceName = resourceName;
    }

    /* renamed from: component1, reason: from getter */
    public final String getRedirectUri() {
        return this.redirectUri;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthCode() {
        return this.authCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDeviceInfo() {
        return this.deviceInfo;
    }

    /* renamed from: component6, reason: from getter */
    public final MerchantDataWithPurchase.Purchase getPurchase() {
        return this.purchase;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component8, reason: from getter */
    public final String getResourceName() {
        return this.resourceName;
    }

    public final AuthWithPurchaseRequestBody copy(String redirectUri, String authCode, String sessionId, String state, String deviceInfo, MerchantDataWithPurchase.Purchase purchase, String merchantLogin, String resourceName) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        return new AuthWithPurchaseRequestBody(redirectUri, authCode, sessionId, state, deviceInfo, purchase, merchantLogin, resourceName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthWithPurchaseRequestBody)) {
            return false;
        }
        AuthWithPurchaseRequestBody authWithPurchaseRequestBody = (AuthWithPurchaseRequestBody) other;
        return Intrinsics.areEqual(this.redirectUri, authWithPurchaseRequestBody.redirectUri) && Intrinsics.areEqual(this.authCode, authWithPurchaseRequestBody.authCode) && Intrinsics.areEqual(this.sessionId, authWithPurchaseRequestBody.sessionId) && Intrinsics.areEqual(this.state, authWithPurchaseRequestBody.state) && Intrinsics.areEqual(this.deviceInfo, authWithPurchaseRequestBody.deviceInfo) && Intrinsics.areEqual(this.purchase, authWithPurchaseRequestBody.purchase) && Intrinsics.areEqual(this.merchantLogin, authWithPurchaseRequestBody.merchantLogin) && Intrinsics.areEqual(this.resourceName, authWithPurchaseRequestBody.resourceName);
    }

    public final String getAuthCode() {
        return this.authCode;
    }

    public final String getDeviceInfo() {
        return this.deviceInfo;
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

    public final String getResourceName() {
        return this.resourceName;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        String str = this.redirectUri;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.authCode;
        int iA = AbstractC1553e.a(this.sessionId, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
        String str3 = this.state;
        int iHashCode2 = (this.purchase.hashCode() + AbstractC1553e.a(this.deviceInfo, (iA + (str3 == null ? 0 : str3.hashCode())) * 31, 31)) * 31;
        String str4 = this.merchantLogin;
        return this.resourceName.hashCode() + ((iHashCode2 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthWithPurchaseRequestBody(redirectUri=");
        sb.append(this.redirectUri);
        sb.append(", authCode=");
        sb.append(this.authCode);
        sb.append(", sessionId=");
        sb.append(this.sessionId);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", deviceInfo=");
        sb.append(this.deviceInfo);
        sb.append(", purchase=");
        sb.append(this.purchase);
        sb.append(", merchantLogin=");
        sb.append(this.merchantLogin);
        sb.append(", resourceName=");
        return Q1.a(sb, this.resourceName, ')');
    }

    public /* synthetic */ AuthWithPurchaseRequestBody(String str, String str2, String str3, String str4, String str5, MerchantDataWithPurchase.Purchase purchase, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, str5, purchase, (i & 64) != 0 ? null : str6, str7);
    }
}
