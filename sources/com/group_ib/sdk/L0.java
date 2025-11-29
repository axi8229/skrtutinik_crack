package com.group_ib.sdk;

import android.hardware.display.DisplayManager;
import android.os.Message;
import android.view.Display;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class L0 extends W0 {
    public static final String f = X.b(7);
    public static final String g = X.b(8);
    public static final String h = X.b(9);
    public static final String i = X.b(12);
    public static final String j = X.b(13);
    public static final String k = X.b(15);
    public static final String l = X.b(16);
    public static final String m = X.b(17);
    public static final String p = X.b(18);
    public I0 b;
    public DisplayManager c;
    public final HashMap d;
    public JSONArray e;

    public L0(MobileSdkService mobileSdkService) {
        super(mobileSdkService);
        this.b = null;
        this.c = null;
        this.d = new HashMap();
        this.e = null;
    }

    public final void a(boolean z, J0 j0) throws JSONException {
        if (j0 == null) {
            return;
        }
        HashMap map = this.d;
        Integer numValueOf = Integer.valueOf(j0.a);
        if (z) {
            map.put(numValueOf, j0);
        } else {
            map.remove(numValueOf);
        }
        try {
            JSONObject jSONObjectPut = new JSONObject().put("t", System.currentTimeMillis()).put("state", z ? g : h).put(m, j0.a());
            if (this.e == null) {
                this.e = new JSONArray();
            }
            this.e.put(jSONObjectPut);
            c1.a(f, jSONObjectPut.toString());
            sendEmptyMessageDelayed(1024, 1000L);
        } catch (Exception e) {
            c1.b(f, "failed to get event data", e);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 1024) {
            return;
        }
        removeMessages(1024);
        JSONArray jSONArray = this.e;
        if (jSONArray != null) {
            MobileSdkService mobileSdkService = this.a;
            synchronized (mobileSdkService.p) {
                mobileSdkService.M = jSONArray;
                mobileSdkService.q.a(true);
            }
            this.e = null;
        }
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void run() throws JSONException {
        if (this.b == null) {
            DisplayManager displayManager = (DisplayManager) this.a.getSystemService("display");
            this.c = displayManager;
            if (displayManager != null) {
                Display[] displays = displayManager.getDisplays();
                if (displays != null) {
                    for (Display display : displays) {
                        a(true, J0.a(display));
                    }
                }
                I0 i0 = new I0(this);
                this.c.registerDisplayListener(i0, this);
                this.b = i0;
            }
        }
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a() {
        if (this.c != null) {
            this.d.clear();
            I0 i0 = this.b;
            if (i0 != null) {
                this.c.unregisterDisplayListener(i0);
                this.b = null;
            }
        }
    }
}
