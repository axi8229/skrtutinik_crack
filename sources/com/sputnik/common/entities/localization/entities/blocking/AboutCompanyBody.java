package com.sputnik.common.entities.localization.entities.blocking;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AboutCompanyLocale.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001e\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/blocking/AboutCompanyBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "companyTitleLabel", "phoneTitleLabel", "addressTitleLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getCompanyTitleLabel", "getPhoneTitleLabel", "getAddressTitleLabel", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AboutCompanyBody implements Parcelable {
    public static final Parcelable.Creator<AboutCompanyBody> CREATOR = new Creator();

    @SerializedName("address_title_label")
    private final String addressTitleLabel;

    @SerializedName("company_title_label")
    private final String companyTitleLabel;

    @SerializedName("phone_title_label")
    private final String phoneTitleLabel;
    private final String title;

    /* compiled from: AboutCompanyLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AboutCompanyBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AboutCompanyBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AboutCompanyBody(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AboutCompanyBody[] newArray(int i) {
            return new AboutCompanyBody[i];
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
        if (!(other instanceof AboutCompanyBody)) {
            return false;
        }
        AboutCompanyBody aboutCompanyBody = (AboutCompanyBody) other;
        return Intrinsics.areEqual(this.title, aboutCompanyBody.title) && Intrinsics.areEqual(this.companyTitleLabel, aboutCompanyBody.companyTitleLabel) && Intrinsics.areEqual(this.phoneTitleLabel, aboutCompanyBody.phoneTitleLabel) && Intrinsics.areEqual(this.addressTitleLabel, aboutCompanyBody.addressTitleLabel);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.companyTitleLabel.hashCode()) * 31) + this.phoneTitleLabel.hashCode()) * 31) + this.addressTitleLabel.hashCode();
    }

    public String toString() {
        return "AboutCompanyBody(title=" + this.title + ", companyTitleLabel=" + this.companyTitleLabel + ", phoneTitleLabel=" + this.phoneTitleLabel + ", addressTitleLabel=" + this.addressTitleLabel + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.companyTitleLabel);
        parcel.writeString(this.phoneTitleLabel);
        parcel.writeString(this.addressTitleLabel);
    }

    public AboutCompanyBody(String title, String companyTitleLabel, String phoneTitleLabel, String addressTitleLabel) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(companyTitleLabel, "companyTitleLabel");
        Intrinsics.checkNotNullParameter(phoneTitleLabel, "phoneTitleLabel");
        Intrinsics.checkNotNullParameter(addressTitleLabel, "addressTitleLabel");
        this.title = title;
        this.companyTitleLabel = companyTitleLabel;
        this.phoneTitleLabel = phoneTitleLabel;
        this.addressTitleLabel = addressTitleLabel;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCompanyTitleLabel() {
        return this.companyTitleLabel;
    }

    public final String getPhoneTitleLabel() {
        return this.phoneTitleLabel;
    }

    public final String getAddressTitleLabel() {
        return this.addressTitleLabel;
    }
}
