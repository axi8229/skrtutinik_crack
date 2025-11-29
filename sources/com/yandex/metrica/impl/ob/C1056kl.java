package com.yandex.metrica.impl.ob;

import android.app.Activity;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.kl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1056kl implements Kk {
    @Override // com.yandex.metrica.impl.ob.Kk
    public JSONObject a(Activity activity, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", activity.getClass().getName()).put("cid", j);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
