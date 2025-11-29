package ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/paymentdetails/PaymentDetailsResponse;", "", "paymentId", "", UpdateKey.STATUS, "Lru/yoomoney/sdk/kassa/payments/api/model/paymentdetails/PaymentStatusResponse;", "userPaymentProcess", "Lru/yoomoney/sdk/kassa/payments/api/model/paymentdetails/UserPaymentProcessResponse;", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/paymentdetails/PaymentStatusResponse;Lru/yoomoney/sdk/kassa/payments/api/model/paymentdetails/UserPaymentProcessResponse;)V", "getPaymentId", "()Ljava/lang/String;", "getStatus", "()Lru/yoomoney/sdk/kassa/payments/api/model/paymentdetails/PaymentStatusResponse;", "getUserPaymentProcess", "()Lru/yoomoney/sdk/kassa/payments/api/model/paymentdetails/UserPaymentProcessResponse;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentDetailsResponse {
    public static final int $stable = 0;
    private final String paymentId;
    private final PaymentStatusResponse status;
    private final UserPaymentProcessResponse userPaymentProcess;

    public PaymentDetailsResponse(@JsonProperty("payment_id") String paymentId, @JsonProperty(UpdateKey.STATUS) PaymentStatusResponse status, @JsonProperty("user_payment_process_status") UserPaymentProcessResponse userPaymentProcess) {
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(userPaymentProcess, "userPaymentProcess");
        this.paymentId = paymentId;
        this.status = status;
        this.userPaymentProcess = userPaymentProcess;
    }

    public static /* synthetic */ PaymentDetailsResponse copy$default(PaymentDetailsResponse paymentDetailsResponse, String str, PaymentStatusResponse paymentStatusResponse, UserPaymentProcessResponse userPaymentProcessResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentDetailsResponse.paymentId;
        }
        if ((i & 2) != 0) {
            paymentStatusResponse = paymentDetailsResponse.status;
        }
        if ((i & 4) != 0) {
            userPaymentProcessResponse = paymentDetailsResponse.userPaymentProcess;
        }
        return paymentDetailsResponse.copy(str, paymentStatusResponse, userPaymentProcessResponse);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPaymentId() {
        return this.paymentId;
    }

    /* renamed from: component2, reason: from getter */
    public final PaymentStatusResponse getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final UserPaymentProcessResponse getUserPaymentProcess() {
        return this.userPaymentProcess;
    }

    public final PaymentDetailsResponse copy(@JsonProperty("payment_id") String paymentId, @JsonProperty(UpdateKey.STATUS) PaymentStatusResponse status, @JsonProperty("user_payment_process_status") UserPaymentProcessResponse userPaymentProcess) {
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(userPaymentProcess, "userPaymentProcess");
        return new PaymentDetailsResponse(paymentId, status, userPaymentProcess);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentDetailsResponse)) {
            return false;
        }
        PaymentDetailsResponse paymentDetailsResponse = (PaymentDetailsResponse) other;
        return Intrinsics.areEqual(this.paymentId, paymentDetailsResponse.paymentId) && this.status == paymentDetailsResponse.status && this.userPaymentProcess == paymentDetailsResponse.userPaymentProcess;
    }

    public final String getPaymentId() {
        return this.paymentId;
    }

    public final PaymentStatusResponse getStatus() {
        return this.status;
    }

    public final UserPaymentProcessResponse getUserPaymentProcess() {
        return this.userPaymentProcess;
    }

    public int hashCode() {
        return this.userPaymentProcess.hashCode() + ((this.status.hashCode() + (this.paymentId.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "PaymentDetailsResponse(paymentId=" + this.paymentId + ", status=" + this.status + ", userPaymentProcess=" + this.userPaymentProcess + ")";
    }
}
