package com.yandex.metrica.impl.ob;

import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class F2 {
    public final String a;
    public final String b;
    public final boolean c;
    public final int d;
    public final Long e;

    public F2(String str, String str2, boolean z, int i, Long l) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = i;
        this.e = l;
    }

    public static JSONArray a(Collection<F2> collection) {
        JSONObject jSONObjectPut;
        JSONArray jSONArray = new JSONArray();
        if (collection != null) {
            for (F2 f2 : collection) {
                f2.getClass();
                try {
                    jSONObjectPut = new JSONObject().put("mac", f2.a).put("ssid", f2.b).put("signal_strength", f2.d).put("is_connected", f2.c).put("last_visible_offset_seconds", f2.e);
                } catch (Throwable unused) {
                    jSONObjectPut = null;
                }
                if (jSONObjectPut != null) {
                    jSONArray.put(jSONObjectPut);
                }
            }
        }
        return jSONArray;
    }
}
