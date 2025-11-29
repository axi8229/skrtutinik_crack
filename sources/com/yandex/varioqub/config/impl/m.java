package com.yandex.varioqub.config.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.varioqub.config.model.ConfigValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class m {
    public static SharedPreferences a() {
        Context context = AbstractC1425d.a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
            context = null;
        }
        return context.getSharedPreferences(context.getPackageName() + "_varioqub_pref", 0);
    }

    public static void b(HashMap map) throws JSONException {
        SharedPreferences.Editor editorEdit = a().edit();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            ConfigValue configValue = (ConfigValue) entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, configValue.asString());
            jSONObject2.put("sourceType", configValue.getSourceType());
            jSONObject2.put("testId", configValue.getTestId());
            jSONObject.put(str, jSONObject2.toString());
        }
        editorEdit.putString("fetched_config_key", jSONObject.toString()).apply();
    }

    public static void c(String str) {
        a().edit().putString("identifier", str).apply();
    }

    public static void a(long j) {
        a().edit().putLong("last_fetched_time_ms_key", j).apply();
    }

    public static void a(HashMap map) throws JSONException {
        SharedPreferences.Editor editorEdit = a().edit();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            ConfigValue configValue = (ConfigValue) entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, configValue.asString());
            jSONObject2.put("sourceType", configValue.getSourceType());
            jSONObject2.put("testId", configValue.getTestId());
            jSONObject.put(str, jSONObject2.toString());
        }
        editorEdit.putString("activated_config_key", jSONObject.toString()).apply();
    }

    public static void b(String str) {
        a().edit().putString("etag", str).apply();
    }

    public static LinkedHashSet b() {
        Set<String> stringSet = a().getStringSet("varioqub_testids", new LinkedHashSet());
        if (stringSet == null) {
            stringSet = SetsKt.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = stringSet.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(Long.valueOf(Long.parseLong((String) it.next())));
        }
        return linkedHashSet;
    }

    public static void a(boolean z) {
        a().edit().putBoolean("should_notify_adapter", z).apply();
    }

    public static void a(Set set) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(String.valueOf(((Number) it.next()).longValue()));
        }
        a().edit().putStringSet("varioqub_testids", linkedHashSet).apply();
    }

    public static void b(long j) {
        a().edit().putLong("last_successful_fetched_time_ms_key", j).apply();
    }

    public static void a(String str) {
        a().edit().putString("config_version", str).apply();
    }
}
