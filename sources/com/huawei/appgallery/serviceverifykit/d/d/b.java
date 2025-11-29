package com.huawei.appgallery.serviceverifykit.d.d;

import android.util.Log;

/* loaded from: classes3.dex */
public class b {
    public static final b b = new b();
    private boolean a;

    private b() throws ClassNotFoundException {
        try {
            Class.forName("com.huawei.appgallery.log.LogAdaptor");
            this.a = true;
        } catch (ClassNotFoundException unused) {
            this.a = false;
        }
    }

    public void a(String str, String str2) {
        if (this.a) {
            a.a.e(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public void a(String str, String str2, Throwable th) {
        if (this.a) {
            a.a.e(str, str2, th);
        } else {
            Log.e(str, str2, th);
        }
    }

    public void b(String str, String str2) {
        if (this.a) {
            a.a.i(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public void c(String str, String str2) {
        if (this.a) {
            a.a.w(str, str2);
        } else {
            Log.w(str, str2);
        }
    }
}
