package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes3.dex */
public class ActivityConversionInfo implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityConversionInfo> CREATOR = new yn();
    public static final int ENTER_ACTIVITY_CONVERSION = 0;
    public static final int EXIT_ACTIVITY_CONVERSION = 1;

    @Packed
    private int activityType;

    @Packed
    private int conversionType;

    public static class Builder {
        private int mActivityType = -1;
        private int mConversionType = -1;

        public ActivityConversionInfo build() {
            Preconditions.checkState(this.mActivityType != -1, "ActivityType not set.");
            Preconditions.checkState(this.mConversionType != -1, "ConversionType not set.");
            return new ActivityConversionInfo(this.mActivityType, this.mConversionType);
        }

        public Builder setActivityType(int i) {
            if (!ActivityIdentificationData.isValidType(i)) {
                throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
            }
            this.mActivityType = i;
            return this;
        }

        public Builder setConversionType(int i) {
            if (i != 0 && i != 1) {
                throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
            }
            this.mConversionType = i;
            return this;
        }
    }

    static class yn implements Parcelable.Creator<ActivityConversionInfo> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityConversionInfo createFromParcel(Parcel parcel) {
            return new ActivityConversionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityConversionInfo[] newArray(int i) {
            return new ActivityConversionInfo[i];
        }
    }

    public ActivityConversionInfo() {
    }

    public ActivityConversionInfo(int i, int i2) {
        if (!ActivityIdentificationData.isValidType(i) || (i2 != 0 && i2 != 1)) {
            throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
        }
        this.activityType = i;
        this.conversionType = i2;
    }

    protected ActivityConversionInfo(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.conversionType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return true;
        }
        if (!(obj instanceof ActivityConversionInfo)) {
            return false;
        }
        ActivityConversionInfo activityConversionInfo = (ActivityConversionInfo) obj;
        return this.activityType == activityConversionInfo.getActivityType() && this.conversionType == activityConversionInfo.getConversionType();
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getConversionType() {
        return this.conversionType;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.activityType), Integer.valueOf(this.conversionType));
    }

    public void setActivityType(int i) {
        if (!ActivityIdentificationData.isValidType(i)) {
            throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
        }
        this.activityType = i;
    }

    public void setConversionType(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
        }
        this.conversionType = i;
    }

    public String toString() {
        return "ActivityConversionInfo{activityType=" + this.activityType + ", conversionType=" + this.conversionType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.conversionType);
    }
}
