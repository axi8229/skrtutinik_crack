package com.sputnik.common.entities.localization.entities.our_home;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OurHomeUpdateLocale.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdatePopup;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "okButton", "laterButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getBody", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getOkButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getLaterButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OurHomeUpdatePopup implements Parcelable {
    public static final Parcelable.Creator<OurHomeUpdatePopup> CREATOR = new Creator();
    private final String body;

    @SerializedName("later_button")
    private final TextTitle laterButton;

    @SerializedName("ok_button")
    private final TextTitle okButton;
    private final String title;

    /* compiled from: OurHomeUpdateLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OurHomeUpdatePopup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OurHomeUpdatePopup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OurHomeUpdatePopup(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OurHomeUpdatePopup[] newArray(int i) {
            return new OurHomeUpdatePopup[i];
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
        if (!(other instanceof OurHomeUpdatePopup)) {
            return false;
        }
        OurHomeUpdatePopup ourHomeUpdatePopup = (OurHomeUpdatePopup) other;
        return Intrinsics.areEqual(this.title, ourHomeUpdatePopup.title) && Intrinsics.areEqual(this.body, ourHomeUpdatePopup.body) && Intrinsics.areEqual(this.okButton, ourHomeUpdatePopup.okButton) && Intrinsics.areEqual(this.laterButton, ourHomeUpdatePopup.laterButton);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.body;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        TextTitle textTitle = this.okButton;
        int iHashCode3 = (iHashCode2 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        TextTitle textTitle2 = this.laterButton;
        return iHashCode3 + (textTitle2 != null ? textTitle2.hashCode() : 0);
    }

    public String toString() {
        return "OurHomeUpdatePopup(title=" + this.title + ", body=" + this.body + ", okButton=" + this.okButton + ", laterButton=" + this.laterButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        TextTitle textTitle = this.okButton;
        if (textTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle.writeToParcel(parcel, flags);
        }
        TextTitle textTitle2 = this.laterButton;
        if (textTitle2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle2.writeToParcel(parcel, flags);
        }
    }

    public OurHomeUpdatePopup(String str, String str2, TextTitle textTitle, TextTitle textTitle2) {
        this.title = str;
        this.body = str2;
        this.okButton = textTitle;
        this.laterButton = textTitle2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final TextTitle getOkButton() {
        return this.okButton;
    }

    public final TextTitle getLaterButton() {
        return this.laterButton;
    }
}
