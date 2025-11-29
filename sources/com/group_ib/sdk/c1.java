package com.group_ib.sdk;

import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.util.Log;
import bz.J1;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class c1 {
    public static int a = 2;
    public static HandlerThread b;
    public static i1 c;
    public static final String d = UUID.randomUUID().toString();
    public static String e = null;
    public static SharedPreferences f = null;
    public static boolean g = false;
    public static boolean h = false;

    public static synchronized void a() {
        try {
            b = null;
            i1 i1Var = c;
            if (i1Var != null) {
                i1Var.sendEmptyMessage(2);
            }
            h = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void b(String str, String str2, Exception exc) {
        String str3;
        if (J1.a(a) >= 1) {
            synchronized (c1.class) {
                try {
                    C0621t c0621t = new C0621t(str == null ? " " : str, str2, exc);
                    i1 i1Var = c;
                    if (i1Var != null) {
                        i1Var.sendMessage(i1Var.obtainMessage(0, c0621t));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (T.a(g)) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                str3 = "[" + str + "] ";
            } else {
                str3 = " ";
            }
            sb.append(str3);
            sb.append(str2);
            Log.e("GIBSDK", sb.toString(), exc);
        }
    }

    public static synchronized void c() {
        c.sendEmptyMessage(8);
    }

    public static synchronized void d() {
        c.sendEmptyMessage(7);
    }

    public static synchronized void a(int i) {
        try {
            if (a != i) {
                a = i;
                SharedPreferences sharedPreferences = f;
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("level", Z0.a(a));
                    editorEdit.apply();
                }
                i1 i1Var = c;
                if (i1Var != null) {
                    i1Var.sendEmptyMessage(5);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void a(int i, int i2, String str, String str2) {
        String str3;
        if (J1.a(a) >= i2) {
            synchronized (c1.class) {
                try {
                    C0621t c0621t = new C0621t(i, str == null ? " " : str, str2);
                    i1 i1Var = c;
                    if (i1Var != null) {
                        i1Var.sendMessage(i1Var.obtainMessage(0, c0621t));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (T.a(g)) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                str3 = "[" + str + "]: ";
            } else {
                str3 = " ";
            }
            sb.append(str3);
            sb.append(str2);
            Log.v("GIBSDK", sb.toString());
        }
    }

    public static boolean b(int i) {
        return J1.a(a) >= J1.a(i) || T.a(g);
    }

    public static synchronized void b() {
        i1 i1Var = c;
        if (i1Var != null) {
            i1Var.sendEmptyMessage(3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[Catch: all -> 0x003e, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000f, B:11:0x002d, B:14:0x0037, B:19:0x0043, B:18:0x0040, B:20:0x0046, B:22:0x004a, B:23:0x0056, B:24:0x0065, B:27:0x0076, B:26:0x0072), top: B:38:0x0003, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void a(android.content.Context r4) {
        /*
            java.lang.Class<com.group_ib.sdk.c1> r0 = com.group_ib.sdk.c1.class
            monitor-enter(r0)
            boolean r1 = com.group_ib.sdk.c1.h     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto L87
            java.lang.String r1 = com.group_ib.sdk.T.e()     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto Lf
            goto L87
        Lf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r1.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = com.group_ib.sdk.T.e()     // Catch: java.lang.Throwable -> L3e
            r1.append(r2)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = ".GIBSDK"
            r1.append(r2)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3e
            r2 = 0
            android.content.SharedPreferences r1 = r4.getSharedPreferences(r1, r2)     // Catch: java.lang.Throwable -> L3e
            com.group_ib.sdk.c1.f = r1     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L46
            java.lang.String r2 = "level"
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)     // Catch: java.lang.Throwable -> L3e
            r2 = 2
            if (r1 == 0) goto L43
            int r1 = com.group_ib.sdk.Z0.a(r1)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            com.group_ib.sdk.c1.a = r1     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            goto L46
        L3e:
            r4 = move-exception
            goto L89
        L40:
            com.group_ib.sdk.c1.a = r2     // Catch: java.lang.Throwable -> L3e
            goto L46
        L43:
            a(r2)     // Catch: java.lang.Throwable -> L3e
        L46:
            android.os.HandlerThread r1 = com.group_ib.sdk.c1.b     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto L56
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = "GIBSDK Log Thread"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3e
            com.group_ib.sdk.c1.b = r1     // Catch: java.lang.Throwable -> L3e
            r1.start()     // Catch: java.lang.Throwable -> L3e
        L56:
            com.group_ib.sdk.i1 r1 = new com.group_ib.sdk.i1     // Catch: java.lang.Throwable -> L3e
            android.os.HandlerThread r2 = com.group_ib.sdk.c1.b     // Catch: java.lang.Throwable -> L3e
            android.os.Looper r2 = r2.getLooper()     // Catch: java.lang.Throwable -> L3e
            int r3 = com.group_ib.sdk.c1.a     // Catch: java.lang.Throwable -> L3e
            r1.<init>(r2, r4, r3)     // Catch: java.lang.Throwable -> L3e
            com.group_ib.sdk.c1.c = r1     // Catch: java.lang.Throwable -> L3e
            android.content.ContentResolver r1 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L72
            java.lang.String r2 = "android_id"
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r2)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L72
            com.group_ib.sdk.c1.e = r1     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L72
            goto L76
        L72:
            java.lang.String r1 = "unknown"
            com.group_ib.sdk.c1.e = r1     // Catch: java.lang.Throwable -> L3e
        L76:
            com.group_ib.sdk.i1 r1 = com.group_ib.sdk.c1.c     // Catch: java.lang.Throwable -> L3e
            r2 = 4
            r1.sendEmptyMessage(r2)     // Catch: java.lang.Throwable -> L3e
            boolean r4 = com.group_ib.sdk.AbstractC0604j0.a(r4)     // Catch: java.lang.Throwable -> L3e
            com.group_ib.sdk.c1.g = r4     // Catch: java.lang.Throwable -> L3e
            r4 = 1
            com.group_ib.sdk.c1.h = r4     // Catch: java.lang.Throwable -> L3e
            monitor-exit(r0)
            return
        L87:
            monitor-exit(r0)
            return
        L89:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.c1.a(android.content.Context):void");
    }

    public static void b(String str, String str2) {
        a(4, 4, str, str2);
    }

    public static void a(String str, String str2) {
        String str3;
        if (T.a(g)) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                str3 = "[" + str + "] ";
            } else {
                str3 = " ";
            }
            sb.append(str3);
            sb.append(str2);
            Log.d("GIBSDK", sb.toString());
        }
    }

    public static void a(String str, String str2, Exception exc) {
        String str3;
        if (T.a(g)) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                str3 = "[" + str + "] ";
            } else {
                str3 = " ";
            }
            sb.append(str3);
            sb.append(str2);
            Log.e("GIBSDK", sb.toString(), exc);
        }
    }

    public static void a(String str) {
        a(3, 3, "PackageProvider", str);
    }
}
