package org.jose4j.keys;

import java.io.ByteArrayInputStream;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.jose4j.base64url.Base64;
import org.jose4j.lang.JoseException;

/* loaded from: classes4.dex */
public class X509Util {
    private CertificateFactory certFactory;

    public X509Util() {
        try {
            this.certFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            throw new IllegalStateException("Couldn't find X.509 CertificateFactory!?!", e);
        }
    }

    public X509Util(String str) throws NoSuchProviderException {
        try {
            this.certFactory = CertificateFactory.getInstance("X.509", str);
        } catch (CertificateException e) {
            throw new IllegalStateException("Couldn't find X.509 CertificateFactory!?!", e);
        }
    }

    public static X509Util getX509Util(String str) throws JoseException {
        if (str == null) {
            return new X509Util();
        }
        try {
            return new X509Util(str);
        } catch (NoSuchProviderException e) {
            throw new JoseException("Provider " + str + " not found when creating X509Util.", e);
        }
    }

    public String toBase64(X509Certificate x509Certificate) {
        try {
            return Base64.encode(x509Certificate.getEncoded());
        } catch (CertificateEncodingException e) {
            throw new IllegalStateException("Unexpected problem getting encoded certificate.", e);
        }
    }

    public X509Certificate fromBase64Der(String str) throws JoseException {
        try {
            return (X509Certificate) this.certFactory.generateCertificate(new ByteArrayInputStream(Base64.decode(str)));
        } catch (CertificateException e) {
            throw new JoseException("Unable to convert " + str + " value to X509Certificate: " + e, e);
        }
    }
}
