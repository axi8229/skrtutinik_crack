package com.huawei.location.lite.common.util.coordinateconverter;

import com.huawei.location.lite.common.log.LogLocation;

/* loaded from: classes3.dex */
public class CoordinateTransform {
    public static LatLon convertCoord(double d, double d2, int i) {
        if (i == 1) {
            return gps84ToGcj02(d, d2);
        }
        LogLocation.e("CoordinateTransform", "coordType is not 84");
        return null;
    }

    private static LatLon gps84ToGcj02(double d, double d2) {
        return transform(d, d2, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.huawei.location.lite.common.util.coordinateconverter.LatLon transform(double r5, double r7, int r9) {
        /*
            com.huawei.location.lite.common.util.coordinateconverter.LatLon r0 = new com.huawei.location.lite.common.util.coordinateconverter.LatLon
            r0.<init>()
            r1 = 0
            double[] r2 = new double[r1]
            java.lang.String r3 = "CoordinateTransform"
            r4 = 1
            if (r9 != r4) goto L13
            double[] r5 = com.huawei.location.lite.common.util.coordinateconverter.Transform.wgs84to02Native(r5, r7)     // Catch: java.lang.Error -> L18 java.lang.Exception -> L1e
        L11:
            r2 = r5
            goto L21
        L13:
            double[] r5 = com.huawei.location.lite.common.util.coordinateconverter.Transform.gcj02to84Native(r5, r7)     // Catch: java.lang.Error -> L18 java.lang.Exception -> L1e
            goto L11
        L18:
            java.lang.String r5 = "transform Native method error"
        L1a:
            com.huawei.location.lite.common.log.LogLocation.e(r3, r5)
            goto L21
        L1e:
            java.lang.String r5 = "transform Native method exception"
            goto L1a
        L21:
            int r5 = r2.length
            r6 = 2
            if (r5 >= r6) goto L2c
            java.lang.String r5 = "transform doubles length exception"
            com.huawei.location.lite.common.log.LogLocation.e(r3, r5)
            r5 = 0
            return r5
        L2c:
            r5 = r2[r1]
            r0.setLatitude(r5)
            r5 = r2[r4]
            r0.setLongitude(r5)
            java.lang.String r5 = "transform ok"
            com.huawei.location.lite.common.log.LogLocation.i(r3, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.coordinateconverter.CoordinateTransform.transform(double, double, int):com.huawei.location.lite.common.util.coordinateconverter.LatLon");
    }
}
