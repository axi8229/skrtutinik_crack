package com.group_ib.sdk;

import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleApiAvailability;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class T {
    public static volatile String a = null;
    public static volatile URL b = null;
    public static final /* synthetic */ boolean x = true;
    public static final HashMap c = new HashMap();
    public static volatile String d = null;
    public static volatile InterfaceC0609m e = null;
    public static volatile C0602i0 f = null;
    public static volatile String g = null;
    public static volatile String h = null;
    public static volatile long i = -1;
    public static volatile long j = 0;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean o = false;
    public static boolean p = false;
    public static volatile boolean q = false;
    public static volatile int y = 1;
    public static volatile URL r = null;
    public static final HashSet s = new HashSet();
    public static Set t = null;
    public static final Object u = new Object();
    public static volatile C0588b0 v = null;
    public static Method w = null;

    public static synchronized boolean a() {
        Class<GoogleApiAvailability> cls;
        if (!k) {
            try {
                Class.forName("com.google.android.gms.safetynet.SafetyNet");
                cls = GoogleApiAvailability.class;
                int i2 = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            l = cls != null;
            k = true;
        }
        return l;
    }

    public static void b() {
        synchronized (u) {
            t = null;
        }
    }

    public static int c() {
        return y;
    }

    public static synchronized C0602i0 d() {
        return f;
    }

    public static synchronized String e() {
        return g;
    }

    public static synchronized String f() {
        return f != null ? f.b : null;
    }

    public static String g() {
        return a;
    }

    public static URL h() {
        URL url = r;
        if (url != null) {
            return url;
        }
        URL url2 = b;
        String string = url2 != null ? url2.toString() : null;
        if (string == null) {
            return url;
        }
        try {
            URL url3 = new URL(string.concat("/id.html"));
            try {
                r = url3;
                return url3;
            } catch (Exception unused) {
                url = url3;
                c1.a(1, 1, "SharedSettings", "failed to get Global ID URL");
                return url;
            }
        } catch (Exception unused2) {
        }
    }

    public static String i() {
        String str;
        URL url = b;
        if (url == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol());
        sb.append("://");
        sb.append(url.getHost());
        if (url.getPort() != -1) {
            str = ":" + url.getPort();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("/");
        return sb.toString();
    }

    public static String j() {
        return h;
    }

    public static String k() {
        String str;
        URL url = b;
        if (url == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("//");
        sb.append(url.getHost());
        if (url.getPort() != -1) {
            str = ":" + url.getPort();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(url.getPath());
        return sb.toString();
    }

    public static synchronized int a(String str) {
        Integer num;
        try {
            if (!x && c == null) {
                throw new AssertionError();
            }
            num = (Integer) c.get(str);
        } catch (Throwable th) {
            throw th;
        }
        return num != null ? num.intValue() : 1;
    }

    public static synchronized boolean b(MobileSdkService mobileSdkService) {
        GoogleApiAvailability googleApiAvailability;
        try {
            if (!m) {
                if (a() && (googleApiAvailability = GoogleApiAvailability.getInstance()) != null) {
                    n = googleApiAvailability.isGooglePlayServicesAvailable(mobileSdkService) == 0;
                }
                m = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return n;
    }

    public static synchronized void c(MobileSdkService mobileSdkService) {
        try {
            if (mobileSdkService.getApplicationContext() != null) {
                String packageName = mobileSdkService.getApplicationContext().getPackageName();
                C0602i0 c0602i0 = null;
                try {
                    PackageManager packageManager = mobileSdkService.getPackageManager();
                    if (packageManager != null) {
                        int i2 = HandlerC0626v0.$r8$clinit;
                        PackageManager packageManager2 = mobileSdkService.getPackageManager();
                        c0602i0 = new C0602i0(packageManager2 != null ? packageManager2.getPackageInfo(packageName, 4290) : null, packageManager);
                    }
                } catch (Exception unused) {
                    c1.a(1, 1, "Package", "Failed to get package info for " + packageName);
                }
                f = c0602i0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static Set a(MobileSdkService mobileSdkService) {
        Set setA;
        synchronized (u) {
            try {
                setA = t;
                if (setA == null) {
                    setA = HandlerC0626v0.a(mobileSdkService);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return setA;
    }

    public static synchronized boolean b(EnumC0589c enumC0589c) {
        return s.contains(enumC0589c);
    }

    public static synchronized void a(int i2, String str) {
        c.put(str, Integer.valueOf(i2));
    }

    public static boolean a(boolean z) {
        return z && q;
    }

    public static synchronized void a(EnumC0589c enumC0589c) {
        s.add(enumC0589c);
    }
}
