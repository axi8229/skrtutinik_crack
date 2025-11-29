package com.huawei.location.lite.common.http;

import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class HttpInterceptorEx {
    private static final HashMap<String, Class> adapterHashMap = new HashMap<>();

    public static InterceptorAdapter getUrlPathExInterceptor(String str) {
        Class cls = adapterHashMap.get(str);
        if (cls == null) {
            return null;
        }
        try {
            return (InterceptorAdapter) cls.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}
