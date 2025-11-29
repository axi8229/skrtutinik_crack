package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ErrorProcessingRequest;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "retryAfter", "", "(Ljava/lang/Integer;)V", "getRetryAfter", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lru/yoomoney/sdk/auth/api/model/ErrorProcessingRequest;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ErrorProcessingRequest extends ProcessError {
    public static final Parcelable.Creator<ErrorProcessingRequest> CREATOR = new Creator();

    @SerializedName("retryAfter")
    private final Integer retryAfter;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ErrorProcessingRequest> {
        @Override // android.os.Parcelable.Creator
        public final ErrorProcessingRequest createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ErrorProcessingRequest(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorProcessingRequest[] newArray(int i) {
            return new ErrorProcessingRequest[i];
        }
    }

    public ErrorProcessingRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ErrorProcessingRequest copy$default(ErrorProcessingRequest errorProcessingRequest, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = errorProcessingRequest.retryAfter;
        }
        return errorProcessingRequest.copy(num);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getRetryAfter() {
        return this.retryAfter;
    }

    public final ErrorProcessingRequest copy(Integer retryAfter) {
        return new ErrorProcessingRequest(retryAfter);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ErrorProcessingRequest) && Intrinsics.areEqual(this.retryAfter, ((ErrorProcessingRequest) other).retryAfter);
    }

    public final Integer getRetryAfter() {
        return this.retryAfter;
    }

    public int hashCode() {
        Integer num = this.retryAfter;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "ErrorProcessingRequest(retryAfter=" + this.retryAfter + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.retryAfter;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
    }

    public ErrorProcessingRequest(Integer num) {
        super(null);
        this.retryAfter = num;
    }

    public /* synthetic */ ErrorProcessingRequest(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }
}
