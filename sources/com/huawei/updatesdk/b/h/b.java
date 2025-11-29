package com.huawei.updatesdk.b.h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.lang.Thread;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class b {
    private static Integer a = null;
    private static boolean b = false;
    private static boolean c = false;
    private static Field d;

    static class a implements Thread.UncaughtExceptionHandler {
        a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageUtils", thread.getName() + " : " + th.getMessage());
        }
    }

    /* renamed from: com.huawei.updatesdk.b.h.b$b, reason: collision with other inner class name */
    public enum EnumC0105b {
        NOT_INSTALLED,
        INSTALLED,
        INSTALLED_LOWCODE
    }

    private static class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageManagerRunnable", "PackageManagerRunnable run!!!!");
            com.huawei.updatesdk.a.a.d.d.a(new File(com.huawei.updatesdk.b.d.d.b()));
        }
    }

    public static int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if ((applicationInfo.flags & 1) == 0) {
            return 0;
        }
        return a(applicationInfo) ? 1 : 2;
    }

    public static int a(String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageInfo packageInfo = com.huawei.updatesdk.a.b.a.a.c().a().getPackageManager().getPackageInfo(str, 128);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("com.huawei.maple.flag")) ? 0 : 1;
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.c.a.a.a.d("PackageUtils", "getMapleStatus not found: " + str);
            return 0;
        }
    }

    public static PackageInfo a(String str, Context context) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.c.a.a.a.d("PackageUtils", "not found: " + str);
            return null;
        }
    }

    public static EnumC0105b a(Context context, String str) throws PackageManager.NameNotFoundException {
        EnumC0105b enumC0105b = EnumC0105b.NOT_INSTALLED;
        if (context == null) {
            return enumC0105b;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return enumC0105b;
            }
            com.huawei.updatesdk.a.a.a.b("PackageUtils", "appmarket info,versioncode = " + packageInfo.versionCode + "versioncode = " + packageInfo.versionName);
            return packageInfo.versionCode < 70203000 ? EnumC0105b.INSTALLED_LOWCODE : EnumC0105b.INSTALLED;
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.c.a.a.a.d("PackageUtils", "isInstallByPackage Exception:" + e.toString());
            return enumC0105b;
        }
    }

    public static void a() {
        Thread thread = new Thread(new c(null));
        thread.setName("delete market file task");
        thread.setUncaughtExceptionHandler(new a());
        thread.start();
    }

    public static boolean a(Context context, String str, boolean z) {
        return z || b(context, str) > 90000000;
    }

    private static boolean a(ApplicationInfo applicationInfo) throws ClassNotFoundException {
        StringBuilder sb;
        int i = applicationInfo.flags;
        Integer numC = c();
        if (numC != null && (i & numC.intValue()) != 0) {
            return true;
        }
        Field fieldB = b();
        if (fieldB == null) {
            return false;
        }
        try {
            return (fieldB.getInt(applicationInfo) & 33554432) != 0;
        } catch (IllegalAccessException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("can not get hwflags");
            sb.append(e.toString());
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageUtils", sb.toString());
            return false;
        } catch (IllegalArgumentException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("can not get hwflags");
            sb.append(e.toString());
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageUtils", sb.toString());
            return false;
        }
    }

    private static int b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.c.a.a.a.d("PackageUtils", "isInstallByPackage:" + e.toString());
            return 0;
        }
    }

    public static Field b() {
        if (c) {
            return d;
        }
        try {
            d = ApplicationInfo.class.getField("hwFlags");
        } catch (NoSuchFieldException unused) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageUtils", "can not find hwFlags");
        }
        c = true;
        return d;
    }

    public static boolean b(Context context, String str, boolean z) {
        return z || b(context, str) > 100200000;
    }

    public static Integer c() throws ClassNotFoundException {
        String string;
        StringBuilder sb;
        String str;
        if (b) {
            return a;
        }
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            a = Integer.valueOf(cls.getDeclaredField("PARSE_IS_REMOVABLE_PREINSTALLED_APK").getInt(cls));
        } catch (ClassNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            str = "isDelApp error ClassNotFoundException:";
            sb.append(str);
            sb.append(e.toString());
            string = sb.toString();
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageUtils", string);
            b = true;
            return a;
        } catch (IllegalAccessException e2) {
            e = e2;
            sb = new StringBuilder();
            str = "isDelApp error IllegalAccessException:";
            sb.append(str);
            sb.append(e.toString());
            string = sb.toString();
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageUtils", string);
            b = true;
            return a;
        } catch (IllegalArgumentException e3) {
            e = e3;
            sb = new StringBuilder();
            str = "isDelApp error IllegalArgumentException:";
            sb.append(str);
            sb.append(e.toString());
            string = sb.toString();
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageUtils", string);
            b = true;
            return a;
        } catch (NoSuchFieldException e4) {
            e = e4;
            sb = new StringBuilder();
            str = "isDelApp error NoSuchFieldException:";
            sb.append(str);
            sb.append(e.toString());
            string = sb.toString();
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageUtils", string);
            b = true;
            return a;
        } catch (Exception e5) {
            string = e5.toString();
            com.huawei.updatesdk.a.a.c.a.a.a.a("PackageUtils", string);
            b = true;
            return a;
        }
        b = true;
        return a;
    }

    public static String c(Context context, String str) {
        String installerPackageName;
        try {
            installerPackageName = context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.a.b("PackageUtils", "can not find installer pkg." + str);
            installerPackageName = null;
        }
        com.huawei.updatesdk.a.a.c.a.a.a.c("PackageUtils", "installer pkg: " + installerPackageName);
        return installerPackageName;
    }

    public static boolean d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (Exception e) {
                com.huawei.updatesdk.a.a.c.a.a.a.d("PackageUtils", "isAppInstalled NameNotFoundException:" + e.toString());
            }
        }
        return false;
    }
}
