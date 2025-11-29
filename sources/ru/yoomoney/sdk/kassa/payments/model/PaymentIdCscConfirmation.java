package ru.yoomoney.sdk.kassa.payments.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardViewKt;

@Keep
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\b\u0081\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\u0006\u0010+\u001a\u00020\u0018\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0010-\u001a\u00020\u0018¢\u0006\u0004\bQ\u0010RJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001aJª\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u00182\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0002\u0010-\u001a\u00020\u0018HÆ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b0\u0010\u0007J\u001a\u00103\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u000101HÖ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b5\u0010\u0007J \u0010:\u001a\u0002092\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b:\u0010;R\u001a\u0010 \u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b=\u0010\u0007R\u001a\u0010!\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010>\u001a\u0004\b?\u0010\nR\u001c\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bA\u0010\rR\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010B\u001a\u0004\bC\u0010\u0004R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010B\u001a\u0004\bD\u0010\u0004R\u0017\u0010%\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010B\u001a\u0004\bE\u0010\u0004R\u0019\u0010&\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b&\u0010B\u001a\u0004\bF\u0010\u0004R\u0017\u0010'\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b'\u0010B\u001a\u0004\bG\u0010\u0004R\u0017\u0010(\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010B\u001a\u0004\bH\u0010\u0004R\u0017\u0010)\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b)\u0010B\u001a\u0004\bI\u0010\u0004R\u0017\u0010*\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b*\u0010J\u001a\u0004\bK\u0010\u0017R\u001a\u0010+\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010L\u001a\u0004\bM\u0010\u001aR \u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010N\u001a\u0004\bO\u0010\u001eR\u001a\u0010-\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010L\u001a\u0004\bP\u0010\u001a¨\u0006S"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/model/PaymentIdCscConfirmation;", "Lru/yoomoney/sdk/kassa/payments/model/T;", "", "toString", "()Ljava/lang/String;", "", "component1", "()I", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "component2", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "Lru/yoomoney/sdk/kassa/payments/model/A;", "component3", "()Lru/yoomoney/sdk/kassa/payments/model/A;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "Lru/yoomoney/sdk/kassa/payments/model/q;", "component11", "()Lru/yoomoney/sdk/kassa/payments/model/q;", "", "component12", "()Z", "", "Lru/yoomoney/sdk/kassa/payments/model/ConfirmationType;", "component13", "()Ljava/util/List;", "component14", "id", "charge", "fee", RemoteMessageConst.Notification.ICON, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "paymentMethodId", "first", "last", BankCardViewKt.EXTRA_EXPIRY_YEAR, BankCardViewKt.EXTRA_EXPIRY_MONTH, "brand", "savePaymentMethodAllowed", "confirmationTypes", "savePaymentInstrument", "copy", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/model/q;ZLjava/util/List;Z)Lru/yoomoney/sdk/kassa/payments/model/PaymentIdCscConfirmation;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getId", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "getCharge", "Lru/yoomoney/sdk/kassa/payments/model/A;", "getFee", "Ljava/lang/String;", "getIcon", "getTitle", "getPaymentMethodId", "getFirst", "getLast", "getExpiryYear", "getExpiryMonth", "Lru/yoomoney/sdk/kassa/payments/model/q;", "getBrand", "Z", "getSavePaymentMethodAllowed", "Ljava/util/List;", "getConfirmationTypes", "getSavePaymentInstrument", "<init>", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/model/q;ZLjava/util/List;Z)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class PaymentIdCscConfirmation extends T {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaymentIdCscConfirmation> CREATOR = new O();
    private final EnumC2333q brand;
    private final Amount charge;
    private final List<ConfirmationType> confirmationTypes;
    private final String expiryMonth;
    private final String expiryYear;
    private final A fee;
    private final String first;
    private final String icon;
    private final int id;
    private final String last;
    private final String paymentMethodId;
    private final boolean savePaymentInstrument;
    private final boolean savePaymentMethodAllowed;
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentIdCscConfirmation(int i, Amount charge, A a, String str, String str2, String paymentMethodId, String str3, String last, String expiryYear, String expiryMonth, EnumC2333q brand, boolean z, List<? extends ConfirmationType> confirmationTypes, boolean z2) {
        super(0);
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(paymentMethodId, "paymentMethodId");
        Intrinsics.checkNotNullParameter(last, "last");
        Intrinsics.checkNotNullParameter(expiryYear, "expiryYear");
        Intrinsics.checkNotNullParameter(expiryMonth, "expiryMonth");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(confirmationTypes, "confirmationTypes");
        this.id = i;
        this.charge = charge;
        this.fee = a;
        this.icon = str;
        this.title = str2;
        this.paymentMethodId = paymentMethodId;
        this.first = str3;
        this.last = last;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        this.brand = brand;
        this.savePaymentMethodAllowed = z;
        this.confirmationTypes = confirmationTypes;
        this.savePaymentInstrument = z2;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    /* renamed from: component11, reason: from getter */
    public final EnumC2333q getBrand() {
        return this.brand;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getSavePaymentMethodAllowed() {
        return this.savePaymentMethodAllowed;
    }

    public final List<ConfirmationType> component13() {
        return this.confirmationTypes;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getSavePaymentInstrument() {
        return this.savePaymentInstrument;
    }

    /* renamed from: component2, reason: from getter */
    public final Amount getCharge() {
        return this.charge;
    }

    /* renamed from: component3, reason: from getter */
    public final A getFee() {
        return this.fee;
    }

    /* renamed from: component4, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPaymentMethodId() {
        return this.paymentMethodId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFirst() {
        return this.first;
    }

    /* renamed from: component8, reason: from getter */
    public final String getLast() {
        return this.last;
    }

    /* renamed from: component9, reason: from getter */
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    public final PaymentIdCscConfirmation copy(int id, Amount charge, A fee, String icon, String title, String paymentMethodId, String first, String last, String expiryYear, String expiryMonth, EnumC2333q brand, boolean savePaymentMethodAllowed, List<? extends ConfirmationType> confirmationTypes, boolean savePaymentInstrument) {
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(paymentMethodId, "paymentMethodId");
        Intrinsics.checkNotNullParameter(last, "last");
        Intrinsics.checkNotNullParameter(expiryYear, "expiryYear");
        Intrinsics.checkNotNullParameter(expiryMonth, "expiryMonth");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(confirmationTypes, "confirmationTypes");
        return new PaymentIdCscConfirmation(id, charge, fee, icon, title, paymentMethodId, first, last, expiryYear, expiryMonth, brand, savePaymentMethodAllowed, confirmationTypes, savePaymentInstrument);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentIdCscConfirmation)) {
            return false;
        }
        PaymentIdCscConfirmation paymentIdCscConfirmation = (PaymentIdCscConfirmation) other;
        return this.id == paymentIdCscConfirmation.id && Intrinsics.areEqual(this.charge, paymentIdCscConfirmation.charge) && Intrinsics.areEqual(this.fee, paymentIdCscConfirmation.fee) && Intrinsics.areEqual(this.icon, paymentIdCscConfirmation.icon) && Intrinsics.areEqual(this.title, paymentIdCscConfirmation.title) && Intrinsics.areEqual(this.paymentMethodId, paymentIdCscConfirmation.paymentMethodId) && Intrinsics.areEqual(this.first, paymentIdCscConfirmation.first) && Intrinsics.areEqual(this.last, paymentIdCscConfirmation.last) && Intrinsics.areEqual(this.expiryYear, paymentIdCscConfirmation.expiryYear) && Intrinsics.areEqual(this.expiryMonth, paymentIdCscConfirmation.expiryMonth) && this.brand == paymentIdCscConfirmation.brand && this.savePaymentMethodAllowed == paymentIdCscConfirmation.savePaymentMethodAllowed && Intrinsics.areEqual(this.confirmationTypes, paymentIdCscConfirmation.confirmationTypes) && this.savePaymentInstrument == paymentIdCscConfirmation.savePaymentInstrument;
    }

    public final EnumC2333q getBrand() {
        return this.brand;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public Amount getCharge() {
        return this.charge;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public List<ConfirmationType> getConfirmationTypes() {
        return this.confirmationTypes;
    }

    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    public final String getExpiryYear() {
        return this.expiryYear;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public A getFee() {
        return this.fee;
    }

    public final String getFirst() {
        return this.first;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public String getIcon() {
        return this.icon;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public int getId() {
        return this.id;
    }

    public final String getLast() {
        return this.last;
    }

    public final String getPaymentMethodId() {
        return this.paymentMethodId;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public boolean getSavePaymentInstrument() {
        return this.savePaymentInstrument;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public boolean getSavePaymentMethodAllowed() {
        return this.savePaymentMethodAllowed;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = (this.charge.hashCode() + (Integer.hashCode(this.id) * 31)) * 31;
        A a = this.fee;
        int iHashCode2 = (iHashCode + (a == null ? 0 : a.hashCode())) * 31;
        String str = this.icon;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int iA = AbstractC1553e.a(this.paymentMethodId, (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
        String str3 = this.first;
        return Boolean.hashCode(this.savePaymentInstrument) + ((this.confirmationTypes.hashCode() + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.savePaymentMethodAllowed, (this.brand.hashCode() + AbstractC1553e.a(this.expiryMonth, AbstractC1553e.a(this.expiryYear, AbstractC1553e.a(this.last, (iA + (str3 != null ? str3.hashCode() : 0)) * 31, 31), 31), 31)) * 31, 31)) * 31);
    }

    public String toString() {
        return "PaymentIdCscConfirmation(id=" + getId() + ", charge=" + getCharge() + ", fee=" + getFee() + ", icon=" + getIcon() + ",title=" + getTitle() + ",paymentMethodId=" + this.paymentMethodId + ",first=******, last=" + this.last + ", brand=" + this.brand + ",savePaymentMethodAllowed=" + getSavePaymentMethodAllowed() + ", confirmationTypes=" + getConfirmationTypes() + ", savePaymentInstrument=" + getSavePaymentInstrument() + "})";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.id);
        this.charge.writeToParcel(parcel, flags);
        A a = this.fee;
        if (a == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            a.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.icon);
        parcel.writeString(this.title);
        parcel.writeString(this.paymentMethodId);
        parcel.writeString(this.first);
        parcel.writeString(this.last);
        parcel.writeString(this.expiryYear);
        parcel.writeString(this.expiryMonth);
        parcel.writeString(this.brand.name());
        parcel.writeInt(this.savePaymentMethodAllowed ? 1 : 0);
        List<ConfirmationType> list = this.confirmationTypes;
        parcel.writeInt(list.size());
        Iterator<ConfirmationType> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next().name());
        }
        parcel.writeInt(this.savePaymentInstrument ? 1 : 0);
    }
}
