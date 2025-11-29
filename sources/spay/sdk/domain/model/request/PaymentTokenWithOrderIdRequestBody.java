package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import spay.sdk.domain.model.FraudMonInfo;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JS\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006$"}, d2 = {"Lspay/sdk/domain/model/request/PaymentTokenWithOrderIdRequestBody;", "", "sessionId", "", "deviceInfo", "paymentId", "", "merchantLogin", "orderId", "isBnplEnabled", "", "fraudMonInfo", "Lspay/sdk/domain/model/FraudMonInfo;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLspay/sdk/domain/model/FraudMonInfo;)V", "getDeviceInfo", "()Ljava/lang/String;", "getFraudMonInfo", "()Lspay/sdk/domain/model/FraudMonInfo;", "()Z", "getMerchantLogin", "getOrderId", "getPaymentId", "()I", "getSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentTokenWithOrderIdRequestBody {
    private final String deviceInfo;
    private final FraudMonInfo fraudMonInfo;
    private final boolean isBnplEnabled;
    private final String merchantLogin;
    private final String orderId;
    private final int paymentId;
    private final String sessionId;

    public PaymentTokenWithOrderIdRequestBody(String sessionId, String deviceInfo, int i, String str, String orderId, boolean z, FraudMonInfo fraudMonInfo) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        this.sessionId = sessionId;
        this.deviceInfo = deviceInfo;
        this.paymentId = i;
        this.merchantLogin = str;
        this.orderId = orderId;
        this.isBnplEnabled = z;
        this.fraudMonInfo = fraudMonInfo;
    }

    public static /* synthetic */ PaymentTokenWithOrderIdRequestBody copy$default(PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody, String str, String str2, int i, String str3, String str4, boolean z, FraudMonInfo fraudMonInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentTokenWithOrderIdRequestBody.sessionId;
        }
        if ((i2 & 2) != 0) {
            str2 = paymentTokenWithOrderIdRequestBody.deviceInfo;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = paymentTokenWithOrderIdRequestBody.paymentId;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = paymentTokenWithOrderIdRequestBody.merchantLogin;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = paymentTokenWithOrderIdRequestBody.orderId;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            z = paymentTokenWithOrderIdRequestBody.isBnplEnabled;
        }
        boolean z2 = z;
        if ((i2 & 64) != 0) {
            fraudMonInfo = paymentTokenWithOrderIdRequestBody.fraudMonInfo;
        }
        return paymentTokenWithOrderIdRequestBody.copy(str, str5, i3, str6, str7, z2, fraudMonInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceInfo() {
        return this.deviceInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPaymentId() {
        return this.paymentId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component5, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsBnplEnabled() {
        return this.isBnplEnabled;
    }

    /* renamed from: component7, reason: from getter */
    public final FraudMonInfo getFraudMonInfo() {
        return this.fraudMonInfo;
    }

    public final PaymentTokenWithOrderIdRequestBody copy(String sessionId, String deviceInfo, int paymentId, String merchantLogin, String orderId, boolean isBnplEnabled, FraudMonInfo fraudMonInfo) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        return new PaymentTokenWithOrderIdRequestBody(sessionId, deviceInfo, paymentId, merchantLogin, orderId, isBnplEnabled, fraudMonInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentTokenWithOrderIdRequestBody)) {
            return false;
        }
        PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody = (PaymentTokenWithOrderIdRequestBody) other;
        return Intrinsics.areEqual(this.sessionId, paymentTokenWithOrderIdRequestBody.sessionId) && Intrinsics.areEqual(this.deviceInfo, paymentTokenWithOrderIdRequestBody.deviceInfo) && this.paymentId == paymentTokenWithOrderIdRequestBody.paymentId && Intrinsics.areEqual(this.merchantLogin, paymentTokenWithOrderIdRequestBody.merchantLogin) && Intrinsics.areEqual(this.orderId, paymentTokenWithOrderIdRequestBody.orderId) && this.isBnplEnabled == paymentTokenWithOrderIdRequestBody.isBnplEnabled && Intrinsics.areEqual(this.fraudMonInfo, paymentTokenWithOrderIdRequestBody.fraudMonInfo);
    }

    public final String getDeviceInfo() {
        return this.deviceInfo;
    }

    public final FraudMonInfo getFraudMonInfo() {
        return this.fraudMonInfo;
    }

    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final int getPaymentId() {
        return this.paymentId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = (Integer.hashCode(this.paymentId) + AbstractC1553e.a(this.deviceInfo, this.sessionId.hashCode() * 31, 31)) * 31;
        String str = this.merchantLogin;
        int iA = AbstractC1553e.a(this.orderId, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
        boolean z = this.isBnplEnabled;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iA + i) * 31;
        FraudMonInfo fraudMonInfo = this.fraudMonInfo;
        return i2 + (fraudMonInfo != null ? fraudMonInfo.hashCode() : 0);
    }

    public final boolean isBnplEnabled() {
        return this.isBnplEnabled;
    }

    public String toString() {
        return "PaymentTokenWithOrderIdRequestBody(sessionId=" + this.sessionId + ", deviceInfo=" + this.deviceInfo + ", paymentId=" + this.paymentId + ", merchantLogin=" + this.merchantLogin + ", orderId=" + this.orderId + ", isBnplEnabled=" + this.isBnplEnabled + ", fraudMonInfo=" + this.fraudMonInfo + ')';
    }

    public /* synthetic */ PaymentTokenWithOrderIdRequestBody(String str, String str2, int i, String str3, String str4, boolean z, FraudMonInfo fraudMonInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? null : str3, str4, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? null : fraudMonInfo);
    }
}
