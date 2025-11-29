package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.location.fence.GeofenceEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class GeofenceRequest implements Parcelable, IMessageEntity {
    private static final int CONVERSIONS_MAX = 7;
    private static final int CONVERSIONS_MIN = 0;
    public static final int COORDINATE_TYPE_GCJ_02 = 0;
    public static final int COORDINATE_TYPE_WGS_84 = 1;
    public static final Parcelable.Creator<GeofenceRequest> CREATOR = new yn();
    public static final int DWELL_INIT_CONVERSION = 4;
    public static final int ENTER_INIT_CONVERSION = 1;
    public static final int EXIT_INIT_CONVERSION = 2;

    @Packed
    private int coordinateType;

    @Packed
    private List<GeofenceEntity> geofenceList;

    @Packed
    private int initConversions;

    public static final class Builder {
        private final List<GeofenceEntity> geofenceList = new ArrayList();
        private int initConversions = 5;
        private int coordinateType = 1;

        public GeofenceRequest build() {
            Preconditions.checkArgument(!this.geofenceList.isEmpty(), "No geofence has been added.");
            int i = this.coordinateType;
            if (i != 0 && i != 1) {
                this.coordinateType = 1;
            }
            HashSet hashSet = new HashSet();
            Iterator<GeofenceEntity> it = this.geofenceList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getUniqueId());
            }
            if (hashSet.size() != this.geofenceList.size()) {
                throw new IllegalArgumentException("more than one geofence has same requestId.");
            }
            int i2 = this.initConversions;
            if (i2 > 7 || i2 < 0) {
                throw new IllegalArgumentException("invalid initConversions");
            }
            return new GeofenceRequest(this.geofenceList, i2, this.coordinateType);
        }

        public Builder createGeofence(Geofence geofence) {
            Preconditions.checkNotNull(geofence, "geofence can't be null.");
            Preconditions.checkArgument(geofence instanceof GeofenceEntity, "Geofence must be instanceof GeofenceEntity");
            this.geofenceList.add((GeofenceEntity) geofence);
            return this;
        }

        public Builder createGeofenceList(List<Geofence> list) {
            if (list != null && !list.isEmpty()) {
                for (Geofence geofence : list) {
                    if (geofence != null) {
                        createGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public Builder setCoordinateType(int i) {
            this.coordinateType = i;
            return this;
        }

        public Builder setInitConversions(int i) {
            this.initConversions = i;
            return this;
        }
    }

    static class yn implements Parcelable.Creator<GeofenceRequest> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public GeofenceRequest createFromParcel(Parcel parcel) {
            return new GeofenceRequest(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public GeofenceRequest[] newArray(int i) {
            return new GeofenceRequest[i];
        }
    }

    public GeofenceRequest() {
    }

    private GeofenceRequest(Parcel parcel) {
        this.geofenceList = parcel.createTypedArrayList(GeofenceEntity.CREATOR);
        this.initConversions = parcel.readInt();
        this.coordinateType = parcel.readInt();
    }

    /* synthetic */ GeofenceRequest(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    GeofenceRequest(List<GeofenceEntity> list, int i, int i2) {
        this.geofenceList = list;
        this.initConversions = i;
        this.coordinateType = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCoordinateType() {
        return this.coordinateType;
    }

    public List<Geofence> getGeofences() {
        return this.geofenceList == null ? new ArrayList() : new ArrayList(this.geofenceList);
    }

    public int getInitConversions() {
        return this.initConversions;
    }

    public String toString() {
        return "GeofenceRequest{geofenceList=" + this.geofenceList + ", initConversions=" + this.initConversions + ", coordinateType=" + this.coordinateType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.geofenceList);
        parcel.writeInt(this.initConversions);
        parcel.writeInt(this.coordinateType);
    }
}
