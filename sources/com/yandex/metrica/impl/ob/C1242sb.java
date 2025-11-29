package com.yandex.metrica.impl.ob;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.sb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1242sb {
    private final String a;
    private final int b;
    private final boolean c;

    public C1242sb(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt("version", -1);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(AppMeasurementSdk.ConditionalUserProperty.NAME, this.a).put("required", this.c);
        int i = this.b;
        if (i != -1) {
            jSONObjectPut.put("version", i);
        }
        return jSONObjectPut;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1242sb.class != obj.getClass()) {
            return false;
        }
        C1242sb c1242sb = (C1242sb) obj;
        if (this.b != c1242sb.b || this.c != c1242sb.c) {
            return false;
        }
        String str = this.a;
        String str2 = c1242sb.a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public C1242sb(String str, int i, boolean z) {
        this.a = str;
        this.b = i;
        this.c = z;
    }
}
