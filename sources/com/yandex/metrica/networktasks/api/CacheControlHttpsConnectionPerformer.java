package com.yandex.metrica.networktasks.api;

import com.yandex.metrica.network.Response;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class CacheControlHttpsConnectionPerformer {
    private final a a;
    private final SSLSocketFactory b;

    public interface Client {
        String getOldETag();

        void onError();

        void onNotModified();

        void onResponse(String str, byte[] bArr);
    }

    CacheControlHttpsConnectionPerformer(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.a = aVar;
        this.b = sSLSocketFactory;
    }

    public CacheControlHttpsConnectionPerformer(SSLSocketFactory sSLSocketFactory) {
        this(new a(), sSLSocketFactory);
    }

    public void performConnection(String str, Client client) {
        Response responseA;
        int code;
        String str2;
        try {
            responseA = this.a.a(client.getOldETag(), str, this.b);
            code = responseA.getCode();
        } catch (Throwable unused) {
        }
        if (code != 200) {
            if (code != 304) {
                client.onError();
                return;
            } else {
                client.onNotModified();
                return;
            }
        }
        List list = (List) responseA.getHeaders().get("ETag");
        if (list == null || list.size() <= 0 || (str2 = (String) list.get(0)) == null) {
            str2 = "";
        }
        client.onResponse(str2, responseA.getResponseData());
    }
}
