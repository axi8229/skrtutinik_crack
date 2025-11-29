package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Yi {
    private final C0871da a;
    private final Zi b;

    public Yi() {
        this(new C0871da(), new Zi());
    }

    public void a(Ui ui, JSONObject jSONObject) {
        C0871da c0871da = this.a;
        If.w wVar = new If.w();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ui_parsing");
        if (jSONObjectOptJSONObject != null) {
            wVar.a = jSONObjectOptJSONObject.optInt("too_long_text_bound", wVar.a);
            wVar.b = jSONObjectOptJSONObject.optInt("truncated_text_bound", wVar.b);
            wVar.c = jSONObjectOptJSONObject.optInt("max_visited_children_in_level", wVar.c);
            wVar.d = Tl.a(Tl.a(jSONObjectOptJSONObject, "after_create_timeout", (Long) null), TimeUnit.SECONDS, wVar.d);
            wVar.e = jSONObjectOptJSONObject.optBoolean("relative_text_size_calculation", wVar.e);
            wVar.f = jSONObjectOptJSONObject.optBoolean("error_reporting", wVar.f);
            wVar.g = jSONObjectOptJSONObject.optBoolean("parsing_allowed_by_default", wVar.g);
            wVar.h = this.b.a(jSONObjectOptJSONObject.optJSONArray("filters"));
        }
        ui.a(c0871da.toModel(wVar));
    }

    Yi(C0871da c0871da, Zi zi) {
        this.a = c0871da;
        this.b = zi;
    }
}
