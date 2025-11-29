package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import spay.sdk.domain.model.FraudMonInfo;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0080\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jp\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011¨\u0006-"}, d2 = {"Lspay/sdk/domain/model/request/PayOnlineRequestBody;", "", "userName", "", "sessionId", "merchantLogin", "deviceInfo", "paymentId", "", "priorityCardOnly", "", "orderId", "isBnplEnabled", "fraudMonInfo", "Lspay/sdk/domain/model/FraudMonInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;ZLspay/sdk/domain/model/FraudMonInfo;)V", "getDeviceInfo", "()Ljava/lang/String;", "getFraudMonInfo", "()Lspay/sdk/domain/model/FraudMonInfo;", "()Z", "getMerchantLogin", "getOrderId", "getPaymentId", "()I", "getPriorityCardOnly", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSessionId", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;ZLspay/sdk/domain/model/FraudMonInfo;)Lspay/sdk/domain/model/request/PayOnlineRequestBody;", "equals", "other", "hashCode", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PayOnlineRequestBody {
    private final String deviceInfo;
    private final FraudMonInfo fraudMonInfo;
    private final boolean isBnplEnabled;
    private final String merchantLogin;
    private final String orderId;
    private final int paymentId;
    private final Boolean priorityCardOnly;
    private final String sessionId;
    private final String userName;

    public PayOnlineRequestBody(String str, String sessionId, String str2, String deviceInfo, int i, Boolean bool, String orderId, boolean z, FraudMonInfo fraudMonInfo) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        this.userName = str;
        this.sessionId = sessionId;
        this.merchantLogin = str2;
        this.deviceInfo = deviceInfo;
        this.paymentId = i;
        this.priorityCardOnly = bool;
        this.orderId = orderId;
        this.isBnplEnabled = z;
        this.fraudMonInfo = fraudMonInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeviceInfo() {
        return this.deviceInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPaymentId() {
        return this.paymentId;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getPriorityCardOnly() {
        return this.priorityCardOnly;
    }

    /* renamed from: component7, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsBnplEnabled() {
        return this.isBnplEnabled;
    }

    /* renamed from: component9, reason: from getter */
    public final FraudMonInfo getFraudMonInfo() {
        return this.fraudMonInfo;
    }

    public final PayOnlineRequestBody copy(String userName, String sessionId, String merchantLogin, String deviceInfo, int paymentId, Boolean priorityCardOnly, String orderId, boolean isBnplEnabled, FraudMonInfo fraudMonInfo) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        return new PayOnlineRequestBody(userName, sessionId, merchantLogin, deviceInfo, paymentId, priorityCardOnly, orderId, isBnplEnabled, fraudMonInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayOnlineRequestBody)) {
            return false;
        }
        PayOnlineRequestBody payOnlineRequestBody = (PayOnlineRequestBody) other;
        return Intrinsics.areEqual(this.userName, payOnlineRequestBody.userName) && Intrinsics.areEqual(this.sessionId, payOnlineRequestBody.sessionId) && Intrinsics.areEqual(this.merchantLogin, payOnlineRequestBody.merchantLogin) && Intrinsics.areEqual(this.deviceInfo, payOnlineRequestBody.deviceInfo) && this.paymentId == payOnlineRequestBody.paymentId && Intrinsics.areEqual(this.priorityCardOnly, payOnlineRequestBody.priorityCardOnly) && Intrinsics.areEqual(this.orderId, payOnlineRequestBody.orderId) && this.isBnplEnabled == payOnlineRequestBody.isBnplEnabled && Intrinsics.areEqual(this.fraudMonInfo, payOnlineRequestBody.fraudMonInfo);
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

    public final Boolean getPriorityCardOnly() {
        return this.priorityCardOnly;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getUserName() {
        return this.userName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.userName;
        int iA = AbstractC1553e.a(this.sessionId, (str == null ? 0 : str.hashCode()) * 31, 31);
        String str2 = this.merchantLogin;
        int iHashCode = (Integer.hashCode(this.paymentId) + AbstractC1553e.a(this.deviceInfo, (iA + (str2 == null ? 0 : str2.hashCode())) * 31, 31)) * 31;
        Boolean bool = this.priorityCardOnly;
        int iA2 = AbstractC1553e.a(this.orderId, (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31, 31);
        boolean z = this.isBnplEnabled;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iA2 + i) * 31;
        FraudMonInfo fraudMonInfo = this.fraudMonInfo;
        return i2 + (fraudMonInfo != null ? fraudMonInfo.hashCode() : 0);
    }

    public final boolean isBnplEnabled() {
        return this.isBnplEnabled;
    }

    public String toString() {
        return "PayOnlineRequestBody(userName=" + this.userName + ", sessionId=" + this.sessionId + ", merchantLogin=" + this.merchantLogin + ", deviceInfo=" + this.deviceInfo + ", paymentId=" + this.paymentId + ", priorityCardOnly=" + this.priorityCardOnly + ", orderId=" + this.orderId + ", isBnplEnabled=" + this.isBnplEnabled + ", fraudMonInfo=" + this.fraudMonInfo + ')';
    }

    public /* synthetic */ PayOnlineRequestBody(String str, String str2, String str3, String str4, int i, Boolean bool, String str5, boolean z, FraudMonInfo fraudMonInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, str2, (i2 & 4) != 0 ? null : str3, str4, i, (i2 & 32) != 0 ? null : bool, str5, z, (i2 & 256) != 0 ? null : fraudMonInfo);
    }
}
