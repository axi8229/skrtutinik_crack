package spay.sdk.domain.model.request;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0080\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006,"}, d2 = {"Lspay/sdk/domain/model/request/PaymentOrderRequestBody;", "", "operationId", "", "merchantLogin", "orderId", "paymentToken", "paymentTokenId", "jsonParams", "", "threeDSMethodNotificationUrl", "termUrl", "bindingNotNeeded", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBindingNotNeeded", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getJsonParams", "()Ljava/util/Map;", "getMerchantLogin", "()Ljava/lang/String;", "getOperationId", "getOrderId", "getPaymentToken", "getPaymentTokenId", "getTermUrl", "getThreeDSMethodNotificationUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lspay/sdk/domain/model/request/PaymentOrderRequestBody;", "equals", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentOrderRequestBody {
    private final Boolean bindingNotNeeded;
    private final Map<String, String> jsonParams;
    private final String merchantLogin;
    private final String operationId;
    private final String orderId;
    private final String paymentToken;
    private final String paymentTokenId;
    private final String termUrl;
    private final String threeDSMethodNotificationUrl;

    public PaymentOrderRequestBody(String operationId, String str, String orderId, String str2, String str3, Map<String, String> jsonParams, String str4, String str5, Boolean bool) {
        Intrinsics.checkNotNullParameter(operationId, "operationId");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(jsonParams, "jsonParams");
        this.operationId = operationId;
        this.merchantLogin = str;
        this.orderId = orderId;
        this.paymentToken = str2;
        this.paymentTokenId = str3;
        this.jsonParams = jsonParams;
        this.threeDSMethodNotificationUrl = str4;
        this.termUrl = str5;
        this.bindingNotNeeded = bool;
    }

    /* renamed from: component1, reason: from getter */
    public final String getOperationId() {
        return this.operationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPaymentToken() {
        return this.paymentToken;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPaymentTokenId() {
        return this.paymentTokenId;
    }

    public final Map<String, String> component6() {
        return this.jsonParams;
    }

    /* renamed from: component7, reason: from getter */
    public final String getThreeDSMethodNotificationUrl() {
        return this.threeDSMethodNotificationUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTermUrl() {
        return this.termUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getBindingNotNeeded() {
        return this.bindingNotNeeded;
    }

    public final PaymentOrderRequestBody copy(String operationId, String merchantLogin, String orderId, String paymentToken, String paymentTokenId, Map<String, String> jsonParams, String threeDSMethodNotificationUrl, String termUrl, Boolean bindingNotNeeded) {
        Intrinsics.checkNotNullParameter(operationId, "operationId");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(jsonParams, "jsonParams");
        return new PaymentOrderRequestBody(operationId, merchantLogin, orderId, paymentToken, paymentTokenId, jsonParams, threeDSMethodNotificationUrl, termUrl, bindingNotNeeded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentOrderRequestBody)) {
            return false;
        }
        PaymentOrderRequestBody paymentOrderRequestBody = (PaymentOrderRequestBody) other;
        return Intrinsics.areEqual(this.operationId, paymentOrderRequestBody.operationId) && Intrinsics.areEqual(this.merchantLogin, paymentOrderRequestBody.merchantLogin) && Intrinsics.areEqual(this.orderId, paymentOrderRequestBody.orderId) && Intrinsics.areEqual(this.paymentToken, paymentOrderRequestBody.paymentToken) && Intrinsics.areEqual(this.paymentTokenId, paymentOrderRequestBody.paymentTokenId) && Intrinsics.areEqual(this.jsonParams, paymentOrderRequestBody.jsonParams) && Intrinsics.areEqual(this.threeDSMethodNotificationUrl, paymentOrderRequestBody.threeDSMethodNotificationUrl) && Intrinsics.areEqual(this.termUrl, paymentOrderRequestBody.termUrl) && Intrinsics.areEqual(this.bindingNotNeeded, paymentOrderRequestBody.bindingNotNeeded);
    }

    public final Boolean getBindingNotNeeded() {
        return this.bindingNotNeeded;
    }

    public final Map<String, String> getJsonParams() {
        return this.jsonParams;
    }

    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPaymentToken() {
        return this.paymentToken;
    }

    public final String getPaymentTokenId() {
        return this.paymentTokenId;
    }

    public final String getTermUrl() {
        return this.termUrl;
    }

    public final String getThreeDSMethodNotificationUrl() {
        return this.threeDSMethodNotificationUrl;
    }

    public int hashCode() {
        int iHashCode = this.operationId.hashCode() * 31;
        String str = this.merchantLogin;
        int iA = AbstractC1553e.a(this.orderId, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
        String str2 = this.paymentToken;
        int iHashCode2 = (iA + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.paymentTokenId;
        int iHashCode3 = (this.jsonParams.hashCode() + ((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31;
        String str4 = this.threeDSMethodNotificationUrl;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.termUrl;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.bindingNotNeeded;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "PaymentOrderRequestBody(operationId=" + this.operationId + ", merchantLogin=" + this.merchantLogin + ", orderId=" + this.orderId + ", paymentToken=" + this.paymentToken + ", paymentTokenId=" + this.paymentTokenId + ", jsonParams=" + this.jsonParams + ", threeDSMethodNotificationUrl=" + this.threeDSMethodNotificationUrl + ", termUrl=" + this.termUrl + ", bindingNotNeeded=" + this.bindingNotNeeded + ')';
    }

    public /* synthetic */ PaymentOrderRequestBody(String str, String str2, String str3, String str4, String str5, Map map, String str6, String str7, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, map, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : bool);
    }
}
