package com.sputnik.common.entities.localization.entities.blocking;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextWith1Param;
import com.sputnik.common.entities.localization.entities.common.TextWithoutParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicePaymentLocale.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b)\u0010(R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b.\u0010/R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00100\u001a\u0004\b1\u00102R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00103\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/blocking/ServicePaymentBody;", "Landroid/os/Parcelable;", "", "accountNumber", "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextWithoutParam;", "badge", "debtBadge", "", "sectionTitles", "Lcom/sputnik/common/entities/localization/entities/blocking/ActiveCell;", "activeCell", "Lcom/sputnik/common/entities/localization/entities/blocking/NormalCell;", "normalCell", "Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;", "offer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextWithoutParam;Lcom/sputnik/common/entities/localization/entities/common/TextWithoutParam;Ljava/util/List;Lcom/sputnik/common/entities/localization/entities/blocking/ActiveCell;Lcom/sputnik/common/entities/localization/entities/blocking/NormalCell;Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAccountNumber", "getSubtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextWithoutParam;", "getBadge", "()Lcom/sputnik/common/entities/localization/entities/common/TextWithoutParam;", "getDebtBadge", "Ljava/util/List;", "getSectionTitles", "()Ljava/util/List;", "Lcom/sputnik/common/entities/localization/entities/blocking/ActiveCell;", "getActiveCell", "()Lcom/sputnik/common/entities/localization/entities/blocking/ActiveCell;", "Lcom/sputnik/common/entities/localization/entities/blocking/NormalCell;", "getNormalCell", "()Lcom/sputnik/common/entities/localization/entities/blocking/NormalCell;", "Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;", "getOffer", "()Lcom/sputnik/common/entities/localization/entities/common/TextWith1Param;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ServicePaymentBody implements Parcelable {
    public static final Parcelable.Creator<ServicePaymentBody> CREATOR = new Creator();

    @SerializedName("account_number")
    private final String accountNumber;

    @SerializedName("active_cell")
    private final ActiveCell activeCell;
    private final TextWithoutParam badge;

    @SerializedName("debt_badge")
    private final TextWithoutParam debtBadge;

    @SerializedName("normal_cell")
    private final NormalCell normalCell;
    private final TextWith1Param offer;

    @SerializedName("section_titles")
    private final List<String> sectionTitles;
    private final String subtitle;

    /* compiled from: ServicePaymentLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ServicePaymentBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServicePaymentBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Parcelable.Creator<TextWithoutParam> creator = TextWithoutParam.CREATOR;
            return new ServicePaymentBody(string, string2, creator.createFromParcel(parcel), creator.createFromParcel(parcel), parcel.createStringArrayList(), parcel.readInt() == 0 ? null : ActiveCell.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? NormalCell.CREATOR.createFromParcel(parcel) : null, TextWith1Param.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServicePaymentBody[] newArray(int i) {
            return new ServicePaymentBody[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServicePaymentBody)) {
            return false;
        }
        ServicePaymentBody servicePaymentBody = (ServicePaymentBody) other;
        return Intrinsics.areEqual(this.accountNumber, servicePaymentBody.accountNumber) && Intrinsics.areEqual(this.subtitle, servicePaymentBody.subtitle) && Intrinsics.areEqual(this.badge, servicePaymentBody.badge) && Intrinsics.areEqual(this.debtBadge, servicePaymentBody.debtBadge) && Intrinsics.areEqual(this.sectionTitles, servicePaymentBody.sectionTitles) && Intrinsics.areEqual(this.activeCell, servicePaymentBody.activeCell) && Intrinsics.areEqual(this.normalCell, servicePaymentBody.normalCell) && Intrinsics.areEqual(this.offer, servicePaymentBody.offer);
    }

    public int hashCode() {
        int iHashCode = ((((((this.accountNumber.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.badge.hashCode()) * 31) + this.debtBadge.hashCode()) * 31;
        List<String> list = this.sectionTitles;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        ActiveCell activeCell = this.activeCell;
        int iHashCode3 = (iHashCode2 + (activeCell == null ? 0 : activeCell.hashCode())) * 31;
        NormalCell normalCell = this.normalCell;
        return ((iHashCode3 + (normalCell != null ? normalCell.hashCode() : 0)) * 31) + this.offer.hashCode();
    }

    public String toString() {
        return "ServicePaymentBody(accountNumber=" + this.accountNumber + ", subtitle=" + this.subtitle + ", badge=" + this.badge + ", debtBadge=" + this.debtBadge + ", sectionTitles=" + this.sectionTitles + ", activeCell=" + this.activeCell + ", normalCell=" + this.normalCell + ", offer=" + this.offer + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.accountNumber);
        parcel.writeString(this.subtitle);
        this.badge.writeToParcel(parcel, flags);
        this.debtBadge.writeToParcel(parcel, flags);
        parcel.writeStringList(this.sectionTitles);
        ActiveCell activeCell = this.activeCell;
        if (activeCell == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            activeCell.writeToParcel(parcel, flags);
        }
        NormalCell normalCell = this.normalCell;
        if (normalCell == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            normalCell.writeToParcel(parcel, flags);
        }
        this.offer.writeToParcel(parcel, flags);
    }

    public ServicePaymentBody(String accountNumber, String subtitle, TextWithoutParam badge, TextWithoutParam debtBadge, List<String> list, ActiveCell activeCell, NormalCell normalCell, TextWith1Param offer) {
        Intrinsics.checkNotNullParameter(accountNumber, "accountNumber");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(badge, "badge");
        Intrinsics.checkNotNullParameter(debtBadge, "debtBadge");
        Intrinsics.checkNotNullParameter(offer, "offer");
        this.accountNumber = accountNumber;
        this.subtitle = subtitle;
        this.badge = badge;
        this.debtBadge = debtBadge;
        this.sectionTitles = list;
        this.activeCell = activeCell;
        this.normalCell = normalCell;
        this.offer = offer;
    }

    public final String getAccountNumber() {
        return this.accountNumber;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final TextWithoutParam getBadge() {
        return this.badge;
    }

    public final TextWithoutParam getDebtBadge() {
        return this.debtBadge;
    }

    public final List<String> getSectionTitles() {
        return this.sectionTitles;
    }

    public final ActiveCell getActiveCell() {
        return this.activeCell;
    }

    public final NormalCell getNormalCell() {
        return this.normalCell;
    }

    public final TextWith1Param getOffer() {
        return this.offer;
    }
}
