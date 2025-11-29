package com.huawei.appgallery.serviceverifykit.b;

import com.huawei.appgallery.serviceverifykit.d.d.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class a {
    private List<com.huawei.appgallery.serviceverifykit.a.a> b(List<com.huawei.appgallery.serviceverifykit.a.a> list) {
        ArrayList arrayList = new ArrayList();
        int iB = 0;
        for (com.huawei.appgallery.serviceverifykit.a.a aVar : list) {
            if (aVar.b() > iB) {
                arrayList.clear();
                iB = aVar.b();
            } else if (aVar.b() != iB) {
                b.b.b("OptimizationCenter", "condition Low level");
            }
            arrayList.add(aVar);
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    private List<com.huawei.appgallery.serviceverifykit.a.a> c(List<com.huawei.appgallery.serviceverifykit.a.a> list) {
        ArrayList arrayList = new ArrayList();
        for (com.huawei.appgallery.serviceverifykit.a.a aVar : list) {
            if (aVar.a() == 0) {
                arrayList.add(aVar);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    private List<com.huawei.appgallery.serviceverifykit.a.a> d(List<com.huawei.appgallery.serviceverifykit.a.a> list) {
        ArrayList arrayList = new ArrayList();
        for (com.huawei.appgallery.serviceverifykit.a.a aVar : list) {
            if (aVar.c() == 1) {
                arrayList.add(aVar);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    private List<com.huawei.appgallery.serviceverifykit.a.a> e(List<com.huawei.appgallery.serviceverifykit.a.a> list) {
        ArrayList arrayList = new ArrayList();
        for (com.huawei.appgallery.serviceverifykit.a.a aVar : list) {
            if (aVar.d() > -1) {
                arrayList.add(aVar);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    public String a(List<com.huawei.appgallery.serviceverifykit.a.a> list) {
        List<com.huawei.appgallery.serviceverifykit.a.a> listB = b(c(d(e(list))));
        String strE = "";
        if (listB.size() > 0) {
            int iF = 0;
            for (com.huawei.appgallery.serviceverifykit.a.a aVar : listB) {
                if (aVar.f() >= iF) {
                    iF = aVar.f();
                    strE = aVar.e();
                }
            }
        }
        return strE;
    }
}
