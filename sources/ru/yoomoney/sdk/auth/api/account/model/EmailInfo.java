package ru.yoomoney.sdk.auth.api.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/EmailInfo;", "Landroid/os/Parcelable;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "modifiable", "", "(Ljava/lang/String;Z)V", "getModifiable", "()Z", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EmailInfo implements Parcelable {
    public static final Parcelable.Creator<EmailInfo> CREATOR = new Creator();

    @SerializedName("modifiable")
    private final boolean modifiable;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EmailInfo> {
        @Override // android.os.Parcelable.Creator
        public final EmailInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EmailInfo(parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final EmailInfo[] newArray(int i) {
            return new EmailInfo[i];
        }
    }

    public EmailInfo(String str, boolean z) {
        this.title = str;
        this.modifiable = z;
    }

    public static /* synthetic */ EmailInfo copy$default(EmailInfo emailInfo, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emailInfo.title;
        }
        if ((i & 2) != 0) {
            z = emailInfo.modifiable;
        }
        return emailInfo.copy(str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getModifiable() {
        return this.modifiable;
    }

    public final EmailInfo copy(String title, boolean modifiable) {
        return new EmailInfo(title, modifiable);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailInfo)) {
            return false;
        }
        EmailInfo emailInfo = (EmailInfo) other;
        return Intrinsics.areEqual(this.title, emailInfo.title) && this.modifiable == emailInfo.modifiable;
    }

    public final boolean getModifiable() {
        return this.modifiable;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        return Boolean.hashCode(this.modifiable) + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public String toString() {
        return "EmailInfo(title=" + this.title + ", modifiable=" + this.modifiable + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeInt(this.modifiable ? 1 : 0);
    }
}
