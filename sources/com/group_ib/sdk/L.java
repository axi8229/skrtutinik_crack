package com.group_ib.sdk;

import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class L {
    public final D a;
    public final C b;
    public final JSONObject c;

    public L(C c, JSONObject jSONObject) {
        this.a = D.navigation;
        this.b = c;
        this.c = jSONObject;
    }

    public JSONObject a() {
        return new JSONObject().put("type", this.a.name()).put(RemoteMessageConst.DATA, this.c);
    }

    public L(D d, C c) {
        this.a = d;
        this.b = c;
        this.c = new JSONObject();
    }
}
