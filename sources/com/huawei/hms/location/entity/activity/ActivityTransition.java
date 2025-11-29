package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;

/* loaded from: classes3.dex */
public class ActivityTransition implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new yn();
    private int activityType;
    private int transitionType;

    static class yn implements Parcelable.Creator<ActivityTransition> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityTransition createFromParcel(Parcel parcel) {
            return new ActivityTransition(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityTransition[] newArray(int i) {
            return new ActivityTransition[i];
        }
    }

    public ActivityTransition() {
    }

    protected ActivityTransition(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.transitionType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getTransitionType() {
        return this.transitionType;
    }

    public void setActivityType(int i) {
        this.activityType = i;
    }

    public void setTransitionType(int i) {
        this.transitionType = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.transitionType);
    }
}
