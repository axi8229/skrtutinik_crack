package com.yandex.metrica.impl.ob;

import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.fk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0931fk implements Gk {
    @Override // com.yandex.metrica.impl.ob.Gk
    public JSONObject a(Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cxts", obj);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
