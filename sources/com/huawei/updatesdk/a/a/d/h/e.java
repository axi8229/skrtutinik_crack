package com.huawei.updatesdk.a.a.d.h;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class e {
    private static String a = "";

    public static boolean a() {
        if ("KidWatch".equals(a)) {
            return true;
        }
        String strA = c.a("ro.vendor.market.type", "");
        a = strA;
        com.huawei.updatesdk.a.a.a.b("WearDeviceUtil", "Children watch property value is " + strA);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return "KidWatch".equals(strA);
    }
}
