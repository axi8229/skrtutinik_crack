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
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

@Keep
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0081\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011Jl\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b!\u0010\rJ\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u001a\u0010%\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004J \u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010-R\u001a\u0010\u0017\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u00100\u001a\u0004\b1\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b3\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b5\u0010\rR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b6\u0010\rR\u001a\u0010\u001c\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b8\u0010\u0011R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b;\u0010\u0011¨\u0006>"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/model/AbstractWallet;", "Lru/yoomoney/sdk/kassa/payments/model/x0;", "", "component1", "()I", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "component2", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "Lru/yoomoney/sdk/kassa/payments/model/A;", "component3", "()Lru/yoomoney/sdk/kassa/payments/model/A;", "", "component4", "()Ljava/lang/String;", "component5", "", "component6", "()Z", "", "Lru/yoomoney/sdk/kassa/payments/model/ConfirmationType;", "component7", "()Ljava/util/List;", "component8", "id", "charge", "fee", RemoteMessageConst.Notification.ICON, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "savePaymentMethodAllowed", "confirmationTypes", "savePaymentInstrument", "copy", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Z)Lru/yoomoney/sdk/kassa/payments/model/AbstractWallet;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getId", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "getCharge", "Lru/yoomoney/sdk/kassa/payments/model/A;", "getFee", "Ljava/lang/String;", "getIcon", "getTitle", "Z", "getSavePaymentMethodAllowed", "Ljava/util/List;", "getConfirmationTypes", "getSavePaymentInstrument", "<init>", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Z)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class AbstractWallet extends x0 {
    public static final int $stable = 8;
    public static final Parcelable.Creator<AbstractWallet> CREATOR = new C2317a();
    private final Amount charge;
    private final List<ConfirmationType> confirmationTypes;
    private final A fee;
    private final String icon;
    private final int id;
    private final boolean savePaymentInstrument;
    private final boolean savePaymentMethodAllowed;
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractWallet(int i, Amount charge, A a, String str, String str2, boolean z, List<? extends ConfirmationType> confirmationTypes, boolean z2) {
        super(0);
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(confirmationTypes, "confirmationTypes");
        this.id = i;
        this.charge = charge;
        this.fee = a;
        this.icon = str;
        this.title = str2;
        this.savePaymentMethodAllowed = z;
        this.confirmationTypes = confirmationTypes;
        this.savePaymentInstrument = z2;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
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
    public final boolean getSavePaymentMethodAllowed() {
        return this.savePaymentMethodAllowed;
    }

    public final List<ConfirmationType> component7() {
        return this.confirmationTypes;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getSavePaymentInstrument() {
        return this.savePaymentInstrument;
    }

    public final AbstractWallet copy(int id, Amount charge, A fee, String icon, String title, boolean savePaymentMethodAllowed, List<? extends ConfirmationType> confirmationTypes, boolean savePaymentInstrument) {
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(confirmationTypes, "confirmationTypes");
        return new AbstractWallet(id, charge, fee, icon, title, savePaymentMethodAllowed, confirmationTypes, savePaymentInstrument);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbstractWallet)) {
            return false;
        }
        AbstractWallet abstractWallet = (AbstractWallet) other;
        return this.id == abstractWallet.id && Intrinsics.areEqual(this.charge, abstractWallet.charge) && Intrinsics.areEqual(this.fee, abstractWallet.fee) && Intrinsics.areEqual(this.icon, abstractWallet.icon) && Intrinsics.areEqual(this.title, abstractWallet.title) && this.savePaymentMethodAllowed == abstractWallet.savePaymentMethodAllowed && Intrinsics.areEqual(this.confirmationTypes, abstractWallet.confirmationTypes) && this.savePaymentInstrument == abstractWallet.savePaymentInstrument;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public Amount getCharge() {
        return this.charge;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public List<ConfirmationType> getConfirmationTypes() {
        return this.confirmationTypes;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public A getFee() {
        return this.fee;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public String getIcon() {
        return this.icon;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.T
    public int getId() {
        return this.id;
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
        return Boolean.hashCode(this.savePaymentInstrument) + ((this.confirmationTypes.hashCode() + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.savePaymentMethodAllowed, (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31, 31)) * 31);
    }

    public String toString() {
        return "AbstractWallet(id=" + this.id + ", charge=" + this.charge + ", fee=" + this.fee + ", icon=" + this.icon + ", title=" + this.title + ", savePaymentMethodAllowed=" + this.savePaymentMethodAllowed + ", confirmationTypes=" + this.confirmationTypes + ", savePaymentInstrument=" + this.savePaymentInstrument + ")";
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
