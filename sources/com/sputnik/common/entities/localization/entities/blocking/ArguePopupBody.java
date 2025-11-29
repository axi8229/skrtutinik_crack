package com.sputnik.common.entities.localization.entities.blocking;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArguePopupLocale.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u000fR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b'\u0010\u000fR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b(\u0010\u000fR\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b)\u0010\u000fR\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b*\u0010\u000f¨\u0006+"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/blocking/ArguePopupBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "steps", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "supportButton", "phoneTitleLabel", "addressTitleLabel", "companyTitleLabel", "timeTitleLabel", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getSteps", "()Ljava/util/List;", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getSupportButton", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getPhoneTitleLabel", "getAddressTitleLabel", "getCompanyTitleLabel", "getTimeTitleLabel", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ArguePopupBody implements Parcelable {
    public static final Parcelable.Creator<ArguePopupBody> CREATOR = new Creator();

    @SerializedName("address_title_label")
    private final String addressTitleLabel;

    @SerializedName("company_title_label")
    private final String companyTitleLabel;

    @SerializedName("phone_title_label")
    private final String phoneTitleLabel;
    private final List<String> steps;

    @SerializedName("support_button")
    private final TitleWithParam supportButton;

    @SerializedName("time_title_label")
    private final String timeTitleLabel;
    private final String title;

    /* compiled from: ArguePopupLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ArguePopupBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArguePopupBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ArguePopupBody(parcel.readString(), parcel.createStringArrayList(), TitleWithParam.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArguePopupBody[] newArray(int i) {
            return new ArguePopupBody[i];
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
        if (!(other instanceof ArguePopupBody)) {
            return false;
        }
        ArguePopupBody arguePopupBody = (ArguePopupBody) other;
        return Intrinsics.areEqual(this.title, arguePopupBody.title) && Intrinsics.areEqual(this.steps, arguePopupBody.steps) && Intrinsics.areEqual(this.supportButton, arguePopupBody.supportButton) && Intrinsics.areEqual(this.phoneTitleLabel, arguePopupBody.phoneTitleLabel) && Intrinsics.areEqual(this.addressTitleLabel, arguePopupBody.addressTitleLabel) && Intrinsics.areEqual(this.companyTitleLabel, arguePopupBody.companyTitleLabel) && Intrinsics.areEqual(this.timeTitleLabel, arguePopupBody.timeTitleLabel);
    }

    public int hashCode() {
        return (((((((((((this.title.hashCode() * 31) + this.steps.hashCode()) * 31) + this.supportButton.hashCode()) * 31) + this.phoneTitleLabel.hashCode()) * 31) + this.addressTitleLabel.hashCode()) * 31) + this.companyTitleLabel.hashCode()) * 31) + this.timeTitleLabel.hashCode();
    }

    public String toString() {
        return "ArguePopupBody(title=" + this.title + ", steps=" + this.steps + ", supportButton=" + this.supportButton + ", phoneTitleLabel=" + this.phoneTitleLabel + ", addressTitleLabel=" + this.addressTitleLabel + ", companyTitleLabel=" + this.companyTitleLabel + ", timeTitleLabel=" + this.timeTitleLabel + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeStringList(this.steps);
        this.supportButton.writeToParcel(parcel, flags);
        parcel.writeString(this.phoneTitleLabel);
        parcel.writeString(this.addressTitleLabel);
        parcel.writeString(this.companyTitleLabel);
        parcel.writeString(this.timeTitleLabel);
    }

    public ArguePopupBody(String title, List<String> steps, TitleWithParam supportButton, String phoneTitleLabel, String addressTitleLabel, String companyTitleLabel, String timeTitleLabel) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(supportButton, "supportButton");
        Intrinsics.checkNotNullParameter(phoneTitleLabel, "phoneTitleLabel");
        Intrinsics.checkNotNullParameter(addressTitleLabel, "addressTitleLabel");
        Intrinsics.checkNotNullParameter(companyTitleLabel, "companyTitleLabel");
        Intrinsics.checkNotNullParameter(timeTitleLabel, "timeTitleLabel");
        this.title = title;
        this.steps = steps;
        this.supportButton = supportButton;
        this.phoneTitleLabel = phoneTitleLabel;
        this.addressTitleLabel = addressTitleLabel;
        this.companyTitleLabel = companyTitleLabel;
        this.timeTitleLabel = timeTitleLabel;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getSteps() {
        return this.steps;
    }

    public final TitleWithParam getSupportButton() {
        return this.supportButton;
    }

    public final String getPhoneTitleLabel() {
        return this.phoneTitleLabel;
    }

    public final String getAddressTitleLabel() {
        return this.addressTitleLabel;
    }

    public final String getCompanyTitleLabel() {
        return this.companyTitleLabel;
    }

    public final String getTimeTitleLabel() {
        return this.timeTitleLabel;
    }
}
