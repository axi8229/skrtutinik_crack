package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.Ud;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.xa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1361xa implements InterfaceC1241sa<Ud> {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1241sa
    public JSONObject a(Ud ud) {
        Ud ud2 = ud;
        JSONObject jSONObject = new JSONObject();
        if (ud2 != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<Ud.a> it = ud2.b.iterator();
                while (it.hasNext()) {
                    Ud.a next = it.next();
                    jSONArray.put(next == null ? null : new JSONObject().putOpt("tracking_id", next.a).put("additional_parameters", next.b).put("source", next.c.a()));
                }
                JSONObject jSONObjectPut = jSONObject.put("candidates", jSONArray);
                C0900ee c0900ee = ud2.a;
                jSONObjectPut.put("chosen", new JSONObject().putOpt("tracking_id", c0900ee.a).put("additional_parameters", c0900ee.b).put("source", c0900ee.e.a()).put("auto_tracking_enabled", c0900ee.d));
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }
}
