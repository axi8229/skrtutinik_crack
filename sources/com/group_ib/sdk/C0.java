package com.group_ib.sdk;

import android.os.Build;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* loaded from: classes3.dex */
public abstract class C0 {
    public static boolean a = false;

    public static void a(HttpsURLConnection httpsURLConnection) throws IOException {
        try {
            InputStream errorStream = httpsURLConnection.getErrorStream();
            if (errorStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream), 256);
                while (bufferedReader.readLine() != null) {
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
            c1.a(1, 1, "ConnectionHelper", "failed to read error from " + httpsURLConnection.getURL() + ": " + e.getMessage());
        }
    }

    public static boolean b(HttpsURLConnection httpsURLConnection) {
        if (Build.VERSION.SDK_INT < 26 && !a) {
            c1.a(4, 4, "ConnectionHelper", "SSL pinning check is unavailable for current Android OS");
            a = true;
        }
        return true;
    }

    public static void a(HttpsURLConnection httpsURLConnection, boolean z) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext;
        if (z) {
            sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new C0634z0()}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new A0());
        } else {
            String str = T.a;
            sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
        }
        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
    }
}
