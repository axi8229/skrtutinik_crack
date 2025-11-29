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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0081\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010#\u001a\u00020\u0012¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0014J\u0084\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010!\u001a\u00020\u00122\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010#\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b&\u0010\u0007J\u001a\u0010)\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b+\u0010\u0007J \u00100\u001a\u00020/2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b0\u00101R\u001a\u0010\u001a\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u0010\u0007R\u001a\u0010\u001b\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b5\u0010\nR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b7\u0010\rR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010\u0004R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b:\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b;\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b<\u0010\u0004R\u001a\u0010!\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010=\u001a\u0004\b>\u0010\u0014R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010?\u001a\u0004\b@\u0010\u0018R\u001a\u0010#\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\bA\u0010\u0014¨\u0006D"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/model/Wallet;", "Lru/yoomoney/sdk/kassa/payments/model/x0;", "", "toString", "()Ljava/lang/String;", "", "component1", "()I", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "component2", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "Lru/yoomoney/sdk/kassa/payments/model/A;", "component3", "()Lru/yoomoney/sdk/kassa/payments/model/A;", "component4", "component5", "component6", "component7", "", "component8", "()Z", "", "Lru/yoomoney/sdk/kassa/payments/model/ConfirmationType;", "component9", "()Ljava/util/List;", "component10", "id", "charge", "fee", "walletId", "balance", RemoteMessageConst.Notification.ICON, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "savePaymentMethodAllowed", "confirmationTypes", "savePaymentInstrument", "copy", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Z)Lru/yoomoney/sdk/kassa/payments/model/Wallet;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getId", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "getCharge", "Lru/yoomoney/sdk/kassa/payments/model/A;", "getFee", "Ljava/lang/String;", "getWalletId", "getBalance", "getIcon", "getTitle", "Z", "getSavePaymentMethodAllowed", "Ljava/util/List;", "getConfirmationTypes", "getSavePaymentInstrument", "<init>", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Z)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class Wallet extends x0 {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Wallet> CREATOR = new u0();
    private final Amount balance;
    private final Amount charge;
    private final List<ConfirmationType> confirmationTypes;
    private final A fee;
    private final String icon;
    private final int id;
    private final boolean savePaymentInstrument;
    private final boolean savePaymentMethodAllowed;
    private final String title;
    private final String walletId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Wallet(int i, Amount charge, A a, String str, Amount amount, String str2, String str3, boolean z, List<? extends ConfirmationType> confirmationTypes, boolean z2) {
        super(0);
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(confirmationTypes, "confirmationTypes");
        this.id = i;
        this.charge = charge;
        this.fee = a;
        this.walletId = str;
        this.balance = amount;
        this.icon = str2;
        this.title = str3;
        this.savePaymentMethodAllowed = z;
        this.confirmationTypes = confirmationTypes;
        this.savePaymentInstrument = z2;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
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
    public final String getWalletId() {
        return this.walletId;
    }

    /* renamed from: component5, reason: from getter */
    public final Amount getBalance() {
        return this.balance;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getSavePaymentMethodAllowed() {
        return this.savePaymentMethodAllowed;
    }

    public final List<ConfirmationType> component9() {
        return this.confirmationTypes;
    }

    public final Wallet copy(int id, Amount charge, A fee, String walletId, Amount balance, String icon, String title, boolean savePaymentMethodAllowed, List<? extends ConfirmationType> confirmationTypes, boolean savePaymentInstrument) {
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(confirmationTypes, "confirmationTypes");
        return new Wallet(id, charge, fee, walletId, balance, icon, title, savePaymentMethodAllowed, confirmationTypes, savePaymentInstrument);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Wallet)) {
            return false;
        }
        Wallet wallet = (Wallet) other;
        return this.id == wallet.id && Intrinsics.areEqual(this.charge, wallet.charge) && Intrinsics.areEqual(this.fee, wallet.fee) && Intrinsics.areEqual(this.walletId, wallet.walletId) && Intrinsics.areEqual(this.balance, wallet.balance) && Intrinsics.areEqual(this.icon, wallet.icon) && Intrinsics.areEqual(this.title, wallet.title) && this.savePaymentMethodAllowed == wallet.savePaymentMethodAllowed && Intrinsics.areEqual(this.confirmationTypes, wallet.confirmationTypes) && this.savePaymentInstrument == wallet.savePaymentInstrument;
    }

    public final Amount getBalance() {
        return this.balance;
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

    public final String getWalletId() {
        return this.walletId;
    }

    public int hashCode() {
        int iHashCode = (this.charge.hashCode() + (Integer.hashCode(this.id) * 31)) * 31;
        A a = this.fee;
        int iHashCode2 = (iHashCode + (a == null ? 0 : a.hashCode())) * 31;
        String str = this.walletId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Amount amount = this.balance;
        int iHashCode4 = (iHashCode3 + (amount == null ? 0 : amount.hashCode())) * 31;
        String str2 = this.icon;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        return Boolean.hashCode(this.savePaymentInstrument) + ((this.confirmationTypes.hashCode() + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.savePaymentMethodAllowed, (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31, 31)) * 31);
    }

    public String toString() {
        return "Wallet(id=" + getId() + ", charge=" + getCharge() + ", fee=" + getFee() + ", walletId=****, balance=" + this.balance + ", icon=" + getIcon() + ", title=" + getTitle() + ", savePaymentMethodAllowed=" + getSavePaymentMethodAllowed() + ", confirmationTypes=" + getConfirmationTypes() + ", savePaymentInstrument=" + getSavePaymentInstrument() + "})";
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
        parcel.writeString(this.walletId);
        Amount amount = this.balance;
        if (amount == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            amount.writeToParcel(parcel, flags);
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
