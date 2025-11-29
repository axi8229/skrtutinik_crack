package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class g {
    private static SharedPreferences b;

    public static long a(String str, long j, Context context) {
        return b(context).getLong(str, j);
    }

    public static synchronized SharedPreferences b(Context context) {
        try {
            if (b == null) {
                b = context.createDeviceProtectedStorageContext().getSharedPreferences("aegis", 0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public static String a(String str, String str2, Context context) {
        return b(context).getString(str, str2);
    }

    public static void b(String str, long j, Context context) {
        b(context).edit().putLong(str, j).apply();
    }

    public static void b(String str, String str2, Context context) {
        b(context).edit().putString(str, str2).apply();
    }
}
