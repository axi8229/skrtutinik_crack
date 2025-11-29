package ru.yoomoney.sdk.kassa.payments.api.model.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardViewKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/tokens/CardRequest;", "", "number", "", BankCardViewKt.EXTRA_EXPIRY_YEAR, BankCardViewKt.EXTRA_EXPIRY_MONTH, "csc", "cardType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardType", "()Ljava/lang/String;", "getCsc", "getExpiryMonth", "getExpiryYear", "getNumber", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CardRequest {
    public static final int $stable = 0;
    private final String cardType;
    private final String csc;
    private final String expiryMonth;
    private final String expiryYear;
    private final String number;

    public CardRequest(@JsonProperty("number") String number, @JsonProperty("expiry_year") String expiryYear, @JsonProperty("expiry_month") String expiryMonth, @JsonProperty("csc") String csc, @JsonProperty("cardholder") String str) {
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(expiryYear, "expiryYear");
        Intrinsics.checkNotNullParameter(expiryMonth, "expiryMonth");
        Intrinsics.checkNotNullParameter(csc, "csc");
        this.number = number;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        this.csc = csc;
        this.cardType = str;
    }

    public static /* synthetic */ CardRequest copy$default(CardRequest cardRequest, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardRequest.number;
        }
        if ((i & 2) != 0) {
            str2 = cardRequest.expiryYear;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = cardRequest.expiryMonth;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = cardRequest.csc;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = cardRequest.cardType;
        }
        return cardRequest.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    /* renamed from: component2, reason: from getter */
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCsc() {
        return this.csc;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCardType() {
        return this.cardType;
    }

    public final CardRequest copy(@JsonProperty("number") String number, @JsonProperty("expiry_year") String expiryYear, @JsonProperty("expiry_month") String expiryMonth, @JsonProperty("csc") String csc, @JsonProperty("cardholder") String cardType) {
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(expiryYear, "expiryYear");
        Intrinsics.checkNotNullParameter(expiryMonth, "expiryMonth");
        Intrinsics.checkNotNullParameter(csc, "csc");
        return new CardRequest(number, expiryYear, expiryMonth, csc, cardType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardRequest)) {
            return false;
        }
        CardRequest cardRequest = (CardRequest) other;
        return Intrinsics.areEqual(this.number, cardRequest.number) && Intrinsics.areEqual(this.expiryYear, cardRequest.expiryYear) && Intrinsics.areEqual(this.expiryMonth, cardRequest.expiryMonth) && Intrinsics.areEqual(this.csc, cardRequest.csc) && Intrinsics.areEqual(this.cardType, cardRequest.cardType);
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final String getCsc() {
        return this.csc;
    }

    @JsonProperty("expiry_month")
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    @JsonProperty("expiry_year")
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    public final String getNumber() {
        return this.number;
    }

    public int hashCode() {
        int iA = AbstractC1553e.a(this.csc, AbstractC1553e.a(this.expiryMonth, AbstractC1553e.a(this.expiryYear, this.number.hashCode() * 31, 31), 31), 31);
        String str = this.cardType;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CardRequest(number=" + this.number + ", expiryYear=" + this.expiryYear + ", expiryMonth=" + this.expiryMonth + ", csc=" + this.csc + ", cardType=" + this.cardType + ")";
    }
}
