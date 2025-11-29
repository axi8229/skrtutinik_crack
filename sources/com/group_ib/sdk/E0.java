package com.group_ib.sdk;

import android.content.SharedPreferences;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class E0 {
    public final SharedPreferences a;
    public final HashMap b;
    public final String c;
    public final SecureRandom d;

    public E0(MobileSdkService mobileSdkService) {
        this.a = null;
        HashMap map = new HashMap();
        this.b = map;
        this.c = X.b(5);
        this.d = new SecureRandom();
        try {
            SharedPreferences sharedPreferences = mobileSdkService.getApplicationContext().getSharedPreferences(T.e() + ".GIBSDK", 0);
            this.a = sharedPreferences;
            if (sharedPreferences != null) {
                String strG = T.g();
                String string = sharedPreferences.getString("cfids" + strG, null);
                String string2 = sharedPreferences.getString("gssc" + strG, null);
                if (string != null) {
                    map.put("cfids" + strG, string);
                }
                if (string2 != null) {
                    map.put("gssc" + strG, string2);
                }
            }
        } catch (Exception e) {
            c1.b("CookieManager", "failed to access shared preferences", e);
        }
        this.b.put("__gsac_" + T.g(), T.j());
    }

    public final synchronized void a(String str, String str2) {
        if (str != null && str2 != null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(str, str2);
                editorEdit.apply();
                this.b.put(str, str2);
            }
        }
    }

    public final synchronized HashMap a() {
        try {
            String str = (String) this.b.get("gssc" + T.a);
            if (str == null || str.isEmpty()) {
                c1.a(2, 2, "CookieManager", "failed to get gssc");
            }
            if (str != null) {
                String hexString = Long.toHexString(System.currentTimeMillis() + Math.abs(this.d.nextLong()));
                if (hexString.length() < 4) {
                    c1.a(1, 1, "CookieManager", "failed to get cookies: invalid prefix");
                    return null;
                }
                String strSubstring = hexString.substring(hexString.length() - 4);
                try {
                    byte[] bytes = (this.c + str + strSubstring).getBytes();
                    char[] cArr = AbstractC0604j0.a;
                    byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bytes);
                    this.b.put("fgssc" + T.a, strSubstring + AbstractC0604j0.a(bArrDigest).substring(4));
                } catch (Exception e) {
                    c1.a("CookieManager", "failed to get cookies", e);
                }
            }
            return this.b;
        } catch (Throwable th) {
            throw th;
        }
    }
}
