package com.yandex.metrica.impl.ob;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Tl;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Ei {
    private final C1408z9 a;

    public Ei() {
        this(new C1408z9());
    }

    void a(Ui ui, Tl.a aVar) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject = aVar.optJSONObject("diagnostics");
        if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("functionalities")) == null) {
            return;
        }
        C1194qa c1194qa = null;
        C1194qa c1194qa2 = null;
        C1194qa c1194qa3 = null;
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                String string = jSONObject.getString(RemoteMessageConst.Notification.TAG);
                C1408z9 c1408z9 = this.a;
                If.e eVar = new If.e();
                eVar.a = jSONObject.getLong("expiration_timestamp");
                eVar.b = jSONObject.optInt("interval", eVar.b);
                C1194qa model = c1408z9.toModel(eVar);
                if ("activation".equals(string)) {
                    c1194qa = model;
                } else if ("clids_info".equals(string)) {
                    c1194qa3 = model;
                } else if ("preload_info".equals(string)) {
                    c1194qa2 = model;
                }
            } catch (Throwable unused) {
            }
        }
        ui.a(new C1217ra(c1194qa, c1194qa3, c1194qa2));
    }

    Ei(C1408z9 c1408z9) {
        this.a = c1408z9;
    }
}
