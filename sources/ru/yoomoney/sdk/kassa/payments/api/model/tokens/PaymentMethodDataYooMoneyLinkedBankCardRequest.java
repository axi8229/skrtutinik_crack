package ru.yoomoney.sdk.kassa.payments.api.model.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.InstrumentType;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentMethodTypeNetwork;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataYooMoneyLinkedBankCardRequest;", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataRequest;", "id", "", "type", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "instrumentType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;", "csc", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;Ljava/lang/String;)V", "getCsc", "()Ljava/lang/String;", "getId", "getInstrumentType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;", "getType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentMethodDataYooMoneyLinkedBankCardRequest extends PaymentMethodDataRequest {
    public static final int $stable = 0;
    private final String csc;
    private final String id;
    private final InstrumentType instrumentType;
    private final PaymentMethodTypeNetwork type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentMethodDataYooMoneyLinkedBankCardRequest(@JsonProperty("id") String id, @JsonProperty("type") PaymentMethodTypeNetwork type, @JsonProperty("instrument_type") InstrumentType instrumentType, @JsonProperty("csc") String csc) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(instrumentType, "instrumentType");
        Intrinsics.checkNotNullParameter(csc, "csc");
        this.id = id;
        this.type = type;
        this.instrumentType = instrumentType;
        this.csc = csc;
    }

    public static /* synthetic */ PaymentMethodDataYooMoneyLinkedBankCardRequest copy$default(PaymentMethodDataYooMoneyLinkedBankCardRequest paymentMethodDataYooMoneyLinkedBankCardRequest, String str, PaymentMethodTypeNetwork paymentMethodTypeNetwork, InstrumentType instrumentType, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentMethodDataYooMoneyLinkedBankCardRequest.id;
        }
        if ((i & 2) != 0) {
            paymentMethodTypeNetwork = paymentMethodDataYooMoneyLinkedBankCardRequest.type;
        }
        if ((i & 4) != 0) {
            instrumentType = paymentMethodDataYooMoneyLinkedBankCardRequest.instrumentType;
        }
        if ((i & 8) != 0) {
            str2 = paymentMethodDataYooMoneyLinkedBankCardRequest.csc;
        }
        return paymentMethodDataYooMoneyLinkedBankCardRequest.copy(str, paymentMethodTypeNetwork, instrumentType, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final PaymentMethodTypeNetwork getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCsc() {
        return this.csc;
    }

    public final PaymentMethodDataYooMoneyLinkedBankCardRequest copy(@JsonProperty("id") String id, @JsonProperty("type") PaymentMethodTypeNetwork type, @JsonProperty("instrument_type") InstrumentType instrumentType, @JsonProperty("csc") String csc) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(instrumentType, "instrumentType");
        Intrinsics.checkNotNullParameter(csc, "csc");
        return new PaymentMethodDataYooMoneyLinkedBankCardRequest(id, type, instrumentType, csc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentMethodDataYooMoneyLinkedBankCardRequest)) {
            return false;
        }
        PaymentMethodDataYooMoneyLinkedBankCardRequest paymentMethodDataYooMoneyLinkedBankCardRequest = (PaymentMethodDataYooMoneyLinkedBankCardRequest) other;
        return Intrinsics.areEqual(this.id, paymentMethodDataYooMoneyLinkedBankCardRequest.id) && this.type == paymentMethodDataYooMoneyLinkedBankCardRequest.type && this.instrumentType == paymentMethodDataYooMoneyLinkedBankCardRequest.instrumentType && Intrinsics.areEqual(this.csc, paymentMethodDataYooMoneyLinkedBankCardRequest.csc);
    }

    public final String getCsc() {
        return this.csc;
    }

    public final String getId() {
        return this.id;
    }

    @JsonProperty("instrument_type")
    public final InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public final PaymentMethodTypeNetwork getType() {
        return this.type;
    }

    public int hashCode() {
        return this.csc.hashCode() + ((this.instrumentType.hashCode() + ((this.type.hashCode() + (this.id.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "PaymentMethodDataYooMoneyLinkedBankCardRequest(id=" + this.id + ", type=" + this.type + ", instrumentType=" + this.instrumentType + ", csc=" + this.csc + ")";
    }
}
