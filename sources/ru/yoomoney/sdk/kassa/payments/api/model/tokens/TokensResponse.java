package ru.yoomoney.sdk.kassa.payments.api.model.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensResponse;", "", "paymentToken", "", "profilingData", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ProfilingDataResponse;", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ProfilingDataResponse;)V", "getPaymentToken", "()Ljava/lang/String;", "getProfilingData", "()Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ProfilingDataResponse;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TokensResponse {
    public static final int $stable = 0;
    private final String paymentToken;
    private final ProfilingDataResponse profilingData;

    public TokensResponse(@JsonProperty("payment_token") String paymentToken, @JsonProperty("profiling_data") ProfilingDataResponse profilingDataResponse) {
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        this.paymentToken = paymentToken;
        this.profilingData = profilingDataResponse;
    }

    public static /* synthetic */ TokensResponse copy$default(TokensResponse tokensResponse, String str, ProfilingDataResponse profilingDataResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tokensResponse.paymentToken;
        }
        if ((i & 2) != 0) {
            profilingDataResponse = tokensResponse.profilingData;
        }
        return tokensResponse.copy(str, profilingDataResponse);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPaymentToken() {
        return this.paymentToken;
    }

    /* renamed from: component2, reason: from getter */
    public final ProfilingDataResponse getProfilingData() {
        return this.profilingData;
    }

    public final TokensResponse copy(@JsonProperty("payment_token") String paymentToken, @JsonProperty("profiling_data") ProfilingDataResponse profilingData) {
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        return new TokensResponse(paymentToken, profilingData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokensResponse)) {
            return false;
        }
        TokensResponse tokensResponse = (TokensResponse) other;
        return Intrinsics.areEqual(this.paymentToken, tokensResponse.paymentToken) && Intrinsics.areEqual(this.profilingData, tokensResponse.profilingData);
    }

    public final String getPaymentToken() {
        return this.paymentToken;
    }

    public final ProfilingDataResponse getProfilingData() {
        return this.profilingData;
    }

    public int hashCode() {
        int iHashCode = this.paymentToken.hashCode() * 31;
        ProfilingDataResponse profilingDataResponse = this.profilingData;
        return iHashCode + (profilingDataResponse == null ? 0 : profilingDataResponse.hashCode());
    }

    public String toString() {
        return "TokensResponse(paymentToken=" + this.paymentToken + ", profilingData=" + this.profilingData + ")";
    }
}
