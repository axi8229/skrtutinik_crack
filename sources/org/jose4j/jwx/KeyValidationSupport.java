package org.jose4j.jwx;

import java.security.Key;
import java.security.interfaces.RSAKey;
import org.jose4j.lang.InvalidKeyException;

/* loaded from: classes4.dex */
public class KeyValidationSupport {
    public static void checkRsaKeySize(Key key) throws InvalidKeyException {
        int iBitLength;
        if (key == null) {
            throw new InvalidKeyException("The RSA key must not be null.");
        }
        if (!(key instanceof RSAKey) || (iBitLength = ((RSAKey) key).getModulus().bitLength()) >= 2048) {
            return;
        }
        throw new InvalidKeyException("An RSA key of size 2048 bits or larger MUST be used with the all JOSE RSA algorithms (given key was only " + iBitLength + " bits).");
    }
}
