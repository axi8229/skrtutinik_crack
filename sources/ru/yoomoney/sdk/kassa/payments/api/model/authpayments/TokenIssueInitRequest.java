package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/TokenIssueInitRequest;", "", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "instanceName", "singleAmountMax", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "paymentUsageLimit", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/PaymentUsageLimit;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/PaymentUsageLimit;)V", "getInstanceName", "()Ljava/lang/String;", "getPaymentUsageLimit", "()Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/PaymentUsageLimit;", "getSingleAmountMax", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "getTmxSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TokenIssueInitRequest {
    public static final int $stable = 8;
    private final String instanceName;
    private final PaymentUsageLimit paymentUsageLimit;
    private final Amount singleAmountMax;
    private final String tmxSessionId;

    public TokenIssueInitRequest(@JsonProperty(YooMoneyAuth.KEY_TMX_SESSION_ID) String tmxSessionId, @JsonProperty("instanceName") String instanceName, @JsonProperty("singleAmountMax") Amount amount, @JsonProperty("paymentUsageLimit") PaymentUsageLimit paymentUsageLimit) {
        Intrinsics.checkNotNullParameter(tmxSessionId, "tmxSessionId");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(paymentUsageLimit, "paymentUsageLimit");
        this.tmxSessionId = tmxSessionId;
        this.instanceName = instanceName;
        this.singleAmountMax = amount;
        this.paymentUsageLimit = paymentUsageLimit;
    }

    public static /* synthetic */ TokenIssueInitRequest copy$default(TokenIssueInitRequest tokenIssueInitRequest, String str, String str2, Amount amount, PaymentUsageLimit paymentUsageLimit, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tokenIssueInitRequest.tmxSessionId;
        }
        if ((i & 2) != 0) {
            str2 = tokenIssueInitRequest.instanceName;
        }
        if ((i & 4) != 0) {
            amount = tokenIssueInitRequest.singleAmountMax;
        }
        if ((i & 8) != 0) {
            paymentUsageLimit = tokenIssueInitRequest.paymentUsageLimit;
        }
        return tokenIssueInitRequest.copy(str, str2, amount, paymentUsageLimit);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInstanceName() {
        return this.instanceName;
    }

    /* renamed from: component3, reason: from getter */
    public final Amount getSingleAmountMax() {
        return this.singleAmountMax;
    }

    /* renamed from: component4, reason: from getter */
    public final PaymentUsageLimit getPaymentUsageLimit() {
        return this.paymentUsageLimit;
    }

    public final TokenIssueInitRequest copy(@JsonProperty(YooMoneyAuth.KEY_TMX_SESSION_ID) String tmxSessionId, @JsonProperty("instanceName") String instanceName, @JsonProperty("singleAmountMax") Amount singleAmountMax, @JsonProperty("paymentUsageLimit") PaymentUsageLimit paymentUsageLimit) {
        Intrinsics.checkNotNullParameter(tmxSessionId, "tmxSessionId");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(paymentUsageLimit, "paymentUsageLimit");
        return new TokenIssueInitRequest(tmxSessionId, instanceName, singleAmountMax, paymentUsageLimit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokenIssueInitRequest)) {
            return false;
        }
        TokenIssueInitRequest tokenIssueInitRequest = (TokenIssueInitRequest) other;
        return Intrinsics.areEqual(this.tmxSessionId, tokenIssueInitRequest.tmxSessionId) && Intrinsics.areEqual(this.instanceName, tokenIssueInitRequest.instanceName) && Intrinsics.areEqual(this.singleAmountMax, tokenIssueInitRequest.singleAmountMax) && this.paymentUsageLimit == tokenIssueInitRequest.paymentUsageLimit;
    }

    public final String getInstanceName() {
        return this.instanceName;
    }

    public final PaymentUsageLimit getPaymentUsageLimit() {
        return this.paymentUsageLimit;
    }

    public final Amount getSingleAmountMax() {
        return this.singleAmountMax;
    }

    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public int hashCode() {
        int iA = AbstractC1553e.a(this.instanceName, this.tmxSessionId.hashCode() * 31, 31);
        Amount amount = this.singleAmountMax;
        return this.paymentUsageLimit.hashCode() + ((iA + (amount == null ? 0 : amount.hashCode())) * 31);
    }

    public String toString() {
        return "TokenIssueInitRequest(tmxSessionId=" + this.tmxSessionId + ", instanceName=" + this.instanceName + ", singleAmountMax=" + this.singleAmountMax + ", paymentUsageLimit=" + this.paymentUsageLimit + ")";
    }
}
