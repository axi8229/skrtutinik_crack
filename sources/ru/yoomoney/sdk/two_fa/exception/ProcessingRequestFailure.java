package ru.yoomoney.sdk.two_fa.exception;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Failure.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/ProcessingRequestFailure;", "Lru/yoomoney/sdk/two_fa/exception/Failure;", "error", "", "retryAfter", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getError", "()Ljava/lang/String;", "getRetryAfter", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lru/yoomoney/sdk/two_fa/exception/ProcessingRequestFailure;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ProcessingRequestFailure extends Failure {
    public static final int $stable = 0;
    public static final Parcelable.Creator<ProcessingRequestFailure> CREATOR = new Creator();
    private final String error;
    private final Integer retryAfter;

    /* compiled from: Failure.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProcessingRequestFailure> {
        @Override // android.os.Parcelable.Creator
        public final ProcessingRequestFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ProcessingRequestFailure(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        public final ProcessingRequestFailure[] newArray(int i) {
            return new ProcessingRequestFailure[i];
        }
    }

    public ProcessingRequestFailure() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ProcessingRequestFailure copy$default(ProcessingRequestFailure processingRequestFailure, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = processingRequestFailure.error;
        }
        if ((i & 2) != 0) {
            num = processingRequestFailure.retryAfter;
        }
        return processingRequestFailure.copy(str, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getRetryAfter() {
        return this.retryAfter;
    }

    public final ProcessingRequestFailure copy(String error, Integer retryAfter) {
        return new ProcessingRequestFailure(error, retryAfter);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessingRequestFailure)) {
            return false;
        }
        ProcessingRequestFailure processingRequestFailure = (ProcessingRequestFailure) other;
        return Intrinsics.areEqual(this.error, processingRequestFailure.error) && Intrinsics.areEqual(this.retryAfter, processingRequestFailure.retryAfter);
    }

    public int hashCode() {
        String str = this.error;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.retryAfter;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ProcessingRequestFailure(error=" + this.error + ", retryAfter=" + this.retryAfter + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.error);
        Integer num = this.retryAfter;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
    }

    public /* synthetic */ ProcessingRequestFailure(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
    }

    public final String getError() {
        return this.error;
    }

    public final Integer getRetryAfter() {
        return this.retryAfter;
    }

    public ProcessingRequestFailure(String str, Integer num) {
        super(null);
        this.error = str;
        this.retryAfter = num;
    }
}
