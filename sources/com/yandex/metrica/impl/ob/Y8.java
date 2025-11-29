package com.yandex.metrica.impl.ob;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Y8 {
    private final C0819b8 a;

    public Y8(C0819b8 c0819b8) {
        this.a = c0819b8;
    }

    public final int a(int i) {
        JSONObject jSONObjectD = this.a.d();
        if (jSONObjectD != null) {
            return jSONObjectD.optInt(String.valueOf(i));
        }
        return 0;
    }

    public final void a(int i, int i2) throws JSONException {
        JSONObject jSONObjectD = this.a.d();
        if (jSONObjectD == null) {
            jSONObjectD = new JSONObject();
        }
        jSONObjectD.put(String.valueOf(i), i2);
        this.a.a(jSONObjectD);
    }
}
