package com.yandex.metrica.networktasks.api;

import android.text.TextUtils;
import com.yandex.metrica.network.NetworkClient;
import com.yandex.metrica.network.Request;
import com.yandex.metrica.network.Response;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
class a {
    a() {
    }

    public Response a(String str, String str2, SSLSocketFactory sSLSocketFactory) {
        Request.Builder builderWithMethod = new Request.Builder(str2).withMethod("GET");
        if (!TextUtils.isEmpty(str)) {
            builderWithMethod.addHeader("If-None-Match", str);
        }
        NetworkClient.Builder builderWithSslSocketFactory = new NetworkClient.Builder().withInstanceFollowRedirects(true).withSslSocketFactory(sSLSocketFactory);
        int i = com.yandex.metrica.networktasks.impl.a.a;
        return builderWithSslSocketFactory.withConnectTimeout(i).withReadTimeout(i).build().newCall(builderWithMethod.build()).execute();
    }
}
