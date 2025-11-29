package com.huawei.location.lite.common.util.coordinateconverter;

import com.huawei.location.lite.common.log.LogLocation;

/* loaded from: classes3.dex */
public class CoordinateUtil {
    public static LatLon convertCoord(double d, double d2, int i) {
        if (i == 1) {
            return gps84ToGcj02(d, d2);
        }
        LogLocation.e("CoordinateUtil", "coordType is not 84");
        return null;
    }

    private static LatLon gps84ToGcj02(double d, double d2) {
        return transform(d, d2, 1);
    }

    private static boolean isValidCoordinates(double d, double d2) {
        return d >= -90.0d && d <= 90.0d && d2 >= -180.0d && d2 <= 180.0d;
    }

    private static LatLon transform(double d, double d2, int i) {
        if (i != 1 || isValidCoordinates(d, d2)) {
            return CoordinateTransform.convertCoord(d, d2, 1);
        }
        LogLocation.e("CoordinateUtil", "transform latLon is not Valid Coordinates");
        return null;
    }
}
