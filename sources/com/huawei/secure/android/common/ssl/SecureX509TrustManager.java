package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes3.dex */
public class SecureX509TrustManager implements X509TrustManager {
    protected List<X509TrustManager> a = new ArrayList();
    private X509Certificate[] b;

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.c("SX509TM", "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e) {
                e.b("SX509TM", "checkServerTrusted CertificateException" + e.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        e.c("SX509TM", "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int length = x509CertificateArr.length;
        for (int i = 0; i < length; i++) {
            X509Certificate x509Certificate = x509CertificateArr[i];
            e.a("SX509TM", "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            e.a("SX509TM", "IssuerDN :" + x509Certificate.getIssuerDN());
            e.a("SX509TM", "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                e.c("SX509TM", "check server i=" + i2);
                X509TrustManager x509TrustManager = this.a.get(i2);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    e.c("SX509TM", "client root ca size=" + acceptedIssuers.length);
                    for (int i3 = 0; i3 < acceptedIssuers.length; i3++) {
                        e.a("SX509TM", "client root ca getIssuerDN :" + acceptedIssuers[i3].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                e.c("SX509TM", "checkServerTrusted end, " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e) {
                e.b("SX509TM", "checkServerTrusted error :" + e.getMessage() + " , time : " + i2);
                if (i2 == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        e.b("SX509TM", "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e;
                }
            }
        }
        e.a("SX509TM", "checkServerTrusted: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e) {
            e.b("SX509TM", "getAcceptedIssuers exception : " + e.getMessage());
            return new X509Certificate[0];
        }
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.b = x509CertificateArr;
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IOException, IllegalArgumentException {
        a(inputStream, str);
    }

    private void a(InputStream inputStream, String str) throws IOException {
        if (inputStream != null && str != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                    KeyStore keyStore = KeyStore.getInstance("bks");
                    keyStore.load(inputStream, str.toCharArray());
                    trustManagerFactory.init(keyStore);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    for (TrustManager trustManager : trustManagers) {
                        if (trustManager instanceof X509TrustManager) {
                            this.a.add((X509TrustManager) trustManager);
                        }
                    }
                    d.a(inputStream);
                } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                    e.b("SX509TM", "loadInputStream: exception : " + e.getMessage());
                }
                e.a("SX509TM", "loadInputStream: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                return;
            } finally {
                d.a(inputStream);
            }
        }
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }
}
