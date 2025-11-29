package com.huawei.location.lite.common.log;

/* loaded from: classes3.dex */
public class LogLocation {
    private static yn iLogLocation = new E5();

    public static void e(String str, Vw vw, boolean z) {
        ((E5) iLogLocation).yn(str, vw, z);
    }

    public static void e(String str, String str2) {
        ((E5) iLogLocation).yn(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        ((E5) iLogLocation).yn(str, str2, th);
    }

    public static void e(String str, String str2, boolean z) {
        ((E5) iLogLocation).yn(str, str2, z);
    }

    public static void i(String str, String str2) {
        ((E5) iLogLocation).Vw(str, str2);
    }

    public static void i(String str, String str2, boolean z) {
        ((E5) iLogLocation).Vw(str, str2, z);
    }

    public static void w(String str, String str2) {
        ((E5) iLogLocation).FB(str, str2);
    }

    public static void d(String str, String str2) {
        ((E5) iLogLocation).getClass();
    }
}
