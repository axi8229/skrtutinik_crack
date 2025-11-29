package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b&\u0010%R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b'\u0010\u000e¨\u0006("}, d2 = {"Lcom/sputnik/common/entities/localization/AboutBody;", "Landroid/os/Parcelable;", "", "skolkovo", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "descriptionLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "rulesButton", "licenseButton", "copyrightLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSkolkovo", "getTitle", "getSubtitle", "getDescriptionLabel", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getRulesButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getLicenseButton", "getCopyrightLabel", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AboutBody implements Parcelable {
    public static final Parcelable.Creator<AboutBody> CREATOR = new Creator();

    @SerializedName("copyright_label")
    private final String copyrightLabel;

    @SerializedName("description_label")
    private final String descriptionLabel;

    @SerializedName("license_button")
    private final TextTitle licenseButton;

    @SerializedName("rules_button")
    private final TextTitle rulesButton;
    private final String skolkovo;
    private final String subtitle;
    private final String title;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AboutBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AboutBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AboutBody(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (TextTitle) parcel.readParcelable(AboutBody.class.getClassLoader()), (TextTitle) parcel.readParcelable(AboutBody.class.getClassLoader()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AboutBody[] newArray(int i) {
            return new AboutBody[i];
        }
    }

    public AboutBody() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AboutBody)) {
            return false;
        }
        AboutBody aboutBody = (AboutBody) other;
        return Intrinsics.areEqual(this.skolkovo, aboutBody.skolkovo) && Intrinsics.areEqual(this.title, aboutBody.title) && Intrinsics.areEqual(this.subtitle, aboutBody.subtitle) && Intrinsics.areEqual(this.descriptionLabel, aboutBody.descriptionLabel) && Intrinsics.areEqual(this.rulesButton, aboutBody.rulesButton) && Intrinsics.areEqual(this.licenseButton, aboutBody.licenseButton) && Intrinsics.areEqual(this.copyrightLabel, aboutBody.copyrightLabel);
    }

    public int hashCode() {
        String str = this.skolkovo;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subtitle;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.descriptionLabel;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        TextTitle textTitle = this.rulesButton;
        int iHashCode5 = (iHashCode4 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        TextTitle textTitle2 = this.licenseButton;
        int iHashCode6 = (iHashCode5 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
        String str5 = this.copyrightLabel;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "AboutBody(skolkovo=" + this.skolkovo + ", title=" + this.title + ", subtitle=" + this.subtitle + ", descriptionLabel=" + this.descriptionLabel + ", rulesButton=" + this.rulesButton + ", licenseButton=" + this.licenseButton + ", copyrightLabel=" + this.copyrightLabel + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.skolkovo);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.descriptionLabel);
        parcel.writeParcelable(this.rulesButton, flags);
        parcel.writeParcelable(this.licenseButton, flags);
        parcel.writeString(this.copyrightLabel);
    }

    public AboutBody(String str, String str2, String str3, String str4, TextTitle textTitle, TextTitle textTitle2, String str5) {
        this.skolkovo = str;
        this.title = str2;
        this.subtitle = str3;
        this.descriptionLabel = str4;
        this.rulesButton = textTitle;
        this.licenseButton = textTitle2;
        this.copyrightLabel = str5;
    }

    public /* synthetic */ AboutBody(String str, String str2, String str3, String str4, TextTitle textTitle, TextTitle textTitle2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : textTitle, (i & 32) != 0 ? null : textTitle2, (i & 64) != 0 ? null : str5);
    }

    public final String getSkolkovo() {
        return this.skolkovo;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getDescriptionLabel() {
        return this.descriptionLabel;
    }

    public final TextTitle getRulesButton() {
        return this.rulesButton;
    }

    public final TextTitle getLicenseButton() {
        return this.licenseButton;
    }

    public final String getCopyrightLabel() {
        return this.copyrightLabel;
    }
}
