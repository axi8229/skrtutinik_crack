package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWith2Params;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AboutCodeLocale.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/AboutCodeBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TitleWith2Params;", "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "okButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TitleWith2Params;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TitleWith2Params;", "getSubtitle", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWith2Params;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getOkButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AboutCodeBody implements Parcelable {
    public static final Parcelable.Creator<AboutCodeBody> CREATOR = new Creator();

    @SerializedName("ok_button")
    private final TextTitle okButton;
    private final TitleWith2Params subtitle;
    private final String title;

    /* compiled from: AboutCodeLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AboutCodeBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AboutCodeBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AboutCodeBody(parcel.readString(), TitleWith2Params.CREATOR.createFromParcel(parcel), TextTitle.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AboutCodeBody[] newArray(int i) {
            return new AboutCodeBody[i];
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
        if (!(other instanceof AboutCodeBody)) {
            return false;
        }
        AboutCodeBody aboutCodeBody = (AboutCodeBody) other;
        return Intrinsics.areEqual(this.title, aboutCodeBody.title) && Intrinsics.areEqual(this.subtitle, aboutCodeBody.subtitle) && Intrinsics.areEqual(this.okButton, aboutCodeBody.okButton);
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.okButton.hashCode();
    }

    public String toString() {
        return "AboutCodeBody(title=" + this.title + ", subtitle=" + this.subtitle + ", okButton=" + this.okButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        this.subtitle.writeToParcel(parcel, flags);
        this.okButton.writeToParcel(parcel, flags);
    }

    public AboutCodeBody(String title, TitleWith2Params subtitle, TextTitle okButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(okButton, "okButton");
        this.title = title;
        this.subtitle = subtitle;
        this.okButton = okButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TitleWith2Params getSubtitle() {
        return this.subtitle;
    }

    public final TextTitle getOkButton() {
        return this.okButton;
    }
}
