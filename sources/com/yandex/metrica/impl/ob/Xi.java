package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Xi {
    private C0846ca a;
    private final Zi b;

    public Xi() {
        this(new C0846ca(), new Zi());
    }

    public C0982hl a(JSONObject jSONObject, String str, If.v vVar) {
        C0846ca c0846ca = this.a;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject != null) {
            vVar.a = jSONObjectOptJSONObject.optBoolean("text_size_collecting", vVar.a);
            vVar.b = jSONObjectOptJSONObject.optBoolean("relative_text_size_collecting", vVar.b);
            vVar.c = jSONObjectOptJSONObject.optBoolean("text_visibility_collecting", vVar.c);
            vVar.d = jSONObjectOptJSONObject.optBoolean("text_style_collecting", vVar.d);
            vVar.i = jSONObjectOptJSONObject.optBoolean("info_collecting", vVar.i);
            vVar.j = jSONObjectOptJSONObject.optBoolean("non_content_view_collecting", vVar.j);
            vVar.k = jSONObjectOptJSONObject.optBoolean("text_length_collecting", vVar.k);
            vVar.l = jSONObjectOptJSONObject.optBoolean("view_hierarchical", vVar.l);
            vVar.n = jSONObjectOptJSONObject.optBoolean("ignore_filtered", vVar.n);
            vVar.o = jSONObjectOptJSONObject.optBoolean("web_view_urls_collecting", vVar.o);
            vVar.e = jSONObjectOptJSONObject.optInt("too_long_text_bound", vVar.e);
            vVar.f = jSONObjectOptJSONObject.optInt("truncated_text_bound", vVar.f);
            vVar.g = jSONObjectOptJSONObject.optInt("max_entities_count", vVar.g);
            vVar.h = jSONObjectOptJSONObject.optInt("max_full_content_length", vVar.h);
            vVar.p = jSONObjectOptJSONObject.optInt("web_view_url_limit", vVar.p);
            vVar.m = this.b.a(jSONObjectOptJSONObject.optJSONArray("filters"));
        }
        return c0846ca.toModel(vVar);
    }

    Xi(C0846ca c0846ca, Zi zi) {
        this.a = c0846ca;
        this.b = zi;
    }
}
