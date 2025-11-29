package ru.yoomoney.sdk.kassa.payments.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

@Keep
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0081\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010#\u001a\u00020\u0004¢\u0006\u0004\bB\u0010CJ\u001d\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0016Jl\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010!\u001a\u00020\u00042\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010#\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b&\u0010\u0013J\u0010\u0010'\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b'\u0010\nJ\u001a\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b,\u0010\nJ \u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b1\u00102R\u001a\u0010\u001c\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b4\u0010\nR\u001a\u0010\u001d\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b6\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b8\u0010\u0010R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u00109\u001a\u0004\b:\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u00109\u001a\u0004\b;\u0010\u0013R\u001a\u0010!\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b=\u0010\u0016R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010>\u001a\u0004\b?\u0010\u001aR\u001a\u0010#\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010<\u001a\u0004\b@\u0010\u0016R\u0017\u0010A\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bA\u0010\u0016¨\u0006D"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/model/SberBank;", "Lru/yoomoney/sdk/kassa/payments/model/T;", "Landroid/content/Context;", "context", "", "isSberAppAvailable", "canPayWithSberPay", "(Landroid/content/Context;Z)Z", "", "component1", "()I", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "component2", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "Lru/yoomoney/sdk/kassa/payments/model/A;", "component3", "()Lru/yoomoney/sdk/kassa/payments/model/A;", "", "component4", "()Ljava/lang/String;", "component5", "component6", "()Z", "", "Lru/yoomoney/sdk/kassa/payments/model/ConfirmationType;", "component7", "()Ljava/util/List;", "component8", "id", "charge", "fee", RemoteMessageConst.Notification.ICON, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "savePaymentMethodAllowed", "confirmationTypes", "savePaymentInstrument", "copy", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Z)Lru/yoomoney/sdk/kassa/payments/model/SberBank;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getId", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "getCharge", "Lru/yoomoney/sdk/kassa/payments/model/A;", "getFee", "Ljava/lang/String;", "getIcon", "getTitle", "Z", "getSavePaymentMethodAllowed", "Ljava/util/List;", "getConfirmationTypes", "getSavePaymentInstrument", "isSberPayAllowed", "<init>", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Z)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class SberBank extends T {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SberBank> CREATOR = new i0();
    private final Amount charge;
    private final List<ConfirmationType> confirmationTypes;
    private final A fee;
    private final String icon;
    private final int id;
    private final boolean isSberPayAllowed;
    private final boolean savePaymentInstrument;
    private final boolean savePaymentMethodAllowed;
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SberBank(int i, Amount charge, A a, String str, String str2, boolean z, List<? extends ConfirmationType> confirmationTypes, boolean z2) {
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
        this.isSberPayAllowed = getConfirmationTypes().contains(ConfirmationType.MOBILE_APPLICATION);
    }

    public final boolean canPayWithSberPay(Context context, boolean isSberAppAvailable) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.isSberPayAllowed && isSberAppAvailable) {
            String string = context.getResources().getString(R$string.ym_app_scheme);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (string.length() > 0) {
                return true;
            }
        }
        return false;
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

    public final SberBank copy(int id, Amount charge, A fee, String icon, String title, boolean savePaymentMethodAllowed, List<? extends ConfirmationType> confirmationTypes, boolean savePaymentInstrument) {
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(confirmationTypes, "confirmationTypes");
        return new SberBank(id, charge, fee, icon, title, savePaymentMethodAllowed, confirmationTypes, savePaymentInstrument);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SberBank)) {
            return false;
        }
        SberBank sberBank = (SberBank) other;
        return this.id == sberBank.id && Intrinsics.areEqual(this.charge, sberBank.charge) && Intrinsics.areEqual(this.fee, sberBank.fee) && Intrinsics.areEqual(this.icon, sberBank.icon) && Intrinsics.areEqual(this.title, sberBank.title) && this.savePaymentMethodAllowed == sberBank.savePaymentMethodAllowed && Intrinsics.areEqual(this.confirmationTypes, sberBank.confirmationTypes) && this.savePaymentInstrument == sberBank.savePaymentInstrument;
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

    /* renamed from: isSberPayAllowed, reason: from getter */
    public final boolean getIsSberPayAllowed() {
        return this.isSberPayAllowed;
    }

    public String toString() {
        return "SberBank(id=" + this.id + ", charge=" + this.charge + ", fee=" + this.fee + ", icon=" + this.icon + ", title=" + this.title + ", savePaymentMethodAllowed=" + this.savePaymentMethodAllowed + ", confirmationTypes=" + this.confirmationTypes + ", savePaymentInstrument=" + this.savePaymentInstrument + ")";
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
