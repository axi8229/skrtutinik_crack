package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterCodeLocale.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010\u0011R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b-\u0010.R\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/EnterCodeBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/login/EnterCodeSubTitle;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/login/EnterCodeTitle;", "subtitle", "", "error", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "example", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "enterButton", "Lcom/sputnik/common/entities/localization/entities/login/AboutButton;", "aboutButton", "<init>", "(Lcom/sputnik/common/entities/localization/entities/login/EnterCodeSubTitle;Lcom/sputnik/common/entities/localization/entities/login/EnterCodeTitle;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/login/AboutButton;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/login/EnterCodeSubTitle;", "getTitle", "()Lcom/sputnik/common/entities/localization/entities/login/EnterCodeSubTitle;", "Lcom/sputnik/common/entities/localization/entities/login/EnterCodeTitle;", "getSubtitle", "()Lcom/sputnik/common/entities/localization/entities/login/EnterCodeTitle;", "Ljava/lang/String;", "getError", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getExample", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getEnterButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/entities/login/AboutButton;", "getAboutButton", "()Lcom/sputnik/common/entities/localization/entities/login/AboutButton;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EnterCodeBody implements Parcelable {
    public static final Parcelable.Creator<EnterCodeBody> CREATOR = new Creator();

    @SerializedName("about_button")
    private final AboutButton aboutButton;

    @SerializedName("enter_button")
    private final TextTitle enterButton;
    private final String error;
    private final TitleWithParam example;
    private final EnterCodeTitle subtitle;
    private final EnterCodeSubTitle title;

    /* compiled from: EnterCodeLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EnterCodeBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnterCodeBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EnterCodeBody(EnterCodeSubTitle.CREATOR.createFromParcel(parcel), EnterCodeTitle.CREATOR.createFromParcel(parcel), parcel.readString(), TitleWithParam.CREATOR.createFromParcel(parcel), TextTitle.CREATOR.createFromParcel(parcel), AboutButton.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnterCodeBody[] newArray(int i) {
            return new EnterCodeBody[i];
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
        if (!(other instanceof EnterCodeBody)) {
            return false;
        }
        EnterCodeBody enterCodeBody = (EnterCodeBody) other;
        return Intrinsics.areEqual(this.title, enterCodeBody.title) && Intrinsics.areEqual(this.subtitle, enterCodeBody.subtitle) && Intrinsics.areEqual(this.error, enterCodeBody.error) && Intrinsics.areEqual(this.example, enterCodeBody.example) && Intrinsics.areEqual(this.enterButton, enterCodeBody.enterButton) && Intrinsics.areEqual(this.aboutButton, enterCodeBody.aboutButton);
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.error.hashCode()) * 31) + this.example.hashCode()) * 31) + this.enterButton.hashCode()) * 31) + this.aboutButton.hashCode();
    }

    public String toString() {
        return "EnterCodeBody(title=" + this.title + ", subtitle=" + this.subtitle + ", error=" + this.error + ", example=" + this.example + ", enterButton=" + this.enterButton + ", aboutButton=" + this.aboutButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.title.writeToParcel(parcel, flags);
        this.subtitle.writeToParcel(parcel, flags);
        parcel.writeString(this.error);
        this.example.writeToParcel(parcel, flags);
        this.enterButton.writeToParcel(parcel, flags);
        this.aboutButton.writeToParcel(parcel, flags);
    }

    public EnterCodeBody(EnterCodeSubTitle title, EnterCodeTitle subtitle, String error, TitleWithParam example, TextTitle enterButton, AboutButton aboutButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(example, "example");
        Intrinsics.checkNotNullParameter(enterButton, "enterButton");
        Intrinsics.checkNotNullParameter(aboutButton, "aboutButton");
        this.title = title;
        this.subtitle = subtitle;
        this.error = error;
        this.example = example;
        this.enterButton = enterButton;
        this.aboutButton = aboutButton;
    }

    public final EnterCodeTitle getSubtitle() {
        return this.subtitle;
    }
}
