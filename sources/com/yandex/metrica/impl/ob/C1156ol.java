package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1228rl;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.ol, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1156ol implements Ik {
    private final List<C1228rl> a;

    public C1156ol(List<C1228rl> list) {
        this.a = list;
    }

    @Override // com.yandex.metrica.impl.ob.Ik
    public Object a(C0882dl c0882dl, C0982hl c0982hl, Ak ak, int i) {
        JSONArray jSONArray = new JSONArray();
        if (this.a.isEmpty()) {
            return jSONArray;
        }
        for (C1228rl c1228rl : this.a) {
            C1228rl.b bVarA = c1228rl.a(ak);
            int i2 = 0;
            if ((c0982hl.f || c1228rl.a()) && (bVarA == null || !c0982hl.i)) {
                JSONObject jSONObjectA = c1228rl.a(c0982hl, bVarA);
                int length = jSONObjectA.toString().getBytes().length + 1;
                int length2 = jSONArray.length();
                if (i + length <= c0982hl.n && length2 < c0982hl.m) {
                    jSONArray.put(jSONObjectA);
                    i2 = length;
                }
            }
            i += i2;
        }
        return jSONArray;
    }
}
