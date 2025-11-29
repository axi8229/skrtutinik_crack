package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1175pf;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class Yc {
    public C1175pf.a a(C1072lc c1072lc) {
        C1175pf.a aVar = new C1175pf.a();
        aVar.a = c1072lc.f() == null ? aVar.a : c1072lc.f().longValue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVar.b = timeUnit.toSeconds(c1072lc.d());
        aVar.e = timeUnit.toSeconds(c1072lc.c());
        aVar.f = c1072lc.b() == null ? 0 : J1.a(c1072lc.b());
        aVar.g = c1072lc.e() == null ? 3 : J1.a(c1072lc.e());
        JSONArray jSONArrayA = c1072lc.a();
        if (jSONArrayA != null) {
            aVar.c = J1.b(jSONArrayA);
        }
        JSONArray jSONArrayG = c1072lc.g();
        if (jSONArrayG != null) {
            aVar.d = J1.a(jSONArrayG);
        }
        return aVar;
    }
}
