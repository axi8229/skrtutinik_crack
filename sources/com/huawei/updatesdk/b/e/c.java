package com.huawei.updatesdk.b.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class c extends a {
    private static String a;

    private String b(List<String> list) {
        String strGenVerifiedPackageName = null;
        try {
            Context contextA = com.huawei.updatesdk.a.b.a.a.c().a();
            ServiceVerifyKit.Builder builder = new ServiceVerifyKit.Builder();
            builder.setContext(contextA).setTargetComponent(new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId"), ServiceVerifyKit.Builder.ComponentType.ACTIVITY);
            if (!com.huawei.updatesdk.b.h.d.a(list) && list.size() < 2) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String strC = com.huawei.updatesdk.b.h.b.c(contextA, it.next());
                    if (!TextUtils.isEmpty(strC)) {
                        arrayList.add(strC);
                    }
                }
                if (!com.huawei.updatesdk.b.h.d.a(arrayList)) {
                    builder.setPreferredPkgs(arrayList);
                }
            }
            com.huawei.updatesdk.b.c.c cVarA = com.huawei.updatesdk.b.c.b.a();
            Iterator<String> it2 = cVarA.g().iterator();
            while (it2.hasNext()) {
                builder.addLegacyInfo(cVarA.a(), it2.next());
            }
            strGenVerifiedPackageName = builder.genVerifiedPackageName();
            com.huawei.updatesdk.a.a.a.b("DefaultTaskInit", "UpdateSDK get market packagename from verify kit is: " + strGenVerifiedPackageName);
            return strGenVerifiedPackageName;
        } catch (Throwable th) {
            com.huawei.updatesdk.a.a.a.c("DefaultTaskInit", "UpdateSDK genVerifiedPackageName error: " + th.toString());
            return strGenVerifiedPackageName;
        }
    }

    private void e() {
        String str;
        com.huawei.updatesdk.a.b.c.c.c.c(a(com.huawei.updatesdk.a.b.a.a.c().a()));
        com.huawei.updatesdk.a.b.c.c.d dVarC = new com.huawei.updatesdk.a.b.c.b(new com.huawei.updatesdk.service.appmgr.bean.a(null), null).c();
        if (dVarC.f()) {
            com.huawei.updatesdk.service.appmgr.bean.b bVar = (com.huawei.updatesdk.service.appmgr.bean.b) dVarC;
            if (bVar.g() != null) {
                a = bVar.g().d();
                str = "getPackageName from store: " + a;
            } else {
                str = "getPackageName from store: error" + bVar.toString();
            }
            com.huawei.updatesdk.a.a.a.b("DefaultTaskInit", str);
        }
    }

    @Override // com.huawei.updatesdk.b.e.a
    String a() {
        return "com.huawei.updatesdk";
    }

    @Override // com.huawei.updatesdk.b.e.a
    String a(Context context) {
        return com.huawei.updatesdk.b.h.c.d(context, "upsdk_store_url");
    }

    @Override // com.huawei.updatesdk.b.e.a
    public void a(String str) {
        com.huawei.updatesdk.a.a.a.b("DefaultTaskInit", "resetMarketPkgName: " + str);
        a = str;
    }

    @Override // com.huawei.updatesdk.b.e.a
    public void a(List<String> list) {
        if (TextUtils.isEmpty(a)) {
            String strB = b(list);
            a = strB;
            if (TextUtils.isEmpty(strB)) {
                e();
            }
            com.huawei.updatesdk.a.a.a.b("DefaultTaskInit", "UpdateSDK genVerifiedPackageName is: " + a);
        }
    }

    @Override // com.huawei.updatesdk.b.e.a
    public String b() {
        return a;
    }
}
