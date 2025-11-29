package ru.yoomoney.sdk.kassa.payments.api.model.paymentmethod;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.BankCardType;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardViewKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JI\u0010\u001b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/CardInfoResponse;", "", "first6", "", "last4", BankCardViewKt.EXTRA_EXPIRY_YEAR, BankCardViewKt.EXTRA_EXPIRY_MONTH, "cardType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;", "source", "Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/BankCardSourceResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/BankCardSourceResponse;)V", "getCardType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;", "getExpiryMonth", "()Ljava/lang/String;", "getExpiryYear", "getFirst6", "getLast4", "getSource", "()Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/BankCardSourceResponse;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CardInfoResponse {
    public static final int $stable = 0;
    private final BankCardType cardType;
    private final String expiryMonth;
    private final String expiryYear;
    private final String first6;
    private final String last4;
    private final BankCardSourceResponse source;

    public CardInfoResponse(@JsonProperty("first6") String str, @JsonProperty("last4") String last4, @JsonProperty("expiry_year") String expiryYear, @JsonProperty("expiry_month") String expiryMonth, @JsonProperty("card_type") BankCardType cardType, @JsonProperty("source") BankCardSourceResponse bankCardSourceResponse) {
        Intrinsics.checkNotNullParameter(last4, "last4");
        Intrinsics.checkNotNullParameter(expiryYear, "expiryYear");
        Intrinsics.checkNotNullParameter(expiryMonth, "expiryMonth");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        this.first6 = str;
        this.last4 = last4;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        this.cardType = cardType;
        this.source = bankCardSourceResponse;
    }

    public static /* synthetic */ CardInfoResponse copy$default(CardInfoResponse cardInfoResponse, String str, String str2, String str3, String str4, BankCardType bankCardType, BankCardSourceResponse bankCardSourceResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardInfoResponse.first6;
        }
        if ((i & 2) != 0) {
            str2 = cardInfoResponse.last4;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = cardInfoResponse.expiryYear;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = cardInfoResponse.expiryMonth;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            bankCardType = cardInfoResponse.cardType;
        }
        BankCardType bankCardType2 = bankCardType;
        if ((i & 32) != 0) {
            bankCardSourceResponse = cardInfoResponse.source;
        }
        return cardInfoResponse.copy(str, str5, str6, str7, bankCardType2, bankCardSourceResponse);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFirst6() {
        return this.first6;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLast4() {
        return this.last4;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    /* renamed from: component5, reason: from getter */
    public final BankCardType getCardType() {
        return this.cardType;
    }

    /* renamed from: component6, reason: from getter */
    public final BankCardSourceResponse getSource() {
        return this.source;
    }

    public final CardInfoResponse copy(@JsonProperty("first6") String first6, @JsonProperty("last4") String last4, @JsonProperty("expiry_year") String expiryYear, @JsonProperty("expiry_month") String expiryMonth, @JsonProperty("card_type") BankCardType cardType, @JsonProperty("source") BankCardSourceResponse source) {
        Intrinsics.checkNotNullParameter(last4, "last4");
        Intrinsics.checkNotNullParameter(expiryYear, "expiryYear");
        Intrinsics.checkNotNullParameter(expiryMonth, "expiryMonth");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        return new CardInfoResponse(first6, last4, expiryYear, expiryMonth, cardType, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardInfoResponse)) {
            return false;
        }
        CardInfoResponse cardInfoResponse = (CardInfoResponse) other;
        return Intrinsics.areEqual(this.first6, cardInfoResponse.first6) && Intrinsics.areEqual(this.last4, cardInfoResponse.last4) && Intrinsics.areEqual(this.expiryYear, cardInfoResponse.expiryYear) && Intrinsics.areEqual(this.expiryMonth, cardInfoResponse.expiryMonth) && this.cardType == cardInfoResponse.cardType && this.source == cardInfoResponse.source;
    }

    @JsonProperty("card_type")
    public final BankCardType getCardType() {
        return this.cardType;
    }

    @JsonProperty("expiry_month")
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    @JsonProperty("expiry_year")
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    public final String getFirst6() {
        return this.first6;
    }

    public final String getLast4() {
        return this.last4;
    }

    public final BankCardSourceResponse getSource() {
        return this.source;
    }

    public int hashCode() {
        String str = this.first6;
        int iHashCode = (this.cardType.hashCode() + AbstractC1553e.a(this.expiryMonth, AbstractC1553e.a(this.expiryYear, AbstractC1553e.a(this.last4, (str == null ? 0 : str.hashCode()) * 31, 31), 31), 31)) * 31;
        BankCardSourceResponse bankCardSourceResponse = this.source;
        return iHashCode + (bankCardSourceResponse != null ? bankCardSourceResponse.hashCode() : 0);
    }

    public String toString() {
        return "CardInfoResponse(first6=" + this.first6 + ", last4=" + this.last4 + ", expiryYear=" + this.expiryYear + ", expiryMonth=" + this.expiryMonth + ", cardType=" + this.cardType + ", source=" + this.source + ")";
    }
}
