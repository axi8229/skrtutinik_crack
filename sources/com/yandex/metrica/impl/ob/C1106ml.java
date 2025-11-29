package com.yandex.metrica.impl.ob;

import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.ml, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1106ml implements Jk {
    @Override // com.yandex.metrica.impl.ob.Jk
    public void a(JSONObject jSONObject, Object obj, String str) {
        try {
            jSONObject.getJSONArray("ssh").getJSONObject(0).put(str, obj);
        } catch (Throwable unused) {
        }
    }
}
