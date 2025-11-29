package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextErrorPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterLocale.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/RegisterBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextErrorPlaceHolder;", "firstNameTextField", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "continueButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextErrorPlaceHolder;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextErrorPlaceHolder;", "getFirstNameTextField", "()Lcom/sputnik/common/entities/localization/entities/common/TextErrorPlaceHolder;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getContinueButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RegisterBody implements Parcelable {
    public static final Parcelable.Creator<RegisterBody> CREATOR = new Creator();

    @SerializedName("continue_button")
    private final TextTitle continueButton;

    @SerializedName("first_name_textfield")
    private final TextErrorPlaceHolder firstNameTextField;
    private final String subtitle;
    private final String title;

    /* compiled from: RegisterLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RegisterBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RegisterBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RegisterBody(parcel.readString(), parcel.readString(), TextErrorPlaceHolder.CREATOR.createFromParcel(parcel), TextTitle.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RegisterBody[] newArray(int i) {
            return new RegisterBody[i];
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
        if (!(other instanceof RegisterBody)) {
            return false;
        }
        RegisterBody registerBody = (RegisterBody) other;
        return Intrinsics.areEqual(this.title, registerBody.title) && Intrinsics.areEqual(this.subtitle, registerBody.subtitle) && Intrinsics.areEqual(this.firstNameTextField, registerBody.firstNameTextField) && Intrinsics.areEqual(this.continueButton, registerBody.continueButton);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.firstNameTextField.hashCode()) * 31) + this.continueButton.hashCode();
    }

    public String toString() {
        return "RegisterBody(title=" + this.title + ", subtitle=" + this.subtitle + ", firstNameTextField=" + this.firstNameTextField + ", continueButton=" + this.continueButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        this.firstNameTextField.writeToParcel(parcel, flags);
        this.continueButton.writeToParcel(parcel, flags);
    }

    public RegisterBody(String title, String subtitle, TextErrorPlaceHolder firstNameTextField, TextTitle continueButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(firstNameTextField, "firstNameTextField");
        Intrinsics.checkNotNullParameter(continueButton, "continueButton");
        this.title = title;
        this.subtitle = subtitle;
        this.firstNameTextField = firstNameTextField;
        this.continueButton = continueButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final TextErrorPlaceHolder getFirstNameTextField() {
        return this.firstNameTextField;
    }

    public final TextTitle getContinueButton() {
        return this.continueButton;
    }
}
