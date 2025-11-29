package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.yandex.metrica.impl.ob.H1;
import com.yandex.metrica.impl.ob.Jf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.lh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1077lh {
    private static final Map<Jf.e.b.a, String> a = Collections.unmodifiableMap(new a());
    private static final Map<H1.d, String> b = Collections.unmodifiableMap(new b());

    /* renamed from: com.yandex.metrica.impl.ob.lh$a */
    class a extends HashMap<Jf.e.b.a, String> {
        a() {
            put(Jf.e.b.a.COMPLETE, "complete");
            put(Jf.e.b.a.ERROR, "error");
            put(Jf.e.b.a.OFFLINE, "offline");
            put(Jf.e.b.a.INCOMPATIBLE_NETWORK_TYPE, "incompatible_network_type");
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.lh$b */
    class b extends HashMap<H1.d, String> {
        b() {
            put(H1.d.WIFI, "wifi");
            put(H1.d.CELL, "cell");
            put(H1.d.OFFLINE, "offline");
            put(H1.d.UNDEFINED, "undefined");
        }
    }

    public String a(Jf.e.b bVar) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("id", bVar.d().a);
            jSONObject.putOpt("url", bVar.d().b);
            jSONObject.putOpt(UpdateKey.STATUS, a.get(bVar.h()));
            jSONObject.putOpt("code", bVar.f());
            if (!A2.a(bVar.e())) {
                jSONObject.putOpt("body", Base64.encodeToString(bVar.e(), 0));
            } else if (!A2.a(bVar.b())) {
                jSONObject.putOpt("body", Base64.encodeToString(bVar.b(), 0));
            }
            jSONObject.putOpt("headers", a(bVar.g()));
            Throwable thC = bVar.c();
            if (thC != null) {
                str = thC.toString() + "\n" + Log.getStackTraceString(thC);
            } else {
                str = null;
            }
            jSONObject.putOpt("error", str);
            jSONObject.putOpt("network_type", b.get(bVar.a()));
            return jSONObject.toString();
        } catch (Throwable th) {
            return th.toString();
        }
    }

    private JSONObject a(Map<String, List<String>> map) throws JSONException {
        if (A2.b(map)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!A2.b(entry.getValue())) {
                List<String> value = entry.getValue();
                if (value.size() > 10) {
                    ArrayList arrayList = new ArrayList(10);
                    for (int i = 0; i < 10; i++) {
                        arrayList.add(value.get(i));
                    }
                    value = arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str : value) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList2.add(A2.a(str, 100));
                    }
                }
                jSONObject.putOpt(key, TextUtils.join(",", arrayList2));
            }
        }
        return jSONObject;
    }
}
