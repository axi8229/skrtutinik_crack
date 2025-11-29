package com.yandex.metrica.impl.ob;

import android.location.Location;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yandex.metrica.PreloadInfo;
import com.yandex.metrica.YandexMetricaConfig;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.na, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1120na implements InterfaceC1241sa<YandexMetricaConfig> {
    private final InterfaceC0833bm a;
    private final C1385ya b;

    C1120na(InterfaceC0833bm interfaceC0833bm, C1385ya c1385ya) {
        this.a = interfaceC0833bm;
        this.b = c1385ya;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1241sa
    public JSONObject a(YandexMetricaConfig yandexMetricaConfig) {
        YandexMetricaConfig yandexMetricaConfig2 = yandexMetricaConfig;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (yandexMetricaConfig2 != null) {
                JSONObject jSONObjectPutOpt = jSONObject2.put("api_key", yandexMetricaConfig2.apiKey).putOpt("app_version", yandexMetricaConfig2.appVersion).putOpt("session_timeout", yandexMetricaConfig2.sessionTimeout).putOpt("crash_reporting", yandexMetricaConfig2.crashReporting).putOpt("native_crash_reporting", yandexMetricaConfig2.nativeCrashReporting).putOpt("location", a(yandexMetricaConfig2.location)).putOpt("location_tracking", yandexMetricaConfig2.locationTracking).putOpt("logs", yandexMetricaConfig2.logs);
                PreloadInfo preloadInfo = yandexMetricaConfig2.preloadInfo;
                jSONObjectPutOpt.putOpt("preload_info", preloadInfo == null ? null : new JSONObject().putOpt("tracking_id", preloadInfo.getTrackingId()).putOpt("additional_parameters", Tl.f(preloadInfo.getAdditionalParams()))).putOpt("first_activation_as_update", yandexMetricaConfig2.firstActivationAsUpdate).putOpt("statistics_sending", yandexMetricaConfig2.statisticsSending).putOpt("max_reports_in_database_count", yandexMetricaConfig2.maxReportsInDatabaseCount).putOpt("error_environment", Tl.f(yandexMetricaConfig2.errorEnvironment)).putOpt("user_profile_id", yandexMetricaConfig2.userProfileID).putOpt("revenue_auto_tracking_enabled", yandexMetricaConfig2.revenueAutoTrackingEnabled).putOpt("sessions_auto_tracking_enabled", yandexMetricaConfig2.sessionsAutoTrackingEnabled).putOpt("app_open_tracking_enabled", yandexMetricaConfig2.appOpenTrackingEnabled);
                if (yandexMetricaConfig2 instanceof com.yandex.metrica.i) {
                    com.yandex.metrica.i iVar = (com.yandex.metrica.i) yandexMetricaConfig2;
                    JSONObject jSONObjectPutOpt2 = jSONObject2.putOpt("device_type", iVar.a).putOpt("clids", Tl.f(iVar.b)).putOpt("distribution_referrer", iVar.c);
                    List<String> list = iVar.d;
                    JSONObject jSONObjectPutOpt3 = jSONObjectPutOpt2.putOpt("custom_hosts", list == null ? null : list.isEmpty() ? new JSONArray() : Tl.b((List<?>) list)).putOpt("app_build_number", iVar.e).putOpt("dispatch_period_seconds", iVar.f).putOpt("max_reports_count", iVar.g).putOpt("app_environment", Tl.f(iVar.h)).putOpt("preload_info_auto_tracking", iVar.i).putOpt("permissions_collection", iVar.j).putOpt("anr_monitoring", iVar.k);
                    this.b.getClass();
                    jSONObjectPutOpt3.putOpt("pulse_config", null).putOpt("rtm_config", null).put("crash_transformer_set", false);
                }
            }
            jSONObject.putOpt("config", jSONObject2).putOpt("process_name", ((Xl) this.a).b());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject a(Location location) throws JSONException {
        if (location == null) {
            return null;
        }
        return new JSONObject().putOpt("provider", location.getProvider()).put("timestamp", location.getTime()).put("precision", location.getAccuracy()).put("altitude", location.getAltitude()).put("lon", location.getLongitude()).put("lat", location.getLatitude()).put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, location.getBearing()).put("speed", location.getSpeed());
    }
}
