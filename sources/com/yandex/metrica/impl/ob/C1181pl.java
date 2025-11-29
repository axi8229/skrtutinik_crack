package com.yandex.metrica.impl.ob;

import android.app.Activity;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.pl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1181pl {
    private final Kk a;
    private final Ik b;
    private final Jk c;
    private final Gk d;
    private final String e;

    public C1181pl(Kk kk, Ik ik, Jk jk, Gk gk, String str) {
        this.a = kk;
        this.b = ik;
        this.c = jk;
        this.d = gk;
        this.e = str;
    }

    public JSONObject a(Activity activity, C0882dl c0882dl, C0982hl c0982hl, Ak ak, long j) {
        JSONObject jSONObjectA = this.a.a(activity, j);
        try {
            this.c.a(jSONObjectA, new JSONObject(), this.e);
            this.c.a(jSONObjectA, this.b.a(c0882dl, c0982hl, ak, (jSONObjectA.toString().getBytes().length + (this.d.a(new JSONObject()).toString().getBytes().length - 2)) - 2), this.e);
        } catch (Throwable unused) {
        }
        return jSONObjectA;
    }
}
