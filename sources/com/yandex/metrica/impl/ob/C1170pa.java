package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1306v3;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.pa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1170pa implements InterfaceC1241sa<C1306v3> {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1241sa
    public JSONObject a(C1306v3 c1306v3) {
        C1306v3 c1306v32 = c1306v3;
        JSONObject jSONObject = new JSONObject();
        if (c1306v32 != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<C1306v3.a> it = c1306v32.a().iterator();
                while (it.hasNext()) {
                    jSONArray.put(a(it.next()));
                }
                jSONObject.putOpt("chosen", a(c1306v32.c())).putOpt("candidates", jSONArray);
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }

    private JSONObject a(C1306v3.a aVar) throws JSONException {
        if (aVar == null) {
            return null;
        }
        return new JSONObject().putOpt("clids", Tl.e(aVar.b())).putOpt("source", aVar.a().a());
    }
}
