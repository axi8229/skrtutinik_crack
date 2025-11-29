package com.huawei.updatesdk.b.b;

import android.content.Context;
import android.os.Build;
import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;

/* loaded from: classes3.dex */
public class c extends com.huawei.updatesdk.a.b.c.c.c {

    @SDKNetTransmission
    private String brand;

    @SDKNetTransmission
    private String buildNumber;

    @SDKNetTransmission
    private String density;

    @SDKNetTransmission
    private int emuiApiLevel;

    @SDKNetTransmission
    private String firmwareVersion;

    @SDKNetTransmission
    private String manufacturer;

    @SDKNetTransmission
    private String phoneType;

    @SDKNetTransmission
    private String resolution;

    @SDKNetTransmission
    private long ts;

    public c() {
        this.emuiApiLevel = 0;
        Context contextA = com.huawei.updatesdk.a.b.a.a.c().a();
        this.ts = System.currentTimeMillis();
        this.firmwareVersion = Build.VERSION.RELEASE.trim();
        this.buildNumber = com.huawei.updatesdk.a.a.d.h.c.c();
        com.huawei.updatesdk.b.c.c cVarA = com.huawei.updatesdk.b.c.b.a();
        this.phoneType = cVarA.f();
        this.density = com.huawei.updatesdk.a.a.d.h.c.f(contextA);
        this.resolution = com.huawei.updatesdk.a.a.d.h.c.e(contextA);
        this.emuiApiLevel = com.huawei.updatesdk.b.h.a.d().a();
        this.manufacturer = cVarA.e();
        this.brand = com.huawei.updatesdk.a.a.d.h.c.c;
    }

    public String toString() {
        return getClass().getName() + " {\n\tmethod_: " + b() + "\n}";
    }
}
