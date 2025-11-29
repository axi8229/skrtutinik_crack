package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ManufacturerUtils {
    public static boolean isMeizuDevice() {
        return getManufacturer().equals("meizu");
    }

    private static String getManufacturer() {
        String str = Build.MANUFACTURER;
        if (str != null) {
            return str.toLowerCase(Locale.ENGLISH);
        }
        return "";
    }
}
