package com.huawei.updatesdk.b.e;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class e {
    private static final Map<String, a> a = new ConcurrentHashMap();

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new c();
        }
        Map<String, a> map = a;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        map.put(str, "apptouch".equals(str) ? new b() : new c());
        return map.get(str);
    }
}
