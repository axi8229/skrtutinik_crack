package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yandex.metrica.impl.ob.C1147oc;
import com.yandex.metrica.impl.ob.E;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Vb {
    private Context a;

    public Vb(Context context) {
        this.a = context;
    }

    public String a(Hc hc) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("collection_mode", hc.a.a());
            jSONObject.put("lat", hc.c().getLatitude());
            jSONObject.put("lon", hc.c().getLongitude());
            jSONObject.putOpt("timestamp", Long.valueOf(hc.c().getTime()));
            jSONObject.putOpt("receive_timestamp", Long.valueOf(hc.e()));
            jSONObject.put("receive_elapsed_realtime_seconds", hc.d());
            jSONObject.putOpt("precision", hc.c().hasAccuracy() ? Float.valueOf(hc.c().getAccuracy()) : null);
            jSONObject.putOpt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, hc.c().hasBearing() ? Float.valueOf(hc.c().getBearing()) : null);
            jSONObject.putOpt("speed", hc.c().hasSpeed() ? Float.valueOf(hc.c().getSpeed()) : null);
            jSONObject.putOpt("altitude", hc.c().hasAltitude() ? Double.valueOf(hc.c().getAltitude()) : null);
            jSONObject.putOpt("provider", C0810b.a(hc.c().getProvider(), (String) null));
            jSONObject.put("charge_type", hc.a().a());
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = null;
        }
        if (string == null) {
            return null;
        }
        try {
            return Tl.b(this.a, string);
        } catch (UnsupportedEncodingException unused2) {
            return null;
        }
    }

    public Hc b(long j, String str) {
        String strA;
        try {
            strA = Tl.a(this.a, str);
        } catch (UnsupportedEncodingException unused) {
            strA = null;
        }
        if (strA != null && !TextUtils.isEmpty(strA)) {
            try {
                JSONObject jSONObject = new JSONObject(strA);
                long jOptLong = jSONObject.optLong("receive_timestamp", 0L);
                long jOptLong2 = jSONObject.optLong("receive_elapsed_realtime_seconds", 0L);
                C1147oc.a aVarA = C1147oc.a.a(jSONObject.optString("collection_mode"));
                Location location = new Location(jSONObject.optString("provider", null));
                location.setLongitude(jSONObject.optDouble("lon", ConfigValue.DOUBLE_DEFAULT_VALUE));
                location.setLatitude(jSONObject.optDouble("lat", ConfigValue.DOUBLE_DEFAULT_VALUE));
                location.setTime(jSONObject.optLong("timestamp", 0L));
                location.setAccuracy((float) jSONObject.optDouble("precision", ConfigValue.DOUBLE_DEFAULT_VALUE));
                location.setBearing((float) jSONObject.optDouble(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, ConfigValue.DOUBLE_DEFAULT_VALUE));
                location.setSpeed((float) jSONObject.optDouble("speed", ConfigValue.DOUBLE_DEFAULT_VALUE));
                location.setAltitude(jSONObject.optDouble("altitude", ConfigValue.DOUBLE_DEFAULT_VALUE));
                return new Hc(aVarA, jOptLong, jOptLong2, location, E.b.a.a(Integer.valueOf(jSONObject.optInt("charge_type", Integer.MIN_VALUE))), Long.valueOf(j));
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public C1072lc a(long j, String str) {
        String strA;
        try {
            strA = Tl.a(this.a, str);
        } catch (UnsupportedEncodingException unused) {
            strA = null;
        }
        if (strA == null || TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            C1072lc c1072lc = new C1072lc();
            try {
                c1072lc.a(Long.valueOf(j));
                JSONObject jSONObject = new JSONObject(strA);
                c1072lc.b(jSONObject.optLong("timestamp", 0L));
                c1072lc.a(jSONObject.optLong("elapsed_realtime_seconds", 0L));
                c1072lc.a(jSONObject.optJSONArray("cell_info"));
                c1072lc.b(jSONObject.optJSONArray("wifi_info"));
                c1072lc.a(E.b.a.a(Integer.valueOf(jSONObject.optInt("charge_type", Integer.MIN_VALUE))));
                c1072lc.a(C1147oc.a.a(jSONObject.optString("collection_mode")));
            } catch (Throwable unused2) {
            }
            return c1072lc;
        } catch (Throwable unused3) {
            return null;
        }
    }

    public String a(C1072lc c1072lc) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", c1072lc.d());
            jSONObject.put("elapsed_realtime_seconds", c1072lc.c());
            jSONObject.putOpt("wifi_info", c1072lc.g());
            jSONObject.putOpt("cell_info", c1072lc.a());
            if (c1072lc.b() != null) {
                jSONObject.put("charge_type", c1072lc.b().a());
            }
            if (c1072lc.e() != null) {
                jSONObject.put("collection_mode", c1072lc.e().a());
            }
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = null;
        }
        if (string == null) {
            return null;
        }
        try {
            return Tl.b(this.a, string);
        } catch (UnsupportedEncodingException unused2) {
            return null;
        }
    }
}
