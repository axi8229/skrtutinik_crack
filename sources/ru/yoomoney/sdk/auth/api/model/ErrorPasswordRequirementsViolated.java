package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ErrorPasswordRequirementsViolated;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ErrorPasswordRequirementsViolated extends ProcessError {
    public static final Parcelable.Creator<ErrorPasswordRequirementsViolated> CREATOR = new Creator();

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ErrorPasswordRequirementsViolated> {
        @Override // android.os.Parcelable.Creator
        public final ErrorPasswordRequirementsViolated createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ErrorPasswordRequirementsViolated(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorPasswordRequirementsViolated[] newArray(int i) {
            return new ErrorPasswordRequirementsViolated[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorPasswordRequirementsViolated(String title) {
        super(null);
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
    }

    public static /* synthetic */ ErrorPasswordRequirementsViolated copy$default(ErrorPasswordRequirementsViolated errorPasswordRequirementsViolated, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorPasswordRequirementsViolated.title;
        }
        return errorPasswordRequirementsViolated.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final ErrorPasswordRequirementsViolated copy(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new ErrorPasswordRequirementsViolated(title);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ErrorPasswordRequirementsViolated) && Intrinsics.areEqual(this.title, ((ErrorPasswordRequirementsViolated) other).title);
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.title.hashCode();
    }

    public String toString() {
        return "ErrorPasswordRequirementsViolated(title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
    }
}
