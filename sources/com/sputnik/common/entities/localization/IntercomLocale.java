package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b \u0010\u000b¨\u0006!"}, d2 = {"Lcom/sputnik/common/entities/localization/IntercomLocale;", "Landroid/os/Parcelable;", "", "noCameraImageTitle", "installIntercomTitle", "insureApartmentTitle", "noServiceTitle", "activationSubscriptionProblemTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getNoCameraImageTitle", "getInstallIntercomTitle", "getInsureApartmentTitle", "getNoServiceTitle", "getActivationSubscriptionProblemTitle", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class IntercomLocale implements Parcelable {
    public static final Parcelable.Creator<IntercomLocale> CREATOR = new Creator();

    @SerializedName("activation_subscribtion_problem_title")
    private final String activationSubscriptionProblemTitle;

    @SerializedName("install_intercom_title")
    private final String installIntercomTitle;

    @SerializedName("insure_apartment_title")
    private final String insureApartmentTitle;

    @SerializedName("no_camera_image_title")
    private final String noCameraImageTitle;

    @SerializedName("no_service_title")
    private final String noServiceTitle;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<IntercomLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IntercomLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IntercomLocale(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IntercomLocale[] newArray(int i) {
            return new IntercomLocale[i];
        }
    }

    public IntercomLocale() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntercomLocale)) {
            return false;
        }
        IntercomLocale intercomLocale = (IntercomLocale) other;
        return Intrinsics.areEqual(this.noCameraImageTitle, intercomLocale.noCameraImageTitle) && Intrinsics.areEqual(this.installIntercomTitle, intercomLocale.installIntercomTitle) && Intrinsics.areEqual(this.insureApartmentTitle, intercomLocale.insureApartmentTitle) && Intrinsics.areEqual(this.noServiceTitle, intercomLocale.noServiceTitle) && Intrinsics.areEqual(this.activationSubscriptionProblemTitle, intercomLocale.activationSubscriptionProblemTitle);
    }

    public int hashCode() {
        String str = this.noCameraImageTitle;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.installIntercomTitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.insureApartmentTitle;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.noServiceTitle;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.activationSubscriptionProblemTitle;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "IntercomLocale(noCameraImageTitle=" + this.noCameraImageTitle + ", installIntercomTitle=" + this.installIntercomTitle + ", insureApartmentTitle=" + this.insureApartmentTitle + ", noServiceTitle=" + this.noServiceTitle + ", activationSubscriptionProblemTitle=" + this.activationSubscriptionProblemTitle + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.noCameraImageTitle);
        parcel.writeString(this.installIntercomTitle);
        parcel.writeString(this.insureApartmentTitle);
        parcel.writeString(this.noServiceTitle);
        parcel.writeString(this.activationSubscriptionProblemTitle);
    }

    public IntercomLocale(String str, String str2, String str3, String str4, String str5) {
        this.noCameraImageTitle = str;
        this.installIntercomTitle = str2;
        this.insureApartmentTitle = str3;
        this.noServiceTitle = str4;
        this.activationSubscriptionProblemTitle = str5;
    }

    public /* synthetic */ IntercomLocale(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getNoServiceTitle() {
        return this.noServiceTitle;
    }

    public final String getActivationSubscriptionProblemTitle() {
        return this.activationSubscriptionProblemTitle;
    }
}
