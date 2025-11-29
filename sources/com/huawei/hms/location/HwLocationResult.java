package com.huawei.hms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class HwLocationResult implements Parcelable {
    public static final Parcelable.Creator<HwLocationResult> CREATOR = new yn();
    private int code;
    private Location location;
    private String message;

    static class yn implements Parcelable.Creator<HwLocationResult> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public HwLocationResult createFromParcel(Parcel parcel) {
            return new HwLocationResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HwLocationResult[] newArray(int i) {
            return new HwLocationResult[i];
        }
    }

    public HwLocationResult() {
    }

    public HwLocationResult(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public HwLocationResult(int i, String str, Location location) {
        this.code = i;
        this.message = str;
        this.location = location;
    }

    protected HwLocationResult(Parcel parcel) {
        this.code = parcel.readInt();
        this.message = parcel.readString();
        this.location = (Location) parcel.readParcelable(Location.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeParcelable(this.location, i);
    }
}
