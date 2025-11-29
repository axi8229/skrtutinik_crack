package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.yandex.metrica.PreloadInfo;
import com.yandex.metrica.YandexMetricaConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.m1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1086m1 {
    private Location b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Location location = new Location(jSONObject.has("provider") ? jSONObject.optString("provider") : null);
            location.setLongitude(jSONObject.getDouble("lng"));
            location.setLatitude(jSONObject.getDouble("lat"));
            location.setTime(jSONObject.optLong(CrashHianalyticsData.TIME));
            location.setAccuracy((float) jSONObject.optDouble("accuracy"));
            location.setAltitude((float) jSONObject.optDouble("alt"));
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    private PreloadInfo c(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        PreloadInfo.Builder builderNewBuilder = PreloadInfo.newBuilder(jSONObject.has("trackid") ? jSONObject.optString("trackid") : null);
        HashMap<String, String> mapD = Tl.d(jSONObject.optString("params"));
        if (mapD != null && mapD.size() > 0) {
            for (Map.Entry<String, String> entry : mapD.entrySet()) {
                builderNewBuilder.setAdditionalParams(entry.getKey(), entry.getValue());
            }
        }
        return builderNewBuilder.build();
    }

    public String a(YandexMetricaConfig yandexMetricaConfig) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apikey", yandexMetricaConfig.apiKey);
            jSONObject.put("app_version", yandexMetricaConfig.appVersion);
            jSONObject.put("session_timeout", yandexMetricaConfig.sessionTimeout);
            jSONObject.put("location", a(yandexMetricaConfig.location));
            PreloadInfo preloadInfo = yandexMetricaConfig.preloadInfo;
            if (preloadInfo == null) {
                string = null;
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("trackid", preloadInfo.getTrackingId());
                    jSONObject2.put("params", Tl.e(preloadInfo.getAdditionalParams()));
                    string = jSONObject2.toString();
                } catch (Throwable unused) {
                }
            }
            jSONObject.put("preload_info", string);
            jSONObject.put("logs", yandexMetricaConfig.logs);
            jSONObject.put("crash_enabled", yandexMetricaConfig.crashReporting);
            jSONObject.put("crash_native_enabled", yandexMetricaConfig.nativeCrashReporting);
            jSONObject.put("location_enabled", yandexMetricaConfig.locationTracking);
            jSONObject.put("max_reports_in_db_count", yandexMetricaConfig.maxReportsInDatabaseCount);
            jSONObject.put("error_environment", Tl.e(yandexMetricaConfig.errorEnvironment));
            jSONObject.put("first_activation_as_update", yandexMetricaConfig.firstActivationAsUpdate);
            jSONObject.put("statistics_sending", yandexMetricaConfig.statisticsSending);
            jSONObject.put("user_profile_id", yandexMetricaConfig.userProfileID);
            jSONObject.put("revenue_auto_tracking_enabled", yandexMetricaConfig.revenueAutoTrackingEnabled);
            jSONObject.put("sessions_auto_tracking_enabled", yandexMetricaConfig.sessionsAutoTrackingEnabled);
            jSONObject.put("app_open_tracking_enabled", yandexMetricaConfig.appOpenTrackingEnabled);
            return jSONObject.toString();
        } catch (Throwable unused2) {
            return "";
        }
    }

    public YandexMetricaConfig a(String str) {
        YandexMetricaConfig yandexMetricaConfig;
        HashMap<String, String> mapD;
        if (TextUtils.isEmpty(str)) {
            yandexMetricaConfig = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                YandexMetricaConfig.Builder builderNewConfigBuilder = YandexMetricaConfig.newConfigBuilder(jSONObject.getString("apikey"));
                if (jSONObject.has("app_version")) {
                    builderNewConfigBuilder.withAppVersion(jSONObject.optString("app_version"));
                }
                if (jSONObject.has("session_timeout")) {
                    builderNewConfigBuilder.withSessionTimeout(jSONObject.getInt("session_timeout"));
                }
                builderNewConfigBuilder.withLocation(b(jSONObject.optString("location")));
                builderNewConfigBuilder.withPreloadInfo(c(jSONObject.optString("preload_info")));
                if (jSONObject.has("logs") && jSONObject.optBoolean("logs")) {
                    builderNewConfigBuilder.withLogs();
                }
                if (jSONObject.has("crash_enabled")) {
                    builderNewConfigBuilder.withCrashReporting(jSONObject.optBoolean("crash_enabled"));
                }
                if (jSONObject.has("crash_native_enabled")) {
                    builderNewConfigBuilder.withNativeCrashReporting(jSONObject.optBoolean("crash_native_enabled"));
                }
                if (jSONObject.has("location_enabled")) {
                    builderNewConfigBuilder.withLocationTracking(jSONObject.optBoolean("location_enabled"));
                }
                if (jSONObject.has("max_reports_in_db_count")) {
                    builderNewConfigBuilder.withMaxReportsInDatabaseCount(jSONObject.optInt("max_reports_in_db_count"));
                }
                if (jSONObject.has("error_environment") && (mapD = Tl.d(jSONObject.optString("error_environment"))) != null) {
                    for (Map.Entry<String, String> entry : mapD.entrySet()) {
                        builderNewConfigBuilder.withErrorEnvironmentValue(entry.getKey(), entry.getValue());
                    }
                }
                if (jSONObject.has("first_activation_as_update")) {
                    builderNewConfigBuilder.handleFirstActivationAsUpdate(jSONObject.optBoolean("first_activation_as_update"));
                }
                if (jSONObject.has("statistics_sending")) {
                    builderNewConfigBuilder.withStatisticsSending(jSONObject.optBoolean("statistics_sending"));
                }
                if (jSONObject.has("user_profile_id")) {
                    yandexMetricaConfig = null;
                    try {
                        builderNewConfigBuilder.withUserProfileID(jSONObject.optString("user_profile_id", null));
                    } catch (Throwable unused) {
                    }
                } else {
                    yandexMetricaConfig = null;
                }
                if (jSONObject.has("revenue_auto_tracking_enabled")) {
                    builderNewConfigBuilder.withRevenueAutoTrackingEnabled(jSONObject.optBoolean("revenue_auto_tracking_enabled"));
                }
                if (jSONObject.has("sessions_auto_tracking_enabled")) {
                    builderNewConfigBuilder.withSessionsAutoTrackingEnabled(jSONObject.optBoolean("sessions_auto_tracking_enabled"));
                }
                if (jSONObject.has("app_open_tracking_enabled")) {
                    builderNewConfigBuilder.withAppOpenTrackingEnabled(jSONObject.optBoolean("app_open_tracking_enabled"));
                }
                return builderNewConfigBuilder.build();
            } catch (Throwable unused2) {
            }
        }
        return yandexMetricaConfig;
    }

    private String a(Location location) {
        if (location == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("provider", location.getProvider());
            jSONObject.put(CrashHianalyticsData.TIME, location.getTime());
            jSONObject.put("accuracy", location.getAccuracy());
            jSONObject.put("alt", location.getAltitude());
            jSONObject.put("lng", location.getLongitude());
            jSONObject.put("lat", location.getLatitude());
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
