package com.yandex.varioqub.config.impl;

import android.content.Context;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.varioqub.config.model.ConfigValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class t {
    public Map a = new HashMap();
    public Map b = MapsKt.emptyMap();
    public final AtomicBoolean c = new AtomicBoolean(false);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.HashMap] */
    public final void a() throws JSONException {
        ?? EmptyMap;
        ConfigValue configValue;
        if (this.c.compareAndSet(false, true)) {
            Context context = AbstractC1425d.a;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appContext");
                context = null;
            }
            String string = context.getSharedPreferences(context.getPackageName() + "_varioqub_pref", 0).getString("activated_config_key", "");
            if (string == null || string.length() == 0) {
                EmptyMap = MapsKt.emptyMap();
            } else {
                JSONObject jSONObject = new JSONObject(string);
                EmptyMap = new HashMap();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string2 = jSONObject.getString(next);
                    if (string2 == null || string2.length() == 0) {
                        configValue = null;
                    } else {
                        JSONObject jSONObject2 = new JSONObject(string2);
                        configValue = new ConfigValue(jSONObject2.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE), jSONObject2.getInt("sourceType"), jSONObject2.getLong("testId"));
                    }
                    if (configValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.yandex.varioqub.config.model.ConfigValue");
                    }
                    EmptyMap.put(next, configValue);
                }
            }
            this.b = EmptyMap;
        }
    }
}
