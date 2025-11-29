package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Fi {
    private final B9 a;

    public Fi(B9 b9) {
        this.a = b9;
    }

    public final void a(Ui ui, JSONObject jSONObject) {
        If.g gVar = new If.g();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_collecting");
        if (jSONObjectOptJSONObject != null) {
            gVar.a = jSONObjectOptJSONObject.optLong("first_delay_seconds", gVar.a);
        }
        ui.a(this.a.toModel(gVar));
    }

    public Fi() {
        this(new B9());
    }
}
