package com.group_ib.sdk;

import android.view.MotionEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.h0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0600h0 {
    public final JSONArray a;
    public long b;
    public float c;
    public float d;
    public float e;
    public float f;

    public C0600h0(int i, MotionEvent motionEvent) {
        JSONArray jSONArray = new JSONArray();
        this.a = jSONArray;
        this.b = motionEvent.getEventTime();
        this.c = motionEvent.getX(i);
        this.d = motionEvent.getY(i);
        this.e = motionEvent.getPressure(i);
        this.f = motionEvent.getSize(i);
        jSONArray.put(new JSONObject().put("t", this.b).put("x", this.c).put("y", this.d).put("p", this.e).put("s", this.f));
    }

    public final void a(int i, MotionEvent motionEvent) throws JSONException {
        if (motionEvent.getActionMasked() == 2) {
            int historySize = motionEvent.getHistorySize();
            for (int i2 = 0; i2 < historySize; i2++) {
                a(motionEvent.getHistoricalEventTime(i2), motionEvent.getHistoricalX(i, i2), motionEvent.getHistoricalY(i, i2), motionEvent.getHistoricalPressure(i, i2), motionEvent.getHistoricalSize(i, i2));
            }
        }
        a(motionEvent.getEventTime(), motionEvent.getX(i), motionEvent.getY(i), motionEvent.getPressure(i), motionEvent.getSize(i));
    }

    public final void a(long j, float f, float f2, float f3, float f4) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("dt", j - this.b);
        this.b = j;
        if (f != this.c) {
            jSONObjectPut.put("dx", f - r5);
            this.c = f;
        }
        if (f2 != this.d) {
            jSONObjectPut.put("dy", f2 - r5);
            this.d = f2;
        }
        if (f3 != this.e) {
            jSONObjectPut.put("dp", f3 - r5);
            this.e = f3;
        }
        if (f4 != this.f) {
            jSONObjectPut.put("ds", f4 - r5);
            this.f = f4;
        }
        this.a.put(jSONObjectPut);
    }
}
