package sberid.sdk.auth.network.tsl;

import android.content.res.Resources;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sberid.sdk.auth.R$raw;

/* compiled from: X509TrustManagerProvider.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u001b\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroid/content/res/Resources;", "resources", "", "isAddSystemCertification", "Ljavax/net/ssl/X509TrustManager;", "createTrustManagers", "(Landroid/content/res/Resources;Z)Ljavax/net/ssl/X509TrustManager;", "Ljava/security/KeyStore;", "createKeyStoreForTlsPinning", "(Landroid/content/res/Resources;Z)Ljava/security/KeyStore;", "Ljava/security/cert/CertificateFactory;", "createCertificateFactoryInternal", "()Ljava/security/cert/CertificateFactory;", "createKeyStoreInternal", "()Ljava/security/KeyStore;", "certificateFactory", "keyStore", "res", "", "resId", "", "loadCertificateIntoKeyStore", "(Ljava/security/cert/CertificateFactory;Ljava/security/KeyStore;Landroid/content/res/Resources;I)V", "addSystemCertification", "(Ljava/security/KeyStore;)Ljava/security/KeyStore;", "Ljava/io/Closeable;", "closeable", "close", "(Ljava/io/Closeable;)V", "", "CA_CERTIFICATE", "Ljava/util/List;", "SberIdSDK_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class X509TrustManagerProviderKt {
    private static final List<Integer> CA_CERTIFICATE = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R$raw.sberca_ext_web), Integer.valueOf(R$raw.sberca_root_ext), Integer.valueOf(R$raw.sberca_test_ext), Integer.valueOf(R$raw.sberca_test_root_ext), Integer.valueOf(R$raw.rusca_sub_rsa2022), Integer.valueOf(R$raw.rusca_root_rsa2022), Integer.valueOf(R$raw.actalis_root_ca), Integer.valueOf(R$raw.actalis_webclickstream), Integer.valueOf(R$raw.id_sber_ru)});

    public static final X509TrustManager createTrustManagers(Resources resources, boolean z) throws NoSuchAlgorithmException, KeyStoreException {
        Intrinsics.checkNotNullParameter(resources, "resources");
        try {
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(createKeyStoreForTlsPinning(resources, z));
            Intrinsics.checkNotNullExpressionValue(tmf, "tmf");
            TrustManager trustManager = tmf.getTrustManagers()[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        } catch (KeyStoreException e) {
            Log.e("TrustManager", "Factory is always created: ", e);
            return null;
        } catch (NoSuchAlgorithmException e2) {
            Log.e("TrustManager", "Default algorithm of TrustManagerFactory and TLS protocol are supported by every Android device:", e2);
            return null;
        } catch (Exception e3) {
            Log.e("TrustManager", "Create Trust Manager: ", e3);
            return null;
        }
    }

    private static final KeyStore createKeyStoreForTlsPinning(Resources resources, boolean z) throws Exception {
        CertificateFactory certificateFactoryCreateCertificateFactoryInternal = createCertificateFactoryInternal();
        KeyStore keyStoreCreateKeyStoreInternal = createKeyStoreInternal();
        Iterator<Integer> it = CA_CERTIFICATE.iterator();
        while (it.hasNext()) {
            loadCertificateIntoKeyStore(certificateFactoryCreateCertificateFactoryInternal, keyStoreCreateKeyStoreInternal, resources, it.next().intValue());
        }
        return !z ? keyStoreCreateKeyStoreInternal : addSystemCertification(keyStoreCreateKeyStoreInternal);
    }

    private static final CertificateFactory createCertificateFactoryInternal() throws Exception {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Intrinsics.checkNotNullExpressionValue(certificateFactory, "CertificateFactory.getInstance(CERTIFICATE_FORMAT)");
            return certificateFactory;
        } catch (CertificateException e) {
            throw new Exception("X.509 is supported everywhere", e);
        }
    }

    private static final KeyStore createKeyStoreInternal() throws Exception {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            Intrinsics.checkNotNullExpressionValue(keyStore, "KeyStore.getInstance(Key…oad(null, null)\n        }");
            return keyStore;
        } catch (IOException e) {
            throw new Exception("There must be no error with this KeyStore's format", e);
        } catch (KeyStoreException e2) {
            throw new Exception("KeyStore with default type can be always created", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new Exception("KeyStore is empty now, there is no need for integrity checking algorithm", e3);
        } catch (CertificateException e4) {
            throw new Exception("There are no certificates in KeyStore, so no exception may be thrown", e4);
        }
    }

    private static final void loadCertificateIntoKeyStore(CertificateFactory certificateFactory, KeyStore keyStore, Resources resources, int i) throws IOException {
        InputStream inputStreamOpenRawResource = null;
        try {
            try {
                inputStreamOpenRawResource = resources.openRawResource(i);
                keyStore.setCertificateEntry(resources.getResourceName(i), certificateFactory.generateCertificate(inputStreamOpenRawResource));
            } catch (KeyStoreException e) {
                throw new Exception("KeyStore is inited already, aliases aren't repeated certainly", e);
            } catch (CertificateException e2) {
                throw new Exception("Certificate is certainly valid", e2);
            }
        } finally {
            close(inputStreamOpenRawResource);
        }
    }

    private static final KeyStore addSystemCertification(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManager[] trustManagers;
        boolean z;
        int i;
        try {
            TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            factory.init((KeyStore) null);
            Intrinsics.checkNotNullExpressionValue(factory, "factory");
            trustManagers = factory.getTrustManagers();
            Intrinsics.checkNotNull(trustManagers);
            z = true;
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                z = false;
            }
        } catch (KeyStoreException e) {
            Log.e("TrustManager", "Factory is always created", e);
        } catch (NoSuchAlgorithmException e2) {
            Log.e("TrustManager", "Default algorithm of TrustManagerFactory and TLS protocol are supported by every Android device", e2);
        }
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected default trust managers: ");
            String string = Arrays.toString(trustManagers);
            Intrinsics.checkNotNullExpressionValue(string, "java.util.Arrays.toString(this)");
            sb.append(string);
            throw new IllegalStateException(sb.toString().toString());
        }
        TrustManager trustManager = trustManagers[0];
        if (trustManager == null) {
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        X509Certificate[] acceptedIssuers = ((X509TrustManager) trustManager).getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "(trustManagers[0] as X50…tManager).acceptedIssuers");
        int length = acceptedIssuers.length;
        for (i = 0; i < length; i++) {
            keyStore.setCertificateEntry("item_" + i, acceptedIssuers[i]);
        }
        return keyStore;
    }

    private static final void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e("TrustManager", "IOException thrown while closing Closeable.", e);
            }
        }
    }
}
