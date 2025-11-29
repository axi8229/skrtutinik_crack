package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/TechnicalFailure;", "Lru/yoomoney/sdk/auth/api/model/Failure;", "retryAfter", "", "(Ljava/lang/Long;)V", "getRetryAfter", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lru/yoomoney/sdk/auth/api/model/TechnicalFailure;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TechnicalFailure extends Failure {
    public static final Parcelable.Creator<TechnicalFailure> CREATOR = new Creator();
    private final Long retryAfter;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TechnicalFailure> {
        @Override // android.os.Parcelable.Creator
        public final TechnicalFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TechnicalFailure(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        public final TechnicalFailure[] newArray(int i) {
            return new TechnicalFailure[i];
        }
    }

    public TechnicalFailure() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TechnicalFailure copy$default(TechnicalFailure technicalFailure, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = technicalFailure.retryAfter;
        }
        return technicalFailure.copy(l);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getRetryAfter() {
        return this.retryAfter;
    }

    public final TechnicalFailure copy(Long retryAfter) {
        return new TechnicalFailure(retryAfter);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TechnicalFailure) && Intrinsics.areEqual(this.retryAfter, ((TechnicalFailure) other).retryAfter);
    }

    public final Long getRetryAfter() {
        return this.retryAfter;
    }

    public int hashCode() {
        Long l = this.retryAfter;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "TechnicalFailure(retryAfter=" + this.retryAfter + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.retryAfter;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }

    public TechnicalFailure(Long l) {
        super(null);
        this.retryAfter = l;
    }

    public /* synthetic */ TechnicalFailure(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l);
    }
}
