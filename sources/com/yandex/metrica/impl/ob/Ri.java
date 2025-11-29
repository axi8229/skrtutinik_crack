package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Tl;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Ri {
    private final U9 a;

    Ri() {
        this(new U9());
    }

    void a(Ui ui, Tl.a aVar) {
        If.p pVar = new If.p();
        JSONObject jSONObjectOptJSONObject = aVar.optJSONObject("sdk_list");
        if (jSONObjectOptJSONObject != null) {
            Long lA = Tl.a(jSONObjectOptJSONObject, "min_collecting_interval_seconds", (Long) null);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            pVar.a = Tl.a(lA, timeUnit, pVar.a);
            pVar.b = Tl.a(Tl.a(jSONObjectOptJSONObject, "min_first_collecting_delay_seconds", (Long) null), timeUnit, pVar.b);
            pVar.c = Tl.a(Tl.a(jSONObjectOptJSONObject, "min_collecting_delay_after_launch_seconds", (Long) null), timeUnit, pVar.c);
            pVar.d = Tl.a(Tl.a(jSONObjectOptJSONObject, "min_request_retry_interval_seconds", (Long) null), timeUnit, pVar.d);
        }
        ui.a(this.a.toModel(pVar));
    }

    Ri(U9 u9) {
        this.a = u9;
    }
}
