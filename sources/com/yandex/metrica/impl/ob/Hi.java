package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Sh;
import com.yandex.metrica.impl.ob.Tl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Hi {
    void a(Ui ui, Tl.a aVar) {
        If.i iVar = new If.i();
        try {
            Object jSONObject = new JSONObject();
            try {
                jSONObject = aVar.get("features");
            } catch (Throwable unused) {
            }
            JSONObject jSONObjectOptJSONObject = ((JSONObject) jSONObject).optJSONObject("list");
            if (jSONObjectOptJSONObject != null) {
                Sh sh = new Sh(new Sh.a().d(a(jSONObjectOptJSONObject, "easy_collecting", iVar.a)).e(a(jSONObjectOptJSONObject, "egress", iVar.w)).m(a(jSONObjectOptJSONObject, "package_info", iVar.b)).n(a(jSONObjectOptJSONObject, "permissions_collecting", iVar.c)).f(a(jSONObjectOptJSONObject, "features_collecting", iVar.d)).o(a(jSONObjectOptJSONObject, "sdk_list", iVar.j)).g(a(jSONObjectOptJSONObject, "google_aid", iVar.e)).q(a(jSONObjectOptJSONObject, "throttling", iVar.r)).v(a(jSONObjectOptJSONObject, "wifi_around", iVar.f)).w(a(jSONObjectOptJSONObject, "wifi_connected", iVar.g)).c(a(jSONObjectOptJSONObject, "cells_around", iVar.h)).p(a(jSONObjectOptJSONObject, "sim_info", iVar.i)).j(a(jSONObjectOptJSONObject, "identity_light_collecting", iVar.k)).l(a(jSONObjectOptJSONObject, "location_collecting", iVar.l)).k(a(jSONObjectOptJSONObject, "lbs_collecting", iVar.m)).h(a(jSONObjectOptJSONObject, "gpl_collecting", iVar.n)).t(a(jSONObjectOptJSONObject, "ui_parsing", iVar.o)).s(a(jSONObjectOptJSONObject, "ui_event_sending", iVar.p)).u(a(jSONObjectOptJSONObject, "ui_raw_event_sending", iVar.p)).r(a(jSONObjectOptJSONObject, "ui_collecting_for_bridge", iVar.q)).a(a(jSONObjectOptJSONObject, "cell_additional_info", iVar.s)).b(a(jSONObjectOptJSONObject, "cell_additional_info_connected_only", iVar.t)).i(a(jSONObjectOptJSONObject, "huawei_oaid", iVar.v)).a(jSONObjectOptJSONObject.has("ssl_pinning") ? Boolean.valueOf(jSONObjectOptJSONObject.getJSONObject("ssl_pinning").getBoolean("enabled")) : null));
                ui.a(a(jSONObjectOptJSONObject, "socket", false));
                ui.a(sh);
            }
        } catch (Throwable unused2) {
        }
    }

    private boolean a(JSONObject jSONObject, String str, boolean z) throws JSONException {
        Boolean boolValueOf = jSONObject.has(str) ? Boolean.valueOf(jSONObject.getJSONObject(str).getBoolean("enabled")) : null;
        Boolean boolValueOf2 = Boolean.valueOf(z);
        if (boolValueOf == null) {
            boolValueOf = boolValueOf2;
        }
        return boolValueOf.booleanValue();
    }
}
