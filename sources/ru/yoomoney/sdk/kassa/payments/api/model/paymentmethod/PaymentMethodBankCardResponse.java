package ru.yoomoney.sdk.kassa.payments.api.model.paymentmethod;

import com.fasterxml.jackson.annotation.JsonProperty;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentMethodTypeNetwork;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\t\u001a\u00020\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/PaymentMethodBankCardResponse;", "Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/PaymentMethodResponse;", "type", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "id", "", "saved", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "cscRequired", "card", "Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/CardInfoResponse;", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;Ljava/lang/String;ZLjava/lang/String;ZLru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/CardInfoResponse;)V", "getCard", "()Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/CardInfoResponse;", "getCscRequired", "()Z", "getId", "()Ljava/lang/String;", "getSaved", "getTitle", "getType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentMethodBankCardResponse extends PaymentMethodResponse {
    public static final int $stable = 0;
    private final CardInfoResponse card;
    private final boolean cscRequired;
    private final String id;
    private final boolean saved;
    private final String title;
    private final PaymentMethodTypeNetwork type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentMethodBankCardResponse(@JsonProperty("type") PaymentMethodTypeNetwork type, @JsonProperty("id") String id, @JsonProperty("saved") boolean z, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String str, @JsonProperty("csc_required") boolean z2, @JsonProperty("card") CardInfoResponse cardInfoResponse) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        this.type = type;
        this.id = id;
        this.saved = z;
        this.title = str;
        this.cscRequired = z2;
        this.card = cardInfoResponse;
    }

    public static /* synthetic */ PaymentMethodBankCardResponse copy$default(PaymentMethodBankCardResponse paymentMethodBankCardResponse, PaymentMethodTypeNetwork paymentMethodTypeNetwork, String str, boolean z, String str2, boolean z2, CardInfoResponse cardInfoResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            paymentMethodTypeNetwork = paymentMethodBankCardResponse.type;
        }
        if ((i & 2) != 0) {
            str = paymentMethodBankCardResponse.id;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            z = paymentMethodBankCardResponse.saved;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            str2 = paymentMethodBankCardResponse.title;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            z2 = paymentMethodBankCardResponse.cscRequired;
        }
        boolean z4 = z2;
        if ((i & 32) != 0) {
            cardInfoResponse = paymentMethodBankCardResponse.card;
        }
        return paymentMethodBankCardResponse.copy(paymentMethodTypeNetwork, str3, z3, str4, z4, cardInfoResponse);
    }

    /* renamed from: component1, reason: from getter */
    public final PaymentMethodTypeNetwork getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSaved() {
        return this.saved;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCscRequired() {
        return this.cscRequired;
    }

    /* renamed from: component6, reason: from getter */
    public final CardInfoResponse getCard() {
        return this.card;
    }

    public final PaymentMethodBankCardResponse copy(@JsonProperty("type") PaymentMethodTypeNetwork type, @JsonProperty("id") String id, @JsonProperty("saved") boolean saved, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String title, @JsonProperty("csc_required") boolean cscRequired, @JsonProperty("card") CardInfoResponse card) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        return new PaymentMethodBankCardResponse(type, id, saved, title, cscRequired, card);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentMethodBankCardResponse)) {
            return false;
        }
        PaymentMethodBankCardResponse paymentMethodBankCardResponse = (PaymentMethodBankCardResponse) other;
        return this.type == paymentMethodBankCardResponse.type && Intrinsics.areEqual(this.id, paymentMethodBankCardResponse.id) && this.saved == paymentMethodBankCardResponse.saved && Intrinsics.areEqual(this.title, paymentMethodBankCardResponse.title) && this.cscRequired == paymentMethodBankCardResponse.cscRequired && Intrinsics.areEqual(this.card, paymentMethodBankCardResponse.card);
    }

    public final CardInfoResponse getCard() {
        return this.card;
    }

    @JsonProperty("csc_required")
    public final boolean getCscRequired() {
        return this.cscRequired;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getSaved() {
        return this.saved;
    }

    public final String getTitle() {
        return this.title;
    }

    public final PaymentMethodTypeNetwork getType() {
        return this.type;
    }

    public int hashCode() {
        int iA = a.a(this.saved, AbstractC1553e.a(this.id, this.type.hashCode() * 31, 31), 31);
        String str = this.title;
        int iA2 = a.a(this.cscRequired, (iA + (str == null ? 0 : str.hashCode())) * 31, 31);
        CardInfoResponse cardInfoResponse = this.card;
        return iA2 + (cardInfoResponse != null ? cardInfoResponse.hashCode() : 0);
    }

    public String toString() {
        return "PaymentMethodBankCardResponse(type=" + this.type + ", id=" + this.id + ", saved=" + this.saved + ", title=" + this.title + ", cscRequired=" + this.cscRequired + ", card=" + this.card + ")";
    }
}
