package npi.spay;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CertificatePinner;
import spay.sdk.domain.model.response.SPaySdkConfig;

/* renamed from: npi.spay.qi, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1871qi implements InterfaceC1997vk {
    public final InterfaceC1728l0 a;
    public SSLContext b;
    public TrustManager[] c;
    public C1496bh d;
    public HostnameVerifier e;

    public C1871qi(InterfaceC1728l0 sPaySdkConfigRepository) {
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        this.a = sPaySdkConfigRepository;
    }

    @Override // npi.spay.InterfaceC1997vk
    public final X509TrustManager a() {
        C1496bh c1496bh = this.d;
        if (c1496bh != null) {
            return c1496bh;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customX509TrustManager");
        return null;
    }

    @Override // npi.spay.InterfaceC1997vk
    public final HostnameVerifier b() {
        HostnameVerifier hostnameVerifier = this.e;
        if (hostnameVerifier != null) {
            return hostnameVerifier;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hostnameVerifier");
        return null;
    }

    @Override // npi.spay.InterfaceC1997vk
    public final SSLContext c() {
        SSLContext sSLContext = this.b;
        if (sSLContext != null) {
            return sSLContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customSSLContext");
        return null;
    }

    public final HostnameVerifier d() {
        final ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf("gate1.spaymentsplus.ru", "cms-res.online.sberbank.ru", "cms-res-web.online.sberbank.ru", "psi.gate1.spaymentsplus.ru", "ift.gate1.spaymentsplus.ru", "test.stat.online.sberbank.ru", "ecomtest.sberbank.ru", "ift.gate2.spaymentsplus.ru", "platichastyami.ru", "iftmpclickstream.testonline.sberbank.ru", "psiclickstream.testonline.sberbank.ru", "ext.clickstream.sberbank.ru");
        SPaySdkConfig sPaySdkConfig = ((O0) this.a).c;
        if (sPaySdkConfig == null) {
            throw C1808o5.a;
        }
        final ArrayList<String> sslPins = sPaySdkConfig.getSslPins();
        if (sslPins == null) {
            sslPins = new ArrayList<>();
        }
        return new HostnameVerifier() { // from class: npi.spay.qi$$ExternalSyntheticLambda0
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return C1871qi.a(arrayListArrayListOf, this, sslPins, str, sSLSession);
            }
        };
    }

    public static final boolean a(ArrayList trustedHostsList, C1871qi this$0, ArrayList trustedPins, String str, SSLSession sSLSession) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(trustedHostsList, "$trustedHostsList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(trustedPins, "$trustedPins");
        if (!trustedHostsList.contains(str)) {
            return false;
        }
        Certificate[] peerCertificates = sSLSession.getPeerCertificates();
        Intrinsics.checkNotNullExpressionValue(peerCertificates, "session.peerCertificates");
        for (Certificate certificate : peerCertificates) {
            Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate receiver = (X509Certificate) certificate;
            this$0.getClass();
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (trustedPins.contains("sha256/" + CertificatePinner.INSTANCE.sha256Hash(receiver).base64())) {
                return true;
            }
        }
        return false;
    }
}
