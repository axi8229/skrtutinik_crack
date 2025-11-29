package ru.yoomoney.sdk.kassa.payments.api.model.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J^\u0010#\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u00020\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\r\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u0006*"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentMethodData;", "", "amount", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "confirmation", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;", "savePaymentMethod", "", "paymentMethodData", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataRequest;", "merchantCustomerId", "savePaymentInstrument", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;Ljava/lang/Boolean;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataRequest;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAmount", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "getConfirmation", "()Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;", "getMerchantCustomerId", "()Ljava/lang/String;", "getPaymentMethodData", "()Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataRequest;", "getSavePaymentInstrument", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSavePaymentMethod", "getTmxSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;Ljava/lang/Boolean;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataRequest;Ljava/lang/String;Ljava/lang/Boolean;)Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentMethodData;", "equals", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TokensRequestPaymentMethodData {
    public static final int $stable = 8;
    private final Amount amount;
    private final ConfirmationRequest confirmation;
    private final String merchantCustomerId;
    private final PaymentMethodDataRequest paymentMethodData;
    private final Boolean savePaymentInstrument;
    private final Boolean savePaymentMethod;
    private final String tmxSessionId;

    public TokensRequestPaymentMethodData(@JsonProperty("amount") Amount amount, @JsonProperty("tmx_session_id") String tmxSessionId, @JsonProperty("confirmation") ConfirmationRequest confirmationRequest, @JsonProperty("save_payment_method") Boolean bool, @JsonProperty("payment_method_data") PaymentMethodDataRequest paymentMethodData, @JsonProperty("merchant_customer_id") String str, @JsonProperty("save_payment_instrument") Boolean bool2) {
        Intrinsics.checkNotNullParameter(tmxSessionId, "tmxSessionId");
        Intrinsics.checkNotNullParameter(paymentMethodData, "paymentMethodData");
        this.amount = amount;
        this.tmxSessionId = tmxSessionId;
        this.confirmation = confirmationRequest;
        this.savePaymentMethod = bool;
        this.paymentMethodData = paymentMethodData;
        this.merchantCustomerId = str;
        this.savePaymentInstrument = bool2;
    }

    public static /* synthetic */ TokensRequestPaymentMethodData copy$default(TokensRequestPaymentMethodData tokensRequestPaymentMethodData, Amount amount, String str, ConfirmationRequest confirmationRequest, Boolean bool, PaymentMethodDataRequest paymentMethodDataRequest, String str2, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            amount = tokensRequestPaymentMethodData.amount;
        }
        if ((i & 2) != 0) {
            str = tokensRequestPaymentMethodData.tmxSessionId;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            confirmationRequest = tokensRequestPaymentMethodData.confirmation;
        }
        ConfirmationRequest confirmationRequest2 = confirmationRequest;
        if ((i & 8) != 0) {
            bool = tokensRequestPaymentMethodData.savePaymentMethod;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            paymentMethodDataRequest = tokensRequestPaymentMethodData.paymentMethodData;
        }
        PaymentMethodDataRequest paymentMethodDataRequest2 = paymentMethodDataRequest;
        if ((i & 32) != 0) {
            str2 = tokensRequestPaymentMethodData.merchantCustomerId;
        }
        String str4 = str2;
        if ((i & 64) != 0) {
            bool2 = tokensRequestPaymentMethodData.savePaymentInstrument;
        }
        return tokensRequestPaymentMethodData.copy(amount, str3, confirmationRequest2, bool3, paymentMethodDataRequest2, str4, bool2);
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
    public final PaymentMethodDataRequest getPaymentMethodData() {
        return this.paymentMethodData;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMerchantCustomerId() {
        return this.merchantCustomerId;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getSavePaymentInstrument() {
        return this.savePaymentInstrument;
    }

    public final TokensRequestPaymentMethodData copy(@JsonProperty("amount") Amount amount, @JsonProperty("tmx_session_id") String tmxSessionId, @JsonProperty("confirmation") ConfirmationRequest confirmation, @JsonProperty("save_payment_method") Boolean savePaymentMethod, @JsonProperty("payment_method_data") PaymentMethodDataRequest paymentMethodData, @JsonProperty("merchant_customer_id") String merchantCustomerId, @JsonProperty("save_payment_instrument") Boolean savePaymentInstrument) {
        Intrinsics.checkNotNullParameter(tmxSessionId, "tmxSessionId");
        Intrinsics.checkNotNullParameter(paymentMethodData, "paymentMethodData");
        return new TokensRequestPaymentMethodData(amount, tmxSessionId, confirmation, savePaymentMethod, paymentMethodData, merchantCustomerId, savePaymentInstrument);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokensRequestPaymentMethodData)) {
            return false;
        }
        TokensRequestPaymentMethodData tokensRequestPaymentMethodData = (TokensRequestPaymentMethodData) other;
        return Intrinsics.areEqual(this.amount, tokensRequestPaymentMethodData.amount) && Intrinsics.areEqual(this.tmxSessionId, tokensRequestPaymentMethodData.tmxSessionId) && Intrinsics.areEqual(this.confirmation, tokensRequestPaymentMethodData.confirmation) && Intrinsics.areEqual(this.savePaymentMethod, tokensRequestPaymentMethodData.savePaymentMethod) && Intrinsics.areEqual(this.paymentMethodData, tokensRequestPaymentMethodData.paymentMethodData) && Intrinsics.areEqual(this.merchantCustomerId, tokensRequestPaymentMethodData.merchantCustomerId) && Intrinsics.areEqual(this.savePaymentInstrument, tokensRequestPaymentMethodData.savePaymentInstrument);
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final ConfirmationRequest getConfirmation() {
        return this.confirmation;
    }

    @JsonProperty("merchant_customer_id")
    public final String getMerchantCustomerId() {
        return this.merchantCustomerId;
    }

    @JsonProperty("payment_method_data")
    public final PaymentMethodDataRequest getPaymentMethodData() {
        return this.paymentMethodData;
    }

    @JsonProperty("save_payment_instrument")
    public final Boolean getSavePaymentInstrument() {
        return this.savePaymentInstrument;
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
        int iHashCode2 = (this.paymentMethodData.hashCode() + ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31)) * 31;
        String str = this.merchantCustomerId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool2 = this.savePaymentInstrument;
        return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "TokensRequestPaymentMethodData(amount=" + this.amount + ", tmxSessionId=" + this.tmxSessionId + ", confirmation=" + this.confirmation + ", savePaymentMethod=" + this.savePaymentMethod + ", paymentMethodData=" + this.paymentMethodData + ", merchantCustomerId=" + this.merchantCustomerId + ", savePaymentInstrument=" + this.savePaymentInstrument + ")";
    }
}
