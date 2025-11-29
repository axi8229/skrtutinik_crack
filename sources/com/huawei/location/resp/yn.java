package com.huawei.location.resp;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class yn implements Parcelable {
    public static final Parcelable.Creator<yn> CREATOR = new C0095yn();
    private Location yn;

    /* renamed from: com.huawei.location.resp.yn$yn, reason: collision with other inner class name */
    static class C0095yn implements Parcelable.Creator<yn> {
        C0095yn() {
        }

        @Override // android.os.Parcelable.Creator
        public yn createFromParcel(Parcel parcel) {
            return new yn(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public yn[] newArray(int i) {
            return new yn[i];
        }
    }

    public yn() {
    }

    public yn(Location location) {
        this.yn = location;
    }

    public yn(Parcel parcel) {
        if (this.yn == null) {
            this.yn = new Location(parcel.readString());
        }
        this.yn.setTime(parcel.readLong());
        this.yn.setElapsedRealtimeNanos(parcel.readLong());
        parcel.readByte();
        this.yn.setLatitude(parcel.readDouble());
        this.yn.setLongitude(parcel.readDouble());
        this.yn.setAltitude(parcel.readDouble());
        this.yn.setSpeed(parcel.readFloat());
        this.yn.setBearing(parcel.readFloat());
        this.yn.setAccuracy(parcel.readFloat());
        if (Build.VERSION.SDK_INT >= 26) {
            this.yn.setVerticalAccuracyMeters(parcel.readFloat());
            this.yn.setSpeedAccuracyMetersPerSecond(parcel.readFloat());
            this.yn.setBearingAccuracyDegrees(parcel.readFloat());
        }
        this.yn.setExtras(parcel.readBundle(yn.class.getClassLoader()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Location location = this.yn;
        if (location != null) {
            String provider = location.getProvider();
            if (provider == null) {
                provider = "";
            }
            parcel.writeString(provider);
            parcel.writeLong(this.yn.getTime());
            parcel.writeLong(this.yn.getElapsedRealtimeNanos());
            parcel.writeByte((byte) 0);
            parcel.writeDouble(this.yn.getLatitude());
            parcel.writeDouble(this.yn.getLongitude());
            parcel.writeDouble(this.yn.getAltitude());
            parcel.writeFloat(this.yn.getSpeed());
            parcel.writeFloat(this.yn.getBearing());
            parcel.writeFloat(this.yn.getAccuracy());
            if (Build.VERSION.SDK_INT >= 26) {
                parcel.writeFloat(this.yn.getVerticalAccuracyMeters());
                parcel.writeFloat(this.yn.getSpeedAccuracyMetersPerSecond());
                parcel.writeFloat(this.yn.getBearingAccuracyDegrees());
            }
            parcel.writeBundle(this.yn.getExtras());
        }
    }

    public Location yn() {
        return this.yn;
    }
}
