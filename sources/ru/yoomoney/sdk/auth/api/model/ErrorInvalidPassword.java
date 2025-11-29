package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ErrorInvalidPassword;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "attemptsLeft", "", "(I)V", "getAttemptsLeft", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ErrorInvalidPassword extends ProcessError {
    public static final Parcelable.Creator<ErrorInvalidPassword> CREATOR = new Creator();

    @SerializedName("attemptsLeft")
    private final int attemptsLeft;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ErrorInvalidPassword> {
        @Override // android.os.Parcelable.Creator
        public final ErrorInvalidPassword createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ErrorInvalidPassword(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorInvalidPassword[] newArray(int i) {
            return new ErrorInvalidPassword[i];
        }
    }

    public ErrorInvalidPassword(int i) {
        super(null);
        this.attemptsLeft = i;
    }

    public static /* synthetic */ ErrorInvalidPassword copy$default(ErrorInvalidPassword errorInvalidPassword, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = errorInvalidPassword.attemptsLeft;
        }
        return errorInvalidPassword.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public final ErrorInvalidPassword copy(int attemptsLeft) {
        return new ErrorInvalidPassword(attemptsLeft);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ErrorInvalidPassword) && this.attemptsLeft == ((ErrorInvalidPassword) other).attemptsLeft;
    }

    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public int hashCode() {
        return Integer.hashCode(this.attemptsLeft);
    }

    public String toString() {
        return "ErrorInvalidPassword(attemptsLeft=" + this.attemptsLeft + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.attemptsLeft);
    }
}
