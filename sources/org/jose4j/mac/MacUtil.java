package org.jose4j.mac;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Mac;
import org.jose4j.lang.JoseException;

/* loaded from: classes4.dex */
public class MacUtil {
    public static Mac getInitializedMac(String str, Key key, String str2) throws InvalidKeyException, JoseException {
        Mac mac = getMac(str, str2);
        initMacWithKey(mac, key);
        return mac;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v7, types: [javax.crypto.Mac] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static Mac getMac(String str, String str2) throws JoseException {
        try {
            str = str2 == null ? Mac.getInstance(str) : Mac.getInstance(str, str2);
            return str;
        } catch (NoSuchAlgorithmException e) {
            throw new JoseException("Unable to get a MAC implementation of algorithm name: " + str, e);
        } catch (NoSuchProviderException e2) {
            throw new JoseException("Unable to get a MAC implementation of algorithm name: " + str + " using provider " + str2, e2);
        }
    }

    public static void initMacWithKey(Mac mac, Key key) throws org.jose4j.lang.InvalidKeyException, InvalidKeyException {
        try {
            mac.init(key);
        } catch (InvalidKeyException e) {
            throw new org.jose4j.lang.InvalidKeyException("Key is not valid for " + mac.getAlgorithm() + " - " + e, e);
        }
    }
}
