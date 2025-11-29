package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yandex.metrica.impl.ob.C1147oc;
import com.yandex.metrica.impl.ob.C1230s;
import com.yandex.metrica.impl.ob.C1297ui;
import com.yandex.metrica.impl.ob.zn;
import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.i0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0986i0 {
    private final Context a;
    private final E b;
    private final C1326w c;
    private final C1315vc d;
    private final I2 e;
    private final D9 f;
    private ContentValues g;
    private Lg h;

    public C0986i0(Context context) {
        this(context, F0.g().c(), F0.g().b(), C1315vc.a(context), H2.a(context));
    }

    public C0986i0 a(ContentValues contentValues) {
        this.g = contentValues;
        return this;
    }

    public C0986i0 a(Lg lg) {
        this.h = lg;
        return this;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        this.g.put("report_request_parameters", jSONObject.toString());
    }

    C0986i0(Context context, E e, C1326w c1326w, C1315vc c1315vc, H2 h2) {
        this.f = new D9();
        this.a = context;
        this.b = e;
        this.c = c1326w;
        this.d = c1315vc;
        this.e = h2.a();
    }

    private void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectPutOpt = jSONObject.putOpt("dId", this.h.g()).putOpt("uId", this.h.w()).putOpt("appVer", this.h.f()).putOpt("appBuild", this.h.b());
        this.h.getClass();
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("analyticsSdkVersionName", "5.3.0");
        this.h.getClass();
        JSONObject jSONObjectPutOpt3 = jSONObjectPutOpt2.putOpt("kitBuildNumber", "45003240").putOpt("kitBuildType", this.h.j()).putOpt("osVer", this.h.o()).putOpt("osApiLev", Integer.valueOf(this.h.n())).putOpt("lang", this.h.k()).putOpt("root", this.h.h()).putOpt("app_debuggable", this.h.z()).putOpt("app_framework", this.h.c()).putOpt("attribution_id", Integer.valueOf(this.h.C()));
        this.h.getClass();
        jSONObjectPutOpt3.putOpt("commit_hash", "a72bf6f57701ed3c2b8ed570054febbff4e58c12");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Bm bm, C1230s.a aVar, vn<C1297ui.b, Object> vnVar) {
        Location locationH;
        K2 k2B;
        C0836c0 c0836c0 = bm.a;
        this.g.put(AppMeasurementSdk.ConditionalUserProperty.NAME, c0836c0.a);
        this.g.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, c0836c0.b);
        this.g.put("type", Integer.valueOf(c0836c0.e));
        this.g.put("custom_type", Integer.valueOf(c0836c0.f));
        this.g.put("error_environment", c0836c0.h());
        this.g.put("user_info", c0836c0.p());
        this.g.put("truncated", Integer.valueOf(c0836c0.h));
        this.g.put("connection_type", Integer.valueOf(H1.b(this.a)));
        this.g.put("profile_id", c0836c0.m());
        this.g.put("encrypting_mode", Integer.valueOf(bm.b.a()));
        this.g.put("first_occurrence_status", Integer.valueOf(c0836c0.j().a));
        EnumC1375y0 enumC1375y0N = c0836c0.n();
        if (enumC1375y0N != null) {
            this.g.put("source", Integer.valueOf(enumC1375y0N.a));
        }
        Boolean boolC = c0836c0.c();
        if (boolC != null) {
            this.g.put("attribution_id_changed", boolC);
        }
        this.g.put("open_id", c0836c0.k());
        this.g.put("extras", this.f.fromModel(c0836c0.i()));
        this.g.put("app_environment", aVar.a);
        this.g.put("app_environment_revision", Long.valueOf(aVar.b));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enabled", this.h.Q());
            if (this.h.Q()) {
                locationH = this.h.H();
                if (locationH == null) {
                    locationH = this.d.a();
                    k2B = null;
                } else {
                    k2B = K2.a(locationH);
                }
            } else {
                locationH = null;
                k2B = null;
            }
            if (k2B == null && locationH != null) {
                k2B = K2.b(locationH);
            }
            if (k2B != null) {
                a(jSONObject, k2B);
            }
            this.g.put("location_info", jSONObject.toString());
        } catch (Throwable unused) {
        }
        EnumMap enumMap = new EnumMap(C1297ui.b.class);
        Xj xjV = F0.g().v();
        LinkedList linkedList = new LinkedList();
        xjV.a(new C0961h0(this, linkedList));
        C1297ui.b bVar = C1297ui.b.WIFI;
        enumMap.put((EnumMap) bVar, (C1297ui.b) this.e.a());
        C1297ui.b bVar2 = C1297ui.b.CELL;
        enumMap.put((EnumMap) bVar2, (C1297ui.b) (linkedList.isEmpty() ? null : (Collection) linkedList.getFirst()));
        zn<Map<C1297ui.b, Object>> znVar = vnVar.get(enumMap);
        this.g.put("has_omitted_data", Integer.valueOf(znVar.a == zn.a.NOT_CHANGED ? 1 : 0));
        zn.a aVar2 = znVar.a;
        D d = znVar.b;
        Collection collection = d == 0 ? null : (Collection) ((Map) d).get(bVar2);
        xjV.a(new C0936g0(this));
        zn.a aVar3 = zn.a.NEW;
        if ((aVar2 == aVar3 || aVar2 == zn.a.REFRESH) && collection != null) {
            this.g.put("cell_info", Tl.a((Collection<C1298uj>) collection).toString());
        }
        zn.a aVar4 = znVar.a;
        D d2 = znVar.b;
        Collection collection2 = d2 != 0 ? (Collection) ((Map) d2).get(bVar) : null;
        if ((aVar4 == zn.a.REFRESH || aVar4 == aVar3) && collection2 != null) {
            this.g.put("wifi_network_info", F2.a(collection2).toString());
        }
        this.g.put("battery_charge_type", Integer.valueOf(this.b.b().a()));
        this.g.put("collection_mode", C1147oc.a.a(this.c.c()).a());
    }

    private void a(JSONObject jSONObject, K2 k2) throws JSONException {
        jSONObject.put("lat", k2.getLatitude());
        jSONObject.put("lon", k2.getLongitude());
        jSONObject.putOpt("timestamp", Long.valueOf(k2.getTime()));
        jSONObject.putOpt("precision", k2.hasAccuracy() ? Float.valueOf(k2.getAccuracy()) : null);
        jSONObject.putOpt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, k2.hasBearing() ? Float.valueOf(k2.getBearing()) : null);
        jSONObject.putOpt("speed", k2.hasSpeed() ? Float.valueOf(k2.getSpeed()) : null);
        jSONObject.putOpt("altitude", k2.hasAltitude() ? Double.valueOf(k2.getAltitude()) : null);
        jSONObject.putOpt("provider", C0810b.a(k2.getProvider(), (String) null));
        jSONObject.putOpt("original_provider", k2.a());
    }
}
