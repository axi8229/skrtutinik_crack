package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1297ui;
import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Tl;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Wi {
    private static final If.u a = new If.u();

    public C1297ui a(Tl.a aVar, String str) {
        C1297ui.a aVar2;
        JSONObject jSONObjectOptJSONObject = aVar.optJSONObject(str);
        C1297ui.a aVar3 = null;
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cell");
        if (jSONObjectOptJSONObject2 != null) {
            If.u uVar = a;
            aVar2 = new C1297ui.a(jSONObjectOptJSONObject2.optInt("refresh_event_count", uVar.a), jSONObjectOptJSONObject2.optLong("refresh_period_seconds", uVar.b));
        } else {
            aVar2 = null;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("wifi");
        if (jSONObjectOptJSONObject3 != null) {
            If.u uVar2 = a;
            aVar3 = new C1297ui.a(jSONObjectOptJSONObject3.optInt("refresh_event_count", uVar2.a), jSONObjectOptJSONObject3.optLong("refresh_period_seconds", uVar2.b));
        }
        return new C1297ui(aVar2, aVar3);
    }
}
