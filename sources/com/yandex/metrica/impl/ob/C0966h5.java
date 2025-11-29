package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.PackageManager;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.h5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0966h5 extends X4 {
    private final I1 b;
    private final C0819b8 c;
    private final C1108mn d;

    public C0966h5(L3 l3) {
        this(l3, l3.x(), F0.g().k(), new C1108mn());
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        String strA;
        L3 l3A = a();
        if (this.c.l()) {
            return false;
        }
        C0836c0 c0836c0E = l3A.m().P() ? C0836c0.e(c0836c0) : C0836c0.c(c0836c0);
        JSONObject jSONObject = new JSONObject();
        C1108mn c1108mn = this.d;
        Context contextG = l3A.g();
        String strB = l3A.e().b();
        c1108mn.getClass();
        JSONObject jSONObject2 = null;
        try {
            PackageManager packageManager = contextG.getPackageManager();
            strA = A2.a(30) ? C1133nn.a(packageManager, strB) : packageManager.getInstallerPackageName(strB);
        } catch (Throwable unused) {
            strA = null;
        }
        if (strA == null) {
            strA = "";
        }
        try {
            jSONObject.put("appInstaller", strA);
            C0900ee c0900eeB = this.b.b();
            if (c0900eeB.c) {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("trackingId", c0900eeB.a);
                    if (c0900eeB.b.length() > 0) {
                        jSONObject2.put("additionalParams", c0900eeB.b);
                    }
                } catch (Throwable unused2) {
                }
            }
            jSONObject.put("preloadInfo", jSONObject2);
        } catch (Throwable unused3) {
        }
        l3A.r().b(c0836c0E.f(jSONObject.toString()));
        this.c.b(true);
        return false;
    }

    C0966h5(L3 l3, C0819b8 c0819b8, I1 i1, C1108mn c1108mn) {
        super(l3);
        this.c = c0819b8;
        this.b = i1;
        this.d = c1108mn;
    }
}
