package com.yandex.metrica.impl.ob;

import android.content.Context;

/* renamed from: com.yandex.metrica.impl.ob.yd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1388yd {
    private InterfaceC1340wd a;

    public C1388yd(InterfaceC1340wd interfaceC1340wd) {
        this.a = interfaceC1340wd;
    }

    public void a(InterfaceC1340wd interfaceC1340wd) {
        this.a = interfaceC1340wd;
    }

    public boolean b(Context context) {
        if (this.a.a("android.permission.READ_PHONE_STATE")) {
            return C1316vd.a(context, "android.permission.READ_PHONE_STATE");
        }
        return false;
    }

    public boolean c(Context context) {
        if (this.a.a("android.permission.ACCESS_WIFI_STATE")) {
            return C1316vd.a(context, "android.permission.ACCESS_WIFI_STATE");
        }
        return false;
    }

    public boolean a(Context context) {
        if (this.a.a("android.permission.ACCESS_COARSE_LOCATION")) {
            return C1316vd.a(context, "android.permission.ACCESS_COARSE_LOCATION");
        }
        return false;
    }
}
