package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.fasterxml.jackson.core.JsonPointer;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.ConfigReader;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class c extends AGConnectServicesConfig {
    private final Context a;
    private final String b;
    private volatile ConfigReader d;
    private final Object e = new Object();
    private AGCRoutePolicy f = AGCRoutePolicy.UNKNOWN;
    private final Map<String, String> g = new HashMap();
    private volatile e h;

    public c(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    private static String a(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return JsonPointer.SEPARATOR + str.substring(i);
    }

    private void a() {
        Log.d("AGC_ConfigImpl", "initConfigReader");
        if (this.d == null) {
            synchronized (this.e) {
                try {
                    if (this.d == null) {
                        this.d = new m(this.a, this.b);
                        this.h = new e(this.d);
                    }
                    b();
                } finally {
                }
            }
        }
    }

    private String b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    private void b() {
        if (this.f == AGCRoutePolicy.UNKNOWN) {
            if (this.d != null) {
                this.f = Utils.getRoutePolicyFromJson(this.d.getString("/region", null), this.d.getString("/agcgw/url", null));
            } else {
                Log.w("AGConnectServiceConfig", "get route fail , config not ready");
            }
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return "DEFAULT_INSTANCE";
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        Log.d("AGC_ConfigImpl", "getRoutePolicy");
        if (this.f == null) {
            this.f = AGCRoutePolicy.UNKNOWN;
        }
        AGCRoutePolicy aGCRoutePolicy = this.f;
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy == aGCRoutePolicy2 && this.d == null) {
            a();
        }
        AGCRoutePolicy aGCRoutePolicy3 = this.f;
        return aGCRoutePolicy3 == null ? aGCRoutePolicy2 : aGCRoutePolicy3;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("path must not be null.");
        }
        if (this.d == null) {
            a();
        }
        String strA = a(str);
        String str3 = this.g.get(strA);
        if (str3 != null) {
            return str3;
        }
        String strB = b(strA);
        if (strB != null) {
            return strB;
        }
        String string = this.d.getString(strA, str2);
        return e.a(string) ? this.h.decrypt(string, str2) : string;
    }
}
