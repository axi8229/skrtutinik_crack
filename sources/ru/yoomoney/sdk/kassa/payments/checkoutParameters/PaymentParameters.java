package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Keep
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0012HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u009b\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u00106\u001a\u000207HÖ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u000207HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000207HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006C"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentParameters;", "Landroid/os/Parcelable;", "amount", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "subtitle", "clientApplicationKey", "shopId", "savePaymentMethod", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/SavePaymentMethod;", "paymentMethodTypes", "", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "gatewayId", "customReturnUrl", "userPhoneNumber", "googlePayParameters", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/GooglePayParameters;", "authCenterClientId", "customerId", "(Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/SavePaymentMethod;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/GooglePayParameters;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "getAuthCenterClientId", "()Ljava/lang/String;", "getClientApplicationKey", "getCustomReturnUrl", "getCustomerId", "getGatewayId", "getGooglePayParameters", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/GooglePayParameters;", "getPaymentMethodTypes", "()Ljava/util/Set;", "getSavePaymentMethod", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/SavePaymentMethod;", "getShopId", "getSubtitle", "getTitle", "getUserPhoneNumber", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class PaymentParameters implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaymentParameters> CREATOR = new e();

    @Keep
    private final Amount amount;

    @Keep
    private final String authCenterClientId;

    @Keep
    private final String clientApplicationKey;

    @Keep
    private final String customReturnUrl;

    @Keep
    private final String customerId;

    @Keep
    private final String gatewayId;

    @Keep
    private final GooglePayParameters googlePayParameters;

    @Keep
    private final Set<PaymentMethodType> paymentMethodTypes;

    @Keep
    private final SavePaymentMethod savePaymentMethod;

    @Keep
    private final String shopId;

    @Keep
    private final String subtitle;

    @Keep
    private final String title;

    @Keep
    private final String userPhoneNumber;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public PaymentParameters(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, SavePaymentMethod savePaymentMethod) {
        this(amount, title, subtitle, clientApplicationKey, shopId, savePaymentMethod, null, null, null, null, null, null, null, 8128, null);
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
    }

    /* renamed from: component1, reason: from getter */
    public final Amount getAmount() {
        return this.amount;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUserPhoneNumber() {
        return this.userPhoneNumber;
    }

    /* renamed from: component11, reason: from getter */
    public final GooglePayParameters getGooglePayParameters() {
        return this.googlePayParameters;
    }

    /* renamed from: component12, reason: from getter */
    public final String getAuthCenterClientId() {
        return this.authCenterClientId;
    }

    /* renamed from: component13, reason: from getter */
    public final String getCustomerId() {
        return this.customerId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component4, reason: from getter */
    public final String getClientApplicationKey() {
        return this.clientApplicationKey;
    }

    /* renamed from: component5, reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    /* renamed from: component6, reason: from getter */
    public final SavePaymentMethod getSavePaymentMethod() {
        return this.savePaymentMethod;
    }

    public final Set<PaymentMethodType> component7() {
        return this.paymentMethodTypes;
    }

    /* renamed from: component8, reason: from getter */
    public final String getGatewayId() {
        return this.gatewayId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCustomReturnUrl() {
        return this.customReturnUrl;
    }

    public final PaymentParameters copy(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, SavePaymentMethod savePaymentMethod, Set<? extends PaymentMethodType> paymentMethodTypes, String gatewayId, String customReturnUrl, String userPhoneNumber, GooglePayParameters googlePayParameters, String authCenterClientId, String customerId) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodTypes, "paymentMethodTypes");
        Intrinsics.checkNotNullParameter(googlePayParameters, "googlePayParameters");
        return new PaymentParameters(amount, title, subtitle, clientApplicationKey, shopId, savePaymentMethod, paymentMethodTypes, gatewayId, customReturnUrl, userPhoneNumber, googlePayParameters, authCenterClientId, customerId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentParameters)) {
            return false;
        }
        PaymentParameters paymentParameters = (PaymentParameters) other;
        return Intrinsics.areEqual(this.amount, paymentParameters.amount) && Intrinsics.areEqual(this.title, paymentParameters.title) && Intrinsics.areEqual(this.subtitle, paymentParameters.subtitle) && Intrinsics.areEqual(this.clientApplicationKey, paymentParameters.clientApplicationKey) && Intrinsics.areEqual(this.shopId, paymentParameters.shopId) && this.savePaymentMethod == paymentParameters.savePaymentMethod && Intrinsics.areEqual(this.paymentMethodTypes, paymentParameters.paymentMethodTypes) && Intrinsics.areEqual(this.gatewayId, paymentParameters.gatewayId) && Intrinsics.areEqual(this.customReturnUrl, paymentParameters.customReturnUrl) && Intrinsics.areEqual(this.userPhoneNumber, paymentParameters.userPhoneNumber) && Intrinsics.areEqual(this.googlePayParameters, paymentParameters.googlePayParameters) && Intrinsics.areEqual(this.authCenterClientId, paymentParameters.authCenterClientId) && Intrinsics.areEqual(this.customerId, paymentParameters.customerId);
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final String getAuthCenterClientId() {
        return this.authCenterClientId;
    }

    public final String getClientApplicationKey() {
        return this.clientApplicationKey;
    }

    public final String getCustomReturnUrl() {
        return this.customReturnUrl;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final String getGatewayId() {
        return this.gatewayId;
    }

    public final GooglePayParameters getGooglePayParameters() {
        return this.googlePayParameters;
    }

    public final Set<PaymentMethodType> getPaymentMethodTypes() {
        return this.paymentMethodTypes;
    }

    public final SavePaymentMethod getSavePaymentMethod() {
        return this.savePaymentMethod;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUserPhoneNumber() {
        return this.userPhoneNumber;
    }

    public int hashCode() {
        int iHashCode = (this.paymentMethodTypes.hashCode() + ((this.savePaymentMethod.hashCode() + AbstractC1553e.a(this.shopId, AbstractC1553e.a(this.clientApplicationKey, AbstractC1553e.a(this.subtitle, AbstractC1553e.a(this.title, this.amount.hashCode() * 31, 31), 31), 31), 31)) * 31)) * 31;
        String str = this.gatewayId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.customReturnUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userPhoneNumber;
        int iHashCode4 = (this.googlePayParameters.hashCode() + ((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31;
        String str4 = this.authCenterClientId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.customerId;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "PaymentParameters(amount=" + this.amount + ", title=" + this.title + ", subtitle=" + this.subtitle + ", clientApplicationKey=" + this.clientApplicationKey + ", shopId=" + this.shopId + ", savePaymentMethod=" + this.savePaymentMethod + ", paymentMethodTypes=" + this.paymentMethodTypes + ", gatewayId=" + this.gatewayId + ", customReturnUrl=" + this.customReturnUrl + ", userPhoneNumber=" + this.userPhoneNumber + ", googlePayParameters=" + this.googlePayParameters + ", authCenterClientId=" + this.authCenterClientId + ", customerId=" + this.customerId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.amount.writeToParcel(parcel, flags);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.clientApplicationKey);
        parcel.writeString(this.shopId);
        parcel.writeString(this.savePaymentMethod.name());
        Set<PaymentMethodType> set = this.paymentMethodTypes;
        parcel.writeInt(set.size());
        Iterator<PaymentMethodType> it = set.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next().name());
        }
        parcel.writeString(this.gatewayId);
        parcel.writeString(this.customReturnUrl);
        parcel.writeString(this.userPhoneNumber);
        this.googlePayParameters.writeToParcel(parcel, flags);
        parcel.writeString(this.authCenterClientId);
        parcel.writeString(this.customerId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public PaymentParameters(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, SavePaymentMethod savePaymentMethod, Set<? extends PaymentMethodType> paymentMethodTypes) {
        this(amount, title, subtitle, clientApplicationKey, shopId, savePaymentMethod, paymentMethodTypes, null, null, null, null, null, null, 8064, null);
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodTypes, "paymentMethodTypes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public PaymentParameters(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, SavePaymentMethod savePaymentMethod, Set<? extends PaymentMethodType> paymentMethodTypes, String str) {
        this(amount, title, subtitle, clientApplicationKey, shopId, savePaymentMethod, paymentMethodTypes, str, null, null, null, null, null, 7936, null);
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodTypes, "paymentMethodTypes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public PaymentParameters(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, SavePaymentMethod savePaymentMethod, Set<? extends PaymentMethodType> paymentMethodTypes, String str, String str2) {
        this(amount, title, subtitle, clientApplicationKey, shopId, savePaymentMethod, paymentMethodTypes, str, str2, null, null, null, null, 7680, null);
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodTypes, "paymentMethodTypes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public PaymentParameters(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, SavePaymentMethod savePaymentMethod, Set<? extends PaymentMethodType> paymentMethodTypes, String str, String str2, String str3) {
        this(amount, title, subtitle, clientApplicationKey, shopId, savePaymentMethod, paymentMethodTypes, str, str2, str3, null, null, null, 7168, null);
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodTypes, "paymentMethodTypes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public PaymentParameters(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, SavePaymentMethod savePaymentMethod, Set<? extends PaymentMethodType> paymentMethodTypes, String str, String str2, String str3, GooglePayParameters googlePayParameters) {
        this(amount, title, subtitle, clientApplicationKey, shopId, savePaymentMethod, paymentMethodTypes, str, str2, str3, googlePayParameters, null, null, 6144, null);
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodTypes, "paymentMethodTypes");
        Intrinsics.checkNotNullParameter(googlePayParameters, "googlePayParameters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Keep
    public PaymentParameters(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, SavePaymentMethod savePaymentMethod, Set<? extends PaymentMethodType> paymentMethodTypes, String str, String str2, String str3, GooglePayParameters googlePayParameters, String str4) {
        this(amount, title, subtitle, clientApplicationKey, shopId, savePaymentMethod, paymentMethodTypes, str, str2, str3, googlePayParameters, str4, null, 4096, null);
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodTypes, "paymentMethodTypes");
        Intrinsics.checkNotNullParameter(googlePayParameters, "googlePayParameters");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Keep
    public PaymentParameters(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, SavePaymentMethod savePaymentMethod, Set<? extends PaymentMethodType> paymentMethodTypes, String str, String str2, String str3, GooglePayParameters googlePayParameters, String str4, String str5) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodTypes, "paymentMethodTypes");
        Intrinsics.checkNotNullParameter(googlePayParameters, "googlePayParameters");
        this.amount = amount;
        this.title = title;
        this.subtitle = subtitle;
        this.clientApplicationKey = clientApplicationKey;
        this.shopId = shopId;
        this.savePaymentMethod = savePaymentMethod;
        this.paymentMethodTypes = paymentMethodTypes;
        this.gatewayId = str;
        this.customReturnUrl = str2;
        this.userPhoneNumber = str3;
        this.googlePayParameters = googlePayParameters;
        this.authCenterClientId = str4;
        this.customerId = str5;
    }

    public /* synthetic */ PaymentParameters(Amount amount, String str, String str2, String str3, String str4, SavePaymentMethod savePaymentMethod, Set set, String str5, String str6, String str7, GooglePayParameters googlePayParameters, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(amount, str, str2, str3, str4, savePaymentMethod, (i & 64) != 0 ? ru.yoomoney.sdk.kassa.payments.utils.h.a() : set, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? new GooglePayParameters(null, 1, null) : googlePayParameters, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9);
    }
}
