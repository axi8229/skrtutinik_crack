package com.huawei.updatesdk.b.c;

import android.os.Build;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class c {
    private String a;
    private String b;

    public abstract String a();

    public abstract int b();

    abstract String c();

    abstract String d();

    public String e() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        String strC = c();
        this.b = strC;
        if (TextUtils.isEmpty(strC)) {
            this.b = Build.MANUFACTURER;
        }
        return this.b;
    }

    public String f() {
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        String strD = d();
        this.a = strD;
        if (TextUtils.isEmpty(strD)) {
            this.a = Build.MODEL;
        }
        return this.a;
    }

    public abstract List<String> g();
}
