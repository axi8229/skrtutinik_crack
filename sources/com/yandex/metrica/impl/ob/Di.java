package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Di {
    private final C1336w9 a;

    public Di() {
        this(new C1336w9());
    }

    public Ph a(JSONObject jSONObject) {
        If.c cVar = new If.c();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("cache_control");
        if (jSONObjectOptJSONObject != null) {
            Long lA = Tl.a(jSONObjectOptJSONObject, "cells_around_ttl", (Long) null);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            cVar.a = Tl.a(lA, timeUnit, cVar.a);
            cVar.b = Tl.a(Tl.a(jSONObjectOptJSONObject, "wifi_networks_ttl", (Long) null), timeUnit, cVar.b);
            cVar.c = Tl.a(Tl.a(jSONObjectOptJSONObject, "last_known_location_ttl", (Long) null), timeUnit, cVar.c);
            cVar.d = Tl.a(Tl.a(jSONObjectOptJSONObject, "net_interfaces_ttl", (Long) null), timeUnit, cVar.d);
        }
        return this.a.toModel(cVar);
    }

    Di(C1336w9 c1336w9) {
        this.a = c1336w9;
    }
}
