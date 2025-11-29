package com.group_ib.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0623u extends A {
    public double j = Double.MAX_VALUE;

    @Override // com.group_ib.sdk.A
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        if (jSONObjectA != null) {
            double d = Double.MAX_VALUE;
            for (double d2 : this.h) {
                if (d2 < d) {
                    d = d2;
                }
            }
            jSONObjectA.put("min_start", B.a(this.j)).put("min_stop", B.a(d));
        }
        return jSONObjectA;
    }

    @Override // com.group_ib.sdk.A
    public final void a(double d) {
        double dAcos = Math.acos(d / 9.81d);
        super.a(dAcos);
        if (this.g > 5 || dAcos >= this.j) {
            return;
        }
        this.j = dAcos;
    }
}
