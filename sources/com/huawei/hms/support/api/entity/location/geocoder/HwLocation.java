package com.huawei.hms.support.api.entity.location.geocoder;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class HwLocation extends LocationBaseResponse implements Parcelable {
    public static final Parcelable.Creator<HwLocation> CREATOR = new yn();
    private Address address;
    private Location location;

    static class yn implements Parcelable.Creator<HwLocation> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public HwLocation createFromParcel(Parcel parcel) {
            return new HwLocation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HwLocation[] newArray(int i) {
            return new HwLocation[i];
        }
    }

    public HwLocation() {
    }

    public HwLocation(Location location) {
        this.location = location;
    }

    public HwLocation(Location location, Address address) {
        this.location = location;
        this.address = address;
    }

    public HwLocation(Parcel parcel) {
        if (this.location == null) {
            this.location = new Location(parcel.readString());
        }
        this.location.setTime(parcel.readLong());
        int i = Build.VERSION.SDK_INT;
        this.location.setElapsedRealtimeNanos(parcel.readLong());
        parcel.readByte();
        this.location.setLatitude(parcel.readDouble());
        this.location.setLongitude(parcel.readDouble());
        this.location.setAltitude(parcel.readDouble());
        this.location.setSpeed(parcel.readFloat());
        this.location.setBearing(parcel.readFloat());
        this.location.setAccuracy(parcel.readFloat());
        if (i >= 26) {
            this.location.setVerticalAccuracyMeters(parcel.readFloat());
            this.location.setSpeedAccuracyMetersPerSecond(parcel.readFloat());
            this.location.setBearingAccuracyDegrees(parcel.readFloat());
        }
        this.location.setExtras(parcel.readBundle(HwLocation.class.getClassLoader()));
        if (this.address == null) {
            this.address = new Address();
        }
        this.address.setCountryCode(parcel.readString());
        this.address.setCountryName(parcel.readString());
        this.address.setState(parcel.readString());
        this.address.setCity(parcel.readString());
        this.address.setCounty(parcel.readString());
        this.address.setStreet(parcel.readString());
        this.address.setFeatureName(parcel.readString());
        this.address.setPostalCode(parcel.readString());
        this.address.setPhone(parcel.readString());
        this.address.setUrl(parcel.readString());
        HashMap map = new HashMap();
        parcel.readMap(map, HwLocation.class.getClassLoader());
        this.address.setExtraInfo(map);
    }

    private String getDefaultVal(String str) {
        return str == null ? "" : str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Address getAddress() {
        return this.address;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Location location = this.location;
        if (location != null) {
            parcel.writeString(getDefaultVal(location.getProvider()));
            parcel.writeLong(this.location.getTime());
            int i2 = Build.VERSION.SDK_INT;
            parcel.writeLong(this.location.getElapsedRealtimeNanos());
            parcel.writeByte((byte) 0);
            parcel.writeDouble(this.location.getLatitude());
            parcel.writeDouble(this.location.getLongitude());
            parcel.writeDouble(this.location.getAltitude());
            parcel.writeFloat(this.location.getSpeed());
            parcel.writeFloat(this.location.getBearing());
            parcel.writeFloat(this.location.getAccuracy());
            if (i2 >= 26) {
                parcel.writeFloat(this.location.getVerticalAccuracyMeters());
                parcel.writeFloat(this.location.getSpeedAccuracyMetersPerSecond());
                parcel.writeFloat(this.location.getBearingAccuracyDegrees());
            }
            parcel.writeBundle(this.location.getExtras());
        }
        Address address = this.address;
        if (address != null) {
            parcel.writeString(getDefaultVal(address.getCountryCode()));
            parcel.writeString(getDefaultVal(this.address.getCountryName()));
            parcel.writeString(getDefaultVal(this.address.getState()));
            parcel.writeString(getDefaultVal(this.address.getCity()));
            parcel.writeString(getDefaultVal(this.address.getCounty()));
            parcel.writeString(getDefaultVal(this.address.getStreet()));
            parcel.writeString(getDefaultVal(this.address.getFeatureName()));
            parcel.writeString(getDefaultVal(this.address.getPostalCode()));
            parcel.writeString(getDefaultVal(this.address.getPhone()));
            parcel.writeString(getDefaultVal(this.address.getUrl()));
            parcel.writeMap(this.address.getExtraInfo());
        }
    }
}
