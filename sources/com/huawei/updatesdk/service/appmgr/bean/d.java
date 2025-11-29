package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.updatesdk.a.a.d.h.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class d extends com.huawei.updatesdk.b.b.c {
    public static final String APIMETHOD = "client.updateCheck";
    public static final int DEFAULT_UPGRADE_RESULT = 0;
    public static final int FULL_UPGRADE_RESULT = 1;
    public static final int INSTALL_CHECK_DEFAULT = 0;
    private String agVersion_;
    private com.huawei.updatesdk.a.a.d.h.b deviceSpecParams_;
    private int getSafeGame_;
    private int gmsSupport_;

    @SDKNetTransmission
    private int hardwareType;
    private int installCheck_;
    private int isFullUpgrade_;

    @SDKNetTransmission
    private int isUpdateSdk;

    @SDKNetTransmission
    private String locale;
    private int mapleVer_;
    private String packageName_;
    private a pkgInfo_;
    private String serviceCountry_;

    @SDKNetTransmission
    private int serviceType;
    private int supportMaple_;
    private int versionCode_;
    private String version_;

    public static class a extends com.huawei.updatesdk.a.b.c.c.b {
        private List<Param> params_;

        public void a(List<Param> list) {
            this.params_ = list;
        }
    }

    public d() {
        this.serviceType = 0;
        this.isUpdateSdk = 1;
        this.installCheck_ = 0;
        this.isFullUpgrade_ = 0;
        this.getSafeGame_ = 1;
        this.supportMaple_ = 0;
        this.locale = null;
        Context contextA = com.huawei.updatesdk.a.b.a.a.c().a();
        a(APIMETHOD);
        b("1.2");
        this.locale = com.huawei.updatesdk.a.a.d.h.c.h();
        g(com.huawei.updatesdk.a.a.d.h.c.h(contextA));
        f(com.huawei.updatesdk.a.a.d.h.c.g(contextA));
        a(com.huawei.updatesdk.a.a.d.h.c.i(contextA) ? 1 : 0);
        e(com.huawei.updatesdk.a.b.a.a.c().a().getPackageName());
        f(com.huawei.updatesdk.b.b.a.d().a());
        e(com.huawei.updatesdk.a.a.d.h.c.d().a());
        c(com.huawei.updatesdk.a.a.d.h.c.d().b());
        this.deviceSpecParams_ = new b.C0103b(contextA).a(true).a();
        this.hardwareType = com.huawei.updatesdk.b.c.b.a().b();
    }

    public d(List<Param> list) {
        this();
        a aVar = new a();
        aVar.a(list);
        a(aVar);
    }

    public static d a(List<PackageInfo> list) {
        d dVar = new d();
        a aVar = new a();
        dVar.a(aVar);
        ArrayList arrayList = new ArrayList();
        aVar.a(arrayList);
        Iterator<PackageInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Param(it.next()));
        }
        return dVar;
    }

    public void a(int i) {
        this.gmsSupport_ = i;
    }

    public void a(a aVar) {
        this.pkgInfo_ = aVar;
    }

    public void b(int i) {
        this.installCheck_ = i;
    }

    public void c(int i) {
        this.mapleVer_ = i;
    }

    public void d(int i) {
        this.serviceType = i;
    }

    public void d(String str) {
        this.agVersion_ = str;
    }

    public void e(int i) {
        this.supportMaple_ = i;
    }

    public void e(String str) {
        this.packageName_ = str;
    }

    public void f(int i) {
        this.versionCode_ = i;
    }

    public void f(String str) {
        this.serviceCountry_ = str;
    }

    public void g(String str) {
        this.version_ = str;
    }
}
