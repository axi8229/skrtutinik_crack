package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Vi {
    private final Y9 a;

    public Vi(Y9 y9) {
        this.a = y9;
    }

    public final void a(Ui ui, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("startup_update");
        If.r rVar = new If.r();
        Integer it = Tl.a(jSONObjectOptJSONObject, "interval_seconds", (Integer) null);
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            rVar.a = it.intValue();
        }
        ui.a(this.a.toModel(rVar));
    }

    public Vi() {
        this(new Y9());
    }
}
