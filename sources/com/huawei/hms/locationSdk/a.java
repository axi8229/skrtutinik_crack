package com.huawei.hms.locationSdk;

import com.huawei.hms.support.api.entity.location.coordinate.LonLat;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.coordinateconverter.CoordinateTransform;
import com.huawei.location.lite.common.util.coordinateconverter.LatLon;

/* loaded from: classes3.dex */
public class a {
    public static LonLat a(double d, double d2, int i) {
        if (i != 1) {
            LogLocation.e("ConvertCoord", "coordType is not 84");
            return null;
        }
        if (!a(d, d2)) {
            HMSLocationLog.e("ConvertCoord", "", "transform latLon is not Valid Coordinates");
            return null;
        }
        LatLon latLonConvertCoord = CoordinateTransform.convertCoord(d, d2, i);
        if (latLonConvertCoord == null) {
            return null;
        }
        LonLat lonLat = new LonLat();
        lonLat.setLatitude(latLonConvertCoord.getLatitude());
        lonLat.setLongitude(latLonConvertCoord.getLongitude());
        return lonLat;
    }

    private static boolean a(double d, double d2) {
        return d >= -90.0d && d <= 90.0d && d2 >= -180.0d && d2 <= 180.0d;
    }
}
