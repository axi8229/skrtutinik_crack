package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.Tl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Ii {
    private static final Set<String> a;

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        hashSet.add("get_ad");
        hashSet.add("report");
        hashSet.add("report_ad");
        hashSet.add("location");
        hashSet.add("startup");
        hashSet.add("diagnostic");
        hashSet.add("mediascope");
    }

    void a(Ui ui, Tl.a aVar) {
        String string;
        List<String> listA;
        String string2 = "";
        try {
            Object jSONObject = new JSONObject();
            try {
                jSONObject = aVar.get("query_hosts");
            } catch (Throwable unused) {
            }
            JSONObject jSONObjectOptJSONObject = ((JSONObject) jSONObject).optJSONObject("list");
            if (jSONObjectOptJSONObject != null) {
                try {
                    string = jSONObjectOptJSONObject.getJSONObject("get_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused2) {
                    string = "";
                }
                if (!TextUtils.isEmpty(string)) {
                    ui.f(string);
                }
                List<String> listA2 = a(jSONObjectOptJSONObject, "report");
                if (!A2.b(listA2)) {
                    ui.f(listA2);
                }
                try {
                    string2 = jSONObjectOptJSONObject.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused3) {
                }
                if (!TextUtils.isEmpty(string2)) {
                    ui.g(string2);
                }
                List<String> listA3 = a(jSONObjectOptJSONObject, "location");
                if (!A2.b(listA3)) {
                    ui.c(listA3);
                }
                List<String> listA4 = a(jSONObjectOptJSONObject, "startup");
                if (!A2.b(listA4)) {
                    ui.h(listA4);
                }
                List<String> listA5 = a(jSONObjectOptJSONObject, "diagnostic");
                if (!A2.b(listA5)) {
                    ui.a(listA5);
                }
                List<String> listA6 = a(jSONObjectOptJSONObject, "mediascope");
                if (!A2.b(listA6)) {
                    ui.e(listA6);
                }
                HashMap map = new HashMap();
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!a.contains(next) && (listA = a(jSONObjectOptJSONObject, next)) != null) {
                        map.put(next, listA);
                    }
                }
                ui.a(map);
            }
        } catch (Throwable unused4) {
        }
    }

    private List<String> a(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                return Tl.b(jSONObjectOptJSONObject.getJSONArray("urls"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
