package org.jose4j.keys;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Set;
import org.jose4j.lang.JoseException;

/* loaded from: classes4.dex */
abstract class KeyPairUtil {
    protected String provider;
    protected SecureRandom secureRandom;

    abstract String getAlgorithm();

    protected KeyPairUtil(String str, SecureRandom secureRandom) {
        this.provider = str;
        this.secureRandom = secureRandom;
    }

    protected KeyFactory getKeyFactory() throws JoseException {
        String algorithm = getAlgorithm();
        try {
            String str = this.provider;
            return str == null ? KeyFactory.getInstance(algorithm) : KeyFactory.getInstance(algorithm, str);
        } catch (NoSuchAlgorithmException e) {
            throw new JoseException("Couldn't find " + algorithm + " KeyFactory! " + e, e);
        } catch (NoSuchProviderException e2) {
            throw new JoseException("Cannot get KeyFactory instance with provider " + this.provider, e2);
        }
    }

    public boolean isAvailable() {
        Set<String> algorithms = Security.getAlgorithms("KeyFactory");
        Set<String> algorithms2 = Security.getAlgorithms("KeyPairGenerator");
        String algorithm = getAlgorithm();
        return algorithms2.contains(algorithm) && algorithms.contains(algorithm);
    }
}
