package com.huawei.updatesdk.b.e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.updatesdk.service.otaupdate.f;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public abstract class a {
    private String a(Context context, String str) {
        String strSynGetGrsUrl;
        try {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            grsBaseInfo.setSerCountry(str);
            strSynGetGrsUrl = new GrsClient(context, grsBaseInfo).synGetGrsUrl(a(), "ROOT");
        } catch (Throwable th) {
            com.huawei.updatesdk.a.a.a.c("AbstractTaskInit", "UpdateSDK Get url from GRS_SDK error: " + th.toString());
            strSynGetGrsUrl = null;
        }
        if (TextUtils.isEmpty(strSynGetGrsUrl)) {
            com.huawei.updatesdk.a.a.a.b("AbstractTaskInit", "UpdateSDK Get url is default url");
            return a(context);
        }
        com.huawei.updatesdk.a.a.a.b("AbstractTaskInit", "UpdateSDK Get url from GRS_SDK Success!" + b(strSynGetGrsUrl));
        return strSynGetGrsUrl;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.substring(0, str.indexOf(46));
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.c.a.a.a.b("AbstractTaskInit", e.toString());
            return null;
        }
    }

    private boolean b(Context context, String str) {
        if (!com.huawei.updatesdk.b.h.b.a(context, str, d())) {
            return false;
        }
        if (Math.abs(System.currentTimeMillis() - com.huawei.updatesdk.b.b.a.d().b(str)) >= 86400000) {
            return true;
        }
        f.e().a(com.huawei.updatesdk.b.b.a.d().a(str));
        return false;
    }

    abstract String a();

    abstract String a(Context context);

    public void a(String str) {
    }

    public abstract void a(List<String> list);

    public abstract String b();

    public String b(Context context) {
        String strA = f.e().a();
        if (!TextUtils.isEmpty(strA)) {
            return a(context, strA);
        }
        com.huawei.updatesdk.a.a.a.b("AbstractTaskInit", "UpdateSDK accoutZone is empty, so url is default");
        return a(context);
    }

    public void c() throws ExecutionException, InterruptedException, TimeoutException {
        Context contextA = com.huawei.updatesdk.a.b.a.a.c().a();
        String strB = b();
        if (b(contextA, strB)) {
            d dVar = new d(String.format(Locale.ROOT, "content://%s.commondata/item/1", strB), strB);
            dVar.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
            try {
                dVar.get(1000L, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                com.huawei.updatesdk.a.a.a.a("AbstractTaskInit", "init AccountZone error: " + e.toString());
            }
        }
    }

    public boolean d() {
        return false;
    }
}
