package com.huawei.updatesdk.b.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class a {
    private static final Object d = new Object();
    private static a e;
    private b a;
    private String b;
    private boolean c = false;

    private a(Context context) {
        this.a = b.a("DeviceSessionUpdateSDK_V1", context);
    }

    public static a d() {
        a aVar;
        synchronized (d) {
            try {
                if (e == null) {
                    e = new a(com.huawei.updatesdk.a.b.a.a.c().a());
                }
                aVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public String a() {
        return this.b;
    }

    public String a(String str) {
        return this.a.a("updatesdk.lastAccountZone" + str, "");
    }

    public void a(long j) {
        this.a.b("updatesdk.lastCheckDate", j);
    }

    public void a(String str, long j) {
        this.a.b("updatesdk.lastInitAccountTime" + str, j);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.b(str, str2);
    }

    public long b() {
        return this.a.a("updatesdk.lastCheckDate", 0L);
    }

    public long b(String str) {
        return this.a.a("updatesdk.lastInitAccountTime" + str, 0L);
    }

    public void b(String str, String str2) {
        this.a.b("updatesdk.lastAccountZone" + str, str2);
    }

    public String c(String str) {
        return TextUtils.isEmpty(str) ? "" : this.a.a(str, "");
    }

    public void c() {
        if (this.c) {
            return;
        }
        d("updatesdk.sign.param");
        d("updatesdk.signkey");
        d("updatesdk.signtime");
        this.c = true;
    }

    public void d(String str) {
        this.a.a(str);
    }

    public void e(String str) {
        this.b = str;
    }
}
