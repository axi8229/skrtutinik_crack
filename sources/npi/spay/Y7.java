package npi.spay;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Y7 implements InterfaceC1997vk {
    public final SSLContext a;
    public final TrustManager[] b;
    public final X509TrustManager c;
    public final HostnameVerifier d;

    public Y7() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        e();
        this.b = f();
        this.c = g();
        this.a = h();
        this.d = d();
    }

    public static final boolean a(String str, SSLSession sSLSession) {
        return true;
    }

    public static void e() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        String defaultType = KeyStore.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType()");
        KeyStore keyStore = KeyStore.getInstance(defaultType);
        keyStore.load(null, null);
        Intrinsics.checkNotNullExpressionValue(keyStore, "keyStore");
    }

    public static TrustManager[] f() {
        return new TrustManager[]{new X7()};
    }

    @Override // npi.spay.InterfaceC1997vk
    public final X509TrustManager a() {
        return this.c;
    }

    @Override // npi.spay.InterfaceC1997vk
    public final HostnameVerifier b() {
        return this.d;
    }

    @Override // npi.spay.InterfaceC1997vk
    public final SSLContext c() {
        return this.a;
    }

    public final HostnameVerifier d() {
        return new HostnameVerifier() { // from class: npi.spay.Y7$$ExternalSyntheticLambda0
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return Y7.a(str, sSLSession);
            }
        };
    }

    public final X509TrustManager g() {
        TrustManager trustManager = this.b[0];
        Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        return (X509TrustManager) trustManager;
    }

    public final SSLContext h() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, this.b, null);
        Intrinsics.checkNotNullExpressionValue(sslContext, "sslContext");
        return sslContext;
    }
}
