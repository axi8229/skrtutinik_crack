package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* loaded from: classes3.dex */
public class g {
    public static volatile X509Certificate a;

    public static X509Certificate a(Context context, String str) throws IOException, UcsException {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return x509Certificate;
            } finally {
            }
        } catch (IOException | CertificateException e) {
            String strA = e.a(e, f.a("Read root cert error "));
            throw h.a("CertVerifier", strA, new Object[0], 1012L, strA);
        }
    }

    public static X509Certificate a(String str) throws IOException, UcsException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(StringUtil.base64Decode(str, 0));
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
                byteArrayInputStream.close();
                return x509Certificate;
            } finally {
            }
        } catch (IOException | CertificateException e) {
            throw new UcsException(1012L, e.getMessage());
        }
    }

    public static void a(Context context, v vVar) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, UcsException, CertificateException, NoSuchProviderException {
        int i;
        if (a == null) {
            synchronized (g.class) {
                try {
                    if (a == null) {
                        a = a(context, "cbg_root.cer");
                    }
                } finally {
                }
            }
        }
        String[] strArr = vVar.a.b;
        if (strArr == null || strArr.length == 0) {
            throw new UcsException(1012L, "verify cert chain failed , certs is empty..");
        }
        int length = strArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            x509CertificateArr[i2] = a(strArr[i2]);
        }
        StringBuilder sbA = f.a("Start verify cert chain using root ca: ");
        sbA.append(a.getSubjectDN().getName());
        LogUcs.i("CertVerifier", sbA.toString(), new Object[0]);
        int i3 = 0;
        while (true) {
            i = length - 1;
            if (i3 >= i) {
                break;
            }
            try {
                LogUcs.i("CertVerifier", "verify cert " + x509CertificateArr[i3].getSubjectDN().getName(), new Object[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("using ");
                int i4 = i3 + 1;
                sb.append(x509CertificateArr[i4].getSubjectDN().getName());
                LogUcs.i("CertVerifier", sb.toString(), new Object[0]);
                x509CertificateArr[i3].checkValidity();
                x509CertificateArr[i3].verify(x509CertificateArr[i4].getPublicKey());
                i3 = i4;
            } catch (RuntimeException e) {
                e = e;
                String strA = e.a(e, f.a("verify cert chain failed , exception "));
                throw h.a("CertVerifier", strA, new Object[0], 1012L, strA);
            } catch (InvalidKeyException e2) {
                e = e2;
                String strA2 = e.a(e, f.a("verify cert chain failed , exception "));
                throw h.a("CertVerifier", strA2, new Object[0], 1012L, strA2);
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                String strA22 = e.a(e, f.a("verify cert chain failed , exception "));
                throw h.a("CertVerifier", strA22, new Object[0], 1012L, strA22);
            } catch (NoSuchProviderException e4) {
                e = e4;
                String strA222 = e.a(e, f.a("verify cert chain failed , exception "));
                throw h.a("CertVerifier", strA222, new Object[0], 1012L, strA222);
            } catch (SignatureException e5) {
                e = e5;
                String strA2222 = e.a(e, f.a("verify cert chain failed , exception "));
                throw h.a("CertVerifier", strA2222, new Object[0], 1012L, strA2222);
            } catch (CertificateException e6) {
                e = e6;
                String strA22222 = e.a(e, f.a("verify cert chain failed , exception "));
                throw h.a("CertVerifier", strA22222, new Object[0], 1012L, strA22222);
            }
        }
        x509CertificateArr[i].verify(a.getPublicKey());
        for (String str : x509CertificateArr[0].getSubjectDN().getName().split(",")) {
            if (str.startsWith("OU=") && "Huawei CBG Cloud Security Signer".equals(str.substring(3))) {
                X509Certificate x509Certificate = x509CertificateArr[0];
                try {
                    Signature signature = Signature.getInstance("RS256".equals(vVar.a.a) ? "SHA256WithRSA" : "SHA256WithRSA/PSS");
                    signature.initVerify(x509Certificate.getPublicKey());
                    signature.update(vVar.d.getBytes(StandardCharsets.UTF_8));
                    if (signature.verify(vVar.c)) {
                        return;
                    } else {
                        throw new UcsException(1012L, "signature not verify");
                    }
                } catch (RuntimeException e7) {
                    e = e7;
                    String strA3 = e.a(e, f.a("verify signature of c1 failed, exception "));
                    throw h.a("CertVerifier", strA3, new Object[0], 1012L, strA3);
                } catch (InvalidKeyException e8) {
                    e = e8;
                    String strA32 = e.a(e, f.a("verify signature of c1 failed, exception "));
                    throw h.a("CertVerifier", strA32, new Object[0], 1012L, strA32);
                } catch (NoSuchAlgorithmException e9) {
                    e = e9;
                    String strA322 = e.a(e, f.a("verify signature of c1 failed, exception "));
                    throw h.a("CertVerifier", strA322, new Object[0], 1012L, strA322);
                } catch (SignatureException e10) {
                    e = e10;
                    String strA3222 = e.a(e, f.a("verify signature of c1 failed, exception "));
                    throw h.a("CertVerifier", strA3222, new Object[0], 1012L, strA3222);
                }
            }
        }
        throw new UcsException(1012L, "Subject OU not verify");
    }
}
