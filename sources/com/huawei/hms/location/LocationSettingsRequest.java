package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public class LocationSettingsRequest implements IMessageEntity, Parcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new yn();

    @Packed
    public boolean alwaysShow;

    @Packed
    public boolean needBle;

    @Packed
    public List<LocationRequest> requests;

    public static class Builder {
        private List<LocationRequest> requests = new ArrayList();
        private boolean alwaysShow = false;
        private boolean needBle = false;

        public Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            this.requests.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest) {
            this.requests.add(locationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.requests, this.alwaysShow, this.needBle, null);
        }

        public Builder setAlwaysShow(boolean z) {
            this.alwaysShow = z;
            return this;
        }

        public Builder setNeedBle(boolean z) {
            this.needBle = z;
            return this;
        }
    }

    static class yn implements Parcelable.Creator<LocationSettingsRequest> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public LocationSettingsRequest createFromParcel(Parcel parcel) {
            return new LocationSettingsRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LocationSettingsRequest[] newArray(int i) {
            return new LocationSettingsRequest[i];
        }
    }

    private LocationSettingsRequest() {
    }

    protected LocationSettingsRequest(Parcel parcel) {
        this.alwaysShow = parcel.readByte() != 0;
        this.needBle = parcel.readByte() != 0;
    }

    private LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2) {
        this.requests = list;
        this.alwaysShow = z;
        this.needBle = z2;
    }

    /* synthetic */ LocationSettingsRequest(List list, boolean z, boolean z2, yn ynVar) {
        this(list, z, z2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.requests);
        parcel.writeByte(this.alwaysShow ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needBle ? (byte) 1 : (byte) 0);
    }
}
