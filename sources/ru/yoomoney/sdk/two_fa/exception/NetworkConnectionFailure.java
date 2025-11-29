package ru.yoomoney.sdk.two_fa.exception;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Failure.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/NetworkConnectionFailure;", "Lru/yoomoney/sdk/two_fa/exception/Failure;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class NetworkConnectionFailure extends Failure {
    public static final int $stable = 0;
    public static final Parcelable.Creator<NetworkConnectionFailure> CREATOR = new Creator();
    private final String error;

    /* compiled from: Failure.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NetworkConnectionFailure> {
        @Override // android.os.Parcelable.Creator
        public final NetworkConnectionFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NetworkConnectionFailure(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final NetworkConnectionFailure[] newArray(int i) {
            return new NetworkConnectionFailure[i];
        }
    }

    public NetworkConnectionFailure() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ NetworkConnectionFailure copy$default(NetworkConnectionFailure networkConnectionFailure, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = networkConnectionFailure.error;
        }
        return networkConnectionFailure.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final NetworkConnectionFailure copy(String error) {
        return new NetworkConnectionFailure(error);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NetworkConnectionFailure) && Intrinsics.areEqual(this.error, ((NetworkConnectionFailure) other).error);
    }

    public int hashCode() {
        String str = this.error;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "NetworkConnectionFailure(error=" + this.error + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.error);
    }

    public NetworkConnectionFailure(String str) {
        super(null);
        this.error = str;
    }

    public /* synthetic */ NetworkConnectionFailure(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getError() {
        return this.error;
    }
}
