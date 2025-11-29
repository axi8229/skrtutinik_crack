package com.group_ib.sdk;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class N {
    public final LinkedHashMap a = new LinkedHashMap();
    public int b = 0;

    public static JSONArray a(LinkedHashMap linkedHashMap) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((LinkedList) ((Map.Entry) it.next()).getValue()).iterator();
            while (it2.hasNext()) {
                jSONArray.put(((L) it2.next()).a());
            }
        }
        return jSONArray;
    }

    public final JSONObject a() {
        if (this.b == 0) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (C c : this.a.keySet()) {
                jSONArray.put(new JSONObject().put("page", c.b).put("element", c.a()).put(RemoteMessageConst.DATA, a((LinkedHashMap) this.a.get(c))));
            }
            return new JSONObject().put("version", "3.1.0").put(RemoteMessageConst.DATA, new JSONArray().put(new JSONObject().put("activity", jSONArray)));
        } catch (Exception e) {
            c1.b("ActivityEvents", "failed to stringify activity events", e);
            return null;
        }
    }
}
