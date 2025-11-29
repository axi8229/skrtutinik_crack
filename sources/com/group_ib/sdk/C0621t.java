package com.group_ib.sdk;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0621t {
    public final int a;
    public final long b;
    public final String c;
    public final String d;

    public C0621t(int i, String str, String str2) {
        this.a = i;
        this.b = System.currentTimeMillis();
        this.c = str;
        this.d = str2;
    }

    public final JSONObject a() throws JSONException {
        Exception e;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("level", AbstractC0585a.a(this.a));
                jSONObject.put(CrashHianalyticsData.TIME, this.b);
                jSONObject.put("module", this.c);
                jSONObject.put(CrashHianalyticsData.MESSAGE, this.d);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
            jSONObject = null;
        }
        return jSONObject;
    }

    public C0621t(String str, String str2, Exception exc) {
        this.a = 1;
        this.b = System.currentTimeMillis();
        this.c = str;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        if (exc != null) {
            exc.printStackTrace(printWriter);
        }
        this.d = str2 + '\n' + stringWriter.toString();
    }
}
