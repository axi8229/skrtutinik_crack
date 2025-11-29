package com.huawei.wisesecurity.ucs.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class SpUtil {
    private static SharedPreferences mSharedPreferences;

    public static synchronized SharedPreferences getInstance(Context context) {
        try {
            if (mSharedPreferences == null) {
                mSharedPreferences = context.createDeviceProtectedStorageContext().getSharedPreferences("ucs.sdk", 0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return mSharedPreferences;
    }

    public static int getInt(String str, int i, Context context) {
        return getInstance(context).getInt(str, i);
    }

    public static long getLong(String str, long j, Context context) {
        return getInstance(context).getLong(str, j);
    }

    public static String getString(String str, String str2, Context context) {
        return getInstance(context).getString(str, str2);
    }

    public static void putInt(String str, int i, Context context) {
        getInstance(context).edit().putInt(str, i).apply();
    }

    public static void putLong(String str, long j, Context context) {
        getInstance(context).edit().putLong(str, j).apply();
    }

    public static void putString(String str, String str2, Context context) {
        getInstance(context).edit().putString(str, str2).apply();
    }
}
