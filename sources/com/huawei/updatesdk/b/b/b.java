package com.huawei.updatesdk.b.b;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class b {
    private SharedPreferences a;

    private b(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public static b a(String str, Context context) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.createDeviceProtectedStorageContext().getSharedPreferences(str, 0);
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.c.a.a.a.b("SharedPreferencesWrapper", "getSharedPreference error");
            sharedPreferences = null;
        }
        return new b(sharedPreferences);
    }

    public long a(String str, long j) {
        try {
            return this.a.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    public String a(String str, String str2) {
        try {
            return this.a.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public void a(String str) {
        try {
            if (this.a.contains(str)) {
                SharedPreferences.Editor editorEdit = this.a.edit();
                editorEdit.remove(str);
                editorEdit.commit();
            }
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.c.a.a.a.b("SharedPreferencesWrapper", "remove error!!key:" + str);
        }
    }

    public void b(String str, long j) {
        try {
            SharedPreferences.Editor editorEdit = this.a.edit();
            editorEdit.putLong(str, j);
            editorEdit.commit();
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("SharedPreferencesWrapper", "putLong error!!key:" + str, e);
        }
    }

    public void b(String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = this.a.edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("SharedPreferencesWrapper", "putString error!!key:" + str, e);
        }
    }
}
