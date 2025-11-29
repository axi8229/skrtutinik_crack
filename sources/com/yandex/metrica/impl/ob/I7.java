package com.yandex.metrica.impl.ob;

import android.util.Base64;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class I7 {
    private String a;
    private String b;

    I7() {
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.a;
            if (str == null) {
                str = "";
            }
            return Base64.encodeToString(jSONObject.put("arg_ee", str).put("arg_hv", this.b).toString().getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }
}
