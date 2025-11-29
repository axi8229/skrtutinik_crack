package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ErrorCodeExpired;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "nextResendFrom", "Lorg/threeten/bp/OffsetDateTime;", "(Lorg/threeten/bp/OffsetDateTime;)V", "getNextResendFrom", "()Lorg/threeten/bp/OffsetDateTime;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ErrorCodeExpired extends ProcessError {
    public static final Parcelable.Creator<ErrorCodeExpired> CREATOR = new Creator();

    @SerializedName("nextResendFrom")
    private final OffsetDateTime nextResendFrom;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ErrorCodeExpired> {
        @Override // android.os.Parcelable.Creator
        public final ErrorCodeExpired createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ErrorCodeExpired((OffsetDateTime) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorCodeExpired[] newArray(int i) {
            return new ErrorCodeExpired[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorCodeExpired(OffsetDateTime nextResendFrom) {
        super(null);
        Intrinsics.checkNotNullParameter(nextResendFrom, "nextResendFrom");
        this.nextResendFrom = nextResendFrom;
    }

    public static /* synthetic */ ErrorCodeExpired copy$default(ErrorCodeExpired errorCodeExpired, OffsetDateTime offsetDateTime, int i, Object obj) {
        if ((i & 1) != 0) {
            offsetDateTime = errorCodeExpired.nextResendFrom;
        }
        return errorCodeExpired.copy(offsetDateTime);
    }

    /* renamed from: component1, reason: from getter */
    public final OffsetDateTime getNextResendFrom() {
        return this.nextResendFrom;
    }

    public final ErrorCodeExpired copy(OffsetDateTime nextResendFrom) {
        Intrinsics.checkNotNullParameter(nextResendFrom, "nextResendFrom");
        return new ErrorCodeExpired(nextResendFrom);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ErrorCodeExpired) && Intrinsics.areEqual(this.nextResendFrom, ((ErrorCodeExpired) other).nextResendFrom);
    }

    public final OffsetDateTime getNextResendFrom() {
        return this.nextResendFrom;
    }

    public int hashCode() {
        return this.nextResendFrom.hashCode();
    }

    public String toString() {
        return "ErrorCodeExpired(nextResendFrom=" + this.nextResendFrom + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeSerializable(this.nextResendFrom);
    }
}
