package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Gi {
    private final C9 a;

    public Gi(C9 c9) {
        this.a = c9;
    }

    public final void a(Ui ui, JSONObject jSONObject) {
        If.h hVar = new If.h();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("egress");
        if (jSONObjectOptJSONObject != null) {
            hVar.a = jSONObjectOptJSONObject.optString("url", hVar.a);
            hVar.b = jSONObjectOptJSONObject.optInt("repeated_delay", hVar.b);
            hVar.c = jSONObjectOptJSONObject.optInt("random_delay_window", hVar.c);
            hVar.d = jSONObjectOptJSONObject.optBoolean("background_allowed", hVar.d);
            hVar.e = jSONObjectOptJSONObject.optBoolean("diagnostic_enabled", hVar.e);
        }
        ui.a(this.a.toModel(hVar));
    }

    public Gi() {
        this(new C9());
    }
}
