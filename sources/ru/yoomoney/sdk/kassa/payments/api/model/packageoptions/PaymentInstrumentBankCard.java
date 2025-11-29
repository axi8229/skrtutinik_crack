package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentBankCard;", "", "paymentInstrumentId", "", "last4", "first6", "cscRequired", "", "cardType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;)V", "getCardType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;", "getCscRequired", "()Z", "getFirst6", "()Ljava/lang/String;", "getLast4", "getPaymentInstrumentId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentInstrumentBankCard {
    public static final int $stable = 0;
    private final BankCardType cardType;
    private final boolean cscRequired;
    private final String first6;
    private final String last4;
    private final String paymentInstrumentId;

    public PaymentInstrumentBankCard(@JsonProperty("payment_instrument_id") String paymentInstrumentId, @JsonProperty("last4") String last4, @JsonProperty("first6") String str, @JsonProperty("csc_required") boolean z, @JsonProperty("card_type") BankCardType cardType) {
        Intrinsics.checkNotNullParameter(paymentInstrumentId, "paymentInstrumentId");
        Intrinsics.checkNotNullParameter(last4, "last4");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        this.paymentInstrumentId = paymentInstrumentId;
        this.last4 = last4;
        this.first6 = str;
        this.cscRequired = z;
        this.cardType = cardType;
    }

    public static /* synthetic */ PaymentInstrumentBankCard copy$default(PaymentInstrumentBankCard paymentInstrumentBankCard, String str, String str2, String str3, boolean z, BankCardType bankCardType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentInstrumentBankCard.paymentInstrumentId;
        }
        if ((i & 2) != 0) {
            str2 = paymentInstrumentBankCard.last4;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = paymentInstrumentBankCard.first6;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = paymentInstrumentBankCard.cscRequired;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            bankCardType = paymentInstrumentBankCard.cardType;
        }
        return paymentInstrumentBankCard.copy(str, str4, str5, z2, bankCardType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPaymentInstrumentId() {
        return this.paymentInstrumentId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLast4() {
        return this.last4;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFirst6() {
        return this.first6;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCscRequired() {
        return this.cscRequired;
    }

    /* renamed from: component5, reason: from getter */
    public final BankCardType getCardType() {
        return this.cardType;
    }

    public final PaymentInstrumentBankCard copy(@JsonProperty("payment_instrument_id") String paymentInstrumentId, @JsonProperty("last4") String last4, @JsonProperty("first6") String first6, @JsonProperty("csc_required") boolean cscRequired, @JsonProperty("card_type") BankCardType cardType) {
        Intrinsics.checkNotNullParameter(paymentInstrumentId, "paymentInstrumentId");
        Intrinsics.checkNotNullParameter(last4, "last4");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        return new PaymentInstrumentBankCard(paymentInstrumentId, last4, first6, cscRequired, cardType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentInstrumentBankCard)) {
            return false;
        }
        PaymentInstrumentBankCard paymentInstrumentBankCard = (PaymentInstrumentBankCard) other;
        return Intrinsics.areEqual(this.paymentInstrumentId, paymentInstrumentBankCard.paymentInstrumentId) && Intrinsics.areEqual(this.last4, paymentInstrumentBankCard.last4) && Intrinsics.areEqual(this.first6, paymentInstrumentBankCard.first6) && this.cscRequired == paymentInstrumentBankCard.cscRequired && this.cardType == paymentInstrumentBankCard.cardType;
    }

    @JsonProperty("card_type")
    public final BankCardType getCardType() {
        return this.cardType;
    }

    @JsonProperty("csc_required")
    public final boolean getCscRequired() {
        return this.cscRequired;
    }

    public final String getFirst6() {
        return this.first6;
    }

    public final String getLast4() {
        return this.last4;
    }

    @JsonProperty("payment_instrument_id")
    public final String getPaymentInstrumentId() {
        return this.paymentInstrumentId;
    }

    public int hashCode() {
        int iA = AbstractC1553e.a(this.last4, this.paymentInstrumentId.hashCode() * 31, 31);
        String str = this.first6;
        return this.cardType.hashCode() + a.a(this.cscRequired, (iA + (str == null ? 0 : str.hashCode())) * 31, 31);
    }

    public String toString() {
        return "PaymentInstrumentBankCard(paymentInstrumentId=" + this.paymentInstrumentId + ", last4=" + this.last4 + ", first6=" + this.first6 + ", cscRequired=" + this.cscRequired + ", cardType=" + this.cardType + ")";
    }
}
