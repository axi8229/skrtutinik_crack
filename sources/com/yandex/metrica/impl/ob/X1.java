package com.yandex.metrica.impl.ob;

import java.io.File;

/* loaded from: classes3.dex */
public final class X1 {
    private static final B0 a = new B0();
    private static final String[] b = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};

    public static int a() {
        return (b() || c()) ? 1 : 0;
    }

    public static boolean b() {
        try {
            return (A2.a(21) ? new File("/system/app/Superuser/Superuser.apk") : new File("/system/app/Superuser.apk")).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c() {
        for (String str : b) {
            try {
            } catch (Throwable unused) {
            }
            if (A2.a(31) ? false : new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }
}
