package com.huawei.wisesecurity.kfs.util;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class PropertyUtil {
    private static final String TAG = "PropertyUtil";

    public static String getSystemProperties(String str, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getDeclaredMethod("get", String.class, String.class).invoke(cls, str, str2);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            Log.e(TAG, "An exception occurred while reading string system properties: " + str);
        }
        return str2;
    }
}
