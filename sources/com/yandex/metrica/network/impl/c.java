package com.yandex.metrica.network.impl;

import com.yandex.metrica.network.Call;
import com.yandex.metrica.network.NetworkClient;
import com.yandex.metrica.network.Request;
import com.yandex.metrica.network.Response;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class c implements Call {
    private final NetworkClient a;
    private final Request b;
    private final d c;

    public c(NetworkClient client, Request request, d urlProvider) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(urlProvider, "urlProvider");
        this.a = client;
        this.b = request;
        this.c = urlProvider;
    }

    private final void a(HttpsURLConnection httpsURLConnection) throws ProtocolException {
        for (Map.Entry entry : this.b.getHeaders().entrySet()) {
            httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        Integer it = this.a.getReadTimeout();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            httpsURLConnection.setReadTimeout(it.intValue());
        }
        Integer it2 = this.a.getConnectTimeout();
        if (it2 != null) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            httpsURLConnection.setConnectTimeout(it2.intValue());
        }
        Boolean it3 = this.a.getUseCaches();
        if (it3 != null) {
            Intrinsics.checkNotNullExpressionValue(it3, "it");
            httpsURLConnection.setUseCaches(it3.booleanValue());
        }
        Boolean it4 = this.a.getInstanceFollowRedirects();
        if (it4 != null) {
            Intrinsics.checkNotNullExpressionValue(it4, "it");
            httpsURLConnection.setInstanceFollowRedirects(it4.booleanValue());
        }
        httpsURLConnection.setRequestMethod(this.b.getMethod());
        SSLSocketFactory sslSocketFactory = this.a.getSslSocketFactory();
        if (sslSocketFactory != null) {
            httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
        }
    }

    @Override // com.yandex.metrica.network.Call
    public Response execute() {
        Map<String, List<String>> headerFields;
        Throwable th;
        int responseCode;
        boolean z;
        Throwable th2;
        byte[] bArr;
        byte[] bArr2;
        int i;
        try {
            d dVar = this.c;
            String url = this.b.getUrl();
            dVar.getClass();
            URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpsURLConnection)) {
                uRLConnectionOpenConnection = null;
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
            if (httpsURLConnection == null) {
                return new Response(new IllegalArgumentException("Connection created for " + this.b.getUrl() + " does not represent https connection"));
            }
            byte[] bArrA = new byte[0];
            byte[] bArr3 = new byte[0];
            try {
                a(httpsURLConnection);
                if (Intrinsics.areEqual(this.b.getMethod(), "POST")) {
                    httpsURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpsURLConnection.getOutputStream();
                    if (outputStream != null) {
                        try {
                            outputStream.write(this.b.getBody());
                            outputStream.flush();
                            CloseableKt.closeFinally(outputStream, null);
                        } finally {
                        }
                    }
                }
                responseCode = httpsURLConnection.getResponseCode();
                try {
                    headerFields = httpsURLConnection.getHeaderFields();
                } catch (Throwable th3) {
                    headerFields = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                headerFields = null;
                th = th4;
                responseCode = 0;
                try {
                    httpsURLConnection.disconnect();
                } catch (Throwable unused) {
                }
                z = false;
                th2 = th;
                bArr = bArrA;
                bArr2 = bArr3;
                i = responseCode;
                return new Response(z, i, bArr, bArr2, headerFields, th2);
            }
            try {
                e eVar = e.a;
                bArrA = eVar.a(this.a.getMaxResponseSize(), new a(httpsURLConnection));
                byte[] bArrA2 = eVar.a(this.a.getMaxResponseSize(), new b(httpsURLConnection));
                try {
                    httpsURLConnection.disconnect();
                } catch (Throwable unused2) {
                }
                th2 = null;
                bArr = bArrA;
                bArr2 = bArrA2;
                i = responseCode;
                z = true;
            } catch (Throwable th5) {
                th = th5;
                httpsURLConnection.disconnect();
                z = false;
                th2 = th;
                bArr = bArrA;
                bArr2 = bArr3;
                i = responseCode;
                return new Response(z, i, bArr, bArr2, headerFields, th2);
            }
            return new Response(z, i, bArr, bArr2, headerFields, th2);
        } catch (Throwable th6) {
            return new Response(th6);
        }
    }
}
