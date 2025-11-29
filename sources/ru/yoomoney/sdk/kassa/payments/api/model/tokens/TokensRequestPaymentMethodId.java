package ru.yoomoney.sdk.kassa.payments.api.model.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JR\u0010\u001e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentMethodId;", "", "amount", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "confirmation", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;", "savePaymentMethod", "", "paymentMethodId", "csc", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "getConfirmation", "()Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;", "getCsc", "()Ljava/lang/String;", "getPaymentMethodId", "getSavePaymentMethod", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTmxSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentMethodId;", "equals", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TokensRequestPaymentMethodId {
    public static final int $stable = 8;
    private final Amount amount;
    private final ConfirmationRequest confirmation;
    private final String csc;
    private final String paymentMethodId;
    private final Boolean savePaymentMethod;
    private final String tmxSessionId;

    public TokensRequestPaymentMethodId(@JsonProperty("amount") Amount amount, @JsonProperty("tmx_session_id") String tmxSessionId, @JsonProperty("confirmation") ConfirmationRequest confirmationRequest, @JsonProperty("save_payment_method") Boolean bool, @JsonProperty("payment_method_id") String paymentMethodId, @JsonProperty("csc") String str) {
        Intrinsics.checkNotNullParameter(tmxSessionId, "tmxSessionId");
        Intrinsics.checkNotNullParameter(paymentMethodId, "paymentMethodId");
        this.amount = amount;
        this.tmxSessionId = tmxSessionId;
        this.confirmation = confirmationRequest;
        this.savePaymentMethod = bool;
        this.paymentMethodId = paymentMethodId;
        this.csc = str;
    }

    public static /* synthetic */ TokensRequestPaymentMethodId copy$default(TokensRequestPaymentMethodId tokensRequestPaymentMethodId, Amount amount, String str, ConfirmationRequest confirmationRequest, Boolean bool, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            amount = tokensRequestPaymentMethodId.amount;
        }
        if ((i & 2) != 0) {
            str = tokensRequestPaymentMethodId.tmxSessionId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            confirmationRequest = tokensRequestPaymentMethodId.confirmation;
        }
        ConfirmationRequest confirmationRequest2 = confirmationRequest;
        if ((i & 8) != 0) {
            bool = tokensRequestPaymentMethodId.savePaymentMethod;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            str2 = tokensRequestPaymentMethodId.paymentMethodId;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = tokensRequestPaymentMethodId.csc;
        }
        return tokensRequestPaymentMethodId.copy(amount, str4, confirmationRequest2, bool2, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final Amount getAmount() {
        return this.amount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final ConfirmationRequest getConfirmation() {
        return this.confirmation;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getSavePaymentMethod() {
        return this.savePaymentMethod;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPaymentMethodId() {
        return this.paymentMethodId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCsc() {
        return this.csc;
    }

    public final TokensRequestPaymentMethodId copy(@JsonProperty("amount") Amount amount, @JsonProperty("tmx_session_id") String tmxSessionId, @JsonProperty("confirmation") ConfirmationRequest confirmation, @JsonProperty("save_payment_method") Boolean savePaymentMethod, @JsonProperty("payment_method_id") String paymentMethodId, @JsonProperty("csc") String csc) {
        Intrinsics.checkNotNullParameter(tmxSessionId, "tmxSessionId");
        Intrinsics.checkNotNullParameter(paymentMethodId, "paymentMethodId");
        return new TokensRequestPaymentMethodId(amount, tmxSessionId, confirmation, savePaymentMethod, paymentMethodId, csc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokensRequestPaymentMethodId)) {
            return false;
        }
        TokensRequestPaymentMethodId tokensRequestPaymentMethodId = (TokensRequestPaymentMethodId) other;
        return Intrinsics.areEqual(this.amount, tokensRequestPaymentMethodId.amount) && Intrinsics.areEqual(this.tmxSessionId, tokensRequestPaymentMethodId.tmxSessionId) && Intrinsics.areEqual(this.confirmation, tokensRequestPaymentMethodId.confirmation) && Intrinsics.areEqual(this.savePaymentMethod, tokensRequestPaymentMethodId.savePaymentMethod) && Intrinsics.areEqual(this.paymentMethodId, tokensRequestPaymentMethodId.paymentMethodId) && Intrinsics.areEqual(this.csc, tokensRequestPaymentMethodId.csc);
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final ConfirmationRequest getConfirmation() {
        return this.confirmation;
    }

    public final String getCsc() {
        return this.csc;
    }

    @JsonProperty("payment_method_id")
    public final String getPaymentMethodId() {
        return this.paymentMethodId;
    }

    @JsonProperty("save_payment_method")
    public final Boolean getSavePaymentMethod() {
        return this.savePaymentMethod;
    }

    @JsonProperty("tmx_session_id")
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public int hashCode() {
        Amount amount = this.amount;
        int iA = AbstractC1553e.a(this.tmxSessionId, (amount == null ? 0 : amount.hashCode()) * 31, 31);
        ConfirmationRequest confirmationRequest = this.confirmation;
        int iHashCode = (iA + (confirmationRequest == null ? 0 : confirmationRequest.hashCode())) * 31;
        Boolean bool = this.savePaymentMethod;
        int iA2 = AbstractC1553e.a(this.paymentMethodId, (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31, 31);
        String str = this.csc;
        return iA2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "TokensRequestPaymentMethodId(amount=" + this.amount + ", tmxSessionId=" + this.tmxSessionId + ", confirmation=" + this.confirmation + ", savePaymentMethod=" + this.savePaymentMethod + ", paymentMethodId=" + this.paymentMethodId + ", csc=" + this.csc + ")";
    }
}
