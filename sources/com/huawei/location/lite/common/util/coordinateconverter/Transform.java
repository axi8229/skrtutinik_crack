package com.huawei.location.lite.common.util.coordinateconverter;

import com.huawei.location.lite.common.log.LogLocation;

/* loaded from: classes3.dex */
public class Transform {
    static {
        String str;
        try {
            System.loadLibrary("Transform");
            LogLocation.i("Transform", "load Transform Library.");
        } catch (SecurityException unused) {
            str = "load Transform Library failed because of SecurityException.";
            LogLocation.e("Transform", str);
        } catch (Exception unused2) {
            str = "load Transform Library failed.";
            LogLocation.e("Transform", str);
        } catch (UnsatisfiedLinkError unused3) {
            str = "load Transform Library failed because of UnsatisfiedLinkError.";
            LogLocation.e("Transform", str);
        }
    }

    public static native double[] gcj02to84Native(double d, double d2);

    public static native double[] wgs84to02Native(double d, double d2);
}
