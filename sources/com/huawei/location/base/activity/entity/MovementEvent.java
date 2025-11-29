package com.huawei.location.base.activity.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class MovementEvent implements Parcelable {
    public static final Parcelable.Creator<MovementEvent> CREATOR = new yn();
    private int mEventType;
    private String mMovement;

    static class yn implements Parcelable.Creator<MovementEvent> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public MovementEvent createFromParcel(Parcel parcel) {
            return new MovementEvent(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public MovementEvent[] newArray(int i) {
            return new MovementEvent[i];
        }
    }

    public MovementEvent(String str, int i) {
        this.mMovement = str;
        this.mEventType = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.mEventType;
    }

    public String getMovement() {
        return this.mMovement;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMovement);
        parcel.writeInt(this.mEventType);
    }
}
