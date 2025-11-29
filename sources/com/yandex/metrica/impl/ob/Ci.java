package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class Ci {
    private final C1264t9 a;

    public Ci() {
        this(new C1264t9());
    }

    void a(Ui ui, JSONObject jSONObject) {
        C1264t9 c1264t9 = this.a;
        If.b bVar = new If.b();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auto_inapp_collecting");
        if (jSONObjectOptJSONObject != null) {
            bVar.a = jSONObjectOptJSONObject.optInt("send_frequency_seconds", bVar.a);
            bVar.b = jSONObjectOptJSONObject.optInt("first_collecting_inapp_max_age_seconds", bVar.b);
        }
        ui.a(c1264t9.toModel(bVar));
    }

    Ci(C1264t9 c1264t9) {
        this.a = c1264t9;
    }
}
