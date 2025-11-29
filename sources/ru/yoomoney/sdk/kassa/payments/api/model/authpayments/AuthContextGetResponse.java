package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthContextGetResponse;", "", UpdateKey.STATUS, "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthPaymentState;", "error", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/ErrorCodeNetwork;", "result", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthContextTypesResult;", "(Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthPaymentState;Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/ErrorCodeNetwork;Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthContextTypesResult;)V", "getError", "()Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/ErrorCodeNetwork;", "getResult", "()Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthContextTypesResult;", "getStatus", "()Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthPaymentState;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthContextGetResponse {
    public static final int $stable = 8;
    private final ErrorCodeNetwork error;
    private final AuthContextTypesResult result;
    private final AuthPaymentState status;

    public AuthContextGetResponse(@JsonProperty(UpdateKey.STATUS) AuthPaymentState status, @JsonProperty("error") ErrorCodeNetwork errorCodeNetwork, @JsonProperty("result") AuthContextTypesResult authContextTypesResult) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.error = errorCodeNetwork;
        this.result = authContextTypesResult;
    }

    public static /* synthetic */ AuthContextGetResponse copy$default(AuthContextGetResponse authContextGetResponse, AuthPaymentState authPaymentState, ErrorCodeNetwork errorCodeNetwork, AuthContextTypesResult authContextTypesResult, int i, Object obj) {
        if ((i & 1) != 0) {
            authPaymentState = authContextGetResponse.status;
        }
        if ((i & 2) != 0) {
            errorCodeNetwork = authContextGetResponse.error;
        }
        if ((i & 4) != 0) {
            authContextTypesResult = authContextGetResponse.result;
        }
        return authContextGetResponse.copy(authPaymentState, errorCodeNetwork, authContextTypesResult);
    }

    /* renamed from: component1, reason: from getter */
    public final AuthPaymentState getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final ErrorCodeNetwork getError() {
        return this.error;
    }

    /* renamed from: component3, reason: from getter */
    public final AuthContextTypesResult getResult() {
        return this.result;
    }

    public final AuthContextGetResponse copy(@JsonProperty(UpdateKey.STATUS) AuthPaymentState status, @JsonProperty("error") ErrorCodeNetwork error, @JsonProperty("result") AuthContextTypesResult result) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new AuthContextGetResponse(status, error, result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthContextGetResponse)) {
            return false;
        }
        AuthContextGetResponse authContextGetResponse = (AuthContextGetResponse) other;
        return this.status == authContextGetResponse.status && this.error == authContextGetResponse.error && Intrinsics.areEqual(this.result, authContextGetResponse.result);
    }

    public final ErrorCodeNetwork getError() {
        return this.error;
    }

    public final AuthContextTypesResult getResult() {
        return this.result;
    }

    public final AuthPaymentState getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        ErrorCodeNetwork errorCodeNetwork = this.error;
        int iHashCode2 = (iHashCode + (errorCodeNetwork == null ? 0 : errorCodeNetwork.hashCode())) * 31;
        AuthContextTypesResult authContextTypesResult = this.result;
        return iHashCode2 + (authContextTypesResult != null ? authContextTypesResult.hashCode() : 0);
    }

    public String toString() {
        return "AuthContextGetResponse(status=" + this.status + ", error=" + this.error + ", result=" + this.result + ")";
    }
}
