package ru.yoomoney.sdk.kassa.payments.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManagerFactory;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\fH\u0002J\f\u0010\u0015\u001a\u00020\f*\u00020\fH\u0002¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/utils/WebTrustManagerImpl;", "Lru/yoomoney/sdk/kassa/payments/utils/WebTrustManager;", "()V", "checkCertificate", "", "context", "Landroid/content/Context;", "error", "Landroid/net/http/SslError;", "fromBase64String", "Ljava/io/InputStream;", "base64cert", "", "fromPem", "pem", "getPemAsString", "contex", "certName", "initTrustStore", "Ljavax/net/ssl/TrustManagerFactory;", "readPemCert", "pemKeyContent", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebTrustManagerImpl implements WebTrustManager {
    public static final int $stable = 0;

    private final InputStream fromBase64String(String base64cert) {
        return new ByteArrayInputStream(Base64.decode(base64cert, 2));
    }

    private final InputStream fromPem(String pem) {
        return fromBase64String(pemKeyContent(pem));
    }

    private final String getPemAsString(Context contex, String certName) throws Resources.NotFoundException {
        InputStream inputStreamOpenRawResource = contex.getResources().openRawResource(contex.getResources().getIdentifier(certName, "raw", contex.getPackageName()));
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        byte[] bytes = ByteStreamsKt.readBytes(inputStreamOpenRawResource);
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        Intrinsics.checkNotNullExpressionValue(ISO_8859_1, "ISO_8859_1");
        return new String(bytes, ISO_8859_1);
    }

    private final TrustManagerFactory initTrustStore(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Intrinsics.checkNotNullExpressionValue(certificateFactory, "getInstance(...)");
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"ym_root_ca", "ym_sub_ca"});
        List list = listListOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(readPemCert(context, (String) it.next()));
        }
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            InputStream inputStream = (InputStream) obj;
            try {
                Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(inputStream);
                CloseableKt.closeFinally(inputStream, null);
                keyStore.setCertificateEntry((String) listListOf.get(i), certificateGenerateCertificate);
                i = i2;
            } finally {
            }
        }
        Intrinsics.checkNotNullExpressionValue(keyStore, "apply(...)");
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        Intrinsics.checkNotNull(trustManagerFactory);
        return trustManagerFactory;
    }

    private final String pemKeyContent(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "\\s+", "", false, 4, (Object) null), "\n", "", false, 4, (Object) null), "-----BEGIN PUBLIC KEY-----", "", false, 4, (Object) null), "-----END PUBLIC KEY-----", "", false, 4, (Object) null), "-----BEGIN CERTIFICATE-----", "", false, 4, (Object) null), "-----END CERTIFICATE-----", "", false, 4, (Object) null);
    }

    private final InputStream readPemCert(Context contex, String certName) {
        return fromPem(StringsKt.trimIndent(getPemAsString(contex, certName)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        kotlin.Result.m2628constructorimpl(kotlin.Unit.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        r8 = kotlin.Result.INSTANCE;
        kotlin.Result.m2628constructorimpl(kotlin.ResultKt.createFailure(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0071, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return r0;
     */
    @Override // ru.yoomoney.sdk.kassa.payments.utils.WebTrustManager
    @android.annotation.SuppressLint({"DiscouragedPrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkCertificate(android.content.Context r7, android.net.http.SslError r8) {
        /*
            r6 = this;
            r0 = 1
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "error"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            int r1 = r8.getPrimaryError()
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L14
            return r3
        L14:
            android.net.http.SslCertificate r8 = r8.getCertificate()
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5a
            java.lang.Class r1 = r8.getClass()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r2 = "mX509Certificate"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r2 = "getDeclaredField(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Throwable -> L5a
            r1.setAccessible(r0)     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r8 = r1.get(r8)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r1 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r1)     // Catch: java.lang.Throwable -> L5a
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch: java.lang.Throwable -> L5a
            java.security.cert.X509Certificate[] r8 = new java.security.cert.X509Certificate[]{r8}     // Catch: java.lang.Throwable -> L5a
            javax.net.ssl.TrustManagerFactory r7 = r6.initTrustStore(r7)     // Catch: java.lang.Throwable -> L5a
            javax.net.ssl.TrustManager[] r7 = r7.getTrustManagers()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r1 = "getTrustManagers(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)     // Catch: java.lang.Throwable -> L5a
            int r1 = r7.length     // Catch: java.lang.Throwable -> L5a
            r2 = r3
        L4a:
            if (r2 >= r1) goto L5e
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L5a
            boolean r5 = r4 instanceof javax.net.ssl.X509TrustManager     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L5c
            javax.net.ssl.X509TrustManager r4 = (javax.net.ssl.X509TrustManager) r4     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = "generic"
            r4.checkServerTrusted(r8, r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            goto L5f
        L5a:
            r7 = move-exception
            goto L67
        L5c:
            int r2 = r2 + r0
            goto L4a
        L5e:
            r0 = r3
        L5f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L65
            kotlin.Result.m2628constructorimpl(r7)     // Catch: java.lang.Throwable -> L65
            goto L71
        L65:
            r7 = move-exception
            r3 = r0
        L67:
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            kotlin.Result.m2628constructorimpl(r7)
            r0 = r3
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.utils.WebTrustManagerImpl.checkCertificate(android.content.Context, android.net.http.SslError):boolean");
    }
}
