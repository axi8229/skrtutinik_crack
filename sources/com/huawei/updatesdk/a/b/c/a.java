package com.huawei.updatesdk.a.b.c;

import com.huawei.updatesdk.service.appmgr.bean.d;
import com.huawei.updatesdk.service.appmgr.bean.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {
    private static final Map<String, Class> a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put(d.APIMETHOD, e.class);
        map.put(com.huawei.updatesdk.service.appmgr.bean.a.APIMETHOD, com.huawei.updatesdk.service.appmgr.bean.b.class);
    }

    public static com.huawei.updatesdk.a.b.c.c.d a(String str) throws InstantiationException {
        Class cls = a.get(str);
        if (cls != null) {
            return (com.huawei.updatesdk.a.b.c.c.d) cls.newInstance();
        }
        throw new InstantiationException("ResponseBean class not found, method:" + str);
    }
}
