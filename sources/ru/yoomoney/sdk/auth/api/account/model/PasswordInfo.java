package ru.yoomoney.sdk.auth.api.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\nHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/PasswordInfo;", "Landroid/os/Parcelable;", "modifiable", "", "(Z)V", "getModifiable", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PasswordInfo implements Parcelable {
    public static final Parcelable.Creator<PasswordInfo> CREATOR = new Creator();

    @SerializedName("modifiable")
    private final boolean modifiable;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PasswordInfo> {
        @Override // android.os.Parcelable.Creator
        public final PasswordInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PasswordInfo(parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final PasswordInfo[] newArray(int i) {
            return new PasswordInfo[i];
        }
    }

    public PasswordInfo(boolean z) {
        this.modifiable = z;
    }

    public static /* synthetic */ PasswordInfo copy$default(PasswordInfo passwordInfo, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = passwordInfo.modifiable;
        }
        return passwordInfo.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getModifiable() {
        return this.modifiable;
    }

    public final PasswordInfo copy(boolean modifiable) {
        return new PasswordInfo(modifiable);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PasswordInfo) && this.modifiable == ((PasswordInfo) other).modifiable;
    }

    public final boolean getModifiable() {
        return this.modifiable;
    }

    public int hashCode() {
        return Boolean.hashCode(this.modifiable);
    }

    public String toString() {
        return "PasswordInfo(modifiable=" + this.modifiable + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.modifiable ? 1 : 0);
    }
}
