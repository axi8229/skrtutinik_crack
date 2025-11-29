package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003J\t\u0010!\u001a\u00020\u000eHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010#\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentOptionSBP;", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentOptionResponse;", "paymentMethodType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "confirmationTypes", "", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "charge", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "fee", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "savePaymentMethod", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "savePaymentInstrument", "", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;Ljava/util/List;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;Z)V", "getCharge", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "getConfirmationTypes", "()Ljava/util/List;", "getFee", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "getPaymentMethodType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "getSavePaymentInstrument", "()Z", "getSavePaymentMethod", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentOptionSBP extends PaymentOptionResponse {
    public static final int $stable = 8;
    private final Amount charge;
    private final List<ConfirmationType> confirmationTypes;
    private final Fee fee;
    private final PaymentMethodTypeNetwork paymentMethodType;
    private final boolean savePaymentInstrument;
    private final SavePaymentMethod savePaymentMethod;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentOptionSBP(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("confirmation_types") List<? extends ConfirmationType> list, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("save_payment_instrument") boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        this.paymentMethodType = paymentMethodType;
        this.confirmationTypes = list;
        this.charge = charge;
        this.fee = fee;
        this.savePaymentMethod = savePaymentMethod;
        this.savePaymentInstrument = z;
    }

    public static /* synthetic */ PaymentOptionSBP copy$default(PaymentOptionSBP paymentOptionSBP, PaymentMethodTypeNetwork paymentMethodTypeNetwork, List list, Amount amount, Fee fee, SavePaymentMethod savePaymentMethod, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            paymentMethodTypeNetwork = paymentOptionSBP.paymentMethodType;
        }
        if ((i & 2) != 0) {
            list = paymentOptionSBP.confirmationTypes;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            amount = paymentOptionSBP.charge;
        }
        Amount amount2 = amount;
        if ((i & 8) != 0) {
            fee = paymentOptionSBP.fee;
        }
        Fee fee2 = fee;
        if ((i & 16) != 0) {
            savePaymentMethod = paymentOptionSBP.savePaymentMethod;
        }
        SavePaymentMethod savePaymentMethod2 = savePaymentMethod;
        if ((i & 32) != 0) {
            z = paymentOptionSBP.savePaymentInstrument;
        }
        return paymentOptionSBP.copy(paymentMethodTypeNetwork, list2, amount2, fee2, savePaymentMethod2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final PaymentMethodTypeNetwork getPaymentMethodType() {
        return this.paymentMethodType;
    }

    public final List<ConfirmationType> component2() {
        return this.confirmationTypes;
    }

    /* renamed from: component3, reason: from getter */
    public final Amount getCharge() {
        return this.charge;
    }

    /* renamed from: component4, reason: from getter */
    public final Fee getFee() {
        return this.fee;
    }

    /* renamed from: component5, reason: from getter */
    public final SavePaymentMethod getSavePaymentMethod() {
        return this.savePaymentMethod;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getSavePaymentInstrument() {
        return this.savePaymentInstrument;
    }

    public final PaymentOptionSBP copy(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("confirmation_types") List<? extends ConfirmationType> confirmationTypes, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("save_payment_instrument") boolean savePaymentInstrument) {
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        return new PaymentOptionSBP(paymentMethodType, confirmationTypes, charge, fee, savePaymentMethod, savePaymentInstrument);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentOptionSBP)) {
            return false;
        }
        PaymentOptionSBP paymentOptionSBP = (PaymentOptionSBP) other;
        return this.paymentMethodType == paymentOptionSBP.paymentMethodType && Intrinsics.areEqual(this.confirmationTypes, paymentOptionSBP.confirmationTypes) && Intrinsics.areEqual(this.charge, paymentOptionSBP.charge) && Intrinsics.areEqual(this.fee, paymentOptionSBP.fee) && this.savePaymentMethod == paymentOptionSBP.savePaymentMethod && this.savePaymentInstrument == paymentOptionSBP.savePaymentInstrument;
    }

    public final Amount getCharge() {
        return this.charge;
    }

    @JsonProperty("confirmation_types")
    public final List<ConfirmationType> getConfirmationTypes() {
        return this.confirmationTypes;
    }

    public final Fee getFee() {
        return this.fee;
    }

    @JsonProperty("payment_method_type")
    public final PaymentMethodTypeNetwork getPaymentMethodType() {
        return this.paymentMethodType;
    }

    @JsonProperty("save_payment_instrument")
    public final boolean getSavePaymentInstrument() {
        return this.savePaymentInstrument;
    }

    @JsonProperty("save_payment_method")
    public final SavePaymentMethod getSavePaymentMethod() {
        return this.savePaymentMethod;
    }

    public int hashCode() {
        int iHashCode = this.paymentMethodType.hashCode() * 31;
        List<ConfirmationType> list = this.confirmationTypes;
        int iHashCode2 = (this.charge.hashCode() + ((iHashCode + (list == null ? 0 : list.hashCode())) * 31)) * 31;
        Fee fee = this.fee;
        return Boolean.hashCode(this.savePaymentInstrument) + ((this.savePaymentMethod.hashCode() + ((iHashCode2 + (fee != null ? fee.hashCode() : 0)) * 31)) * 31);
    }

    public String toString() {
        return "PaymentOptionSBP(paymentMethodType=" + this.paymentMethodType + ", confirmationTypes=" + this.confirmationTypes + ", charge=" + this.charge + ", fee=" + this.fee + ", savePaymentMethod=" + this.savePaymentMethod + ", savePaymentInstrument=" + this.savePaymentInstrument + ")";
    }
}
