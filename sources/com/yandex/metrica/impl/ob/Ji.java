package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Tl;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Ji {
    private final J9 a;

    Ji() {
        this(new J9());
    }

    void a(Ui ui, Tl.a aVar) {
        if (ui.e().f) {
            If.j jVar = new If.j();
            JSONObject jSONObjectOptJSONObject = aVar.optJSONObject("identity_light_collecting");
            if (jSONObjectOptJSONObject != null) {
                jVar.a = jSONObjectOptJSONObject.optLong("min_interval_seconds", jVar.a);
            }
            ui.a(this.a.toModel(jVar));
        }
    }

    Ji(J9 j9) {
        this.a = j9;
    }
}
