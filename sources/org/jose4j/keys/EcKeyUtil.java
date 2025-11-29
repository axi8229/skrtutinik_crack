package org.jose4j.keys;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import org.jose4j.lang.JoseException;

/* loaded from: classes4.dex */
public class EcKeyUtil extends KeyPairUtil {
    @Override // org.jose4j.keys.KeyPairUtil
    public /* bridge */ /* synthetic */ boolean isAvailable() {
        return super.isAvailable();
    }

    public EcKeyUtil() {
        this(null, null);
    }

    public EcKeyUtil(String str, SecureRandom secureRandom) {
        super(str, secureRandom);
    }

    @Override // org.jose4j.keys.KeyPairUtil
    String getAlgorithm() {
        return "EC";
    }

    public ECPublicKey publicKey(BigInteger bigInteger, BigInteger bigInteger2, ECParameterSpec eCParameterSpec) throws JoseException {
        try {
            return (ECPublicKey) getKeyFactory().generatePublic(new ECPublicKeySpec(new ECPoint(bigInteger, bigInteger2), eCParameterSpec));
        } catch (InvalidKeySpecException e) {
            throw new JoseException("Invalid key spec: " + e, e);
        }
    }

    public ECPrivateKey privateKey(BigInteger bigInteger, ECParameterSpec eCParameterSpec) throws JoseException {
        try {
            return (ECPrivateKey) getKeyFactory().generatePrivate(new ECPrivateKeySpec(bigInteger, eCParameterSpec));
        } catch (InvalidKeySpecException e) {
            throw new JoseException("Invalid key spec: " + e, e);
        }
    }
}
