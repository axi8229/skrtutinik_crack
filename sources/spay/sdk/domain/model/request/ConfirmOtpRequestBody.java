package spay.sdk.domain.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JW\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lspay/sdk/domain/model/request/ConfirmOtpRequestBody;", "", "bankInvoiceId", "", "bindingId", "orderNumber", "otpHash", "environmentParams", "merchantLogin", "sessionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBankInvoiceId", "()Ljava/lang/String;", "getBindingId", "getEnvironmentParams", "getMerchantLogin", "getOrderNumber", "getOtpHash", "getSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfirmOtpRequestBody {
    private final String bankInvoiceId;
    private final String bindingId;
    private final String environmentParams;
    private final String merchantLogin;
    private final String orderNumber;
    private final String otpHash;
    private final String sessionId;

    public ConfirmOtpRequestBody(String bankInvoiceId, String str, String str2, String otpHash, String str3, String str4, String sessionId) {
        Intrinsics.checkNotNullParameter(bankInvoiceId, "bankInvoiceId");
        Intrinsics.checkNotNullParameter(otpHash, "otpHash");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.bankInvoiceId = bankInvoiceId;
        this.bindingId = str;
        this.orderNumber = str2;
        this.otpHash = otpHash;
        this.environmentParams = str3;
        this.merchantLogin = str4;
        this.sessionId = sessionId;
    }

    public static /* synthetic */ ConfirmOtpRequestBody copy$default(ConfirmOtpRequestBody confirmOtpRequestBody, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = confirmOtpRequestBody.bankInvoiceId;
        }
        if ((i & 2) != 0) {
            str2 = confirmOtpRequestBody.bindingId;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = confirmOtpRequestBody.orderNumber;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = confirmOtpRequestBody.otpHash;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = confirmOtpRequestBody.environmentParams;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = confirmOtpRequestBody.merchantLogin;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = confirmOtpRequestBody.sessionId;
        }
        return confirmOtpRequestBody.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBankInvoiceId() {
        return this.bankInvoiceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOtpHash() {
        return this.otpHash;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEnvironmentParams() {
        return this.environmentParams;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final ConfirmOtpRequestBody copy(String bankInvoiceId, String bindingId, String orderNumber, String otpHash, String environmentParams, String merchantLogin, String sessionId) {
        Intrinsics.checkNotNullParameter(bankInvoiceId, "bankInvoiceId");
        Intrinsics.checkNotNullParameter(otpHash, "otpHash");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new ConfirmOtpRequestBody(bankInvoiceId, bindingId, orderNumber, otpHash, environmentParams, merchantLogin, sessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmOtpRequestBody)) {
            return false;
        }
        ConfirmOtpRequestBody confirmOtpRequestBody = (ConfirmOtpRequestBody) other;
        return Intrinsics.areEqual(this.bankInvoiceId, confirmOtpRequestBody.bankInvoiceId) && Intrinsics.areEqual(this.bindingId, confirmOtpRequestBody.bindingId) && Intrinsics.areEqual(this.orderNumber, confirmOtpRequestBody.orderNumber) && Intrinsics.areEqual(this.otpHash, confirmOtpRequestBody.otpHash) && Intrinsics.areEqual(this.environmentParams, confirmOtpRequestBody.environmentParams) && Intrinsics.areEqual(this.merchantLogin, confirmOtpRequestBody.merchantLogin) && Intrinsics.areEqual(this.sessionId, confirmOtpRequestBody.sessionId);
    }

    public final String getBankInvoiceId() {
        return this.bankInvoiceId;
    }

    public final String getBindingId() {
        return this.bindingId;
    }

    public final String getEnvironmentParams() {
        return this.environmentParams;
    }

    public final String getMerchantLogin() {
        return this.merchantLogin;
    }

    public final String getOrderNumber() {
        return this.orderNumber;
    }

    public final String getOtpHash() {
        return this.otpHash;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        int iHashCode = this.bankInvoiceId.hashCode() * 31;
        String str = this.bindingId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.orderNumber;
        int iA = AbstractC1553e.a(this.otpHash, (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
        String str3 = this.environmentParams;
        int iHashCode3 = (iA + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.merchantLogin;
        return this.sessionId.hashCode() + ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConfirmOtpRequestBody(bankInvoiceId=");
        sb.append(this.bankInvoiceId);
        sb.append(", bindingId=");
        sb.append(this.bindingId);
        sb.append(", orderNumber=");
        sb.append(this.orderNumber);
        sb.append(", otpHash=");
        sb.append(this.otpHash);
        sb.append(", environmentParams=");
        sb.append(this.environmentParams);
        sb.append(", merchantLogin=");
        sb.append(this.merchantLogin);
        sb.append(", sessionId=");
        return Q1.a(sb, this.sessionId, ')');
    }

    public /* synthetic */ ConfirmOtpRequestBody(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, str4, (i & 16) != 0 ? null : str5, str6, str7);
    }
}
