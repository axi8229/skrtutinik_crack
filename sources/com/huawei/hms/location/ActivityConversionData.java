package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ActivityConversionData implements Parcelable {
    public static final Parcelable.Creator<ActivityConversionData> CREATOR = new yn();
    private int activityType;
    private int conversionType;
    private long elapsedTimeFromReboot;

    static class yn implements Parcelable.Creator<ActivityConversionData> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityConversionData createFromParcel(Parcel parcel) {
            return new ActivityConversionData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityConversionData[] newArray(int i) {
            return new ActivityConversionData[0];
        }
    }

    public ActivityConversionData() {
    }

    public ActivityConversionData(int i, int i2, long j) {
        if (!ActivityIdentificationData.isValidType(i) || (i2 != 0 && i2 != 1)) {
            throw new IllegalArgumentException("ActivityConversionData:The parameter is out of range");
        }
        this.activityType = i;
        this.conversionType = i2;
        this.elapsedTimeFromReboot = j;
    }

    private ActivityConversionData(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.conversionType = parcel.readInt();
        this.elapsedTimeFromReboot = parcel.readLong();
    }

    /* synthetic */ ActivityConversionData(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityConversionData)) {
            return false;
        }
        ActivityConversionData activityConversionData = (ActivityConversionData) obj;
        return this.activityType == activityConversionData.getActivityType() && this.conversionType == activityConversionData.getConversionType() && this.elapsedTimeFromReboot == activityConversionData.getElapsedTimeFromReboot();
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getConversionType() {
        return this.conversionType;
    }

    public long getElapsedTimeFromReboot() {
        return this.elapsedTimeFromReboot;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "ActivityConversionData{activityType=" + this.activityType + ", conversionType=" + this.conversionType + ", elapsedTimeFromReboot=" + this.elapsedTimeFromReboot + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.conversionType);
        parcel.writeLong(this.elapsedTimeFromReboot);
    }
}
