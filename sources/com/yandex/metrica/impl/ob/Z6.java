package com.yandex.metrica.impl.ob;

import android.util.Base64;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.J;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Z6 {
    private final byte[] a;
    private final String b;
    private final int c;
    private final HashMap<J.a, Integer> d;
    private final String e;
    private final Integer f;
    private final String g;
    private final String h;
    private final CounterConfiguration.b i;
    private final String j;

    public Z6(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("event");
        this.a = Base64.decode(jSONObject2.getString("jvm_crash"), 0);
        this.b = jSONObject2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.c = jSONObject2.getInt("bytes_truncated");
        this.j = Tl.b(jSONObject2, "environment");
        String strOptString = jSONObject2.optString("trimmed_fields");
        this.d = new HashMap<>();
        if (strOptString != null) {
            try {
                HashMap<String, String> mapD = Tl.d(strOptString);
                if (mapD != null) {
                    for (Map.Entry<String, String> entry : mapD.entrySet()) {
                        this.d.put(J.a.valueOf(entry.getKey()), Integer.valueOf(Integer.parseInt(entry.getValue())));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("process_configuration");
        this.e = jSONObject3.getString("package_name");
        this.f = Integer.valueOf(jSONObject3.getInt("pid"));
        this.g = jSONObject3.getString("psid");
        JSONObject jSONObject4 = jSONObject.getJSONObject("reporter_configuration");
        this.h = jSONObject4.getString("api_key");
        this.i = a(jSONObject4);
    }

    public String a() {
        return this.h;
    }

    public int b() {
        return this.c;
    }

    public byte[] c() {
        return this.a;
    }

    public String d() {
        return this.j;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.e;
    }

    public Integer g() {
        return this.f;
    }

    public String h() {
        return this.g;
    }

    public CounterConfiguration.b i() {
        return this.i;
    }

    public HashMap<J.a, Integer> j() {
        return this.d;
    }

    public String k() throws JSONException {
        HashMap map = new HashMap();
        for (Map.Entry<J.a, Integer> entry : this.d.entrySet()) {
            map.put(entry.getKey().name(), entry.getValue());
        }
        return new JSONObject().put("process_configuration", new JSONObject().put("pid", this.f).put("psid", this.g).put("package_name", this.e)).put("reporter_configuration", new JSONObject().put("api_key", this.h).put("reporter_type", this.i.a())).put("event", new JSONObject().put("jvm_crash", Base64.encodeToString(this.a, 0)).put(AppMeasurementSdk.ConditionalUserProperty.NAME, this.b).put("bytes_truncated", this.c).put("trimmed_fields", Tl.g(map)).putOpt("environment", this.j)).toString();
    }

    @Deprecated
    private CounterConfiguration.b a(JSONObject jSONObject) throws JSONException {
        return jSONObject.has("reporter_type") ? CounterConfiguration.b.a(jSONObject.getString("reporter_type")) : jSONObject.getBoolean("is_commutation") ? CounterConfiguration.b.COMMUTATION : CounterConfiguration.b.MAIN;
    }

    public Z6(C0836c0 c0836c0, C1402z3 c1402z3, HashMap<J.a, Integer> map) {
        this.a = c0836c0.r();
        this.b = c0836c0.g();
        this.c = c0836c0.d();
        if (map != null) {
            this.d = map;
        } else {
            this.d = new HashMap<>();
        }
        A3 a3A = c1402z3.a();
        this.e = a3A.f();
        this.f = a3A.g();
        this.g = a3A.h();
        CounterConfiguration counterConfigurationB = c1402z3.b();
        this.h = counterConfigurationB.a();
        this.i = counterConfigurationB.k();
        this.j = c0836c0.h();
    }
}
