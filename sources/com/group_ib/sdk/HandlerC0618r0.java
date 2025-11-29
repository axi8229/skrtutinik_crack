package com.group_ib.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.r0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class HandlerC0618r0 extends Handler {
    public MobileSdkService a;
    public final LinkedHashMap b;
    public final LinkedHashMap c;
    public boolean d;
    public JSONArray e;

    public HandlerC0618r0() {
        super(Looper.getMainLooper());
        this.a = null;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = false;
        this.e = null;
    }

    public final synchronized void a(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
        if (mobileSdkService != null) {
            c();
        }
    }

    public final synchronized JSONArray b() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = this.e;
        if (jSONArray2 == null || jSONArray2.length() == 0) {
            jSONArray = null;
        } else {
            jSONArray = this.e;
            this.e = new JSONArray();
        }
        return jSONArray;
    }

    public final void c() {
        JSONArray jSONArray = null;
        if (this.d) {
            synchronized (this) {
                try {
                    if (!this.b.isEmpty()) {
                        jSONArray = new JSONArray();
                        Iterator it = this.b.entrySet().iterator();
                        while (it.hasNext()) {
                            jSONArray.put(((Map.Entry) it.next()).getValue());
                        }
                    }
                    this.d = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        JSONArray jSONArrayA = a();
        JSONArray jSONArrayB = b();
        if (jSONArray == null && jSONArrayB == null) {
            return;
        }
        c1.a(4, 4, "Attributes", "Attributes have changed");
        this.a.a(jSONArray, jSONArrayA, jSONArrayB);
    }

    @Override // android.os.Handler
    public final synchronized void handleMessage(Message message) {
        if (this.a != null) {
            c();
        }
    }

    public final synchronized void a(String str, String str2) {
        a(str, str2, false);
    }

    public final synchronized void a(String str, String str2, boolean z) {
        String string;
        try {
            c1.a(3, 3, "Attributes", "setAttribute(" + str + ", " + str2 + ")");
        } catch (Exception e) {
            c1.b("Attributes", "Failed to add attribute", e);
        } finally {
        }
        if (str != null && !str.isEmpty() && str2 != null) {
            LinkedHashMap linkedHashMap = z ? this.c : this.b;
            JSONObject jSONObject = (JSONObject) linkedHashMap.get(str);
            if (jSONObject == null || (string = jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE)) == null || !string.equals(str2)) {
                linkedHashMap.put(str, new JSONObject().put("key", str).put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str2).put(CrashHianalyticsData.TIME, System.currentTimeMillis()));
                if (!z) {
                    this.d = true;
                }
                if (this.a != null && !hasMessages(0)) {
                    sendEmptyMessage(0);
                }
            }
        }
    }

    public final synchronized JSONArray a() {
        JSONArray jSONArray;
        try {
            if (this.c.isEmpty()) {
                jSONArray = null;
            } else {
                jSONArray = new JSONArray();
                if (!this.b.isEmpty()) {
                    Iterator it = this.b.entrySet().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((Map.Entry) it.next()).getValue());
                    }
                }
                Iterator it2 = this.c.entrySet().iterator();
                while (it2.hasNext()) {
                    jSONArray.put(((Map.Entry) it2.next()).getValue());
                }
                this.c.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONArray;
    }

    public final synchronized void a(String str) {
        if (str == null) {
            return;
        }
        try {
            byte[] bytes = str.getBytes();
            char[] cArr = AbstractC0604j0.a;
            a("login_hash", AbstractC0604j0.a(MessageDigest.getInstance("SHA1").digest(bytes)), false);
            String str2 = T.a;
            a("login_rsa", null, false);
        } catch (Exception e) {
            c1.b("Attributes", "Failed to set login", e);
        }
    }
}
