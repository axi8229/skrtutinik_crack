package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ErrorInvalidCode;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "attemptsLeft", "", "nextResendFrom", "Lorg/threeten/bp/OffsetDateTime;", "(ILorg/threeten/bp/OffsetDateTime;)V", "getAttemptsLeft", "()I", "getNextResendFrom", "()Lorg/threeten/bp/OffsetDateTime;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ErrorInvalidCode extends ProcessError {
    public static final Parcelable.Creator<ErrorInvalidCode> CREATOR = new Creator();

    @SerializedName("attemptsLeft")
    private final int attemptsLeft;

    @SerializedName("nextResendFrom")
    private final OffsetDateTime nextResendFrom;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ErrorInvalidCode> {
        @Override // android.os.Parcelable.Creator
        public final ErrorInvalidCode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ErrorInvalidCode(parcel.readInt(), (OffsetDateTime) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorInvalidCode[] newArray(int i) {
            return new ErrorInvalidCode[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorInvalidCode(int i, OffsetDateTime nextResendFrom) {
        super(null);
        Intrinsics.checkNotNullParameter(nextResendFrom, "nextResendFrom");
        this.attemptsLeft = i;
        this.nextResendFrom = nextResendFrom;
    }

    public static /* synthetic */ ErrorInvalidCode copy$default(ErrorInvalidCode errorInvalidCode, int i, OffsetDateTime offsetDateTime, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = errorInvalidCode.attemptsLeft;
        }
        if ((i2 & 2) != 0) {
            offsetDateTime = errorInvalidCode.nextResendFrom;
        }
        return errorInvalidCode.copy(i, offsetDateTime);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    /* renamed from: component2, reason: from getter */
    public final OffsetDateTime getNextResendFrom() {
        return this.nextResendFrom;
    }

    public final ErrorInvalidCode copy(int attemptsLeft, OffsetDateTime nextResendFrom) {
        Intrinsics.checkNotNullParameter(nextResendFrom, "nextResendFrom");
        return new ErrorInvalidCode(attemptsLeft, nextResendFrom);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorInvalidCode)) {
            return false;
        }
        ErrorInvalidCode errorInvalidCode = (ErrorInvalidCode) other;
        return this.attemptsLeft == errorInvalidCode.attemptsLeft && Intrinsics.areEqual(this.nextResendFrom, errorInvalidCode.nextResendFrom);
    }

    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public final OffsetDateTime getNextResendFrom() {
        return this.nextResendFrom;
    }

    public int hashCode() {
        return this.nextResendFrom.hashCode() + (Integer.hashCode(this.attemptsLeft) * 31);
    }

    public String toString() {
        return "ErrorInvalidCode(attemptsLeft=" + this.attemptsLeft + ", nextResendFrom=" + this.nextResendFrom + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.attemptsLeft);
        parcel.writeSerializable(this.nextResendFrom);
    }
}
