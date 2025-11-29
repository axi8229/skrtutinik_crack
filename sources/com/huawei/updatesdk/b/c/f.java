package com.huawei.updatesdk.b.c;

import android.os.Build;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class f extends c {
    @Override // com.huawei.updatesdk.b.c.c
    public String a() {
        return "com.huawei.appmarketwear";
    }

    @Override // com.huawei.updatesdk.b.c.c
    public int b() {
        return 2;
    }

    @Override // com.huawei.updatesdk.b.c.c
    String c() {
        return com.huawei.updatesdk.a.a.d.h.c.a("ro.product.manufacturer", "");
    }

    @Override // com.huawei.updatesdk.b.c.c
    String d() {
        return com.huawei.updatesdk.a.a.d.h.e.a() ? Build.PRODUCT : "";
    }

    @Override // com.huawei.updatesdk.b.c.c
    public List<String> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("CE1EF7188F820973C191227D95D54311ED3A65EC83E37009E898A1C058BBC775");
        return arrayList;
    }
}
