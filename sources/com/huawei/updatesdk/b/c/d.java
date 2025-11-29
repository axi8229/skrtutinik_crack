package com.huawei.updatesdk.b.c;

import com.huawei.hms.jos.JosConstant;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class d extends c {
    @Override // com.huawei.updatesdk.b.c.c
    public String a() {
        return JosConstant.APP_MARKET_PACKAGE;
    }

    @Override // com.huawei.updatesdk.b.c.c
    public int b() {
        return 0;
    }

    @Override // com.huawei.updatesdk.b.c.c
    String c() {
        return com.huawei.updatesdk.a.a.d.h.c.a("ro.product.manufacturer", "");
    }

    @Override // com.huawei.updatesdk.b.c.c
    String d() {
        return com.huawei.updatesdk.a.a.d.h.c.a("ro.product.hw_model", "");
    }

    @Override // com.huawei.updatesdk.b.c.c
    public List<String> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F");
        arrayList.add("FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212");
        return arrayList;
    }
}
