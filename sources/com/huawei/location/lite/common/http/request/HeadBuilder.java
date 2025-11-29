package com.huawei.location.lite.common.http.request;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes3.dex */
public class HeadBuilder {
    private final HashMap<String, String> headers;

    public HeadBuilder() {
        this(UUID.randomUUID().toString());
    }

    public HeadBuilder(String str) {
        HashMap<String, String> map = new HashMap<>(16);
        this.headers = map;
        map.put("X-Request-ID", TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str);
        map.put("Content-Type", "application/json");
    }

    public HeadBuilder add(String str, String str2) {
        if (str != null && str2 != null) {
            this.headers.put(str, str2);
        }
        return this;
    }

    public HeadBuilder addAll(HashMap<String, String> map) {
        if (map != null) {
            this.headers.putAll(map);
        }
        return this;
    }

    public String get(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.headers.get(str);
    }

    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public String remove(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.headers.remove(str);
    }

    public HeadBuilder setPackageName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.headers.put("X-CP-Info", str);
        }
        return this;
    }

    public String toString() {
        return "HeadBuilder{headers=" + this.headers + '}';
    }
}
