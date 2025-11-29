package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.core.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class b extends AGConnectInstance {
    private static List<Service> a;
    private static final Map<String, AGConnectInstance> b = new HashMap();
    private static String c;
    private final AGConnectOptions d;
    private final d e;
    private final d f;

    public b(AGConnectOptions aGConnectOptions) throws SecurityException {
        Log.d("AGC_Instance", "AGConnectInstanceImpl init");
        this.d = aGConnectOptions;
        if (a == null) {
            Log.e("AGC_Instance", "please call `initialize()` first");
        }
        this.e = new d(a, aGConnectOptions.getContext());
        d dVar = new d(null, aGConnectOptions.getContext());
        this.f = dVar;
        if (aGConnectOptions instanceof com.huawei.agconnect.config.impl.b) {
            dVar.a(((com.huawei.agconnect.config.impl.b) aGConnectOptions).a(), aGConnectOptions.getContext());
        }
        Log.d("AGC_Instance", "AGConnectInstanceImpl init end");
    }

    public static AGConnectInstance a() {
        String str = c;
        if (str == null) {
            str = "DEFAULT_INSTANCE";
        }
        return a(str);
    }

    public static AGConnectInstance a(AGConnectOptions aGConnectOptions) {
        return a(aGConnectOptions, false);
    }

    private static synchronized AGConnectInstance a(AGConnectOptions aGConnectOptions, boolean z) {
        AGConnectInstance bVar;
        Map<String, AGConnectInstance> map = b;
        bVar = map.get(aGConnectOptions.getIdentifier());
        if (bVar == null || z) {
            bVar = new b(aGConnectOptions);
            map.put(aGConnectOptions.getIdentifier(), bVar);
        }
        return bVar;
    }

    public static synchronized AGConnectInstance a(String str) {
        AGConnectInstance aGConnectInstance;
        try {
            aGConnectInstance = b.get(str);
            if (aGConnectInstance == null) {
                if ("DEFAULT_INSTANCE".equals(str)) {
                    Log.w("AGC_Instance", "please call `initialize()` first");
                } else {
                    Log.w("AGC_Instance", "not find instance for : " + str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return aGConnectInstance;
    }

    public static synchronized void a(Context context) {
        Log.w("AGC_Instance", "agc sdk initialize");
        if (b.size() > 0) {
            Log.w("AGC_Instance", "Repeated invoking initialize");
        } else {
            a(context, AGConnectServicesConfig.fromContext(context));
        }
    }

    private static synchronized void a(Context context, AGConnectOptions aGConnectOptions) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                Log.w("AGC_Instance", "context.getApplicationContext null");
            } else {
                context = applicationContext;
            }
            b();
            if (a == null) {
                a = new c(context).a();
            }
            a(aGConnectOptions, true);
            c = aGConnectOptions.getIdentifier();
            Log.i("AGC_Instance", "initFinish callback start");
            a.a();
            Log.i("AGC_Instance", "AGC SDK initialize end");
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void b() {
        JsonProcessingFactory.registerProcessor("/agcgw/url", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.1
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE";
                } else {
                    if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                        return null;
                    }
                    str = "/agcgw_all/SG";
                }
                return aGConnectOptions.getString(str);
            }
        });
        JsonProcessingFactory.registerProcessor("/agcgw/backurl", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.2
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE_back";
                } else {
                    if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                        return null;
                    }
                    str = "/agcgw_all/SG_back";
                }
                return aGConnectOptions.getString(str);
            }
        });
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public Context getContext() {
        return this.d.getContext();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public AGConnectOptions getOptions() {
        return this.d;
    }
}
