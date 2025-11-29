package com.huawei.updatesdk.b.h;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a {
    private static final Map<Integer, String> b;
    private static a c;
    private int a;

    static {
        HashMap map = new HashMap();
        b = map;
        c = new a();
        map.put(1, "1.0");
        map.put(2, "1.5");
        map.put(3, "1.6");
        map.put(4, "2.0");
        map.put(5, "2.0");
        map.put(6, "2.3");
        map.put(7, "3.0");
        map.put(8, "3.0.5");
        map.put(8, "3.1");
        map.put(9, "4.0");
        map.put(10, "4.1");
        map.put(11, "5.0");
        map.put(12, "5.1");
    }

    private a() {
        this.a = 0;
        int iC = c();
        this.a = iC;
        if (iC == 0) {
            this.a = b();
        }
        com.huawei.updatesdk.a.a.c.a.a.a.a("EMUISupportUtil", "emuiVersion:" + this.a);
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length == 2) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    private int b() {
        String strA = a(com.huawei.updatesdk.a.a.d.h.c.a("ro.build.version.emui", ""));
        if (TextUtils.isEmpty(strA)) {
            return 0;
        }
        for (Map.Entry<Integer, String> entry : b.entrySet()) {
            if (strA.equals(entry.getValue())) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    private int c() {
        return com.huawei.updatesdk.a.a.d.h.c.a("ro.build.hw_emui_api_level", 0);
    }

    public static a d() {
        return c;
    }

    public int a() {
        return this.a;
    }
}
