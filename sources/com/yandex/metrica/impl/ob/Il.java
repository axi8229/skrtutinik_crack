package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1228rl;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Il extends C1228rl {
    public volatile String h;
    public volatile String i;

    Il(String str, String str2, C1228rl.b bVar, int i, boolean z) {
        super(str, str2, null, i, z, C1228rl.c.VIEW, C1228rl.a.WEBVIEW);
        this.h = null;
        this.i = null;
    }

    @Override // com.yandex.metrica.impl.ob.C1228rl
    JSONArray a(C0982hl c0982hl) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", "HTML");
            if (c0982hl.j) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("u", A2.a(this.h, c0982hl.o));
                jSONObject2.putOpt("ou", A2.a(this.i, c0982hl.o));
                if (jSONObject2.length() > 0) {
                    jSONObject.put("i", jSONObject2);
                }
            }
            jSONArray.put(jSONObject);
        } catch (Throwable unused) {
        }
        return jSONArray;
    }

    @Override // com.yandex.metrica.impl.ob.C1228rl
    boolean a() {
        return true;
    }

    @Override // com.yandex.metrica.impl.ob.C1228rl
    public String toString() {
        return "WebViewElement{url='" + this.h + "', originalUrl='" + this.i + "', mClassName='" + this.a + "', mId='" + this.b + "', mParseFilterReason=" + this.c + ", mDepth=" + this.d + ", mListItem=" + this.e + ", mViewType=" + this.f + ", mClassType=" + this.g + "} ";
    }
}
