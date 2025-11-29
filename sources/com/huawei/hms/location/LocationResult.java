package com.huawei.hms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class LocationResult implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<LocationResult> CREATOR = new yn();
    private static final String EXTRA_KEY = "com.huawei.hms.location.EXTRA_LOCATION_RESULT";
    private static final String TAG = "LocationResult";

    @Packed
    private List<HWLocation> locations;

    static class yn implements Parcelable.Creator<LocationResult> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public LocationResult createFromParcel(Parcel parcel) {
            return new LocationResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LocationResult[] newArray(int i) {
            return new LocationResult[i];
        }
    }

    protected LocationResult(Parcel parcel) {
        this.locations = parcel.createTypedArrayList(HWLocation.CREATOR);
    }

    LocationResult(List<HWLocation> list) {
        this.locations = list;
    }

    public static LocationResult create(List<HWLocation> list) {
        return new LocationResult(list);
    }

    public static LocationResult extractResult(Intent intent) {
        LocationResult locationResult = null;
        if (intent == null) {
            return null;
        }
        try {
            if (!intent.hasExtra(EXTRA_KEY)) {
                return null;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra(EXTRA_KEY);
            if (!(parcelableExtra instanceof LocationResult)) {
                if (!(parcelableExtra instanceof Bundle)) {
                    return null;
                }
                Bundle bundle = (Bundle) parcelableExtra;
                if (bundle.getParcelable(EXTRA_KEY) == null) {
                    return null;
                }
                parcelableExtra = bundle.getParcelable(EXTRA_KEY);
            }
            locationResult = (LocationResult) parcelableExtra;
            return locationResult;
        } catch (Exception unused) {
            return locationResult;
        }
    }

    public static boolean hasResult(Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra(EXTRA_KEY)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.locations, ((LocationResult) obj).locations);
    }

    public final List<HWLocation> getHWLocationList() {
        return this.locations;
    }

    public final HWLocation getLastHWLocation() {
        int size = this.locations.size();
        if (size == 0) {
            return null;
        }
        return this.locations.get(size - 1);
    }

    public final Location getLastLocation() {
        int size = this.locations.size();
        if (size == 0) {
            return null;
        }
        return LocationJsonUtil.convertLocation(this.locations.get(size - 1));
    }

    public final List<Location> getLocations() throws JSONException {
        ArrayList arrayList = new ArrayList();
        Iterator<HWLocation> it = this.locations.iterator();
        while (it.hasNext()) {
            Location locationConvertLocation = LocationJsonUtil.convertLocation(it.next());
            if (locationConvertLocation != null) {
                arrayList.add(locationConvertLocation);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        return Objects.hash(this.locations);
    }

    public String toString() {
        return "LocationResult{locations=" + this.locations + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.locations);
    }
}
