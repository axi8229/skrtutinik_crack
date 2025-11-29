package com.huawei.appgallery.serviceverifykit.d;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class c {
    private static String a(String str, String str2) {
        int iIndexOf = str.toUpperCase(Locale.getDefault()).indexOf(str2 + ContainerUtils.KEY_VALUE_DELIMITER);
        if (iIndexOf == -1) {
            return null;
        }
        int iIndexOf2 = str.indexOf(",", iIndexOf);
        int length = iIndexOf + str2.length() + 1;
        return iIndexOf2 != -1 ? str.substring(length, iIndexOf2) : str.substring(length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003a A[EXC_TOP_SPLITTER, PHI: r6
  0x003a: PHI (r6v11 java.io.InputStream) = (r6v23 java.io.InputStream), (r6v24 java.io.InputStream), (r6v25 java.io.InputStream) binds: [B:16:0x0038, B:22:0x0048, B:25:0x0051] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.cert.X509Certificate a(android.content.Context r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "close stream failed"
            java.lang.String r1 = "X509CertUtil"
            r2 = 0
            android.content.res.Resources r6 = r6.getResources()     // Catch: java.lang.Throwable -> L2b java.security.cert.CertificateException -> L30 java.io.IOException -> L3e android.content.res.Resources.NotFoundException -> L49
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch: java.lang.Throwable -> L2b java.security.cert.CertificateException -> L30 java.io.IOException -> L3e android.content.res.Resources.NotFoundException -> L49
            java.lang.String r3 = "ag_sdk_cbg_root.cer"
            java.io.InputStream r6 = r6.open(r3)     // Catch: java.lang.Throwable -> L2b java.security.cert.CertificateException -> L30 java.io.IOException -> L3e android.content.res.Resources.NotFoundException -> L49
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch: java.lang.Throwable -> L29 java.security.cert.CertificateException -> L31 java.io.IOException -> L3f android.content.res.Resources.NotFoundException -> L4a
            java.security.cert.Certificate r3 = r3.generateCertificate(r6)     // Catch: java.lang.Throwable -> L29 java.security.cert.CertificateException -> L31 java.io.IOException -> L3f android.content.res.Resources.NotFoundException -> L4a
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch: java.lang.Throwable -> L29 java.security.cert.CertificateException -> L31 java.io.IOException -> L3f android.content.res.Resources.NotFoundException -> L4a
            if (r6 == 0) goto L27
            r6.close()     // Catch: java.io.IOException -> L25
            goto L27
        L25:
            r2 = r3
            goto L54
        L27:
            r2 = r3
            goto L59
        L29:
            r2 = move-exception
            goto L5a
        L2b:
            r6 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
            goto L5a
        L30:
            r6 = r2
        L31:
            com.huawei.appgallery.serviceverifykit.d.d.b r3 = com.huawei.appgallery.serviceverifykit.d.d.b.b     // Catch: java.lang.Throwable -> L29
            java.lang.String r4 = "CertificateException"
            r3.a(r1, r4)     // Catch: java.lang.Throwable -> L29
            if (r6 == 0) goto L59
        L3a:
            r6.close()     // Catch: java.io.IOException -> L54
            goto L59
        L3e:
            r6 = r2
        L3f:
            com.huawei.appgallery.serviceverifykit.d.d.b r3 = com.huawei.appgallery.serviceverifykit.d.d.b.b     // Catch: java.lang.Throwable -> L29
            java.lang.String r4 = "can not open cbg root cer"
            r3.a(r1, r4)     // Catch: java.lang.Throwable -> L29
            if (r6 == 0) goto L59
            goto L3a
        L49:
            r6 = r2
        L4a:
            com.huawei.appgallery.serviceverifykit.d.d.b r3 = com.huawei.appgallery.serviceverifykit.d.d.b.b     // Catch: java.lang.Throwable -> L29
            java.lang.String r4 = "can not found cbg root cer"
            r3.a(r1, r4)     // Catch: java.lang.Throwable -> L29
            if (r6 == 0) goto L59
            goto L3a
        L54:
            com.huawei.appgallery.serviceverifykit.d.d.b r6 = com.huawei.appgallery.serviceverifykit.d.d.b.b
            r6.a(r1, r0)
        L59:
            return r2
        L5a:
            if (r6 == 0) goto L65
            r6.close()     // Catch: java.io.IOException -> L60
            goto L65
        L60:
            com.huawei.appgallery.serviceverifykit.d.d.b r6 = com.huawei.appgallery.serviceverifykit.d.d.b.b
            r6.a(r1, r0)
        L65:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appgallery.serviceverifykit.d.c.a(android.content.Context):java.security.cert.X509Certificate");
    }

    private static X509Certificate a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(a.a(str));
    }

    private static X509Certificate a(byte[] bArr) throws CertificateException {
        if (bArr != null && bArr.length != 0) {
            try {
                Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
                if (certificateGenerateCertificate instanceof X509Certificate) {
                    return (X509Certificate) certificateGenerateCertificate;
                }
            } catch (CertificateException e) {
                com.huawei.appgallery.serviceverifykit.d.d.b.b.a("X509CertUtil", "Failed to get cert: " + e.getMessage());
            }
        }
        return null;
    }

    private static boolean a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        return a(x509Certificate, "CN", str);
    }

    private static boolean a(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(a(x509Certificate.getSubjectDN().getName(), str));
    }

    public static boolean a(X509Certificate x509Certificate, List<X509Certificate> list) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (list != null && list.size() != 0) {
            if (x509Certificate == null) {
                com.huawei.appgallery.serviceverifykit.d.d.b.b.a("X509CertUtil", "rootCert is null,verify failed ");
                return false;
            }
            try {
                x509Certificate.checkValidity();
                PublicKey publicKey = x509Certificate.getPublicKey();
                for (int size = list.size() - 1; size >= 0; size--) {
                    X509Certificate x509Certificate2 = list.get(size);
                    if (x509Certificate2 != null) {
                        try {
                            x509Certificate2.verify(publicKey);
                            x509Certificate2.checkValidity();
                            publicKey = x509Certificate2.getPublicKey();
                        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                            com.huawei.appgallery.serviceverifykit.d.d.b.b.a("X509CertUtil", "verify failed " + e.getMessage());
                        }
                    }
                    return false;
                }
                return a(list);
            } catch (CertificateExpiredException | CertificateNotYetValidException e2) {
                com.huawei.appgallery.serviceverifykit.d.d.b.b.a("X509CertUtil", "verifyCertChain Exception:" + e2.getMessage());
            }
        }
        return false;
    }

    public static boolean a(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (x509Certificate == null || bArr == null || bArr2 == null || bArr2.length == 0) {
            com.huawei.appgallery.serviceverifykit.d.d.b.b.c("X509CertUtil", "checkSignature parameter is null");
            return false;
        }
        try {
            Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
            signature.initVerify(x509Certificate.getPublicKey());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            com.huawei.appgallery.serviceverifykit.d.d.b.b.a("X509CertUtil", "failed checkSignature,Exception:", e);
            return false;
        }
    }

    private static boolean a(List<X509Certificate> list) {
        for (int i = 1; i < list.size(); i++) {
            if (!a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<X509Certificate> b(String str) {
        return b(c(str));
    }

    private static List<X509Certificate> b(List<String> list) {
        if (list == null) {
            com.huawei.appgallery.serviceverifykit.d.d.b.b.c("X509CertUtil", "base64 CertChain is null.");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            X509Certificate x509CertificateA = a(it.next());
            if (x509CertificateA == null) {
                com.huawei.appgallery.serviceverifykit.d.d.b.b.a("X509CertUtil", "Failed to get cert from CertChain");
            } else {
                arrayList.add(x509CertificateA);
            }
        }
        return arrayList;
    }

    public static boolean b(X509Certificate x509Certificate, String str) {
        return a(x509Certificate, "OU", str);
    }

    private static List<String> c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException e) {
            com.huawei.appgallery.serviceverifykit.d.d.b.b.a("X509CertUtil", "Failed to getCertChain: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
