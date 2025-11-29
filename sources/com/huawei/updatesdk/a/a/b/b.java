package com.huawei.updatesdk.a.a.b;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.updatesdk.a.a.d.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class b {
    private HttpURLConnection a = null;

    public static class a {
        private String a;
        private int b;

        public int a() {
            return this.b;
        }

        public String b() {
            return this.a;
        }
    }

    public static HttpsURLConnection a(String str, Context context) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setSSLSocketFactory(SecureSSLSocketFactory.getInstance(context));
        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        return httpsURLConnection;
    }

    private byte[] a(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream = null;
        dataOutputStream = null;
        dataOutputStream = null;
        dataOutputStream = null;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        DataOutputStream dataOutputStream2 = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, bArr.length));
                        try {
                            int length = bArr.length;
                            dataOutputStream2.write(bArr, 0, length);
                            dataOutputStream2.flush();
                            dataOutputStream2.close();
                            dataOutputStream = length;
                        } catch (IOException e) {
                            e = e;
                            dataOutputStream = dataOutputStream2;
                            com.huawei.updatesdk.a.a.c.a.a.a.a("HttpsUtil", "gzip error!", e);
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                                dataOutputStream = dataOutputStream;
                            }
                            return byteArrayOutputStream.toByteArray();
                        } catch (Throwable th) {
                            th = th;
                            dataOutputStream = dataOutputStream2;
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e2) {
                                    com.huawei.updatesdk.a.a.c.a.a.a.a("HttpsUtil", "gzip error!", e2);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
                byteArrayOutputStream = null;
            }
        } catch (IOException e5) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("HttpsUtil", "gzip error!", e5);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public a a(String str, String str2, String str3, String str4, Context context) throws Throwable {
        Throwable th;
        DataOutputStream dataOutputStream;
        a aVar = new a();
        BufferedInputStream bufferedInputStream = null;
        try {
            HttpsURLConnection httpsURLConnectionA = a(str, context);
            this.a = httpsURLConnectionA;
            httpsURLConnectionA.setDoInput(true);
            this.a.setDoOutput(true);
            this.a.setUseCaches(false);
            this.a.setConnectTimeout(5000);
            this.a.setReadTimeout(10000);
            this.a.setRequestMethod("POST");
            this.a.setRequestProperty("Content-Type", "application/x-gzip");
            this.a.setRequestProperty("Content-Encoding", "gzip");
            this.a.setRequestProperty("Connection", "Keep-Alive");
            this.a.setRequestProperty("User-Agent", str4);
            dataOutputStream = new DataOutputStream(this.a.getOutputStream());
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = null;
        }
        try {
            dataOutputStream.write(a(str2.getBytes(str3)));
            dataOutputStream.flush();
            int responseCode = this.a.getResponseCode();
            aVar.b = responseCode;
            bufferedInputStream = responseCode == 200 ? new BufferedInputStream(this.a.getInputStream()) : new BufferedInputStream(this.a.getErrorStream());
            com.huawei.updatesdk.a.a.d.b bVar = new com.huawei.updatesdk.a.a.d.b();
            byte[] bArrA = com.huawei.updatesdk.a.a.b.a.b().a();
            while (true) {
                int i = bufferedInputStream.read(bArrA);
                if (i == -1) {
                    break;
                }
                bVar.a(bArrA, i);
            }
            com.huawei.updatesdk.a.a.b.a.b().a(bArrA);
            aVar.a = bVar.a();
            HttpURLConnection httpURLConnection = this.a;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            d.a(dataOutputStream);
            d.a(bufferedInputStream);
            return aVar;
        } catch (Throwable th3) {
            th = th3;
            HttpURLConnection httpURLConnection2 = this.a;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            d.a(dataOutputStream);
            d.a(bufferedInputStream);
            throw th;
        }
    }

    public void a() {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
