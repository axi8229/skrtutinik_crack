package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.PreloadInfo;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.ie, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1000ie {
    private C0900ee a;

    public C1000ie(PreloadInfo preloadInfo, C0858cm c0858cm, boolean z) {
        if (preloadInfo != null) {
            if (!TextUtils.isEmpty(preloadInfo.getTrackingId())) {
                this.a = new C0900ee(preloadInfo.getTrackingId(), new JSONObject(preloadInfo.getAdditionalParams()), true, z, EnumC1279u0.APP);
            } else if (c0858cm.isEnabled()) {
                c0858cm.e("Required field \"PreloadInfo.trackingId\" is empty!\nThis preload info will be skipped.");
            }
        }
    }

    public JSONObject a(JSONObject jSONObject) {
        C0900ee c0900ee = this.a;
        if (c0900ee != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("trackingId", c0900ee.a);
                    jSONObject2.put("additionalParams", c0900ee.b);
                    jSONObject2.put("wasSet", c0900ee.c);
                    jSONObject2.put("autoTracking", c0900ee.d);
                    jSONObject2.put("source", c0900ee.e.a());
                } catch (Throwable unused) {
                }
                jSONObject.put("preloadInfo", jSONObject2);
            } catch (Throwable unused2) {
            }
        }
        return jSONObject;
    }
}
