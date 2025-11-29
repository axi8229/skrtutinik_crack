package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006/"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/SavedBankCardPaymentParameters;", "Landroid/os/Parcelable;", "amount", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "subtitle", "clientApplicationKey", "shopId", "paymentMethodId", "savePaymentMethod", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/SavePaymentMethod;", "gatewayId", "(Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/SavePaymentMethod;Ljava/lang/String;)V", "getAmount", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "getClientApplicationKey", "()Ljava/lang/String;", "getGatewayId", "getPaymentMethodId", "getSavePaymentMethod", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/SavePaymentMethod;", "getShopId", "getSubtitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class SavedBankCardPaymentParameters implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SavedBankCardPaymentParameters> CREATOR = new f();

    @Keep
    private final Amount amount;

    @Keep
    private final String clientApplicationKey;

    @Keep
    private final String gatewayId;

    @Keep
    private final String paymentMethodId;

    @Keep
    private final SavePaymentMethod savePaymentMethod;

    @Keep
    private final String shopId;

    @Keep
    private final String subtitle;

    @Keep
    private final String title;

    @Keep
    public SavedBankCardPaymentParameters(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, String paymentMethodId, SavePaymentMethod savePaymentMethod, String str) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(paymentMethodId, "paymentMethodId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        this.amount = amount;
        this.title = title;
        this.subtitle = subtitle;
        this.clientApplicationKey = clientApplicationKey;
        this.shopId = shopId;
        this.paymentMethodId = paymentMethodId;
        this.savePaymentMethod = savePaymentMethod;
        this.gatewayId = str;
    }

    /* renamed from: component1, reason: from getter */
    public final Amount getAmount() {
        return this.amount;
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
    public final String getPaymentMethodId() {
        return this.paymentMethodId;
    }

    /* renamed from: component7, reason: from getter */
    public final SavePaymentMethod getSavePaymentMethod() {
        return this.savePaymentMethod;
    }

    /* renamed from: component8, reason: from getter */
    public final String getGatewayId() {
        return this.gatewayId;
    }

    public final SavedBankCardPaymentParameters copy(Amount amount, String title, String subtitle, String clientApplicationKey, String shopId, String paymentMethodId, SavePaymentMethod savePaymentMethod, String gatewayId) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(paymentMethodId, "paymentMethodId");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        return new SavedBankCardPaymentParameters(amount, title, subtitle, clientApplicationKey, shopId, paymentMethodId, savePaymentMethod, gatewayId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SavedBankCardPaymentParameters)) {
            return false;
        }
        SavedBankCardPaymentParameters savedBankCardPaymentParameters = (SavedBankCardPaymentParameters) other;
        return Intrinsics.areEqual(this.amount, savedBankCardPaymentParameters.amount) && Intrinsics.areEqual(this.title, savedBankCardPaymentParameters.title) && Intrinsics.areEqual(this.subtitle, savedBankCardPaymentParameters.subtitle) && Intrinsics.areEqual(this.clientApplicationKey, savedBankCardPaymentParameters.clientApplicationKey) && Intrinsics.areEqual(this.shopId, savedBankCardPaymentParameters.shopId) && Intrinsics.areEqual(this.paymentMethodId, savedBankCardPaymentParameters.paymentMethodId) && this.savePaymentMethod == savedBankCardPaymentParameters.savePaymentMethod && Intrinsics.areEqual(this.gatewayId, savedBankCardPaymentParameters.gatewayId);
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final String getClientApplicationKey() {
        return this.clientApplicationKey;
    }

    public final String getGatewayId() {
        return this.gatewayId;
    }

    public final String getPaymentMethodId() {
        return this.paymentMethodId;
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

    public int hashCode() {
        int iHashCode = (this.savePaymentMethod.hashCode() + AbstractC1553e.a(this.paymentMethodId, AbstractC1553e.a(this.shopId, AbstractC1553e.a(this.clientApplicationKey, AbstractC1553e.a(this.subtitle, AbstractC1553e.a(this.title, this.amount.hashCode() * 31, 31), 31), 31), 31), 31)) * 31;
        String str = this.gatewayId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SavedBankCardPaymentParameters(amount=" + this.amount + ", title=" + this.title + ", subtitle=" + this.subtitle + ", clientApplicationKey=" + this.clientApplicationKey + ", shopId=" + this.shopId + ", paymentMethodId=" + this.paymentMethodId + ", savePaymentMethod=" + this.savePaymentMethod + ", gatewayId=" + this.gatewayId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.amount.writeToParcel(parcel, flags);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.clientApplicationKey);
        parcel.writeString(this.shopId);
        parcel.writeString(this.paymentMethodId);
        parcel.writeString(this.savePaymentMethod.name());
        parcel.writeString(this.gatewayId);
    }

    public /* synthetic */ SavedBankCardPaymentParameters(Amount amount, String str, String str2, String str3, String str4, String str5, SavePaymentMethod savePaymentMethod, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(amount, str, str2, str3, str4, str5, savePaymentMethod, (i & 128) != 0 ? null : str6);
    }
}
