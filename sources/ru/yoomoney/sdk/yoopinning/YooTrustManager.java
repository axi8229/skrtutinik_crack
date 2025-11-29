package ru.yoomoney.sdk.yoopinning;

import android.annotation.SuppressLint;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.CertificateEncodingException;
import javax.security.cert.CertificateException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.OkHostnameVerifier;
import org.jose4j.base64url.Base64;

/* compiled from: TrustManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ)\u0010\r\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fJ)\u0010\r\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\u001b\u0010\u0010\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0002\u0010\u0011J%\u0010\u0013\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u000b*\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/yoopinning/YooTrustManager;", "Ljavax/net/ssl/X509TrustManager;", "certRepository", "Lru/yoomoney/sdk/yoopinning/CertRepository;", "(Lru/yoomoney/sdk/yoopinning/CertRepository;)V", "checkClientTrusted", "", "chain", "", "Ljava/security/cert/X509Certificate;", "authType", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "host", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;Ljava/lang/String;)V", "containsInBlackList", "([Ljava/security/cert/X509Certificate;)V", "containsInWhiteList", "customCheckServer", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "thumbprint", "Companion", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"CustomX509TrustManager"})
/* loaded from: classes5.dex */
public final class YooTrustManager implements X509TrustManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CertRepository certRepository;

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public YooTrustManager(CertRepository certRepository) {
        Intrinsics.checkNotNullParameter(certRepository, "certRepository");
        this.certRepository = certRepository;
        certRepository.updateCertificates();
    }

    public final void checkServerTrusted(X509Certificate[] chain, String authType, String host) throws CertificateException, CertificateNotYetValidException, CertificateExpiredException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(authType, "authType");
        Intrinsics.checkNotNullParameter(host, "host");
        customCheckServer(chain, host);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException, CertificateNotYetValidException, CertificateExpiredException {
        X509Certificate[] x509CertificateArr;
        List listFilterNotNull;
        if (chain == null || (listFilterNotNull = ArraysKt.filterNotNull(chain)) == null || (x509CertificateArr = (X509Certificate[]) listFilterNotNull.toArray(new X509Certificate[0])) == null) {
            x509CertificateArr = new X509Certificate[0];
        }
        customCheckServer(x509CertificateArr, null);
    }

    private final void customCheckServer(X509Certificate[] chain, String host) throws CertificateException, CertificateNotYetValidException, CertificateExpiredException {
        containsInBlackList(chain);
        containsInWhiteList(chain);
        X509Certificate x509Certificate = (X509Certificate) ArraysKt.firstOrNull(chain);
        if (x509Certificate != null) {
            if (!x509Certificate.getExtendedKeyUsage().contains("1.3.6.1.5.5.7.3.1")) {
                throw new CertificateException("It isn't WEB OID");
            }
            if (host != null) {
                OkHostnameVerifier.INSTANCE.verify(host, x509Certificate);
            }
        }
        Iterator it = ArrayIteratorKt.iterator(chain);
        while (it.hasNext()) {
            ((X509Certificate) it.next()).checkValidity();
        }
    }

    private final void containsInBlackList(X509Certificate[] chain) throws CertificateException {
        List<String> blackList = this.certRepository.getCertificates().getValue().getBlackList();
        Iterator it = ArrayIteratorKt.iterator(chain);
        while (it.hasNext()) {
            if (CollectionsKt.contains(blackList, thumbprint((X509Certificate) it.next()))) {
                throw new CertificateException("Certificate in blackList");
            }
        }
    }

    private final void containsInWhiteList(X509Certificate[] chain) throws CertificateException {
        Object next;
        List<String> whiteList = this.certRepository.getCertificates().getValue().getWhiteList();
        Iterator it = ArraysKt.toList(chain).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (CollectionsKt.contains(whiteList, thumbprint((X509Certificate) next))) {
                    break;
                }
            }
        }
        if (((X509Certificate) next) == null) {
            throw new CertificateException("No one certificate in whiteList");
        }
    }

    private final String thumbprint(X509Certificate x509Certificate) throws CertificateEncodingException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
        messageDigest.update(x509Certificate.getEncoded());
        return Base64.encode(messageDigest.digest());
    }

    /* compiled from: TrustManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/yoopinning/YooTrustManager$Companion;", "", "()V", "SERVER_AUTH_OID", "", "getYooTrustManager", "Ljavax/net/ssl/X509TrustManager;", "certRepository", "Lru/yoomoney/sdk/yoopinning/CertRepository;", "getYooTrustManager$yoopinning_release", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final X509TrustManager getYooTrustManager$yoopinning_release(CertRepository certRepository) {
            Intrinsics.checkNotNullParameter(certRepository, "certRepository");
            return new YooTrustManager(certRepository);
        }
    }
}
