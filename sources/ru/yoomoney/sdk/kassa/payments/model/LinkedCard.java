package ru.yoomoney.sdk.kassa.payments.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

@Keep
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0081\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010#\u001a\u00020\u000b\u0012\u0006\u0010$\u001a\u00020\u0010\u0012\u0006\u0010%\u001a\u00020\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010'\u001a\u00020\u0015\u0012\u0006\u0010(\u001a\u00020\u0015\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010*\u001a\u00020\u0015¢\u0006\u0004\bM\u0010NJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0017J \u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u00102\b\b\u0002\u0010%\u001a\u00020\u000b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010'\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00152\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010*\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b-\u0010\rJ\u0010\u0010.\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b.\u0010\u0004J\u001a\u00101\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b3\u0010\u0004J \u00108\u001a\u0002072\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b8\u00109R\u001a\u0010\u001e\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\b;\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\b=\u0010\u0007R\u001c\u0010 \u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\b?\u0010\nR\u001c\u0010!\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010@\u001a\u0004\bA\u0010\rR\u001c\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bB\u0010\rR\u0017\u0010#\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b#\u0010@\u001a\u0004\bC\u0010\rR\u0017\u0010$\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b$\u0010D\u001a\u0004\bE\u0010\u0012R\u0017\u0010%\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b%\u0010@\u001a\u0004\bF\u0010\rR\u0019\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b&\u0010@\u001a\u0004\bG\u0010\rR\u0017\u0010'\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b'\u0010H\u001a\u0004\b'\u0010\u0017R\u001a\u0010(\u001a\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010H\u001a\u0004\bI\u0010\u0017R \u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010J\u001a\u0004\bK\u0010\u001cR\u001a\u0010*\u001a\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010H\u001a\u0004\bL\u0010\u0017¨\u0006O"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/model/LinkedCard;", "Lru/yoomoney/sdk/kassa/payments/model/x0;", "", "component1", "()I", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "component2", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "Lru/yoomoney/sdk/kassa/payments/model/A;", "component3", "()Lru/yoomoney/sdk/kassa/payments/model/A;", "", "component4", "()Ljava/lang/String;", "component5", "component6", "Lru/yoomoney/sdk/kassa/payments/model/q;", "component7", "()Lru/yoomoney/sdk/kassa/payments/model/q;", "component8", "component9", "", "component10", "()Z", "component11", "", "Lru/yoomoney/sdk/kassa/payments/model/ConfirmationType;", "component12", "()Ljava/util/List;", "component13", "id", "charge", "fee", RemoteMessageConst.Notification.ICON, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "cardId", "brand", "pan", AppMeasurementSdk.ConditionalUserProperty.NAME, "isLinkedToWallet", "savePaymentMethodAllowed", "confirmationTypes", "savePaymentInstrument", "copy", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/model/q;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Z)Lru/yoomoney/sdk/kassa/payments/model/LinkedCard;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getId", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;", "getCharge", "Lru/yoomoney/sdk/kassa/payments/model/A;", "getFee", "Ljava/lang/String;", "getIcon", "getTitle", "getCardId", "Lru/yoomoney/sdk/kassa/payments/model/q;", "getBrand", "getPan", "getName", "Z", "getSavePaymentMethodAllowed", "Ljava/util/List;", "getConfirmationTypes", "getSavePaymentInstrument", "<init>", "(ILru/yoomoney/sdk/kassa/payments/checkoutParameters/Amount;Lru/yoomoney/sdk/kassa/payments/model/A;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/model/q;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Z)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class LinkedCard extends x0 {
    public static final int $stable = 8;
    public static final Parcelable.Creator<LinkedCard> CREATOR = new E();
    private final EnumC2333q brand;
    private final String cardId;
    private final Amount charge;
    private final List<ConfirmationType> confirmationTypes;
    private final A fee;
    private final String icon;
    private final int id;
    private final boolean isLinkedToWallet;
    private final String name;
    private final String pan;
    private final boolean savePaymentInstrument;
    private final boolean savePaymentMethodAllowed;
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LinkedCard(int i, Amount charge, A a, String str, String str2, String cardId, EnumC2333q brand, String pan, String str3, boolean z, boolean z2, List<? extends ConfirmationType> confirmationTypes, boolean z3) {
        super(0);
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(pan, "pan");
        Intrinsics.checkNotNullParameter(confirmationTypes, "confirmationTypes");
        this.id = i;
        this.charge = charge;
        this.fee = a;
        this.icon = str;
        this.title = str2;
        this.cardId = cardId;
        this.brand = brand;
        this.pan = pan;
        this.name = str3;
        this.isLinkedToWallet = z;
        this.savePaymentMethodAllowed = z2;
        this.confirmationTypes = confirmationTypes;
        this.savePaymentInstrument = z3;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsLinkedToWallet() {
        return this.isLinkedToWallet;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getSavePaymentMethodAllowed() {
        return this.savePaymentMethodAllowed;
    }

    public final List<ConfirmationType> component12() {
        return this.confirmationTypes;
    }

    /* renamed from: component13, reason: from getter */
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
    public final String getCardId() {
        return this.cardId;
    }

    /* renamed from: component7, reason: from getter */
    public final EnumC2333q getBrand() {
        return this.brand;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPan() {
        return this.pan;
    }

    /* renamed from: component9, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final LinkedCard copy(int id, Amount charge, A fee, String icon, String title, String cardId, EnumC2333q brand, String pan, String name, boolean isLinkedToWallet, boolean savePaymentMethodAllowed, List<? extends ConfirmationType> confirmationTypes, boolean savePaymentInstrument) {
        Intrinsics.checkNotNullParameter(charge, "charge");
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(pan, "pan");
        Intrinsics.checkNotNullParameter(confirmationTypes, "confirmationTypes");
        return new LinkedCard(id, charge, fee, icon, title, cardId, brand, pan, name, isLinkedToWallet, savePaymentMethodAllowed, confirmationTypes, savePaymentInstrument);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkedCard)) {
            return false;
        }
        LinkedCard linkedCard = (LinkedCard) other;
        return this.id == linkedCard.id && Intrinsics.areEqual(this.charge, linkedCard.charge) && Intrinsics.areEqual(this.fee, linkedCard.fee) && Intrinsics.areEqual(this.icon, linkedCard.icon) && Intrinsics.areEqual(this.title, linkedCard.title) && Intrinsics.areEqual(this.cardId, linkedCard.cardId) && this.brand == linkedCard.brand && Intrinsics.areEqual(this.pan, linkedCard.pan) && Intrinsics.areEqual(this.name, linkedCard.name) && this.isLinkedToWallet == linkedCard.isLinkedToWallet && this.savePaymentMethodAllowed == linkedCard.savePaymentMethodAllowed && Intrinsics.areEqual(this.confirmationTypes, linkedCard.confirmationTypes) && this.savePaymentInstrument == linkedCard.savePaymentInstrument;
    }

    public final EnumC2333q getBrand() {
        return this.brand;
    }

    public final String getCardId() {
        return this.cardId;
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

    public final String getName() {
        return this.name;
    }

    public final String getPan() {
        return this.pan;
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
        int iA = AbstractC1553e.a(this.pan, (this.brand.hashCode() + AbstractC1553e.a(this.cardId, (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31, 31)) * 31, 31);
        String str3 = this.name;
        return Boolean.hashCode(this.savePaymentInstrument) + ((this.confirmationTypes.hashCode() + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.savePaymentMethodAllowed, ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.isLinkedToWallet, (iA + (str3 != null ? str3.hashCode() : 0)) * 31, 31), 31)) * 31);
    }

    public final boolean isLinkedToWallet() {
        return this.isLinkedToWallet;
    }

    public String toString() {
        return "LinkedCard(id=" + this.id + ", charge=" + this.charge + ", fee=" + this.fee + ", icon=" + this.icon + ", title=" + this.title + ", cardId=" + this.cardId + ", brand=" + this.brand + ", pan=" + this.pan + ", name=" + this.name + ", isLinkedToWallet=" + this.isLinkedToWallet + ", savePaymentMethodAllowed=" + this.savePaymentMethodAllowed + ", confirmationTypes=" + this.confirmationTypes + ", savePaymentInstrument=" + this.savePaymentInstrument + ")";
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
        parcel.writeString(this.cardId);
        parcel.writeString(this.brand.name());
        parcel.writeString(this.pan);
        parcel.writeString(this.name);
        parcel.writeInt(this.isLinkedToWallet ? 1 : 0);
        parcel.writeInt(this.savePaymentMethodAllowed ? 1 : 0);
        List<ConfirmationType> list = this.confirmationTypes;
        parcel.writeInt(list.size());
        Iterator<ConfirmationType> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next().name());
        }
        parcel.writeInt(this.savePaymentInstrument ? 1 : 0);
    }

    public /* synthetic */ LinkedCard(int i, Amount amount, A a, String str, String str2, String str3, EnumC2333q enumC2333q, String str4, String str5, boolean z, boolean z2, List list, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, amount, a, str, str2, str3, enumC2333q, str4, (i2 & 256) != 0 ? null : str5, (i2 & 512) != 0 ? false : z, z2, list, z3);
    }
}
