package ru.yoomoney.sdk.kassa.payments.api.model.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.InstrumentType;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentMethodTypeNetwork;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataYooMoneyWalletRequest;", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataRequest;", "type", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "instrumentType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;)V", "getInstrumentType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;", "getType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentMethodDataYooMoneyWalletRequest extends PaymentMethodDataRequest {
    public static final int $stable = 0;
    private final InstrumentType instrumentType;
    private final PaymentMethodTypeNetwork type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentMethodDataYooMoneyWalletRequest(@JsonProperty("type") PaymentMethodTypeNetwork type, @JsonProperty("instrument_type") InstrumentType instrumentType) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(instrumentType, "instrumentType");
        this.type = type;
        this.instrumentType = instrumentType;
    }

    public static /* synthetic */ PaymentMethodDataYooMoneyWalletRequest copy$default(PaymentMethodDataYooMoneyWalletRequest paymentMethodDataYooMoneyWalletRequest, PaymentMethodTypeNetwork paymentMethodTypeNetwork, InstrumentType instrumentType, int i, Object obj) {
        if ((i & 1) != 0) {
            paymentMethodTypeNetwork = paymentMethodDataYooMoneyWalletRequest.type;
        }
        if ((i & 2) != 0) {
            instrumentType = paymentMethodDataYooMoneyWalletRequest.instrumentType;
        }
        return paymentMethodDataYooMoneyWalletRequest.copy(paymentMethodTypeNetwork, instrumentType);
    }

    /* renamed from: component1, reason: from getter */
    public final PaymentMethodTypeNetwork getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public final PaymentMethodDataYooMoneyWalletRequest copy(@JsonProperty("type") PaymentMethodTypeNetwork type, @JsonProperty("instrument_type") InstrumentType instrumentType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(instrumentType, "instrumentType");
        return new PaymentMethodDataYooMoneyWalletRequest(type, instrumentType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentMethodDataYooMoneyWalletRequest)) {
            return false;
        }
        PaymentMethodDataYooMoneyWalletRequest paymentMethodDataYooMoneyWalletRequest = (PaymentMethodDataYooMoneyWalletRequest) other;
        return this.type == paymentMethodDataYooMoneyWalletRequest.type && this.instrumentType == paymentMethodDataYooMoneyWalletRequest.instrumentType;
    }

    @JsonProperty("instrument_type")
    public final InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public final PaymentMethodTypeNetwork getType() {
        return this.type;
    }

    public int hashCode() {
        return this.instrumentType.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        return "PaymentMethodDataYooMoneyWalletRequest(type=" + this.type + ", instrumentType=" + this.instrumentType + ")";
    }
}
