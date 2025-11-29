package ru.yoomoney.sdk.kassa.payments.api.model.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentMethodTypeNetwork;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataSberbankRequest;", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/PaymentMethodDataRequest;", "type", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "phone", "", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "getType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentMethodDataSberbankRequest extends PaymentMethodDataRequest {
    public static final int $stable = 0;
    private final String phone;
    private final PaymentMethodTypeNetwork type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentMethodDataSberbankRequest(@JsonProperty("type") PaymentMethodTypeNetwork type, @JsonProperty("phone") String str) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.phone = str;
    }

    public static /* synthetic */ PaymentMethodDataSberbankRequest copy$default(PaymentMethodDataSberbankRequest paymentMethodDataSberbankRequest, PaymentMethodTypeNetwork paymentMethodTypeNetwork, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            paymentMethodTypeNetwork = paymentMethodDataSberbankRequest.type;
        }
        if ((i & 2) != 0) {
            str = paymentMethodDataSberbankRequest.phone;
        }
        return paymentMethodDataSberbankRequest.copy(paymentMethodTypeNetwork, str);
    }

    /* renamed from: component1, reason: from getter */
    public final PaymentMethodTypeNetwork getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    public final PaymentMethodDataSberbankRequest copy(@JsonProperty("type") PaymentMethodTypeNetwork type, @JsonProperty("phone") String phone) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new PaymentMethodDataSberbankRequest(type, phone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentMethodDataSberbankRequest)) {
            return false;
        }
        PaymentMethodDataSberbankRequest paymentMethodDataSberbankRequest = (PaymentMethodDataSberbankRequest) other;
        return this.type == paymentMethodDataSberbankRequest.type && Intrinsics.areEqual(this.phone, paymentMethodDataSberbankRequest.phone);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final PaymentMethodTypeNetwork getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.phone;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PaymentMethodDataSberbankRequest(type=" + this.type + ", phone=" + this.phone + ")";
    }
}
