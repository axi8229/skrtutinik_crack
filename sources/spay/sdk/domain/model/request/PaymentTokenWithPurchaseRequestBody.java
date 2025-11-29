package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import spay.sdk.data.dto.MerchantDataWithPurchase;
import spay.sdk.domain.model.FraudMonInfo;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003JS\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006&"}, d2 = {"Lspay/sdk/domain/model/request/PaymentTokenWithPurchaseRequestBody;", "", "sessionId", "", "deviceInfo", "paymentId", "", "merchantLogin", "purchase", "Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "isBnplEnabled", "", "fraudMonInfo", "Lspay/sdk/domain/model/FraudMonInfo;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;ZLspay/sdk/domain/model/FraudMonInfo;)V", "getDeviceInfo", "()Ljava/lang/String;", "getFraudMonInfo", "()Lspay/sdk/domain/model/FraudMonInfo;", "()Z", "getMerchantLogin", "getPaymentId", "()I", "getPurchase", "()Lspay/sdk/data/dto/MerchantDataWithPurchase$Purchase;", "getSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentTokenWithPurchaseRequestBody {
    private final String deviceInfo;
    private final FraudMonInfo fraudMonInfo;
    private final boolean isBnplEnabled;
    private final String merchantLogin;
    private final int paymentId;
    private final MerchantDataWithPurchase.Purchase purchase;
    private final String sessionId;

    public PaymentTokenWithPurchaseRequestBody(String sessionId, String deviceInfo, int i, String str, MerchantDataWithPurchase.Purchase purchase, boolean z, FraudMonInfo fraudMonInfo) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        this.sessionId = sessionId;
        this.deviceInfo = deviceInfo;
        this.paymentId = i;
        this.merchantLogin = str;
        this.purchase = purchase;
        this.isBnplEnabled = z;
        this.fraudMonInfo = fraudMonInfo;
    }

    public static /* synthetic */ PaymentTokenWithPurchaseRequestBody copy$default(PaymentTokenWithPurchaseRequestBody paymentTokenWithPurchaseRequestBody, String str, String str2, int i, String str3, MerchantDataWithPurchase.Purchase purchase, boolean z, FraudMonInfo fraudMonInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentTokenWithPurchaseRequestBody.sessionId;
        }
        if ((i2 & 2) != 0) {
            str2 = paymentTokenWithPurchaseRequestBody.deviceInfo;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            i = paymentTokenWithPurchaseRequestBody.paymentId;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = paymentTokenWithPurchaseRequestBody.merchantLogin;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            purchase = paymentTokenWithPurchaseRequestBody.purchase;
        }
        MerchantDataWithPurchase.Purchase purchase2 = purchase;
        if ((i2 & 32) != 0) {
            z = paymentTokenWithPurchaseRequestBody.isBnplEnabled;
        }
        boolean z2 = z;
        if ((i2 & 64) != 0) {
            fraudMonInfo = paymentTokenWithPurchaseRequestBody.fraudMonInfo;
        }
        return paymentTokenWithPurchaseRequestBody.copy(str, str4, i3, str5, purchase2, z2, fraudMonInfo);
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
    public final MerchantDataWithPurchase.Purchase getPurchase() {
        return this.purchase;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsBnplEnabled() {
        return this.isBnplEnabled;
    }

    /* renamed from: component7, reason: from getter */
    public final FraudMonInfo getFraudMonInfo() {
        return this.fraudMonInfo;
    }

    public final PaymentTokenWithPurchaseRequestBody copy(String sessionId, String deviceInfo, int paymentId, String merchantLogin, MerchantDataWithPurchase.Purchase purchase, boolean isBnplEnabled, FraudMonInfo fraudMonInfo) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return new PaymentTokenWithPurchaseRequestBody(sessionId, deviceInfo, paymentId, merchantLogin, purchase, isBnplEnabled, fraudMonInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentTokenWithPurchaseRequestBody)) {
            return false;
        }
        PaymentTokenWithPurchaseRequestBody paymentTokenWithPurchaseRequestBody = (PaymentTokenWithPurchaseRequestBody) other;
        return Intrinsics.areEqual(this.sessionId, paymentTokenWithPurchaseRequestBody.sessionId) && Intrinsics.areEqual(this.deviceInfo, paymentTokenWithPurchaseRequestBody.deviceInfo) && this.paymentId == paymentTokenWithPurchaseRequestBody.paymentId && Intrinsics.areEqual(this.merchantLogin, paymentTokenWithPurchaseRequestBody.merchantLogin) && Intrinsics.areEqual(this.purchase, paymentTokenWithPurchaseRequestBody.purchase) && this.isBnplEnabled == paymentTokenWithPurchaseRequestBody.isBnplEnabled && Intrinsics.areEqual(this.fraudMonInfo, paymentTokenWithPurchaseRequestBody.fraudMonInfo);
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

    public final int getPaymentId() {
        return this.paymentId;
    }

    public final MerchantDataWithPurchase.Purchase getPurchase() {
        return this.purchase;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = (Integer.hashCode(this.paymentId) + AbstractC1553e.a(this.deviceInfo, this.sessionId.hashCode() * 31, 31)) * 31;
        String str = this.merchantLogin;
        int iHashCode2 = (this.purchase.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        boolean z = this.isBnplEnabled;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        FraudMonInfo fraudMonInfo = this.fraudMonInfo;
        return i2 + (fraudMonInfo != null ? fraudMonInfo.hashCode() : 0);
    }

    public final boolean isBnplEnabled() {
        return this.isBnplEnabled;
    }

    public String toString() {
        return "PaymentTokenWithPurchaseRequestBody(sessionId=" + this.sessionId + ", deviceInfo=" + this.deviceInfo + ", paymentId=" + this.paymentId + ", merchantLogin=" + this.merchantLogin + ", purchase=" + this.purchase + ", isBnplEnabled=" + this.isBnplEnabled + ", fraudMonInfo=" + this.fraudMonInfo + ')';
    }

    public /* synthetic */ PaymentTokenWithPurchaseRequestBody(String str, String str2, int i, String str3, MerchantDataWithPurchase.Purchase purchase, boolean z, FraudMonInfo fraudMonInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? null : str3, purchase, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? null : fraudMonInfo);
    }
}
