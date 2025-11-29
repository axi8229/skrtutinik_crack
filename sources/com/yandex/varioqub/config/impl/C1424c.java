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

/* renamed from: com.yandex.varioqub.config.impl.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1424c {
    public final i a;
    public final long b;
    public final t c;
    public final C1422a d;
    public final u e;
    public long f;
    public long g;
    public HashMap h = new HashMap();
    public String i = "";
    public String j = "";
    public String k = "";
    public final AtomicBoolean l = new AtomicBoolean(false);
    public boolean m;

    public C1424c(i iVar, long j, t tVar, C1422a c1422a, u uVar) {
        this.a = iVar;
        this.b = j;
        this.c = tVar;
        this.d = c1422a;
        this.e = uVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.Map] */
    public final void a() throws JSONException {
        ?? EmptyMap;
        ConfigValue configValue;
        if (this.l.compareAndSet(false, true)) {
            this.f = m.a().getLong("last_fetched_time_ms_key", 0L);
            this.g = m.a().getLong("last_successful_fetched_time_ms_key", 0L);
            String string = m.a().getString("experiments", "");
            if (string == null) {
                string = "";
            }
            this.j = string;
            String string2 = m.a().getString("identifier", "");
            if (string2 == null) {
                string2 = "";
            }
            this.i = string2;
            String string3 = m.a().getString("fetched_config_key", "");
            Context context = null;
            if (string3 == null || string3.length() == 0) {
                EmptyMap = MapsKt.emptyMap();
            } else {
                JSONObject jSONObject = new JSONObject(string3);
                EmptyMap = new HashMap();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string4 = jSONObject.getString(next);
                    if (string4 == null || string4.length() == 0) {
                        configValue = null;
                    } else {
                        JSONObject jSONObject2 = new JSONObject(string4);
                        configValue = new ConfigValue(jSONObject2.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE), jSONObject2.getInt("sourceType"), jSONObject2.getLong("testId"));
                    }
                    if (configValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.yandex.varioqub.config.model.ConfigValue");
                    }
                    EmptyMap.put(next, configValue);
                }
            }
            this.h = new HashMap((Map) EmptyMap);
            Context context2 = AbstractC1425d.a;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appContext");
            } else {
                context = context2;
            }
            this.m = context.getSharedPreferences(context.getPackageName() + "_varioqub_pref", 0).getBoolean("should_notify_adapter", false);
        }
    }
}
