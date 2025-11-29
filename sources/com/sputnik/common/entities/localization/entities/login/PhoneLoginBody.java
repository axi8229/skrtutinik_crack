package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneLoginLocale.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b$\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b%\u0010\u0011R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b/\u0010\u0011¨\u00060"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "loginSubtitle", "phoneNumberTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "phoneTextField", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "continueButton", "Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginPrivacy;", "documents", "incorrectPhoneError", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginPrivacy;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "getLoginSubtitle", "getPhoneNumberTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "getPhoneTextField", "()Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getContinueButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginPrivacy;", "getDocuments", "()Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginPrivacy;", "getIncorrectPhoneError", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PhoneLoginBody implements Parcelable {
    public static final Parcelable.Creator<PhoneLoginBody> CREATOR = new Creator();

    @SerializedName("continue_button")
    private final TextTitle continueButton;
    private final PhoneLoginPrivacy documents;

    @SerializedName("error_incorrect_phone")
    private final String incorrectPhoneError;

    @SerializedName("login_subtitle")
    private final String loginSubtitle;

    @SerializedName("phone_number_title")
    private final String phoneNumberTitle;

    @SerializedName("phone_textfield")
    private final TextPlaceHolder phoneTextField;

    @SerializedName("register_subtitle")
    private final String subtitle;

    @SerializedName("register_title")
    private final String title;

    /* compiled from: PhoneLoginLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhoneLoginBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneLoginBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PhoneLoginBody(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), TextPlaceHolder.CREATOR.createFromParcel(parcel), TextTitle.CREATOR.createFromParcel(parcel), PhoneLoginPrivacy.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneLoginBody[] newArray(int i) {
            return new PhoneLoginBody[i];
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
        if (!(other instanceof PhoneLoginBody)) {
            return false;
        }
        PhoneLoginBody phoneLoginBody = (PhoneLoginBody) other;
        return Intrinsics.areEqual(this.title, phoneLoginBody.title) && Intrinsics.areEqual(this.subtitle, phoneLoginBody.subtitle) && Intrinsics.areEqual(this.loginSubtitle, phoneLoginBody.loginSubtitle) && Intrinsics.areEqual(this.phoneNumberTitle, phoneLoginBody.phoneNumberTitle) && Intrinsics.areEqual(this.phoneTextField, phoneLoginBody.phoneTextField) && Intrinsics.areEqual(this.continueButton, phoneLoginBody.continueButton) && Intrinsics.areEqual(this.documents, phoneLoginBody.documents) && Intrinsics.areEqual(this.incorrectPhoneError, phoneLoginBody.incorrectPhoneError);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.loginSubtitle.hashCode()) * 31) + this.phoneNumberTitle.hashCode()) * 31) + this.phoneTextField.hashCode()) * 31) + this.continueButton.hashCode()) * 31) + this.documents.hashCode()) * 31;
        String str = this.incorrectPhoneError;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PhoneLoginBody(title=" + this.title + ", subtitle=" + this.subtitle + ", loginSubtitle=" + this.loginSubtitle + ", phoneNumberTitle=" + this.phoneNumberTitle + ", phoneTextField=" + this.phoneTextField + ", continueButton=" + this.continueButton + ", documents=" + this.documents + ", incorrectPhoneError=" + this.incorrectPhoneError + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.loginSubtitle);
        parcel.writeString(this.phoneNumberTitle);
        this.phoneTextField.writeToParcel(parcel, flags);
        this.continueButton.writeToParcel(parcel, flags);
        this.documents.writeToParcel(parcel, flags);
        parcel.writeString(this.incorrectPhoneError);
    }

    public PhoneLoginBody(String title, String subtitle, String loginSubtitle, String phoneNumberTitle, TextPlaceHolder phoneTextField, TextTitle continueButton, PhoneLoginPrivacy documents, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(loginSubtitle, "loginSubtitle");
        Intrinsics.checkNotNullParameter(phoneNumberTitle, "phoneNumberTitle");
        Intrinsics.checkNotNullParameter(phoneTextField, "phoneTextField");
        Intrinsics.checkNotNullParameter(continueButton, "continueButton");
        Intrinsics.checkNotNullParameter(documents, "documents");
        this.title = title;
        this.subtitle = subtitle;
        this.loginSubtitle = loginSubtitle;
        this.phoneNumberTitle = phoneNumberTitle;
        this.phoneTextField = phoneTextField;
        this.continueButton = continueButton;
        this.documents = documents;
        this.incorrectPhoneError = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getLoginSubtitle() {
        return this.loginSubtitle;
    }

    public final String getPhoneNumberTitle() {
        return this.phoneNumberTitle;
    }

    public final TextPlaceHolder getPhoneTextField() {
        return this.phoneTextField;
    }

    public final TextTitle getContinueButton() {
        return this.continueButton;
    }

    public final PhoneLoginPrivacy getDocuments() {
        return this.documents;
    }

    public final String getIncorrectPhoneError() {
        return this.incorrectPhoneError;
    }
}
