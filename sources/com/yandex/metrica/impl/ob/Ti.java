package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Oh;
import com.yandex.metrica.impl.ob.Tl;
import com.yandex.metrica.impl.ob.Ui;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Ti {
    private final Ii a;
    private final Hi b;
    private final Oi c;
    private final Ri d;
    private final Qi e;
    private final Ni f;
    private final Si g;
    private final Ji h;
    private final Wi i;
    private final Li j;
    private final Pi k;
    private final Z9 l;
    private final Yi m;
    private final Xi n;
    private final Ci o;
    private final Di p;
    private final Ei q;
    private final Bi r;
    private final Ki s;
    private final Fi t;
    private final Gi u;
    private final Vi v;
    private final Mi w;

    public Ti() {
        this(new Ki(), new Ii(), new Hi(), new Oi(), new Ri(), new Qi(), new Ni(), new Si(), new Ji(), new Wi(), new Li(), new Pi(), new Z9(), new Yi(), new Xi(), new Di(), new Ei(), new Ci(), new Bi(), new Fi(), new Gi(), new Vi(), new Mi());
    }

    public Ui a(byte[] bArr) {
        String strOptString;
        String strOptString2;
        Ui ui = new Ui();
        try {
            this.s.getClass();
            Tl.a aVar = new Tl.a(new String(bArr, "UTF-8"));
            JSONObject jSONObjectOptJSONObject = aVar.optJSONObject("device_id");
            if (jSONObjectOptJSONObject != null) {
                strOptString = jSONObjectOptJSONObject.optString("hash");
                strOptString2 = jSONObjectOptJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            } else {
                strOptString = "";
                strOptString2 = "";
            }
            ui.d(strOptString2);
            ui.c(strOptString);
            a(ui, aVar);
            ui.a(Ui.a.OK);
            return ui;
        } catch (Throwable unused) {
            Ui ui2 = new Ui();
            ui2.a(Ui.a.BAD);
            return ui2;
        }
    }

    public Ti(Ki ki, Ii ii, Hi hi, Oi oi, Ri ri, Qi qi, Ni ni, Si si, Ji ji, Wi wi, Li li, Pi pi, Z9 z9, Yi yi, Xi xi, Di di, Ei ei, Ci ci, Bi bi, Fi fi, Gi gi, Vi vi, Mi mi) {
        this.a = ii;
        this.b = hi;
        this.c = oi;
        this.d = ri;
        this.e = qi;
        this.f = ni;
        this.g = si;
        this.h = ji;
        this.i = wi;
        this.j = li;
        this.k = pi;
        this.l = z9;
        this.m = yi;
        this.n = xi;
        this.p = di;
        this.q = ei;
        this.o = ci;
        this.r = bi;
        this.s = ki;
        this.t = fi;
        this.u = gi;
        this.v = vi;
        this.w = mi;
    }

    private void a(Ui ui, Tl.a aVar) throws JSONException {
        long jOptLong;
        long jOptLong2;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3 = aVar.optJSONObject("queries");
        if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject3.optJSONObject("list")) != null) {
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("sdk_list");
            if (jSONObjectOptJSONObject4 != null) {
                ui.h(jSONObjectOptJSONObject4.optString("url", null));
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject2.optJSONObject("host");
            if (jSONObjectOptJSONObject5 != null) {
                ui.a(jSONObjectOptJSONObject5.optString("url", null));
            }
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = aVar.get("distribution_customization");
        } catch (Throwable unused) {
        }
        JSONObject jSONObjectOptJSONObject6 = ((JSONObject) jSONObject).optJSONObject("clids");
        if (jSONObjectOptJSONObject6 != null) {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObjectOptJSONObject6.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject6.optJSONObject(next);
                if (jSONObjectOptJSONObject7 != null && jSONObjectOptJSONObject7.has(AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
                    map.put(next, jSONObjectOptJSONObject7.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                }
            }
            ui.e(Tl.c(map));
        }
        JSONObject jSONObjectOptJSONObject8 = aVar.optJSONObject("locale");
        ui.b((jSONObjectOptJSONObject8 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject8.optJSONObject("country")) == null || !jSONObjectOptJSONObject.optBoolean("reliable", false)) ? "" : jSONObjectOptJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, ""));
        JSONObject jSONObjectOptJSONObject9 = aVar.optJSONObject(CrashHianalyticsData.TIME);
        if (jSONObjectOptJSONObject9 != null) {
            try {
                ui.a(Long.valueOf(jSONObjectOptJSONObject9.getLong("max_valid_difference_seconds")));
            } catch (Throwable unused2) {
            }
        }
        If.s sVar = new If.s();
        JSONObject jSONObjectOptJSONObject10 = aVar.optJSONObject("stat_sending");
        if (jSONObjectOptJSONObject10 != null) {
            sVar.a = Tl.a(Tl.a(jSONObjectOptJSONObject10, "disabled_reporting_interval_seconds", (Long) null), TimeUnit.SECONDS, sVar.a);
        }
        ui.a(this.l.toModel(sVar));
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject11 = aVar.optJSONObject("mediascope_api_keys");
        if (jSONObjectOptJSONObject11 != null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject11.optJSONArray("list")) != null) {
            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                try {
                    arrayList.add(jSONArrayOptJSONArray2.getString(i));
                } catch (Throwable unused3) {
                }
            }
        }
        ui.d(arrayList);
        this.b.a(ui, aVar);
        this.a.a(ui, aVar);
        this.c.getClass();
        JSONObject jSONObjectOptJSONObject12 = aVar.optJSONObject("permissions");
        if (jSONObjectOptJSONObject12 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject12.optJSONArray("list")) != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject13 = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject13 != null) {
                    String strOptString = jSONObjectOptJSONObject13.optString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                    boolean zOptBoolean = jSONObjectOptJSONObject13.optBoolean("enabled");
                    if (TextUtils.isEmpty(strOptString)) {
                        ui.a("", false);
                    } else {
                        ui.a(strOptString, zOptBoolean);
                    }
                }
            }
        }
        this.d.a(ui, aVar);
        this.e.getClass();
        If r0 = new If();
        JSONObject jSONObjectOptJSONObject14 = aVar.optJSONObject("retry_policy");
        int iOptInt = r0.H;
        int iOptInt2 = r0.I;
        if (jSONObjectOptJSONObject14 != null) {
            iOptInt = jSONObjectOptJSONObject14.optInt("max_interval_seconds", iOptInt);
            iOptInt2 = jSONObjectOptJSONObject14.optInt("exponential_multiplier", r0.I);
        }
        ui.a(new RetryPolicyConfig(iOptInt, iOptInt2));
        this.f.getClass();
        if (ui.e().c) {
            JSONObject jSONObjectOptJSONObject15 = aVar.optJSONObject("permissions_collecting");
            If.n nVar = new If.n();
            if (jSONObjectOptJSONObject15 != null) {
                jOptLong = jSONObjectOptJSONObject15.optLong("check_interval_seconds", nVar.a);
                jOptLong2 = jSONObjectOptJSONObject15.optLong("force_send_interval_seconds", nVar.b);
            } else {
                jOptLong = nVar.a;
                jOptLong2 = nVar.b;
            }
            ui.a(new C0804ai(jOptLong, jOptLong2));
        }
        this.g.a(ui, aVar);
        this.h.a(ui, aVar);
        this.j.a(ui, aVar);
        this.k.a(ui, aVar);
        this.m.a(ui, aVar);
        ui.b(this.n.a(aVar, "ui_event_sending", C1085m0.b()));
        ui.c(this.n.a(aVar, "ui_raw_event_sending", C1085m0.b()));
        ui.a(this.n.a(aVar, "ui_collecting_for_bridge", C1085m0.a()));
        this.o.a(ui, aVar);
        ui.a(this.i.a(aVar, "throttling"));
        ui.a(this.p.a(aVar));
        this.q.a(ui, aVar);
        this.r.getClass();
        JSONObject jSONObjectOptJSONObject16 = aVar.optJSONObject("attribution");
        if (jSONObjectOptJSONObject16 != null) {
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject16.optJSONArray("deeplink_conditions");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject17 = jSONArrayOptJSONArray3.optJSONObject(i3);
                    String strOptString2 = jSONObjectOptJSONObject17.optString("key", null);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        String strOptString3 = jSONObjectOptJSONObject17.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, null);
                        arrayList2.add(new Pair(strOptString2, strOptString3 == null ? null : new Oh.a(strOptString3)));
                    }
                }
            }
            ui.a(new Oh(arrayList2));
        }
        this.t.a(ui, aVar);
        if (ui.e().w) {
            this.u.a(ui, aVar);
        }
        this.v.a(ui, aVar);
        this.w.a(ui, aVar);
    }
}
