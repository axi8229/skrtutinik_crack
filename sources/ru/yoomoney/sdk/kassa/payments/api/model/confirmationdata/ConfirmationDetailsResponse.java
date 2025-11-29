package ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDetailsResponse;", "", "paymentId", "", "confirmationData", "Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse;", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse;)V", "getConfirmationData", "()Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse;", "getPaymentId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfirmationDetailsResponse {
    public static final int $stable = 8;
    private final ConfirmationDataResponse confirmationData;
    private final String paymentId;

    public ConfirmationDetailsResponse(@JsonProperty("payment_id") String paymentId, @JsonProperty("confirmation_data") ConfirmationDataResponse confirmationData) {
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
        this.paymentId = paymentId;
        this.confirmationData = confirmationData;
    }

    public static /* synthetic */ ConfirmationDetailsResponse copy$default(ConfirmationDetailsResponse confirmationDetailsResponse, String str, ConfirmationDataResponse confirmationDataResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            str = confirmationDetailsResponse.paymentId;
        }
        if ((i & 2) != 0) {
            confirmationDataResponse = confirmationDetailsResponse.confirmationData;
        }
        return confirmationDetailsResponse.copy(str, confirmationDataResponse);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPaymentId() {
        return this.paymentId;
    }

    /* renamed from: component2, reason: from getter */
    public final ConfirmationDataResponse getConfirmationData() {
        return this.confirmationData;
    }

    public final ConfirmationDetailsResponse copy(@JsonProperty("payment_id") String paymentId, @JsonProperty("confirmation_data") ConfirmationDataResponse confirmationData) {
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
        return new ConfirmationDetailsResponse(paymentId, confirmationData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmationDetailsResponse)) {
            return false;
        }
        ConfirmationDetailsResponse confirmationDetailsResponse = (ConfirmationDetailsResponse) other;
        return Intrinsics.areEqual(this.paymentId, confirmationDetailsResponse.paymentId) && Intrinsics.areEqual(this.confirmationData, confirmationDetailsResponse.confirmationData);
    }

    public final ConfirmationDataResponse getConfirmationData() {
        return this.confirmationData;
    }

    public final String getPaymentId() {
        return this.paymentId;
    }

    public int hashCode() {
        return this.confirmationData.hashCode() + (this.paymentId.hashCode() * 31);
    }

    public String toString() {
        return "ConfirmationDetailsResponse(paymentId=" + this.paymentId + ", confirmationData=" + this.confirmationData + ")";
    }
}
