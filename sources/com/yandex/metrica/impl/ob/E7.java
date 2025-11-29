package com.yandex.metrica.impl.ob;

import android.util.Base64;
import com.yandex.metrica.CounterConfiguration;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class E7 {
    private static String[] a = {"arg_ak", "arg_pn", "arg_pd", "arg_ps", "arg_rt"};

    E7() {
    }

    C0990i4 a(String str) {
        try {
            return a(new JSONObject(new String(Base64.decode(str, 0))).getJSONObject("arg_cd"));
        } catch (Exception unused) {
            return null;
        }
    }

    private C0990i4 a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        try {
            for (String str : a) {
                if (!jSONObject.has(str)) {
                    return null;
                }
            }
            int i = jSONObject.getInt("arg_pd");
            if (i == 0) {
                i = Integer.parseInt(jSONObject.getString("arg_pd"));
            }
            return new C0990i4(jSONObject.getString("arg_ak"), jSONObject.getString("arg_pn"), Integer.valueOf(i), jSONObject.getString("arg_ps"), CounterConfiguration.b.a(jSONObject.getString("arg_rt")));
        } catch (Exception unused) {
            return null;
        }
    }
}
