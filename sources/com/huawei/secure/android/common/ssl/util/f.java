package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes3.dex */
public class f {
    private static final String a = "f";

    public static String a(String str) {
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            return "";
        }
        try {
            return contextUtil.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.b(a, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            e.b(a, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            e.b(a, "throwable");
            return "";
        }
    }
}
