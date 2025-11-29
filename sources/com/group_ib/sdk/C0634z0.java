package com.group_ib.sdk;

import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.group_ib.sdk.z0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0634z0 implements X509TrustManager {
    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateNotYetValidException, CertificateExpiredException {
        try {
            x509CertificateArr[0].checkValidity();
        } catch (Exception unused) {
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateNotYetValidException, CertificateExpiredException {
        try {
            x509CertificateArr[0].checkValidity();
        } catch (Exception unused) {
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
