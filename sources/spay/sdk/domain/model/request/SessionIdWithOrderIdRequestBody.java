package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lspay/sdk/domain/model/request/SessionIdWithOrderIdRequestBody;", "", "redirectUri", "", "merchantLogin", "orderId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMerchantLogin", "()Ljava/lang/String;", "getOrderId", "getRedirectUri", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionIdWithOrderIdRequestBody {
    private final String merchantLogin;
    private final String orderId;
    private final String redirectUri;

    public SessionIdWithOrderIdRequestBody(String redirectUri, String str, String orderId) {
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        this.redirectUri = redirectUri;
        this.merchantLogin = str;
        this.orderId = orderId;
    }

    public static /* synthetic */ SessionIdWithOrderIdRequestBody copy$default(SessionIdWithOrderIdRequestBody sessionIdWithOrderIdRequestBody, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sessionIdWithOrderIdRequestBody.redirectUri;
        }
        if ((i & 2) != 0) {
            str2 = sessionIdWithOrderIdRequestBody.merchantLogin;
        }
        if ((i & 4) != 0) {
            str3 = sessionIdWithOrderIdRequestBody.orderId;
        }
        return sessionIdWithOrderIdRequestBody.copy(str, str2, str3);
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
    public final String getOrderId() {
        return this.orderId;
    }

    public final SessionIdWithOrderIdRequestBody copy(String redirectUri, String merchantLogin, String orderId) {
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        return new SessionIdWithOrderIdRequestBody(redirectUri, merchantLogin, orderId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionIdWithOrderIdRequestBody)) {
            return false;
        }
        SessionIdWithOrderIdRequestBody sessionIdWithOrderIdRequestBody = (SessionIdWithOrderIdRequestBody) other;
        return Intrinsics.areEqual(this.redirectUri, sessionIdWithOrderIdRequestBody.redirectUri) && Intrinsics.areEqual(this.merchantLogin, sessionIdWithOrderIdRequestBody.merchantLogin) && Intrinsics.areEqual(this.orderId, sessionIdWithOrderIdRequestBody.orderId);
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

    public int hashCode() {
        int iHashCode = this.redirectUri.hashCode() * 31;
        String str = this.merchantLogin;
        return this.orderId.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SessionIdWithOrderIdRequestBody(redirectUri=");
        sb.append(this.redirectUri);
        sb.append(", merchantLogin=");
        sb.append(this.merchantLogin);
        sb.append(", orderId=");
        return Q1.a(sb, this.orderId, ')');
    }

    public /* synthetic */ SessionIdWithOrderIdRequestBody(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, str3);
    }
}
