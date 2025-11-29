package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomofonLocale.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b \u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010\u000b¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/DomofonTimingStatus;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/login/DomofonTiming;", "timing", "", "refreshing", "getting", "activated", "<init>", "(Lcom/sputnik/common/entities/localization/entities/login/DomofonTiming;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/login/DomofonTiming;", "getTiming", "()Lcom/sputnik/common/entities/localization/entities/login/DomofonTiming;", "Ljava/lang/String;", "getRefreshing", "getGetting", "getActivated", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomofonTimingStatus implements Parcelable {
    public static final Parcelable.Creator<DomofonTimingStatus> CREATOR = new Creator();
    private final String activated;
    private final String getting;
    private final String refreshing;
    private final DomofonTiming timing;

    /* compiled from: DomofonLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DomofonTimingStatus> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DomofonTimingStatus createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DomofonTimingStatus(DomofonTiming.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DomofonTimingStatus[] newArray(int i) {
            return new DomofonTimingStatus[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomofonTimingStatus)) {
            return false;
        }
        DomofonTimingStatus domofonTimingStatus = (DomofonTimingStatus) other;
        return Intrinsics.areEqual(this.timing, domofonTimingStatus.timing) && Intrinsics.areEqual(this.refreshing, domofonTimingStatus.refreshing) && Intrinsics.areEqual(this.getting, domofonTimingStatus.getting) && Intrinsics.areEqual(this.activated, domofonTimingStatus.activated);
    }

    public int hashCode() {
        return (((((this.timing.hashCode() * 31) + this.refreshing.hashCode()) * 31) + this.getting.hashCode()) * 31) + this.activated.hashCode();
    }

    public String toString() {
        return "DomofonTimingStatus(timing=" + this.timing + ", refreshing=" + this.refreshing + ", getting=" + this.getting + ", activated=" + this.activated + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.timing.writeToParcel(parcel, flags);
        parcel.writeString(this.refreshing);
        parcel.writeString(this.getting);
        parcel.writeString(this.activated);
    }

    public DomofonTimingStatus(DomofonTiming timing, String refreshing, String getting, String activated) {
        Intrinsics.checkNotNullParameter(timing, "timing");
        Intrinsics.checkNotNullParameter(refreshing, "refreshing");
        Intrinsics.checkNotNullParameter(getting, "getting");
        Intrinsics.checkNotNullParameter(activated, "activated");
        this.timing = timing;
        this.refreshing = refreshing;
        this.getting = getting;
        this.activated = activated;
    }

    public final DomofonTiming getTiming() {
        return this.timing;
    }

    public final String getGetting() {
        return this.getting;
    }
}
