package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010+\u001a\u00020\u0012HÆ\u0003Je\u0010,\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0011\u001a\u00020\u00128\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\r\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000b\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentOptionGooglePay;", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentOptionResponse;", "paymentMethodType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "confirmationTypes", "", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "charge", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "fee", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "savePaymentMethod", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "savePaymentInstrument", "", "identificationRequirement", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;", "paymentSystemsAllowed", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;Ljava/util/List;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;ZLru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;)V", "getCharge", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "getConfirmationTypes", "()Ljava/util/List;", "getFee", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "getIdentificationRequirement", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;", "getPaymentMethodType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "getPaymentSystemsAllowed", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;", "getSavePaymentInstrument", "()Z", "getSavePaymentMethod", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentOptionGooglePay extends PaymentOptionResponse {
    public static final int $stable = 8;
    private final Amount charge;
    private final List<ConfirmationType> confirmationTypes;
    private final Fee fee;
    private final IdentificationRequirement identificationRequirement;
    private final PaymentMethodTypeNetwork paymentMethodType;
    private final BankCardType paymentSystemsAllowed;
    private final boolean savePaymentInstrument;
    private final SavePaymentMethod savePaymentMethod;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentOptionGooglePay(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("confirmation_types") List<? extends ConfirmationType> list, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("save_payment_instrument") boolean z, @JsonProperty("identification_requirement") IdentificationRequirement identificationRequirement, @JsonProperty("payment_systems_allowed") BankCardType paymentSystemsAllowed) {
        super(null);
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentSystemsAllowed, "paymentSystemsAllowed");
        this.paymentMethodType = paymentMethodType;
        this.confirmationTypes = list;
        this.charge = charge;
        this.fee = fee;
        this.savePaymentMethod = savePaymentMethod;
        this.savePaymentInstrument = z;
        this.identificationRequirement = identificationRequirement;
        this.paymentSystemsAllowed = paymentSystemsAllowed;
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

    /* renamed from: component7, reason: from getter */
    public final IdentificationRequirement getIdentificationRequirement() {
        return this.identificationRequirement;
    }

    /* renamed from: component8, reason: from getter */
    public final BankCardType getPaymentSystemsAllowed() {
        return this.paymentSystemsAllowed;
    }

    public final PaymentOptionGooglePay copy(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("confirmation_types") List<? extends ConfirmationType> confirmationTypes, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("save_payment_instrument") boolean savePaymentInstrument, @JsonProperty("identification_requirement") IdentificationRequirement identificationRequirement, @JsonProperty("payment_systems_allowed") BankCardType paymentSystemsAllowed) {
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentSystemsAllowed, "paymentSystemsAllowed");
        return new PaymentOptionGooglePay(paymentMethodType, confirmationTypes, charge, fee, savePaymentMethod, savePaymentInstrument, identificationRequirement, paymentSystemsAllowed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentOptionGooglePay)) {
            return false;
        }
        PaymentOptionGooglePay paymentOptionGooglePay = (PaymentOptionGooglePay) other;
        return this.paymentMethodType == paymentOptionGooglePay.paymentMethodType && Intrinsics.areEqual(this.confirmationTypes, paymentOptionGooglePay.confirmationTypes) && Intrinsics.areEqual(this.charge, paymentOptionGooglePay.charge) && Intrinsics.areEqual(this.fee, paymentOptionGooglePay.fee) && this.savePaymentMethod == paymentOptionGooglePay.savePaymentMethod && this.savePaymentInstrument == paymentOptionGooglePay.savePaymentInstrument && this.identificationRequirement == paymentOptionGooglePay.identificationRequirement && this.paymentSystemsAllowed == paymentOptionGooglePay.paymentSystemsAllowed;
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

    @JsonProperty("identification_requirement")
    public final IdentificationRequirement getIdentificationRequirement() {
        return this.identificationRequirement;
    }

    @JsonProperty("payment_method_type")
    public final PaymentMethodTypeNetwork getPaymentMethodType() {
        return this.paymentMethodType;
    }

    @JsonProperty("payment_systems_allowed")
    public final BankCardType getPaymentSystemsAllowed() {
        return this.paymentSystemsAllowed;
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
        int iA = a.a(this.savePaymentInstrument, (this.savePaymentMethod.hashCode() + ((iHashCode2 + (fee == null ? 0 : fee.hashCode())) * 31)) * 31, 31);
        IdentificationRequirement identificationRequirement = this.identificationRequirement;
        return this.paymentSystemsAllowed.hashCode() + ((iA + (identificationRequirement != null ? identificationRequirement.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "PaymentOptionGooglePay(paymentMethodType=" + this.paymentMethodType + ", confirmationTypes=" + this.confirmationTypes + ", charge=" + this.charge + ", fee=" + this.fee + ", savePaymentMethod=" + this.savePaymentMethod + ", savePaymentInstrument=" + this.savePaymentInstrument + ", identificationRequirement=" + this.identificationRequirement + ", paymentSystemsAllowed=" + this.paymentSystemsAllowed + ")";
    }
}
