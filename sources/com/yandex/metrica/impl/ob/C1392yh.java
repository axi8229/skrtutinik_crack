package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.yh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1392yh {
    private final C1362xb a;
    private final Context b;
    private String c;
    private String d;
    private boolean e;
    private C1178pi f;

    C1392yh(Context context, C1178pi c1178pi) {
        this(context, c1178pi, F0.g().r());
    }

    String a() throws ExecutionException, InterruptedException {
        C1266tb c1266tb;
        C1266tb c1266tb2;
        JSONObject jSONObject = new JSONObject();
        if (!this.e) {
            C1410zb c1410zbA = this.a.a(this.b);
            C1290ub c1290ubA = c1410zbA.a();
            String str = null;
            this.c = (!c1290ubA.a() || (c1266tb2 = c1290ubA.a) == null) ? null : c1266tb2.b;
            C1290ub c1290ubB = c1410zbA.b();
            if (c1290ubB.a() && (c1266tb = c1290ubB.a) != null) {
                str = c1266tb.b;
            }
            this.d = str;
            this.e = true;
        }
        try {
            a(jSONObject, "uuid", this.f.V());
            a(jSONObject, "device_id", this.f.i());
            a(jSONObject, "google_aid", this.c);
            a(jSONObject, "huawei_aid", this.d);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    C1392yh(Context context, C1178pi c1178pi, C1362xb c1362xb) {
        this.e = false;
        this.b = context;
        this.f = c1178pi;
        this.a = c1362xb;
    }

    public void a(C1178pi c1178pi) {
        this.f = c1178pi;
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }
}
