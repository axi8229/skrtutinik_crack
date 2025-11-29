package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.z1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1400z1 {
    private final B0 a;
    private boolean b;

    public C1400z1(Xl xl) {
        this(xl, new B0());
    }

    public void a(Context context) {
        long jOptLong;
        String strA;
        synchronized (this) {
        }
        if (this.b) {
            return;
        }
        synchronized (this) {
            try {
                strA = L0.a(this.a.a(context, "metrica_service_settings.dat"));
            } catch (Throwable unused) {
            }
            jOptLong = !TextUtils.isEmpty(strA) ? new JSONObject(strA).optLong("delay") : 0L;
        }
        if (jOptLong > 0) {
            try {
                Thread.sleep(jOptLong);
            } catch (Throwable unused2) {
            }
        }
        this.b = true;
    }

    C1400z1(Xl xl, B0 b0) {
        this.b = false;
        this.a = b0;
    }
}
