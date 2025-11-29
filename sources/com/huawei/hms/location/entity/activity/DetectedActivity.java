package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class DetectedActivity implements Parcelable {
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new yn();
    private int confidence;
    private int type;

    static class yn implements Parcelable.Creator<DetectedActivity> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public DetectedActivity createFromParcel(Parcel parcel) {
            return new DetectedActivity(parcel, (yn) null);
        }

        @Override // android.os.Parcelable.Creator
        public DetectedActivity[] newArray(int i) {
            return new DetectedActivity[i];
        }
    }

    public DetectedActivity() {
    }

    public DetectedActivity(int i, int i2) {
        this.confidence = i2;
        this.type = i;
    }

    private DetectedActivity(Parcel parcel) {
        this.type = parcel.readInt();
        this.confidence = parcel.readInt();
    }

    /* synthetic */ DetectedActivity(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public int getType() {
        return this.type;
    }

    public void setConfidence(int i) {
        this.confidence = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.confidence);
    }
}
