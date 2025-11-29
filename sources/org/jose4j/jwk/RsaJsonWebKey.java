package org.jose4j.jwk;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;
import org.jose4j.keys.RsaKeyUtil;
import org.jose4j.lang.JoseException;

/* loaded from: classes4.dex */
public class RsaJsonWebKey extends PublicJsonWebKey {
    public RsaJsonWebKey(Map<String, Object> map) throws JoseException {
        this(map, null);
    }

    public RsaJsonWebKey(Map<String, Object> map, String str) throws JoseException {
        super(map, str);
        BigInteger bigIntFromBase64UrlEncodedParam = getBigIntFromBase64UrlEncodedParam(map, "n", true);
        BigInteger bigIntFromBase64UrlEncodedParam2 = getBigIntFromBase64UrlEncodedParam(map, "e", true);
        RsaKeyUtil rsaKeyUtil = new RsaKeyUtil(str, null);
        this.key = rsaKeyUtil.publicKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam2);
        checkForBareKeyCertMismatch();
        if (map.containsKey("d")) {
            BigInteger bigIntFromBase64UrlEncodedParam3 = getBigIntFromBase64UrlEncodedParam(map, "d", false);
            if (map.containsKey("p")) {
                this.privateKey = rsaKeyUtil.privateKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam2, bigIntFromBase64UrlEncodedParam3, getBigIntFromBase64UrlEncodedParam(map, "p", false), getBigIntFromBase64UrlEncodedParam(map, "q", false), getBigIntFromBase64UrlEncodedParam(map, "dp", false), getBigIntFromBase64UrlEncodedParam(map, "dq", false), getBigIntFromBase64UrlEncodedParam(map, "qi", false));
            } else {
                this.privateKey = rsaKeyUtil.privateKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam3);
            }
        }
        removeFromOtherParams("n", "e", "d", "p", "q", "dp", "dq", "qi");
    }

    @Override // org.jose4j.jwk.JsonWebKey
    public String getKeyType() {
        return "RSA";
    }

    public RSAPublicKey getRsaPublicKey() {
        return (RSAPublicKey) this.key;
    }

    public RSAPrivateKey getRsaPrivateKey() {
        return (RSAPrivateKey) this.privateKey;
    }

    @Override // org.jose4j.jwk.PublicJsonWebKey
    protected void fillPublicTypeSpecificParams(Map<String, Object> map) {
        RSAPublicKey rsaPublicKey = getRsaPublicKey();
        putBigIntAsBase64UrlEncodedParam(map, "n", rsaPublicKey.getModulus());
        putBigIntAsBase64UrlEncodedParam(map, "e", rsaPublicKey.getPublicExponent());
    }

    @Override // org.jose4j.jwk.PublicJsonWebKey
    protected void fillPrivateTypeSpecificParams(Map<String, Object> map) {
        RSAPrivateKey rsaPrivateKey = getRsaPrivateKey();
        if (rsaPrivateKey != null) {
            putBigIntAsBase64UrlEncodedParam(map, "d", rsaPrivateKey.getPrivateExponent());
            if (rsaPrivateKey instanceof RSAPrivateCrtKey) {
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) rsaPrivateKey;
                putBigIntAsBase64UrlEncodedParam(map, "p", rSAPrivateCrtKey.getPrimeP());
                putBigIntAsBase64UrlEncodedParam(map, "q", rSAPrivateCrtKey.getPrimeQ());
                putBigIntAsBase64UrlEncodedParam(map, "dp", rSAPrivateCrtKey.getPrimeExponentP());
                putBigIntAsBase64UrlEncodedParam(map, "dq", rSAPrivateCrtKey.getPrimeExponentQ());
                putBigIntAsBase64UrlEncodedParam(map, "qi", rSAPrivateCrtKey.getCrtCoefficient());
            }
        }
    }
}
