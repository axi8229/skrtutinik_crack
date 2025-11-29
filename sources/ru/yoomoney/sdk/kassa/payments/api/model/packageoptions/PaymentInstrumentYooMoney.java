package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney;", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentOptionResponse;", "()V", "AbstractYooMoneyWallet", "PaymentInstrumentYooMoneyLinkedBankCard", "PaymentInstrumentYooMoneyWallet", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney$AbstractYooMoneyWallet;", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney$PaymentInstrumentYooMoneyLinkedBankCard;", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney$PaymentInstrumentYooMoneyWallet;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PaymentInstrumentYooMoney extends PaymentOptionResponse {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000eHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0003\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010#\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney$AbstractYooMoneyWallet;", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney;", "paymentMethodType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "charge", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "fee", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "savePaymentMethod", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "confirmationTypes", "", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "savePaymentInstrument", "", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;Ljava/util/List;Z)V", "getCharge", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "getConfirmationTypes", "()Ljava/util/List;", "getFee", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "getPaymentMethodType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "getSavePaymentInstrument", "()Z", "getSavePaymentMethod", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AbstractYooMoneyWallet extends PaymentInstrumentYooMoney {
        public static final int $stable = 8;
        private final Amount charge;
        private final List<ConfirmationType> confirmationTypes;
        private final Fee fee;
        private final PaymentMethodTypeNetwork paymentMethodType;
        private final boolean savePaymentInstrument;
        private final SavePaymentMethod savePaymentMethod;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AbstractYooMoneyWallet(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("confirmation_types") List<? extends ConfirmationType> list, @JsonProperty("save_payment_instrument") boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
            Intrinsics.checkNotNullParameter(charge, "charge");
            Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
            this.paymentMethodType = paymentMethodType;
            this.charge = charge;
            this.fee = fee;
            this.savePaymentMethod = savePaymentMethod;
            this.confirmationTypes = list;
            this.savePaymentInstrument = z;
        }

        public static /* synthetic */ AbstractYooMoneyWallet copy$default(AbstractYooMoneyWallet abstractYooMoneyWallet, PaymentMethodTypeNetwork paymentMethodTypeNetwork, Amount amount, Fee fee, SavePaymentMethod savePaymentMethod, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentMethodTypeNetwork = abstractYooMoneyWallet.paymentMethodType;
            }
            if ((i & 2) != 0) {
                amount = abstractYooMoneyWallet.charge;
            }
            Amount amount2 = amount;
            if ((i & 4) != 0) {
                fee = abstractYooMoneyWallet.fee;
            }
            Fee fee2 = fee;
            if ((i & 8) != 0) {
                savePaymentMethod = abstractYooMoneyWallet.savePaymentMethod;
            }
            SavePaymentMethod savePaymentMethod2 = savePaymentMethod;
            if ((i & 16) != 0) {
                list = abstractYooMoneyWallet.confirmationTypes;
            }
            List list2 = list;
            if ((i & 32) != 0) {
                z = abstractYooMoneyWallet.savePaymentInstrument;
            }
            return abstractYooMoneyWallet.copy(paymentMethodTypeNetwork, amount2, fee2, savePaymentMethod2, list2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final PaymentMethodTypeNetwork getPaymentMethodType() {
            return this.paymentMethodType;
        }

        /* renamed from: component2, reason: from getter */
        public final Amount getCharge() {
            return this.charge;
        }

        /* renamed from: component3, reason: from getter */
        public final Fee getFee() {
            return this.fee;
        }

        /* renamed from: component4, reason: from getter */
        public final SavePaymentMethod getSavePaymentMethod() {
            return this.savePaymentMethod;
        }

        public final List<ConfirmationType> component5() {
            return this.confirmationTypes;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getSavePaymentInstrument() {
            return this.savePaymentInstrument;
        }

        public final AbstractYooMoneyWallet copy(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("confirmation_types") List<? extends ConfirmationType> confirmationTypes, @JsonProperty("save_payment_instrument") boolean savePaymentInstrument) {
            Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
            Intrinsics.checkNotNullParameter(charge, "charge");
            Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
            return new AbstractYooMoneyWallet(paymentMethodType, charge, fee, savePaymentMethod, confirmationTypes, savePaymentInstrument);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AbstractYooMoneyWallet)) {
                return false;
            }
            AbstractYooMoneyWallet abstractYooMoneyWallet = (AbstractYooMoneyWallet) other;
            return this.paymentMethodType == abstractYooMoneyWallet.paymentMethodType && Intrinsics.areEqual(this.charge, abstractYooMoneyWallet.charge) && Intrinsics.areEqual(this.fee, abstractYooMoneyWallet.fee) && this.savePaymentMethod == abstractYooMoneyWallet.savePaymentMethod && Intrinsics.areEqual(this.confirmationTypes, abstractYooMoneyWallet.confirmationTypes) && this.savePaymentInstrument == abstractYooMoneyWallet.savePaymentInstrument;
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
            int iHashCode = (this.charge.hashCode() + (this.paymentMethodType.hashCode() * 31)) * 31;
            Fee fee = this.fee;
            int iHashCode2 = (this.savePaymentMethod.hashCode() + ((iHashCode + (fee == null ? 0 : fee.hashCode())) * 31)) * 31;
            List<ConfirmationType> list = this.confirmationTypes;
            return Boolean.hashCode(this.savePaymentInstrument) + ((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31);
        }

        public String toString() {
            return "AbstractYooMoneyWallet(paymentMethodType=" + this.paymentMethodType + ", charge=" + this.charge + ", fee=" + this.fee + ", savePaymentMethod=" + this.savePaymentMethod + ", confirmationTypes=" + this.confirmationTypes + ", savePaymentInstrument=" + this.savePaymentInstrument + ")";
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u00102\u001a\u00020\u0014HÆ\u0003J\t\u00103\u001a\u00020\u0018HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0012HÆ\u0003J\t\u0010;\u001a\u00020\u0014HÆ\u0003J\u008f\u0001\u0010<\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00122\b\b\u0003\u0010\u0013\u001a\u00020\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0003\u0010\u0016\u001a\u00020\u00142\b\b\u0003\u0010\u0017\u001a\u00020\u0018HÆ\u0001J\u0013\u0010=\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0016\u001a\u00020\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0017\u001a\u00020\u00188\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0011\u001a\u00020\u00128\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\r\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u000b\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006C"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney$PaymentInstrumentYooMoneyLinkedBankCard;", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney;", "paymentMethodType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "confirmationTypes", "", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "charge", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "fee", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "savePaymentMethod", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "savePaymentInstrument", "", "identificationRequirement", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;", "instrumentType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;", "id", "", "cardName", "cardMask", "cardType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;Ljava/util/List;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;ZLru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;)V", "getCardMask", "()Ljava/lang/String;", "getCardName", "getCardType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/BankCardType;", "getCharge", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "getConfirmationTypes", "()Ljava/util/List;", "getFee", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "getId", "getIdentificationRequirement", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;", "getInstrumentType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;", "getPaymentMethodType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "getSavePaymentInstrument", "()Z", "getSavePaymentMethod", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PaymentInstrumentYooMoneyLinkedBankCard extends PaymentInstrumentYooMoney {
        public static final int $stable = 8;
        private final String cardMask;
        private final String cardName;
        private final BankCardType cardType;
        private final Amount charge;
        private final List<ConfirmationType> confirmationTypes;
        private final Fee fee;
        private final String id;
        private final IdentificationRequirement identificationRequirement;
        private final InstrumentType instrumentType;
        private final PaymentMethodTypeNetwork paymentMethodType;
        private final boolean savePaymentInstrument;
        private final SavePaymentMethod savePaymentMethod;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PaymentInstrumentYooMoneyLinkedBankCard(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("confirmation_types") List<? extends ConfirmationType> list, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("save_payment_instrument") boolean z, @JsonProperty("identification_requirement") IdentificationRequirement identificationRequirement, @JsonProperty("instrument_type") InstrumentType instrumentType, @JsonProperty("id") String id, @JsonProperty("card_name") String str, @JsonProperty("card_mask") String cardMask, @JsonProperty("card_type") BankCardType cardType) {
            super(null);
            Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
            Intrinsics.checkNotNullParameter(charge, "charge");
            Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
            Intrinsics.checkNotNullParameter(instrumentType, "instrumentType");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(cardMask, "cardMask");
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            this.paymentMethodType = paymentMethodType;
            this.confirmationTypes = list;
            this.charge = charge;
            this.fee = fee;
            this.savePaymentMethod = savePaymentMethod;
            this.savePaymentInstrument = z;
            this.identificationRequirement = identificationRequirement;
            this.instrumentType = instrumentType;
            this.id = id;
            this.cardName = str;
            this.cardMask = cardMask;
            this.cardType = cardType;
        }

        /* renamed from: component1, reason: from getter */
        public final PaymentMethodTypeNetwork getPaymentMethodType() {
            return this.paymentMethodType;
        }

        /* renamed from: component10, reason: from getter */
        public final String getCardName() {
            return this.cardName;
        }

        /* renamed from: component11, reason: from getter */
        public final String getCardMask() {
            return this.cardMask;
        }

        /* renamed from: component12, reason: from getter */
        public final BankCardType getCardType() {
            return this.cardType;
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
        public final InstrumentType getInstrumentType() {
            return this.instrumentType;
        }

        /* renamed from: component9, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final PaymentInstrumentYooMoneyLinkedBankCard copy(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("confirmation_types") List<? extends ConfirmationType> confirmationTypes, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("save_payment_instrument") boolean savePaymentInstrument, @JsonProperty("identification_requirement") IdentificationRequirement identificationRequirement, @JsonProperty("instrument_type") InstrumentType instrumentType, @JsonProperty("id") String id, @JsonProperty("card_name") String cardName, @JsonProperty("card_mask") String cardMask, @JsonProperty("card_type") BankCardType cardType) {
            Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
            Intrinsics.checkNotNullParameter(charge, "charge");
            Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
            Intrinsics.checkNotNullParameter(instrumentType, "instrumentType");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(cardMask, "cardMask");
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            return new PaymentInstrumentYooMoneyLinkedBankCard(paymentMethodType, confirmationTypes, charge, fee, savePaymentMethod, savePaymentInstrument, identificationRequirement, instrumentType, id, cardName, cardMask, cardType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaymentInstrumentYooMoneyLinkedBankCard)) {
                return false;
            }
            PaymentInstrumentYooMoneyLinkedBankCard paymentInstrumentYooMoneyLinkedBankCard = (PaymentInstrumentYooMoneyLinkedBankCard) other;
            return this.paymentMethodType == paymentInstrumentYooMoneyLinkedBankCard.paymentMethodType && Intrinsics.areEqual(this.confirmationTypes, paymentInstrumentYooMoneyLinkedBankCard.confirmationTypes) && Intrinsics.areEqual(this.charge, paymentInstrumentYooMoneyLinkedBankCard.charge) && Intrinsics.areEqual(this.fee, paymentInstrumentYooMoneyLinkedBankCard.fee) && this.savePaymentMethod == paymentInstrumentYooMoneyLinkedBankCard.savePaymentMethod && this.savePaymentInstrument == paymentInstrumentYooMoneyLinkedBankCard.savePaymentInstrument && this.identificationRequirement == paymentInstrumentYooMoneyLinkedBankCard.identificationRequirement && this.instrumentType == paymentInstrumentYooMoneyLinkedBankCard.instrumentType && Intrinsics.areEqual(this.id, paymentInstrumentYooMoneyLinkedBankCard.id) && Intrinsics.areEqual(this.cardName, paymentInstrumentYooMoneyLinkedBankCard.cardName) && Intrinsics.areEqual(this.cardMask, paymentInstrumentYooMoneyLinkedBankCard.cardMask) && this.cardType == paymentInstrumentYooMoneyLinkedBankCard.cardType;
        }

        @JsonProperty("card_mask")
        public final String getCardMask() {
            return this.cardMask;
        }

        @JsonProperty("card_name")
        public final String getCardName() {
            return this.cardName;
        }

        @JsonProperty("card_type")
        public final BankCardType getCardType() {
            return this.cardType;
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

        public final String getId() {
            return this.id;
        }

        @JsonProperty("identification_requirement")
        public final IdentificationRequirement getIdentificationRequirement() {
            return this.identificationRequirement;
        }

        @JsonProperty("instrument_type")
        public final InstrumentType getInstrumentType() {
            return this.instrumentType;
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
            int iA = a.a(this.savePaymentInstrument, (this.savePaymentMethod.hashCode() + ((iHashCode2 + (fee == null ? 0 : fee.hashCode())) * 31)) * 31, 31);
            IdentificationRequirement identificationRequirement = this.identificationRequirement;
            int iA2 = AbstractC1553e.a(this.id, (this.instrumentType.hashCode() + ((iA + (identificationRequirement == null ? 0 : identificationRequirement.hashCode())) * 31)) * 31, 31);
            String str = this.cardName;
            return this.cardType.hashCode() + AbstractC1553e.a(this.cardMask, (iA2 + (str != null ? str.hashCode() : 0)) * 31, 31);
        }

        public String toString() {
            return "PaymentInstrumentYooMoneyLinkedBankCard(paymentMethodType=" + this.paymentMethodType + ", confirmationTypes=" + this.confirmationTypes + ", charge=" + this.charge + ", fee=" + this.fee + ", savePaymentMethod=" + this.savePaymentMethod + ", savePaymentInstrument=" + this.savePaymentInstrument + ", identificationRequirement=" + this.identificationRequirement + ", instrumentType=" + this.instrumentType + ", id=" + this.id + ", cardName=" + this.cardName + ", cardMask=" + this.cardMask + ", cardType=" + this.cardType + ")";
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00102\u001a\u00020\u0012HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0014HÆ\u0003J}\u00104\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00122\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001b\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0011\u001a\u00020\u00128\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\r\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u000b\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006;"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney$PaymentInstrumentYooMoneyWallet;", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentInstrumentYooMoney;", "paymentMethodType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "confirmationTypes", "", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "charge", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "fee", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "savePaymentMethod", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "savePaymentInstrument", "", "identificationRequirement", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;", "instrumentType", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;", "id", "", "balance", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;Ljava/util/List;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;ZLru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;)V", "getBalance", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Amount;", "getCharge", "getConfirmationTypes", "()Ljava/util/List;", "getFee", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/Fee;", "getId", "()Ljava/lang/String;", "getIdentificationRequirement", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/IdentificationRequirement;", "getInstrumentType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/InstrumentType;", "getPaymentMethodType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentMethodTypeNetwork;", "getSavePaymentInstrument", "()Z", "getSavePaymentMethod", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/SavePaymentMethod;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PaymentInstrumentYooMoneyWallet extends PaymentInstrumentYooMoney {
        public static final int $stable = 8;
        private final Amount balance;
        private final Amount charge;
        private final List<ConfirmationType> confirmationTypes;
        private final Fee fee;
        private final String id;
        private final IdentificationRequirement identificationRequirement;
        private final InstrumentType instrumentType;
        private final PaymentMethodTypeNetwork paymentMethodType;
        private final boolean savePaymentInstrument;
        private final SavePaymentMethod savePaymentMethod;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PaymentInstrumentYooMoneyWallet(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("confirmation_types") List<? extends ConfirmationType> list, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("save_payment_instrument") boolean z, @JsonProperty("identification_requirement") IdentificationRequirement identificationRequirement, @JsonProperty("instrument_type") InstrumentType instrumentType, @JsonProperty("id") String str, @JsonProperty("balance") Amount amount) {
            super(null);
            Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
            Intrinsics.checkNotNullParameter(charge, "charge");
            Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
            Intrinsics.checkNotNullParameter(instrumentType, "instrumentType");
            this.paymentMethodType = paymentMethodType;
            this.confirmationTypes = list;
            this.charge = charge;
            this.fee = fee;
            this.savePaymentMethod = savePaymentMethod;
            this.savePaymentInstrument = z;
            this.identificationRequirement = identificationRequirement;
            this.instrumentType = instrumentType;
            this.id = str;
            this.balance = amount;
        }

        /* renamed from: component1, reason: from getter */
        public final PaymentMethodTypeNetwork getPaymentMethodType() {
            return this.paymentMethodType;
        }

        /* renamed from: component10, reason: from getter */
        public final Amount getBalance() {
            return this.balance;
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
        public final InstrumentType getInstrumentType() {
            return this.instrumentType;
        }

        /* renamed from: component9, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final PaymentInstrumentYooMoneyWallet copy(@JsonProperty("payment_method_type") PaymentMethodTypeNetwork paymentMethodType, @JsonProperty("confirmation_types") List<? extends ConfirmationType> confirmationTypes, @JsonProperty("charge") Amount charge, @JsonProperty("fee") Fee fee, @JsonProperty("save_payment_method") SavePaymentMethod savePaymentMethod, @JsonProperty("save_payment_instrument") boolean savePaymentInstrument, @JsonProperty("identification_requirement") IdentificationRequirement identificationRequirement, @JsonProperty("instrument_type") InstrumentType instrumentType, @JsonProperty("id") String id, @JsonProperty("balance") Amount balance) {
            Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
            Intrinsics.checkNotNullParameter(charge, "charge");
            Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
            Intrinsics.checkNotNullParameter(instrumentType, "instrumentType");
            return new PaymentInstrumentYooMoneyWallet(paymentMethodType, confirmationTypes, charge, fee, savePaymentMethod, savePaymentInstrument, identificationRequirement, instrumentType, id, balance);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaymentInstrumentYooMoneyWallet)) {
                return false;
            }
            PaymentInstrumentYooMoneyWallet paymentInstrumentYooMoneyWallet = (PaymentInstrumentYooMoneyWallet) other;
            return this.paymentMethodType == paymentInstrumentYooMoneyWallet.paymentMethodType && Intrinsics.areEqual(this.confirmationTypes, paymentInstrumentYooMoneyWallet.confirmationTypes) && Intrinsics.areEqual(this.charge, paymentInstrumentYooMoneyWallet.charge) && Intrinsics.areEqual(this.fee, paymentInstrumentYooMoneyWallet.fee) && this.savePaymentMethod == paymentInstrumentYooMoneyWallet.savePaymentMethod && this.savePaymentInstrument == paymentInstrumentYooMoneyWallet.savePaymentInstrument && this.identificationRequirement == paymentInstrumentYooMoneyWallet.identificationRequirement && this.instrumentType == paymentInstrumentYooMoneyWallet.instrumentType && Intrinsics.areEqual(this.id, paymentInstrumentYooMoneyWallet.id) && Intrinsics.areEqual(this.balance, paymentInstrumentYooMoneyWallet.balance);
        }

        public final Amount getBalance() {
            return this.balance;
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

        public final String getId() {
            return this.id;
        }

        @JsonProperty("identification_requirement")
        public final IdentificationRequirement getIdentificationRequirement() {
            return this.identificationRequirement;
        }

        @JsonProperty("instrument_type")
        public final InstrumentType getInstrumentType() {
            return this.instrumentType;
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
            int iA = a.a(this.savePaymentInstrument, (this.savePaymentMethod.hashCode() + ((iHashCode2 + (fee == null ? 0 : fee.hashCode())) * 31)) * 31, 31);
            IdentificationRequirement identificationRequirement = this.identificationRequirement;
            int iHashCode3 = (this.instrumentType.hashCode() + ((iA + (identificationRequirement == null ? 0 : identificationRequirement.hashCode())) * 31)) * 31;
            String str = this.id;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Amount amount = this.balance;
            return iHashCode4 + (amount != null ? amount.hashCode() : 0);
        }

        public String toString() {
            return "PaymentInstrumentYooMoneyWallet(paymentMethodType=" + this.paymentMethodType + ", confirmationTypes=" + this.confirmationTypes + ", charge=" + this.charge + ", fee=" + this.fee + ", savePaymentMethod=" + this.savePaymentMethod + ", savePaymentInstrument=" + this.savePaymentInstrument + ", identificationRequirement=" + this.identificationRequirement + ", instrumentType=" + this.instrumentType + ", id=" + this.id + ", balance=" + this.balance + ")";
        }
    }

    private PaymentInstrumentYooMoney() {
        super(null);
    }

    public /* synthetic */ PaymentInstrumentYooMoney(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
