package com.huawei.updatesdk.service.otaupdate;

import android.text.TextUtils;
import com.huawei.hms.jos.JosConstant;

/* loaded from: classes3.dex */
public class f {
    private static f d = new f();
    private String a;
    private String b;
    private String c = JosConstant.APP_MARKET_PACKAGE;

    private f() {
    }

    public static f e() {
        return d;
    }

    public String a() {
        return !TextUtils.isEmpty(this.a) ? this.a : this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public boolean d() {
        String str = this.a;
        if (str != null) {
            return str.equals(this.b);
        }
        return true;
    }
}
