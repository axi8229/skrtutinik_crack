package com.yandex.metrica.impl.ob;

import android.util.Pair;
import com.yandex.metrica.impl.ob.C0829bi;
import com.yandex.metrica.impl.ob.Tl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Pi {
    private static final Map<String, C0829bi.a> a = Collections.unmodifiableMap(new a());

    class a extends HashMap<String, C0829bi.a> {
        a() {
            put("wifi", C0829bi.a.WIFI);
            put("cell", C0829bi.a.CELL);
        }
    }

    void a(Ui ui, Tl.a aVar) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject = aVar.optJSONObject("requests");
        if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("list") || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("list")) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                arrayList.add(a(jSONArrayOptJSONArray.getJSONObject(i)));
            } catch (Throwable unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ui.g(arrayList);
    }

    private C0829bi a(JSONObject jSONObject) throws JSONException {
        int i;
        JSONObject jSONObject2 = jSONObject.getJSONObject("headers");
        ArrayList arrayList = new ArrayList(jSONObject2.length());
        Iterator<String> itKeys = jSONObject2.keys();
        while (true) {
            i = 0;
            if (!itKeys.hasNext()) {
                break;
            }
            String next = itKeys.next();
            JSONArray jSONArray = jSONObject2.getJSONArray(next);
            while (i < jSONArray.length()) {
                arrayList.add(new Pair(next, jSONArray.getString(i)));
                i++;
            }
        }
        String strB = Tl.b(jSONObject, "id");
        String strB2 = Tl.b(jSONObject, "url");
        String strB3 = Tl.b(jSONObject, "method");
        Long lValueOf = Long.valueOf(jSONObject.getLong("delay_seconds"));
        ArrayList arrayList2 = new ArrayList();
        if (jSONObject.has("accept_network_types")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("accept_network_types");
            while (i < jSONArray2.length()) {
                arrayList2.add(a.get(jSONArray2.getString(i)));
                i++;
            }
        }
        return new C0829bi(strB, strB2, strB3, arrayList, lValueOf, arrayList2);
    }
}
