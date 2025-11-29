package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Th {
    private Map<String, ? extends List<String>> a = MapsKt.emptyMap();
    private Map<String, ? extends W0> b = MapsKt.emptyMap();
    private W0 c;

    public final W0 a() {
        return this.c;
    }

    public final Map<String, W0> b() {
        return this.b;
    }

    public final synchronized void a(W0 w0) {
        HashMap map;
        Map mapEmptyMap;
        List<String> listB;
        String str;
        try {
            W0 w02 = this.c;
            String str2 = w02 != null ? w02.a : null;
            if (str2 == null || str2.length() == 0 || ((str = w0.a) != null && str.length() != 0)) {
                this.c = w0;
                String str3 = w0.a;
                if (str3 == null) {
                    map = null;
                } else {
                    map = new HashMap();
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            try {
                                List<String> listB2 = Tl.b(new JSONArray(jSONObject.optString(next)));
                                if (listB2 != null) {
                                    map.put(next, listB2);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (map != null) {
                    mapEmptyMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                    for (Map.Entry entry : map.entrySet()) {
                        mapEmptyMap.put(entry.getKey(), new W0(String.valueOf(Tl.b((List<?>) entry.getValue())), w0.b, w0.c));
                    }
                } else {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                this.b = mapEmptyMap;
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapEmptyMap.size()));
                for (Map.Entry entry2 : mapEmptyMap.entrySet()) {
                    Object key = entry2.getKey();
                    String str4 = ((W0) entry2.getValue()).a;
                    if (str4 == null) {
                        listB = null;
                    } else {
                        try {
                            listB = Tl.b(new JSONArray(str4));
                        } catch (Throwable unused3) {
                        }
                    }
                    if (listB == null) {
                        listB = CollectionsKt.emptyList();
                    }
                    linkedHashMap.put(key, listB);
                }
                this.a = linkedHashMap;
            }
        } finally {
        }
    }

    public final synchronized void a(List<String> list, Map<String, W0> map) {
        U0 u0;
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : list) {
                List<String> list2 = this.a.get(str);
                if (list2 != null && !list2.isEmpty()) {
                    linkedHashMap.put(str, list2);
                }
            }
            String strB = Tl.b(linkedHashMap);
            W0 w0 = this.c;
            if (w0 == null || (u0 = w0.b) == null) {
                u0 = U0.UNKNOWN;
            }
            map.put("yandex_mobile_metrica_custom_sdk_hosts", new W0(strB, u0, w0 != null ? w0.c : null));
        } catch (Throwable th) {
            throw th;
        }
    }
}
