package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class He implements Ge {
    private final C1174pe a;

    public He() {
        this(new C1174pe());
    }

    @Override // com.yandex.metrica.impl.ob.Ge
    public byte[] a(C1198qe c1198qe, Lg lg) {
        if (!lg.T() && !TextUtils.isEmpty(c1198qe.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c1198qe.b);
                jSONObject.remove("preloadInfo");
                c1198qe.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.a.a(c1198qe, lg);
    }

    He(C1174pe c1174pe) {
        this.a = c1174pe;
    }
}
