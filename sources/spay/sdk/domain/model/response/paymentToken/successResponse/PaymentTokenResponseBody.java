package spay.sdk.domain.model.response.paymentToken.successResponse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lspay/sdk/domain/model/response/paymentToken/successResponse/PaymentTokenResponseBody;", "", "paymentToken", "", "initiateBankInvoiceId", "(Ljava/lang/String;Ljava/lang/String;)V", "getInitiateBankInvoiceId", "()Ljava/lang/String;", "getPaymentToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentTokenResponseBody {
    private final String initiateBankInvoiceId;
    private final String paymentToken;

    public PaymentTokenResponseBody(String paymentToken, String str) {
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        this.paymentToken = paymentToken;
        this.initiateBankInvoiceId = str;
    }

    public static /* synthetic */ PaymentTokenResponseBody copy$default(PaymentTokenResponseBody paymentTokenResponseBody, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentTokenResponseBody.paymentToken;
        }
        if ((i & 2) != 0) {
            str2 = paymentTokenResponseBody.initiateBankInvoiceId;
        }
        return paymentTokenResponseBody.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPaymentToken() {
        return this.paymentToken;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInitiateBankInvoiceId() {
        return this.initiateBankInvoiceId;
    }

    public final PaymentTokenResponseBody copy(String paymentToken, String initiateBankInvoiceId) {
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        return new PaymentTokenResponseBody(paymentToken, initiateBankInvoiceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentTokenResponseBody)) {
            return false;
        }
        PaymentTokenResponseBody paymentTokenResponseBody = (PaymentTokenResponseBody) other;
        return Intrinsics.areEqual(this.paymentToken, paymentTokenResponseBody.paymentToken) && Intrinsics.areEqual(this.initiateBankInvoiceId, paymentTokenResponseBody.initiateBankInvoiceId);
    }

    public final String getInitiateBankInvoiceId() {
        return this.initiateBankInvoiceId;
    }

    public final String getPaymentToken() {
        return this.paymentToken;
    }

    public int hashCode() {
        int iHashCode = this.paymentToken.hashCode() * 31;
        String str = this.initiateBankInvoiceId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PaymentTokenResponseBody(paymentToken=");
        sb.append(this.paymentToken);
        sb.append(", initiateBankInvoiceId=");
        return Q1.a(sb, this.initiateBankInvoiceId, ')');
    }
}
