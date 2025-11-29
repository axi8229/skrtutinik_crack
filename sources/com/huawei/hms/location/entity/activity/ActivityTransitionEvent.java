package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ActivityTransitionEvent implements Parcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new yn();
    private int activityType;
    private long elapsedRealTimeNanos;
    private int transitionType;

    static class yn implements Parcelable.Creator<ActivityTransitionEvent> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityTransitionEvent createFromParcel(Parcel parcel) {
            return new ActivityTransitionEvent(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityTransitionEvent[] newArray(int i) {
            return new ActivityTransitionEvent[0];
        }
    }

    public ActivityTransitionEvent(int i, int i2, long j) {
        this.activityType = i;
        this.transitionType = i2;
        this.elapsedRealTimeNanos = j;
    }

    private ActivityTransitionEvent(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.transitionType = parcel.readInt();
        this.elapsedRealTimeNanos = parcel.readLong();
    }

    /* synthetic */ ActivityTransitionEvent(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public long getElapsedRealTimeNanos() {
        return this.elapsedRealTimeNanos;
    }

    public int getTransitionType() {
        return this.transitionType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.transitionType);
        parcel.writeLong(this.elapsedRealTimeNanos);
    }
}
