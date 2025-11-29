package com.huawei.updatesdk.a.b.b;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes3.dex */
public final class b {
    private Intent a;

    private b(Intent intent) {
        this.a = intent;
    }

    public static b a(Intent intent) {
        return new b(intent);
    }

    public int a(String str, int i) {
        if (d()) {
            try {
                return this.a.getIntExtra(str, i);
            } catch (Exception unused) {
                com.huawei.updatesdk.a.a.a.a("SecureIntent", "getIntExtra exception!");
            }
        }
        return i;
    }

    public String a() {
        String action;
        return (!d() || (action = this.a.getAction()) == null) ? "" : action;
    }

    public String a(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.a.getStringExtra(str);
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.a.a("SecureIntent", "getStringExtra exception!");
            return "";
        }
    }

    public boolean a(String str, boolean z) {
        if (d()) {
            try {
                return this.a.getBooleanExtra(str, z);
            } catch (Exception unused) {
                com.huawei.updatesdk.a.a.a.a("SecureIntent", "getBooleanExtra exception!");
            }
        }
        return z;
    }

    public long b(String str, int i) {
        if (d()) {
            try {
                return this.a.getLongExtra(str, i);
            } catch (Exception unused) {
                com.huawei.updatesdk.a.a.a.a("SecureIntent", "getIntExtra exception!");
            }
        }
        return i;
    }

    public Bundle b() {
        if (d()) {
            return this.a.getExtras();
        }
        return null;
    }

    public Intent c() {
        return this.a;
    }

    public boolean d() {
        return this.a != null;
    }
}
