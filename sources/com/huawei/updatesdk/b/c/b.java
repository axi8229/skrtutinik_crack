package com.huawei.updatesdk.b.c;

import android.app.UiModeManager;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {
    private static final Map<Integer, Class<? extends c>> a;
    private static c b;
    private static int c;

    static {
        HashMap map = new HashMap();
        a = map;
        c = -1;
        map.put(3, a.class);
        map.put(1, e.class);
        map.put(2, f.class);
        map.put(0, d.class);
    }

    private static int a(Context context) {
        if (c(context)) {
            return 1;
        }
        if (d(context)) {
            return 2;
        }
        return b(context) ? 3 : 0;
    }

    public static c a() {
        c cVar = b;
        if (cVar != null) {
            return cVar;
        }
        Context contextA = com.huawei.updatesdk.a.b.a.a.c().a();
        if (c < 0) {
            c = a(contextA);
        }
        com.huawei.updatesdk.a.a.a.b("DeviceImplFactory", "deviceType: " + c);
        Class<? extends c> cls = a.get(Integer.valueOf(c));
        if (cls == null) {
            d dVar = new d();
            b = dVar;
            return dVar;
        }
        try {
            b = cls.newInstance();
        } catch (Throwable unused) {
            b = new d();
            com.huawei.updatesdk.a.a.a.a("DeviceImplFactory", "createDeviceInfo error and create default phone deviceinfo");
        }
        return b;
    }

    private static boolean b(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    private static boolean c(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        com.huawei.updatesdk.a.a.a.b("DeviceImplFactory", "UI mode: " + uiModeManager.getCurrentModeType());
        return uiModeManager.getCurrentModeType() == 4;
    }

    private static boolean d(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }
}
