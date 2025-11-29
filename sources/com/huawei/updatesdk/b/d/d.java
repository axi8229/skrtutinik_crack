package com.huawei.updatesdk.b.d;

import android.text.TextUtils;
import java.io.File;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public class d {
    private static volatile d a;

    public static synchronized d a() {
        try {
            if (a == null) {
                a = new d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }

    public static String b() {
        String strB = com.huawei.updatesdk.a.b.a.a.c().b();
        if (TextUtils.isEmpty(strB)) {
            return "";
        }
        String str = strB + "/updatesdk";
        File file = new File(str);
        return (file.exists() || file.mkdirs()) ? str : "";
    }

    public HttpsURLConnection a(String str) {
        HttpsURLConnection httpsURLConnectionA = com.huawei.updatesdk.a.a.b.b.a(str, com.huawei.updatesdk.a.b.a.a.c().a());
        httpsURLConnectionA.setConnectTimeout(7000);
        httpsURLConnectionA.setReadTimeout(10000);
        httpsURLConnectionA.setUseCaches(false);
        httpsURLConnectionA.setDoInput(true);
        httpsURLConnectionA.setRequestProperty("Accept-Encoding", "identity");
        httpsURLConnectionA.setInstanceFollowRedirects(true);
        return httpsURLConnectionA;
    }
}
