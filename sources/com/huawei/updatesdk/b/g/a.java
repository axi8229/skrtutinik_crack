package com.huawei.updatesdk.b.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class a {
    private static String a;

    public static String a() throws PackageManager.NameNotFoundException {
        String str = a;
        if (str != null) {
            return str;
        }
        Context contextA = com.huawei.updatesdk.a.b.a.a.c().a();
        try {
            String packageName = contextA.getPackageName();
            PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0);
            if (packageInfo != null) {
                packageName = packageName + packageInfo.versionName;
            }
            String str2 = Build.BRAND;
            if (TextUtils.isEmpty(str2)) {
                str2 = "other";
            }
            String str3 = packageName + "_" + str2;
            a = str3;
            return str3;
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.c.a.a.a.b("ApplicationSession", "getUserAgent() " + e.toString());
            return null;
        }
    }
}
