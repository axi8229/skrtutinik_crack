package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003Ja\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lspay/sdk/domain/model/request/AuthWithOrderIdRequestBody;", "", "redirectUri", "", "authCode", "sessionId", "state", "deviceInfo", "orderId", "merchantLogin", "resourceName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthCode", "()Ljava/lang/String;", "getDeviceInfo", "getMerchantLogin", "getOrderId", "getRedirectUri", "getResourceName", "getSessionId", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthWithOrderIdRequestBody {
    private final String authCode;
    private final String deviceInfo;
    private final String merchantLogin;
    private final String orderId;
    private final String redirectUri;
    private final String resourceName;
    private final String sessionId;
    private final String state;

    public AuthWithOrderIdRequestBody(String str, String str2, String sessionId, String str3, String deviceInfo, String orderId, String str4, String resourceName) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        this.redirectUri = str;
        this.authCode = str2;
        this.sessionId = sessionId;
        this.state = str3;
        this.deviceInfo = deviceInfo;
        this.orderId = orderId;
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
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component8, reason: from getter */
    public final String getResourceName() {
        return this.resourceName;
    }

    public final AuthWithOrderIdRequestBody copy(String redirectUri, String authCode, String sessionId, String state, String deviceInfo, String orderId, String merchantLogin, String resourceName) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        return new AuthWithOrderIdRequestBody(redirectUri, authCode, sessionId, state, deviceInfo, orderId, merchantLogin, resourceName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthWithOrderIdRequestBody)) {
            return false;
        }
        AuthWithOrderIdRequestBody authWithOrderIdRequestBody = (AuthWithOrderIdRequestBody) other;
        return Intrinsics.areEqual(this.redirectUri, authWithOrderIdRequestBody.redirectUri) && Intrinsics.areEqual(this.authCode, authWithOrderIdRequestBody.authCode) && Intrinsics.areEqual(this.sessionId, authWithOrderIdRequestBody.sessionId) && Intrinsics.areEqual(this.state, authWithOrderIdRequestBody.state) && Intrinsics.areEqual(this.deviceInfo, authWithOrderIdRequestBody.deviceInfo) && Intrinsics.areEqual(this.orderId, authWithOrderIdRequestBody.orderId) && Intrinsics.areEqual(this.merchantLogin, authWithOrderIdRequestBody.merchantLogin) && Intrinsics.areEqual(this.resourceName, authWithOrderIdRequestBody.resourceName);
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

    public final String getOrderId() {
        return this.orderId;
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
        int iA2 = AbstractC1553e.a(this.orderId, AbstractC1553e.a(this.deviceInfo, (iA + (str3 == null ? 0 : str3.hashCode())) * 31, 31), 31);
        String str4 = this.merchantLogin;
        return this.resourceName.hashCode() + ((iA2 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthWithOrderIdRequestBody(redirectUri=");
        sb.append(this.redirectUri);
        sb.append(", authCode=");
        sb.append(this.authCode);
        sb.append(", sessionId=");
        sb.append(this.sessionId);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", deviceInfo=");
        sb.append(this.deviceInfo);
        sb.append(", orderId=");
        sb.append(this.orderId);
        sb.append(", merchantLogin=");
        sb.append(this.merchantLogin);
        sb.append(", resourceName=");
        return Q1.a(sb, this.resourceName, ')');
    }

    public /* synthetic */ AuthWithOrderIdRequestBody(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, str5, str6, (i & 64) != 0 ? null : str7, str8);
    }
}
